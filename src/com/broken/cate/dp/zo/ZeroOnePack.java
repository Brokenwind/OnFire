package com.broken.cate.dp.zo;

/**
 * Created by Amei on 2017/9/16.
 */
public class ZeroOnePack {
    private int volume;
    private int[] weight;
    private int[] value;
    private int len;
    // 0: means not select the thing, 1: means select the thing
    private int[] status = {0,1};
    public ZeroOnePack(){
        volume = 10;
        weight=new int[]{0,2,2,6,5,4};
        value= new int[]{0,6,3,5,4,6};
        len = value.length-1;
    }

    public int calssical(){
        int[][] res;
        res = new int[len+1][volume+1];
        for ( int i = 1; i <= len; i ++ ){
            for ( int j = weight[i]; j <= volume; j ++ ){
                for ( int k = 0; k < status.length; k ++ ){
                    res[i][j]  = max(res[i][j],res[i - 1][j - status[k] * weight[i]] + status[k] * value[i]);
                }
            }
        }
        return res[len][volume];
    }
    //
    public int classicalImproved(){
        int res[] = new int[volume+1];
        for ( int i = 1; i <= len; i ++ ){
            for ( int j = volume; j > 0; j -- ){
                if ( weight[i] < j )
                res[j] = max(res[j],res[j-weight[i]] + value[i]);
            }
        }
        return res[volume];
    }
    // 完全背包
    public int completePack(){
        int[][] res;
        res = new int[len+1][volume+1];
        for ( int i = 1; i <= len; i ++ ){
            for ( int j = 1; j <= volume; j ++ ){
                res[i][j] = -1;
                for ( int k = 0; k <= 1 && j >= k*weight[i]; k ++ ){
                    res[i][j] = max(res[i][j],res[i - 1][j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return res[len][volume];
    }
    public int max (int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        ZeroOnePack one = new ZeroOnePack();
        System.out.println(one.completePack());
    }
}
