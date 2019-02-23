package com.broken.cate.leet.media;

public class FindMinimumInRotatedSortedArray2 {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] == nums[end]) {
                end--;
            } else {
                end = mid;
            }
        }
        return nums[end];
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 2};
        System.out.println(findMin(nums));
    }
}
