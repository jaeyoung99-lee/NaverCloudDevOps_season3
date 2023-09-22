# 테이블 조회
show tables; -- 전체 테이블 조회
select * from test01; -- test01 조회
desc test01; -- 테이블 구조 확인

-- insert
insert into test01 (name, age) values('kim', 40);
-- num에 null 값을 주면 null이 들어가는 게 아니라 auto 숫자가 발생된다
insert into test01 values (null, 'son', 26, 189.9, now(), '2023-01-01');

-- 테이블 구조 변경(add, drop column, modify, rename column)
alter table test01 add hp varchar(20) default '010-111-1111'; -- 컬럼 추가
alter table test01 drop column age; -- age 컬럼 제거
alter table test01 rename column birthday to birth; -- 컬럼명 수정

-- 테이블명 변경 - test01을 member로 변경
alter table test01 rename member;
select * from member; -- 바뀐 거 확인

-- sawon 테이블 생성 - 제약 조건들도 추가하기
create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자')));
        
desc sawon;

-- sawon의 제약 조건들 확인
select * from information_schema.table_constraints where table_name='sawon';

-- 데이터 추가
insert into sawon values (null, '이하나', 89, '여자', '홍보부');

-- 제약 조건 오류 확인
-- Error Code: 3819. Check constraint 'ck_sawon_score' is violated.
insert into sawon values (null, '이두나', 120, '여자', '홍보부');
-- Error Code: 3819. Check constraint 'ck_sawon_gender' is violated.
insert into sawon values (null, '이두나', 89, '여', '홍보부');

-- 제대로 된 데이터 7개 추가
insert into sawon values (null, '강호동', 90, '남자', '인사부');
insert into sawon values (null, '유재석', 45, '남자', '교육부');
insert into sawon values (null, '이효리', 23, '여자', '홍보부');
insert into sawon values (null, '강감찬', 95, '남자', '홍보부');
insert into sawon values (null, '유관순', 20, '여자', '인사부');
insert into sawon values (null, '홍길동', 26, '남자', '교육부');
insert into sawon values (null, '신사임', 26, '여자', '인사부');

-- select limit
select * from sawon order by name;
select * from sawon order by name limit 0, 3; -- 0(첫글)번부터 3개 조회
select * from sawon order by name limit 3, 4; -- 3(첫글)번부터 4개 조회

-- 문자함수들 연습
select concat('Hello', 'Kitty', '!!!') from dual;
-- sawon의 name에서 '이'를 포함한 데이터 조회
select * from sawon where name like concat('%', '이', '%');
select * from sawon where name like '%강%';
select replace('Happy Day!!', 'Happy', 'Nice') from dual; -- Happy를 Nice로 변경해서 출력
select instr('Happy Day', 'Day') from dual; -- 7 : Day의 위치 찾기(1부터 시작)
select instr('Happy Day', 'Hello') from dual; -- 0 : 없을 경우

-- 추출
select left('Have a Nice Day', 4) from dual; -- 왼쪽에서 4글자 추출 : Have
select right('Have a Nice Day', 8) from dual; -- 오른쪽에서 8글자 추출 : Nice Day
select mid('Have a Nice Day', 6, 6) from dual; -- 왼쪽에서 6번째부터 6글자 추출 : a Nice
select substring('Have a Nice Day', 6, 6) from dual; -- 왼쪽에서 6번째부터 6글자 추출 : a Nice

-- 공백 제거
select ltrim('     Hello        ') from dual; -- 왼쪽 공백 제거
select rtrim('     Hello        ') from dual; -- 오른쪽 공백 제거
select trim('     Hello        ') from dual; -- 양쪽 공백 제거

-- 대소문자 변환
select lcase('Happy') from dual; -- 소문자
select lower('Happy') from dual; -- 소문자
select ucase('Happy') from dual; -- 대문자
select upper('Happy') from dual; -- 대문자

-- 거꾸로
select reverse('Happy') from dual; -- 거꾸로

-- 조건 함수
select if(1 = 2, 'happy', 'nice') from dual;
select name, score, if(score >= 90, '합격', '불합격') "평가" from sawon;

-- 오라클의 NVL이 MySQL에서는 ifnull
select name, height from member;
select name, ifnull(height, 0) from member;

-- 수학 함수
select ceiling(5.3), ceiling(5.9) from dual; -- 무조건 올림
select floor(5.3), floor(5.9) from dual; -- 무조건 내림
select truncate(2.345, 2) from dual; -- 소수점 2자리까지 출력하고 무조건 내림
select mod(7, 2) from dual; -- 나머지

-- Group by
select buseo 부서, count(*) 인원수, max(score) 최고점수, min(score) 최저점수, avg(score) 평균점수 from sawon group by buseo;

-- join 연습
CREATE TABLE bitclass (
    idx SMALLINT PRIMARY KEY,
    class VARCHAR(30),
    price INT,
    gigan SMALLINT
);
   
CREATE TABLE stu (
    num SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    idx SMALLINT,
    sugangday DATE,
    CONSTRAINT stu_fk_idx FOREIGN KEY (idx)
        REFERENCES bitclass (idx)
);
   
-- bitclass 에 데이터 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

-- stu 에 데이터 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

-- inner join 1
select class, price, gigan, name, sugangday from bitclass b, stu s where b.idx = s.idx;

-- inner join 2
select name, class, gigan, price, sugangday from bitclass b inner join stu s on b.idx = s.idx;

select * from bitclass b inner join stu s on b.idx = s.idx;

-- sub table에 데이터가 추가된 상태에서 부모 테이블의 데이터 삭제
delete from bitclass where idx = 100; -- 오류 발생

-- sub table의 데이터를 먼저 삭제 후 부모 테이블의 데이터 삭제
delete from stu where idx = 100;
delete from bitclass where idx = 100;

-- 연습용 join 테이블 모두 제거하기
drop table stu;
drop table bitclass;

drop table member;