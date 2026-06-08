/*
Problem: Find All Anagrams in a String

Difficulty: Medium

Source: LeetCode 438

Description:
Given two strings s and p, return an array of all
the start indices of p's anagrams in s.

You may return the answer in any order.

Example 1:
Input:
s = "cbaebabacd"
p = "abc"

Output:
[0, 6]

Example 2:
Input:
s = "abab"
p = "ab"

Output:
[0, 1, 2]

Pattern: Sliding Window + Frequency Count

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create frequency arrays for p and current window.
2. Fill both arrays for the first window.
3. Compare frequencies.
4. Slide the window one character at a time.
5. Add new character and remove old character.
6. If frequencies match, store the start index.
7. Return all matching indices.
*/

import java.util.*;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {

            windowCount[s.charAt(i) - 'a']++;

            windowCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string p: ");
        String p = sc.nextLine();

        List<Integer> result = findAnagrams(s, p);

        System.out.println("Anagram Indices: " + result);

        sc.close();
    }
}