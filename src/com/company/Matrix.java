package com.company;

// 직사각형 모양의 범위를 여러 번 선택해 테두리 부분의 숫자를 시계 방향으로 회전
// 각 회전은 좌표 2개로 표현하며 그 의미는 해당 좌표로 이루어진 직사각형의 테두리에 숫자들을 한칸 식 시계방향으로 회전
// r, c <= 100
// i, j 열에 있는 숫자는 (i-1) * column + j

public class Matrix {
    int[][] mat;
    public int[] solution(int rows, int columns, int[][] queries) {

        mat = new int[rows][columns];

        int val = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                mat[i][j] = val++;
            }
        }

        int[] answer = new  int[queries.length];

        int idx = 0;
        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int min = TurnMat(x1, y1, x2, y2);
            answer[idx] = min;
            idx++;
        }

        return answer;
    }
    public int TurnMat(int x1, int y1, int x2, int y2) {
        x1--; y1--; x2--; y2--;
        int min = 999999;

        int hei = x2-x1+1;
        int wid = y2-y1+1;

        int tmp = mat[x1][y1];

        for (int i=1; i<hei; i++) {
            mat[y1+i-1][x1] = mat[y1+i][x1];
            min = Math.min(mat[y1+i-1][x1], min) ;
        }

        for (int i=1; i<wid; i++) {
            mat[y2][x1+i-1] = mat[y2][x1+i];
            min = Math.min(mat[y2][x1+i-1], min) ;
        }

        for (int i=1; i<hei; i++) {
            mat[y2-i+1][x2] = mat[y2-i][x2];
            min = Math.min(mat[y2-i+1][x2], min) ;
        }

        for (int i=1; i<wid; i++) {
            mat[y1][x2-i+1] = mat[y1][x2-i];
            min = Math.min(mat[y1][x2-i+1], min) ;
        }
        mat[y1+1][x1] = tmp;
        min = Math.min(mat[y1+1][x1], min) ;
        return min;
    }
}
