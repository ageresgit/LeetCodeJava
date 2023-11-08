package com.github.ageresgit.treeproblems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    private boolean equalTrees(TreeNode a, TreeNode b) {
        if (a == b) return true;
        if (a == null) return b == null;
        if (b == null) return false;
        return (a.val == b.val && equalTrees(a.left, b.left) && equalTrees(a.right, b.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if (root == null) return subRoot == null;
        if (subRoot == null) return true;
        if (root.val == subRoot.val && equalTrees(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSubtreeIterational(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        if (subRoot == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int index = queue.size(); index > 0; --index) {
                TreeNode node = queue.remove();
                if (equalTrees(node, subRoot)) return true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return false;
    }
}
