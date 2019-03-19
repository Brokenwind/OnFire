package com.broken.cate.leet.media;

import java.util.*;

public class TopKFrequentElements {


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> key_cnt = new HashMap();
        for (int key : nums) {
            if (key_cnt.containsKey(key)) {
                key_cnt.put(key, key_cnt.get(key) + 1);
            } else {
                key_cnt.put(key, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList(key_cnt.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        list.subList(k, list.size()).clear();
        List<Integer> res = new LinkedList<Integer>();
        Iterator<Map.Entry<Integer, Integer>> iter = list.iterator();
        int tmpk = k;
        while (iter.hasNext() && tmpk > 0) {
            Map.Entry<Integer, Integer> entry = iter.next();
            res.add(entry.getKey());
        }

        return res;
    }
}
