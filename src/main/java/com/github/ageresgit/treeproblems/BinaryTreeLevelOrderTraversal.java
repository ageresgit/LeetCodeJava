package com.github.ageresgit.treeproblems;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        List<List<Integer>> listList = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> nextList = new ArrayList<>();
            for (int index = level.size(); index > 0; index--) {
                TreeNode node = level.poll();
                nextList.add(node.val);
                if (node.left != null) level.add(node.left);
                if (node.right != null) level.add(node.right);
            }
            listList.add(nextList);
        }
        return listList;
    }
}
