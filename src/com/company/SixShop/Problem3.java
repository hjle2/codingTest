package com.company.SixShop;

public class Problem3 {
    int boxs = Integer.MAX_VALUE;

    // 3, 5 개를 담을 수 있는 상자
    // 갯수에 따라 배송비
    // 꽉 차야 배송 가능하다..
    // 보낼 수 없다면 -1 반환
    public int solution(int n) {

        Cal(0, 0, n);
        return boxs == Integer.MAX_VALUE ? -1 : boxs;
    }

    public void Cal (int cnt5, int cnt3, int total) {
        if (total == 0) {
            if (boxs > (cnt5 + cnt3))
                boxs = cnt5 + cnt3;
            return;
        }
        if (total < 0) {
            return;
        }
        if (boxs < (cnt5 + cnt3))
            return;

        Cal(cnt5 + 1, cnt3, total - 5);
        Cal(cnt5, cnt3 + 1, total - 3);
    }
}
