/*
Problem: Implement Queue using Stacks

Difficulty: Easy

Source: LeetCode 232

Description:
Implement a First-In-First-Out (FIFO) queue using only
two stacks.

Implement the MyQueue class:

1. push(int x) - Push element x to the back of queue.
2. pop() - Remove the element from the front of queue.
3. peek() - Get the front element.
4. empty() - Return whether the queue is empty.

Example:

Input:
push(1)
push(2)

peek()
pop()
empty()

Output:
1
1
false

Pattern: Queue Design / Stack Simulation

Time Complexity:
push()  -> O(1)
pop()   -> O(1) amortized
peek()  -> O(1) amortized
empty() -> O(1)

Space Complexity: O(n)

Approach:
1. Use two stacks:
   - inputStack for insertion.
   - outputStack for deletion.
2. Push elements directly into inputStack.
3. For pop() and peek():
   - If outputStack is empty, transfer all elements
     from inputStack to outputStack.
4. Front element is always at the top of outputStack.
*/

import java.util.Scanner;
import java.util.Stack;

public class ImplementQueueUsingStacks {

    static class MyQueue {

        private Stack<Integer> inputStack;
        private Stack<Integer> outputStack;

        public MyQueue() {

            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        public void push(int x) {

            inputStack.push(x);
        }

        public int pop() {

            peek();

            return outputStack.pop();
        }

        public int peek() {

            if (outputStack.isEmpty()) {

                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.peek();
        }

        public boolean empty() {

            return inputStack.isEmpty()
                    && outputStack.isEmpty();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyQueue queue = new MyQueue();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            queue.push(sc.nextInt());
        }

        System.out.println("Front Element: " + queue.peek());
        System.out.println("Removed Element: " + queue.pop());
        System.out.println("Is Queue Empty: " + queue.empty());

        sc.close();
    }
}