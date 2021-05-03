package com.company.KAKAOBLIND2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 파일명은 100 글자 이내
// 영문 대소문자, 숫자, 공백, 마침표, 빼기 부호로 이루어져 있다
// 영문자로 시작하여 숫자를 하나 이상 포함
// HEAD, NUMBER, TAIL 세 부분으로 구성

// HEAD는 숫자가 아닌 문자
// NUMBER 는 한 글자에서 '최대' 다섯 글자 사이의 연속된 숫자 앞에 0이 올 수 있다. 0부터 99999 사이의 숫자
// TAIL 은 그 나머지 부분, 아무 글자도 없을 수도, 숫자가 다시 있을 수도 있다.

// HEAD 기준 사전 순 정렬 대소문자 구분 않는다.
// 다음 NUMBER 기준, 숫자 순으로 정렬
// 둘다 동일하다면 원래 입력에 주어진 순서 유지
//
public class SortFiles {
    public String[] solution(String[] files) {
    String[] answer = new String[3];
    // [0] = HEAD, [1] = NUMBER, [2] = TAIL

        Arrays.sort(files, new Comparator() {
            public int compare(Object o1, Object o2) {

            Pattern pa = Pattern.compile("[0-9]{1,5}");
            Matcher ma1 = pa.matcher(o1.toString());
            Matcher ma2 = pa.matcher(o2.toString());

            if (ma1.find() && ma2.find()) {
                String head1 = o1.toString().substring(0, ma1.start()).toLowerCase();
                String head2 = o2.toString().substring(0, ma2.start()).toLowerCase();

                if (head1.equals(head2)) {
                    int num1 = Integer.valueOf(o1.toString().substring(ma1.start(), ma1.end()));
                    int num2 = Integer.valueOf(o2.toString().substring(ma2.start(), ma2.end()));

                    if (num1 == num2) return 0;
                    else return num1 - num2;
                }
                else {
                    return head1.compareTo(head2);
                }
            }

            return 0;
        } });
    return files;
}
}
