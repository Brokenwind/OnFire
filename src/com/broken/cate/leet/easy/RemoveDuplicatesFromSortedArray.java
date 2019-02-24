package com.broken.cate.leet.easy;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int newIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newIndex]) {
                nums[++newIndex] = nums[i];
            }
        }
        return newIndex + 1;
    }
}
