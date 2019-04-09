package com.broken.cate.leet.media;

public class ShortestUnsortedContinuousSubarray {
    /**
     * Shortest Unsorted Continuous Subarray
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        // [2, 6, 4, 8, 10, 9, 15]
        // [6, 4, 8, 10, 9,18]
        // 一个有序的序列应该是：当前值大于前边的最大值，小于后边的最小值
        int length = nums.length;
        // start = -1, end = -2,是保证当整体有序时，end-start+1 = 0
        int start = -1;
        int end = -2;
        int min = nums[length - 1];
        int max = nums[0];

        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length - i - 1]);

            if (nums[i] < max) {
                end = i;
            }
            if (nums[length - 1 - i] > min) {
                start = length - 1 - i;
            }
        }
        return end - start + 1;
    }

}
