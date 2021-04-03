package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class kakaoTest {
    // 상품권 하나씩
    // 교환 가능
    // 원하지 않는 상품을 받은 사람 수 최소
        public int solution2(int[] gift_cards, int[] wants) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i=0; i< gift_cards.length; i++) {
                if (gift_cards[i] == wants[i]) {
                    wants[i] = 0;
                    continue;
                }
                else list.add(gift_cards[i]);
            }

            int answer = 0;
            for (int i=0; i< wants.length; i++) {
                if (wants[i] == 0)
                    continue;
                if (!list.contains(wants[i])) {
                    answer++;
                    continue;
                }

                list.remove(list.indexOf(wants[i]));
            }
            return answer;
        }

        public int solution1(int[] gift_cards, int[] wants) {

            int len = gift_cards.length;
            boolean[] canExchange = new boolean[len];

            ArrayList<Integer> list = new ArrayList<>();

            for (int i=0; i<len; i++) {
                if (gift_cards[i] == wants[i]) {
                    list.add(0);
                    canExchange[i] = false;
                }
                else {
                    list.add(gift_cards[i]);
                    canExchange[i] = true;
                }
            }

            int answer = 0;
            for (int i=0; i<len; i++) {
                // 이미 원하는 값을 갖음.
                if (!canExchange[i]) {
                    continue;
                }
                int want = wants[i];
                // 교환할 사람이 없음.
                if (!list.contains(wants[i])) {
                    answer++;
                    continue;
                }

                // 교환
                int idx = list.indexOf(want);
                int temp = list.get(i);
                list.set(i, 0);
                list.set(idx, temp);

                canExchange[i] = false;
            }
            return answer;
    }
}
