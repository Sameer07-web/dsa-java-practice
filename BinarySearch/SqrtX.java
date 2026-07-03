/*
Problem: Sqrt(x)

Difficulty: Easy

Source: LeetCode 69

Description:
Given a non-negative integer x, return the square root of x
rounded down to the nearest integer.

The returned integer should be non-negative.

You must not use any built-in exponent function or operator,
such as pow(x, 0.5) or sqrt(x).

Example 1:

Input:
x = 4

Output:
2

Example 2:

Input:
x = 8

Output:
2

Explanation:
The square root of 8 is 2.82842...
Since the decimal part is truncated,
the result is 2.

Pattern: Binary Search on Numbers

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Handle the base case:
   - If x < 2, return x.
2. Perform Binary Search on the range [1, x].
3. Calculate:
   - mid
   - square = mid * mid
4. If square == x, return mid.
5. If square < x, search the right half.
6. Otherwise, search the left half.
7. When the loop ends, right stores the integer square root.
*/

import java.util.Scanner;

public class SqrtX {

    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            }

            if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int x = sc.nextInt();

        int result = mySqrt(x);

        System.out.println("Integer Square Root: " + result);

        sc.close();
    }
}