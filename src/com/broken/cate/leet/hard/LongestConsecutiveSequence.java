package com.broken.cate.leet.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        Set<Integer> set = new HashSet<>();
        int maxRes = 0;
        for (int item : nums) {
            set.add(item);
        }
        for (int item : nums) {
            int length = 1;
            for (int data = item - 1; set.contains(data); length++, data--) {
                set.remove(data);
            }
            for (int data = item + 1; set.contains(data); length++, data++) {
                set.remove(data);
            }
            maxRes = Math.max(maxRes, length);
        }
        return maxRes;
    }
}
