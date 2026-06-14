/*
Problem: Intersection of Two Linked Lists

Difficulty: Easy

Source: LeetCode 160

Description:
Given the heads of two singly linked lists, return the node
at which the two lists intersect.

If the two linked lists have no intersection, return null.

The lists retain their original structure after the function returns.

Example 1:
Input:

List A:
4 1 8 4 5

List B:
5 6 1 8 4 5

Intersection Value:
8

Output:
8

Example 2:
Input:

List A:
1 9 1 2 4

List B:
3 2 4

Intersection Value:
2

Output:
2

Example 3:
Input:

List A:
2 6 4

List B:
1 5

Intersection Value:
-1

Output:
No Intersection

Pattern: Two Pointers / Pointer Switching

Time Complexity: O(m + n)

Space Complexity: O(1)

Approach:
1. Initialize two pointers:
   - p1 at headA
   - p2 at headB
2. Traverse both lists simultaneously.
3. When a pointer reaches null, redirect it to the head of the other list.
4. Both pointers will eventually:
   - Meet at the intersection node, or
   - Become null if no intersection exists.
5. Return the intersection node.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Demo implementation for LeetCode-style intersection problem.");
        System.out.println("Intersection construction is complex in Scanner input.");
        System.out.println("Refer to LeetCode test cases for actual execution.");

        sc.close();
    }
}