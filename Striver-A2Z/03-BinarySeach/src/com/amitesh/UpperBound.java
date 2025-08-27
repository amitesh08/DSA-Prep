package com.amitesh;

public class UpperBound {
    public static void main(String[] args) {
        //Q. Implement Upper Bound.
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;
        System.out.println(upperBound(arr, target));
    }
    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] > target) {
                ans = mid;     // possible answer, but look left for smaller index
                end = mid - 1;
            } else {
                start = mid + 1; // arr[mid] <= target, so go right
            }
        }
        return ans;
    }
}
