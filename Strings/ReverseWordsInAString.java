/*
Problem: Reverse Words in a String

Difficulty: Medium

Source: LeetCode 151

Description:
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters.

The returned string should only have a single space
separating the words and no leading or trailing spaces.

Example 1:
Input:
"the sky is blue"

Output:
"blue is sky the"

Example 2:
Input:
"  hello world  "

Output:
"world hello"

Example 3:
Input:
"a good   example"

Output:
"example good a"

Pattern: String Manipulation

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Remove leading and trailing spaces using trim().
2. Split the string using one or more spaces.
3. Traverse words array from end to beginning.
4. Append words into StringBuilder.
5. Add space between words.
6. Return final reversed string.
*/

import java.util.Scanner;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Reversed Words: " + reverseWords(s));

        sc.close();
    }
}