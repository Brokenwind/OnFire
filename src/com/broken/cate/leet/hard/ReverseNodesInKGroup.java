package com.broken.cate.leet.hard;

import com.broken.cate.ListNode;

import java.util.List;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] list;
        ListNode start = head;
        ListNode lastEnd = head;
        do {
            list = reverse(start, k);
            lastEnd.next = list[0];
            lastEnd = list[1];
        } while (start != null);
        return null;
    }

    public ListNode[] reverse(ListNode head, int k) {
        ListNode[] res = new ListNode[2];
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && --k >= 0) {
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        res[0] = pre;
        res[1] = cur;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseNodesInKGroup group = new ReverseNodesInKGroup();
        group.reverseKGroup(head, 2);
    }
}
