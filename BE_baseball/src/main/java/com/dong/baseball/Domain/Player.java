package com.dong.baseball.Domain;

public class Player {
    // 타자 투수 구별은 없음, 왜냐하면 불펜으로 타자가 투수할수도 있기 때문
    // 나중에 Player를 최대한 풍부하게 만들어놓고 batter, pitcher 클래스를 상속받아 만들면 됨
    String team;
    int gamesPlayed;
    int atBat;
    int hit;
    int ball;
    int Strike;
    double battingAverage;
}
