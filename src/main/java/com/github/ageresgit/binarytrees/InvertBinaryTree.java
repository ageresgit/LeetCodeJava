package com.github.ageresgit.binarytrees;

import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null;
        if (root.left != null || root.right != null) {
            TreeNode temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = temp;
        }
        return root;
    }

    private void swapChildren(TreeNode parent) {
        TreeNode temporary = parent.left;
        parent.left = parent.right;
        parent.right = temporary;
    }
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            if (node != null) {
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                swapChildren(node);
            }
        }
        return root;
    }
}
