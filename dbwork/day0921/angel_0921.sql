-- 2023.09.21.목 DB 정규화

-- DB 정규화(Normalization)
-- 정규화란? 한마디로 DB 서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러 개의 테이블로 나누는 과정
-- 정규화된 데이터베이스는 중복이 최소화되도록 설계된 데이터베이스임
-- 장점 : 메모리 절약, 구조화된 시스템으로 인해 관리 편함
-- 단점 : 조회 비율이 매우 높은 시스템의 경우 테이블 간의 join 연산이 반복적으로 이루어지므로 질의 응답 속도가 느림

-- student의 num을 외부키로 갖는 새로운 테이블 stuinfo
-- 외부키는 테이블 생성 시에 설정해도 되고 나중에 설정해도 됨

create table stuinfo(
    idx number(5) constraint stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student의 num을 외부키로 설정(student의 num은 반드시 primary key여야 함)
-- ppt p.29 참고
alter table stuinfo add constraint stuinfo_fk_num foreign key(num) references student(num);

-- stuinfo에 데이터를 추가
-- 없는 번호인 9번으로 insert 시 어떤 오류가 나는지 확인 필요
-- 오류메시지 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
-- student 테이블이 부모 테이블인데 거기에 num이 9가 없어서 오류가 나는 것
insert into stuinfo values (seq_stu.nextval, 9, '서울시 강남구', '010-1234-4567');
-- 만약 이순신의 정보일 경우 이순신의 num이 3이므로 3으로 추가해야 함
insert into stuinfo values (seq_stu.nextval, 3, '서울시 강남구', '010-1234-4567'); -- 이순신
insert into stuinfo values (seq_stu.nextval, 6, '부산', '010-1256-6583'); -- 김구
insert into stuinfo values (seq_stu.nextval, 10, '제주도', '010-6745-3547'); -- 광개토

-- stuinfo만 조회
select * from stuinfo;

-- student만 조회
select * from student;

-- 개인 정보가 등록된 학생에 한해서 모든 정보 출력(inner join, equi join)
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num;

-- 컬럼명 앞에 무조건 어느테이블 소속인지 붙였는데 양쪽에 같은 컬럼이 없다면 생략 가능
select name, java, spring, ban, addr, hp from student stu, stuinfo info where stu.num = info.num;

-- 개인 정보가 등록되어있지 않은 학생들을 출력(outer join)
-- sub table dp (+) : 등록이 안된 컬럼은 null 값으로 출력
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num(+);

-- 위의 결과에 null인 학생만 출력
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num(+) and info.addr is null;

-- sub 테이블에 연결된 데이터가 있는데 부모 테이블(student)의 해당 데이터를 삭제하고자 할 경우
-- 오류 발생 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from student where num = 3; -- 오류 발생

delete from student where num = 7; -- 지워짐, stuinfo에 데이터가 없어서

-- student의 3번 데이터 삭제
-- 자식 테이블(stuinfo의 num이 3인 데이터를 먼저 삭제 후 student 삭제)
delete from stuinfo where num = 3; -- 자식 테이블 먼저 삭제
delete from student where num = 3; -- 부모 테이블 삭제

-- 부모 테이블 drop
-- 오류 발생
drop table student;

-- 자식 테이블 삭제(drop)
drop table stuinfo;