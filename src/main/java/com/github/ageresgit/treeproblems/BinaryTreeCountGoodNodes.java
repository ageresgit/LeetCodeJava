package com.github.ageresgit.treeproblems;

public class BinaryTreeCountGoodNodes {
    public int goodNodes(TreeNode root, int max, int count) {
        if (root == null) return count;
        int newMax = Integer.max(max, root.val);
        if (newMax == root.val) count++;
        count = goodNodes(root.right, newMax, count);
        return goodNodes(root.left, newMax, count);
    }
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val, 0);
    }
}
