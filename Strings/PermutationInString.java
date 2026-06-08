/*
Problem: Permutation in String

Difficulty: Medium

Source: LeetCode 567

Description:
Given two strings s1 and s2, return true if s2
contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's
permutations is a substring of s2.

Example 1:
Input:
s1 = "ab"
s2 = "eidbaooo"

Output:
true

Explanation:
"ba" is a permutation of "ab".

Example 2:
Input:
s1 = "ab"
s2 = "eidboaoo"

Output:
false

Pattern: Sliding Window + Frequency Count

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create frequency arrays for s1 and current window.
2. Fill both arrays for the first window.
3. Compare frequencies.
4. Slide the window through s2.
5. Add new character and remove old character.
6. If frequencies match, return true.
7. If no match is found, return false.
*/

import java.util.Arrays;
import java.util.Scanner;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {

            windowCount[s2.charAt(i) - 'a']++;

            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s1: ");
        String s1 = sc.nextLine();

        System.out.print("Enter string s2: ");
        String s2 = sc.nextLine();

        System.out.println("Contains Permutation: "
                + checkInclusion(s1, s2));

        sc.close();
    }
}