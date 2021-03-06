package com.broken.cate.leet;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2)
            return res;
        //copy original list and sort
        int[] copylist = new int[numbers.length];
        System.arraycopy(numbers, 0, copylist, 0, numbers.length);
        Arrays.sort(copylist);
        int low = 0;
        int high = copylist.length - 1;
        while (low < high) {
            if (copylist[low] + copylist[high] < target)
                low++;
            else if (copylist[low] + copylist[high] > target)
                high--;
            else {
                res[0] = copylist[low];
                res[1] = copylist[high];
                break;
            }
        }
        //find index from original list
        int index1 = -1, index2 = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == res[0] && index1 == -1)
                index1 = i + 1;
            else if (numbers[i] == res[1] && index2 == -1)
                index2 = i + 1;
        }
        res[0] = index1;
        res[1] = index2;
        Arrays.sort(res);
        return res;
    }

}
