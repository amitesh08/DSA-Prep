package com.amitesh;

public class SingleNumber {
    public static void main(String[] args) {
        //Q.136. Single Number
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i< nums.length; i++){
            ans = ans^nums[i];
        }
        return ans;
    }
}
