package com.company.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Network {
    // 컴퓨터의 개수 n은 1이상, 200이하인 자연수
    // 각 컴퓨터는 0부터 n-1인 정수로 표현
    // i번 컴퓨터와 j번 컴퓨터가 연결 되어 있으면 computers[i][j] 는 1 (즉, computers[i][i] 는 항상 1)
    // 네트워크의 개수를 return
    public int solution(int n, int[][] computers) {
        int[] parents = new int[computers.length];
        for(int i=0; i<computers.length; i++) {
            parents[i] = i;
        }
        List<Integer> networkParents = new ArrayList<>();

        for (int i=0; i<computers.length; i++) {
            boolean isSeper = true;
            for (int j=0; j<computers[i].length; j++) {
                if (i==j) continue;
                if (computers[i][j] == 1) {
                    Connect(parents, i, j);
                    isSeper = false;

                }
            }
            if (isSeper) {
                if (!networkParents.contains(getParents(parents, i)))
                    networkParents.add(getParents(parents, i));
            }
        }

        for (int i: parents) {
            if (!networkParents.contains(getParents(parents, i)))
                networkParents.add(i);
        }
        return networkParents.size();
    }
    private static boolean isConnected(int[] parents, int from, int to) {
        return getParents(parents, from) == getParents(parents, to);
    }

    private static int getParents(int[] parents, int edge) {
        if (parents[edge] == edge) return edge;
        return getParents(parents, parents[edge]);
    }
    private static void Connect(int[] parents, int from, int to) {
        from = getParents(parents, from);
        to = getParents(parents, to);

        if (from < to)
            parents[to] = from;
        else
            parents[from] = to;
    }
}
