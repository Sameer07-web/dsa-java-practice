/*
Problem: Rotate List

Difficulty: Medium

Source: LeetCode 61

Description:
Given the head of a linked list, rotate the list to the right
by k places.

Example 1:
Input:
1 2 3 4 5
2

Output:
4 5 1 2 3

Explanation:
Rotate the list right by 2 positions.

Example 2:
Input:
0 1 2
4

Output:
2 0 1

Explanation:
k = 4
4 % 3 = 1
Rotate right by 1 position.

Pattern: Circular Linked List / Pointer Manipulation

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Find the length of the linked list.
2. Connect the tail to the head to form a circular list.
3. Compute k = k % length.
4. Find the new tail at position length - k.
5. The next node becomes the new head.
6. Break the circular link.
7. Return the new head.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        ListNode result = rotateRight(head, k);

        System.out.print("Rotated List: ");
        printList(result);

        sc.close();
    }
}