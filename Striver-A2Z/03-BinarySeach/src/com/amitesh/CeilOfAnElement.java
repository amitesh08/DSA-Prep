package com.amitesh;

public class CeilOfAnElement {
    public static void main(String[] args) {
        //Q. Find Ceil of an element
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int element = 11;
        System.out.println(findCeil(arr, element));
    }
    public static int findCeil(int[] arr, int x){
    /*
    ------------------- FIND CEIL -------------------
    IDEA:
        Ceil of x = smallest element in array >= x

    APPROACH:
        1. Use Binary Search to efficiently find x or the closest larger element.
        2. Maintain a variable 'res' to store the index of the current ceil candidate.
        3. Iterate while start <= end:
            - If arr[mid] == x → exact match found, return mid.
            - If arr[mid] > x → arr[mid] is a valid ceil candidate:
                * Store mid in 'res'.
                * Move left (end = mid - 1) to check for a smaller element that is still ≥ x.
            - If arr[mid] < x → arr[mid] is too small, move right (start = mid + 1) to find a larger candidate.
        4. Return res (-1 if no larger element exists in the array)
        TIME COMPLEXITY: O(log n)
        SPACE COMPLEXITY: O(1)
    */

        int start = 0;
        int end = arr.length - 1;
        int res = -1; // stores index of current ceil candidate

        while (start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] >= x){
                res = mid; // candidate for ceil
                end = mid - 1; // try to find a smaller one on the left
            } else {
                start = mid + 1; // discard left half
            }
        }
        return res; // index of ceil element
    }
}
