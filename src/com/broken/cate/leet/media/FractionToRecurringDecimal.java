package com.broken.cate.leet.media;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuffer res = new StringBuffer();
        long numer = numerator;
        long denom = denominator;
        if (numer < 0 ^ denom < 0) {
            res.append("-");
        }
        if (denom == 0) {
            return "0";
        }
        numer = Math.abs(numer);
        denom = Math.abs(denom);
        res.append(numer / denom);
        long reminder = numer % denom;
        if (reminder == 0) {
            return res.toString();
        }
        res.append(".");
        int index = res.length();
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                res.insert(map.get(reminder), "(");
                res.append(")");
                break;
            }
            map.put(reminder, index++);
            reminder *= 10;
            res.append(reminder / denom);
            reminder = reminder % denom;

        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1,-2147483648));
    }
}
