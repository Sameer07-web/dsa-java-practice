/*
Problem: Reverse Nodes in k-Group

Difficulty: Hard

Source: LeetCode 25

Description:
Given the head of a linked list, reverse the nodes of the
list k at a time and return the modified list.

k is a positive integer and is less than or equal to the
length of the linked list.

If the number of nodes is not a multiple of k, then the
remaining nodes should remain as they are.

You may not alter the values in the nodes, only nodes
themselves may be changed.

Example 1:
Input:
1 2 3 4 5
2

Output:
2 1 4 3 5

Example 2:
Input:
1 2 3 4 5
3

Output:
3 2 1 4 5

Pattern: Linked List Reversal / Reverse in Groups

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create a dummy node before head.
2. Find the kth node from the current group.
3. If kth node does not exist, stop.
4. Reverse nodes within the current group.
5. Connect the reversed group with the previous and next parts.
6. Move to the next group and repeat.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kth = getKthNode(groupPrev, k);

            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode temp = curr.next;

                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;

            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    public static ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
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

        ListNode result = reverseKGroup(head, k);

        System.out.print("Updated List: ");
        printList(result);

        sc.close();
    }
}