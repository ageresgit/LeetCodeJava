package com.github.ageresgit.treeproblems;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    boolean isSymmetricTrees(TreeNode a, TreeNode b) {
        if (a == null) return (b == null);
        return (b!= null && a.val == b.val && isSymmetricTrees(a.right, b.left) && isSymmetricTrees(a.left, b.right));
    }
    public boolean isSymmetric(TreeNode root) {
        return (root == null || isSymmetricTrees(root.left, root.right));
    }
    public boolean isSymmetricBF(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> lTree = new LinkedList<>(), rTree = new LinkedList<>();
        lTree.add(root.left);
        rTree.add(root.right);
        while (!lTree.isEmpty() || !rTree.isEmpty()) {
            for (int index = 0; index < lTree.size(); index++) {
                TreeNode l = lTree.poll(), r = rTree.poll();
                if (l == null && r == null) continue;
                if (r == null || l == null || r.val != l.val) return false;
                lTree.add(l.left);
                lTree.add(l.right);
                rTree.add(r.right);
                rTree.add(r.left);
            }
        }
        return true;
    }
    boolean isSymmetricStructure(TreeNode l, TreeNode r) {
        if (r == null && l == null) return true;
        if (r == null || l == null) return false;
        if (r.val != l.val) return false;
        if (!(r.left == null && l.right == null || r.left != null && l.right != null)) return false;
        if (!(l.left == null && r.right == null || l.left != null && r.right != null)) return false;
        return true;
    }
    public boolean isSymmetricBF2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> lTree = new ArrayDeque<>(), rTree = new ArrayDeque<>();
        if (root.left != null) lTree.add(root.left);
        if (root.right != null) rTree.add(root.right);
        while (!lTree.isEmpty() || !rTree.isEmpty()) {
            if (lTree.size() != rTree.size()) return false;
            for (int index = 0; index < lTree.size(); index++) {
                TreeNode l = lTree.poll(), r = rTree.poll();
                if (!isSymmetricStructure(l, r)) return false;
                if (l.left != null) lTree.add(l.left);
                if (l.right != null) lTree.add(l.right);
                if (r.right != null) rTree.add(r.right);
                if (r.left != null) rTree.add(r.left);
            }
        }
        return true;
    }
}
