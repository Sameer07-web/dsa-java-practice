/*
Problem: Remove Nth Node From End of List

Difficulty: Medium

Source: LeetCode 19

Description:
Given the head of a linked list, remove the nth node
from the end of the list and return its head.

Example 1:
Input:
1 2 3 4 5
2

Output:
1 2 3 5

Explanation:
The 2nd node from the end is 4, so it is removed.

Example 2:
Input:
1
1

Output:
Empty List

Example 3:
Input:
1 2
1

Output:
1

Pattern: Two Pointers / Fast & Slow Pointer Gap

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create a dummy node pointing to head.
2. Place two pointers, first and second, at dummy.
3. Move first pointer (n + 1) steps ahead.
4. Move both pointers until first reaches null.
5. Second will be just before the node to remove.
6. Skip the target node.
7. Return dummy.next.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

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
            System.out.println("Empty List");
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

        System.out.print("Enter N: ");
        int removePosition = sc.nextInt();

        ListNode result = removeNthFromEnd(head, removePosition);

        System.out.print("Updated List: ");
        printList(result);

        sc.close();
    }
}