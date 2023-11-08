package com.github.ageresgit.treeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SerializeBinaryTreePreorder implements SerializeBinaryTree {
    static final String nullValue = "n";
    static final String separator = " ";
    private String stringOf(TreeNode node) {
        return (node == null)? nullValue: Integer.toString(node.val);
    }
    private TreeNode nodeOf(String value) {
        if (value.equals(nullValue)) return null;
        return new TreeNode(Integer.valueOf(value));
    }
    private void serialize(TreeNode node, StringBuilder sb) {
        sb.append(stringOf(node));
        sb.append(separator);
        if (node == null) return;
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private int deserialize(TreeNode node, List<String> values, int nodeNumber) {
        if (nodeNumber == values.size()) return nodeNumber;
        if (node == null) return nodeNumber + 1;
        node.left = nodeOf(values.get(nodeNumber));
        if (node.left != null) nodeNumber = deserialize(node.left, values, nodeNumber + 1);
        else nodeNumber++;
        node.right = nodeOf(values.get(nodeNumber));
        if (node.right != null) nodeNumber = deserialize(node.right, values, nodeNumber + 1);
        else nodeNumber++;
        return nodeNumber;
    }
    public TreeNode deserialize(String data) {
        if (data == null || data == "") return null;
        //String[] nodeValues = data.split(separator);
        ArrayList<String> values = new ArrayList<>();
        int start = 0;
        while (start < data.length()) {
            int end = data.indexOf(separator, start + 1);
            if (end == -1) end = data.length();
            values.add(data.substring(start, end));
            start = end + 1;
        }
        //if (nodeValues.length == 0) return null;
        if (values.size() == 0) return null;
        //TreeNode root = nodeOf(nodeValues[0]);
        TreeNode root = nodeOf(values.get(0));
        //deserialize(root, nodeValues, 1);
        deserialize(root, values, 1);
        return root;
    }
    private int deserialize(TreeNode node, String[] values, int nodeNumber) {
        if (nodeNumber == values.length) return nodeNumber;
        if (node == null) return nodeNumber + 1;
        node.left = nodeOf(values[nodeNumber]);
        if (node.left != null) nodeNumber = deserialize(node.left, values, nodeNumber + 1);
        else nodeNumber++;
        node.right = nodeOf(values[nodeNumber]);
        if (node.right != null) nodeNumber = deserialize(node.right, values, nodeNumber + 1);
        else nodeNumber++;
        return nodeNumber;
    }
}
