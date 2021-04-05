package com.company;

import java.util.Stack;

public class RightParentheses {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                if (c == '(') stack.push(c);
                else return false;
            }
            else {
                if (!stack.peek().equals(c)) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }

        return stack.empty();
    }
}
