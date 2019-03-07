package com.broken.cate.leet.media;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public static int findKthLargest(int[] nums, int start, int end, int k) {
        if (k == 1)
            return nums[start];
        int selected = nums[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i < j && nums[i] <= selected) i++;
            while (i < j && nums[j] >= selected) j--;
            System.out.printf("%d, %d, %d\n", i, j, k);
            swap(nums, i, j);
        }

        swap(nums, start, j);
        int preLen = j - start + 1;
        if (k == preLen)
            return nums[j];
        else if (k < preLen) {
            return findKthLargest(nums, start, j, k);
        } else {
            return findKthLargest(nums, j + 1, end, k - preLen);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

}
