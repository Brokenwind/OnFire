package com.broken.cate.leet.media;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char[] data = s.toCharArray();
        int start = 0;
        int end = data.length - 1;
        while (start < data.length && data[start] == ' ') start++;
        while (end >= 0 && data[end] == ' ') end--;
        int cur = start;
        for (int i = start + 1; i <= end; i++) {
            if (data[i] == ' ' && data[i - 1] == ' ') {
                continue;
            } else {
                data[++cur] = data[i];
            }
        }
        end = cur;
        reverse(data, start, end);
        int wordStart = start;
        for (int i = start; i <= end; i++) {
            if (i == end) {
                reverse(data, wordStart, end);
            } else if (data[i] == ' ') {
                reverse(data, wordStart, i - 1);
                wordStart = i + 1;
            }
        }
        if (end == start && start >= data.length)
            return "";
        else
            return new String(data, start, end - start + 1);
    }

    public static void reverse(char[] data, int start, int end) {
        int half = start + (end - start + 1) / 2;
        for (int i = start, dis = 0; i < half; i++, dis++) {
            char temp = data[i];
            data[i] = data[end - dis];
            data[end - dis] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  aaa ").length());
    }
}
