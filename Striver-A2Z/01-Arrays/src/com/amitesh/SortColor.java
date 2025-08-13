package com.amitesh;

import java.util.Arrays;

public class SortColor {
    public static void main(String[] args) {
        int[] arr = {0,2,1,0,1,2,0};
        System.out.println(Arrays.toString(arr));
        sortBrute(arr);
//        System.out.println("Brute force " +Arrays.toString(arr));
        sortOptimal(arr);
        System.out.println("Optimal " +Arrays.toString(arr));
    }
    public static void sortBrute(int[] arr){
        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i : arr){
            if(i == 0) zero++;
            else if (i == 1) one++;
            else two++;
        }
        int index = 0;
        for(int i =0; i<zero; i++){
            arr[index++] = 0;
        }for(int i =0; i<one; i++){
            arr[index++] = 1;
        }for(int i =0; i<two; i++){
            arr[index++] = 2;
        }
    }
    public static void sortOptimal(int[] arr){
        //using Dutch National Flag
        int low = 0;
        int mid = 0;
        int high = arr.length -1;

        while(mid<=high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr ,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
