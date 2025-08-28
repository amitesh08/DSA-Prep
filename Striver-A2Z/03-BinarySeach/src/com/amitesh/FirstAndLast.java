package com.amitesh;

import java.util.Arrays;

public class FirstAndLast {
    public static void main(String[] args) {
        // Q. find first and last occurrence of the element
        int[] arr = {2, 4, 10, 10, 10, 28, 20};
        int target = 10;
        System.out.println(Arrays.toString(firstLastSearch(arr, target)));
    }
    public static int[] firstLastSearch(int[] arr, int target){
        int[] ans = {-1, -1};
        ans[0] = search(arr, target, true);   // find first occurrence
        if (ans[0] != -1) {
            ans[1] = search(arr, target, false); // find last occurrence
        }
        return ans;
    }

    public static int search(int[] arr, int target, boolean findFirst){
        int start = 0, end = arr.length - 1, ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                if (findFirst) {
                    end = mid - 1;   // keep searching left
                } else {
                    start = mid + 1; // keep searching right
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
