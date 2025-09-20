package com.amitesh;

public class Fibonacci {
    public static void main(String[] args) {
        //Q. 509. Fibonacci Number
        int n = 50;
        System.out.println(fib(n));
    }
    static int fib(int n){
        /*
        -not optimal as it is getting stuck for just a small number 50 cause it making
        repeated function calls. that makes it more long.
         */
        if(n < 2) return n;

        return fib(n-1) + fib(n-2);
    }
}
