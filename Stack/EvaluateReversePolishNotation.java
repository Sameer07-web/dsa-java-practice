/*
Problem: Evaluate Reverse Polish Notation

Difficulty: Medium

Source: LeetCode 150

Description:
Evaluate the value of an arithmetic expression in
Reverse Polish Notation (RPN).

Valid operators:
+, -, *, /

Each operand may be an integer or another expression.

Division between two integers should truncate toward zero.

Example 1:

Input:
["2","1","+","3","*"]

Output:
9

Explanation:
((2 + 1) * 3) = 9

Example 2:

Input:
["4","13","5","/","+"]

Output:
6

Explanation:
4 + (13 / 5) = 6

Example 3:

Input:
["10","6","9","3","+","-11","*","/","*","17","+","5","+"]

Output:
22

Pattern: Stack / Expression Evaluation

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Traverse all tokens.
2. If token is a number:
   - Push into stack.
3. If token is an operator:
   - Pop two operands.
   - Perform operation.
   - Push result back.
4. Final stack element is the answer.
*/

import java.util.Scanner;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);

            } else if (token.equals("-")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);

            } else if (token.equals("*")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);

            } else if (token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] tokens = new String[n];

        System.out.println("Enter tokens:");

        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextLine();
        }

        System.out.println("Result: "
                + evalRPN(tokens));

        sc.close();
    }
}