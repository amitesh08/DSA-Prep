package com.amitesh;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        //Q. 2149. Rearrange Array Elements by Sign
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArrayBrute(nums)));
        System.out.println(Arrays.toString(rearrangeArrayOptimal(nums)));
    }
    public static int[] rearrangeArrayBrute(int[] nums) {
    /*
    -------- IDEA / APPROACH --------
    1. We know the array contains equal number of positive and negative numbers.
    2. Create two separate arrays:
       - one for positive numbers
       - one for negative numbers
    3. Traverse the input array and store positives and negatives separately.
    4. Then, rebuild the nums array by placing:
       - positives at even indices (0, 2, 4, …)
       - negatives at odd indices (1, 3, 5, …)
    5. This ensures the array is rearranged as required.

    -------- COMPLEXITY --------
    Time:  O(n)   (one pass to split, one pass to merge)
    Space: O(n)   (two extra arrays)
    */

        int n = nums.length;
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int pi = 0, ni = 0;

        // Step 1: Separate positives and negatives
        for (int num : nums) {
            if (num >= 0) pos[pi++] = num;
            else neg[ni++] = num;
        }

        // Step 2: Refill original array
        pi = 0;
        ni = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) nums[i] = pos[pi++]; // even index → positive
            else nums[i] = neg[ni++];            // odd index  → negative
        }

        return nums;
    }



    public static int[] rearrangeArrayOptimal(int[] nums) {
    /*
    Problem:
    Given an array with equal positive and negative numbers,
    rearrange so that positives are at even indices and negatives
    at odd indices, while maintaining relative order.

    Optimal Approach:
    - Use two pointers (pos and neg) for result array.
    - Traverse input:
        - If num > 0 → place at pos, pos += 2
        - If num < 0 → place at neg, neg += 2
    - Return result.

    Complexity:
    - Time: O(n) → single pass.
    - Space: O(n) → extra result array.
    */

        int n = nums.length;
        int[] res = new int[n];
        int pos = 0; // even index
        int neg = 1; // odd index

        for (int num : nums) {
            if (num >= 0) {
                res[pos] = num;
                pos += 2;
            } else {
                res[neg] = num;
                neg += 2;
            }
        }

        return res;
    }
}

