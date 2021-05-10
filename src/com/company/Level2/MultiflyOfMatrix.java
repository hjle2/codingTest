package com.company.Level2;

public class MultiflyOfMatrix {
    //
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr1.length;
        int row = arr2[0].length;
        int ii = arr1[0].length;
        int[][] answer = new int[col][row];

        for (int c=0; c<col; c++) {
            for (int r=0; r<row; r++) {
                int val = 0;
                for (int i=0; i<ii; i++) {
                    val += arr1[c][i] * arr2[i][r];
                }
                answer[c][r] = val;
            }
        }
        return answer;
    }
}
