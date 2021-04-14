package com.company.DP;

public class EatingLand {

    public int GetMaxLandNum(int[][] land, int i, int jj) {
        int max = 0;
        for (int j=0; j<land[0].length; j++) {
            if (j == jj) continue;
            max = Math.max(land[i][j], max);
        }
        return max;
    }
    int solution(int[][] land) {
        int answer = 0;

        for (int i=1; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                land[i][j] = GetMaxLandNum(land, i-1, j) + land[i][j];

                answer = Math.max(land[i][j], answer);
            }
        }

        return answer;
    }
}
