/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1

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
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b - a));
    public int kthSmallest(TreeNode root, int k) {
        helper(root);

        while(maxHeap.size() > k) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        maxHeap.offer(node.val);
        helper(node.right);
    }
}