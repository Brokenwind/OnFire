package com.broken.cate.leet.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama1"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ((cur >= '0' && cur <= '9') || (cur >= 'a' && cur <= 'z') ) {
                builder.append(cur);
            }
        }
        String filted = builder.toString();
        for (int i = 0; i < filted.length() / 2; i++) {
            if (filted.charAt(i) != filted.charAt(filted.length() - 1 - i))
                return false;
        }

        return true;
    }
}
