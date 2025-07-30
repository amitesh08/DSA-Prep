package com.amitesh;

public class SecondLargest {
    public static void main(String[] args) {
        int [] arr = {2, 3, 4, 9, 0, 1, 5};
        int res = secondLargestElement(arr);
        System.out.println(res);
    }

    private static int secondLargestElement(int[] arr) {
        int max = arr[0];
        int secondMax = -1;

        for(int e : arr){
            if (e > max){
                secondMax = max;
                max = e;
            } else if (e > secondMax && e != max) {
                secondMax = e;
            }
        }
        return secondMax;
    }
}
