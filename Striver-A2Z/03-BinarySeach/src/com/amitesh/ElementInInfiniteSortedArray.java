package com.amitesh;

public class ElementInInfiniteSortedArray {
    public static void main(String[] args) {
        // Q. find the position of an element in an infinite sorted array.
        int[] arr = {2,3,4,5,6,6,7,8,9,9,13,15,17,21,23,24,25,29,30,32,34,35,37};
        int target = 15;
        System.out.println(search(arr, target));
    }
    public static int search(int[] arr, int target){
    /*
    IDEA:
        - In an infinite sorted array, we can’t directly know the size.
        - So we expand the search window exponentially until we find a range
          [start, end] such that arr[end] >= target.
        - Then we apply Binary Search inside that range.

    APPROACH:
        1. Start with a window: start = 0, end = 1
        2. Expand window exponentially:
            - While arr[end] < target:
                - Move start = end
                - Double the end = end * 2
        3. Apply binary search in the range [start, end].
        4. Return index if found, else -1.

    TIME COMPLEXITY:
        - O(log p), where p is the position of the target
          (window expands log times + binary search)
    SPACE COMPLEXITY: O(1)
    */

        int start = 0;
        int end = 1;

        // expand the window until target <= arr[end]
        while (end < arr.length && arr[end] < target) {
            start = end;
            end = end * 2;
            if (end >= arr.length) {
                end = arr.length - 1; // keep inside array bounds
            }
        }

        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // target not found
    }

}
