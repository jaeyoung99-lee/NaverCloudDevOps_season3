--����
--���̺� ���� (student) : num ����(5),name ���ڿ�(10),height ����(5,1),
--  java ����(3) �⺻�� 10,spring ����(3) �⺻�� 10, ban ���ڿ�(20)
create table student(
    num number(5),
    name varchar2(10),
    height number(5, 1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar2(20));

--������ ����  seq_stu  �⺻(1���� 1������), nocache �߰�
create sequence seq_stu start with 1 increment by 1 nocache;

--�������ǵ� �߰�
--num  �� primary key �߰�(student_pk_nu)
alter table student add constraint student_pk_nu primary key(num);

--java,spring �� 1~100 �� �����ϵ��� check �������� �߰�
alter table student add constraint student_ck_java check (java >=1 and java <= 100);
alter table student add constraint student_ck_spring check (spring >= 1 and spring <= 100);

--ban �� '�޴Թ�','�޴Թ�','���Թ�' �� �߰��Ҽ� �ֵ��� check �߰�
alter table student add constraint student_ck_ban check (ban in ('�޴Թ�', '�޴Թ�', '���Թ�'));

--5�� ������ ����Ÿ�� �߰��غ���
insert into student values (seq_stu.nextval, 'ȫ�浿', 170, 80, 85, '�޴Թ�');
insert into student values (seq_stu.nextval, '������', 180, 70, 85, '�޴Թ�');
insert into student values (seq_stu.nextval, '�̼���', 185, 85, 21, '���Թ�');
insert into student values (seq_stu.nextval, '������', 165, 87, 46, '���Թ�');
insert into student values (seq_stu.nextval, '������', 168, 76, 82, '�޴Թ�');

--Ŀ���ϱ�
commit;

--num>=4 �̻� ��� ����
delete from student where num >= 4;

-- num �� 3�� ����� java������ 99�� ,ban�� '�޴Թ�' ���� ����
update student set java = 99, ban = '�޴Թ�' where num = 3;

--num=2 �λ���� Ű�� 188.9 �� ����
update student set height = 188.9 where num = 2;

--num=2 �� ����Ÿ ����
delete from student where num = 2;

-- ������ 3�� �߰�
insert into student values (seq_stu.nextval, '�豸', 189, 75, 81, '�޴Թ�');
insert into student values (seq_stu.nextval, '�̼���', 176, 89, 96, '���Թ�');
insert into student values (seq_stu.nextval, '������', 184, 95, 78, '�޴Թ�');

--��ȸ  �̸�  �� �ڹ�  ������  ����  ��� -������ ���� ������� ���
select name as "�̸�", ban as "��", java as "�ڹ�", spring as "������", (java+spring) as "����", (java+spring)/2 as "���" from student order by "����" desc;
