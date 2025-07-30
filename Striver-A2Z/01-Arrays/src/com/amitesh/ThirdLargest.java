package com.amitesh;

public class ThirdLargest {
    public static void main(String[] args) {
        int [] arr = {2, 3, 4, 9, 0, 1, 5};
        int res = thirdLargestElement(arr);
        System.out.println(res);
    }

    private static int thirdLargestElement(int[] arr) {
        // Your code here
        int n = arr.length;

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE,
                third = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // If arr[i] is greater than first,
            // set third to second, second to
            // first and first to arr[i].
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            // If arr[i] is greater than second,
            // set third to second and second
            // to arr[i].
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            }

            // If arr[i] is greater than third,
            // set third to arr[i].
            else if (arr[i] > third) {
                third = arr[i];
            }
        }

        // Return the third largest element
        return third;
    }
}
