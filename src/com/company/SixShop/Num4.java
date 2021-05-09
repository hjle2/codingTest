package com.company.SixShop;

import java.util.ArrayList;
class Num4 {

    // 거꾸로 생각하면
    // idx N 까지는 val 에 완료됨.
    // 그 다음에 들어가는 애는 N + val에 완료됨 ..
    // ArrayList <Integer(Sec), ArrayList<Integer(idx)>> 로 할걸 
    public int[] solution(int N, int[] coffee_times) {
        ArrayList<Integer> list = new ArrayList<>();
        int t =0;
        boolean[] done = new boolean[coffee_times.length];
        int[] getin = new int[coffee_times.length];
        int[] shots = new int[N];

        for (int i=0; i<N; i++) {
            getin[i] = 0;
            shots[i] = i;
        }

        int next = N;

        while (true) {
            t++;
            for (int i=0; i<N; i++) {
                if (shots[i] >= coffee_times.length) continue;
                if (getin[i] + coffee_times[shots[i]] <= t) {
                    list.add(shots[i]+1);
                    shots[i] = next++;
                    getin[i] = t;
                    if (list.size() == coffee_times.length) {
                        int[] answer = new int[coffee_times.length];
                        int ii=0;
                        for (int  val : list) {
                            answer[ii++] = val;
                        }
                        return answer;
                    }
                }
            }
        }
    }
}