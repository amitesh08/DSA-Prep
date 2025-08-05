package com.amitesh;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
    public static void main(String[] args) {
        //Q. two sum optimised
        int[] arr = {2,7,11,15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        /* Optimised
            -> we are using map, we will store every element with their index.
            -> for each new number ,
                -> "did we already see this number that can pair with this one to make the target.
                -> if yes "return the indices"
                -> if No " remember this number and move on.
        */
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
