package com.company.Level2;

import java.util.Arrays;

public class CreateMinimumValue {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<len; i++) {
            answer += A[i] * B[len - 1 -i];
        }
        return answer;
    }
}
