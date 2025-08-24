package com.amitesh;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        // Q. Longest Consecutive Subsequence
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(int[] arr) {
        /*
    Idea:
    We want the length of the longest sequence of consecutive integers
    (order in array doesn't matter).

    Approach:
    1. Insert all numbers into a HashSet for O(1) lookup.
    2. For each number, only start counting if it's the "start" of a sequence
       (i.e., num-1 not in set).
    3. Expand forward (num+1, num+2, ...) to count the streak.
    4. Keep track of the maximum streak length.

    Time Complexity: O(n)
        - Each number visited at most twice (start check + streak count).
    Space Complexity: O(n)
        - HashSet to store numbers.
    */

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // only start from beginning of a sequence
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
