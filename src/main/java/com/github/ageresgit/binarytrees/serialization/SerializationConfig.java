package com.github.ageresgit.binarytrees.serialization;

import com.github.ageresgit.binarytrees.TreeNode;

public class SerializationConfig {
    public final static TreeNode NULL_NODE = new TreeNode();
    public final static String DELIMITER = " ";
    public final static String NULL_NODE_VALUE = "n";

    public static String nodeToStr(TreeNode node) {
        if (node == null || node == NULL_NODE) return NULL_NODE_VALUE;
        return Integer.toString(node.val);
    }

    public static TreeNode strToNode(String stringValue) {
        if (NULL_NODE_VALUE.equals(stringValue) || stringValue == null || stringValue.isEmpty()) return null;
        return new TreeNode(Integer.parseInt(stringValue));
    }

    public static StringBuilder serializeNode(TreeNode node, StringBuilder sb) {
        if (sb.length() > 0) sb.append(DELIMITER);
        sb.append(nodeToStr(node));
        return sb;
    }

    public static TreeNode getNextFromArray(String[] strings, int stringIndex) {
        if (stringIndex >= strings.length) return null;
        return strToNode(strings[stringIndex]);
    }
}
