package com.broken.cate.leet.media;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        int area = 0;
        while( i < j ){
            area = (j-i) * Math.min(height[i],height[j]);
            if ( area > max ){
                max = area;
            }
            if ( height[i] < height[j] ){
                i ++;
            }else{
                j --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(data));
    }
}
