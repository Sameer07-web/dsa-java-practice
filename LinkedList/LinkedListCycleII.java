/*
Problem: Linked List Cycle II

Difficulty: Medium

Source: LeetCode 142

Description:
Given the head of a linked list, return the node where the cycle
begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node that can
be reached again by continuously following the next pointer.

Example 1:
Input:
3 2 0 -4
1

Output:
2

Explanation:
The tail connects to node index 1.
The cycle starts at node with value 2.

Example 2:
Input:
1 2
0

Output:
1

Example 3:
Input:
1
-1

Output:
No Cycle

Pattern: Fast & Slow Pointers (Floyd's Cycle Detection)

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Use slow and fast pointers to detect a cycle.
2. If they meet, a cycle exists.
3. Place a new pointer at head.
4. Move both pointers one step at a time.
5. The node where they meet is the starting node of the cycle.
6. Return that node.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return start;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("No Cycle");
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

        ListNode cycleStart = detectCycle(nodes[0]);

        if (cycleStart == null) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle Starts At: " + cycleStart.val);
        }

        sc.close();
    }
}