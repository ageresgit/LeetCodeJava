package com.github.ageresgit.treeproblems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        int depth = -1;
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        while (!nodes.isEmpty()){
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode node = nodes.removeFirst();
                if (node != null) {
                    nodes.addLast(node.left);
                    nodes.addLast(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Integer.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }
    private int maxDepthRecursiveOne(TreeNode root, int depth, int maxDepth) {
        if (root == null) return Integer.max(depth, maxDepth);
        return Integer.max(maxDepthRecursiveOne(root.left, depth + 1, maxDepth),
                maxDepthRecursiveOne(root.right, depth + 1, maxDepth));
    }
    public int maxDepthRecursiveOne(TreeNode root) {
        return maxDepthRecursiveOne(root, 0, 0);
    }
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int maxDepthIterative(TreeNode root) {
        Stack<Pair> nodes = new Stack<>();
        return 0;
    }
    public int maxDepthIterativeTwo(TreeNode root) {
        Stack<Pair> nodes = new Stack<>();
        int depth = 0, maxDepth = 0;
        while (root != null || !nodes.isEmpty()){
            if (root != null) {
                depth += 1;
                maxDepth = Integer.max(maxDepth, depth);
                nodes.push(new Pair(root, depth));
                root = root.right;
            }
            else {
                depth -= 1;
                Pair p = nodes.pop();
                root = p.node;
                depth = p.depth;
                root = root.left;
            }
        }
        return maxDepth;
    }
}
