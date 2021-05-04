package com.company;

public class MaxAndMin {
    public String solution(String s) {
         String[] nums = s.split(" ");
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;

         for (int i=0; i<nums.length; i++) {
             int num = Integer.valueOf(nums[i]);
             if (max < num)
                 max = num;
             if (min > num)
                 min = num;
         }
        String answer = "";
         answer += min;
         answer += " ";
         answer += max;
        return answer;
    }
}
