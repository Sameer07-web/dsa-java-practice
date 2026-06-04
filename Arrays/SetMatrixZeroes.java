/*
Problem: Set Matrix Zeroes

Difficulty: Medium

Source: LeetCode 73

Description:
Given an m x n integer matrix, if an element is 0,
set its entire row and column to 0.

You must do it in-place.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]

Output:
[[1,0,1],
 [0,0,0],
 [1,0,1]]

Example 2:
Input:
[[0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]]

Output:
[[0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]]

Pattern: Matrix Manipulation

Time Complexity: O(m × n)
Space Complexity: O(1)

Approach:
1. Use first row and first column as markers.
2. Mark rows and columns that need to become zero.
3. Update matrix using markers.
4. Handle first row and first column separately.
*/

import java.util.Scanner;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
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
        setZeroes(matrix);
        System.out.println("Matrix after setting zeroes:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}