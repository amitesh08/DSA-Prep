package com.amitesh;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Bubble Sort
        int[] arr = {3,1,4,5,2};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr) {
    /*
    IDEA:
        - Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.
        - In each pass, the largest element "bubbles up" to the end of the array.
        - After the i-th pass, the last i elements are already sorted.

    APPROACH:
        1. Repeat passes for (n-1) times (where n = size of array).
        2. In each pass:
           - Compare each element with its next neighbor.
           - Swap if they are in the wrong order.
        3. Optimization:
           - Use a `swapped` flag:
             If no swaps happen in a pass → array is already sorted → stop early.

    TIME COMPLEXITY:
        - Worst/Avg Case: O(n^2) (when array is reverse sorted).
        - Best Case: O(n) (when array is already sorted, because of the `swapped` flag).

    SPACE COMPLEXITY: O(1) (in-place sorting).
    */

        boolean swapped;

        // Outer loop runs for (n-1) passes
        for (int i = 0; i < arr.length; i++) {
            swapped = false;

            // Inner loop: compare adjacent elements up to (n-i-1)
            for (int j = 1; j < arr.length - i; j++) {
                // If previous element is greater → swap
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps in this pass → array is already sorted
            if (!swapped) break;
        }
    }

}