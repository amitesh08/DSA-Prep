package com.amitesh;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        // Q. 560. SubArray Sum Equals K.
        int[] nums = {1,2,3};
        System.out.println(subArraySum(nums, 3));
    }
    public static int subArraySum(int[] nums, int k){
    /*
    Idea:
    - Use the concept of prefix sum + HashMap.
    - If sum[i] - sum[j] = k → then subArray (j+1 ... i) has sum k.
    - Store frequency of each prefix sum in a HashMap to count such cases.

    Approach:
    1. Initialize a HashMap to store prefix sum frequencies.
       - Start with {0:1} because sum=0 before starting allows subArray starting from index 0.
    2. Traverse the array, keeping a running prefix sum.
    3. At each step, check if (currentSum - k) exists in the map:
       - If yes, add its frequency to count.
    4. Update the frequency of currentSum in the map.
    5. Return total count.

    Time Complexity: O(n) → each element processed once.
    Space Complexity: O(n) → HashMap stores prefix sums.
    */

        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);  // base case

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;

            if(prefixSumFreq.containsKey(sum - k)){
                count += prefixSumFreq.get(sum - k);
            }

            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
