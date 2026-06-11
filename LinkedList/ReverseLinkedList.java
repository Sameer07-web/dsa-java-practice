/*
Problem: Reverse Linked List

Difficulty: Easy

Source: LeetCode 206

Description:
Given the head of a singly linked list, reverse the list
and return the reversed list.

Example 1:
Input:
1 2 3 4 5

Output:
5 4 3 2 1

Example 2:
Input:
1 2

Output:
2 1

Example 3:
Input:
1

Output:
1

Pattern: Linked List Reversal

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Initialize:
      prev = null
      curr = head
2. Traverse the linked list.
3. Store next node.
4. Reverse current node's pointer.
5. Move prev and curr one step forward.
6. When curr becomes null, prev will be the new head.
7. Return prev.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
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

        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);

        sc.close();
    }
}