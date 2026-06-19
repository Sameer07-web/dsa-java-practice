/*
Problem: Daily Temperatures

Difficulty: Medium

Source: LeetCode 739

Description:
Given an array of integers temperatures represents the daily
temperatures, return an array answer such that:

answer[i] is the number of days you have to wait after the
i-th day to get a warmer temperature.

If there is no future day for which this is possible,
keep answer[i] = 0.

Example 1:

Input:
[73,74,75,71,69,72,76,73]

Output:
[1,1,4,2,1,1,0,0]

Example 2:

Input:
[30,40,50,60]

Output:
[1,1,1,0]

Example 3:

Input:
[30,60,90]

Output:
[1,1,0]

Pattern: Monotonic Decreasing Stack

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Store indices in the stack.
2. Maintain a decreasing temperature stack.
3. When a warmer day is found:
   - Pop previous colder days.
   - Calculate waiting days.
4. Push current index into the stack.
5. Remaining indices have no warmer future day.
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && temperatures[i] >
                    temperatures[stack.peek()]) {

                int index = stack.pop();

                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] temperatures = new int[n];

        System.out.println("Enter temperatures:");

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        int[] result =
                dailyTemperatures(temperatures);

        System.out.println("Result: "
                + Arrays.toString(result));

        sc.close();
    }
}