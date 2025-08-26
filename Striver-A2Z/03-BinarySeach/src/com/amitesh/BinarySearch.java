package com.amitesh;

public class BinarySearch {
    public static void main(String[] args) {
        // Q. 704 Binary Search
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end - start) /2;

            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}