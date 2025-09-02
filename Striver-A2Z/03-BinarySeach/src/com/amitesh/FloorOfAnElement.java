package com.amitesh;

public class FloorOfAnElement {
    public static void main(String[] args) {
        // Q. Find Floor of an Element in a sorted Array.
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int element = 11;
        System.out.println(findFloor(arr, element));
    }
    public static int findFloor(int[] arr, int x){
    /*
    IDEA:
        Floor of x in a sorted array = largest element <= x.
        If x exists in the array, floor = x itself.
        Otherwise, floor = closest smaller element.

    APPROACH:
        1. Use Binary Search to efficiently find x or the closest smaller element in a sorted array.
        2. Maintain a variable 'res' to store the index of the current floor candidate.
        3. Iterate while start <= end:
            - If arr[mid] == x → exact match found, return mid immediately.
            - If arr[mid] < x → arr[mid] is a valid floor candidate:
                * Store mid in 'res'.
                * Move right (start = mid + 1) to check for a larger element that is still <= x.
            - If arr[mid] > x → arr[mid] is too large, move left (end = mid - 1) to find a smaller candidate.
        4. After the loop, return res:
            - If a valid floor exists, res contains its index.
            - If no smaller element exists in the array, res remains -1.
    */

        int start = 0;
        int end = arr.length - 1;
        int res = -1; // stores the index of current floor candidate

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] <= x) {
                res = mid; // found a candidate, look for a better one on the right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res; // index of floor element, -1 if no floor exists
    }
}