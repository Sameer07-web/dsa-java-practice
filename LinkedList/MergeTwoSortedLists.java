/*
Problem: Merge Two Sorted Lists

Difficulty: Easy

Source: LeetCode 21

Description:
You are given the heads of two sorted linked lists.

Merge the two lists into one sorted linked list and
return the head of the merged list.

The merged list should be made by splicing together
the nodes of the first two lists.

Example 1:
Input:
List1: 1 2 4
List2: 1 3 4

Output:
1 1 2 3 4 4

Example 2:
Input:
List1:
List2:

Output:
Empty List

Example 3:
Input:
List1:
List2: 0

Output:
0

Pattern: Merge Two Sorted Lists

Time Complexity: O(n + m)

Space Complexity: O(1)

Approach:
1. Create a dummy node.
2. Compare nodes from both lists.
3. Attach the smaller node to the merged list.
4. Move the corresponding pointer forward.
5. When one list ends, attach the remaining nodes.
6. Return dummy.next.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter first sorted list:");
        ListNode list1 = createList(sc, n1);

        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter second sorted list:");
        ListNode list2 = createList(sc, n2);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(mergedList);

        sc.close();
    }
}