package com.amitesh;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        //Insertion Sort
        int[] arr = {5,3,4,1,2};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion(int[] arr) {
    /*
    IDEA:
    - Insertion Sort works like sorting playing cards in your hand.
    - You pick elements one by one and insert them into their correct position
      in the already sorted part of the array.
    - At every step, the left portion of the array is sorted.

    APPROACH:
    1. Start from the 2nd element (index 1), because the 1st element is already "sorted".
    2. For each element, compare it with elements on its left side.
    3. Keep swapping/moving it backward until it is in the correct position.
    4. Repeat this for all elements.

    HOW IT WORKS:
    - Imagine you have a partially sorted array (left side).
    - You take the next element and "insert" it into its correct spot
      among the sorted elements.

    TIME COMPLEXITY:
    - Worst/Avg Case: O(n^2) (when array is reverse sorted).
    - Best Case: O(n) (when array is already sorted).
    SPACE COMPLEXITY: O(1) (in-place sorting).
    */

        int n = arr.length;

        // Outer loop picks elements one by one (from index 1 to n-1)
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: move current element backwards to its correct position
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapElements(arr, j, j - 1); // Swap if smaller than previous
                } else {
                    break; // Stop when current element is in the right spot
                }
            }
        }
    }

    // Helper function to swap two elements
    static void swapElements(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
