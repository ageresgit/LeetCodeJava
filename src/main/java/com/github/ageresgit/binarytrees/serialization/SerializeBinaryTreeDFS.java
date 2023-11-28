package com.github.ageresgit.binarytrees.serialization;

import com.github.ageresgit.binarytrees.TreeNode;

import java.util.Stack;

import static com.github.ageresgit.binarytrees.serialization.SerializationConfig.*;

public class SerializeBinaryTreeDFS implements SerializeBinaryTree {
    private StringBuilder serialize(TreeNode root, StringBuilder sb) {
        serializeNode(root, sb);
        if (root != null) {
            sb = serialize(root.left, sb);
            sb = serialize(root.right, sb);
        }
        return sb;
    }

    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }

    private int deserialize(TreeNode root, String[] strings, int index) {
        if (index < strings.length && root != null) {
            root.left = getNextFromArray(strings, index++);
            index = deserialize(root.left, strings, index);
            root.right = getNextFromArray(strings, index++);
            index = deserialize(root.right, strings, index);
        }
        return index;
    }

    public TreeNode deserialize(String data) {
        String[] strings = data.split(DELIMITER);
        TreeNode root = getNextFromArray(strings, 0);
        deserialize(root, strings, 1);

        return root;
    }
}
