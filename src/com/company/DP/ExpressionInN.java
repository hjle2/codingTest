package com.company.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExpressionInN {
    // N만으로 4칙 연산을 사용하여 number를 만드는 숫자들 중
    // 가장 적은 횟수를 리턴
    int CNT = 8;
    int ERR = -1;
    int num;
    int target;
    int answer = 9;

    public int solution1(int N, int number) {
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
    // dp 의 기본 개념은
    // set[1] 에는 N을 1회 사용해서 만들 수 있는 모든 경우의 수를 담는다.
    // set[2] 에는 ...
    // 같은 방식으로 구하면서 number값을 가장 먼저 갖게 되는 idx 를 리턴하면 된다.
    int MAX = 9;
    public int solution(int N, int number) {
        int answer = -1;

        Set<Integer>[] setArr = new Set[9];

        int t = N;
        for (int i=1; i<MAX; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }

        for (int i=1; i<MAX; i++) {
            for (int j=1; j < i; j++) {
                for (Integer a : setArr[j]) {
                    for (Integer b : setArr[i-j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if (b != 0)
                            setArr[i].add(a / b);
                        if (a != 0)
                            setArr[i].add(b / a);
                    }
                }
            }
        }
        for (int i=1; i<MAX; i++){
            if (setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;
    }



        public int solutionDP(int N, int number) {
            int answer = -1;
            Set<Integer>[] setArr = new Set[9];
            int t = N;

            for(int i = 1; i < 9; i++) {
                setArr[i] = new HashSet<>();
                setArr[i].add(t);
                t = t * 10 + N;
            }

            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < i; j++) {
                    for(Integer a : setArr[j]) {
                        for(Integer b : setArr[i - j]) {
                            setArr[i].add(a + b);
                            setArr[i].add(a - b);
                            setArr[i].add(b - a);
                            setArr[i].add(a * b);
                            if(b != 0) {
                                setArr[i].add(a / b);
                            }
                            if(a != 0) {
                                setArr[i].add(b / a);
                            }
                        }
                    }
                }
            }
            for(int i = 1; i < 9; i++) {
                if(setArr[i].contains(number)) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }

}