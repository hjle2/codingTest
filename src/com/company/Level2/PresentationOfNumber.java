package com.company.Level2;

public class PresentationOfNumber {
    // 1, 3, 6, 10, 15, 21
    public int solution(int n) {
        int answer = 1;
        int sum = 0;
        for (int i=1; i<=n/2 + 1; i++) {
            if (ispossibleToPresent(n, i)) answer++;
        }
        return answer;
    }
    public boolean ispossibleToPresent(int n, int start) {
        int sum = 0;
        for (int i=start; i<=n/2 + 1; i++) {
            sum += i;
            if (sum == n) return true;
            if (sum > n) return false;
        }
        return false;
    }
}
