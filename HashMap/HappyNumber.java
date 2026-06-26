/*
Problem: Happy Number

Difficulty: Easy

Source: LeetCode 202

Description:
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

1. Starting with any positive integer, replace the number
   by the sum of the squares of its digits.
2. Repeat the process until the number equals 1,
   or it loops endlessly in a cycle that does not include 1.
3. Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

Example 1:

Input:
n = 19

Output:
true

Explanation:
19 -> 82
82 -> 68
68 -> 100
100 -> 1

Example 2:

Input:
n = 2

Output:
false

Pattern: HashSet / Cycle Detection / Math

Time Complexity: O(log n)

Space Complexity: O(log n)

Approach:
1. Create a HashSet to store previously seen numbers.
2. Repeatedly calculate the sum of squares of digits.
3. If the number becomes 1:
   - Return true.
4. If the number repeats:
   - A cycle exists, return false.
*/

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {

    public static boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {

            set.add(n);
            n = getNextNumber(n);
        }

        return n == 1;
    }

    private static int getNextNumber(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean result = isHappy(n);

        System.out.println("Is Happy Number: " + result);

        sc.close();
    }
}