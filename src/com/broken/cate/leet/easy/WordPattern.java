package com.broken.cate.leet.media;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] pieces = str.split(" ");
        if (pieces.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pieces.length; i++) {
            char cur = pattern.charAt(i);
            // 如果已经存在key,则查看是否对应的字符串是否相同
            if (map.containsKey(cur)) {
                if (!map.get(cur).equals(pieces[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), pieces[i]);
                set.add(pieces[i]);
            }
        }

        return true;
    }
}
