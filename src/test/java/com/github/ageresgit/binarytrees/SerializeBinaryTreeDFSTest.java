package com.github.ageresgit.binarytrees;

import com.github.ageresgit.binarytrees.serialization.SerializeBinaryTreeDFS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SerializeBinaryTreeDFSTest {
    static private TreeNode tree12345;
    SerializeBinaryTreeDFS sbt = new SerializeBinaryTreeDFS();

    @BeforeAll
    static void setAll() {
        tree12345 = new TreeNode(1);
        tree12345.left = new TreeNode(2);
        tree12345.right = new TreeNode(3);
        tree12345.right.left = new TreeNode(4);
        tree12345.right.right = new TreeNode(5);
    }

    @Test
    void serializeTest() {
        Assertions.assertEquals("1 2 n n 3 4 n n 5 n n", sbt.serialize(tree12345));
    }

    @Test
    void deserialize() {
        SameTree equalizer = new SameTree();
        Assertions.assertTrue(equalizer.isSameTree(tree12345, sbt.deserialize("1 2 n n 3 4 n n 5 n n")));
    }
}