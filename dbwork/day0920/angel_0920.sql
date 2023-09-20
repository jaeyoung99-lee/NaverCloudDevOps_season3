-- angel 계정 연습

-- 전체 시퀀스 조회
select * from seq;

-- sequence 생성
create sequence seq1 start with 1 increment by 1; -- 1부터 1씩 증가되는 시퀀스 생성
create sequence seq2 start with 5 increment by 3 nocache; -- 5부터 3씩 증가, cache 값은 0
create sequence seq3 maxvalue 100 nocache; -- start with 와 increment 생략 시 1로 초기값 지정

-- 값 발생시키기
select seq1.nextval, seq2.nextval, seq3.nextval from dual;

-- 시퀀스 제거
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

-- 새로운 시퀀스 하나 생성
create sequence seq_test nocache;

-- table 생성
create table test(
    num number(3) primary key,
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5, 2),
    birthday date);
    
-- 데이터 추가
-- 일부 데이터만 넣는 경우 컬럼명을 반드시 표기
insert into test(num, name) values (seq_test.nextval, '캔디');

-- 순서대로 모든 컬럼값을 넣는 경우 컬럼명 생략 가능
insert into test values (seq_test.nextval, '캐서린', 'AB', 67.89, sysdate);

-- 제약 조건에 안맞는 경우 오류 확인
insert into test(num, blood) values (seq_test.nextval, 'O');
insert into test(num, name, blood) values (2, 'Lee', 'O');

-- 제대로 된 데이터 3개 추가
insert into test values (seq_test.nextval, '강호동', 'B', 78.9, '2000-10-10');
insert into test values (seq_test.nextval, '유재석', 'A', 76.45, '1979-12-25');
insert into test values (seq_test.nextval, '이영자', 'O', 77.77, '1969-09-09');

rollback; -- 마지막 commit한 이후 SQL문(DML명령어 : insert, delete, update) 모두 취소됨

commit; -- 더이상 rollback 안됨

insert into test values (seq_test.nextval, '홍길동', 'B', 56.78, '1989-12-21');

rollback;

-- 수정, 강호등의 혈액형을 'AB'형으로 수정
update test set blood = 'AB' where name = '강호동';

-- 2개의 컬럼 수정
update test set weight = 80.8, birthday = sysdate where num = 9;

-- 삭제 
delete from test; -- 모든 데이터가 삭제되므로 where 조건문 꼭 쓰기
rollback;

-- num이 11, 12, 13인 행 삭제
delete from test where num in (11, 12, 13);

-- table 제거
drop table test; -- rollback 안됨

-- 시퀀스 제거
drop sequence seq_test;

create table person(
    num number(3) constraint person_pk_num primary key,
    blood char(2));
    
-- 기존 제약 조건 제거
alter table person drop constraint person_pk_num;

-- primary key에 대한 제약 조건 추가
alter table person add constraint person_num_pk primary key(num);

-- blood에 대해서 check 제약 조건 추가
alter table person add constraint person_ck_blood check (blood in ('A', 'B', 'O', 'AB'));

-- 데이터 추가
insert into person values (1, 'A');
insert into person values (1, 'B'); -- 오류 : 무결성 제약 조건(ANGEL.PERSON_NUM_PK)에 위배
insert into person values (2, 'b'); -- 오류 : 체크 제약조건(ANGEL.PERSON_CK_BLOOD)이 위배
insert into person values (2, 'O');

-- 컬럼을 추가(add)
alter table person add name varchar2(20);
alter table person add score number(5, 1) default 30.5;

-- 컬럼을 제거(drop column)
alter table person drop column num;

-- java라는 컬럼을 number 타입으로 추가 후 1 ~ 100 사이값만 들어오도록 제약 조건 추가
alter table person add java number(3) default 0;
alter table person add constraint person_ck_java check (java >= 0 and java <=100);

-- 컬럼명 변경(rename column)
alter table person rename column java to spring;

-- 데이터 추가 시 컬럼 순서대로 주기 싫을 경우 컴렁명 주면 됨
insert into person (name, blood, spring, score) values ('lee', 'O', '90', '35');

drop table person;