package com.amitesh;

public class BinarySearchReverseSorted {
    public static void main(String[] args) {
        // Q. binary search on reverse sorted Array.
        int[] arr = { 9,7,6,4,3,2};
        int target = 4;
        System.out.println(binarySearch(arr, target));
    }
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if (target < arr[mid]) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
