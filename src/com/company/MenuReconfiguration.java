package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MenuReconfiguration {
    HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {

        HashSet<String> hashSet = new HashSet<>();

        for (int crs : course) {
            for (String order : orders) {
                getCourse(order, crs, 0, "");
            }
        }

        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
        hashSet.addAll(map.keySet());

        for (int crs : course) {
            int max = 2;
            for (String key : map.keySet()) {
                if (key.length() != crs)
                    continue;
                int val = map.get(key);
                if (val > max)
                    max = val;
            }
            for (String key : hashSet) {
                if (key.length() != crs)
                    continue;
                if (map.get(key) < max)
                    map.remove(key);
            }
        }
        String[] answer = new String[map.size()];

        int idx = 0;
        for (String key : map.keySet()) {
            answer[idx++] = key;
            System.out.println(key);
        }

        Arrays.sort(answer);
        return answer;
    }
    public String sortStr(String str) {
        String[] array = str.split("");
        Arrays.sort(array);
        return String.join("", array);
    }
    public void getCourse(String order, int n, int r, String result) {
        if (n == 0) {
            result = sortStr(result);
            map.put(result, map.getOrDefault(result, 0) + 1);
            //System.out.println(result + " : " + map.get(result));
            return;
        }
        for (int i=r; i<order.length(); i++) {
            getCourse(order, n-1, i+1, result + order.charAt(i));
        }
    }
}
