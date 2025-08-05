package com.amitesh;

public class NonDecreasingArray {
    public static void main(String[] args) {
        //Q. 665. Non-decreasing Array
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));

    }
    public static boolean checkPossibility(int[] nums){
        int spot  = 0;

        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i+1]) {
                if (spot == 1) return false; // Already modified once

                // Decide which element to modify
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1]; // Lower current element
                } else {
                    nums[i + 1] = nums[i]; // Raise next element
                }

                spot++;
            }
        }
        return true;
    }
}
