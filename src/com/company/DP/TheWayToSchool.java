package com.company.DP;

public class TheWayToSchool {
    // 시작 점(집)  은 1,1 ****
    // 목표 점(학교)는 m,n
    // 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return ..?
    int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        int answer = m-1 + n-1;
        dp = new int[m][n];

        dp[0][0] = 0;// 집
        for (int i=0; i<m; i++)
            dp[i][0] = 1;
        for (int i=0; i<n; i++)
            dp[0][i] = 1;

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - 1 ;
            }
        }
        return dp[m-1][n-1];
    }
}