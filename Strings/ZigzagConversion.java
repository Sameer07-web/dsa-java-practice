/*
Problem: Zigzag Conversion

Difficulty: Medium

Source: LeetCode 6

Description:
The string is written in a zigzag pattern on a given
number of rows and then read row by row.

Return the converted string.

Example 1:
Input:
s = "PAYPALISHIRING"
numRows = 3

Output:
"PAHNAPLSIIGYIR"

Example 2:
Input:
s = "PAYPALISHIRING"
numRows = 4

Output:
"PINALSIGYAHRPI"

Example 3:
Input:
s = "A"
numRows = 1

Output:
"A"

Pattern: Simulation / String Manipulation

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Create StringBuilder for each row.
2. Traverse characters of the string.
3. Move downward and upward across rows.
4. Append characters to corresponding rows.
5. Combine all rows and return the result.
*/

import java.util.Scanner;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            if (currentRow == 0 ||
                currentRow == numRows - 1) {

                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        System.out.println("Converted String: "
                + convert(s, numRows));

        sc.close();
    }
}