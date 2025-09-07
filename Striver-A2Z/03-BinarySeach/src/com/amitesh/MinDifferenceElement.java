package com.amitesh;

public class MinDifferenceElement {
    public static void main(String[] args) {
        //Q. Minimum difference element in a sorted array
        int[] arr = {2, 5, 10, 12, 15};
        int target = 6;
        System.out.println("Minimum Difference Element: " + findMinDiffElement(arr, target));
    }

    public static int findMinDiffElement(int[] arr, int target) {
        /*
        IDEA:
        - In a sorted array, the closest element to the target will be either:
            1. The exact element if target exists
            2. The floor (largest element smaller than target)
            3. The ceil (smallest element greater than target)
        - Use Binary Search to narrow down to floor and ceil, then return whichever is closer.

        APPROACH:
        1. Run Binary Search until start > end.
        2. If arr[mid] == target → return arr[mid].
        3. If arr[mid] < target → move right (start = mid + 1).
        4. Else move left (end = mid - 1).
        5. After loop ends:
            - end will point to floor
            - start will point to ceil
        6. Compare |target - arr[end]| vs |arr[start] - target| carefully.
        7. Return the element with the smaller difference.

        TIME COMPLEXITY: O(log n)
        SPACE COMPLEXITY: O(1)
        */

        int n = arr.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // exact match
            } else if (arr[mid] < target) {
                start = mid + 1; // go right
            } else {
                end = mid - 1;   // go left
            }
        }

        // Now loop is over → start = ceil, end = floor
        // Edge cases: check boundaries
        if (end < 0) return arr[0];          // target smaller than smallest element
        if (start >= n) return arr[n - 1];  // target larger than largest element

        // Compare differences
        if ((target - arr[end]) <= (arr[start] - target)) {
            return arr[end];
        } else {
            return arr[start];
        }
    }
}
