/*
Problem: Add Two Numbers

Difficulty: Medium

Source: LeetCode 2

Description:
You are given two non-empty linked lists representing two
non-negative integers.

The digits are stored in reverse order, and each node
contains a single digit.

Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading
zero, except the number 0 itself.

Example 1:
Input:
2 4 3
5 6 4

Output:
7 0 8

Explanation:
342 + 465 = 807

Example 2:
Input:
0
0

Output:
0

Example 3:
Input:
9 9 9 9 9 9 9
9 9 9 9

Output:
8 9 9 9 0 0 0 1

Pattern: Linked List Addition / Carry Handling

Time Complexity: O(max(n, m))

Space Complexity: O(max(n, m))

Approach:
1. Traverse both linked lists simultaneously.
2. Add corresponding digits and carry.
3. Create a new node using sum % 10.
4. Update carry using sum / 10.
5. Continue until both lists and carry are exhausted.
6. Return the result list.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
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

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();

        System.out.println("Enter first number:");
        ListNode l1 = createList(sc, n1);

        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();

        System.out.println("Enter second number:");
        ListNode l2 = createList(sc, n2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Sum List: ");
        printList(result);

        sc.close();
    }
}