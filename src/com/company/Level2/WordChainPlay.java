package com.company.Level2;

import java.util.ArrayList;

// 가장 먼저 탈락하는 사람의 번호, 그 사람의 몇번째 차례에 탈락하는지
public class WordChainPlay {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);

        int turn = 2;
        String End = words[0].substring(words[0].length()-1);

        for (int i=1; i<words.length; i++) {
            if (!words[i].startsWith(End) || list.contains(words[i])) {
                answer[0] = turn;
                answer[1] = i / n  + 1;
                return answer;
            }
            else {
                list.add(words[i]);
                End = words[i].substring(words[i].length()-1);
                turn++;
                if (turn > n)
                    turn = 1;
            }
        }
        return answer;
    }
}
