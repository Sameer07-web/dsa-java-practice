/*
Problem: Merge k Sorted Lists

Difficulty: Hard

Source: LeetCode 23

Description:
You are given an array of k linked lists, each linked list
is sorted in ascending order.

Merge all the linked lists into one sorted linked list
and return it.

Example 1:
Input:
3
3
1 4 5
3
1 3 4
2
2 6

Output:
1 1 2 3 4 4 5 6

Example 2:
Input:
0

Output:
Empty List

Pattern: Heap / Priority Queue

Time Complexity: O(N log k)

Space Complexity: O(k)

Where:
N = Total number of nodes
k = Number of linked lists

Approach:
1. Create a min heap.
2. Insert the head of every non-empty list into the heap.
3. Extract the smallest node from the heap.
4. Add it to the merged list.
5. Insert the next node of the extracted node into the heap.
6. Repeat until the heap becomes empty.
7. Return the merged list.
*/

import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
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

        System.out.print("Enter number of linked lists: ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {

            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();

            System.out.println("Enter sorted elements:");
            lists[i] = createList(sc, n);
        }

        ListNode result = mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(result);

        sc.close();
    }
}