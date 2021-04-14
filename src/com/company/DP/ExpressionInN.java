package com.company.DP;

import java.util.ArrayList;

public class ExpressionInN {
    // N만으로 4칙 연산을 사용하여 number를 만드는 숫자들 중
    // 가장 적은 횟수를 리턴
    int CNT = 8;
    int ERR = -1;
    int num;
    int target;
    int answer = 9;

    public int solution(int N, int number) {
        num = N;
        target = number;

        dfs(0, 0);

        return answer > CNT ? -1 : answer;
    }

    public void dfs(int number, int count) {
        if (count > CNT) {
            return;
        }
        if (number == target) {
            answer = Math.min(answer, count);
            return;
        }

        int temp = num;

        for (int i=0; i<CNT-count + 1; i++) {
            int cnt = count + i + 1;
            dfs(number + temp, cnt);
            dfs(number - temp, cnt);
            dfs(number * temp, cnt);
            dfs(number / temp, cnt);
            temp = temp * 10 + num;
        }
    }
}