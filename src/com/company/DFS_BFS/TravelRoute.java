package com.company.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TravelRoute {
    HashMap<String, List<String>> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();
    String key = "ICN";
    // ICN 에서 출발
    // 주어진 항공권을 모두 이용하여 여행경로를 짠다.
    public String[] solution(String[][] tickets) {

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], s -> new ArrayList<>()).add(ticket[1]);
        }
        list.add(key);
        GetRoute(map, list, tickets, 0);
        // 출발지 ICN

        return (String[]) list.toArray();
    }
    public boolean GetRoute(HashMap<String, List<String>> map, ArrayList<String> list, String[][] tickets, int n) {
        if (n == tickets.length) {
            ans = list;
            return true;
        }
        else {
            for (int i=n; i<tickets.length; i++) {
                if (!map.containsKey(key)) return false;
                if (map.get(key).size() < 1) return false;

                if (map.get(key).size() > 1) {
                    Collections.sort(map.get(key));
                    for (int j=0; j<map.get(key).size(); j++) {
                        key = map.get(key).remove(j);
                        list.add(key);
                        if (!GetRoute(map, list, tickets, n+1) && n > 0) continue;
                        map.get(key).add(key);
                        list.remove(list.size() - 1);
                    }
                }
                key = map.get(key).remove(0);
                list.add(key);
            }
        }
        return false;
    }
}
