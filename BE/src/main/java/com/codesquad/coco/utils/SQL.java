package com.codesquad.coco.utils;

public class SQL {
    public static String GAME_SAVE_SQL = "insert into game (home,away,user_type) values (:home,:away,:user_type)";
    public static String FIND_USER_TEAM_NAME_SQL = "select if(g.user_type = 'home',g.home,g.away) as team_name from game g where g.id = :id";
    public static String FIND_ALL_INNINGS_SQL = "select i.id, i.score, i.score_board from innings i where i.score_board =:id order by score_board_key";
    public static String SCORE_BOARD_SAVE_SQL = "insert into score_board (game,team) values (:game, :team)";
    public static String FIND_SCORE_BOARD_SQL = "select s.id, s.game,s.team from score_board s where s.game =:id and s.team = :teamName ";
    public static String FIND_SCORE_BOARDS_SQL = "select s.id, s.game,s.team from score_board s where s.game = :id";
    public static String INNINGS_SAVE_SQL = "insert into innings (score_board, score, score_board_key) values (:score_board,:score,:score_board_key)";
    public static String FIND_PLAYER_BY_TEAM_NAME = "SELECT p.id as pid, p.type, p.name, r.id as rid, r.outs, r.hits, r.at_bat FROM player p inner JOIN record r ON r.player = p.id WHERE p.team = :teamName order by p.id";
    public static String FIND_PLAYER_BY_PLAYER_ID = "select p.id as pid, p.name, p.type, r.id as rid, r.outs, r.hits, r.at_bat from player p inner JOIN record r ON r.player = p.id where p.id= :id";
    public static String UPDATE_PLAYER_RECORD = "update record set at_bat = :atBat, hits = :hits, outs = :outs where id = :id";
    public static String FIND_ALL_TEAM_NAME = "select t.name from team t";
    public static String FIND_HOME_TEAM_NAME_BY_GAME_ID = "select g.home as team_name from game g where g.id = :id ";
    public static String FIND_AWAY_TEAM_NAME_BY_GAME_ID = "select g.away as team_name from game g where g.id = :id ";

}
