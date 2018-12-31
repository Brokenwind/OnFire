package com.broken.cate.leet.hard;

import java.util.Arrays;

/**
 * 这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，
 * 看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
 * 但是这道题被定义为Hard也是有其原因的，难就难在要在两个未合并的有序数组之间使用二分法，
 * 这里我们需要定义一个函数来找到第K个元素，由于两个数组长度之和的奇偶不确定，因此需要分情况来讨论，
 * 对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。
 * 下面重点来看如何实现找到第K个元素，首先我们需要让数组1的长度小于或等于数组2的长度，
 * 那么我们只需判断如果数组1的长度大于数组2的长度的话，交换两个数组即可，
 * 然后我们要判断小的数组是否为空，为空的话，直接在另一个数组找第K个即可。还有一种情况是当K = 1时，
 * 表示我们要找第一个元素，只要比较两个数组的第一个元素，返回较小的那个即可。
 */
public class MedianOfTwoSortedArrays {
        public static void main(String[] args) {
            
        }
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
            return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
        }
        public static int  findKth(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            if (m > n) return findKth(nums2, nums1, k);
            if (m == 0) return nums2[k - 1];
            if (k == 1) return Math.min(nums1[0], nums2[0]);
            int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
            if (nums1[i - 1] > nums2[j - 1]) {
                return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
            } else {
                return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
            }
        }
}

