package com.broken.cate.dp.zo;

import java.util.Scanner;

/**
 * Created by Amei on 2017/9/17.
 * New semester is coming, and DuoDuo has to go to school tomorrow. She decides to have fun tonight and will be very busy after tonight. She like watch cartoon very much. So she wants her uncle to buy some movies and watch with her tonight. Her grandfather gave them L minutes to watch the cartoon. After that they have to go to sleep.

 DuoDuo list N piece of movies from 1 to N. All of them are her favorite, and she wants her uncle buy for her. She give a value Vi (Vi > 0) of the N piece of movies. The higher value a movie gets shows that DuoDuo likes it more. Each movie has a time Ti to play over. If a movie DuoDuo choice to watch she won‘t stop until it goes to end.

 But there is a strange problem, the shop just sell M piece of movies (not less or more then), It is difficult for her uncle to make the decision. How to select M piece of movies from N piece of DVDs that DuoDuo want to get the highest value and the time they cost not more then L. How clever you are! Please help DuoDuo‘s uncle.

 Input

 The first line of the input file contains a single integer t (1 ≤ t ≤ 10), the number of test cases, followed by input data for each test case:

 The first line is: N(N ≤ 100), M(M ≤ N), L(L ≤ 1000)

 N: the number of DVD that DuoDuo want buy. M: the number of DVD that the shop can sale. L: the longest time that her grandfather allowed to watch. The second line to N+1 line, each line contain two numbers. The first number is the time of the i-th DVD, and the second number is the value of ith DVD that DuoDuo rated.

 Output

 Contain one number (It is less than 231).

 The total value that DuoDuo can get tonight. If DuoDuo can‘t watch all of the movies that her uncle had bought for her, please output 0.

 Sample Input

 1
 3 2 10
 11 100
 1 2
 9 1
 Sample Output
 3
 */
public class TOJ3596 {
    // the number of DVD that DuoDuo want buy
    private int N;
    // the number of DVD that the shop can sale
    private int M;
    // the longest time that her grandfather allowed to watch
    private int L;
    private Movie[] movies;
    class Movie{

         int time;
         int value;
        public Movie(int t, int v){
            this.time = t;
            this.value= v;
        }
    }
    public TOJ3596(int n,int m, int l, Movie[] movies){
        this.N = n;
        this.M = m;
        this.L = l;
        this.movies = movies;
    }

    public int dp(){
        int[][][] res = new int[N+1][M+1][L+1];
        for ( int n = 1; n <= N; n ++ ){
            for ( int m = 1; m <= M; m ++ ){
                for ( int l = movies[n].time; l <= L; l ++ ){
                    res[n][m][l] = -1;
                    res[n][m][l] = max(res[n-1][m][l],res[n-1][m-1][l-movies[n].time]+movies[n].value);
                }
            }
        }
        return res[N][M][L];
    }

    public int max (int a, int b){
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        // index starts from 1
        Movie[] movies = new Movie[n+1];
        for ( int i = 1; i <= n; i ++ ){
            System.out.println(movies[i]);

            int t = scanner.nextInt();
            int v = scanner.nextInt();
            //Movie movie = new Movie(t,v);
        }
        TOJ3596 pro = new TOJ3596(n,m,l,movies);
        System.out.println(pro.dp());
    }
}
