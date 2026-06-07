/*
Problem: Length of Last Word

Difficulty: Easy

Source: LeetCode 58

Description:
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal substring consisting of
non-space characters only.

Example 1:
Input:
"Hello World"

Output:
5

Example 2:
Input:
"   fly me   to   the moon  "

Output:
4

Example 3:
Input:
"luffy is still joyboy"

Output:
6

Pattern: String Traversal

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Start from the end of the string.
2. Skip trailing spaces.
3. Count characters until a space is found.
4. Return the count.
*/

import java.util.Scanner;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Length of Last Word: "
                + lengthOfLastWord(s));

        sc.close();
    }
}