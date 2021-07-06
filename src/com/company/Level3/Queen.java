package com.company.Level3;

public class Queen {
    int answer = 0;
    public int solution(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;

//        init board
        boolean[][] board = new boolean[n][n];
        for (int x = 0; x<n; x++) {
            for (int y = 0; y<n; y++) {
                board[x][y] = false;
            }
        }

        for (int i=1; i<n-1; i++) {
            board[0][i] = true;
            dfs(i, 0, board, 1);
            board[0][i] = false;
        }
        return answer;
    }

    public void dfs(int x, int y, boolean[][] board, int cntQ) {
        int n = board.length;
        if (cntQ == board.length) {
            answer++;
        }

        for (int i = 0; i<n; i++) {
            if (y+1 < n && !board[y+1][i]) {
                boolean enable = EnableSetQueen(board, i, y+1);

                if (!enable) continue;
                cntQ++;
                board[y+1][i] = true;
                dfs(i, y+1, board, cntQ);
                board[y+1][i] = false;
                cntQ--;
            }
        }
    }
    public boolean EnableSetQueen(boolean[][] board, int x, int y) {
        int n = board.length;

        for (int i=0; i<n; i++) {
            if (board[i][x]) return false;
            if (board[y][i]) return false;

            if (x-i >= 0 && y-i >= 0 && board[y-i][x-i])
                return false;
            if (x+i < n && y+i < n && board[y+i][x+i])
                return false;
            if (x-i >= 0 && y+i < n && board[y+i][x-i])
                return false;
            if (x+i < n && y-i >= 0 && board[y-i][x+i])
                return false;
        }
//        board[y][x] = true;
        return true;
    }
    public boolean SetQueen(int x, int y, int n, boolean[][] board) {
        if (!board[y][x]) return false;

        for (int i=0; i<n; i++) {
            if (board[y][i])
                board[y][i] = false;
            if (board[i][x])
                board[i][x] = false;

            if (x-i >= 0 && y-i >= 0 && board[y-i][x-i])
                board[y-i][x-i] = false;
            if (x+i < n && y+i < n && board[y+i][x+i])
                board[y+i][x+i] = false;
            if (x-i >= 0 && y+i < n && board[y+i][x-i])
                board[y+i][x-i] = false;
            if (x+i < n && y-i >= 0 && board[y-i][x+i])
                board[y-i][x+i] = false;
        }
        return true;
    }
}