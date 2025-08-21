/*
100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Input: p = [1,2,3], q = [1,2,3]
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode c1 = q1.poll();
            TreeNode c2 = q2.poll();

            if (c1.val != c2.val) {
                return false;
            }

            if (c1.left != null && c2.left != null) {
                q1.offer(c1.left);
                q2.offer(c2.left);
            } else if (c1.left != null || c2.left != null) {
                return false;
            }

            if (c1.right != null && c2.right != null) {
                q1.offer(c1.right);
                q2.offer(c2.right);
            } else if (c1.right != null || c2.right != null) {
                return false;
            }
        }
        return true;
    }
}