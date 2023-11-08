package com.github.ageresgit.treeproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTreeBreadthFirst implements SerializeBinaryTree {
    static final char leftParenthesis = '[';
    static final char rightParenthesis = ']';
    static final String emptyTree = "[]";
    static final char delimiter = ',';
    static final String nullValue = "null";
    static class NodeContainer {
        private int actualLength;
        private ArrayList<TreeNode> nodes;
        NodeContainer() {
            nodes = new ArrayList<>();
            actualLength = 0;
        }
        NodeContainer(String s) {
            nodes = new ArrayList<>();
            if (s == null || emptyTree.equals(s)) return;
            int index = 0;
            while (index < s.length()) {
                char ch = s.charAt(index++);
                if (ch == leftParenthesis || ch == delimiter) {
                    int begin = index;
                    while (s.charAt(index) != delimiter && s.charAt(index) != rightParenthesis) index++;
                    add(s.substring(begin, index));
                }
            }
        }
        void add(TreeNode node) {
            nodes.add(node);
            if (node != null) actualLength = nodes.size();
        }
        void add(String token) {
            add((nullValue.equals(token))? null: new TreeNode(Integer.valueOf(token)));
        }
        TreeNode get(int index) {return nodes.get(index);}
        int length() {return actualLength;}
        boolean exists(int i) {return i < actualLength;}
        void clear() {nodes.clear();actualLength = 0;}
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(leftParenthesis);
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            for (int index = q.size(); index > 0; index--) {
                TreeNode node = q.poll();
                if (node != null){
                    q.add(node.left);
                    q.add(node.right);
                }
                if (node != root) sb.append(delimiter);
                sb.append((node == null)?"null":Integer.toString(node.val));
            }
        }
        sb.append(rightParenthesis);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        NodeContainer container = new NodeContainer(data);
        if (container.length() <= 0) return null;
        TreeNode root = container.get(0);
        int rootIndex = 0, childIndex = 1;
        while (rootIndex < container.length()) {
            TreeNode parent = container.get(rootIndex++);
            if (parent == null) continue;
            if (!container.exists(childIndex)) break;
            parent.left = container.get(childIndex++);
            if (!container.exists(childIndex)) break;
            parent.right = container.get(childIndex++);
        }
        return root;
    }
}

