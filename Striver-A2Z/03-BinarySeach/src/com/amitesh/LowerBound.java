package com.amitesh;

public class LowerBound {
    public static void main(String[] args) {
        //Q. implement lower Bound
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 11;
        System.out.println(lowerBound(arr, target));
    }
    public static int lowerBound(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] >= target) {
                ans = mid;      // possible answer
                end = mid - 1;  // try to find smaller index
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
