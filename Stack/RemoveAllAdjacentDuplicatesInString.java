/*
Problem: Remove All Adjacent Duplicates In String

Difficulty: Easy

Source: LeetCode 1047

Description:
You are given a string consisting of lowercase English letters.

A duplicate removal consists of choosing two adjacent and equal
letters and removing them.

Continue removing duplicates until no adjacent duplicates remain.

Return the final string after all such removals.

Example 1:

Input:
abbaca

Output:
ca

Explanation:
abbaca
→ aaca
→ ca

Example 2:

Input:
azxxzy

Output:
ay

Pattern: Stack / String Processing

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Traverse each character of the string.
2. If current character matches stack top:
   - Remove duplicate using pop().
3. Otherwise:
   - Push character into stack.
4. Build result from remaining stack characters.
5. Reverse and return the final string.
*/

import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() &&
                    stack.peek() == ch) {

                stack.pop();

            } else {

                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Result: "
                + removeDuplicates(s));

        sc.close();
    }
}