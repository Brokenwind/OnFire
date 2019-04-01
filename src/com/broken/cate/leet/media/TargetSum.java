package com.broken.cate.leet.media;

public class TargetSum {
    // https://www.cnblogs.com/zhonghuasong/p/9369882.html
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        // sum + S 不是偶数以及S大于sum的时候都没有结果，返回0
        if (((sum + S) & 1) == 1 || S > sum) {
            return 0;
        }

        return subsetSum(nums, (sum + S) / 2);
    }

    /**
     * 求数组中子集加起来等于sum的组合的个数
     *
     * @param nums
     * @param sum
     * @return
     */
    public int subsetSum(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int item : nums) {
            for (int i = sum; i >= item; i--) {
                dp[i] += dp[i - item];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        TargetSum sum = new TargetSum();
        // the final result should be  5
        System.out.println(sum.findTargetSumWays(nums, 3));
    }
}
