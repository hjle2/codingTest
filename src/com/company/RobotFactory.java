package com.company;
// 예외처리를 잘하자
// 로봇으로 여러 종류의 완제품을 만드는 공장
// 로봇 한대는 한 종류의 부품만 처리
// 최소의 로봇 대수로 최대한 다양한 완제품
// needs [x] [y] = 1 -> x물건을 만드는데 y 부품이 필요 있다.

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RobotFactory {
    HashMap<String, Integer> map;
    int MAX;


    public void makeMap(int n, int r, String result) {

        if (n == 0)
        {
            map.put(result, 0);
            return;
        }

        for (int i=r; i<MAX; i++) {
            makeMap(n-1, i+1, result + String.valueOf(i));
        }
    }
        public int solution(int[][] needs, int r) {

            // 조합, 가능 갯
            map = new HashMap<>();

            MAX = needs[0].length;

            makeMap(r ,0,  "");

            int cnt = 0;
            for (int[] need: needs) {
                if (getCount(need) > r)
                    continue;

                List<String> keyset = map.keySet().stream().filter(x -> Contains(x, need)).collect(Collectors.toList());
                for (String key : keyset) {
                    map.put(key.toString(), map.get(key) + 1);
                }
            }

            String maxkey = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();



            return map.get(maxkey);
        }
        public boolean Contains(String str, int[] data) {
        String key = "";
            for (int i=0; i<data.length; i++) {
                if(data[i] == 1) {
                    key += String.valueOf(i);
                }
            }
            for (char c : key.toCharArray()) {
                if (!str.contains(String.valueOf(c)))
                    return false;
            }
            return true;
        }
        public int getCount(int[] need) {
            int cnt = 0;
            for (int i : need) {
                if (i == 1)
                cnt++;
            }
            return cnt;
        }
}
