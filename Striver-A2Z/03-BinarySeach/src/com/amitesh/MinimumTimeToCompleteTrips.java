package com.amitesh;

public class MinimumTimeToCompleteTrips {
    public static void main(String[] args) {
        //Q. 2187. Minimum Time to Complete Trips
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }
    public static long minimumTime(int[] time, int totalTrips){
        /*
    IDEA:
    - We have multiple buses, each bus takes some fixed time to complete ONE trip.
      Example: if bus[i] = 3 → it takes 3 units of time for that bus to finish one trip,
      so in 10 units of time, it can complete 10/3 = 3 trips.
    - We want the MINIMUM time in which all buses together can complete at least `totalTrips`.

    - This is a "minimum value search" problem → Binary Search on Answer.

    APPROACH:
    1. Search space for time:
       - Minimum time = 1 (at least 1 unit of time needed).
       - Maximum time = min(time) * totalTrips
         (because the fastest bus doing all trips alone is the worst-case upper bound).

    2. Use Binary Search:
       - midTime = (left + right) / 2.
       - Check if it's possible to complete `totalTrips` within midTime using helper function.

    3. Helper function canCompleteTrip():
       - For each bus time[i], trips it can do = midTime / time[i].
       - Sum up trips from all buses.
       - If total trips ≥ required trips → possible, else not.

    4. Adjust search:
       - If possible in midTime → shrink right = midTime (try smaller time).
       - If not possible → move left = midTime + 1 (need more time).

    5. At the end, left will be the minimum time.

    TIME COMPLEXITY: O(n log (minTime * totalTrips))
    SPACE COMPLEXITY: O(1)
    */

        long left = 1;

        // Find the minimum bus time (fastest bus)
        long minBusTime = Integer.MAX_VALUE;
        for (int t : time) {
            minBusTime = Math.min(minBusTime, t);
        }

        // Maximum possible time: fastest bus doing all trips
        long right = minBusTime * totalTrips;

        // Binary search
        while (left < right) {
            long midTime = left + (right - left) / 2;

            if (canCompleteTrip(time, totalTrips, midTime)) {
                right = midTime; // try smaller time
            } else {
                left = midTime + 1; // need more time
            }
        }

        return left;
    }

    public static boolean canCompleteTrip(int[] time, int totalTrips, long midTime) {
        long tripCount = 0;

        for (int t : time) {
            tripCount += midTime / t; // trips completed by this bus
            if (tripCount >= totalTrips) {
                return true; // early exit if already enough trips
            }
        }
        return tripCount >= totalTrips;
    }
}
