/*
Problem: Valid Anagram

Difficulty: Easy

Source: LeetCode 242

Description:
Given two strings s and t, return true if t is an
anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging
the letters of a different word or phrase, using all
the original letters exactly once.

Example 1:
Input:
s = "anagram"
t = "nagaram"

Output:
true

Example 2:
Input:
s = "rat"
t = "car"

Output:
false

Pattern: Hashing / Frequency Counting

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. If lengths are different,
   return false.

2. Create a frequency array of size 26.

3. Traverse both strings together.
   - Increment count for characters in s.
   - Decrement count for characters in t.

4. If every frequency becomes zero,
   both strings contain the same characters.

5. Return true, otherwise false.
*/

import java.util.Scanner;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s = sc.nextLine();
        System.out.print("Enter second string: ");
        String t = sc.nextLine();
        boolean result = isAnagram(s, t);
        System.out.println("Is Anagram: " + result);
        sc.close();
    }
}