package com.broken.cate.leet.media;

import com.broken.cate.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftStart = head;
        ListNode slow = head;
        ListNode quick = head;
        // 找到中点
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        // 右半边的开始位置
        ListNode rightStart = slow.next;
        // 从中点断开
        slow.next = null;

        ListNode sortLeft = sortList(leftStart);
        ListNode sortRight = sortList(rightStart);

        return merge(sortLeft, sortRight);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (left != null || right != null) {
            while (left != null && (right == null || left.val <= right.val)) {
                pre.next = left;
                left = left.next;
                pre = pre.next;
            }
            while (right != null && (left == null || left.val > right.val)) {
                pre.next = right;
                right = right.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
