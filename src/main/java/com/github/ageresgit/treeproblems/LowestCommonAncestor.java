package com.github.ageresgit.treeproblems;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Integer.min(p.val, q.val), max = Integer.max(p.val, q.val);

        boolean less = root.val < min, more = root.val > max;
        while (less || more) {
            if (less) root = root.right;
            else root = root.left;
            less = root.val < min;
            more = root.val > max;
        }
        return root;
    }
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < Integer.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
        if (root.val > Integer.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
