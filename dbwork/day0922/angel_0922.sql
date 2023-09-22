-- 2023.09.22.�� ���ν���

/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
����
 
create : ���� ����, ���� ���ν����� ���� ��� ���� �߻�
create or replace : ���� ����, ���� ���ν��� ������ ���

create [or replace] procedure ���ν�����
   [�Ķ���� ��� ����ŸŸ��,....]
is
       	���� ����
begin
            	�ڵ�;
end;
/
 
ȣ��:   exec ���ν�����;
            	exec ���ν�����(��..)

*/

-- ����1
-- �ʰ��� ���ν��� �����غ���
create or replace procedure mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('ù ���ν��� ����!');
end;
/

-- mytest ���ν��� ȣ��
exec mytest;


--------------------------------------------------------------------------------


-- ����2 : ���ڸ� ���ڷ� ������ ������ ���
create or replace procedure gugu(dan number)
is
begin
    if dan < 2 or dan > 9 then
        DBMS_OUTPUT.PUT_LINE('2 ~ 9 ���̷� ���� ��������!');
    else
        DBMS_OUTPUT.PUT_LINE('** '||dan|| '�� **');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||' x '||a||' = '||(dan * a));
        end loop;
    end if;
end;
/

-- ����
exec gugu(9);


--------------------------------------------------------------------------------


-- shop�� ������ �߰��ϱ� - ������
insert into shop values (seq_shop.nextval, '���̽����콺', 34000, 'white');

-- shop�� sang_color�� Ÿ�� ���� ����
alter table shop modify sang_color varchar2(30);
insert into shop values(seq_shop.nextval, 'üũ����', 34890, 'rainbow');
insert into shop values(seq_shop.nextval, '���̽�����', 24250, 'purple');
insert into shop values(seq_shop.nextval, '7��û����', 55730, 'magenta');
commit;


--------------------------------------------------------------------------------


-- ����3 : ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ�� ����ϱ�
create or replace procedure sangpum(sang varchar2)
is
    Cursor s1 is select * from shop where sang_name like '%'||sang||'%';
    
    -- �˻��� ��ǰ ������ ���� ����
    v_cnt number(2);

begin
    select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt = 0 then
        DBMS_OUTPUT.PUT_LINE(sang||' ��ǰ�� ��Ͽ� �����ϴ�.');
    else
        DBMS_OUTPUT.PUT_LINE(sang||' ��ǰ ��ȸ�ϱ�');
        DBMS_OUTPUT.PUT_LINE('�� '||v_cnt||'�� ��ȸ');
        DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ  ��ǰ��  ����  ����');
        DBMS_OUTPUT.PUT_LINE('-----------------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;
        end loop;
    end if;
end;
/

-- sangpum ���ν��� ȣ��
exec sangpum('����');
exec sangpum('û����');
exec sangpum('�Ѻ�');


--------------------------------------------------------------------------------


-- ����4
/*
exec addUpdate('���̽�����', '45000', 'black'); - �ش� ��ǰ�� ������ �߰�, ������ ����, ���� ����
*/

create or replace procedure addUpdate(sang_name varchar2, sang_price number, sang_color varchar2)
is
    v_name shop.sang_name%type := sang_name;
    v_price shop.sang_price%type := sang_price;
    v_color shop.sang_color%type := sang_color;
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name = v_name;
    if v_cnt = 0 then
        insert into shop values (seq_shop.nextval, v_name, v_price, v_color);
        DBMS_OUTPUT.PUT_LINE(sang_name||' ��ǰ�� �߰��Ǿ����ϴ�.');
    else
        update shop set sang_price = v_price where sang_name = v_name;
        update shop set sang_color = v_color where sang_name = v_name;
        DBMS_OUTPUT.PUT_LINE(sang_name||' ��ǰ�� ���ݰ� ������ ����Ǿ����ϴ�.');
    end if;
end;
/

exec addUpdate('���̽�����', '45000', 'black');
exec addUpdate('�ݹ���', '42190', 'lightgreen');