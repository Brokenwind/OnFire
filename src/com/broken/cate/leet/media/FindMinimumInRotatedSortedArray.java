package com.broken.cate.leet.media;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[end];
    }

    public static int findMin(int[] nums, int start, int end) {
        end = end >= 0 ? end : 0;
        if (start >= end) {
            return nums[end];
        }
        int mid = (end + start) / 2;
        // 左边有序
        if (nums[mid] > nums[start]) {
            return Math.min(nums[start], findMin(nums, mid + 1, end));
        } else {
            int leftMin = findMin(nums, start, mid - 1);
            int rightMin = findMin(nums, mid + 1, end);
            return Math.min(Math.min(leftMin, rightMin), nums[mid]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(findMin(nums));
    }
}
