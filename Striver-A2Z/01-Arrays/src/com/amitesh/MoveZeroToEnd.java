package com.amitesh;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        //Q. 283. Move Zeroes(Leetcode)
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));

    }
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length ; j++) {
//            if (nums[i] == 0 && nums[j] != 0) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//                i++;
//            } else if (nums[i] != 0) {
//                i++;
//            }
            if (nums[j] != 0) {
                // Swap only if i and j are different
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                i++;
            }
        }
    }
}
