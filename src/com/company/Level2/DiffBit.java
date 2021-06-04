package com.company.Level2;

public class DiffBit {
    public boolean diffCnt(long number1, long number2) {
        String num1 = Long.toBinaryString(number1);
        String num2 = Long.toBinaryString(number2);

        if (num1.length() < num2.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        if (num2.charAt(num2.length()-1) == '0') return true;

        int idx1 = num1.length() -1;
        int idx2 = num2.length() -1;

        int ans  = 0;
        for (int i=0; i<num1.length(); i++) {
            if (i >= num2.length()) {
                if (idx1 >= 0 && num1.charAt(idx1--) == '1') ans++;
            }
            else if (num1.charAt(idx1--) != num2.charAt(idx2--)) {
                ans++;
            }
            if (ans > 2)
                return false;
        }
        return ans<=2;
    }
    public long getLeastNum(long number) {
        int plus = 1;
        while (true) {
            if (diffCnt(number, number + plus++)) {
                return number + plus-1;
            }
        }
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i=0; i< numbers.length; i++) {
            answer[i] = getLeastNum(numbers[i]);
        }
        return answer;
    }
}
