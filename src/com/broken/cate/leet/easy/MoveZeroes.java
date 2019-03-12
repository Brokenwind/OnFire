package com.broken.cate.leet.easy;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0;
        int zero = 0;
        int nozero = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            zero = i;
            while (i < nums.length && nums[i] == 0) i++;
            nozero = i;
            if (zero < nums.length && nozero < nums.length) {
                swap(nums, zero, nozero);
                // important
                i = zero + 1;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
