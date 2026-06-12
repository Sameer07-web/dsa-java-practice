/*
Problem: Swapping Nodes in a Linked List

Difficulty: Medium

Source: LeetCode 1721

Description:
You are given the head of a linked list and an integer k.

Return the head of the linked list after swapping the values
of the kth node from the beginning and the kth node from the end.

Example 1:
Input:
1 2 3 4 5
2

Output:
1 4 3 2 5

Explanation:
The 2nd node from the beginning is 2.
The 2nd node from the end is 4.
Swap their values.

Example 2:
Input:
7 9 6 6 7 8 3 0 9 5
5

Output:
7 9 6 6 8 7 3 0 9 5

Pattern: Two Pointers

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Find the kth node from the beginning.
2. Keep a pointer at this node.
3. Move another pointer to the end while moving a second pointer from head.
4. The second pointer reaches the kth node from the end.
5. Swap the values of both nodes.
6. Return the head.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SwappingNodesInLinkedList {

    public static ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        int temp = kthFromStart.val;
        kthFromStart.val = second.val;
        second.val = temp;

        return head;
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

        ListNode result = swapNodes(head, k);

        System.out.print("Updated List: ");
        printList(result);

        sc.close();
    }
}