package com.amitesh;

public class ArraySortedAndRotated {
    public static void main(String[] args) {
//        1752. Check if Array Is Sorted and Rotated
        int [] nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]) count++;
        }
        if(nums[n-1] > nums[0]) count++;
        return count <= 1;
    }
}
