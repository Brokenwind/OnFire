package com.broken.cate.leet.media;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        // start - end 至少相差三个数
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            }
            // A[mid] 小于两边
            else {
                end = mid;
            }
        }
        if (nums[start] < nums[end])
            return end;
        else {
            return start;
        }
    }
}
