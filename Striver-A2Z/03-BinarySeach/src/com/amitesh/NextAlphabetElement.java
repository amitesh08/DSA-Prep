package com.amitesh;

public class NextAlphabetElement {
    public static void main(String[] args) {
        //Q. Next Alphabet element.
        char[] arr = {'a', 'c', 'f', 'h'};
        char target = 'z';
        System.out.println(nextElement(arr, target));

    }
    public static char nextElement(char[] arr, char target){
        int start = 0;
        int end = arr.length - 1;
        char ans = arr[0];

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > target){
                ans = arr[mid];
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
