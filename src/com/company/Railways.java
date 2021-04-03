package com.company;

// n개 역이 철로로 연결, 양방향통행 가능
// 임의의 두 역을 직접 연결하는 철로는 무조건 하나
// 1번 역에서 출발 , 전체 역 중에 한곳으로 종착
// 모든 역 방문 필요 없음
// 같은역 두번 방문 안됨
// 각 역의 일일 이용객 수가 최대가 되도록 종착역 지정
// 여러개라면 그 중 번호가 큰 역 선택

import java.util.Arrays;
import java.util.Collections;

public class Railways {
    int[] result;
    public int[] solution(int n, int[] passenger, int[][] train) {

        int[] answer = new int[2];

         result = new int[passenger.length];

        int[] parents = new int[n];

            for (int i=0; i<n; i++) {
                parents[i] = i;
            }

            for (int i=0; i<train.length; i++) {
                int from = train[i][0] -1;
                int to = train[i][1] -1;
                int value = passenger[to];

                if (isConnected(parents, from, to)) continue;
                else {
                    result[to] += value;
                    Connect(parents, from, to);
                }
            }
            return answer;
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

