package com.codesquad.coco.utils;

const val GAME_SAVE_SQL: String = """
insert into game (home,away,user_type) 
values (:home,:away,:user_type);
"""

const val FIND_USER_TEAM_NAME_SQL: String = """
select if(g.user_type = 'home',g.home,g.away) as team_name 
from game g where g.id = :id;
"""

const val FIND_ALL_INNINGS_SQL: String = """
select i.id, i.score, i.score_board 
from innings i 
where i.score_board =:id order by score_board_key;
"""

const val SCORE_BOARD_SAVE_SQL: String = """
insert into score_board (game,team) 
values (:game, :team);
"""

const val FIND_SCORE_BOARD_SQL: String = """
select s.id, s.game,s.team 
from score_board s
where s.game =:id and s.team = :teamName;
"""

const val FIND_SCORE_BOARDS_SQL: String = """
select s.id, s.game,s.team 
from score_board s 
where s.game = :id;
"""

const val INNINGS_SAVE_SQL: String = """
insert into innings (score_board, score, score_board_key)
values (:score_board,:score,:score_board_key);
"""

const val FIND_PLAYER_BY_TEAM_NAME: String = """
SELECT p.id as pid, p.type, p.name, r.id as rid, r.outs, r.hits, r.at_bat 
FROM player p 
inner JOIN record r ON r.player = p.id 
WHERE p.team = :teamName order by p.id;
"""

const val FIND_PLAYER_BY_PLAYER_ID: String = """
select p.id as pid, p.name, p.type, r.id as rid, r.outs, r.hits, r.at_bat 
from player p 
inner JOIN record r ON r.player = p.id 
where p.id= :id;
"""

const val UPDATE_PLAYER_RECORD: String = """
update record set at_bat = :atBat, hits = :hits, outs = :outs 
where id = :id;
"""

const val FIND_ALL_TEAM_NAME: String = """
select t.name 
from team t
"""

const val FIND_HOME_TEAM_NAME_BY_GAME_ID: String = """
select g.home as team_name 
from game g where g.id = :id;
"""

const val FIND_AWAY_TEAM_NAME_BY_GAME_ID: String = """
select g.away as team_name 
from game g where g.id = :id;
"""

