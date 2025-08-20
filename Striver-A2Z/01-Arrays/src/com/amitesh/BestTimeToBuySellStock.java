package com.amitesh;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        //Q. 121. Best Time to Buy and Sell Stock
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        /*
        Problem:
        You are given an array `prices[]` where prices[i] = price of stock on day i.
        You want to maximize your profit by choosing a single day to buy and
        another later day to sell. Return the maximum profit.
        If no profit can be made, return 0.

        Idea:
        - To maximize profit, we must buy at the lowest price before a higher price appears.
        - Keep track of the minimum price seen so far and calculate potential profit at each step.
        - Update the maximum profit whenever we find a better profit.

        Approach:
        1. Initialize `min` as the first day's price (lowest so far).
        2. Iterate through the array:
           - Calculate profit if selling today (`prices[i] - min`).
           - Update maxProfit if this profit is higher.
           - Update min if today’s price is lower than current min.
        3. Return maxProfit (0 if no profit possible).

        Complexity:
        - Time: O(n) → one pass through the array.
        - Space: O(1) → constant space.
    */

        int min = prices[0];        // Minimum price so far
        int maxProfit = 0;          // Maximum profit found

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;             // Profit if we sell today
            maxProfit = Math.max(maxProfit, cost);  // Update maximum profit
            min = Math.min(min, prices[i]);         // Update minimum buying price
        }

        return maxProfit;
    }
}
