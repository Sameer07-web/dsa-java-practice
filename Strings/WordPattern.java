/*
Problem: Word Pattern

Difficulty: Easy

Source: LeetCode 290

Description:
Given a pattern and a string s, find if s follows
the same pattern.

A pattern means a full match where each character
in the pattern maps to exactly one word and no two
characters map to the same word.

Example 1:
Input:
pattern = "abba"
s = "dog cat cat dog"

Output:
true

Example 2:
Input:
pattern = "abba"
s = "dog cat cat fish"

Output:
false

Example 3:
Input:
pattern = "aaaa"
s = "dog cat cat dog"

Output:
false

Pattern: HashMap

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
1. Split the string into words.
2. If pattern length and word count differ,
   return false.
3. Create a HashMap<Character, String>.
4. Traverse pattern and words together.
5. If mapping exists, verify it matches.
6. If mapping does not exist:
   - Ensure word is not already mapped.
   - Store the mapping.
7. If all mappings are valid,
   return true.
*/

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {

                if (!map.get(ch).equals(word)) {
                    return false;
                }

            } else {

                if (map.containsValue(word)) {
                    return false;
                }

                map.put(ch, word);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Follows Pattern: " + wordPattern(pattern, s));

        sc.close();
    }
}