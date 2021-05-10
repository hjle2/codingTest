package com.company.Level2;

import java.util.HashMap;
import java.util.Stack;

public class CorrectParentheses {
    HashMap<Character, Character> map = new HashMap<>();
    public void initMap() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    public int solution(String s) {
        int answer = 0;
        initMap();
        for (int i=0; i<s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isCorrect(s)) answer++;
        }
        return answer;
    }
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())  {
            if (stack.empty() || !map.containsKey(c))
                stack.push(c);
            else {
                char ch = stack.peek();
                char has = map.get(c);
                if (ch == has)
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.empty();
    }
}
