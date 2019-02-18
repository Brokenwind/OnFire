package com.broken.cate.leet.media;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partition(s, res, temp);
        return res;
    }

    public static void partition(String s, List<List<String>> res, List<String> temp) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String seg = s.substring(0, i);
            if (isPalindrome(seg)) {
                temp.add(seg);
                partition(s.substring(i), res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String temp) {
        if (temp == null || temp.length() == 0)
            return false;
        if (temp.length() == 1)
            return true;
        int half = (temp.length() + 1) / 2;
        for (int i = 0; i < half; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
