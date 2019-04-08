package com.broken.cate.leet.media;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int num = s.length();
        boolean[][] isPalind = new boolean[num][num];
        int count = 0;
        for (int end = 0; end < num; end++) {
            for (int start = 0; start <= end; start++) {
                isPalind[start][end] = (s.charAt(start) == s.charAt(end) && ((end - start) <= 2 || isPalind[start + 1][end - 1]));
                if (isPalind[start][end]) {
                    //System.out.println(s.substring(start, end + 1));
                    count++;
                }
            }
        }
        return count;

    }
}
