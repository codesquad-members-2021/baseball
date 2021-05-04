insert into team(name)
values ('team1');
insert into team(name)
values ('team2');
insert into team(name)
values ('team3');
insert into team(name)
values ('team4');

insert into player(name, team)
values ('eve', 1);
insert into player(name, team)
values ('jung', 1);
insert into player(name, team)
values ('jane', 2);
insert into player(name, team)
values ('adela', 2);

insert into team_game_score(inning, score, team)
values (1, 3, 1);
insert into team_game_score(inning, score, team)
values (1, 4, 2);


insert into player_game_info(batting_order, role, plate_appearance, hits, `out`, average, player)
values (2, '타자', 5, 5, 0, 1, 2);
insert into player_game_info(batting_order,  role, plate_appearance, hits, `out`, average, player)
values (1, '투수', 2, 1, 2, 0.5, 1);
insert into player_game_info(batting_order,  role, plate_appearance, hits, `out`, average, player)
values (1, '타자', 4, 3, 1, 0.75, 3);
insert into player_game_info(batting_order,  role, plate_appearance, hits, `out`, average, player)
values (2, '투수', 2, 1, 2, 0.5, 4);

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
