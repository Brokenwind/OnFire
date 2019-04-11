package com.broken.cate.leet.media;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPattern2 {
    private boolean res = false;

    public boolean wordPattern2(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        wordPatternHelper(pattern, str, map, set, 0, 0);
        return res;
    }

    public void wordPatternHelper(String pattern, String str, HashMap<Character, String> map, Set<String> set, int pCur, int sCur) {
        // 同时到了最后的时候，表示可以匹配
        if (pCur == pattern.length() && sCur == str.length()) {
            res = true;
        }
        // 只有一个到达最后，另一个没有，这时没有找到符合要求的结果
        if (pCur >= pattern.length() || sCur >= str.length()) {
            res = false;
        }
        for (int i = sCur; i < str.length(); i++) {
            char cur = pattern.charAt(i);
            String piece = str.substring(sCur, i + 1);
            // 如果已经存在key,则查看是否对应的字符串是否相同
            if (!map.containsKey(cur) && !set.contains(piece)) {
                set.add(piece);
                map.put(cur, piece);
                wordPatternHelper(pattern, str, map, set, pCur + 1, i);
                set.remove(piece);
                map.remove(cur);
            } else {
                wordPatternHelper(pattern, str, map, set, pCur + 1, i);
            }
        }
    }
}
