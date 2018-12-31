package com.broken.cate.leet.media;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        HashSet set = new HashSet();
        int len = 0;
        int left = 0;
        int max = 0;
        int start = 0;
        for ( int i = 0; i < line.length(); i ++ ){
            if ( set.contains(line.charAt(i)) ){
                len = i - left;
                if ( len > max ) {
                    max = len;
                    start = left;
                }
                left = i;
                set.clear();
                set.add(line.charAt(i));
            }
            else{
                set.add(line.charAt(i));
            }
        }
        System.out.println(max);
        System.out.println(line.substring(start,start+max));
    }
}
