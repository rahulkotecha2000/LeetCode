/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Object[]> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(new Object[]{root, 0});
        int minCol = 0;
        int maxCol = 0;

        while(!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int col = (Integer) curr[1];
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            if(node.left != null) {
                queue.offer(new Object[]{node.left, col - 1});
            }

            if (node.right != null) {
                queue.offer(new Object[]{node.right, col + 1});
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}