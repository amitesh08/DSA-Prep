package com.amitesh;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //Q. 33. Search in Rotated Sorted Array I
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left  = binarySearch(nums, target, 0 , pivot -1);

        if (left != -1) return left;

        // else search in right side
        return binarySearch(nums, target, pivot, nums.length - 1);
    }
    public static int findPivot(int[] nums){
        int n = nums.length;
        int start = 0;
        int end = n-1;

        if(nums[start] < nums[end]){
            return 0;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return mid;
            }

            // if middle element is greater than nums[end], pivot lies to the right
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                // otherwise pivot lies to the left
                end = mid - 1;
            }
        }
        return 0;
    }
    public static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end ){
            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
