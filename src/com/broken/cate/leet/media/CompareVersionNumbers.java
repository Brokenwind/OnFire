package com.broken.cate.leet.media;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len1 = split1.length;
        int len2 = split2.length;
        if (len1 == 0) {
            split1 = new String[1];
            split1[0] = version1;
        }
        if (len2 == 0) {
            split2 = new String[1];
            split2[0] = version2;
        }
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            int data1 = 0;
            int data2 = 0;
            if (split1[i].length() != 0) {
                data1 = Integer.valueOf(split1[i]);
            }
            if (split2[i].length() != 0) {
                data2 = Integer.valueOf(split2[i]);
            }
            System.out.printf("%d %d\n", data1, data2);
            if (data1 == data2) {
                continue;
            } else if (data1 > data2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (minLen == split1.length && minLen == split2.length) {
            return 0;
        } else if (minLen == split1.length) {
            int i = minLen;
            while (i < split2.length) {
                if (Integer.valueOf(split2[i++]) > 0)
                    return -1;
            }
        } else {
            int i = minLen;
            while (i < split1.length) {
                if (Integer.valueOf(split1[i++]) > 0)
                    return 1;
            }
        }
        return 0;

    }
}
