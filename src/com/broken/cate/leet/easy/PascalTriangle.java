package com.broken.cate.leet.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generate(5)));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1)
            return res;
        else if (numRows == 1) {
            res.add(Arrays.asList(1));
            return res;
        } else if (numRows == 2) {
            res.add(Arrays.asList(1));
            res.add(Arrays.asList(1, 1));
            return res;
        } else {
            res.add(Arrays.asList(1));
            res.add(Arrays.asList(1, 1));
            for (int i = 3; i <= numRows; i++) {
                List<Integer> pre = res.get(res.size() - 1);
                List<Integer> line = new ArrayList<>();
                line.add(1);
                for (int j = 1; j < pre.size(); j++) {
                    line.add(pre.get(j - 1) + pre.get(j));
                }
                line.add(1);
                res.add(line);
            }

            return res;
        }
    }
}
