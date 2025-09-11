package com.amitesh;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        //Q. 1539. Kth Missing Positive Number
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
    public static int findKthPositive(int[] arr, int k) {
        /*
    IDEA:
    - We are given a sorted array of positive integers.
    - If there were no missing numbers, the i-th element should be (i+1).
    - So, missing numbers until index mid = arr[mid] - (mid+1).
    - Use this property with binary search.

    APPROACH:
    1. Use binary search on arr.
    2. For each mid:
        - Calculate missing = arr[mid] - (mid+1).
        - If missing < k → we need more missing numbers → move right.
        - Else → move left.
    3. When search ends, 'left' represents how many elements in arr
       are before the position where the k-th missing number lies.
    4. Final Answer = left + k.

    TIME COMPLEXITY: O(log n)
    SPACE COMPLEXITY: O(1)
    */

        int n = arr.length;
        int left = 0, right = n - 1;

        // Binary search to find the position
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Numbers missing until arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;  // still need more missing numbers
            } else {
                right = mid - 1; // search in left half
            }
        }

        // kth missing number = index (left) + k
        return left + k;
    }
}
