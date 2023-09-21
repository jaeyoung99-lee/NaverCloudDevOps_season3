-- 2023.09.21.�� DB ����ȭ

-- DB ����ȭ(Normalization)
-- ����ȭ��? �Ѹ���� DB ������ �޸𸮸� �������� �ʱ� ���ؼ� � ���̺��� �ĺ��ڸ� ������ ���� ���� ���̺�� ������ ����
-- ����ȭ�� �����ͺ��̽��� �ߺ��� �ּ�ȭ�ǵ��� ����� �����ͺ��̽���
-- ���� : �޸� ����, ����ȭ�� �ý������� ���� ���� ����
-- ���� : ��ȸ ������ �ſ� ���� �ý����� ��� ���̺� ���� join ������ �ݺ������� �̷�����Ƿ� ���� ���� �ӵ��� ����

-- student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo
-- �ܺ�Ű�� ���̺� ���� �ÿ� �����ص� �ǰ� ���߿� �����ص� ��

create table stuinfo(
    idx number(5) constraint stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student�� num�� �ܺ�Ű�� ����(student�� num�� �ݵ�� primary key���� ��)
-- ppt p.29 ����
alter table stuinfo add constraint stuinfo_fk_num foreign key(num) references student(num);

-- stuinfo�� �����͸� �߰�
-- ���� ��ȣ�� 9������ insert �� � ������ ������ Ȯ�� �ʿ�
-- �����޽��� : ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
-- student ���̺��� �θ� ���̺��ε� �ű⿡ num�� 9�� ��� ������ ���� ��
insert into stuinfo values (seq_stu.nextval, 9, '����� ������', '010-1234-4567');
-- ���� �̼����� ������ ��� �̼����� num�� 3�̹Ƿ� 3���� �߰��ؾ� ��
insert into stuinfo values (seq_stu.nextval, 3, '����� ������', '010-1234-4567'); -- �̼���
insert into stuinfo values (seq_stu.nextval, 6, '�λ�', '010-1256-6583'); -- �豸
insert into stuinfo values (seq_stu.nextval, 10, '���ֵ�', '010-6745-3547'); -- ������

-- stuinfo�� ��ȸ
select * from stuinfo;

-- student�� ��ȸ
select * from student;

-- ���� ������ ��ϵ� �л��� ���ؼ� ��� ���� ���(inner join, equi join)
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num;

-- �÷��� �տ� ������ ������̺� �Ҽ����� �ٿ��µ� ���ʿ� ���� �÷��� ���ٸ� ���� ����
select name, java, spring, ban, addr, hp from student stu, stuinfo info where stu.num = info.num;

-- ���� ������ ��ϵǾ����� ���� �л����� ���(outer join)
-- sub table dp (+) : ����� �ȵ� �÷��� null ������ ���
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num(+);

-- ���� ����� null�� �л��� ���
select stu.name, stu.java, stu.spring, stu.ban, info.addr, info.hp from student stu, stuinfo info where stu.num = info.num(+) and info.addr is null;

-- sub ���̺� ����� �����Ͱ� �ִµ� �θ� ���̺�(student)�� �ش� �����͸� �����ϰ��� �� ���
-- ���� �߻� : ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from student where num = 3; -- ���� �߻�

delete from student where num = 7; -- ������, stuinfo�� �����Ͱ� ���

-- student�� 3�� ������ ����
-- �ڽ� ���̺�(stuinfo�� num�� 3�� �����͸� ���� ���� �� student ����)
delete from stuinfo where num = 3; -- �ڽ� ���̺� ���� ����
delete from student where num = 3; -- �θ� ���̺� ����

-- �θ� ���̺� drop
-- ���� �߻�
drop table student;

-- �ڽ� ���̺� ����(drop)
drop table stuinfo;