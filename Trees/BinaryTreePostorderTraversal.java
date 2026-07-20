/*
Problem: Binary Tree Postorder Traversal

Difficulty: Easy

Source: LeetCode 145

Description:
Given the root of a binary tree, return the postorder traversal
of its nodes' values.

Postorder Traversal follows the order:
Left → Right → Root

Example 1:

Input:

        1
         \
          2
         /
        3

Output:
[3,2,1]

Example 2:

Input:
root = []

Output:
[]

Example 3:

Input:
root = [1]

Output:
[1]

Pattern:
Tree Traversal
Depth First Search (DFS)
Recursion

Time Complexity: O(n)

Space Complexity: O(h)

where:
n = Number of Nodes
h = Height of Tree

Approach:
1. If the current node is null, return.
2. Recursively traverse the left subtree.
3. Recursively traverse the right subtree.
4. Visit the current node and add its value to the result.
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private static void postorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        postorder(node.left, result);

        postorder(node.right, result);

        result.add(node.val);
    }

    public static void main(String[] args) {

        /*
                1
                 \
                  2
                 /
                3
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
    }
}