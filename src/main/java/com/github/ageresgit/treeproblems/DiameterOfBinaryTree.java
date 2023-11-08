package com.github.ageresgit.treeproblems;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree {
    private static class Pair {
        static final Pair NULL_NODE = new Pair(-1, -1);
        int height;
        int diameter;
        Pair(int h, int d) {
            height = h;
            diameter = d;
        }
    }
    private Pair diameter(TreeNode node) {
        if (node == null) return Pair.NULL_NODE;
        Pair left = diameter(node.left);
        Pair right = diameter(node.right);
        int h = 1 + Integer.max(left.height, right.height);
        int d = Integer.max(Integer.max(left.diameter, right.diameter), 2 + left.height + right.height);
        return new Pair(h, d);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diameter;
    }
}
