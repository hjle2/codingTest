package com.company.SixShop;

public class ShorterWord {

    public String solution(String s1, String s2) {
        // s1 is shorter one
        if (s1.length() > s2.length()) {
            String tmp = s2;
            s2 = s1;
            s1 = tmp;
        }

        int len = s1.length();
        String cmp = "";
        String cmpb = "";
        int front = 0;
        int back = 0;
        // 앞부
        for (int i=0; i < len; i++) {
            cmp += s1.charAt(i);
            cmpb += s1.charAt(len-1-i);

            if (s2.endsWith(cmp))
                front = cmp.length();
            if (s2.startsWith(cmpb))
                back = cmpb.length();
        }

        String answer = "";
        if (front > back) {
            answer += s2.substring(0, s2.length()-front);
            answer += s1;
        }
        else if (front < back) {
            answer += s1.substring(0, s1.length()-back);
            answer += s2;
        }
        else {
            if (s1.compareTo(s2) < 0) {
                answer += s1.substring(0, s1.length()-back);
                answer += s2;
            }
            else  {
                answer += s2.substring(0, s2.length()-front);
                answer += s1;
            }
        }
        return answer;
    }
}
// 74 score
