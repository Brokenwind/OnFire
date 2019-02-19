package com.broken.cate.leet.media;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0)
            return -1;
        if (gas.length != cost.length)
            return -1;
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int have = 0;
            // count 统计次数
            int count = 0;
            for (int j = i; count < len; j = (j + 1) % len, count++) {
                have += (gas[j] - cost[j]);
                // 当前量无法到达下一个节点
                if (have < 0) {
                    break;
                }
            }
            // 完成一个循环
            if (count == len)
                return i;
        }
        return -1;
    }
}
