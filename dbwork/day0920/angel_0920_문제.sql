--문제
--테이블 생성 (student) : num 숫자(5),name 문자열(10),height 숫자(5,1),
--  java 숫자(3) 기본값 10,spring 숫자(3) 기본값 10, ban 문자열(20)
create table student(
    num number(5),
    name varchar2(10),
    height number(5, 1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar2(20));

--시퀀스 생성  seq_stu  기본(1부터 1씩증가), nocache 추가
create sequence seq_stu start with 1 increment by 1 nocache;

--제약조건들 추가
--num  에 primary key 추가(student_pk_nu)
alter table student add constraint student_pk_nu primary key(num);

--java,spring 은 1~100 만 가능하도록 check 제약조건 추가
alter table student add constraint student_ck_java check (java >=1 and java <= 100);
alter table student add constraint student_ck_spring check (spring >= 1 and spring <= 100);

--ban 은 '햇님반','달님반','별님반' 만 추가할수 있도록 check 추가
alter table student add constraint student_ck_ban check (ban in ('햇님반', '달님반', '별님반'));

--5개 정도만 데이타를 추가해보자
insert into student values (seq_stu.nextval, '홍길동', 170, 80, 85, '햇님반');
insert into student values (seq_stu.nextval, '강감찬', 180, 70, 85, '달님반');
insert into student values (seq_stu.nextval, '이순신', 185, 85, 21, '별님반');
insert into student values (seq_stu.nextval, '유관순', 165, 87, 46, '별님반');
insert into student values (seq_stu.nextval, '윤봉길', 168, 76, 82, '햇님반');

--커밋하기
commit;

--num>=4 이상 모두 삭제
delete from student where num >= 4;

-- num 이 3인 사람의 java점수를 99로 ,ban을 '달님반' 으로 수정
update student set java = 99, ban = '달님반' where num = 3;

--num=2 인사람의 키를 188.9 로 수정
update student set height = 188.9 where num = 2;

--num=2 인 데이타 삭제
delete from student where num = 2;

-- 데이터 3개 추가
insert into student values (seq_stu.nextval, '김구', 189, 75, 81, '달님반');
insert into student values (seq_stu.nextval, '이성계', 176, 89, 96, '별님반');
insert into student values (seq_stu.nextval, '광개토', 184, 95, 78, '햇님반');

--조회  이름  반 자바  스프링  총점  평균 -총점이 높은 사람부터 출력
select name as "이름", ban as "반", java as "자바", spring as "스프링", (java+spring) as "총점", (java+spring)/2 as "평균" from student order by "총점" desc;
