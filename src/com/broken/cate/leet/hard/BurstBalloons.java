package com.broken.cate.leet.hard;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        //http://www.cnblogs.com/grandyang/p/5006441.html
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        //按照区间长度来，长度从1-n
        for (int len = 1; len <= n; len++) {
            // 区间长度为len的开始位置
            for (int start = 1; start <= n - len + 1; start++) {
                //区间长度为len的结束位置
                int end = start + len - 1;
                //在[start,end]中寻找切分点，使得最后结果最大
                for (int i = start; i <= end; i++) {
                    int cur = newNums[start - 1] * newNums[i] * newNums[end + 1] + dp[start][i - 1] + dp[i + 1][end];
                    dp[start][end] = Math.max(dp[start][end], cur);
                }
            }
        }
        return dp[1][n];

    }
}
