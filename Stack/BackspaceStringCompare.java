/*
Problem: Backspace String Compare

Difficulty: Easy

Source: LeetCode 844

Description:
Given two strings s and t, return true if they are equal
when both are typed into empty text editors.

'#' means a backspace character.

Note:
After processing all backspaces, compare the final strings.

Example 1:
Input:
s = "ab#c"
t = "ad#c"

Output:
true

Explanation:
s -> "ac"
t -> "ac"

Example 2:
Input:
s = "ab##"
t = "c#d#"

Output:
true

Example 3:
Input:
s = "a#c"
t = "b"

Output:
false

Pattern: Stack Simulation / String Processing

Time Complexity: O(n + m)

Space Complexity: O(n + m)

Approach:
1. Use a stack for each string.
2. Traverse characters:
   - Normal character -> Push
   - '#' -> Pop previous character if available
3. Build final processed strings.
4. Compare both processed strings.
5. Return true if equal.
*/

import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        return buildString(s).equals(buildString(t));
    }

    private static String buildString(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch != '#') {

                stack.push(ch);

            } else if (!stack.isEmpty()) {

                stack.pop();
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

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        System.out.println("Result: "
                + backspaceCompare(s, t));

        sc.close();
    }
}