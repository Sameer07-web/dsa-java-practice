/*
Problem: Isomorphic Strings

Difficulty: Easy

Source: LeetCode 205

Description:
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be
replaced to get t.

All occurrences of a character must be replaced with another
character while preserving the order of characters.

No two characters may map to the same character, but a
character may map to itself.

Example 1:

Input:
s = "egg"
t = "add"

Output:
true

Example 2:

Input:
s = "foo"
t = "bar"

Output:
false

Example 3:

Input:
s = "paper"
t = "title"

Output:
true

Pattern: HashMap / Character Mapping

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. If the lengths of the strings are different,
   return false.
2. Maintain two mapping arrays:
   - One for characters in s.
   - One for characters in t.
3. Traverse both strings simultaneously.
4. If previous mapping positions differ,
   return false.
5. Update both mappings with the current position.
6. If traversal completes, return true.
*/

import java.util.Scanner;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapS[chS] != mapT[chT]) {
                return false;
            }

            mapS[chS] = i + 1;
            mapT[chT] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = isIsomorphic(s, t);

        System.out.println("Is Isomorphic: " + result);

        sc.close();
    }
}