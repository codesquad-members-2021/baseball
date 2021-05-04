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


