package com.company.Level2;

public class Tornement {
    public int getMul(int n) {
        int result = 0;
        while (1 < n) {
            n /= 2;
            result++;
        }
        return result;
    }
    public boolean isMeet(int a, int b) {
        int aa = a/2 + (a%2 == 0 ? 0 : 1);
        int bb = b/2 + (b%2 == 0 ? 0 : 1);
        return aa == bb;
    }
    public int solution(int n, int a, int b)
    {
        // 게임의 횟수 n = 2^x
        int max = getMul(n) ;
        int mid = n/2;
        //1 -? 1
        //2 -> 1
        // 3 -> 2
        int answer = 0;

        while (true) {
            if (!isMeet(a,b)) {
                answer++;
                a = a/2 + (a%2 == 0 ? 0 : 1);
                b = b/2 + (b%2 == 0 ? 0 : 1);
            }
            else break;
        }
        return answer;
    }
}