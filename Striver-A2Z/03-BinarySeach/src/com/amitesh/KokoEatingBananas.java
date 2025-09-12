package com.amitesh;

public class KokoEatingBananas {
    public static void main(String[] args) {
        //Q. 875. Koko Eating Bananas
        int[] piles = {3, 6, 7, 11};
        int hrs = 8;
        System.out.println(minEatingSpeed(piles, hrs));
    }
    public static int minEatingSpeed(int[] piles, int hrs) {
        /*
    IDEA:
        - Koko can choose a speed (bananas per hour).
        - If she eats too slow → not enough hours to finish all bananas.
        - If she eats too fast → she finishes, but we want the MINIMUM speed.
        - This is a "Binary Search on Answer" problem.

    APPROACH:
        1. The search space for eating speed:
           - Minimum = 1 (slowest possible speed).
           - Maximum = max(piles) (if Koko eats an entire largest pile in 1 hour).

        2. Binary Search:
           - mid = (left + right) / 2 → candidate eating speed.
           - Check if Koko can finish all piles at this speed within given hrs.

        3. Helper function canEatAll():
           - For each pile:
             - Hours required = ceil(pile / speed).
             - Add all hours.
           - If total hours <= hrs → possible.

        4. Adjust search:
           - If possible at mid → try smaller speed (right = mid).
           - If not possible → need faster speed (left = mid + 1).

        5. At the end, left = minimum eating speed.

    TIME COMPLEXITY: O(n log(maxPile))
    SPACE COMPLEXITY: O(1)
    */

        int left = 1;
        int maxPile = Integer.MIN_VALUE;

        // Find the largest pile (max eating speed needed)
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int right = maxPile;

        // Binary search for min eating speed
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, hrs)) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need faster speed
            }
        }
        return left;
    }

    // Helper function: check if Koko can eat all bananas at speed `speed`
    public static boolean canEatAll(int[] piles, int speed, int hrs) {
        int hoursNeeded = 0;

        for (int pile : piles) {
            // Equivalent to ceil(pile / speed)
            hoursNeeded += pile / speed;
            if (pile % speed != 0) {
                hoursNeeded++;
            }
        }

        return hoursNeeded <= hrs;
    }
}
