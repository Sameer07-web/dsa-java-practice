/*
Problem: Word Pattern

Difficulty: Easy

Source: LeetCode 290

Description:
Given a pattern and a string s, determine if s follows
the same pattern.

Here, follow means a full match such that there is a
bijection between a letter in pattern and a non-empty
word in s.

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

Pattern: HashMap / Bidirectional Mapping

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Split the string into words.
2. If the number of words is different from the pattern length,
   return false.
3. Maintain two HashMaps:
   - Character -> Word
   - Word -> Character
4. Traverse both simultaneously.
5. If either mapping is inconsistent,
   return false.
6. Otherwise, establish new mappings.
7. If all mappings remain valid,
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

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {

                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }

            } else {

                charToWord.put(ch, word);
            }

            if (wordToChar.containsKey(word)) {

                if (wordToChar.get(word) != ch) {
                    return false;
                }

            } else {

                wordToChar.put(word, ch);
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

        boolean result = wordPattern(pattern, s);

        System.out.println("Follows Pattern: " + result);

        sc.close();
    }
}