-- 2023.09.20.수

-- sal이 1000 ~ 2000 사이 출력

-- 방법1
select ename, sal, comm from emp where sal >= 1000 and sal <= 2000;

-- 방법2
select ename, sal, comm from emp where sal between 1000 and 2000;

-- sal이 1000 ~ 2000을 제외하고 출력

-- 방법1
select ename, sal, comn from emp where sal not between 1000 and 2000;

-- 방법2
select ename, sal, comn from emp where sal < 1000 or sal > 2000;

-- comm이 null인 데이터 조회
select * from emp where comm is null;

-- comm이 null이 아닌 데이터 조회
select * from emp where comm is not null;

-- comm이 null인 경우 0으로 출력, 마지막 컬럼에 sal + comm을 출력
select ename, sal, comm, sal+comm from emp; -- 숫자 + null = null

-- NVL(컬럼명, 값) : 해당 컬럼값이 null이면 0으로 출력(mysql에서는 isnull(컬럼명, 값))
select ename, sal, NVL(comm, 0), sal+NVL(comm, 0) from emp; -- 컬럼명을 주목

-- 자바로 가져갈 경우 컬럼 인덱스나 컬럼명으로 가져감 -> 컬럼명이 복잡한 경우 별칭 지정
select ename as "사원명", sal as "연봉" from emp; -- "별칭", 공백이 없을 경우 "" 생략 가능
select ename as 사원명, sal as 연봉 from emp;
select empno "사원 번호", sal 연봉 from emp; -- 별칭에 공백 있는 경우 반드시 "" 사용, as 생략 가능

select ename as "사원명", sal as "연봉", NVL(comm, 0) as "수수료", sal+NVL(comm, 0) as "총 연봉" from emp;

-- 총 글 개수 출력
select count(*) from emp;
select count(*) as "count" from emp; -- 별칭 사용

-- 문자열을 이어서 출력 ||, 컬럼명은 member로 출력
select ename||'님의 직업은 '||job||'입니다' member from emp;

-- xx님의 총 연봉은 xxx입니다. (sal+comm, null일 경우 100으로 계산, 제목은 회원 연봉
select ename||'님의 총 연봉은 '||(sal+NVL(comm, 100))||'입니다' as "회원 연봉" from emp;

-- empno 여러 개 조회
select empno, ename from emp where empno = 7369 or empno = 7788 or empno = 7900;

-- 여러 개 조회 시 in 사용
select empno, ename from emp where empno in (7369, 7788, 7900);

-- 위의 3개의 empno을 빼고 출력
select empno, ename from emp where empno not in (7369, 7788, 7900);

-- ename, job을  출력 (job이 salesman이거나 analyst, manager 3개의 직업만)
select ename, job from emp where job in ('SALESMAN', 'ANALYST', 'MANAGER');

-- 날짜로 조건
select * from emp where hiredate = '80/12/17';
select * from emp where hiredate = '1980-12-17';
select * from emp where hiredate >= '1980-01-01' and hiredate <= '1981-10-10';

-- 현재 날짜 조회
select sysdate from dual; -- dual을 이용하면 현재 콘솔에 출력 가능

-- 내일 날짜
select sysdate+1 from dual;

-- to_char 변환 함수를 이용해서 조회
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual; -- mi : 분, mm : 월
select to_char(sysdate, 'yyyy-mm-dd am hh:mi') from dual; -- 오전, 오후 표시 am 또는 pm 쓰면 자동으로 출력

-- emp에서 ename, hiredate(yyyy-mm-dd)를 출력하는데 1981년에 입사한 사람만 출력
-- 제목은 사원명, 입사일
select ename as "사원명", to_char(hiredate, 'yyyy-mm-dd') as "입사일" from emp where to_char(hiredate, 'yyyy') = 1981;

-- 그룹 함수 : count, max, min, avg, sum
select count(*) from emp; -- 전체 데이터 개수
select avg(sal) from emp; -- sal의 평균
select round(avg(sal), 1) from emp; -- 2073.2, 보통 평균을 구할 땐 round 함수와 같이 사용
select round(avg(sal), 0) from emp; -- 2073
select round(avg(sal), -1) from emp; -- 2070
select round(avg(sal), -2) from emp; -- 2100

select sum(sal) from emp; -- sal의 총 합계 29025
select min(sal) from emp; -- 제일 작은 급여
select max(sal) from emp; -- 제일 큰 급여

-- 서브쿼리 이용
-- 제일 작은 급여를 받는 사람의 이름을 출력
select ename, sal from emp where sal = (select min(sal) from emp);
-- 제일 큰 급여를 받는 사람의 이름을 출력
select ename, sal from emp where sal = (select max(sal) from emp);
-- SCOTT의 직업과 같은 직업을 가진 사람들 조회(ename, job, sal)
select ename, job, sal from emp where job = (select job from emp where ename = 'SCOTT');
-- allen보다 더 높은 연봉을 받는 사람의 인원 수는?
select count(*) from emp where sal > (select sal from emp where ename = 'ALLEN');

-- GROUP BY
-- JOB 직업별로 인원수 구하기
select job as "직업", count(*) as "인원수" from emp group by job;
-- 위의 결과를 직업의 오름차순으로 출력
select job as "직업", count(*) as "인원수" from emp group by job order by 직업 asc;
select job as "직업", count(*) as "인원수" from emp group by job order by 1;
-- 인원수의 오름차순으로 출력
select job as "직업", count(*) as "인원수" from emp group by job order by 인원수 asc;
select job as "직업", count(*) as "인원수" from emp group by job order by 2;

-- 직업별로 인원수, 평균 연봉, 최저 연봉, 최고 연봉 출력
select job as "직업", count(*) as "인원수", round(avg(sal), 0) as "평균 연봉", max(sal) as "최고 연봉", min(sal) as "최저 연봉" from emp group by job;

-- 그룹에 대한 조건을 줄 경우 HAVING
-- 위의 SQL문에 인원수가 3명 이상인 그룹만 출력
select job as "직업", count(*) as "인원수", round(avg(sal), 0) as "평균 연봉", max(sal) as "최고 연봉", min(sal) as "최저 연봉" from emp group by job having count(*) >= 3;

-- 오라클 함수들
-- 숫자 함수
select abs(-5), abs(5) from dual; -- abs : 절대값으로 출력(양수값)
select ceil(2.2), ceil(2.9) from dual; -- ceil(숫자) : 무조건 올림
select floor(2.2), floor(2.9) from dual; -- floor(숫자) : 무조건 내림
select mod(7, 2) from dual; -- mod : 나머지
select power(2, 3) from dual; -- power : 지수승

-- 변환함수
select '7' + 7 from dual;
select to_number('7') + 7 from dual;
select to_char(sysdate, 'yyyy-m-dd') from dual;