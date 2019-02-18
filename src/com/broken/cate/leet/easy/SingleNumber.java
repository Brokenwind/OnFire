package com.broken.cate.leet.easy;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int item : nums) {
            res ^= item;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
