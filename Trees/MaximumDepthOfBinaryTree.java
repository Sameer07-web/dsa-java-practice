/*
Problem: Maximum Depth of Binary Tree

Difficulty: Easy

Source: LeetCode 104

Description:
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along
the longest path from the root node down to the farthest leaf node.

Example 1:

Input:

        3
       / \
      9   20
         /  \
        15   7

Output:
3

Example 2:

Input:

      1
       \
        2

Output:
2

Pattern:
Tree Traversal
Depth First Search (DFS)
Recursion

Time Complexity: O(n)

Space Complexity: O(h)

where:
n = Number of Nodes
h = Height of the Tree

Approach:
1. If the current node is null, return 0.
2. Recursively calculate the maximum depth of the left subtree.
3. Recursively calculate the maximum depth of the right subtree.
4. Return the larger depth plus one for the current node.
*/

public class MaximumDepthOfBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);

        System.out.println("Maximum Depth: " + depth);
    }
}