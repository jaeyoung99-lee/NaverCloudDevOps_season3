-- scott ������ ���̺�� ��ȸ �����ϱ�
select * from emp; -- ��ü ���̺��� ������ ��ȸ
select * from emp order by ename asc; -- ename�� �������� ������������ ��ȸ(asc�� ���� ����)
select * from emp order by ename desc; -- ename�� �������� ������������ ��ȸ(desc�� ���� �ȵ�)
select empno, ename from emp; -- �Ϻ� �÷��� ��ȸ
select job from emp; -- job �÷��� ��ȸ
-- ���� ������ ��� �� ������ ���, �������� ���� ��ȸ
select DISTINCT job from emp order by 1; -- �÷��� 1�� �̹Ƿ� job ��� 1�̶�� �ᵵ �ȴ�
-- sal�� 3000�̻��� �͸� ��ȸ
select * from emp where sal >= 3000;
-- sal�� 2000�̻��̸鼭 deptno�� 20�� ��� ��ȸ(and)
select ename, sal, deptno from emp where sal >= 2000 and deptno = 20;

-- SMITH�� ������ ��ȸ
select * from emp where ename='SMITH';

-- A�� �����ϴ� ����鸸 ��ȸ
select * from emp where ename like 'A%'; -- A% : A�� �����ϴ� ��� ��, % : ��� ���� ���� ��� ����

-- �� ��° ���ڰ� A�� ����鸸 ��ȸ
select * from emp where ename like '_A%'; -- �����(_)�� ������ �� ���ڸ� �ǹ�

-- �� ��° ���ڰ� A�� ����鸸 ��ȸ
select * from emp where ename like '__A%'; -- �����(_) �� �� ���

-- S�� �����ϰų� J�� �Ӥ����ϴ� ��� ��� ��ȸ
select * from emp where ename like 'S%' or ename like 'J%';

-- sal�� 2000�̻��� ��� �߿� S�� �����ϴ� ��� ��ȸ
select * from emp where sal >= 2000 and ename like 'S%';