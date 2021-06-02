package com.company.KAKAOBLIND2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class Cache {
    int cash_miss = 5;
    int cash_hit = 1;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (i < cacheSize) {
                list.add(city);
                answer += cash_miss;
                continue;
            }
            if (list.contains(city)) {
                answer += cash_hit;
                list.remove(city);
                list.add(city);
            }
            else {
                answer += cash_miss;
                if (list.size() > 0) {
                    list.remove(0);
                    list.add(city);
                }
            }
        }
        return answer;
    }
}
