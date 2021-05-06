-- schema.sql 파일은 DDL 스크립트
-- data.sql 파일은 DML 스크립트
use baseball;
INSERT INTO `match`(home,away) values
    ('Tigers','Bears'),
    ('Bears','Twins'),
    ('Twins','Dinos'),
    ('Dinos','Lions'),
    ('Lions','Eagles'),
    ('Eagles','Giants'),
    ('Giants','Tigers');

-- -- 둘중하나 TOP/AWAY or BOT/HOME

INSERT INTO 'board'(`inning`,`turn`,`strike`,`ball`,`out`,`home_point`,`away_point`,`pitcher`,`batter`) values
(1,'TOP/AWAY',0,0,0,0,0,'kim','dong'),
(1,'TOP/AWAY',1,0,0,0,0,'kim','dong'), -- 1 스트라이크
(1,'TOP/AWAY',2,0,0,0,0,'kim','dong'), -- 2 스트라이크
(1,'TOP/AWAY',3,0,1,0,0,'kim','dong'), -- 3 스트라이크 , 삼진아웃
(1,'TOP/AWAY',0,0,1,0,0,'kim','hun'), -- 타자변경
(1,'TOP/AWAY',0,1,1,0,0,'kim','hun'), -- 1 볼
(1,'TOP/AWAY',0,2,1,0,0,'kim','hun'), -- 2 볼
(1,'TOP/AWAY',1,2,1,0,0,'kim','hun'), -- 2 볼 1스트라이크
(1,'TOP/AWAY',0,0,1,0,0,'kim','honux'), -- 앞에서 안타 쳐서 호눅스로 타자변경
(1,'TOP/AWAY',1,0,1,0,0,'kim','honux'), -- 앞에서 안타 쳐서 호눅스로 타자변경
(1,'TOP/AWAY',2,0,1,0,0,'kim','honux'), -- 앞에서 안타 쳐서 호눅스로 타자변경
(1,'TOP/AWAY',3,0,1,0,0,'kim','honux'), -- 앞에서 안타 쳐서 호눅스로 타자변경



(1,'BOT/HOME',0,0,0,0,0,'kim','dong');