package com.broken.cate.leet.media;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        dfs(nums, target, 0, 0, 3);
        return res;
    }

    static int minRes = Integer.MAX_VALUE;
    static int res = Integer.MAX_VALUE;

    public static void dfs(int[] nums, int target, int tempSum, int start, int count) {
        if (start >= nums.length && count > 0)
            return;
        if (count == 0) {
            if (Math.abs(tempSum - target) < minRes) {
                minRes = Math.abs(tempSum - target);
                res = tempSum;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            dfs(nums, target, tempSum + nums[i], i + 1, count - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSumClosest(nums, 1));
    }
}
