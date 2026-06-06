/*
Problem: Isomorphic Strings

Difficulty: Easy

Source: LeetCode 205

Description:
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can
be replaced to get t.

All occurrences of a character must be replaced with
another character while preserving the order of characters.

No two characters may map to the same character.

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

Pattern: HashMap

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Create a HashMap to store character mappings.
2. Traverse both strings together.
3. If mapping exists, verify it matches.
4. If mapping does not exist:
   - Ensure target character is not already mapped.
   - Store the new mapping.
5. If all mappings are valid, return true.
*/

import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {

                if (map.get(ch1) != ch2) {
                    return false;
                }

            } else {

                if (map.containsValue(ch2)) {
                    return false;
                }

                map.put(ch1, ch2);
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

        System.out.println("Is Isomorphic: " + isIsomorphic(s, t));

        sc.close();
    }
}