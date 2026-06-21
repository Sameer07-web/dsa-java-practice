/*
Problem: Design Circular Deque

Difficulty: Medium

Source: LeetCode 641

Description:
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

1. MyCircularDeque(k) Initializes the deque with size k.
2. insertFront() Adds an item at the front.
3. insertLast() Adds an item at the rear.
4. deleteFront() Deletes an item from the front.
5. deleteLast() Deletes an item from the rear.
6. getFront() Gets the front item.
7. getRear() Gets the last item.
8. isEmpty() Checks whether the deque is empty.
9. isFull() Checks whether the deque is full.

Example:

Input:
MyCircularDeque deque = new MyCircularDeque(3);

deque.insertLast(1);
deque.insertLast(2);
deque.insertFront(3);
deque.insertFront(4);

deque.getRear();
deque.isFull();

deque.deleteLast();
deque.insertFront(4);

deque.getFront();

Output:
true
true
true
false
2
true
true
true
4

Pattern: Deque Design / Circular Array

Time Complexity:
insertFront() -> O(1)
insertLast()  -> O(1)
deleteFront() -> O(1)
deleteLast()  -> O(1)
getFront()    -> O(1)
getRear()     -> O(1)
isEmpty()     -> O(1)
isFull()      -> O(1)

Space Complexity: O(k)

Approach:
1. Use a circular array of size k.
2. Maintain front, rear, and size.
3. Use modulo (%) operation for circular behavior.
4. Support insertion and deletion from both ends.
*/

import java.util.Scanner;

public class DesignCircularDeque {

    static class MyCircularDeque {

        private int[] deque;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularDeque(int k) {

            capacity = k;
            deque = new int[k];

            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean insertFront(int value) {

            if (isFull()) {
                return false;
            }

            front = (front - 1 + capacity) % capacity;
            deque[front] = value;
            size++;

            if (size == 1) {
                rear = front;
            }

            return true;
        }

        public boolean insertLast(int value) {

            if (isFull()) {
                return false;
            }

            rear = (rear + 1) % capacity;
            deque[rear] = value;
            size++;

            if (size == 1) {
                front = rear;
            }

            return true;
        }

        public boolean deleteFront() {

            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % capacity;
            size--;

            return true;
        }

        public boolean deleteLast() {

            if (isEmpty()) {
                return false;
            }

            rear = (rear - 1 + capacity) % capacity;
            size--;

            return true;
        }

        public int getFront() {

            if (isEmpty()) {
                return -1;
            }

            return deque[front];
        }

        public int getRear() {

            if (isEmpty()) {
                return -1;
            }

            return deque[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque capacity: ");
        int k = sc.nextInt();

        MyCircularDeque deque = new MyCircularDeque(k);

        System.out.print("Enter number of rear insertions: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            if (deque.insertLast(value)) {
                System.out.println(value + " inserted");
            } else {
                System.out.println("Deque is Full");
            }
        }

        System.out.println("Front Element: " + deque.getFront());
        System.out.println("Rear Element: " + deque.getRear());

        System.out.println("Deque Full: " + deque.isFull());

        deque.deleteLast();

        System.out.println("After Deleting Last:");
        System.out.println("Rear Element: " + deque.getRear());

        sc.close();
    }
}