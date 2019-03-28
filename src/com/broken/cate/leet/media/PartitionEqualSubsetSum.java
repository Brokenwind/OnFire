package com.broken.cate.leet.media;

import java.util.*;

public class PartitionEqualSubsetSum {
    public int[][] reconstructQueue(int[][] people) {
        //按身高降序排序(h大的在前面)，按k的大小升序排列(k小的在前面)
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return -a[0] + b[0];
                else return a[1] - b[1];
            }
        });
        //保存结果
        List<int[]> res = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            int[] peo = people[i];
            res.add(peo[1], peo);
        }
        return res.toArray(new int[people.length][]);
    }
}
