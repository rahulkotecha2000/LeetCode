/*
543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode () {}

    public TreeNode (int val) {
        this.val = val;
    }

    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}