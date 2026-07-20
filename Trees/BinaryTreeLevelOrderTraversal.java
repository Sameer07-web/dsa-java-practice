/*
Problem: Binary Tree Level Order Traversal

Difficulty: Medium

Source: LeetCode 102

Description:
Given the root of a binary tree, return the level order
traversal of its nodes' values.

(Level by level, from left to right.)

Example:

Input:

        3
       / \
      9   20
         /  \
        15   7

Output:

[
 [3],
 [9,20],
 [15,7]
]

Pattern:
Breadth First Search (BFS)
Queue
Level Order Traversal

Time Complexity: O(n)

Space Complexity: O(n)

where:
n = Number of Nodes

Approach:
1. If the tree is empty, return an empty list.
2. Create a queue and insert the root node.
3. Process one level at a time.
4. Store all nodes of the current level.
5. Add each node's left and right children to the queue.
6. Repeat until the queue becomes empty.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(level);
        }

        return result;
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

        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal:");

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}