package com.company;


import com.company.DFS_BFS.Network;
import com.company.DFS_BFS.TravelRoute;
import com.company.DFS_BFS.WordTrans;
import com.company.DP.ExpressionInN;
import com.company.DP.IntegerTriangle;
import com.company.KAKAOBLIND2018.SortFiles;
import com.company.Level2.*;
import com.company.SixShop.Num2;
//import com.company.SixShop.Num4;
import com.company.SixShop.ShorterWord;

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

//          RightParentheses m = new RightParentheses();
//          m.solution("()()");

//        QuadTree q = new QuadTree();

//        int[][] data = new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
//        TheBiggestSquare t = new TheBiggestSquare();

//        int[][] data = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] data = new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};

//        EatingLand e = new EatingLand();
//        e.solution(data);

//        CollectStickers c = new CollectStickers();
//        c.solution(new int[] {1,1,1,100,1,1,1,100,1,1,1,100});
//        WordsPuzzle w = new WordsPuzzle();
//        w.solution(new String[] {"app","ap","p","l","e","ple","pp"}, "apple");
//        Network n = new Network();
//        int[][] data = {{1,1,0},  {1,1,0}, {0,0,1}};
//        n.solution(3, data);

//        WordTrans w = new WordTrans();
//        w.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});// 4

//        TravelRoute t = new TravelRoute();
//        String[][] data = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
//        String[][] data = 	{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] data = 	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        t.solution(data); // "ICN", "JFK", "HND", "IAD"

//        ExpressionInN e = new ExpressionInN();
//        e.solution(5, 12); // 4

//        IntegerTriangle i = new IntegerTriangle();
//        int[][] data = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        i.solution(data); // 30

//        NextBiggerNumber number = new NextBiggerNumber();
//        number.solution(78); // 83
//        number.solution(15); // 23
//        number.solution(6); // 9

//        SortFiles sortFiles = new SortFiles();
//        sortFiles.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

//        ShorterWord shorterWord = new ShorterWord();
//        shorterWord.solution("xyZA", "aBCxy"); // ABCxyZA

//        Num2 num2 = new Num2();
//        num2.solution(new int[] {2,2,1}); // 1,1,3
//        Num4 num4 = new Num4();
//        num4.solution(4, new int[] {4,2,2,5,3}); // 2,3,1,5,4
//        Fibonacci fibonacci = new Fibonacci();
//        System.out.println(fibonacci.solution(100000)); // 2
//        CreateMinimumValue createMinimumValue = new CreateMinimumValue();
//        createMinimumValue.solution(new int[] {1,4,2}, new int[] {5,4,4}); // 29

//        MultiflyOfMatrix multiflyOfMatrix = new MultiflyOfMatrix();
//        int[][] arr1 = {{1,4}, {3,2}, {4,1}};
//        int[][] arr2 = {{3,3}, {3,3}};
//        multiflyOfMatrix.solution(arr1, arr2);

//        LCMofN lcMofN = new LCMofN();
//        lcMofN.solution(new int[]{2,6,8,14}); // 168

        WordChainPlay wordChainPlay = new WordChainPlay();
        wordChainPlay.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}); // 3,3
    }
}
