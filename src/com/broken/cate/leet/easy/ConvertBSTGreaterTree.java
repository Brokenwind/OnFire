package com.broken.cate.leet.easy;

import com.broken.cate.leet.TreeNode;

import java.util.*;

public class ConvertBSTGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        //[5,2,13]
        //[18,20,13]
        if (root == null)
            return root;
        List<TreeNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            nodes.add(cur);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        System.out.println(nodes.size());
        nodes.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        int curVal = 0;
        for (TreeNode node : nodes) {
            curVal += node.val;
            System.out.println(node.val);
            node.val = curVal;
        }
        return root;

    }
}
