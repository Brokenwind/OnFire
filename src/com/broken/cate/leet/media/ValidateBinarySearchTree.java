package com.broken.cate.leet.media;

import com.broken.cate.leet.TreeNode;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean isleft = isValidBST(root.left);
        boolean isright = isValidBST(root.right);
        int leftValue = root.left == null ? Integer.MIN_VALUE : root.left.val;
        int rightValue = root.right == null ? Integer.MAX_VALUE : root.right.val;
        return isleft && isright && (leftValue < root.val && rightValue > root.val);
    }

    public static void main(String[] args) {

    }
}
