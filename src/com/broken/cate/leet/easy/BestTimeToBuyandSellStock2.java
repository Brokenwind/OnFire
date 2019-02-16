package com.broken.cate.leet.easy;

public class BestTimeToBuyandSellStock2 {
    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(data));
    }

    public static int maxProfit(int[] prices) {
        int maxRes = 0;
        int inPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > inPrice) {
                maxRes += (prices[i] - inPrice);
                inPrice = prices[i];
            }else{
                inPrice = prices[i];
            }
        }
        return maxRes;
    }
}
