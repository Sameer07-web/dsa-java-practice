/*
Problem: Sort List

Difficulty: Medium

Source: LeetCode 148

Description:
Given the head of a linked list, return the list after sorting
it in ascending order.

The algorithm should run in O(n log n) time complexity.

Example 1:
Input:
4 2 1 3

Output:
1 2 3 4

Example 2:
Input:
-1 5 3 4 0

Output:
-1 0 3 4 5

Example 3:
Input:
1

Output:
1

Pattern: Merge Sort / Divide and Conquer

Time Complexity: O(n log n)

Space Complexity: O(log n)

Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Split the list into two halves.
3. Recursively sort both halves.
4. Merge the sorted halves.
5. Return the merged sorted list.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SortList {

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    public static ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static ListNode createList(Scanner sc, int n) {

        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

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

        System.out.println("Enter node values:");

        ListNode head = createList(sc, n);

        ListNode result = sortList(head);

        System.out.print("Sorted List: ");
        printList(result);

        sc.close();
    }
}