/*
Problem: Flatten a Multilevel Doubly Linked List

Difficulty: Medium

Source: LeetCode 430

Description:
You are given a doubly linked list where in addition to
the next and previous pointers, it could have a child
pointer which may or may not point to a separate doubly
linked list.

Flatten the list so that all nodes appear in a single-level
doubly linked list.

The child pointers should be set to null.

Example 1:
Input:

1 - 2 - 3 - 4 - 5 - 6
        |
        7 - 8 - 9 - 10
            |
            11 - 12

Output:

1 - 2 - 3 - 7 - 8 - 11 - 12 - 9 - 10 - 4 - 5 - 6

Pattern: DFS / Doubly Linked List

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Traverse the doubly linked list.
2. Whenever a child list is found:
   - Recursively flatten the child list.
3. Insert the flattened child list between the current node
   and the next node.
4. Update next and prev pointers.
5. Set child pointer to null.
6. Continue until the entire structure is flattened.
*/

class Node {

    int val;
    Node prev;
    Node next;
    Node child;

    Node(int val) {
        this.val = val;
    }
}

public class FlattenMultilevelDoublyLinkedList {

    public static Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        flattenDFS(head);

        return head;
    }

    private static Node flattenDFS(Node node) {

        Node curr = node;
        Node last = null;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node childTail = flattenDFS(curr.child);

                next = curr.next;

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }

    public static void main(String[] args) {

        System.out.println(
            "LeetCode 430 uses a multilevel doubly linked list."
        );

        System.out.println(
            "Building such a structure using Scanner input is not practical."
        );

        System.out.println(
            "Refer to LeetCode test cases for execution and verification."
        );
    }
}