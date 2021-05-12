package com.company.DevCat;

import java.util.Stack;

// 보조배터리 n개를 구매하기 위해 필요한 최소 금액
// 견적 battery 에는 판매 단위와 단위 가격
// 효용성 없네
public class Num2 {
    public int solution(int n, int[][] battery) {
        dfs(n, battery);
        return price;
    }
    public void dfs(int n, int[][] battery) {
        Stack<NOW> stack = new Stack<>();
        stack.add(new NOW(0, 0));

        while(!stack.empty()) {
            NOW now = stack.pop();
            if (now.n >= n) {
                if (price > now.price)
                    price = now.price;
                continue;
            }

            for (int i=0; i<battery.length; i++) {
                int val1 = battery[i][0];
                int val2 = battery[i][1];
                if (now.price + val2 > price) continue;
                stack.push(new NOW(now.n+val1, now.price+val2));
            }
        }
    }
    public int getMinIdx(int n, int[][] battery) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i=0; i< battery.length; i++) {
            if (battery[i][1]/battery[i][0] < min) {
                min = battery[i][1]/battery[i][0];
                idx = i;
            }
        }
        int mul = n / battery[idx][0];
        cnt = mul * battery[idx][0];
        if (cnt < n) cnt += battery[idx][0];

        return idx;
    }
    public void dfs2(int n, int[][] battery) {
        int idx = getMinIdx(n, battery);
        int unit = battery[idx][0];
        int unitP = battery[idx][1];

        Stack<NOW> stack = new Stack<>();
        stack.add(new NOW(cnt, cnt/unit * unitP));
        price = stack.peek().price;

        while(!stack.empty()) {
            NOW now = stack.pop();
            now.n -= unit;
            now.price -= unitP;
//            if (now.price >= n) {
//                if (price > now.price)
//                    price = now.price;
//                continue;
//            }

            for (int i=0; i<battery.length; i++) {
                int val1 = battery[i][0];
                int val2 = battery[i][1];
                if (now.price + val2 > price) continue;
                stack.push(new NOW(now.n+val1, now.price+val2));
            }
        }
    }
    int price = Integer.MAX_VALUE;
    int cnt=0;

    public class NOW {
        int n;
        int price;

        public NOW(int n, int total) {
            this.n = n;
            this.price = total;
        }
    }
}
