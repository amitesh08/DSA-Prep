package com.amitesh;

public class Power {
    public static void main(String[] args) {
        //Q. 50. Pow(x, n)
        double x = 2.00000; int n = 10;
        System.out.println(myPow(x,n));
    }
    static double myPow(double x , int n){
    /*
    IDEA:
    - We want to calculate x^n (x raised to the power n).
    - This can be solved recursively:
        x^n = x * x^(n-1)
    - But we must also handle:
        1. Base cases (n = 0, n = 1).
        2. Negative exponents (x^-n = 1 / x^n).

    APPROACH (Naïve Recursive):
    1. If n == 0 → return 1 (anything power 0 is 1).
    2. If n == 1 → return x (base case).
    3. If n < 0 → convert it to positive exponent and return reciprocal.
    4. Otherwise, → recursively compute x^(n-1) and multiply with x.

    LIMITATION:
    - This takes O(n) recursive calls, which is too slow for large n (like 10^9).
    - Better approach: "Exponentiation by Squaring" → reduces complexity to O(log n).
    */

        if (n == 0) return 1;  // base case: x^0 = 1
        if (n == 1) return x;  // base case: x^1 = x

        if (n < 0) {
            // for negative exponent, take reciprocal
            return 1 / myPow(x, -n);
        }

        // Recursive step: x^n = x * x^(n-1)
        double temp = myPow(x, n - 1);

        return x * temp;
    }
}
