/*
Problem: Swap Nodes in Pairs

Difficulty: Medium

Source: LeetCode 24

Description:
Given a linked list, swap every two adjacent nodes and
return its head.

You must solve the problem without modifying the values
in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input:
1 2 3 4

Output:
2 1 4 3

Example 2:
Input:
1

Output:
1

Example 3:
Input:
1 2 3

Output:
2 1 3

Pattern: Linked List Pointer Manipulation

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create a dummy node before head.
2. Use a pointer prev to track the node before the current pair.
3. Identify first and second nodes of the pair.
4. Swap the pair by changing pointers.
5. Move prev to the end of the swapped pair.
6. Repeat until fewer than two nodes remain.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
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

        ListNode result = swapPairs(head);

        System.out.print("Updated List: ");
        printList(result);

        sc.close();
    }
}