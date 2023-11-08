package com.github.ageresgit.treeproblems;

import java.util.Stack;

public class InvertBinaryTree {
    public void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !nodes.isEmpty()) {
            if (curr != null) {
                swapChildren(curr);
                nodes.push(curr);
                curr = curr.left;
            } else {
                curr = nodes.pop();
                curr = curr.right;
            }
        }
        return root;
    }
        public TreeNode invertTreeRecursive(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            swapChildren(root);
            invertTreeRecursive(root.right);
            invertTreeRecursive(root.left);
        }
        return root;
    }
}
