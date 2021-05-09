package com.company.DFS_BFS;

import java.util.Arrays;

public class WordTrans {
    int answer;
    int cnt;
    String[] wordss;
    // words 안에 있는 단어로 변환 가능.
    // 바뀌는 단어와 1개의 글자만 달라야 함.
    public int solution(String begin, String target, String[] words) {
        answer = words.length;
        cnt = 0;
        wordss = words;
        // words 안에 target 없음.
//        if (!Arrays.stream(words).toList().contains(target)) return 0;

        WordTrans(begin, target, words, cnt);

        return answer;
    }
    public void WordTrans(String begin, String target, String[] wordss, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i=0; i<wordss.length; i++) {
            if (wordss[i] == "") continue;
            if (isOneDiff(begin, wordss[i])) {
                String s = wordss[i];
                wordss[i] = "";
                WordTrans(s, target, wordss, cnt+1);
                wordss[i] = s;
            }
        }
    }

    public boolean isOneDiff(String str, String compare) {
        int count = 0;

        // 같으면 return false
        if (str.equals(compare)) return false;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == compare.charAt(i))
                continue;
            count++;
            if (count > 1) return false;
        }
        // 1개만 틀리다면 true return
        return count == 1;
    }
}