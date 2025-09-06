package com.amitesh;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        //Q. Single Element in a Sorted Array
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(arr));
    }
    public static int singleNonDuplicate(int[] nums) {
        /*
    IDEA:
        - The array is sorted, and every element appears exactly twice, except one.
        - Normally, elements form pairs like this:
            index: 0 1 | 2 3 | 4 5 | ...
            value: a a | b b | c c | ...
        - This means:
            - For EVEN indices, nums[i] == nums[i+1]
            - For ODD indices, nums[i] == nums[i-1]
        - But when the single element appears, this perfect pairing breaks.
        - Using Binary Search, we can detect which half of the array is "normal"
          (still following the pairing) and which half is "broken" (contains the single element).

    APPROACH:
        1. Apply Binary Search over the array.
        2. Handle edge cases first:
           - If mid = 0 and nums[0] != nums[1], answer is nums[0].
           - If mid = n-1 and nums[n-1] != nums[n-2], answer is nums[n-1].
        3. For the general case:
           - If nums[mid] is different from BOTH neighbors → nums[mid] is the single element.
        4. If not found yet, decide which side to search:
           - Case A: mid is EVEN
               • If nums[mid] == nums[mid+1], pairing is intact up to mid,
                 so the single element lies to the RIGHT → start = mid + 1.
               • Otherwise, the single element is on the LEFT → end = mid - 1.
           - Case B: mid is ODD
               • If nums[mid] == nums[mid-1], pairing is intact up to mid,
                 so the single element lies to the RIGHT → start = mid + 1.
               • Otherwise, the single element is on the LEFT → end = mid - 1.
        5. Keep shrinking the search space until the unique element is found.

    WHY IT WORKS:
        - Before the single element: pairs start at even indices (0,2,4...).
        - After the single element: the pattern shifts, and pairs start at odd indices (1,3,5...).
        - By checking the parity (even/odd) of mid and its pairing,
          we can always eliminate half the search space.

    TIME COMPLEXITY: O(log n) → each step halves the search space.
    SPACE COMPLEXITY: O(1) → only a few pointers are used.
    */

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums.length == 1){
                return nums[0];
            }

            // Edge cases (to avoid out-of-bound access)
            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid == n - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            // Found the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Decide which half to search
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1; // search right
            } else {
                end = mid - 1;   // search left
            }
        }

        return -1; // should never reach here if input is valid
    }
}
