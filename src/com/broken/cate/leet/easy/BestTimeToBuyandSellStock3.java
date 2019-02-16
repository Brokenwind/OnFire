package com.broken.cate.leet.easy;

import com.alibaba.fastjson.JSON;

public class BestTimeToBuyandSellStock3 {
    public static void main(String[] args) {
        int[] data = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(data));
    }

    public static int maxProfit(int[] prices) {
        //https://www.cnblogs.com/springfor/p/3877068.html
        if (prices == null || prices.length == 0)
            return 0;
        // 计算[0,i] 区间中,一次交易的最大利润
        int min = prices[0];
        int[] front = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            front[i] = Math.max(front[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }

        // 计算[i,prices.length-1] 区间中,一次交易的最大利润
        int max = prices[prices.length - 1];
        int[] back = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            back[i] = Math.max(back[i + 1], max - prices[i]);
            max = Math.max(prices[i], max);
        }

        int maxRes = 0;
        //System.out.println(JSON.toJSONString(front));
        //System.out.println(JSON.toJSONString(back));
        for (int i = 0; i < prices.length; i++) {
            maxRes = Math.max(front[i] + back[i], maxRes);
        }

        return maxRes;
    }


    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        int min = prices[0];
        int arrayA[] = new int[len];

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            arrayA[i] = Math.max(arrayA[i - 1], prices[i] - min);
        }

        int max = prices[len - 1];
        int arrayB[] = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            arrayB[i] = Math.max(max - prices[i], arrayB[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, arrayA[i] + arrayB[i]);
        }

        return maxProfit;
    }
}
