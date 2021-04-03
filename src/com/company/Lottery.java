package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// 6 개 일치 1등.
// 2개 일치 5등. // 그 외 낙
// 최저 순위와 최고 순위
//
public class Lottery {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        ArrayList<Integer> lotto = new ArrayList<>();
        ArrayList<Integer> win_num = new ArrayList<>();

        int zero = 0;
        for (int l : lottos) {
            lotto.add(l);
            if (l == 0)
                zero++;
        }
        for (int w : win_nums) {
            win_num.add(w);
        }

        int cnt = 0;
        for (int i : win_num) {
            if (lotto.contains(i))
                cnt++;
        }
        answer[1] = 7-cnt;
        if (cnt < 2)
            answer[1] = 6;

        answer[0] = answer[1] - zero;

        if (answer[0] <= 0)
            answer[0] = 1;

        return answer;
    }
}
