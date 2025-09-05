package com.amitesh;

public class First1InSortedBinaryArray {
    public static void main(String[] args) {
        // Q. Find the first 1 in an  infinite sorted Binary Array.
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}; //infinite Array
        System.out.println(search(arr));
    }
    public static int search(int[] arr) {
    /*
    IDEA:
        - The array is binary sorted (all 0’s followed by all 1’s).
        - We need the first index where 1 appears.
        - Since it’s "infinite", we expand the search window exponentially
          until we are sure the first 1 lies within [start, end].
        - Then we perform Binary Search inside that window to find the first 1.

    APPROACH:
        1. Initialize start = 0, end = 1.
        2. Expand the window exponentially while arr[end] == 0:
             - Move start = end
             - Double end = end * 2
             - If end exceeds array length → clamp it to arr.length - 1
        3. Now apply Binary Search in [start, end] to find first index of 1.
        4. Return that index or -1 if 1 not found.

    TIME COMPLEXITY:
        - O(log p), where p = index of first 1.
    SPACE COMPLEXITY: O(1).
    */

        int start = 0;
        int end = 1;

        // Expand window until we find a '1'
        while (end < arr.length && arr[end] == 0) {
            start = end;
            end *= 2;
            if (end >= arr.length) {
                end = arr.length - 1; // clamp to array bounds
            }
        }

        // Binary search in the window [start, end]
        return firstIndex(arr, start, end);
    }

    public static int firstIndex(int[] arr, int start, int end) {
        int key = 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                ans = mid;         // found a 1
                end = mid - 1;     // look further left for first occurrence
            } else {
                start = mid + 1;   // move right if arr[mid] == 0
            }
        }
        return ans; // -1 if no 1 exists
    }
}
