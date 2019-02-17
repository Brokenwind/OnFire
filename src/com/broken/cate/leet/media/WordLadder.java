package com.broken.cate.leet.media;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {

    }

    /**
     * 参考: https://segmentfault.com/a/1190000010639103
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 找到通向结尾的路径,返回
                if (cur.equals(endWord)) {
                    return steps + 1;
                }
                for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                    String temp = iterator.next();
                    if (isValid(cur, temp)) {
                        iterator.remove();
                        queue.offer(temp);
                    }
                }
            }
            steps++;
        }
        // 如果没有找到 这样的路径直接返回0
        return 0;
    }

    public static boolean isValid(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0, count = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i) && ++count > 1) {
                return false;
            }
        }
        return true;
    }
}
