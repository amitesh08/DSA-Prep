package com.amitesh;

import java.util.ArrayList;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5};
        System.out.println(findUnionOptimal(arr1, arr2));
        System.out.println(findUnionBetter(arr1, arr2));
    }
    public static ArrayList<Integer> findUnionOptimal(int[] arr1, int[] arr2) {
/*
    ---------OPTIMAL APPROACH---------

    Approach - We are using TreeSet instead of HashMap/HashSet.
    Why TreeSet?
        - TreeSet stores only unique elements (removes duplicates automatically).
        - TreeSet maintains elements in sorted (ascending) order by default.
        - This removes the need to manually sort or check duplicates.

    How we are solving this:
        - Insert all elements of arr1 into the TreeSet.
        - Insert all elements of arr2 into the TreeSet.
        - Since TreeSet ensures uniqueness and sorting, we directly get the union.
        - Finally, convert TreeSet into ArrayList (because output type is ArrayList).
     */

        // TreeSet automatically sorts and keeps only unique elements
        TreeSet<Integer> set = new TreeSet<>();

        // Inserting all elements of arr1 into the set
        for (int num : arr1) set.add(num);

        // Inserting all elements of arr2 into the set
        for (int num : arr2) set.add(num);

        // Convert TreeSet (unique + sorted) into ArrayList and return
        return new ArrayList<>(set);
    }

    public static ArrayList<Integer> findUnionBetter(int[] arr1, int[] arr2) {
    /*
    ---------BETTER OPTIMAL APPROACH---------
    Using Two Pointers (works when arrays are already sorted)

    🔹 IDEA:
    - Both arrays are sorted.
    - We keep 2 pointers: i for arr1, j for arr2.
    - Compare elements at arr1[i] and arr2[j]:
        - If arr1[i] <= arr2[j], take arr1[i] into union (only if not duplicate), move i.
        - Else, take arr2[j] into union (only if not duplicate), move j.
    - This way we merge like in "merge step of merge sort".
    - Continue until one array is fully traversed.
    - Then add remaining elements of the other array (avoiding duplicates).

    🔹 Why Optimal?
    - Time Complexity: O(n1 + n2) → only one pass through both arrays.
    - Space Complexity: O(1) extra (apart from result list).
    - Faster than TreeSet because we don’t use log(N) insertions.
    */

        int n1 = arr1.length;
        int n2 = arr2.length;

        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                // Add arr1[i] if it's not a duplicate of last inserted
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++; // move pointer in arr1
            } else {
                // Add arr2[j] if it's not a duplicate of last inserted
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++; // move pointer in arr2
            }
        }

        // Add remaining elements from arr1
        while (i < n1) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Add remaining elements from arr2
        while (j < n2) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

}
