/*
Problem: Basic Calculator II

Difficulty: Medium

Source: LeetCode 227

Description:
Given a string s which represents an expression,
evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume:
- The expression is always valid.
- Only non-negative integers and operators
  '+', '-', '*', '/' are present.
- Spaces may exist in the expression.

Example 1:

Input:
"3+2*2"

Output:
7

Example 2:

Input:
" 3/2 "

Output:
1

Example 3:

Input:
" 3+5 / 2 "

Output:
5

Pattern: Stack / Expression Evaluation

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Traverse the expression character by character.
2. Build the current number.
3. When an operator is encountered:
   - '+' -> Push number.
   - '-' -> Push negative number.
   - '*' -> Multiply with previous value.
   - '/' -> Divide previous value.
4. Update the current operator.
5. Sum all values in the stack.
6. Return the result.
*/

import java.util.Scanner;
import java.util.Stack;

public class BasicCalculatorII {

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ')
                    || i == s.length() - 1) {

                if (sign == '+') {

                    stack.push(num);

                } else if (sign == '-') {

                    stack.push(-num);

                } else if (sign == '*') {

                    stack.push(stack.pop() * num);

                } else if (sign == '/') {

                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = sc.nextLine();

        System.out.println("Result: "
                + calculate(expression));

        sc.close();
    }
}
