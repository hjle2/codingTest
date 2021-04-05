package com.company;


import com.company.GroupPhoto.GroupPhoto;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        ParenthesesConversion.Solution("(()())()");
//        ParenthesesConversion.Solution(")(");
//        ParenthesesConversion.Solution("()))((()");
//        ParenthesesConversion.Solution(")))()(((");

//        GetPrimeNumbers g = new GetPrimeNumbers();
//        g.solution("17");
//        g.solution("011");

//        MenuReconfiguration m = new MenuReconfiguration();
//        m.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
//        m.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5});
//        m.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4});

//        TargetNumber m = new TargetNumber();
//        m.solution(new int[]{1,1,1,1,1}, 3); // 5
//        m.solution(new int[]{1, 2, 1, 2}, 2); // 3

//        RankingSearch m = new RankingSearch();
//        String test = "java";
//        boolean result = test.matches("ja[a-z]*");


//        m.solution4(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
//                new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});

        GroupPhoto m = new GroupPhoto();

        m.solution(2, new String[] {"N~F=0", "R~T>2"});
    }
}
