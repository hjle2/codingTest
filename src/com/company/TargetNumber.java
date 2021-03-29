package com.company;

import java.util.Arrays;

public class TargetNumber {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        int max = Arrays.stream(numbers).sum();

        getTarget(numbers, max, 0, target);

        return answer;
    }
    public void getTarget(int[] numbers, int n, int r, int target) {
        if (target == n) {
            answer++;
            return;
        }
        if (target > n)
            return;

        for (int i=r; i<numbers.length; i++) {
            getTarget(numbers, n - (2 * numbers[i]), i+1, target);
        }
    }
}
