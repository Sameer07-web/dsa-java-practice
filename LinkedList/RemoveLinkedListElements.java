/*
Problem: Remove Linked List Elements

Difficulty: Easy

Source: LeetCode 203

Description:
Given the head of a linked list and an integer val,
remove all the nodes of the linked list that have
Node.val == val, and return the new head.

Example 1:
Input:
1 2 6 3 4 5 6
6

Output:
1 2 3 4 5

Example 2:
Input:
7 7 7 7
7

Output:
Empty List

Example 3:
Input:
1 2 3 4
5

Output:
1 2 3 4

Pattern: Linked List Traversal / Dummy Node

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create a dummy node pointing to head.
2. Use a current pointer starting from dummy.
3. Traverse the list.
4. If current.next contains the target value:
      skip that node.
5. Otherwise move current forward.
6. Return dummy.next as the new head.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {

            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

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

        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();

        ListNode result = removeElements(head, val);

        System.out.print("Updated List: ");
        printList(result);

        sc.close();
    }
}