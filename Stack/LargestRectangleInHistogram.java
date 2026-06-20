/*
Problem: Largest Rectangle in Histogram

Difficulty: Hard

Source: LeetCode 84

Description:
Given an array of integers heights representing
the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:

Input:
[2,1,5,6,2,3]

Output:
10

Explanation:
Largest rectangle:
Height = 5
Width = 2

Area = 10

Example 2:

Input:
[2,4]

Output:
4

Pattern: Monotonic Increasing Stack

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Maintain an increasing stack of indices.
2. When a smaller height appears:
   - Pop taller bars.
   - Calculate area using popped height.
3. Width:
   - Current index - Previous Smaller Element - 1
4. Track maximum area.
5. Add a dummy height 0 at the end to process remaining bars.
*/

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight =
                    (i == n) ? 0 : heights[i];

            while (!stack.isEmpty()
                    && currentHeight <
                    heights[stack.peek()]) {

                int height =
                        heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {

                    width = i;

                } else {

                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(
                        maxArea,
                        height * width
                );
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter heights:");

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        System.out.println(
                "Largest Rectangle Area: "
                        + largestRectangleArea(heights));

        sc.close();
    }
}