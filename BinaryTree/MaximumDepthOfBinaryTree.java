/*
104. Maximum Depth of a Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3
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
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}