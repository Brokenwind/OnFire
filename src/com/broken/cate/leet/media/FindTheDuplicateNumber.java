package com.broken.cate.leet.media;

import java.util.HashSet;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int item : nums) {
            if (set.contains(item)) {
                return item;
            } else {
                set.add(item);
            }
        }
        return 0;

    }
}
