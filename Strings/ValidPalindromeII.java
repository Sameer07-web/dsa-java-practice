/*
Problem: Valid Palindrome II

Difficulty: Easy

Source: LeetCode 680

Description:
Given a string s, return true if the string can be
a palindrome after deleting at most one character.

Example 1:
Input:
s = "aba"

Output:
true

Example 2:
Input:
s = "abca"

Output:
true

Explanation:
Delete 'c' to get "aba".

Example 3:
Input:
s = "abc"

Output:
false

Pattern: Two Pointers + Greedy

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Use two pointers:
   left and right.
2. Compare characters from both ends.
3. If mismatch occurs:
   - Skip left character and check palindrome.
   - Skip right character and check palindrome.
4. If either check succeeds,
   return true.
5. Otherwise return false.
*/

import java.util.Scanner;

public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome(String s,
                                       int left,
                                       int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Valid Palindrome II: "
                + validPalindrome(s));

        sc.close();
    }
}