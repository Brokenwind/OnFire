package com.broken.cate.leet.media;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //https://www.cnblogs.com/grandyang/p/6810361.html
        int res = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            // 如果sum - k 在map中存在，则说明此时数组中有和为K的子数组
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return res;

    }
}
