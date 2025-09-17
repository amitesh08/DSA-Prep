package com.amitesh;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        //Q. Selection Sort
        int[] arr = {4, 5, 1, 2, 3};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            //find the max item in the remaining array swap with correct index.
            int last = n - i - 1;
            int maxIndex = getMaxIndex(arr, last);
            swapElements(arr, maxIndex, last);
        }
    }

    static void swapElements(int[] arr, int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int last) {
        int max = 0;

        for (int i = 0; i <= last ; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}
