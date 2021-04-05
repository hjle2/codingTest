package com.company.GroupPhoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupPhoto {
    String[] dt;
    int answer = 0;

    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        dt = data;

//        GetFactorial(friendiends, 0, "");
        GetFactorial(8, 0, "");
//        for (String con : data) {
//            char[] c = con.toCharArray();
//
//

//        }
        return answer;
    }
    public boolean isPossiblePosition(String n) {
        for (String condition : dt) {
            char[] cond = condition.toCharArray();
            int from  = 0, to = 0, gap = 0, icond = cond[4] - '0';

            for (int j=0; j<8; j++) {
                if (n.charAt(j) == cond[0]) from = j;
                if (n.charAt(j) == cond[2]) to = j;
            }

            gap = Math.abs(from - to) -1;
            switch(cond[3]) {
                case '=':
                    if (gap != icond) return false;
                    break;
                case '<':
                    if (gap >= icond) return false;
                    break;
                case '>':
                    if (gap <= icond) return false;
                    break;
            }
        }
        return true;
    }
    public void GetFactorial(int n, int r, String result) {
        if (result.length() == n) {
            if (isPossiblePosition(result))
                answer++;
            return;
        }
        for (int i=0; i<n; i++) {
            char c = friends[i];
            if (c == ' ') continue;
            friends[i] = ' ';
            GetFactorial(n, r+1, result + c);
            friends[i] = c;
        }
    }

    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] position;
    static boolean[] check;
    static int ans;

    public int solution1(int n, String[] data) {
        position = new char[8];
        check = new boolean[8];
        ans = 0;

        backtracking(0, n, data);

        return ans;
    }

    public boolean isPossible(int n, String[] data){
        for(int i = 0 ; i < n ; ++i){
            char[] condition = data[i].toCharArray();
            int from = 0, to = 0, gap = 0, cond = condition[4] - '0';

            for(int j = 0 ; j < 8 ; ++j){
                if(position[j] == condition[0]) from = j;
                if(position[j] == condition[2]) to = j;
            }

            gap = Math.abs(from - to) - 1;
            switch(condition[3]){
                case '=':
                    if(gap != cond) return false;
                    break;
                case '<':
                    if(gap >= cond) return false;
                    break;
                case '>':
                    if(gap <= cond) return false;
                    break;
            }
        }
        return true;
    }

    public void backtracking(int idx, int n, String[] data){
        if(idx == 8){
            if(isPossible(n, data)){
                ans++;
            }
            return;
        }

        for(int i = 0 ; i < 8 ; ++i){
            if(!check[i]){
                check[i] = true;
                position[idx] = character[i];
                backtracking(idx + 1, n, data);
                check[i] = false;
            }
        }
    }
}
