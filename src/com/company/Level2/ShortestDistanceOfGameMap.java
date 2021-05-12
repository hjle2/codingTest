package com.company.Level2;

// 두 팀으로 나누어서 진행, 상대 팀 전영을 먼저 파괴하면 승리
// 캐릭터는 1,1 상대팀은 5,5

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceOfGameMap {
    int DISTANCE = Integer.MAX_VALUE;
    int[][] maps;
    boolean[][] visited;

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public void dp(int x, int y, int distance) {
        if (DISTANCE <= distance || distance > maps.length * maps[0].length) return;

        if (x == (maps[0].length -1) && y == (maps.length-1)) {
            DISTANCE = Math.min(DISTANCE, distance);
            return;
        }

        for (int i=0; i<dx.length; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];
            if (ix >= 0 && ix < maps[0].length && iy >= 0 && iy < maps.length)
            {
                if (!visited[iy][ix] && maps[iy][ix] == 1) {
                    visited[iy][ix] = true;
                    maps[iy][ix] = distance + 1;
                    dp(ix, iy, distance + 1);
                    visited[iy][ix] = false;
                }

            }
        }
    }


    public int bfs (int x, int y, int[][] maps) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while(!que.isEmpty()) {
            Node node = que.poll();
            if (node.x == maps[0].length - 1 && node.y == maps.length - 1) {
                return node.cost;
            }

            for (int i=0; i<dx.length; i++) {
                int ix = node.x + dx[i];
                int iy = node.y + dy[i];
                if (ix >= 0 && ix < maps[0].length && iy >= 0 && iy < maps.length) {
                    if (!visited[iy][ix] && maps[iy][ix] == 1) {
                        visited[iy][ix] = true;
                        que.offer(new Node(ix, iy, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
    public void dfs(int x, int y, int distance) {
        if (DISTANCE <= distance) return;

        if (x == (maps[0].length -1) && y == (maps.length-1)) {
            DISTANCE = Math.min(DISTANCE, distance);
            return;
        }

        for (int i=0; i<dx.length; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];
            if (ix >= 0 && ix < maps[0].length && iy >= 0 && iy < maps.length) {
                if (!visited[iy][ix] && maps[iy][ix] == 1) {
                    visited[iy][ix] = true;
                    dfs(ix, iy, distance + 1);
                    visited[iy][ix] = false;
                }
            }
        }
    }
    public void initVisited() {
        visited = new boolean[maps.length][maps[0].length];

        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[0].length; j++) {
                if (maps[i][j] == 0)
                visited[i][j] = true;
                else
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
    }
    public int solution(int[][] MAP) {
        int answer = 1;
        maps = MAP;
        maps[0][0] = 0;
        initVisited();
        bfs(0, 0, MAP);
        return DISTANCE == Integer.MAX_VALUE ? -1 : DISTANCE;
    }
    public class Node {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

}