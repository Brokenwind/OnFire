package com.broken.cate.leet.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(getRow(3)));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] mid = new int[rowIndex + 1];
        mid[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                mid[j] += mid[j - 1];
            }
        }
        for (int i = 0; i <= rowIndex; i++)
            res.add(mid[i]);
        return res;
    }

    public static int getCompNums(int down, int up) {
        if (down == up)
            return 1;
        if (up == 0)
            return 1;
        if (up == 1)
            return down;
        if (up > down / 2) {
            up = down - up;
        }
        long downMul = 1;
        long upMul = 1;
        for (int i = 1; i <= up; i++) {
            upMul *= i;
            downMul *= (down - i + 1);
        }
        return (int) (downMul / upMul);
    }
}
