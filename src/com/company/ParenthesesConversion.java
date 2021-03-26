package com.company;

import java.util.*;

public class ParenthesesConversion {
    static String result = "";

    public static String Solution(String p) {
        result = "";
        System.out.println(p);

        //Parentheses(p, "");
        solution(p);

        System.out.println(result);
        return result;
    }

    // 정상적인 괄호인지 확인
    private static boolean isPerfectParenthesess(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (stack.empty())
                stack.push(c);
            else {
                if (stack.peek() != c && c == ')')
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.empty();
    }

    private static void solution(String u) {
        Stack<Character> stack = new Stack<>();

        if (u.isEmpty())
            return;

        if (isPerfectParenthesess(u)) {
            result += u;
            return;
        }
        int idx = 0;
        for (char c : u.toCharArray()) {
            if (stack.empty())
                stack.push(c);
            else {
                if (c != stack.peek())
                    stack.pop();
                else
                    stack.push(c);
            }
            idx++;

            if (stack.empty()) {
                String first = u.substring(0, idx);
                String second = u.substring(idx);

                if (isPerfectParenthesess(first)) {
                    result += first;
                    solution(second);
                } else {
                    result += '(';
                    solution(second);
                    result += ')';
                    result += WrongtoRight(first);
                }

                break;
            }
        }
    }

    private static void Parentheses(String u, String v) {
        Stack<Character> stack = new Stack<>();

        if (u.isEmpty() && v.isEmpty())
            return;

        if (isPerfectParenthesess(u)) {
            result += u;
            Parentheses(v, "");
            return;
        }

        int idx = 0;
        for (char c : u.toCharArray()) {
            if (stack.empty())
                stack.push(c);
            else {
                if (c != stack.peek())
                    stack.pop();
                else
                    stack.push(c);
            }
            idx++;

            if (stack.empty()) {
                String first = u.substring(0, idx);
                String second = u.substring(idx);

                if (u.equals(first))
                    first = WrongtoRight(u);
                Parentheses(first, "");
                Parentheses(second, "");
                break;
            }
        }

    }

    private static String WrongtoRight(String wrong) {
        String result = "";
        for (int i = 1; i < wrong.length() - 1; i++)
            result += wrong.charAt(i) == '(' ? ')' : '(';
        return result;
    }
}
