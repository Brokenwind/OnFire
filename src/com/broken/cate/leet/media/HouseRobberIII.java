package com.broken.cate.leet.media;

import com.broken.cate.leet.TreeNode;

public class HouseRobberIII {
    public static int rob(TreeNode root) {
        if (root == null)
            return 0;
        return rob3(root, false);

    }

    public static int rob3(TreeNode root, boolean parentRobbed) {
        if (root == null) {
            return 0;
        }
        // 如果父节点没有被抢劫，则可以抢劫当前点，也可以不抢劫当前点
        if (!parentRobbed) {
            int choosed = rob3(root.left, true) + rob3(root.right, true) + root.val;
            int notChoonsed = rob3(root.left, false) + rob3(root.right, false);
            return Math.max(choosed, notChoonsed);
        }
        // 如果父节点被抢劫，则不能抢劫改点
        else {
            return rob3(root.left, false) + rob3(root.right, false);
        }
    }
}
