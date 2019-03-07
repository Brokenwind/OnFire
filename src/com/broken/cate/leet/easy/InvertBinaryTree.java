package com.broken.cate.leet.easy;

import com.broken.cate.leet.TreeNode;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public static void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
