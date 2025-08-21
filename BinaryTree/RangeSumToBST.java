/*
938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
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
    int ans;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return ans;
    }

    private void helper(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        helper(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            ans += node.val;
        }
        helper(node.right, low, high);
    }
}