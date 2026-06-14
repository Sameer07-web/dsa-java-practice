/*
Problem: Partition List

Difficulty: Medium

Source: LeetCode 86

Description:
Given the head of a linked list and a value x,
partition it such that all nodes less than x come
before nodes greater than or equal to x.

You should preserve the original relative order
of the nodes in each partition.

Example 1:
Input:
1 4 3 2 5 2
3

Output:
1 2 2 4 3 5

Example 2:
Input:
2 1
2

Output:
1 2

Pattern: Linked List Partitioning

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Create two dummy lists:
   - smaller list for nodes < x
   - greater list for nodes >= x
2. Traverse the original list.
3. Append each node to the appropriate list.
4. Connect the smaller list to the greater list.
5. Return the head of the partitioned list.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {

        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {

            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;
        smaller.next = greaterDummy.next;

        return smallerDummy.next;
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

        System.out.print("Enter partition value x: ");
        int x = sc.nextInt();

        ListNode result = partition(head, x);

        System.out.print("Partitioned List: ");
        printList(result);

        sc.close();
    }
}