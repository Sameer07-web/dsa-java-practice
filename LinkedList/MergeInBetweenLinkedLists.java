/*
Problem: Merge In Between Linked Lists

Difficulty: Medium

Source: LeetCode 1669

Description:
You are given two linked lists: list1 and list2.

Remove nodes from list1 starting from index a to index b
and insert list2 in their place.

Return the modified linked list.

Example 1:
Input:

list1:
0 1 2 3 4 5

a = 3
b = 4

list2:
1000000 1000001 1000002

Output:
0 1 2 1000000 1000001 1000002 5

Pattern: Linked List Splicing

Time Complexity: O(n + m)

Space Complexity: O(1)

Approach:
1. Find the node before index a.
2. Find the node after index b.
3. Connect the node before a to the head of list2.
4. Traverse to the tail of list2.
5. Connect the tail of list2 to the node after b.
6. Return the modified list.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeInBetweenLinkedLists {

    public static ListNode mergeInBetween(
            ListNode list1,
            int a,
            int b,
            ListNode list2) {

        ListNode prevA = list1;

        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA;

        for (int i = 0; i < (b - a + 2); i++) {
            afterB = afterB.next;
        }

        prevA.next = list2;

        ListNode tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = afterB;

        return list1;
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

        System.out.print("Enter size of list1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements of list1:");
        ListNode list1 = createList(sc, n1);

        System.out.print("Enter a: ");
        int a = sc.nextInt();

        System.out.print("Enter b: ");
        int b = sc.nextInt();

        System.out.print("Enter size of list2: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements of list2:");
        ListNode list2 = createList(sc, n2);

        ListNode result =
                mergeInBetween(list1, a, b, list2);

        System.out.print("Merged List: ");
        printList(result);

        sc.close();
    }
}