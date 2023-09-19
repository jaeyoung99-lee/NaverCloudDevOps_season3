-- scott 연습용 테이블로 조회 연습하기
select * from emp; -- 전체 테이블의 데이터 조회
select * from emp order by ename asc; -- ename을 기준으로 오름차순으로 조회(asc는 생략 가능)
select * from emp order by ename desc; -- ename을 기준으로 내림차순으로 조회(desc는 생략 안됨)
select empno, ename from emp; -- 일부 컬럼만 조회
select job from emp; -- job 컬럼만 조회
-- 같은 직업일 경우 한 번씩만 출력, 오름차순 정렬 조회
select DISTINCT job from emp order by 1; -- 컬럼이 1개 이므로 job 대신 1이라고 써도 된다
-- sal이 3000이상인 것만 조회
select * from emp where sal >= 3000;
-- sal이 2000이상이면서 deptno가 20인 사람 조회(and)
select ename, sal, deptno from emp where sal >= 2000 and deptno = 20;

-- SMITH의 데이터 조회
select * from emp where ename='SMITH';

-- A로 시작하는 사람들만 조회
select * from emp where ename like 'A%'; -- A% : A로 시작하는 모든 것, % : 모든 글자 길이 상관 없음

-- 두 번째 글자가 A인 사람들만 조회
select * from emp where ename like '_A%'; -- 언더바(_)는 임의의 한 글자를 의미

-- 세 번째 글자가 A인 사람들만 조회
select * from emp where ename like '__A%'; -- 언더바(_) 두 개 사용

-- S로 시작하거나 J로 ㅣㅅ작하는 모든 사람 조회
select * from emp where ename like 'S%' or ename like 'J%';

-- sal이 2000이상인 사람 중에 S로 시작하는 사람 조회
select * from emp where sal >= 2000 and ename like 'S%';