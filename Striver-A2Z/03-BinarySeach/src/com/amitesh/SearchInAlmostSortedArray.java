package com.amitesh;

public class SearchInAlmostSortedArray {
    public static void main(String[] args) {
        //Q. Search in a nearly sorted array.
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;
        System.out.println(findTarget(arr, target));
    }
    public static int findTarget(int[] arr, int target){
    /*
    IDEA:
        The array is "nearly sorted", meaning every element
        may be misplaced by at most 1 position.
        So, the target can only be at:
            - mid
            - mid - 1
            - mid + 1

    APPROACH:
        1. Use Binary Search with a slight modification.
        2. At each step, check arr[mid], arr[mid-1], and arr[mid+1].
        3. If none matches:
             - If arr[mid] < target → search in the right half (skip 2 steps).
             - Else → search in the left half (skip 2 steps).
        4. Keep repeating until start > end.
        5. If not found, return -1.
    */

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check mid, mid-1, mid+1
            if (arr[mid] == target) {
                return mid;
            }
            if (mid - 1 >= start && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (mid + 1 <= end && arr[mid + 1] == target) {
                return mid + 1;
            }

            // Move search space
            if (arr[mid] < target) {
                start = mid + 2; // skip checked indices
            } else {
                end = mid - 2; // skip checked indices
            }
        }
        return -1;
    }
}
