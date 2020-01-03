/*
Tree explained:
Root node
Each node has only one parent
Trees can never be disconnected
Each node can only have AT MOST 2 child nodes
Name of tree = how many child the root has
2 child = binary
3 child = trinary

Binary Search Tree (Special Type)
Heaps (Min Heaps and Max Heaps)
Tries - a tree like data structure that stores
characters in string in a tree like structure

Most trees dont have pointer back to parent
Space - time complexity -
Space : Storing tree is always O(N)
Time : Traversing is O(N) (Go through all N nodes)
BUT if we just going through one side (left or right)
then time complexity becomes O(log n) as long as the
tree is balanced
Balanced: means its roughly same on both sides,
the last node on one sad can have extra child, as long
as it doesn't have a child of its own

Vocabs :
Any path in a tree that starts at root and ends at
one of the bottom node is a branch
leaf node = bottom node
levels are called levels
A tree is complete if every single level is filled up
except the final level
In the final level, if it has nodes, it must be filled
up from left to right
A tree is full if every children has no kids, or k kids
(k = 2 if binary , 3 if trenary etc. )
Depth = how far down it goes = height = #levels

Binary tree  at most two child
                parent
    less val node   greater val node
*/

import java.util.*;

public class Trees {

    /*
    BST
    1. Parent.val > leftNode.val && Parent.val <= rightNode.val
    2. Child nodes are != null
    */

    // Write a Binary Search Tree (BST) class. The class should have a "value" property
    // set to be an integer, as well as "left" and "right" properties, both of which
    // should point to either the None (null) value or to another BST.
    //A node is said to be a BST node if and only if it satisfies the BST property:
    // its value is strictly greater than the values of every node to its left;
    // its value is less than or equal to the values of every node to its right;
    // and both of its children nodes are either BST nodes themselves or None (null) values.
    // The BST class should support insertion, searching, and removal of values.
    // The removal method should only remove the first instance of the target value.
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
          this.value = value;
        }

        public BST insert(int value) {

			if (this.value <= value && this.right != null) {
					insertHelper(value, this.right);
			} else if (this.value > value && this.left != null) {
					insertHelper(value, this.left);
			}
			return this;
		}

		public static void insertHelper(int value, BST tree) {
			if (tree.left == null) {
				tree.left = new BST(value);
				return;
			} else if (tree.right == null) {
				tree.right = new BST(value);
				return;
			} else {
				if (tree.value <= value) {
						insertHelper(value, tree.right);
				} else {
						insertHelper(value, tree.left);
				}
			}
		}

        public boolean contains(int value) {
          if (this.value <= value && this.right != null) {
              return containsHelper(value, this.right);
          } else if (this.value > value && this.left != null) {
              return containsHelper(value, this.left);
          }
          return false;
        }

        public static boolean containsHelper(int value, BST tree) {
            if (this.value <= value && this.right != null) {
                return containsHelper(value, this.right);
            } else if (this.value > value && this.left != null) {
                return containsHelper(value, this.left);
            }
            return false;
        }


        // Only removes the first instance
        public BST remove(int value) {
          // Write your code here.
          // Do not edit the return statement of this method.
          return this;
        }
    }

    /*
    Time = O(log n) because eliminating half the tree
    Worst Case = O(n) when the tree only has one branch
    Space = Recursive = O(log n) since adding frames to
    a call stack; Or/ O(depth) as its called
    Iteratively space will be O(1)
    */
    // What does static mean ?
    // With static methods you dont have to create an object
    // Instance methods you do
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstHelper (tree, target, Double.MAX_VALUE);
    }

    public static int findClosestValueInBstHelper(BST tree, int target, double closest) {
        // Base case current node == null
        if (tree == null) {
            return (int)closest;
        }
        int distance = (int)Math.abs(target-tree.value);
        int closestDistance = (int)Math.abs(closest-target);

        if (closestDistance > distance) {
            closest = tree.value; // Update closest
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        } else {
            return (int)closest; // Found the exact value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(1);
        System.out.print(findClosestValueInBst(tree, -1));
    }
}
