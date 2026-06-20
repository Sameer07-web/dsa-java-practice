/*
Problem: Min Stack

Difficulty: Medium

Source: LeetCode 155

Description:
Design a stack that supports:

1. push(val)
2. pop()
3. top()
4. getMin()

Retrieving the minimum element must be done in O(1) time.

Example:

Input:
push(-2)
push(0)
push(-3)

getMin()

pop()

top()

getMin()

Output:
-3
0
-2

Pattern: Stack Design / Auxiliary Stack

Time Complexity:
push()   -> O(1)
pop()    -> O(1)
top()    -> O(1)
getMin() -> O(1)

Space Complexity: O(n)

Approach:
1. Maintain two stacks:
   - Main Stack
   - Minimum Stack
2. Push element into minStack when:
   - minStack is empty
   - current value <= current minimum
3. During pop():
   - Remove from minStack if popped value equals minimum.
4. Top element comes from main stack.
5. Minimum element is always available at minStack.peek().
*/

import java.util.Scanner;
import java.util.Stack;

public class MinStackDesign {

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {

            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {

            stack.push(val);

            if (minStack.isEmpty() ||
                    val <= minStack.peek()) {

                minStack.push(val);
            }
        }

        public void pop() {

            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }

            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MinStack stack = new MinStack();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Top Element: " + stack.top());
        System.out.println("Minimum Element: " + stack.getMin());

        stack.pop();

        System.out.println("After Pop:");
        System.out.println("Top Element: " + stack.top());
        System.out.println("Minimum Element: " + stack.getMin());

        sc.close();
    }
}