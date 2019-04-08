package com.broken.cate.leet.media;

import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // http://www.cnblogs.com/grandyang/p/7098764.html
        // [“A”,”A”,”A”,”B”,”B”,”B”], n = 2
        // output: 8
        if (tasks == null || tasks.length == 0)
            return 0;
        if (n == 0)
            return tasks.length;
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        for (char item : tasks) {
            count[item - 'A']++;
        }
        Arrays.sort(count, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int max = count[0];
        int i = 0;
        while (i < count.length && max == count[i]) {
            i++;
        }
        return Math.max(tasks.length, (count[0] - 1) * (n + 1) + i);

    }
}
