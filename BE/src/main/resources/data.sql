use baseball;

insert into team(name, is_user) values ('Captain', false);
insert into team(name, is_user) values ('Marvel', false);
insert into team(name, is_user) values ('Twins', false);
insert into team(name, is_user) values ('Tigers', false);
insert into team(name, is_user) values ('Rockets', false);
insert into team(name, is_user) values ('Dodgers', false);

insert into player(name, team) values ('KimGwangJin', 1);
insert into player(name, team) values ('LeeDongKyu', 1);
insert into player(name, team) values ('KimJinSu', 1);
insert into player(name, team) values ('ParkYoungKwon', 1);
insert into player(name, team) values ('ChooJinsu', 1);
insert into player(name, team) values ('leeYongdae', 1);
insert into player(name, team) values ('RyuHeonJin', 1);
insert into player(name, team) values ('ChoiDongsu', 1);
insert into player(name, team) values ('HanYangbeom', 1);

insert into player(name, team) values ('김광진', 2);
insert into player(name, team) values ('이동규', 2);
insert into player(name, team) values ('김진수', 2);
insert into player(name, team) values ('박영권', 2);
insert into player(name, team) values ('추진수', 2);
insert into player(name, team) values ('이용대', 2);
insert into player(name, team) values ('류현진', 2);
insert into player(name, team) values ('최동수', 2);
insert into player(name, team) values ('한양범', 2);

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
