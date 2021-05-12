package com.company.KAKAOBLIND2018;

// 네오는 자신이 기억한 멜로드를 방금 그곡을 이용해 음악을 찾는다.
// 네오가 기억하는 멜로디는 끝과 처음 부분
// 제목, 재생이 시작되고 끝난 시각, 악보를 제공
// CDE FGA 의 12개 (+#)
// 1분에 1개의 음 재생
// 재생 시간 > 음악 길이 이면, 반복 재생
// 0:0 을 넘겨서 재생되는 일은 없음
// 여러 음악이 일치하면, 재생된 시간이 제일 긴 음악 제목을 반환
// 재생 시간도 같으면 먼저 입력된 음악 제목 반환
// 없으면 " (None) " 반환
public class TheSong {
    public class Song {
        int idx;
        int playTime;
        String title;
        String melody;

        public Song(int idx, int playTime, String title, String melody) {
            this.idx = idx;
            this.playTime = playTime;
            this.title = title;
            this.melody = melody;
        }
    }
    String none = " (None) ";
    public String getMelody(String melody, int playTime) {
        int len = melody.length();
        if (len == playTime)
            return melody;
        else if (len > playTime) {
            return melody.substring(0, playTime);
        }
        // len < playTime
        else {
            while(melody.length() < playTime) {
                int addLeng = playTime - len;
                if (addLeng <= melody.length())
                    melody += melody.substring(0, addLeng);
                else
                    melody += melody;
            }
            return melody;
        }
    }
    public String solution(String m, String[] musicinfos) {
        int playTime;
        String title, melody;
        for (String str : musicinfos) {
            String[] infos = str.split(",");
            String[] start = infos[0].split(":");
            String[] end = infos[1].split(":");

            int hour = Integer.valueOf(end[0]) - Integer.valueOf(start[0]);
            int minute = Integer.valueOf(end[1]) - Integer.valueOf(start[1]);

            playTime = hour * 60 + minute;
            title = infos[2];
            melody = infos[3];
        }
        String answer = "";
        return answer;
    }
}
