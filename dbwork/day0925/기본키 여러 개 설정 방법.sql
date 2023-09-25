create table test(
num smallint,
name varchar(20),
age smallint default 10,
birthday date,
constraint test_pk_numname primary key(num, name)
);

insert into test values (1, 'lee', 10, now());
insert into test values (2, 'lee', 10, now());
insert into test values (1, 'kim', 10, now());
-- insert into test values (1, 'lee', 10, now()); -- num과 name이 기본키로 설정되었기 때문에 num과 name 모두 같은 게 있으면 안됨

drop table test;