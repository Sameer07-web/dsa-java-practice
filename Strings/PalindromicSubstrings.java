/*
Problem: Palindromic Substrings

Difficulty: Medium

Source: LeetCode 647

Description:
Given a string s, return the number of palindromic
substrings in it.

A string is a palindrome if it reads the same
forward and backward.

A substring is a contiguous sequence of characters.

Example 1:
Input:
s = "abc"

Output:
3

Explanation:
"a", "b", "c"

Example 2:
Input:
s = "aaa"

Output:
6

Explanation:
"a", "a", "a", "aa", "aa", "aaa"

Pattern: Expand Around Center

Time Complexity: O(n²)

Space Complexity: O(1)

Approach:
1. Treat every character as a center.
2. Expand for odd length palindromes.
3. Expand for even length palindromes.
4. Count every valid palindrome found.
5. Return total count.
*/

import java.util.Scanner;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            count += expand(s, i, i);

            count += expand(s, i, i + 1);
        }

        return count;
    }

    public static int expand(String s, int left, int right) {

        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Palindromic Substrings Count: "
                + countSubstrings(s));

        sc.close();
    }
}