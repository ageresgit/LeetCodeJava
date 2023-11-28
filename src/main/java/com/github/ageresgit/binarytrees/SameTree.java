package com.github.ageresgit.binarytrees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return (q == null);
        if ((q == null) || (q.val != p.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
