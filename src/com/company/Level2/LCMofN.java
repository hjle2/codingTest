package com.company.Level2;

import java.util.Arrays;

// N개의 최소공배수
public class LCMofN {

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i=0; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    public static int lcm(int num1, int num2) {
        return (num1 * num2)/gcd(num1, num2);
    }

    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
    public void TEST(int n1, int n2){
        int num1 = n1, num2 = n2;
        int gcd = gcd(num1, num2);
        System.out.println(gcd); // 최대공약수
        System.out.println(num1 * num2 / gcd); // 최소공배수
    }
}
