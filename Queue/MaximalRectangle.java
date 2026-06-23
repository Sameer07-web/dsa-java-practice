/*
Problem: Maximal Rectangle

Difficulty: Hard

Source: LeetCode 85

Description:
Given a rows x cols binary matrix filled with '0's and '1's,
find the largest rectangle containing only '1's and return its area.

Example 1:

Input:
[
 ['1','0','1','0','0'],
 ['1','0','1','1','1'],
 ['1','1','1','1','1'],
 ['1','0','0','1','0']
]

Output:
6

Explanation:
The largest rectangle contains only 1's and has area = 6.

Example 2:

Input:
[['0']]

Output:
0

Example 3:

Input:
[['1']]

Output:
1

Pattern: Monotonic Stack + Histogram

Time Complexity: O(rows × cols)

Space Complexity: O(cols)

Approach:
1. Treat each row as the base of a histogram.
2. Build a heights array:
   - If current cell is '1', increment height.
   - Otherwise, reset height to 0.
3. For each row, find the largest rectangle in the histogram.
4. Use the Largest Rectangle in Histogram algorithm.
5. Track the maximum area across all rows.
*/

import java.util.Scanner;
import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea,
                    largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight =
                    (i == n) ? 0 : heights[i];

            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea,
                        height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        char[][] matrix = new char[rows][cols];

        System.out.println("Enter matrix elements (0 or 1):");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = sc.next().charAt(0);
            }
        }

        int result = maximalRectangle(matrix);

        System.out.println("Maximum Rectangle Area: " + result);

        sc.close();
    }
}