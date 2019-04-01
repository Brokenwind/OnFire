package com.broken.cate.leet.easy;

import com.broken.cate.leet.TreeNode;

public class DiameterOfBinaryTree {
    // https://www.cnblogs.com/grandyang/p/6607318.html

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 不能只是以根节点为准
        int twoSide = maxDeep(root.left) + maxDeep(root.right);
        return Math.max(twoSide, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public int maxDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }
}
