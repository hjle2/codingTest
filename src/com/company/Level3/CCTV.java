package com.company.Level3;

import java.util.ArrayList;
import java.util.Collections;

public class CCTV {
    public boolean isAllTrue(boolean[] arr) {
        for (boolean val : arr) {
            if (!val) return false;
        }
        return true;
    }
    public int solution(int[][] routes) {
        ArrayList<Integer> out = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        boolean[] isInCCTV = new boolean[routes.length];

        for (int i=0; i<routes.length; i++) {
            out.add(routes[i][1]);
            in.add(routes[i][0]);
            isInCCTV[i] = false;
        }

        Collections.sort(out);
        Collections.sort(in);

        int answer = 0;
        int idx = 0;
        int CCTV = out.get(0);

        while (++answer > 0 &&!isAllTrue(isInCCTV)) {
            for (int i=0; i<out.size(); i++) {
                if (!isInCCTV[i] && routes[i][0] <= CCTV) {
                    isInCCTV[i] = true;
                    idx++;
                }
            }
            CCTV = 0;
            // in 시간 중에서 idx 번째로 작은 값인 차의 out시간이 다음 CCTV
            if (idx >= in.size()) break;
            int val = in.get(idx);
            for (int i=0; i<out.size(); i++) {
                if (routes[i][0] == val) {
                    CCTV = Math.max(routes[i][1], CCTV);
                }
            }
        }
//        for (int i=0; i<out.size(); i++)
//        {
//            int CCTV = out.get(i);
//            boolean isAddAns = false;
//            for (int j=0; j< isInCCTV.length; j++) {
//                if (!isInCCTV[j] && routes[j][0] <= CCTV) {
//                    isInCCTV[j] = true;
//                    isAddAns = true;
//                }
//            }
//            if (isAddAns)  {
//                answer++;
//                System.out.println(i + " : " + CCTV);
//            }
//        }
        return answer;
    }
}
