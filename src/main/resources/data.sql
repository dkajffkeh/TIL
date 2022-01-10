
insert into member (`member_id`, `age`, `username`) values (1, 31,'유호연1');

insert into member (`member_id`, `age`, `username`) values (2, 34,'유호연2');

insert into member (`member_id`, `age`, `username`) values (3, 34,'유호연3');

insert into member (`member_id`, `age`, `username`) values (4, 34,'유호연4');

insert into member (`member_id`, `age`, `username`) values (5, 34,'유호연5');

insert into team (`team_id`, name, `member_id`) values (1, '테스트팀1',3);

insert into team (`team_id`, name, `member_id`) values (2, '테스트팀2',3);

insert into team (`team_id`, name, `member_id`) values (3, '테스트팀3',3);

insert into coach (`coach_id`, `career`, `name`,`member_id`,`team_id`) values (1, NULL, 'Coach1',3, 1);

insert into coach (`coach_id`, `career`, `name`,`member_id`,`team_id`) values (2, NULL, 'Coach2',3, 2);

insert into coach (`coach_id`, `career`, `name`,`member_id`,`team_id`) values (3, NULL, 'Coach3',3, 3);

