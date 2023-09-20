-- angel ���� ����

-- ��ü ������ ��ȸ
select * from seq;

-- sequence ����
create sequence seq1 start with 1 increment by 1; -- 1���� 1�� �����Ǵ� ������ ����
create sequence seq2 start with 5 increment by 3 nocache; -- 5���� 3�� ����, cache ���� 0
create sequence seq3 maxvalue 100 nocache; -- start with �� increment ���� �� 1�� �ʱⰪ ����

-- �� �߻���Ű��
select seq1.nextval, seq2.nextval, seq3.nextval from dual;

-- ������ ����
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

-- ���ο� ������ �ϳ� ����
create sequence seq_test nocache;

-- table ����
create table test(
    num number(3) primary key,
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5, 2),
    birthday date);
    
-- ������ �߰�
-- �Ϻ� �����͸� �ִ� ��� �÷����� �ݵ�� ǥ��
insert into test(num, name) values (seq_test.nextval, 'ĵ��');

-- ������� ��� �÷����� �ִ� ��� �÷��� ���� ����
insert into test values (seq_test.nextval, 'ĳ����', 'AB', 67.89, sysdate);

-- ���� ���ǿ� �ȸ´� ��� ���� Ȯ��
insert into test(num, blood) values (seq_test.nextval, 'O');
insert into test(num, name, blood) values (2, 'Lee', 'O');

-- ����� �� ������ 3�� �߰�
insert into test values (seq_test.nextval, '��ȣ��', 'B', 78.9, '2000-10-10');
insert into test values (seq_test.nextval, '���缮', 'A', 76.45, '1979-12-25');
insert into test values (seq_test.nextval, '�̿���', 'O', 77.77, '1969-09-09');

rollback; -- ������ commit�� ���� SQL��(DML��ɾ� : insert, delete, update) ��� ��ҵ�

commit; -- ���̻� rollback �ȵ�

insert into test values (seq_test.nextval, 'ȫ�浿', 'B', 56.78, '1989-12-21');

rollback;

-- ����, ��ȣ���� �������� 'AB'������ ����
update test set blood = 'AB' where name = '��ȣ��';

-- 2���� �÷� ����
update test set weight = 80.8, birthday = sysdate where num = 9;

-- ���� 
delete from test; -- ��� �����Ͱ� �����ǹǷ� where ���ǹ� �� ����
rollback;

-- num�� 11, 12, 13�� �� ����
delete from test where num in (11, 12, 13);

-- table ����
drop table test; -- rollback �ȵ�

-- ������ ����
drop sequence seq_test;

create table person(
    num number(3) constraint person_pk_num primary key,
    blood char(2));
    
-- ���� ���� ���� ����
alter table person drop constraint person_pk_num;

-- primary key�� ���� ���� ���� �߰�
alter table person add constraint person_num_pk primary key(num);

-- blood�� ���ؼ� check ���� ���� �߰�
alter table person add constraint person_ck_blood check (blood in ('A', 'B', 'O', 'AB'));

-- ������ �߰�
insert into person values (1, 'A');
insert into person values (1, 'B'); -- ���� : ���Ἲ ���� ����(ANGEL.PERSON_NUM_PK)�� ����
insert into person values (2, 'b'); -- ���� : üũ ��������(ANGEL.PERSON_CK_BLOOD)�� ����
insert into person values (2, 'O');

-- �÷��� �߰�(add)
alter table person add name varchar2(20);
alter table person add score number(5, 1) default 30.5;

-- �÷��� ����(drop column)
alter table person drop column num;

-- java��� �÷��� number Ÿ������ �߰� �� 1 ~ 100 ���̰��� �������� ���� ���� �߰�
alter table person add java number(3) default 0;
alter table person add constraint person_ck_java check (java >= 0 and java <=100);

-- �÷��� ����(rename column)
alter table person rename column java to spring;

-- ������ �߰� �� �÷� ������� �ֱ� ���� ��� �ķ��� �ָ� ��
insert into person (name, blood, spring, score) values ('lee', 'O', '90', '35');

drop table person;