package com.broken.cate.leet.hard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return nums;
        // 建立一个大顶堆
        LinkedList<Integer> queue = new LinkedList();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            // 移除不在范围中的数
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.poll();
            }
            // 弹出队列中比当前值小的数，保证队列是梯度下降的
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            // 添加新的值到窗口
            queue.offerLast(i);
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return nums;
        // 建立一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            // 当i >= k时移除不在窗口中的值
            if (i >= k) {
                queue.remove(nums[i - k]);
            }
            // 添加新的值到窗口
            queue.offer(nums[i]);
            // 获取窗口中的最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = queue.peek();
            }
        }

        return res;

    }
}
