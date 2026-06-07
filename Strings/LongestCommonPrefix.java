/*
Problem: Longest Common Prefix

Difficulty: Easy

Source: LeetCode 14

Description:
Write a function to find the longest common prefix
string amongst an array of strings.

If there is no common prefix,
return an empty string "".

Example 1:
Input:
["flower","flow","flight"]

Output:
"fl"

Example 2:
Input:
["dog","racecar","car"]

Output:
""

Pattern: String Traversal

Time Complexity: O(n × m)

n = number of strings
m = length of prefix

Space Complexity: O(1)

Approach:
1. Assume first string as prefix.
2. Compare prefix with every other string.
3. If current string does not start with prefix:
   - Remove last character from prefix.
4. Repeat until prefix matches.
5. If prefix becomes empty, return "".
6. Return final prefix.
*/

import java.util.Scanner;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n];

        System.out.println("Enter strings:");

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        System.out.println("Longest Common Prefix: "
                + longestCommonPrefix(strs));

        sc.close();
    }
}