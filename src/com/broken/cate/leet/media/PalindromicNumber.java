package com.broken.cate.leet.media;

import java.util.Scanner;

/**
 *
 要求：
 给定字符串，求它的回文子序列个数。回文子序列反转字符顺序后仍然与原序列相同。
 例如字符串aba中，回文子序列为"a", "a", "aa", "b", "aba"，共5个。
 内容相同位置不同的子序列算不同的子序列。

 思路:

 */
public class PalindromicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        System.out.println(count(data));

    }
    public static int count(String data){
        int len = data.length();
        int[][] dp = new int[len][len];
        for ( int right = 0; right < len; right ++ ){
            dp[right][right] = 1;
            for ( int left = right - 1; left >= 0; left -- ){
                if ( data.charAt(left) == data.charAt(right) ){
                    dp[left][right] = dp[left + 1][right] + dp[left][right - 1] + 1;
                }
                else
                {
                    dp[left][right] = dp[left + 1][right] + dp[left][right - 1] - dp[left+1][right-1];
                }
            }
        }
        return dp[0][len-1];
    }
}
