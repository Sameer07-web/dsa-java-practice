/*
Problem: Search a 2D Matrix

Difficulty: Medium

Source: LeetCode 74

Description:
You are given an m x n integer matrix with the following properties:

1. Each row is sorted in non-decreasing order.
2. The first integer of each row is greater than the last integer
   of the previous row.

Given an integer target, return true if target exists in the matrix,
otherwise return false.

You must write an algorithm with O(log(m × n)) runtime complexity.

Example 1:

Input:
matrix =
[
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
]

target = 3

Output:
true

Example 2:

Input:
matrix =
[
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
]

target = 13

Output:
false

Pattern: Binary Search + 2D Matrix

Time Complexity: O(log(m × n))

Space Complexity: O(1)

Approach:
1. Treat the matrix as a single sorted array.
2. Initialize:
   - left = 0
   - right = rows × cols - 1
3. Perform Binary Search.
4. Convert the 1D index into 2D coordinates:
   - row = mid / cols
   - col = mid % cols
5. Compare the value with the target.
6. Search the appropriate half.
7. Return true if found, otherwise false.
*/

import java.util.Scanner;

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int value = matrix[mid / cols][mid % cols];

            if (value == target) {
                return true;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        boolean result = searchMatrix(matrix, target);

        System.out.println("Target Found: " + result);

        sc.close();
    }
}