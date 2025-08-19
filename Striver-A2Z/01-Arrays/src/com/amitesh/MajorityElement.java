package com.amitesh;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        //Q. 169 - Majority Element
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElementBetter(nums));
        System.out.println(majorityElementOptimal(nums));
    }
    public static int majorityElementBetter(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                int temp = map.get(num);
                map.put(num, temp + 1);
            }
            else{
                map.put(num,1);
            }
        }
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2) ans = key;
        }
        return ans;
    }
    public static int majorityElementOptimal(int[] nums){
    /*
    ---------OPTIMAL SOLUTION---------
    Using Moore's Voting Algorithm

    Idea:
    - If an element appears more than n/2 times in an array,
      it will remain as the "last standing candidate" after
      canceling out all other elements.

    Approach:
    1. Phase 1 (Find candidate):
       - Maintain a count and a candidate element.
       - Traverse the array:
         - If count is 0 → set current element as candidate.
         - If current element equals candidate → increase count.
         - Else → decrease count.
       - After this, candidate will hold the potential majority element.

    2. Phase 2 (Verify candidate):
       - Count how many times the candidate actually appears in the array.
       - If it appears > n/2 times → return it.
       - Else → return -1 (no majority element).
     */

        int count = 0;     // keeps track of balance between candidate and others
        int element = 0;   // will store the candidate element

        // Phase 1: Find candidate
        for (int num : nums){
            if(count == 0){
                element = num;  // choose new candidate
                count = 1;
            } else if (num == element) {
                count++;        // same as candidate → increase count
            } else {
                count--;        // different → cancel one occurrence
            }
        }

        // Phase 2: Verify candidate
        int count1 = 0;
        for (int num : nums){
            if(num == element) count1++;
        }

        if(count1 > nums.length/2) return element; // majority element found
        return -1; // no majority element
    }

}
