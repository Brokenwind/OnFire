package com.broken.cate.leet.media;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += (nums[i] >> j) & 0x1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= ((count[i] % 3) << i);
        }
        return res;
    }
}
