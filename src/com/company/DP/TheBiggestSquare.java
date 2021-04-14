package com.company.DP;

public class TheBiggestSquare {
    // 1과 0으로 채워진 표
    // 표의 1칸은 1x1의 정사각형
    // 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return (축에 평행한 정사각형)
    public int solution(int [][]board)
    {
        int answer = 0;
        // 정사각형의 최대 크기
        int len = Math.min(board.length, board[0].length);
//        answer = FindBiggestSqure(board, len);

        return FindBiggestSqure(board);
    }
    public int FindBiggestSqure(int[][] board)
    {
        int result = 0;
        for (int i=1; i < board.length; i++) {
            for (int j=1; j<board[0].length; j++) {
                if (board[i][j] == 0)
                    continue;

                board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
                result = Math.max(result, board[i][j]);
            }
        }
        return result;
    }
    // DP 알고리즘을 사용해야 효용성 문제를 풀 수 있음.
    public int FindBiggestSqure(int[][] board, int r) {
        if (r == 1) {
            return 1;
        }
        else {
            // 정사각형의 변의 길이
            for (int i=0; i<= board.length-r; i++) {
                for (int j=0; j<=board[0].length-r; j++) {
                    if (board[i][j] == 0) continue;
                    if (isFullOne(i, j, r, board))
                        return r*r;
                }
            }
            return FindBiggestSqure(board, r-1);
        }
    }
    public boolean isFullOne(int ii, int jj, int n, int[][] board) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[ii+i][jj+j] == 0)
                    return false;
            }
        }
        return true;
    }
    public boolean isFullZero(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j< board[0].length; j++) {
                if (board[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
