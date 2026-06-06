/*
Problem: Ransom Note

Difficulty: Easy

Source: LeetCode 383

Description:
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed
by using the letters from magazine.

Each letter in magazine can only be used once.

Example 1:
Input:
ransomNote = "a"
magazine = "b"

Output:
false

Example 2:
Input:
ransomNote = "aa"
magazine = "ab"

Output:
false

Example 3:
Input:
ransomNote = "aa"
magazine = "aab"

Output:
true

Pattern: Hashing / Frequency Counting

Time Complexity: O(n + m)
Space Complexity: O(1)

Approach:
1. Create a frequency array of size 26.
2. Count all characters present in magazine.
3. Traverse ransomNote.
4. Decrease frequency for each required character.
5. If frequency becomes negative,
   return false.
6. Otherwise return true.
*/

import java.util.Scanner;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {

            count[ransomNote.charAt(i) - 'a']--;

            if (count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransom note: ");
        String ransomNote = sc.nextLine();

        System.out.print("Enter magazine: ");
        String magazine = sc.nextLine();

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println("Can Construct: " + result);

        sc.close();
    }
}