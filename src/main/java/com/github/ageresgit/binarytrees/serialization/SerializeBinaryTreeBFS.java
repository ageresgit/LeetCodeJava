package com.github.ageresgit.binarytrees.serialization;

import com.github.ageresgit.binarytrees.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.github.ageresgit.binarytrees.serialization.SerializationConfig.*;

public class SerializeBinaryTreeBFS implements SerializeBinaryTree {
    // Serialization-Deserialization with BFS
    @Override
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        if (root != null) queue.offer(root);
        int queueSize = queue.size();
        while (queueSize != 0) {
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (sb.length() > 0) sb.append(DELIMITER);
                if (node == NULL_NODE) {
                    sb.append(NULL_NODE_VALUE);
                }
                else {
                    sb.append(node.val);
                    queue.offer(node.left == null ? NULL_NODE : node.left);
                    queue.offer(node.right == null ? NULL_NODE : node.right);
                }
            }
            queueSize = queue.size();
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    @Override
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] strings = data.split(DELIMITER);
        int stringIndex = 0;
        TreeNode root = getNextFromArray(strings, stringIndex++);
        Queue<TreeNode> buildQueue = new ArrayDeque<>();
        if (root != null) buildQueue.offer(root);
        while (stringIndex < strings.length && !buildQueue.isEmpty()) {
            TreeNode next = buildQueue.poll();
            next.left = getNextFromArray(strings, stringIndex++);
            next.right = getNextFromArray(strings, stringIndex++);
            if (next.left != null) buildQueue.offer(next.left);
            if (next.right != null) buildQueue.offer(next.right);
        }
        return root;
    }
}
