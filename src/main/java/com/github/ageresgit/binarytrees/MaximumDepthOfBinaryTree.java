package com.github.ageresgit.binarytrees;

import java.util.*;

public class MaximumDepthOfBinaryTree {
    public int maxDepthIterational(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if (root != null) {
            queue.offer(root);
        }
        int size = queue.size();
        while(size > 0) {
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            size = queue.size();
        }
        return depth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
