package com.amitesh;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        //Q. 189. Rotate Array
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        k = k % nums.length;
        if (k != 0) {
            reverseArray(0, nums.length - 1, nums);
            reverseArray(0, k - 1, nums);
            reverseArray(k, nums.length - 1, nums);
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void reverseArray(int start , int end , int[] nums){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
