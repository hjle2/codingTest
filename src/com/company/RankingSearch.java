package com.company;

import com.sun.jdi.connect.LaunchingConnector;

import java.util.*;
import java.util.stream.Collectors;

public class RankingSearch {

    public int[] solution4(String[] infos, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> map = new HashMap<>();

        for (String info : infos) {
            String[] data = info.split(" ");
            int score = Integer.valueOf(data[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(data[j]);
                }
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        List<Integer> empty = new ArrayList<>();

        int idx = 0;
        // 1. Point
        for (Map.Entry<String, List<Integer>> entry : map.entrySet())
            entry.getValue().sort(null);
        for (String qry : query) {
            int lastidx = qry.lastIndexOf(" ");
            int score = qry.substring(lastidx).trim().equals("-") ? 0 : Integer.valueOf(qry.substring(lastidx).trim());
            String key = qry.substring(0, lastidx).replaceAll("and", "").replaceAll(" ", "").replaceAll("-", "");

            List<Integer> list = map.getOrDefault(key, empty);

            int s = 0, e = list.size();

            // 2. Point
            while (s < e) {
                int mid = (s + e) / 2;

                if (list.get(mid) < score) s = mid + 1;
                else e = mid;
            }

            answer[idx++] = list.size() - s;

//            answer[idx] = map.containsKey(key) ? map.get(key).stream().filter(x -> x >= score).collect(Collectors.toList()).size() : 0;
        }
        return answer;
    }

    public int[] solution3(String[] infos, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> map = new HashMap<>();

        for (String info : infos) {
            int lastidx = info.lastIndexOf(" ");
            String key = info.substring(0, lastidx).replaceAll(" ", "");
            int score = Integer.valueOf(info.substring(lastidx).trim());

            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(score);
        }
int idx = 0;
        for (String qry : query) {
            int lastidx = qry.lastIndexOf(" ");
            String score = qry.substring(lastidx).trim();
            String data = qry.substring(0, lastidx).
                    replaceAll("and", "")
                    .replaceAll("-", "[a-z]*")
                    .replaceAll(" ", "");

            var entry = map.keySet().stream()
                    .filter(x -> x.matches(data)).collect(Collectors.toList());

            int cnt = 0;
                for (String key : entry) {
                    cnt += map.get(key).stream().filter(x -> score.equals("-") || x >= Integer.valueOf(score)).count();
                }

                answer[idx] = cnt;
                idx++;

        }
        return answer;
    }



    public class Applicant {
        Lang lang; // 0 -> - 1, java, 2 cpp, 3 python
        Position position;
        Level level;
        Food food;
        int score;
        public Applicant() {}
    }
    enum Lang {
        java,
        cpp,
        python
    }
    enum Position {
        backend,
        frontend,
    }
    enum Level {
        junior,
        senior,
    }
    enum Food {
        chicken,
        pizza,
    }

        public int[] solution2(String[] infos, String[] query) {
        int[] answer = new int[query.length];
        List<Applicant> applicants = new ArrayList<>();

        for (String info : infos) {
            String[] data = info.split(" ");
            Applicant per = new Applicant();
            per.lang = Lang.valueOf(data[0]);
            per.position = Position.valueOf(data[1]);
            per.level = Level.valueOf(data[2]);
            per.food = Food.valueOf(data[3]);
            per.score = Integer.valueOf(data[4]);
            applicants.add(per);
        }

        int idx = 0;
        for (String qry : query) {
            qry = qry.replaceAll("and ", "");
            String[] data = qry.split(" ");

            var cnt = applicants.stream().filter(
                    x -> (data[0].equals("-") || x.lang == Lang.valueOf(data[0]) )
                    && (data[1].equals("-") || x.position == Position.valueOf(data[1]))
                    && (data[2].equals("-") || x.level == Level.valueOf(data[2]))
                    && (data[3].equals("-") || x.food == Food.valueOf(data[3]))
                    && (data[4].equals("-") || x.score >= Integer.valueOf(data[4])))
                    .collect(Collectors.toList()).stream().count();

            answer[idx] = (int)cnt;

            idx++;
        }

        return answer;
    }

    public int[] solution1(String[] infos, String[] query) {
        int[] answer = new int[query.length];

        int idx = 0;
        for (String qry : query) {
            qry = qry.replaceAll("and ", "").replaceAll("-", "");
            String[] val = qry.split(" ");

            for (String info : infos) {
                // 4가 점수

                boolean flag = true;
                for (int i=0; i<val.length; i++) {
                    if (i < val.length - 1)
                    {
                        if (!info.contains(val[i].trim()))
                        {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        if (Integer.valueOf(info.split(" ")[4]) < Integer.valueOf(val[i]) )
                            flag = false;
                    }
                }
                if (flag)
                answer[idx]++;
            }
            idx++;
        }
        return answer;
    }

}
