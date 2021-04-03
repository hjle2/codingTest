package com.company;


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


//        kakaoTest m = new kakaoTest();
//        m.solution2(new int[]{4,5,3,2,1} , new int[] {2,4,4,5,1});

//        RobotFactory m = new RobotFactory();
//                int[][] data = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} };
//                m.solution(data, 2);

//        Railways m = new Railways();
                int[][] data = {  {2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
               // int[][] data = {  {1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
//        m.solution(5, new int[]  { 1,1,2,3,4 }, data);

        Matrix m = new Matrix();
        m.solution(6, 6, data);


    }
}
