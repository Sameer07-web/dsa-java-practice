/*
Problem: Copy List with Random Pointer

Difficulty: Medium

Source: LeetCode 138

Description:
A linked list of length n is given such that each node
contains an additional random pointer, which could point
to any node in the list or null.

Construct a deep copy of the list.

The deep copy should consist of exactly n new nodes,
where each new node has its value set to the value
of its corresponding original node.

Both the next and random pointers of the new nodes
should point to new nodes in the copied list.

Example 1:
Input:
[[7,null],[13,0],[11,4],[10,2],[1,0]]

Output:
Deep Copy Created

Example 2:
Input:
[[1,1],[2,1]]

Output:
Deep Copy Created

Pattern: Deep Copy / Linked List Cloning

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Insert copied nodes after every original node.
2. Connect random pointers of copied nodes.
3. Separate the original and copied lists.
4. Return the head of the copied list.
*/

class Node {

    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class CopyListWithRandomPointer {

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node curr = head;

        // Step 1: Insert copied nodes
        while (curr != null) {

            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;

        // Step 2: Connect random pointers
        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;

        // Step 3: Separate copied list
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println(
            "LeetCode 138 uses a special linked list with random pointers."
        );

        System.out.println(
            "Random pointer construction through Scanner input is impractical."
        );

        System.out.println(
            "Refer to LeetCode test cases to execute and verify the solution."
        );
    }
}