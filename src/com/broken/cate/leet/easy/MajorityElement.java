package com.broken.cate.leet.easy;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int num = map.get(nums[i]) + 1;
                map.put(nums[i], num);
                if (num > nums.length / 2)
                    return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
