/*
Problem: First Unique Character in a String

Difficulty: Easy

Source: LeetCode 387

Description:
Given a string s, find the first non-repeating character
in it and return its index.

If it does not exist, return -1.

Example 1:
Input:
s = "leetcode"

Output:
0

Example 2:
Input:
s = "loveleetcode"

Output:
2

Example 3:
Input:
s = "aabb"

Output:
-1

Pattern: Hashing / Frequency Counting

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Create a frequency array of size 26.
2. Traverse the string and count occurrences
   of each character.
3. Traverse the string again.
4. Return the index of the first character
   whose frequency is 1.
5. If no such character exists, return -1.
*/

import java.util.Scanner;

public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String s = sc.nextLine();
        int result = firstUniqChar(s);
        System.out.println("First Unique Character Index: " + result);
        sc.close();
    }
}