/*
Problem: Middle of the Linked List

Difficulty: Easy

Source: LeetCode 876

Description:
Given the head of a singly linked list, return the middle node
of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:
Input:
1 2 3 4 5

Output:
3 4 5

Explanation:
The middle node is 3.

Example 2:
Input:
1 2 3 4 5 6

Output:
4 5 6

Explanation:
There are two middle nodes (3 and 4).
Return the second middle node.

Pattern: Fast & Slow Pointers

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Initialize two pointers:
   - slow moves one step at a time.
   - fast moves two steps at a time.
2. Traverse until fast reaches the end.
3. When traversal ends, slow will point to the middle node.
4. Return the middle node.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            sc.close();
            return;
        }

        System.out.println("Enter node values:");

        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        ListNode middle = middleNode(head);

        System.out.print("Middle Node Onwards: ");
        printList(middle);

        sc.close();
    }
}