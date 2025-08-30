package com.amitesh;

public class FindKthRotation {
    public static void main(String[] args) {
        //. Q. Find out how many times the array has been rotated
        int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
        System.out.println(findKRotation(arr)); // Expected: 4 (rotated 4 times)
    }
    public static int findKRotation(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // case: already sorted (no rotation)
        if (arr[start] <= arr[end]) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            // check if mid is minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // index of smallest element = no. of rotations
            }

            // if middle element is greater than arr[end], pivot lies to the right
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                // otherwise pivot lies to the left
                end = mid - 1;
            }
        }
        return 0;
    }
}
