/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

Input: root = [3,9,20,null,null,15,7]
Output: true

Input: root = []
Output: true
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (isHeightBalanced(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int isHeightBalanced (TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lH =  isHeightBalanced(node.left);
        int rH = isHeightBalanced(node.right);

        if (Math.abs(lH - rH) > 1) {
            return -1;
        }

        if (lH == -1 || rH == -1) {
            return -1;
        }

        return Math.max(lH, rH) + 1;
    }
}