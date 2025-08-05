package com.amitesh;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
       //Q.217. Contains Duplicate
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i : nums){
            if(s.contains(i)) return true;

            s.add(i);
        }
        return false;
    }
}
