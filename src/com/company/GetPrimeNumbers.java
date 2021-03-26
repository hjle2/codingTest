package com.company;

import java.util.*;

public class GetPrimeNumbers {
    static List<Integer> list = new ArrayList<>();
    public int solution(String numbers) {
        getNum(numbers.toCharArray(), "");

        return list.size();
    }
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i=2; i<=(int)Math.sqrt(num); i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }

    public void getNum(char[] numbers, String now) {
        String val = "";
        int iv = 0;

        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == ' ')
                continue;

            char c = numbers[i];
            numbers[i] = ' ';
            val = now + c;
            iv = Integer.valueOf(val);

            if (isPrime(iv) && !list.contains(iv))
                list.add(iv);

            getNum(numbers, val);
            numbers[i] = c;
        }
    }
}
