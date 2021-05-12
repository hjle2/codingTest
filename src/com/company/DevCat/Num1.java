package com.company.DevCat;

// n*n
// 객자 내부 숫자는 체력
// 목표점 row 번째 가로선과 column 번째 세로선이 만나는 곳
// 목표점을 중심으로 대각선 길이가 r인 정사각형을 45도 왼쪽으로 기울인 모양으로 마법 사용
// 격자에 위치한 몬스터들은 공격력 (p) 만큼 피가 깎임
// 영역에 절반만 위치한 것들은 공격력의 절반만 피가 깎임

// maps : 몬스터가 배치된 지도의 정보
// p : 마법의 공격력
// 마법의 범위
// 마법을 한 번 사용하여 없앨 수 있는 가장 많은 몬스터의 수
// 최소 row 와 column의 값은 r/2 + 1 , r/2 + 1 ( 1, 1 부터 시작하기 때문에)
// r은 짝수

// 2 : 4
// 4 : 12
// 6 : 18
// 효용성 없음
// 0,0 이면, 0.0, 0,1 0,2/2 1,0 1,1/2 2,1/1
public class Num1 {
    int MAX = 0;
    public boolean ZeroDie(int[][] maps, int p) {
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[0].length; j++) {
                if (maps[i][j] < p) return false;
            }
        }
        return true;
    }
    public int solution(int[][] maps, int p, int r) {
        if (ZeroDie(maps, p)) return MAX;
        int answer = -1;

        for (int y=1; y<maps.length; y++) {
            for (int x = 1; x < maps[0].length; x++) {
                int score = 0;

                for (int i=0; i<r/2; i++) {
                    if (x-i >= 0) {

                    }
                    if (x+i < maps[0].length) {

                    }
                    if (y-i >= 0) {

                    }
                    if (y+i < maps.length) {

                    }
                }


            }
        }
        return answer;
    }
}
