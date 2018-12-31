package com.broken.cate.leet.media;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这道题让我们求最长回文子串，首先说下什么是回文串，就是正读反读都一样的字符串，
 * 比如 "bob", "level", "noon" 等等。那么最长回文子串就是在一个字符串中的那个最长的回文子串。
 * LeetCode中关于回文串的题共有五道，除了这道，其他的四道为 Palindrome Number 验证回文数字，
 * Validate Palindrome 验证回文字符串， Palindrome Partitioning 拆分回文串，
 * Palindrome Partitioning II 拆分回文串之二，我们知道传统的验证回文串的方法就是两个两个的对称验证是否相等，
 * 那么对于找回文字串的问题，就要以每一个字符为中心，像两边扩散来寻找回文串，这个算法的时间复杂度是O(n*n)，
 * 可以通过OJ，就是要注意奇偶情况，由于回文串的长度可奇可偶，比如"bob"是奇数形式的回文，
 * "noon"就是偶数形式的回文，两种形式的回文都要搜索，参见代码如下：
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        int[] count = new int[data.length()];
        Arrays.fill(count,1);
        //System.out.println(Solution1(data));
        System.out.println(longest(data));
    }

    public static String Solution1(String data){
        int max = 0;
        int left = 0;
        int right = 0;
        for ( int i = 0; i < data.length() - 1; i ++ ){
            for ( int j = i + 1; j < data.length(); j ++ ){
                if ( isPaliindromic(data,i,j) ){
                    if ( j - i > max ){
                        max = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return data.substring(left,right+1);
    }

    public static  boolean isPaliindromic(String data, int left, int right){
        boolean res = true;
        int len = right - left + 1;
        int i,j,mid;
        mid = left + len / 2;
        if ( len % 2 == 0 ){
            i = mid - 1;
            j = mid;
        }
        else{
            i = mid - 1;
            j = mid + 1;
        }
        for ( ; i >= left && j <= right; i --, j ++ ){
            if ( data.charAt(i) != data.charAt(j) ) {
                res = false;
                break;
            }
        }
        return res;
    }

    // 动态规划解法
    public static String longest(String data){
        int len = data.length();
        int max = 0;
        int start = 0,end = 0;
        boolean[][] dp = new boolean[len][len];
        for ( int i = 0; i < len; i ++ )
            Arrays.fill(dp[i],false);
        for ( int right = 0; right < len; right ++ ){
            for ( int left = 0; left <= right; left ++ ){
                if ( right - left <= 1 ){
                    dp[left][right] = (data.charAt(left) == data.charAt(right));
                }
                else {
                    dp[left][right] = ( data.charAt(left) == data.charAt(right) && dp[left+1][right-1]);
                }
                if ( dp[left][right] && (right - left + 1 > max )){
                    max = right - left + 1;
                    start = left;
                }
            }
        }
        return data.substring(start, start+max);
    }

}
