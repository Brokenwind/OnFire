package com.broken.cate.leet.easy;

import com.broken.cate.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len <= 1)
            return true;
        int mid = len / 2;
        int harfRightStart = (len % 2 == 0 ? mid : mid + 1);
        Stack<Integer> stack = new Stack<>();
        node = head;
        for (int i = 0; i < len; i++) {
            if (i < mid) {
                stack.push(node.val);
            }
            if (i >= harfRightStart) {
                if (node.val != stack.pop()) {
                    return false;
                }
            }
            node = node.next;
        }
        return true;
    }
}
