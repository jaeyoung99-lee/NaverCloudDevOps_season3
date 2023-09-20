-- 2023.09.20.��

-- sal�� 1000 ~ 2000 ���� ���

-- ���1
select ename, sal, comm from emp where sal >= 1000 and sal <= 2000;

-- ���2
select ename, sal, comm from emp where sal between 1000 and 2000;

-- sal�� 1000 ~ 2000�� �����ϰ� ���

-- ���1
select ename, sal, comn from emp where sal not between 1000 and 2000;

-- ���2
select ename, sal, comn from emp where sal < 1000 or sal > 2000;

-- comm�� null�� ������ ��ȸ
select * from emp where comm is null;

-- comm�� null�� �ƴ� ������ ��ȸ
select * from emp where comm is not null;

-- comm�� null�� ��� 0���� ���, ������ �÷��� sal + comm�� ���
select ename, sal, comm, sal+comm from emp; -- ���� + null = null

-- NVL(�÷���, ��) : �ش� �÷����� null�̸� 0���� ���(mysql������ isnull(�÷���, ��))
select ename, sal, NVL(comm, 0), sal+NVL(comm, 0) from emp; -- �÷����� �ָ�

-- �ڹٷ� ������ ��� �÷� �ε����� �÷������� ������ -> �÷����� ������ ��� ��Ī ����
select ename as "�����", sal as "����" from emp; -- "��Ī", ������ ���� ��� "" ���� ����
select ename as �����, sal as ���� from emp;
select empno "��� ��ȣ", sal ���� from emp; -- ��Ī�� ���� �ִ� ��� �ݵ�� "" ���, as ���� ����

select ename as "�����", sal as "����", NVL(comm, 0) as "������", sal+NVL(comm, 0) as "�� ����" from emp;

-- �� �� ���� ���
select count(*) from emp;
select count(*) as "count" from emp; -- ��Ī ���

-- ���ڿ��� �̾ ��� ||, �÷����� member�� ���
select ename||'���� ������ '||job||'�Դϴ�' member from emp;

-- xx���� �� ������ xxx�Դϴ�. (sal+comm, null�� ��� 100���� ���, ������ ȸ�� ����
select ename||'���� �� ������ '||(sal+NVL(comm, 100))||'�Դϴ�' as "ȸ�� ����" from emp;

-- empno ���� �� ��ȸ
select empno, ename from emp where empno = 7369 or empno = 7788 or empno = 7900;

-- ���� �� ��ȸ �� in ���
select empno, ename from emp where empno in (7369, 7788, 7900);

-- ���� 3���� empno�� ���� ���
select empno, ename from emp where empno not in (7369, 7788, 7900);

-- ename, job��  ��� (job�� salesman�̰ų� analyst, manager 3���� ������)
select ename, job from emp where job in ('SALESMAN', 'ANALYST', 'MANAGER');

-- ��¥�� ����
select * from emp where hiredate = '80/12/17';
select * from emp where hiredate = '1980-12-17';
select * from emp where hiredate >= '1980-01-01' and hiredate <= '1981-10-10';

-- ���� ��¥ ��ȸ
select sysdate from dual; -- dual�� �̿��ϸ� ���� �ֿܼ� ��� ����

-- ���� ��¥
select sysdate+1 from dual;

-- to_char ��ȯ �Լ��� �̿��ؼ� ��ȸ
select to_char(sysdate, 'yyyy-mm-dd') from dual;
select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual; -- mi : ��, mm : ��
select to_char(sysdate, 'yyyy-mm-dd am hh:mi') from dual; -- ����, ���� ǥ�� am �Ǵ� pm ���� �ڵ����� ���

-- emp���� ename, hiredate(yyyy-mm-dd)�� ����ϴµ� 1981�⿡ �Ի��� ����� ���
-- ������ �����, �Ի���
select ename as "�����", to_char(hiredate, 'yyyy-mm-dd') as "�Ի���" from emp where to_char(hiredate, 'yyyy') = 1981;

-- �׷� �Լ� : count, max, min, avg, sum
select count(*) from emp; -- ��ü ������ ����
select avg(sal) from emp; -- sal�� ���
select round(avg(sal), 1) from emp; -- 2073.2, ���� ����� ���� �� round �Լ��� ���� ���
select round(avg(sal), 0) from emp; -- 2073
select round(avg(sal), -1) from emp; -- 2070
select round(avg(sal), -2) from emp; -- 2100

select sum(sal) from emp; -- sal�� �� �հ� 29025
select min(sal) from emp; -- ���� ���� �޿�
select max(sal) from emp; -- ���� ū �޿�

-- �������� �̿�
-- ���� ���� �޿��� �޴� ����� �̸��� ���
select ename, sal from emp where sal = (select min(sal) from emp);
-- ���� ū �޿��� �޴� ����� �̸��� ���
select ename, sal from emp where sal = (select max(sal) from emp);
-- SCOTT�� ������ ���� ������ ���� ����� ��ȸ(ename, job, sal)
select ename, job, sal from emp where job = (select job from emp where ename = 'SCOTT');
-- allen���� �� ���� ������ �޴� ����� �ο� ����?
select count(*) from emp where sal > (select sal from emp where ename = 'ALLEN');

-- GROUP BY
-- JOB �������� �ο��� ���ϱ�
select job as "����", count(*) as "�ο���" from emp group by job;
-- ���� ����� ������ ������������ ���
select job as "����", count(*) as "�ο���" from emp group by job order by ���� asc;
select job as "����", count(*) as "�ο���" from emp group by job order by 1;
-- �ο����� ������������ ���
select job as "����", count(*) as "�ο���" from emp group by job order by �ο��� asc;
select job as "����", count(*) as "�ο���" from emp group by job order by 2;

-- �������� �ο���, ��� ����, ���� ����, �ְ� ���� ���
select job as "����", count(*) as "�ο���", round(avg(sal), 0) as "��� ����", max(sal) as "�ְ� ����", min(sal) as "���� ����" from emp group by job;

-- �׷쿡 ���� ������ �� ��� HAVING
-- ���� SQL���� �ο����� 3�� �̻��� �׷츸 ���
select job as "����", count(*) as "�ο���", round(avg(sal), 0) as "��� ����", max(sal) as "�ְ� ����", min(sal) as "���� ����" from emp group by job having count(*) >= 3;

-- ����Ŭ �Լ���
-- ���� �Լ�
select abs(-5), abs(5) from dual; -- abs : ���밪���� ���(�����)
select ceil(2.2), ceil(2.9) from dual; -- ceil(����) : ������ �ø�
select floor(2.2), floor(2.9) from dual; -- floor(����) : ������ ����
select mod(7, 2) from dual; -- mod : ������
select power(2, 3) from dual; -- power : ������

-- ��ȯ�Լ�
select '7' + 7 from dual;
select to_number('7') + 7 from dual;
select to_char(sysdate, 'yyyy-m-dd') from dual;