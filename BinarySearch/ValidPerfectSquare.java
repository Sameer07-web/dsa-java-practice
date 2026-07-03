/*
Problem: Valid Perfect Square

Difficulty: Easy

Source: LeetCode 367

Description:
Given a positive integer num, return true if num is a
perfect square or false otherwise.

Do not use any built-in library function such as sqrt().

Example 1:

Input:
num = 16

Output:
true

Example 2:

Input:
num = 14

Output:
false

Pattern: Binary Search on Numbers

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Handle the special case when num == 1.
2. Perform Binary Search on the range [1, num].
3. Calculate:
   - mid
   - square = mid * mid
4. If square == num, return true.
5. If square < num, search the right half.
6. Otherwise, search the left half.
7. If no perfect square is found, return false.
*/

import java.util.Scanner;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        long left = 1;
        long right = num;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            long square = mid * mid;

            if (square == num) {
                return true;
            }

            if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        boolean result = isPerfectSquare(num);

        System.out.println("Is Perfect Square: " + result);

        sc.close();
    }
}