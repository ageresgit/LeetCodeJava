package com.github.ageresgit.binarytrees.serialization;

import com.github.ageresgit.binarytrees.TreeNode;

public interface SerializeBinaryTree {
    /// Encodes a tree to a single string.
    String serialize(TreeNode root);

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data);
}
