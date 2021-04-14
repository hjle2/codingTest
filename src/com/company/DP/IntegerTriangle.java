package com.company.DP;

// 정삼각형의 꼭대기에서 바닥까지 경로 중 숫자의 합이 가장 큰 경우

public class IntegerTriangle {
    int[] dp;
    public int solution(int[][] triangle) {
        int len = triangle.length;
        dp = new int[len];

        for (int i=0; i<len; i++)
            dp[i] = triangle[len-1][i];


        for (int i=len -1 -1; i>=0; i--) {
            for (int j=0; j<len; j++) {

                if (j >= triangle[i].length)
                    continue;

                if (j+1 < len)
                    dp[j] = Math.max(dp[j], dp[j+1]) + triangle[i][j];
            }
        }

        return dp[0];
    }

    public int solution1(int[][] triangle) {
        int answer = 0;

        // Init dp
        int len = triangle.length;
        dp = new int[len];
        dp[0] = triangle[0][0];
        for (int i=1; i<len; i++) {
            dp[i] = 0;
        }
        // 0 -> 0, 1
        // 1 -> 1, 2

        int idx = 0;
        for (int i=1; i<len; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                if (j == idx || j == idx+1) {
                    int val = dp[i-1] + triangle[i][j];
                    if (val > dp[i]) {
                        dp[i] = val;
                        idx = j;
                    }
                }
            }
        }
        return dp[len-1];
    }


    int answer = 0;
    public int solutiondfs(int[][] traingle) {

        GetMaxRoute(traingle, 0, 0, 0);
        return answer;
    }
    public void GetMaxRoute(int[][] triangle, int now, int n, int idx) {
        if (n == triangle.length) {
            answer = Math.max(now, answer);
            return;
        }

            for (int j=0; j<triangle[n].length; j++) {
                if (idx == j || idx + 1 == j) {

                    int val = triangle[n][j];
                    triangle[n][j] = 0;

                    GetMaxRoute(triangle, now + val, n + 1, j);

                    triangle[n][j] = val;
                }
            }
    }
}
