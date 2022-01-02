
insert into team (`team_id`, name) values (1, '테스트팀1');

insert into team (`team_id`, name) values (2, '테스트팀2');

insert into team (`team_id`, name) values (3, '테스트팀3');

insert into coach (`coach_id`, `career`, `name`, `team_id`) values (1, NULL, 'Coach1', 1);

insert into coach (`coach_id`, `career`, `name`, `team_id`) values (2, NULL, 'Coach2', 2);

insert into coach (`coach_id`, `career`, `name`, `team_id`) values (3, NULL, 'Coach3', 3);

insert into member (`member_id`, `age`, `coach_id`, `team_id`, `username`) values (1, 31, 1, 1, '유호연1');

insert into member (`member_id`, `age`, `coach_id`, `team_id`, `username`) values (2, 34, 2, 2, '유호연2');

insert into member (`member_id`, `age`, `coach_id`, `team_id`, `username`) values (3, 34, 2, 2, '유호연3');

insert into member (`member_id`, `age`, `coach_id`, `team_id`, `username`) values (4, 34, 2, 2, '유호연4');

insert into member (`member_id`, `age`, `coach_id`, `team_id`, `username`) values (5, 34, 1, 1, '유호연5');