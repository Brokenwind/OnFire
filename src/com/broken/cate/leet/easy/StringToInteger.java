package com.broken.cate.leet.easy;

import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        System.out.println(atoi(data));
    }
    public static int atoi(String data){
        int res = 0;
        int sign = 1;
        int i = 0;
        String s = data.trim();
        char first = s.charAt(0);
        if ( first == '-' || first == '+' ) {
            if ( first == '-' )
                sign = -1;
            i = 1;
        }
        for ( ; i < s.length(); i ++ ){
            if ( s.charAt(i) >= '0' && s.charAt(i) <= '9' )
                res = res * 10 + (s.charAt(i) - '0' );
            else
                break;
        }
        return sign*res;
    }
}
