package com.broken.cate.leet.media;

import com.broken.cate.leet.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {

    }

    private static int sum = 0;

    public static int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        return sumNumbers(root.left, sum * 10 + root.val) + sumNumbers(root.right, sum * 10 + root.val);
    }

}
