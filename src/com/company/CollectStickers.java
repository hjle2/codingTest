package com.company;

public class CollectStickers {

    int[] dp1;
    int[] dp2;
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1)
            return sticker[0];

        dp1 = new int[n];
        dp2 = new int[n];

        dp1[0] = sticker[0];
        dp1[1] = dp1[0];

        for (int i=2; i<n-1; ++i) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i=2; i<n; ++i) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        return Math.max(dp1[n-2], dp2[n-1]);
    }
    public void SOLUTION(int[] arr) {

        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i];
        }
    }



    public int[] arr;
    public int sum;
    int answer = 0;
    public int GetMax(int[] arr) {
        int max = 0;
        for (int i: arr) {
            max = Math.max(i, max);
        }
        return max;
    }
    public boolean isNull(int[] arr) {
        for (int i: arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
    public int GetNumOfEven(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                even += arr[i];
            else
                odd +=  arr[i];
        }
        return Math.max(even, odd);
    }
    public int GetNumOfOdd(int[] tt, int r, int sum) {
        if (isNull(arr)) {
            return sum;
        }
        else {
            for (int i=0; i< arr.length; i++) {
                int tmp = arr[i];
                if (tmp == 0) continue;
                int ileft = i - 1;
                if (ileft < 0) ileft = arr.length-1;
                int iright = i + 1;
                if (iright >= arr.length) iright = 0;
                int left = arr[ileft];
                int right = arr[iright];

                arr[i] = 0;
                arr[ileft] = 0;
                arr[iright] = 0;
                answer = Math.max(GetNumOfOdd(arr, r+1, sum + tmp), answer);
                arr[i] = tmp;
                arr[ileft] = left;
                arr[iright] = right;
            }

            return sum;
        }

    }
}