package com.broken.cate.leet.media;

import java.util.Scanner;

/**
 * 要求：
 给定字符串，求它的回文子序列个数。回文子序列反转字符顺序后仍然与原序列相同。例如字符串aba中，
 回文子序列为"a", "a", "aa", "b", "aba"，共5个。内容相同位置不同的子序列算不同的子序列。

 思路：
 动态规划思想
 对于任意字符串，如果头尾字符不相等，则字符串的回文子序列个数就等于去掉头的字符串的回文子序列
 个数+去掉尾的字符串的回文子序列个数-去掉头尾的字符串的回文子序列个数；如果头尾字符相等，
 那么除了上述的子序列个数之外，还要加上首尾相等时新增的子序列个数，1+去掉头尾的字符串的回文子序列个数，
 1指的是加上头尾组成的回文子序列，如aa，bb等。
 因此动态规划的状态转移方程为：
 设字符串为str，长度为n，p[i][j]表示第i到第j个字符间的最长子序列的长度（i<=j），则：
 状态初始条件：dp[i][i]=1 （i=0：n-1）
 状态转移方程：dp[i][j]=dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]  if（str[i]！=str[j]）
 dp[i][j]=dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]+dp[i+1][j-1]+1=dp[i+1][j] + dp[i][j-1]+1  if （str[i]==str[j]）
 */

public class LongestPalindromicSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        System.out.println(longest(data));
    }
    public static int longest(String data){
        int len = data.length();
        int[][] dp = new int[len][len];
        for ( int right = 0; right < len; right ++ ){
            dp[right][right] = 1;
            for ( int left = right - 1; left >= 0; left -- ){
                if ( data.charAt(left) == data.charAt(right) )
                    dp[left][right] = dp[left+1][right-1] + 2;
                else{
                    dp[left][right] = Math.max(dp[left+1][right],dp[left][right-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
