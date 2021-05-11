use baseball;

insert into team(name, is_user) values ('Captain', false);
insert into team(name, is_user) values ('Marvel', false);
insert into team(name, is_user) values ('Twins', false);
insert into team(name, is_user) values ('Tigers', false);
insert into team(name, is_user) values ('Rockets', false);
insert into team(name, is_user) values ('Dodgers', false);

insert into player(name, team) values ('신데렐라', 1);
insert into player(name, team) values ('모아나', 1);
insert into player(name, team) values ('벨', 1);
insert into player(name, team) values ('애리얼', 1);
insert into player(name, team) values ('라푼젤', 1);
insert into player(name, team) values ('뮬란', 1);
insert into player(name, team) values ('자스민', 1);
insert into player(name, team) values ('포카혼타스', 1);
insert into player(name, team) values ('메리다', 1);

insert into player(name, team) values ('김광진', 2);
insert into player(name, team) values ('이동규', 2);
insert into player(name, team) values ('김진수', 2);
insert into player(name, team) values ('박영권', 2);
insert into player(name, team) values ('추진수', 2);
insert into player(name, team) values ('이용대', 2);
insert into player(name, team) values ('류현진', 2);
insert into player(name, team) values ('최동수', 2);
insert into player(name, team) values ('한양범', 2);

insert into player(name, team) values ('엘사', 3);
insert into player(name, team) values ('안나', 3);
insert into player(name, team) values ('올라프', 3);
insert into player(name, team) values ('스벤', 3);
insert into player(name, team) values ('크리스토프', 3);
insert into player(name, team) values ('트롤', 3);
insert into player(name, team) values ('얼음괴물', 3);
insert into player(name, team) values ('한스', 3);
insert into player(name, team) values ('스벤당근', 3);

insert into player(name, team) values ('이승만', 4);
insert into player(name, team) values ('장면', 4);
insert into player(name, team) values ('최규하', 4);
insert into player(name, team) values ('전두환', 4);
insert into player(name, team) values ('노태우', 4);
insert into player(name, team) values ('김영삼', 4);
insert into player(name, team) values ('김대중', 4);
insert into player(name, team) values ('노무현', 4);
insert into player(name, team) values ('이명박', 4);

insert into player(name, team) values ('버즈', 5);
insert into player(name, team) values ('우디', 5);
insert into player(name, team) values ('제시', 5);
insert into player(name, team) values ('보핍', 5);
insert into player(name, team) values ('포키', 5);
insert into player(name, team) values ('렉스', 5);
insert into player(name, team) values ('햄', 5);
insert into player(name, team) values ('포테이토헤드', 5);
insert into player(name, team) values ('에일리언', 5);

insert into player(name, team) values ('아이언맨', 6);
insert into player(name, team) values ('캡틴아메리카', 6);
insert into player(name, team) values ('스파이더맨', 6);
insert into player(name, team) values ('헐크', 6);
insert into player(name, team) values ('스칼렛위치', 6);
insert into player(name, team) values ('블랙위도우', 6);
insert into player(name, team) values ('블랙팬서', 6);
insert into player(name, team) values ('토르', 6);
insert into player(name, team) values ('그루트', 6);



insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 1);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 2);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 3);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 4);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 5);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 6);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 7);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 8);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 9);

insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 10);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 11);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 12);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 13);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 14);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 15);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 16);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 17);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 18);

insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 19);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 20);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 21);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 22);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 23);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 24);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 25);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 26);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 27);

insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 28);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 29);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 30);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 31);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 32);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 33);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 34);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 35);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 36);

insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 37);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 38);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 39);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 40);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 41);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 42);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 43);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 44);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 45);

insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 0, 0, 0, 0, 0, 46);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 0, 0, 0, 0, 47);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (3, '타자', 0, 0, 0, 0, 0, 48);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (4, '타자', 0, 0, 0, 0, 0, 49);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (5, '타자', 0, 0, 0, 0, 0, 50);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (6, '타자', 0, 0, 0, 0, 0, 51);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (7, '타자', 0, 0, 0, 0, 0, 52);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (8, '타자', 0, 0, 0, 0, 0, 53);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (9, '타자', 0, 0, 0, 0, 0, 54);
