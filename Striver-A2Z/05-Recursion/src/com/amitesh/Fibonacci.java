package com.amitesh;

public class Fibonacci {
    public static void main(String[] args) {
        //Q. 509. Fibonacci Number
        int n = 50;
        System.out.println(fiboFormula(n));
    }
    static int fib(int n){
        /*
        -not optimal as it is getting stuck for just a small number 50 cause it making
        repeated function calls. that makes it more long.
         */
        if(n < 2) return n;

        return fib(n-1) + fib(n-2);
    }
    static long fiboFormula(int n){
        // just for demo , use long instead.
        long i = (long) (Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
        return i;
    }
}
