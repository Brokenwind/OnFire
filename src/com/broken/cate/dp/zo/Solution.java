package com.broken.cate.dp.zo;

import java.util.*;
/**
 * Created by Amei on 2017/9/27.
 */
public class Solution {
    int[] data = new int[4];
    int tar;
    int res = 0;

    int findMaxMolecules(int massA, int massB, int massC, int massD, int massX){
        data[0] = massA;
        data[1] = massB;
        data[2] = massC*2;
        data[3] = massD*2;
        tar = massX;
        Arrays.sort(data);
        greedy(0,tar,0);
        return res;
    }
    public void greedy(int k, int left ,int count){
        if ( k >= 4 && left != 0 )
            return;
        if ( left == 0 ){
            if ( count > res )
                res = count;
            return;
        }
        int cur = data[k];
        for ( int i = 0; i <= left/cur; i ++ ){
            greedy(k+1,left-cur*i,count+i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[4];
        for ( int i = 0; i < 4; i ++ ) {
            data[i] = scanner.nextInt();
        }
        int tar = scanner.nextInt();
        Solution m = new Solution();
        System.out.println(m.findMaxMolecules(data[0],data[1],data[2],data[3],tar));
    }
}
