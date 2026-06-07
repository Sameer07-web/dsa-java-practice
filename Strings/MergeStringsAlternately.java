/*
Problem: Merge Strings Alternately

Difficulty: Easy

Source: LeetCode 1768

Description:
You are given two strings word1 and word2.

Merge the strings by adding letters in alternating order,
starting with word1.

If one string is longer than the other,
append the additional letters onto the end.

Return the merged string.

Example 1:
Input:
word1 = "abc"
word2 = "pqr"

Output:
"apbqcr"

Example 2:
Input:
word1 = "ab"
word2 = "pqrs"

Output:
"apbqrs"

Example 3:
Input:
word1 = "abcd"
word2 = "pq"

Output:
"apbqcd"

Pattern: Two Pointers / String Traversal

Time Complexity: O(n + m)

Space Complexity: O(n + m)

Approach:
1. Create a StringBuilder.
2. Traverse both strings simultaneously.
3. Append one character from word1.
4. Append one character from word2.
5. If one string remains,
   append the remaining characters.
6. Return the final merged string.
*/

import java.util.Scanner;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {

            result.append(word1.charAt(i));
            result.append(word2.charAt(j));

            i++;
            j++;
        }

        while (i < word1.length()) {
            result.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String word1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String word2 = sc.nextLine();

        System.out.println("Merged String: "
                + mergeAlternately(word1, word2));

        sc.close();
    }
}