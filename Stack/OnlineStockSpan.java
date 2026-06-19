/*
Problem: Online Stock Span

Difficulty: Medium

Source: LeetCode 901

Description:
Design an algorithm that collects daily stock prices
and returns the span of the stock's price for the current day.

The span of the stock's price today is defined as the
maximum number of consecutive days (starting from today
and going backward) for which the stock price was less
than or equal to today's price.

Example:

Input:
100
80
60
70
60
75
85

Output:
1
1
1
2
1
4
6

Pattern: Monotonic Decreasing Stack

Time Complexity:
next() -> O(1) amortized

Space Complexity: O(n)

Approach:
1. Maintain a decreasing stack.
2. Store:
   - stock price
   - span
3. Remove all smaller or equal prices.
4. Merge their spans.
5. Push current price and span.
6. Return span.
*/

import java.util.Scanner;
import java.util.Stack;

public class OnlineStockSpan {

    static class StockSpanner {

        private Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {

            int span = 1;

            while (!stack.isEmpty()
                    && stack.peek()[0] <= price) {

                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});

            return span;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockSpanner stockSpanner =
                new StockSpanner();

        System.out.print("Enter number of prices: ");
        int n = sc.nextInt();

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {

            int price = sc.nextInt();

            System.out.println(
                    "Span: "
                    + stockSpanner.next(price));
        }

        sc.close();
    }
}