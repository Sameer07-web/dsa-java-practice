/*
Problem: Longest Substring Without Repeating Characters

Difficulty: Medium

Source: LeetCode 3

Description:
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:
Input:
"abcabcbb"

Output:
3

Explanation:
The answer is "abc", with length 3.

Example 2:
Input:
"bbbbb"

Output:
1

Explanation:
The answer is "b", with length 1.

Example 3:
Input:
"pwwkew"

Output:
3

Explanation:
The answer is "wke", with length 3.

Pattern: Sliding Window

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a HashSet to store characters in current window.
2. Maintain two pointers:
   left and right.
3. Expand right pointer.
4. If duplicate character appears:
   remove characters from left side
   until duplicate is removed.
5. Update maximum window length.
6. Return maximum length.
*/

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.nextLine();

        System.out.println(
                "Length of Longest Substring: "
                + lengthOfLongestSubstring(s));

        sc.close();
    }
}