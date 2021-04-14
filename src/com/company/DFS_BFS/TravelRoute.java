package com.company.DFS_BFS;

import java.lang.reflect.Array;
import java.util.*;

public class TravelRoute {

    ArrayList<String> ans = new ArrayList<>();
    String start = "ICN";
    // ICN 에서 출발
    // 주어진 항공권을 모두 이용하여 여행경로를 짠다.
    public String[] solution1(String[][] tickets) {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        int flight = tickets.length + 1;

        for (String[] ticket : tickets) {
//            map.computeIfAbsent(ticket[0], s -> new ArrayList<>()).add(ticket[1]);
            map.put(ticket[0], map.getOrDefault(ticket[0], new ArrayList<>()));
            map.get(ticket[0]).add(ticket[1]);
        }

        list.add(start);
        // 출발지 ICN
        GetTravelRoute(map, list, flight);

        String[] answer = new String[flight];
        for (int i=0; i<flight; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public void GetTravelRoute(HashMap<String, List<String>> tickets, ArrayList<String> route, int n) {

        HashMap<String, List<String>> _tickets = new HashMap<>();
        ArrayList<String> _route = new ArrayList<>();
        _route.addAll(route);
        for (String key : tickets.keySet()) {
            _tickets.put(key, new ArrayList<>(tickets.get(key)));
        }

        for (int i=0; i<n; i++) {
            String from = _route.get(_route.size()-1);
            if (_tickets.get(from).size() == 0) return;

            if (_tickets.get(from).size() > 1) {
                Collections.sort(_tickets.get(from));

                int size = _tickets.get(from).size();
                for (int j=0; j<size; j++) {
                    String to = _tickets.get(from).remove(0);
                    _route.add(to);

                    GetTravelRoute(_tickets, _route, n);
                    if (ans.size() > 0) return;

                    _tickets.get(from).add(to);
                    _route.remove(_route.size()-1);
                }
                break;
            }

            if (_tickets.get(from).size() == 1) {
                String to = _tickets.get(from).remove(0);
                _route.add(to);
                if (n == _route.size()) {
                    ans = _route;
                    return;
                }
            }
        }
    }


    String result = "";
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        dfs(tickets, "ICN", "ICN", 0);

        String[] answer = result.split(",");
        return answer;
    }

    public void dfs(String[][] tickets, String route, String now, int n) {
        if (n == tickets.length) {
            result = route;
            return;
        }

        for (int i=0; i< tickets.length; i++) {
            if (tickets[i][0] == now) {
                String next = tickets[i][1];
                tickets[i][0] = "";
                dfs(tickets, route +","+ next, next, n+1);
                if (result != "") return;
                tickets[i][0] = now;

            }
        }
    }
}
//import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//class Solution {
//    List<String> list = new ArrayList<>();
//    static String route = "";
//    static boolean[] visit;
//
//    private void dfs(String[][] tickets, String end, int cnt) {
//        route += end + ",";
//
//        if(cnt == tickets.length) {
//            list.add(route); return;
//        }
//
//        for(int i = 0; i < tickets.length; i++) {
//            String s = tickets[i][0], e = tickets[i][1];
//            if(s.equals(end) && !visit[i]) {
//                visit[i] = true;
//                dfs(tickets, e, cnt + 1);
//                visit[i] = false; route = route.substring(0, route.length()-4);
//            }
//        }
//    }
//
//    public String[] solution(String[][] tickets) {
//        for(int i = 0; i < tickets.length; i++) {
//            visit = new boolean[tickets.length];
//            String start = tickets[i][0], end = tickets[i][1];
//
//            if(start.equals("ICN")) {
//                route = start + ","; visit[i] = true;
//                dfs(tickets, end, 1);
//            }
//        }
//
//        Collections.sort(list);
//        String[] answer = list.get(0).split(",");
//
//        return answer;
//    }
//}