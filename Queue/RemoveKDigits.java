/*
Problem: Remove K Digits

Difficulty: Medium

Source: LeetCode 402

Description:
Given string num representing a non-negative integer num,
and an integer k, return the smallest possible integer
after removing k digits from num.

Example 1:

Input:
num = "1432219"
k = 3

Output:
"1219"

Explanation:
Remove digits 4, 3, and 2 to form the smallest number 1219.

Example 2:

Input:
num = "10200"
k = 1

Output:
"200"

Example 3:

Input:
num = "10"
k = 2

Output:
"0"

Pattern: Monotonic Increasing Stack + Greedy

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a monotonic increasing stack.
2. Traverse each digit in the number.
3. While:
   - stack is not empty
   - current digit is smaller than stack top
   - k > 0
   Remove larger digits.
4. If removals are still left, remove digits from the end.
5. Build the answer from the stack.
6. Remove leading zeros.
7. Return "0" if the result becomes empty.
*/

import java.util.Scanner;
import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while (k > 0) {

            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        while (result.length() > 0
                && result.charAt(0) == '0') {

            result.deleteCharAt(0);
        }

        return result.length() == 0
                ? "0"
                : result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String num = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        String result = removeKdigits(num, k);

        System.out.println("Smallest Number: " + result);

        sc.close();
    }
}