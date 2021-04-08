package com.company;

public class WordsPuzzle {
    int[] dp;
    public int solution(String[] strs, String t) {
        dp = new int[t.length()];

//        for (int i=0; i<t.length(); i++) dp[i] = 10000;

        for (int i=0; i<t.length(); i++) {
            GetMinDP1(strs, t, i);
        }

        char[] chart = t.toCharArray();

//        if (Contains(strs, String.valueOf(chart[0])))
//            dp[0] = 1;
//
//        if (Contains(strs, String.valueOf(t.substring(0, 1+1))))
//            dp[1] = 1;
//        if (Contains(strs, String.valueOf(chart[1])))
//            dp[1] = Math.min(dp[1], dp[1-0] + 1);
//
//        if (Contains(strs, String.valueOf(t.substring(0, 2+1))))
//            dp[2] = 1;
//        if (Contains(strs, String.valueOf(chart[2])))
//            dp[2] = Math.min(dp[2], dp[2-1] + 1);
//        if (Contains(strs, String.valueOf(t.substring(1, 2+1))))
//            dp[2] = Math.min(dp[2], dp[2-0] + 1);
//
//        if (Contains(strs, String.valueOf(t.substring(0, 3+1))))
//            dp[3] = 1;
//        if (Contains(strs, String.valueOf(chart[3])))
//            dp[3] = Math.min(dp[3], dp[3-1] + 1);
//        if (Contains(strs, String.valueOf(t.substring(3-1, 3+1))))
//            dp[3] = Math.min(dp[3], dp[3-2] + 1);
//        if (Contains(strs, String.valueOf(t.substring(3-2, 3+1))))
//            dp[3] = Math.min(dp[3], dp[3-3] + 1);
//
//        if (Contains(strs, String.valueOf(t.substring(4-4, 4+1))))
//            dp[4] = 1;
//        if (Contains(strs, String.valueOf(t.substring(4-0, 4+1))))
//            dp[4] = Math.min(dp[4], dp[4-1] + 1);
//        if (Contains(strs, String.valueOf(t.substring(4-1, 4+1))))
//            dp[4] = Math.min(dp[4], dp[4-2] + 1);
//        if (Contains(strs, String.valueOf(t.substring(4-2, 4+1))))
//            dp[4] = Math.min(dp[4], dp[4-3] + 1);
//        if (Contains(strs, String.valueOf(t.substring(4-3, 4+1))))
//            dp[4] = Math.min(dp[4], dp[4-4] + 1);

        int answer = dp[t.length()-1];

        return dp[t.length()-1] == 10000 ? -1 : dp[t.length()-1];
    }
    public void GetMinDP1(String[] str, String t, int idx) {
        if (Contains(str, t)) {
            dp[idx] = 1;
            return;
        }
        for (int i=1; i<= idx; i++) {
            t = t.substring(1, t.length());
            if (Contains(str, t)) {
                if (i == 0) {
                    dp[idx] = 1;
                    return;
                }
                else {
                    if (dp[i - 1] > 0)
                    dp[idx] = Math.min(dp[idx], dp[i-1] + 1);
                }
            }
        }
    }
    public void GetMinDP(String[] str, StringBuilder t, int idx) {
        StringBuilder s = new StringBuilder(t);
        if (Contains(str, s)) {
            dp[idx] = 1;
            return;
        }
            for (int i = 1; i <= idx; i++) {
                s = s.deleteCharAt(0);
                if (Contains(str, s)) {
                    dp[idx] = Math.min(dp[idx], dp[i - 1] + 1);
                }
            }
    }
    public boolean Contains(String[] str, StringBuilder contain) {
        for (String s : str) {
            if (s.equals(contain.toString()))
                return true;
        }
        return false;
    }
    public void GetMinDP(String[] str, String t, int idx) {
        String s = "";
        for (int i=0; i<= idx; i++) {
            s = t.substring(i, idx + 1);
            if (Contains(str, s)) {
                if (i == 0) {
                    dp[idx] = 1;
                    return;
                }
                else
                    dp[idx] = Math.min(dp[idx], dp[i-1] + 1);
            }
        }
    }
    public boolean Contains(String[] str, String contain) {
        for (String s : str) {
            if (s.equals(contain))
                return true;
        }
        return false;
    }
}
