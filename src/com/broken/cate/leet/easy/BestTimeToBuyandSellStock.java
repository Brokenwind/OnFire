package com.broken.cate.leet.easy;

public class BestTimeToBuyandSellStock {
    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(data));
    }

    public static int maxProfit(int[] prices) {
        int maxRes = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxRes = Math.max(maxRes, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return maxRes;
    }
}
