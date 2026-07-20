/*
Problem: Binary Tree Preorder Traversal

Difficulty: Easy

Source: LeetCode 144

Description:
Given the root of a binary tree, return the preorder traversal
of its nodes' values.

Preorder Traversal follows the order:
Root → Left → Right

Example 1:

Input:

        1
         \
          2
         /
        3

Output:
[1,2,3]

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
2. Visit the current node and add its value to the result.
3. Recursively traverse the left subtree.
4. Recursively traverse the right subtree.
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private static void preorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);

        preorder(node.left, result);

        preorder(node.right, result);
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

        List<Integer> result = preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}