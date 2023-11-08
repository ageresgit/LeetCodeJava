package com.github.ageresgit.treeproblems;

public class BalancedBinaryTree {
    public int treeHeight(TreeNode node) {
        if (node == null) return 0;
        int l = treeHeight(node.left);
        if (l < 0) return -1;
        int r = treeHeight(node.right);
        if (r < 0) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Integer.max(l, r);
    }
    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) >= 0;
    }
}
