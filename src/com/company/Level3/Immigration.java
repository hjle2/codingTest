package com.company.Level3;

import java.util.Arrays;

public class Immigration {
    long numProcessed(long mid, int[] times)
    {
        long numP = 0;
        for (int i = 0; i < times.length; i++)
        {
            numP += mid / times[i];
        }
        return numP;
    }
    // 0 < n < 1,000,000,000
    // 0 < times[] < 1,000,000,000
    // 0 < time.length < 100,000
    public long solution(int n, int[] times) {

        long result = 0;
        //최대한의 경우 1명당 smallestTime * n분 걸림
        long max = (long)times[0] * (long)n;

        while (result < max)
        {
            long mid = (max - result)/ 2 + result;
            long numP = numProcessed(mid, times);
            System.out.println(mid + " " +numP + " " + max);
            if (numP >= n)
            {
                max = mid;
            }
            else
            {
                result = mid + 1;
            }
        }

        return result;
    }
}
