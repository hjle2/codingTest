package com.company.Level2;

// 두 팀으로 나누어서 진행, 상대 팀 전영을 먼저 파괴하면 승리
// 캐릭터는 1,1 상대팀은 5,5

public class ShortestDistanceOfGameMap {
    int DISTANCE = Integer.MAX_VALUE;
    int[][] maps;
    public void func(int x, int y, int distance) {
        if (DISTANCE <= distance) return;

        if (x == (maps[0].length -1) && y == (maps.length-1)) {
            DISTANCE = Math.min(DISTANCE, distance);
            return;
        }
        // 오른쪽 방향
        if (x + 1 < maps[0].length && maps[y][x+1] == 1) {
            maps[y][x+1] = 0;
            func(x+1, y, distance+1);
            maps[y][x+1] = 1;
        }
        // 아래쪽 방향
        if (y + 1 < maps.length && maps[y+1][x] == 1) {
            maps[y+1][x] = 0;
            func(x, y+1, distance+1);
            maps[y+1][x] = 1;
        }
        // 왼쪽 방향
        if (x - 1 >= 0 && maps[y][x-1] == 1) {
            maps[y][x-1] = 0;
            func(x-1, y, distance+1);
            maps[y][x-1] = 1;
        }
        // 위쪽 방향
        if (y - 1 >= 0 && maps[y-1][x] == 1) {
            maps[y-1][x] = 0;
            func(x, y-1, distance+1);
            maps[y-1][x] = 1;
        }
    }
    public int solution(int[][] MAP) {
        int answer = 1;
        maps = MAP;
        maps[0][0] = 0;
        func(0, 0, answer);
        return DISTANCE == Integer.MAX_VALUE ? -1 : DISTANCE;
    }
}
