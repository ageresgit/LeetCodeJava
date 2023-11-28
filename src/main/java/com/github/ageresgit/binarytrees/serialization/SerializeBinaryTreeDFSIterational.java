package com.github.ageresgit.binarytrees.serialization;

import com.github.ageresgit.binarytrees.TreeNode;

import java.util.Stack;

import static com.github.ageresgit.binarytrees.serialization.SerializationConfig.*;

public class SerializeBinaryTreeDFSIterational implements SerializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder tree2Str = new StringBuilder();
        Stack<TreeNode> treeNodes = new Stack<>();
        while (root != null || !treeNodes.empty()) {
            serializeNode(root, tree2Str);
            if (root != null) {
                root = treeNodes.push(root).left;
            }
            else {
                root = treeNodes.pop().right;
            }
        }

        return tree2Str.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strings = data.split(DELIMITER);
        int stringIndex = 0;
        TreeNode root = getNextFromArray(strings, stringIndex++);
        TreeNode upper = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || upper != null) {
            if (upper != null) {
                nodeStack.push(upper);
                upper.left = getNextFromArray(strings, stringIndex++);
                upper = upper.left;
            }
            else {
                upper = nodeStack.pop();
                upper.right = getNextFromArray(strings, stringIndex++);
                upper = upper.right;
            }
        }

        return root;
    }
}
