package com.amitesh;

public class PeakElement {
    public static void main(String[] args) {
        //Q. find Peak Element
        int[] arr = {5,10,20,15};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        /*
    IDEA:
    - A peak element is greater than both neighbors.
    - Using Binary Search, we can find one in O(log n).
    - Key insight:
        - If mid < mid+1 → peak lies on right.
        - If mid > mid+1 → peak lies on left or mid.

    APPROACH:
    1. Run binary search.
    2. At each step:
        - If nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1], return mid.
        - Else move towards the side which has the larger neighbor.
    3. Handle edge cases separately for 0 and n-1.

    TIME COMPLEXITY: O(log n)
    SPACE COMPLEXITY: O(1)
    */

        int n = nums.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: middle element
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid; // found a peak
                } else if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1; // go right
                } else {
                    end = mid - 1; // go left
                }
            }
            // Case 2: left boundary
            else if (mid == 0) {
                return (nums[0] >= nums[1]) ? 0 : 1;
            }
            // Case 3: right boundary
            else if (mid == n - 1) {
                return (nums[n - 1] >= nums[n - 2]) ? n - 1 : n - 2;
            }
        }
        return -1; // should never reach here
    }
}
