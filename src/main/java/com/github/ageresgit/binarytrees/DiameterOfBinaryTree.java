package com.github.ageresgit.binarytrees;

public class DiameterOfBinaryTree {
    static final NodeData NULL_DATA = new NodeData(-1, -1);
    static class NodeData{
        int height;
        int diameter;

        NodeData(int height, int diameter) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    private NodeData getNodeData(TreeNode node) {
        if (node == null) return NULL_DATA;
        NodeData ll = getNodeData(node.left);
        NodeData rr= getNodeData(node.right);

        return new NodeData(Integer.max(ll.height, rr.height) + 1, Integer.max(Integer.max(ll.diameter, rr.diameter), ll.height + rr.height + 2));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getNodeData(root).diameter;
    }
}
