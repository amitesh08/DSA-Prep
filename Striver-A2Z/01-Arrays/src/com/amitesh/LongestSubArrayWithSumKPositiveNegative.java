package com.amitesh;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumKPositiveNegative {
    public static void main(String[] args) {
        //Q. Longest SubArray With Sum K. positive + negative
        int[] arr = {1, 2, 3, 1, 1, 1, 4, 2, 3};
        int k = 3;
        System.out.println(longestSubArray(arr, k));
    }
    public static int longestSubArray(int[] arr, int k) {
        //for positive and negative integer in the array.
        //for this we have to use prefix + hashmap.
        Map<Long, Integer> prefixMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (prefixMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
            }

            if (!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
