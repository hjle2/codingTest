package com.company.Level2;

public class CreateJadenCaseString {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for (char c : s.toCharArray()) {

            if (c <= 'z' && c >= 'A') {
                if (flag) {
                    answer += String.valueOf(c).toUpperCase();
                }
                else {
                    answer += String.valueOf(c).toLowerCase();
                }
            }
            else answer += c;

            if (c == ' ') flag = true;
            else flag = false;
        }

        return answer;
    }
}
