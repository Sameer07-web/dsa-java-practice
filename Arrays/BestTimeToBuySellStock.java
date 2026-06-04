/*
Problem: Best Time To Buy And Sell Stock

Difficulty: Easy

Source: LeetCode 121

Description:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5

Explanation:
Buy on day 2 (price = 1) and sell on day 5 (price = 6).
Profit = 6 - 1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0

Explanation:
No profitable transaction exists.

Pattern: Running Minimum

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Assume the first stock price as the minimum price.
2. Traverse the array from left to right.
3. Update minimum price whenever a smaller value is found.
4. Calculate profit by selling on the current day.
5. Update maximum profit if current profit is greater.
6. Return the maximum profit obtained.
*/

import java.util.Scanner;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        
        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        System.out.println("Maximum Profit: " + maxProfit);
        sc.close();
    }
}