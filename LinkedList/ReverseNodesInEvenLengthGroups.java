/*
Problem: Reverse Nodes in Even Length Groups

Difficulty: Medium

Source: LeetCode 2074

Description:
You are given the head of a linked list.

The nodes are grouped in increasing order of group size:

Group 1 -> 1 node
Group 2 -> 2 nodes
Group 3 -> 3 nodes
Group 4 -> 4 nodes
...

If the length of a group is even,
reverse the nodes in that group.

Return the modified linked list.

Example 1:
Input:
5 2 6 3 9 1 7 3 8 4

Output:
5 6 2 3 9 1 4 8 3 7

Explanation:

Groups:
[5]
[2,6]
[3,9,1]
[7,3,8,4]

Reverse even groups:
[5]
[6,2]
[3,9,1]
[4,8,3,7]

Example 2:
Input:
1 1 0 6

Output:
1 0 1 6

Pattern: Group Reversal / Pointer Manipulation

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Divide nodes into groups of increasing size.
2. Count actual nodes in each group.
3. Reverse the group if its length is even.
4. Leave odd-length groups unchanged.
5. Connect all groups correctly.
*/

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseNodesInEvenLengthGroups {

    public static ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {

            int count = 0;
            ListNode temp = curr;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {

                ListNode groupPrev = prev;
                ListNode groupCurr = curr;

                ListNode nextGroup = temp;

                ListNode p = nextGroup;

                for (int i = 0; i < count; i++) {

                    ListNode next = groupCurr.next;

                    groupCurr.next = p;
                    p = groupCurr;
                    groupCurr = next;
                }

                groupPrev.next = p;

                prev = curr;
                curr = nextGroup;

            } else {

                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
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

        ListNode result = reverseEvenLengthGroups(head);

        System.out.print("Modified List: ");
        printList(result);

        sc.close();
    }
}