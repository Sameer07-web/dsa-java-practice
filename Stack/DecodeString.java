/*
Problem: Decode String

Difficulty: Medium

Source: LeetCode 394

Description:
Given an encoded string, return its decoded string.

Encoding Rule:
k[encoded_string]

The encoded_string inside the square brackets is repeated
exactly k times.

You may assume:
- Input is always valid.
- No extra white spaces.
- Digits only represent repeat counts.

Example 1:

Input:
3[a]2[bc]

Output:
aaabcbc

Example 2:

Input:
3[a2[c]]

Output:
accaccacc

Example 3:

Input:
2[abc]3[cd]ef

Output:
abcabccdcdcdef

Pattern: Stack / Nested String Processing

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use one stack for repeat counts.
2. Use another stack for previous strings.
3. When '[' appears:
   - Store current number.
   - Store current string.
4. When ']' appears:
   - Repeat current substring.
   - Append it to previous string.
5. Return final decoded string.
*/

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();

        int number = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');

            } else if (ch == '[') {

                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current = new StringBuilder();

            } else if (ch == ']') {

                int repeat = countStack.pop();

                StringBuilder previous =
                        stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;

            } else {

                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter encoded string: ");
        String s = sc.nextLine();

        System.out.println("Decoded String: "
                + decodeString(s));

        sc.close();
    }
}