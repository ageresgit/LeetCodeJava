package com.github.ageresgit.treeproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSightView {
    void rightSideViewDFS(TreeNode node, List<Integer> ans, int level) {
        if (node == null) return;
        if (level == ans.size()) ans.add(node.val);
        rightSideViewDFS(node.right, ans, level + 1);
        rightSideViewDFS(node.left, ans, level + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        rightSideViewDFS(root, answer, 0);
        return answer;
    }
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while (!level.isEmpty()) {
            for (int index = level.size(); index > 0; index--) {
                root = level.poll();
                if (root.left != null) level.add(root.left);
                if (root.right != null) level.add(root.right);
                if (index == 1) answer.add(root.val);
            }
        }
        return answer;
    }
}
