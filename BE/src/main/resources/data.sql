insert into team(name, is_user)
values ('Captain', false);
insert into team(name,  is_user)
values ('Marvel', false);
insert into team(name,  is_user)
values ('Twins', false);
insert into team(name,  is_user)
values ('Tigers', false);
insert into team(name,  is_user)
values ('Rockets', false);
insert into team(name,  is_user)
values ('Dodgers', false);

insert into player(name, team)
values ('eve', 1);
insert into player(name, team)
values ('jung', 1);
insert into player(name, team)
values ('jane', 2);
insert into player(name, team)
values ('adela', 2);

insert into team_game_score(inning_number, score, team)
values (1, 0, 1);
insert into team_game_score(inning_number, score, team)
values (2, 1, 1);
insert into team_game_score(inning_number, score, team)
values (1, 4, 2);


insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '타자', 0, 5, 5, 0, 1, 2);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '투수', 15, 2, 1, 2, 0.5, 1);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (1, '타자', 0, 4, 3, 1, 0.75, 3);
insert into player_game_info(batting_order, role, pitch_count, plate_appearance, hits, `out`, average, player)
values (2, '투수', 30, 2, 1, 2, 0.5, 4);

insert into history(player, team, action_name, strike, ball, `out`)
values (1, 1, 'S', 2, 2, 1);
insert into history(player, team, action_name, strike, ball, `out`)
values (1, 1, 'H', 2, 2, 1);
insert into history(player, team, action_name, strike, ball, `out`)
values (2, 1, 'H', 2, 2, 1);
insert into history(player, team, action_name, strike, ball, `out`)
values (3, 2, 'S', 2, 2, 1);
insert into history(player, team, action_name, strike, ball, `out`)
values (3, 2, 'H', 2, 2, 1);
insert into history(player, team, action_name, strike, ball, `out`)
values (4, 2, 'H', 2, 2, 1);

-- insert into `match`(my_team_id, counter_team_id, is_home)
-- values (1, 2, true);
