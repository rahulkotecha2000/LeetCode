// 145. Binary Tree Postorder Traversal

// Given the root of a binary tree, return the postorder traversal of its nodes' values.
//Input: root = [1,null,2,3]
// Output: [3,2,1]

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
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return ;
        }

        helper(node.left);
        helper(node.right);
        ans.add(node.val);
    }
}