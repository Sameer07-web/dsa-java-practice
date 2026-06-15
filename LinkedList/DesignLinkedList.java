/*
Problem: Design Linked List

Difficulty: Medium

Source: LeetCode 707

Description:
Design your implementation of the linked list.

Implement the MyLinkedList class:

1. get(index)        - Get the value of the index-th node.
2. addAtHead(val)    - Add a node before the first element.
3. addAtTail(val)    - Append a node to the last element.
4. addAtIndex(index, val)
                      - Add a node before the index-th node.
5. deleteAtIndex(index)
                      - Delete the index-th node.

Example:
Input:
addAtHead(1)
addAtTail(3)
addAtIndex(1, 2)
get(1)
deleteAtIndex(1)
get(1)

Output:
2
3

Pattern: Linked List Design

Time Complexity:
get()            -> O(n)
addAtHead()      -> O(1)
addAtTail()      -> O(n)
addAtIndex()     -> O(n)
deleteAtIndex()  -> O(n)

Space Complexity: O(n)

Approach:
1. Maintain a head pointer and size variable.
2. Traverse to required position for operations.
3. Update links carefully during insertion/deletion.
4. Keep size updated after every modification.
*/

import java.util.Scanner;

public class DesignLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {

        private Node head;
        private int size;

        public int get(int index) {

            if (index < 0 || index >= size) {
                return -1;
            }

            Node curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        public void addAtHead(int val) {

            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;

            size++;
        }

        public void addAtTail(int val) {

            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                size++;
                return;
            }

            Node curr = head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;

            size++;
        }

        public void addAtIndex(int index, int val) {

            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
                return;
            }

            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            Node newNode = new Node(val);

            newNode.next = curr.next;
            curr.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {

            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                head = head.next;
                size--;
                return;
            }

            Node curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;

            size--;
        }

        public void printList() {

            Node curr = head;

            while (curr != null) {

                System.out.print(curr.val);

                if (curr.next != null) {
                    System.out.print(" ");
                }

                curr = curr.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyLinkedList list = new MyLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);

        System.out.println("Value at index 1: " + list.get(1));

        list.deleteAtIndex(1);

        System.out.print("Linked List: ");
        list.printList();

        sc.close();
    }
}