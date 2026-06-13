/*
Problem: Reverse Linked List II

Difficulty: Medium

Source: LeetCode 92

Description:
Given the head of a singly linked list and two integers
left and right where left <= right, reverse the nodes
of the list from position left to position right,
and return the reversed list.

Example 1:
Input:
1 2 3 4 5
2
4

Output:
1 4 3 2 5

Explanation:
The nodes from position 2 to 4 are reversed.

Example 2:
Input:
5
1
1

Output:
5

Pattern: Linked List Reversal / Sublist Reversal

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create a dummy node before head.
2. Move prev pointer to the node before 'left'.
3. Start reversing nodes between left and right.
4. Insert each node at the front of the sublist.
5. Return dummy.next as the new head.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
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

        System.out.print("Enter left position: ");
        int left = sc.nextInt();

        System.out.print("Enter right position: ");
        int right = sc.nextInt();

        ListNode result = reverseBetween(head, left, right);

        System.out.print("Reversed List: ");
        printList(result);

        sc.close();
    }
}