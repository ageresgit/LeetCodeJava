package com.github.ageresgit.treeproblems;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int counter = 1;
        while (root != null || !stack.empty()) {
            if (root == null) {
                root = stack.pop();
                if (counter == k) return root.val;
                counter++;
                root = root.right;
            }
            else {
                stack.push(root);
                root = root.left;
            }
        }
        return k;
    }
}
