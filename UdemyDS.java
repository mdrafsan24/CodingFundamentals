public class UdemyDS {

    public static void main(String[] args) {
        // RECURSION
        // -----------
        recursion("fibonacci");
        OneDimArray(new int[10]);

    }

    public static void recursion(String s) {
        switch (s) {
            case "factorial":
                System.out.println(factorial(5));
            case "fibonacci":
                System.out.println(fibonacci(4));

        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return (n*factorial(n-1));
    }

    public static int fibonacci(int n) {
        if (n < 1) {
            return 0;
        } else if ( n == 1 || n == 2) {
            return n-1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void OneDimArray(int[] arr) {
        traverseArray(arr);
        insertArray(6, 555, arr);

    }

    public static void traverseArray(int[] arr) {
        System.out.print("Traversal : ");
        try {
            for (int i= 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists !");
        }
        System.out.println();

    }

    public static void insertArray(int location, int val, int[] arr) {
        try {
            if (arr[location] == 0) {
                arr[location] = val;
                System.out.println ("Succesfully inserted " + val);
            } else {
                System.out.println("Already occupied");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists !");
        }
        System.out.print("PROOF THAT IT WAS INSERTER: " + arr[location]);
    }

}
