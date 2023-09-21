-- ��ǰ ������ ���� shop ���̺�
-- ��ٱ��Ͽ� ���� cart ���̺��� ����µ� ��ǰ ���� ������ ���ؼ� shop�� num�� �ܺ�Ű�� ����
-- ��ǰ�� �����ϸ� ��ٱ����� �ش� �����Ͱ� �ڵ����� �����ǵ��� on delete cascade ����

-- ���ο� ������ ����
create sequence seq_shop start with 10 increment by 10 nocache;

-- shop table ����
create table shop(
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar(100),
    sang_price number(7),
    sang_color varchar2(20));
    
-- �ܺ�Ű�� ����� cart ���̺��� ���� -> show�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ���������� cascade �����ؼ� ����
create table cart(
    cart_no number(5) constraint cart_fk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date);
    
alter table cart add constraint cart_fk_sangno foreign key(sang_no) references shop(sang_no) on delete cascade;

-- model(ERD) Ȯ�� : cart ���̺��� model Ŭ���ؼ� Ȯ��

-- 5���� ��ǰ ���
insert into shop values(seq_shop.nextval, '���콺', '23000', 'yellow');
insert into shop values(seq_shop.nextval, 'û����', '49000', 'skyblue');
insert into shop values(seq_shop.nextval, '������', '59800', 'black');
insert into shop values(seq_shop.nextval, '��Ʈ����', '35600', 'red');
insert into shop values(seq_shop.nextval, '������', '49900', 'green');

commit;

-- cart�� ���콺, û����, ��Ʈ���� 3���� ���ؼ� �߰� - ��¥�� ���� ��¥(sysdate)
insert into cart values(seq_shop.nextval, 300, 3, sysdate);
insert into cart values(seq_shop.nextval, 310, 2, sysdate);
insert into cart values(seq_shop.nextval, 330, 5, sysdate);

commit;

-- ��ȸ(inner join)
-- ������ ��ǰ��, ����, ����, ����, ������(to_char �̿��ؼ� yyyy-mm-dd hh24:mi)
select sang_name, sang_price, sang_color, cnt, to_char(cartday,'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c 
where s.sang_no = c.sang_no;

-- �ƹ��� cart�� ���� ���� ��ǰ�� ��ȸ
-- ��ǰ��, ����, ���� ���
select sang_name, sang_price, sang_color
from shop s, cart c
where s.sang_no = c.sang_no(+) and c.cnt is null;

--cascade �� ���������Ƿ� cart �� ��� ��ǰ�� ������ �ȴ�(�̶� cart �� �ڵ����� ������)
delete from shop where sang_no = 10;

--�θ� ���̺� drop ���Ѻ���
drop table shop;  --��������

--���̺� ������ sub ���̺� ���� ������ �θ� ���̺� ����
drop table cart;
drop table shop;

--�������� ��������
drop SEQUENCE seq_shop;


---------------------------------------------------------------------------------------------------------------------


-- ����
-- ������ : seq_food ����
-- ��������� �޴� ���̺�(���̺�� : food)
-- food_num ����(5) �⺻Ű, fname ���ڿ�(20), : �޴���, fprice ����(7) : ����
create sequence seq_food start with 1 increment by 1 nocache;

create table food(
    food_num number(5) constraint food_pk_num primary key,
    fname varchar2(20),
    fprice number(7));

-- sub ���̺� : �� ���̺�(person)
-- person_num ����(5) �⺻Ű, food_num �ܺ�Ű ����(cascade ����)
-- person_name ���ڿ�(10) : ����
-- ������ : bookingday : date Ÿ��
create table person(
    person_num number(5) constraint person_pk_num primary key,
    food_num number(5),
    person_name varchar2(10),
    bookingday date);

alter table person add constraint person_fk_foodnum foreign key(food_num) references food(food_num) on delete cascade;

commit;

-- food�� 5���� �޴� ���(���İ�Ƽ, ������ ��)
insert into food values(seq_food.nextval, '���İ�Ƽ', 12000);
insert into food values(seq_food.nextval, '������', 8000);
insert into food values(seq_food.nextval, '�ʹ�', 24000);
insert into food values(seq_food.nextval, 'ġŲ', 18000);
insert into food values(seq_food.nextval, '��ä', 10000);

commit;

-- �ֹ��� �� ���� �߰�(���� �޴��� ���� �� �ֹ��ϱ⵵ ��)
insert into person values(seq_food.nextval, 1, '��ȣ��', '2023-09-21');
insert into person values(seq_food.nextval, 1, '���缮', '2023-10-21');
insert into person values(seq_food.nextval, 3, '��ȿ��', '2023-09-25');
insert into person values(seq_food.nextval, 4, '������', '2023-11-12');
insert into person values(seq_food.nextval, 2, 'ȫ�浿', '2023-12-29');
insert into person values(seq_food.nextval, 5, '������', '2024-01-30');
insert into person values(seq_food.nextval, 3, '�̼���', '2023-10-23');

commit;

-- �޴� �� ���İ�Ƽ�� ���� �� �ֹ��� ���̺����� ���������� Ȯ��
delete from food where fname = '���İ�Ƽ';

-- ��ȸ : ������, �ֹ��ڸ�, ���ĸ�, ����, ������(���� �ѱ۷� �ֱ�)
select food.food_num "�޴� ��ȣ", person_name "�ֹ��ڸ�", fname "���ĸ�", fprice "����", bookingday "������" from food, person where food.food_num = person.food_num;
