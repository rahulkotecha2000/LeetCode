// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Example:
//Input: root = [1,null,2,3]
//Output: [1,3,2]

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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}