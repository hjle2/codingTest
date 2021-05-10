package com.company.Level2;

import java.math.BigInteger;

// 통과 되는데 시간 초과
public class Fibonacci {
    BigInteger f0 = BigInteger.ZERO;
    BigInteger f1 = BigInteger.ONE;
    public int solution(int n) {
        BigInteger answer = Func2(n);//Func(n);
        BigInteger mod = BigInteger.valueOf(1234567);

        return Integer.valueOf(answer.mod(mod).toString());
    }
    public int Func(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        else
        return Func(n-1) + Func(n-2);
    }
    public BigInteger Func2 (int n) {
        for (int i=2; i<n; i++) {
            BigInteger temp = f0;
            f0 = f1;
            f1 = temp.add(f1);
        }
        return f1;
    }
}
