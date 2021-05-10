package com.company.Level2;

public class JumpAndTeleport {
    int battery = Integer.MAX_VALUE;
    // K 칸을 앞으로 점프
    // (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동
    // K 칸 점프하면 K 만큼의 건전지 사용량
    // 건전지 사용량을 최소화
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }
    public void func(int now, int dest, int use) {
        if (use > battery) return;
        else if (now * 2 == dest && battery > use) {
            battery = use;
            return;
        }

        func(now + 1, dest, use + 1);
        func(now * 2, dest, use);
    }
}
