package com.amitesh;

public class FindInMountainArray {
    public static void main(String[] args) {
        // Q. 1095. Find in Mountain Array
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int key = 3;

        int peak = findPeak(arr);

        // Search in ascending part
        int left = binarySearch(arr, 0, peak, key, true);

        if (left != -1) {
            System.out.println(left);
        } else {
            // Search in descending part
            int right = binarySearch(arr, peak + 1, arr.length - 1, key, false);
            System.out.println(right);
        }
    }

    public static int findPeak(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;

        if (n == 1) return 0; // ✅ return index, not element

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < n - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid; // peak index
                } else if (arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid == 0) {
                return arr[0] >= arr[1] ? 0 : 1;
            } else if (mid == n - 1) {
                return arr[n - 1] >= arr[n - 2] ? n - 1 : n - 2;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int start, int end, int key, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (ascending) {
                // Normal binary search
                if (arr[mid] < key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // Reverse binary search for descending part
                if (arr[mid] < key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
