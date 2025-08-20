package com.amitesh;

public class MaximumSubArray {
    public static void main(String[] args) {
        //Q. 53 - Maximum SubArray
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayOptimal(nums));
    }
    public static int maxSubArrayOptimal(int[] nums) {
    /*
    ------ KADANE'S ALGORITHM ------

    Idea:
    - Keep track of the "current running sum".
    - If the running sum ever goes below 0, reset it to 0
      because it won't help in forming the max subArray.
    - Keep updating the global maximum along the way.

    Approach:
    1. Initialize:
       - max = Integer.MIN_VALUE (to handle all negative case)
       - sum = 0
    2. Traverse each element:
       - Add current element to sum.
       - Update max if sum > max.
       - If sum < 0 → reset sum = 0.
    3. Return max.

    Complexity:
    - Time: O(n) (single pass)
    - Space: O(1)
    */

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // Update global max
            if (sum > max) {
                max = sum;
            }

            // Reset running sum if it goes negative
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
