package com.company;
// 1 -> 10
// 11 -> 101
// 10 -> 100
// 100 -> 1000
// 110 -> 1001
// 1010 -> 1100
// 1의 중간에 0이 없는 경우..
// 자리수를 추가해야하는 경우..?

public class NextBiggerNumber {
//    public char[] getBigerBinary(char[] num) {
//        for (int i=num.length-2; i>=0; i++) {
//            if (num[i] == '0') {
//                num[i]
//            }
//        }
//    }
    public boolean isneedadd(char[] num) {
        int firstzero = num.length;
        int lastone = 0;

        for (int i=0; i< num.length; i++) {
            if (num[i] == '0' && firstzero > i)
                firstzero = i;
            else
                lastone = i;
        }
        return lastone > firstzero;
    }
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int cntone = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') cntone++;
        }
        int answer = n+1;
        for (;answer<1000000; answer++) {
            int cnt = 0;
            for (char c : Integer.toBinaryString(answer).toCharArray()) {
                if (c == '1') cnt++;
            }
            if (cnt == cntone) return answer;
        }
        return answer;
    }

    int firstzero = 0;
    int lastzero = 0;
    int lastone = 0;
    int cntone = 0;
    int cntzero = 0;
    public Boolean isNeedAdd(char[] num) {
        firstzero = 0;
        lastzero = 0;
        lastone = 0;
        cntone = 0;
        cntzero = 0;

        // 첫번째는 무조건 1임!
        // 첫번째로 0이 나타나는 idx 와 마지막으로 1이 나타나는 idx 비교!
        firstzero = num.length;
        for (int i=0; i<num.length; i++) {
            if (num[i] == '0') {
                if (firstzero > i)
                    firstzero = i;

                if (i < num.length-2)
                    lastzero = i;

                cntzero++;
            }
            else {
                lastone = i;
                cntone++;
            }
        }
        // 첫번째 0 가 마지막 1보다 크면,
        // 1로 시작하는 숫자에서
        // 즉, 1 사이에 0이 존재하지 않으면!!
        return firstzero > lastone;
    }
    public int solution1(int n) {//110 -> 1001 len (3) + 1 - 2 - cntone(1개수) - 1(10에 들어간 1)
        char[] num =Integer.toBinaryString(n).toCharArray();

        // 추가되어야 하는 0의 갯수 = 10 + 0이 num.length - 1의 갯수 - 1 개 다음 나머지 1 전부 몰빵
        if (isNeedAdd(num)) {
            String result = "10";
            for (int i=0; i<num.length - cntone;i++)
                result += '0';

            for (int i=0; i<cntone-1;i++) {
                result += '1';
            }
            return Integer.parseInt(result,2);
        }

        // lastzero 자리에 0이 1로 바뀌고,
        // 나머지 0의 갯수만큼 1을 좌라락 배치한 후 1의 갯수만큼 1을 배치한다

        int i = lastzero;
        num[i++] = '1';
        int cnt0 = 0;

        for (int j=i; j<num.length; j++) {
            if (num[j] == '0') cnt0++;
        }

            for (int j=0; j<cnt0+1; j++)
            if (i < num.length)
                num[i++] = '0';

        for (;i<num.length;i++)
            num[i] = '1';

        return Integer.valueOf(String.valueOf(num),2);
    }
}