import java.util.*;

public class Arrays {

    /*  Takes in an array [1,2,3,4,5,6] and targetSum = 7
        Raturns an array filled with ints that add
        up to the target sum ( [3,4] ).

    - Tachnique used:
        Go through each int and compute the potential match
        then look through HashMap to find if the pot match
        already exists, if yes then return, otherwise just
        put the number into the map and continue.
    */
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map <Integer, Boolean> nums = new HashMap<>();
        for (int num: array) {
            int potentialMatch = targetSum - num;
            if (nums.containsKey(potentialMatch)) {
                return new int[] {num, potentialMatch};
            } else {
                nums.put(num, true);
            }
        }
        return new int[0];
    }

    /*  Takes in an array [12,3,1,2,-6,5,-8,6], 0
        Returns triplets adding up to 0 in ascending order
        [[-8,2,6],[-8,3,5,],[-6,1,5]]

        Technique used :
            Pointers :
            First sort the array in ascending order (default sorting)
            Now start looping through the array
            with currentNum = array[i] and a left and right

    */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        java.util.Arrays.sort(array); // Sort the array first
        // length-2 because we need atleast 2 integer
        // Use List instead of ArrayList because we can easily
        // gain access to the collection framwork methods
        List<Integer[]> triplets = new ArrayList<Integer[]>();
        for (int i=0; i<array.length-2; i++) {
            int left = i+1;
            int right = array.length-1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    Integer[] newTriplet = {array[i], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                }
            }
        }
        return triplets;
    }

    /*  Takes in two arrays
        arrayOne : [-1,5,10,20,28,3]
        arrayTwo : [26,134,135,15,17]

        find THE pair of number abs diff closest to zero

        Returns array containing these two nums
        [28,26]
        ***** Key points :
        Arrays.sort Big O = n*log(n)
        Technique used :
        Pointers after sorting in ascending order
        Time = O(Nlog(N)+Mlog(M))
        Pointer algor time = O(N+M)
        Space = O(1) sice not storing anything
    */

    public static int[] smallestDifference (int[] arrayOne, int[] arrayTwo) {
        java.util.Arrays.sort(arrayOne);
        java.util.Arrays.sort(arrayTwo);

        int lowestDistanceSoFar = Integer.MAX_VALUE;

        int leftArrLastIndex = arrayOne.length - 1;
        int rightArrLastIndex = arrayTwo.length - 1;

        int leftPointer = 0;
        int rightPointer = 0;

        int [] retVal = new int [2];
        while (leftPointer != leftArrLastIndex && rightPointer != rightArrLastIndex) {
            if (arrayTwo[rightPointer]-arrayOne[leftPointer] == 0) {
                return new int[] {arrayOne[leftPointer],arrayTwo[rightPointer]};
            } else {
                int distanceArr = Math.abs(arrayTwo[rightPointer]-arrayOne[leftPointer]);
                if (distanceArr < lowestDistanceSoFar) {
                    retVal [0] = arrayOne[leftPointer];
                    retVal [1] = arrayTwo[rightPointer];
                    lowestDistanceSoFar = distanceArr;
                }
                if (arrayOne[leftPointer] < arrayTwo[rightPointer]) {
                    leftPointer++;
                } else {
                    rightPointer++;
                }
            }
        }

        return retVal;
    }
    /*
    Given list of integers and integer, move the integer to the right

    */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftPointer = 0;
        int rightPointer = array.size() - 1;

        while (leftPointer < rightPointer) {
            if (array.get(leftPointer) == toMove && array.get(rightPointer) != toMove) {
                array.set(leftPointer, array.get(rightPointer));
                array.set(rightPointer, toMove);
                leftPointer ++;
                rightPointer --;
                continue;
            }
            if (array.get(rightPointer) == toMove) { rightPointer--; }
            if (array.get(leftPointer) != toMove ) { leftPointer++; }
        }

        return array;
    }

    /*
    take non  empty array and integer
    @return all quadruplets that sum up to that integer (sum)
    */

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map <Integer, List <Integer[]> > pairs = new HashMap<>();
            List<Integer[]> retVal = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                int j =i+1;
                while (j < array.length) {
                    int sum = array[i] + array[j];
                    if (pairs.containsKey(targetSum - sum)) {
                        for (Integer[] pair: pairs.get(targetSum - sum)){
                            Integer[] newQuad = {pair[0], pair[1], array[i], array[j]};
                            retVal.add (newQuad);
                        }
                    }
                    j++;
                }
                for (int k= 0; k < i; k++) {
                    List<Integer[]> pairGroup = new ArrayList<Integer[]>();
    				Integer[] newPair = {array[k], array[i]};
                    if (pairs.containsKey(array[i] + array[k])) {
                        pairGroup.add(newPair);
    				    pairs.get(array[i] + array[k]).add(newPair);
                    } else {
    					List <Integer[]> quadToAdd = new ArrayList <Integer[]>();
    					quadToAdd.add(newPair);
                        pairs.put(array[i] + array[k], quadToAdd);
                    }
                }
            }
            return retVal;
    }

      /*
      Subarray Sort
      Given array of integers
      Return the beg and end indices of the shortest array that needs to
      be sorted to make the whole array sorted
      else @return [-1, 1]
      @return [beg index, end index]
      @ min size of array = 2
      [1,2,4,7,10,11,7,12,6,7,16,18,19]
      Its [7,10,11,7,12,6,7] since 6 goes first
      Returns : [3, 9]
      Arrays.sort Big O = n*log(n)
      */

      // My solution : Put all of them in one hashmap
      // two pointers : if
      public static int[] subarraySort(int[] array) {
          int beginningIndex = 0;
          int endingIndex = 0;

          int leftPointer = 0;
          int rightPointer = array.length - 1;

          boolean foundBeginning = false;
          boolean foundEnding = false;

          while (!foundBeginning && !foundEnding) {
              if (leftPointer == 0) {
                  if (array[leftPointer] > array[leftPointer+1]) {
                      foundBeginning = true;
                      beginningIndex = 0;
                  }
              } else {
                  boolean correctPos = (array[leftPointer] >= array[leftPointer-1]) && (array[leftPointer] <= array[leftPointer+1]);
                  if (!foundBeginning && !correctPos) {
                      foundBeginning = true;
                      beginningIndex = leftPointer;
                  } else {
                      leftPointer++;
                  }
              }

              if (rightPointer == array.length-1) {
                  if (array[rightPointer] < array[rightPointer-1]) {
                      foundEnding = true;
                      endingIndex = rightPointer;
                  }
              } else {
                  boolean correctPos = (array[rightPointer] >= array[rightPointer-1]) && (array[rightPointer] <= array[rightPointer+1]);
                  if (!foundEnding && !correctPos) {
                      foundEnding = true;
                      endingIndex = rightPointer;
                  } else {
                      rightPointer++;
                  }
              }
          }
          return new int[]{1,2};

      }

      /*
      Given an array of numbers move all the 0's to the end
      Algo Description:
      Create an index that starts from 0
      Iterate through the array whenever you find a number
      thats no equal to 0, simply move that number to the
      index's position, and the increase index + 1;
      at the and loop from index -> arr.length,
      and make each arr[i] = 0;
      */
      public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i=0; i < nums.length; i++) {
              if(nums[i] != 0) {
                  nums[index++] = nums[i]; // If num not zero
              }
          }

          for (int i= index; i < nums.length; i++) {
              nums[i] = 0;
          }
      }

      /*
      Given an array of integers, return all the numbers
      that are unique

      @param : array of integers nums
      @arg : {1,3,5,5,6,6,7,8,10,10}
      */

      public static List<Integer> getUniqueNums(int[] nums) {
          Map<Integer, Boolean> existingNums = new HashMap();

          for (int i=0; i<nums.length; i++) {
              Integer key = new Integer(nums[i]);
              if (!(existingNums.containsKey(key))){
                  existingNums.put(key, true);
                  continue;
              }
              existingNums.remove(key);
          }
          return new ArrayList<Integer>(existingNums.keySet());
      }

      public static void main(String[] args) {
          List<Integer> list = getUniqueNums(new int[] {1,2,3, 3, 5, 6, 5, 10, 10, 9, 56, 2});

          for (Integer i: list) {
              System.out.println(i);
          }
      }

}
