package com.broken.cate.leet.easy;

import com.broken.cate.leet.TreeNode;

public class SubtreeAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean res = equalTree(s.left, t) || equalTree(s.right, t) || equalTree(s, t);
        if (res == true) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean equalTree(TreeNode s, TreeNode t) {
        if ((s == null && t == null)) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equalTree(s.left, t.left) && equalTree(s.right, t.right);
    }

}
