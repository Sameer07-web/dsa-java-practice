/*
Problem: Odd Even Linked List

Difficulty: Medium

Source: LeetCode 328

Description:
Given the head of a singly linked list, group all nodes with
odd indices together followed by the nodes with even indices.

The first node is considered odd, the second node even, and so on.

Maintain the relative order of odd nodes and even nodes.

Example 1:
Input:
1 2 3 4 5

Output:
1 3 5 2 4

Example 2:
Input:
2 1 3 5 6 4 7

Output:
2 3 6 7 1 5 4

Pattern: Linked List Rearrangement

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create two pointers:
   - odd for odd indexed nodes
   - even for even indexed nodes
2. Store the head of even list.
3. Rearrange pointers to separate odd and even nodes.
4. Connect the odd list with the even list.
5. Return the head.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

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

        ListNode result = oddEvenList(head);

        System.out.print("Rearranged List: ");
        printList(result);

        sc.close();
    }
}