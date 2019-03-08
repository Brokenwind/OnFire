package com.broken.cate.leet.media;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        int[] res = new int[nums.length];
        pre[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            pre[i + 1] = pre[i] * nums[i];
        }
        suf[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            suf[i - 1] = suf[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * suf[i];
        }
        return res;
    }
}
