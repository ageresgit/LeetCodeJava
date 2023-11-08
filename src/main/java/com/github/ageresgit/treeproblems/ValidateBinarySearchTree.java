package com.github.ageresgit.treeproblems;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        return (min == null || root.val > min) &&
                (max == null || root.val < max) &&
                isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}
