package com.broken.cate.leet.media;

public class MaximumProductSubarray {
    // https://www.cnblogs.com/grandyang/p/4028713.html
    public static int maxProduct(int[] nums) {
        // [0-i]中包括第i个值,并连续乘积值最大是多少
        int[] max = new int[nums.length];
        // [0-i]中包括第i个值,并连续乘积值最小是多少
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int maxRes = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            if (max[i] > maxRes)
                maxRes = max[i];
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, -2, 4};
        System.out.println(maxProduct(data));
    }
}
