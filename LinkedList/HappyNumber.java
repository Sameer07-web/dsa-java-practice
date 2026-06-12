/*
Problem: Happy Number

Difficulty: Easy

Source: LeetCode 202

Description:
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

1. Starting with any positive integer, replace the number
   by the sum of the squares of its digits.
2. Repeat the process until the number equals 1.
3. If it ends in 1, the number is happy.
4. If it enters a cycle that does not include 1,
   the number is not happy.

Return true if n is a happy number, otherwise false.

Example 1:
Input:
19

Output:
true

Explanation:
19 -> 82 -> 68 -> 100 -> 1

Example 2:
Input:
2

Output:
false

Pattern: Fast & Slow Pointers (Cycle Detection)

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Create a helper function to calculate the sum of squares
   of digits.
2. Use slow and fast pointers.
3. Slow moves one transformation at a time.
4. Fast moves two transformations at a time.
5. If they meet at 1, the number is happy.
6. Otherwise, a cycle exists and the number is not happy.
*/

import java.util.Scanner;

public class HappyNumber {

    public static int getNext(int num) {

        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));

        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Is Happy Number: " + isHappy(n));

        sc.close();
    }
}