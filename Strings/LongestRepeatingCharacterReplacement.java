/*
Problem: Longest Repeating Character Replacement

Difficulty: Medium

Source: LeetCode 424

Description:
You are given a string s and an integer k.

You can choose any character of the string and
change it to any other uppercase English character
at most k times.

Return the length of the longest substring containing
the same letter after performing at most k replacements.

Example 1:
Input:
s = "ABAB"
k = 2

Output:
4

Explanation:
Replace both 'B' characters with 'A'.

Example 2:
Input:
s = "AABABBA"
k = 1

Output:
4

Pattern: Sliding Window

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Maintain a sliding window.
2. Track frequency of characters inside the window.
3. Keep record of the most frequent character.
4. If replacements needed exceed k:
   shrink the window.
5. Update maximum window length.
6. Return the longest valid window.
*/

import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(
                    maxFreq,
                    freq[s.charAt(right) - 'A']
            );

            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;

                left++;
            }

            maxLength = Math.max(
                    maxLength,
                    right - left + 1
            );
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Longest Length: "
                + characterReplacement(s, k));

        sc.close();
    }
}