package com.amitesh;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        // Q. 31 Next Permutation
        int[] nums = {3,2,1};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void nextPermutation(int[] nums) {
    /*
    Idea:
    We want to rearrange numbers into the next lexicographically greater permutation.
    If no such permutation exists (array is in descending order), we return the smallest (ascending order).

    Approach:
    1. Traverse from the right and find the first index `i` such that nums[i] < nums[i+1].
       (This is the "dip" point where we can increase the permutation).
    2. If such `i` exists:
         - Find index `j` from the right such that nums[j] > nums[i].
         - Swap nums[i] and nums[j].
    3. Reverse the subarray from i+1 to end.
       (This gives the next smallest sequence after position `i`).

       Time Complexity: O(n)
        - Finding `i` takes O(n).
        - Finding `j` takes O(n).
        - Reversing takes O(n).
        Overall O(n).

        Space Complexity: O(1)
         - In-place modifications, no extra space used.
    */

        int i = nums.length - 2;

        // Step 1: find first decreasing index
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            // Step 2: find just larger element to swap
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        // Step 3: reverse the suffix
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
