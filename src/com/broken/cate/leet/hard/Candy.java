package com.broken.cate.leet.hard;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1])
                res[i] = res[i - 1] + 1;
        }
        for (int i = res.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] < res[i + 1] + 1)
                res[i] = res[i + 1] + 1;
        }
        int sum = 0;
        for (int item : res)
            sum += item;
        return sum;
    }
}
