package com.broken.cate.leet.hard;

import java.util.Arrays;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        // 计算dp[i][j], 字符串下标i-j的子串是否为回文
        boolean[][] isPalind = new boolean[s.length()][s.length()];
        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start <= end; start++) {
                isPalind[start][end] = (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalind[start + 1][end - 1]));
            }
        }

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isPalind[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[s.length()];
    }
}
