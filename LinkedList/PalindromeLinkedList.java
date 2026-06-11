/*
Problem: Palindrome Linked List

Difficulty: Easy

Source: LeetCode 234

Description:
Given the head of a singly linked list, return true if it
is a palindrome or false otherwise.

A palindrome reads the same forward and backward.

Example 1:
Input:
1 2 2 1

Output:
true

Example 2:
Input:
1 2

Output:
false

Example 3:
Input:
1 2 3 2 1

Output:
true

Pattern: Fast & Slow Pointers + Linked List Reversal

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Compare the first half and reversed second half node by node.
4. If any values differ, return false.
5. If all values match, return true.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(true);
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

        System.out.println("Is Palindrome: " + isPalindrome(head));

        sc.close();
    }
}