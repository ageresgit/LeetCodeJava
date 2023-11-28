package com.github.ageresgit.treeproblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeBinaryTreeDFSTest {
    @Test
    void test01() {
        SerializeBinaryTreeBreadthFirst codec = new SerializeBinaryTreeBreadthFirst();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serial = codec.serialize(root);
        SerializeBinaryTreeBreadthFirst decodec = new SerializeBinaryTreeBreadthFirst();
        TreeNode deserializedRoot = decodec.deserialize(serial);
        assertEquals(root, deserializedRoot);
    }

}