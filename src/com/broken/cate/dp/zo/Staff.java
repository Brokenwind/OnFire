package com.broken.cate.dp.zo;

import java.util.Scanner;

/**
 * Created by Amei on 2017/9/27.
 */
public class Staff implements Runnable {
    String s = "yes";
    public void run(){
        this.s = "no";
    }
    public static void main(String[] args) throws InterruptedException {
        Staff t = new Staff();
        Thread h = new Thread(t);
        h.start();
        h.sleep(1000);
        for ( int i = 0; i < 10; i ++ )
            System.out.println(t.s);

    }
}
