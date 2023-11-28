package com.github.ageresgit.binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthOfBinaryTreeTest {

    @Test
    void maxDepthIterationalTest() {
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertEquals(0, m.maxDepthIterational(root.left.right));
        assertEquals(1, m.maxDepthIterational(root.left.left));
        assertEquals(2, m.maxDepthIterational(root.left));
        assertEquals(2, m.maxDepthIterational(root.right));
        assertEquals(3, m.maxDepthIterational(root));
    }

    @Test
    void maxDepthTest() {
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        assertEquals(0, m.maxDepth(root.left.right));
        assertEquals(1, m.maxDepth(root.left.left));
        assertEquals(2, m.maxDepth(root.left));
        assertEquals(2, m.maxDepth(root.right));
        assertEquals(3, m.maxDepth(root));
    }
}