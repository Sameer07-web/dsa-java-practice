/*
Problem: Design Circular Queue

Difficulty: Medium

Source: LeetCode 622

Description:
Design your implementation of the circular queue.

The circular queue is a linear data structure in which
operations are performed based on FIFO (First In First Out)
principle and the last position is connected back to the
first position to make a circle.

Implement the MyCircularQueue class:

1. MyCircularQueue(k) Initializes the object with size k.
2. enQueue(value) Inserts an element into the circular queue.
3. deQueue() Deletes an element from the circular queue.
4. Front() Gets the front item.
5. Rear() Gets the last item.
6. isEmpty() Checks whether the circular queue is empty.
7. isFull() Checks whether the circular queue is full.

Example:

Input:
MyCircularQueue queue = new MyCircularQueue(3);

queue.enQueue(1);
queue.enQueue(2);
queue.enQueue(3);
queue.enQueue(4);

queue.Rear();
queue.isFull();

queue.deQueue();
queue.enQueue(4);

queue.Rear();

Output:
true
true
true
false
3
true
true
true
4

Pattern: Queue Design / Circular Queue

Time Complexity:
enQueue() -> O(1)
deQueue() -> O(1)
Front()   -> O(1)
Rear()    -> O(1)
isEmpty() -> O(1)
isFull()  -> O(1)

Space Complexity: O(k)

Approach:
1. Use an array of size k.
2. Maintain:
   - front pointer
   - rear pointer
   - current size
3. Use modulo (%) operation to achieve circular behavior.
4. Insert at rear and remove from front.
*/

import java.util.Scanner;

public class DesignCircularQueue {

    static class MyCircularQueue {

        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularQueue(int k) {

            capacity = k;
            queue = new int[k];

            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean enQueue(int value) {

            if (isFull()) {
                return false;
            }

            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;

            return true;
        }

        public boolean deQueue() {

            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % capacity;
            size--;

            return true;
        }

        public int Front() {

            if (isEmpty()) {
                return -1;
            }

            return queue[front];
        }

        public int Rear() {

            if (isEmpty()) {
                return -1;
            }

            return queue[rear];
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

        System.out.print("Enter queue capacity: ");
        int k = sc.nextInt();

        MyCircularQueue queue = new MyCircularQueue(k);

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            if (queue.enQueue(value)) {
                System.out.println(value + " inserted");
            } else {
                System.out.println("Queue is Full");
            }
        }

        System.out.println("Front Element: " + queue.Front());
        System.out.println("Rear Element: " + queue.Rear());

        System.out.println("Queue Full: " + queue.isFull());

        queue.deQueue();

        System.out.println("After Dequeue:");
        System.out.println("Front Element: " + queue.Front());

        sc.close();
    }
}