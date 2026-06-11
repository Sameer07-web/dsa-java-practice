/*
Problem: Linked List Cycle

Difficulty: Easy

Source: LeetCode 141

Description:
Given head, the head of a linked list, determine if the linked
list has a cycle in it.

A cycle exists if some node in the list can be reached again
by continuously following the next pointer.

Return true if there is a cycle in the linked list.
Otherwise, return false.

Example 1:
Input:
3 2 0 -4
1

Output:
true

Explanation:
The tail connects to node index 1, forming a cycle.

Example 2:
Input:
1 2
0

Output:
true

Example 3:
Input:
1
-1

Output:
false

Pattern: Fast & Slow Pointers (Floyd's Cycle Detection)

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Initialize two pointers:
   - slow moves one step at a time.
   - fast moves two steps at a time.
2. Traverse the linked list.
3. If slow and fast meet, a cycle exists.
4. If fast reaches null, there is no cycle.
5. Return the result.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println(false);
            sc.close();
            return;
        }

        ListNode[] nodes = new ListNode[n];

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            nodes[i] = new ListNode(sc.nextInt());
        }

        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        System.out.print("Enter cycle position (-1 for no cycle): ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < n) {
            nodes[n - 1].next = nodes[pos];
        }

        System.out.println("Cycle Exists: " + hasCycle(nodes[0]));

        sc.close();
    }
}