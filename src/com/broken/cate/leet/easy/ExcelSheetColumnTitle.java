package com.broken.cate.leet.easy;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuffer buffer = new StringBuffer();
        int data = n;
        while (data > 26) {
            int rest = (data - 1) % 26;
            data = (data - 1) / 26;
            buffer.insert(0, (char) ('A' + rest));
        }
        buffer.insert(0, (char) ('A' + data - 1));

        return buffer.toString();
    }
}
