package com.amitesh;

public class NumberOfOccurrence {
    public static void main(String[] args) {
        //Q. Count Occurrences in Sorted Array.
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 4;
        System.out.println(countFreq(arr, target));
    }
    public static int countFreq(int[] arr, int target) {
        // code here
        int[] ans = {-1, -1};
        ans[0] = search(arr, target, true);   // find first occurrence
        ans[1] = search(arr, target, false); // find last occurrence

        if(ans[0] == -1 || ans[1] == -1){
            return 0;
        }
        return ans[1] - ans[0] + 1 ;
    }
    public static int search(int[] arr, int target, boolean findFirst){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                ans = mid;
                if(findFirst){
                    end = mid - 1;
                }
                else start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
