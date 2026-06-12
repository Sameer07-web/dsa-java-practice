/*
Problem: Reorder List

Difficulty: Medium

Source: LeetCode 143

Description:
You are given the head of a singly linked list.

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...

You may not modify the values in the nodes.
Only the nodes themselves may be changed.

Example 1:
Input:
1 2 3 4

Output:
1 4 2 3

Example 2:
Input:
1 2 3 4 5

Output:
1 5 2 4 3

Pattern: Fast & Slow Pointers + Reversal + Merge

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Merge both halves alternately.
4. Return the reordered list.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReorderList {

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
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

        reorderList(head);

        System.out.print("Reordered List: ");
        printList(head);

        sc.close();
    }
}