package com.broken.cate.leet.hard;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        // https://www.geeksforgeeks.org/remove-invalid-parentheses/
        List<String> res = new ArrayList<>();
        // 存储访问过的字符串
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean level = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValidParentheses(cur)) {
                res.add(cur);
                level = true;
            }
            // 题目要求最少的删除次数
            // 如果已经找到结果,就不用继续去删除括号来寻找,不然会增加删除次数
            if (level)
                continue;
            for (int i = 0; i < cur.length(); i++) {
                // 当遇上括号的时候才进行处理
                if (cur.charAt(i) == ')' || cur.charAt(i) == '(') {
                    String cutted = new StringBuffer(cur).deleteCharAt(i).toString();
                    System.out.println(cutted.length());
                    // 将没用访问过的字符串放入Set中
                    if (!visited.contains(cutted)) {
                        visited.add(cutted);
                        queue.offer(cutted);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValidParentheses(String s) {
        int cnt = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                cnt++;
            } else if (chr == ')') {
                cnt--;
            } else {
                continue;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return (cnt == 0);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(removeInvalidParentheses(")(")));
        System.out.println(isValidParentheses(""));
    }

}
