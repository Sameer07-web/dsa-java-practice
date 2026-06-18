/*
Problem: Implement Stack using Queues

Difficulty: Easy

Source: LeetCode 225

Description:
Implement a Last-In-First-Out (LIFO) stack using only
two operations of a queue:

1. push to back
2. pop/remove from front

Implement the MyStack class:

1. push(int x)
2. pop()
3. top()
4. empty()

Example:

Input:
push(1)
push(2)

top()
pop()
empty()

Output:
2
2
false

Pattern: Stack Design / Queue Simulation

Time Complexity:
push()  -> O(n)
pop()   -> O(1)
top()   -> O(1)
empty() -> O(1)

Space Complexity: O(n)

Approach:
1. Use a single queue.
2. Insert the new element into the queue.
3. Rotate previous elements behind the new element.
4. Front of queue always represents stack top.
5. Perform pop and top operations directly.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ImplementStackUsingQueues {

    static class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {

            queue.offer(x);

            int size = queue.size();

            while (size > 1) {
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyStack stack = new MyStack();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Is Empty: " + stack.empty());

        sc.close();
    }
}