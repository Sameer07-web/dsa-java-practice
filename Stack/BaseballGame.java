/*
Problem: Baseball Game

Difficulty: Easy

Source: LeetCode 682

Description:
You are keeping score for a baseball game with strange rules.

Operations:

1. Integer x
   - Record a new score of x.

2. "+"
   - Record a score that is the sum of the previous two scores.

3. "D"
   - Record a score that is double the previous score.

4. "C"
   - Invalidate and remove the previous score.

Return the sum of all valid scores.

Example:

Input:
["5","2","C","D","+"]

Output:
30

Explanation:

5   -> [5]
2   -> [5,2]
C   -> [5]
D   -> [5,10]
+   -> [5,10,15]

Total = 5 + 10 + 15 = 30

Pattern: Stack Simulation

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a stack to store valid scores.
2. Process each operation:
   - Integer -> Push score.
   - "+" -> Push sum of previous two scores.
   - "D" -> Push double previous score.
   - "C" -> Remove previous score.
3. Sum all values in the stack.
4. Return total score.
*/

import java.util.Scanner;
import java.util.Stack;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("+")) {

                int first = stack.pop();
                int second = stack.peek();

                stack.push(first);
                stack.push(first + second);

            } else if (op.equals("D")) {

                stack.push(2 * stack.peek());

            } else if (op.equals("C")) {

                stack.pop();

            } else {

                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] operations = new String[n];

        System.out.println("Enter operations:");

        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextLine();
        }

        System.out.println("Total Score: "
                + calPoints(operations));

        sc.close();
    }
}