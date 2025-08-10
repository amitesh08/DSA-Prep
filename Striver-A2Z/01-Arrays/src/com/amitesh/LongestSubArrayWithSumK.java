package com.amitesh;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        //Q. Longest SubArray With Sum K.
        int[] arr = {1, 2, 3, 1, 1, 1, 4, 2, 3};
        int k = 3;
        System.out.println(longestSubArrayBrute(arr, k));
    }
    public static int longestSubArrayBrute(int[] arr, int k) {
        //Brute Force
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if(sum == k) length = Math.max(length, j-i + 1);
            }
        }
        return length;

    }public static int longestSubArrayOptimal(int[] arr, int k) {
        //optimal
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if(sum == k) length = Math.max(length, j-i + 1);
            }
        }
        return length;

    }
}
