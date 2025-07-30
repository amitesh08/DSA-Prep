package com.amitesh;

public class LargestElement {
    public static void main(String[] args) {
        int [] arr = {2, 3, 4, 9, 0, 1, 5};
        int res = largestElement(arr);
        System.out.println(res);
    }
    public static int largestElement(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int e : arr){
            if(e > max){
                max = e;
            }
        }
        return max;
    }
}