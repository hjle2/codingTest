package com.company.SixShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Num2 {
    public int[] solution(int[] grade) {
        HashMap<Integer, Integer> map  = new HashMap<>();

        for (int i : grade)
            map.put(i, map.getOrDefault(map.get(i), 0) + 1);


//        Collections.sort(map, new Comparator() {
//
//        });
        int[] answer = new int[grade.length];
        return answer;
    }
    // 자신보다 높은 점수를 받은 학생의 수에 1을 더한 숫자가 자신의 등수
    // 순서대로 점수가 들어있는 배열 grade
    // 등수를 return 하라.
    ArrayList<Integer> score = new ArrayList<>();

    public int[] solution1(int[] grade) {
        for (int i : grade) {
            score.add(i);
        }
        Collections.sort(score, Collections.reverseOrder());

        int[] answer = new int[grade.length];

        for (int i=0; i<answer.length; i++) {
            answer[i] = getRanking(grade[i]) + 1;
        }
        return answer;
    }

    private int getRanking(int grade) {
        int ranking = score.size();

        if   (score.contains(grade)) {
            return score.indexOf(grade);
        }
        else {
            int gr = grade + 1;
            while(!score.contains(gr++)) {

            }
            return score.indexOf(gr-1);
        }
    }

}
// 82.6