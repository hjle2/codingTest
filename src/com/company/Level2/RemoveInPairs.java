package com.company.Level2;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveInPairs {
    public int solution(String s ){
        //if (!isPairs(s)) return 0;

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.empty() || st.peek() != c) {
                st.push(c);
            }
            else st.pop();
        }
        return st.empty() ? 1 : 0;
    }
    public boolean isPairs(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int val : map.values()) {
            if (val % 2 != 0) return false;
        }
        return true;
    }
    // s는 소문자로 이루어진 문자열
    // 붙어있는 짝을 찾아 제거한 뒤 앞뒤 문자열을 이어 붙인다.
    public int solution1(String s)
    {
        if (!isPairs(s)) return 0;
        String rg = "(\\w)\\1";
        Pattern pa = Pattern.compile(rg);
        Matcher mat = pa.matcher(s);

        while(pa.matcher(s).find()) {
            s = s.replaceAll(rg, "");
        }
        return s.isEmpty() ? 1 : 0;
    }
}
