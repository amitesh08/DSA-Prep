package com.amitesh;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(isPowerOfTwo1(n));
        System.out.println(isPowerOfTwo(n));
    }
    //solution 1
    static boolean isPowerOfTwo1(int n) {
    /*
    IDEA:
    - A power of two has exactly one set bit in binary.
    - Example: 1 (0001), 2 (0010), 4 (0100), 8 (1000).

    APPROACH:
    1. If n <= 0 → return false (powers of two are positive only).
    2. Count the number of set bits (1s) in n.
    3. If exactly one set bit → return true, else false.

    TIME COMPLEXITY: O(log n) (loop goes through bits).
    SPACE COMPLEXITY: O(1).
    */
        if (n <= 0) return false;

        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) { // check last bit
                count++;
            }
            n = n >> 1; // right shift to check next bit
        }
        return count == 1;
    }
    static boolean isPowerOfTwo(int n) {
    /*
    IDEA:
    - A number is a power of two if it has exactly one set bit (1) in its binary form.
      Example:
        1 -> 0001
        2 -> 0010
        4 -> 0100
        8 -> 1000
      Each of these has only one '1'.

    TRICK:
    - For any power of two `n`, if you subtract 1 (`n - 1`), all the bits after that single '1'
      become 1s, and the original set bit becomes 0.
      Example:
        n = 8  -> 1000
        n-1= 7 -> 0111
        ----------------
        n & (n-1) = 1000 & 0111 = 0000

    - For numbers that are NOT powers of two, `n & (n-1)` will NOT be zero because
      there are multiple 1s.
      Example:
        n = 10 -> 1010
        n-1= 9 -> 1001
        ----------------
        n & (n-1) = 1010 & 1001 = 1000 (≠ 0)

    APPROACH:
    1. First check if n > 0 (powers of two must be positive).
    2. Then check (n & (n - 1)) == 0.
       - If true -> n has exactly one set bit -> power of two.
       - If false -> not a power of two.

    TIME COMPLEXITY: O(1) (just one bitwise operation).
    SPACE COMPLEXITY: O(1).
    */

        return n > 0 && (n & (n - 1)) == 0;
    }

}
