package com.amitesh;

import java.util.ArrayList;

public class MaximumSubArrayList {
    public static void main(String[] args) {
        //Q. 53 - Maximum SubArray | print the subArray
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayOptimal(nums));
    }
    public static ArrayList<Integer> maxSubArrayOptimal(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i< nums.length; i++) {
            if(sum == 0) start = i;
            sum += nums[i];

            // Update global max
            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Reset running sum if it goes negative
            if (sum < 0) {
                sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++){
            list.add(nums[i]);
        }
        return list;
    }
}
