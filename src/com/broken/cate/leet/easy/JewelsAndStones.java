package com.broken.cate.leet.easy;

import java.util.Arrays;

public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[256];
        Arrays.fill(jewels, false);
        for (char jewel : J.toCharArray()) {
            jewels[jewel] = true;
        }
        int count = 0;
        for (char stone : S.toCharArray()) {
            if (jewels[stone]) {
                count++;
            }
        }
        return count;
    }
}
