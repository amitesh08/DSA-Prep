package com.amitesh;

import java.util.ArrayList;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,4,5};
        System.out.println(findUnionOptimal(arr1, arr2));
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
    Using Two Pointer


     */

        return new ArrayList<>();
    }
}
