package com.company.DevmatchingWebBE2021;

import java.util.Arrays;

class RottoRanking {
int[] score = {6, 6, 5, 4, 3, 2, 1};
public int[] getRanking(int cnt, int zerocnt) {
        int[] result = new int[2];

        result[0] = score[cnt + zerocnt];
        result[1] = score[cnt];

        return result;
        }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int cnt = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCnt = 0;
        for (int i : lottos) {
            if (i==0) zeroCnt++;
        }

        for (int i=0; i<6; i++) {
            if (lottos[i] == 0) continue;
            int val = lottos[i];
            if (Arrays.stream(win_nums).filter(x -> x == val).count() > 0)
                cnt++;
        }

        return getRanking(cnt, zeroCnt);
    }
}