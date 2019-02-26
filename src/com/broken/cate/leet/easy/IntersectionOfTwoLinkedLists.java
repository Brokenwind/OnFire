package com.broken.cate.leet.easy;

import com.broken.cate.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        while (head1 != null) {
            ListNode head2 = headB;
            while (head2 != null) {
                if (head2 == head1) {
                    return head2;
                }
                head2 = head2.next;
            }
            head1 = head1.next;
        }
        return null;

    }
}
