/*
Problem: Minimum Window Substring

Difficulty: Hard

Source: LeetCode 76

Description:
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every
character in t (including duplicates) is included in the window.

If there is no such substring, return an empty string "".

Example 1:
Input:
s = "ADOBECODEBANC"
t = "ABC"

Output:
"BANC"

Example 2:
Input:
s = "a"
t = "a"

Output:
"a"

Example 3:
Input:
s = "a"
t = "aa"

Output:
""

Pattern: Variable Size Sliding Window

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Store frequency of characters in t.
2. Expand window using right pointer.
3. Decrease required count when matching characters found.
4. When all characters are matched:
   - Try shrinking window from left.
   - Update minimum window length.
5. Continue until entire string is processed.
6. Return the smallest valid window.
*/

import java.util.Scanner;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        for (char ch : t.toCharArray()) {
            count[ch]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char current = s.charAt(right);

            if (count[current] > 0) {
                required--;
            }

            count[current]--;
            right++;

            while (required == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                count[leftChar]++;

                if (count[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string t: ");
        String t = sc.nextLine();

        System.out.println("Minimum Window: "
                + minWindow(s, t));

        sc.close();
    }
}