package com.company;

public class QuadTree {
    int[] answer = new int[2];
    // S : 압축하고자 하는 영역
    // S 내부 수가 같은 숫자면 하나의 수로 압축
    // 그렇지 않다면, 4개의 정사각형 영역으로 나눈 후 위의 과정 재 진행
    // 0과, 1의 갯수 리턴
    public int[] solution(int[][] arr) {

        GetZIP(arr.length, 0, arr);

        return answer;
    }
    public void GetZIP(int n, int r, int[][] arr) {
        if (isAllSame(arr) || arr.length == 1) {
            int i = arr[0][0];
            answer[i] ++;
            return;
        }
        else {
            for (int i=0; i<2; i++) {
                for (int j=0; j<2; j++) {
                    GetZIP(n, r+1, GetArray(i, j, arr));
                }
            }
        }
    }
    public int[][] GetArray(int r, int c, int[][] arr) {
        int len = arr.length/2;
        int[][] result = new int[len][len];

        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                result[i][j] = arr[r*len + i][c*len + j];
            }
        }
        return result;
    }
    public boolean isAllSame(int[][] arr) {
        int num = arr[0][0];

        for (int[] ar : arr) {
            for (int a : ar) {
                if (num != a) return false;
            }
        }
        return true;
    }
}
