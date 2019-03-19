package com.broken.cate.leet.media;

public class CountingBits {
    public int[] countBits(int num) {
        //https://www.cnblogs.com/grandyang/p/5294255.html
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num == 0)
            return res;
        res[1] = 1;
        if (num == 1)
            return res;
        int k = 1, i = 2;
        while (i <= num) {
            for (i = (int) Math.pow(2, k); i < Math.pow(2, k + 1); ++i) {
                if (i > num) break;
                int t = (int) Math.pow(2, k - 1);
                if (i < Math.pow(2, k) + t) {
                    res[i] = res[i - t];
                } else {
                    res[i] = (res[i - t] + 1);
                }
            }
            ++k;
        }
        return res;
    }
}
