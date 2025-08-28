package com.amitesh;

public class OrderAgnostic {
    public static void main(String[] args) {
        // Q. Order Agnostic Binary Search
//        int[] arr = {9,7,6,4,3,2};
        int[] arr = {-1,0,3,5,9,12};
        int target = 3;
        System.out.println(orderAgnosticSearch(arr, target));
    }
    public static int orderAgnosticSearch(int[] arr , int target){
        int start = 0;
        int end = arr.length -1;

        if(arr[start] < arr[end]){
            return binarySearch(arr, target, start, end);
        }else{
            return reverseBinarySearch(arr, target, start, end);
        }
    }
    public static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int reverseBinarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
