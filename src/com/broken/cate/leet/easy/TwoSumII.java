package com.broken.cate.leet.easy;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            } else if (temp > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;

    }
}
