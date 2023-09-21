-- PL-SQL�̶�?
-- SQL �� ������ ����Ҹ� �߰��ؼ� ���α׷����� ��

--����1
declare
    -- ���� �����ϴ� ����
    v_no number(4, 1); -- 4�ڸ��� �Ҽ��� ���� 1�ڸ� ���� �ִ� ���� ����
begin
    -- sql�����̳� pl-sql������ �ڵ��ϴ� ����(:=:����, =:��, ����)
    v_no:=12.7;
    DBMS_Output.put_line(v_no); -- ���
end;
-- �Ʒ� �����ð� ���� ���α׷� ����
/

-- ����2
DECLARE
    vname varchar2(20);
    vban varchar2(20);
BEGIN
    select
        name, ban
        into vname, vban
        from student where num = 1;
	DBMS_Output.put_line(vname||'���� '||vban||'�Դϴ�');
end;
/

-- person�� food ���̺��� �����Ͽ� person_num�� 9�� ����� �̸�, �ֹ��� �޴�, ������ ���
DECLARE
    vname varchar2(20);
    vfood varchar2(20);
    vprice number(7);
BEGIN
    select
        person_name, fname, fprice
        into vname, vfood, vprice
        from person, food where food.food_num = person.food_num and person_num = 12;
	DBMS_Output.put_line('�ֹ���:'||vname);
    DBMS_Output.put_line('�޴���:'||vfood);
    DBMS_Output.put_line('����:'||vprice||'��');
end;
/

-- ����4
-- ��ǰ���� ������ ������ �� �ش� ��ǰ���� ���ݰ� ������ ���
DECLARE
    vsangpum varchar2(20) := '��Ʈ����';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
BEGIN
    select
        sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999'))
        into vprice, vcolor, vprice2
        from shop where sang_name = vsangpum;
	DBMS_Output.put_line('��ǰ��:'||vsangpum);
	DBMS_Output.put_line('��  ��:'||vcolor);
	DBMS_Output.put_line('��  ��:'||vprice);
	DBMS_Output.put_line('��  ��:'||vprice2);
end;
/

/*
if ���ǽ� then
    ����1;
else
    ����2;
end if;

���� if��
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    ...
end if;
*/

-- ����5
-- �⵵�� �´� �� ���ϱ�
-- Ű����� �⵵�� �Է¹ް��� �� ���
accept year prompt '�¾ �⵵�� �Է��ϼ���';
DECLARE
    -- v_year number(4) := 1989; -- ���� �ִ� ���
    v_year number(4) := '&year'; -- �Է��� ���� ����
    v_mod number(2) := mod(v_year, 12); -- �⵵�� 12�� ���� �������� ���Ѵ�
    v_ddi varchar2(10); -- �� ������ ����
BEGIN
    if v_mod = 0 then v_ddi := '������';
    elsif v_mod = 1 then v_ddi := '��';
    elsif v_mod = 2 then v_ddi := '��';
    elsif v_mod = 3 then v_ddi := '����';
    elsif v_mod = 4 then v_ddi := '��';
    elsif v_mod = 5 then v_ddi := '��';
    elsif v_mod = 6 then v_ddi := 'ȣ����';
    elsif v_mod = 7 then v_ddi := '�䳢';
    elsif v_mod = 8 then v_ddi := '��';
    elsif v_mod = 9 then v_ddi := '��';
    elsif v_mod = 10 then v_ddi := '��';
    elsif v_mod = 11 then v_ddi := '��';
    end if;
	DBMS_Output.put_line(v_year||'����� '||v_ddi||'���Դϴ�');
end;
/

-- ����6
-- db �÷��� Ÿ���� �������� ��� TYPE
accept inputname prompt 'name?';
DECLARE
    v_name student.name%type := '&inputname';
    v_height student.height%type;
    v_java student.java%type;
    v_spring student.spring%type;
BEGIN
    select
        height, java, spring
        into v_height, v_java, v_spring
        from student where name = v_name;
	DBMS_Output.put_line('�л���:'||v_name);
	DBMS_Output.put_line('Ű:'||v_height);
	DBMS_Output.put_line('�ڹ�����:'||v_java);
	DBMS_Output.put_line('����������:'||v_spring);
	DBMS_Output.put_line('����:'||(v_java + v_spring));
end;
/

/*
�ݺ��� : loop
loop    
    �����;
    exit when ����;
end loop;
*/

-- ����7
-- 1���� 10���� �ݺ��ؼ� ���
DECLARE
    v_no number(2) := 0;
BEGIN
    loop
        v_no := v_no + 1;
        DBMS_Output.put_line('no='||v_no);
        exit when v_no = 10; -- 10�� ��� �ݺ����� ����������
    end loop;
end;
/

-- ����8
-- ���� �Է��ϸ� �ش���� ����Ͻÿ�
accept dan prompt '�� ���� ����ұ��?';
DECLARE
    v_no number(2) := '&dan';
    v_num number(2) := 0;
BEGIN
    loop
        v_num := v_num + 1;
        DBMS_Output.put_line(v_no||' x '||v_num||' = '||(v_no * v_num));
        exit when v_num = 9; -- 9�� ��� �ݺ����� ����������
    end loop;
end;
/

-- ����9 : Exception ó��(����4 ����)
accept sangpum prompt 'sangpum?';
DECLARE
    vsangpum varchar2(20) := '&sangpum';
    vcolor varchar2(20);
    vprice number(7);
    vprice2 varchar2(20);
BEGIN
    select
        sang_price, sang_color, ltrim(to_char(sang_price, 'L999,999'))
        into vprice, vcolor, vprice2
        from shop where sang_name = vsangpum;
	DBMS_Output.put_line('��ǰ��:'||vsangpum);
	DBMS_Output.put_line('��  ��:'||vcolor);
	DBMS_Output.put_line('��  ��:'||vprice);
	DBMS_Output.put_line('��  ��:'||vprice2);
    
    -- ����� 2�� �̻��̰ų� ������ ���� �߻�
    -- ����Ŭ���� ����ó���ϴ� ���
    exception
        when NO_DATA_FOUND then
            DBMS_Output.put_line(vsangpum||' ��ǰ�� DB�� �����ϴ�');
        when TOO_MANY_ROWS then
            DBMS_Output.put_line(vsangpum||' ��ǰ�� DB�� 2�� �̻� �����մϴ�');
        when OTHERS then
            DBMS_Output.put_line(vsangpum||' ��ǰ�� ���� ���� �߻� - ���� ��');
end;
/

/*
Ƚ���� ������ �ִ� ����� �ݺ���
for ���� in [reverse]���۰�..������ loop
    �����;
end loop;
*/

-- ����10 : ����8 ������ ���� �� for������ �����ϱ�
accept dan prompt '�� ���� ����ұ��?';
DECLARE
    v_no number(2) := '&dan';
    v_num number(2);
BEGIN
    DBMS_Output.put_line('** '||v_no||' �� **');
    for v_num in 1..9 loop
        DBMS_Output.put_line(v_no||' x '||v_num||' = '||(v_no * v_num));
    end loop;
end;
/

-- ����11
-- ���ڵ� ������ ������ ��������
DECLARE
    v_num student.num%TYPE := 6;
    v_stu angel.student%rowtype; -- ���ڵ� ������ �о�� ���
BEGIN
    select * into v_stu
    from student where num = v_num;
	DBMS_Output.put_line('�̸�:'||v_stu.name);
	DBMS_Output.put_line('Ű:'||v_stu.height);
	DBMS_Output.put_line('�ڹ�:'||v_stu.java);
	DBMS_Output.put_line('������:'||v_stu.spring);
	DBMS_Output.put_line('��:'||v_stu.ban);
end;
/

-- db�� ���� �����͸� ��ȸ�� ���
/*
Cursor : �� SQL���� ������ ������ ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ����
           Ư���� �޸� ������ ����ϴµ� �� ������ �����ϴ� ���� Ŀ����
         �� select������ ���� ������ ��ȸ�� ����ϴ� ��ü

Ŀ�� �Ӽ�
sql%rowcount : ����� ���� ��ȯ(��� ������ ���� �� ������ �˷���)
sql%found : ���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �� ��� true
sql%notfound : ������� ���� ���
sql%isopen : �׻� false(�׻� close�� �ϱ� ������ �׻� false)
*/

-- ����12
DECLARE
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype;
BEGIN
    select * into v_shop
    from shop where sang_no = v_sno;
	DBMS_Output.put_line('��ǰ��:'||v_shop.sang_name);
	DBMS_Output.put_line('��ȸ�� ���హ��:'||sql%rowcount); -- 1
    
    -- student�� java ���� �����ϱ�
    update student set java = 99;
    DBMS_Output.put_line('������ ���హ��:'||sql%rowcount); -- 3
   
end;
/

-- ����13
-- ���� ���ڵ� ��ȸ
DECLARE
    Cursor s1
    is
    select * from shop;
BEGIN
	DBMS_Output.put_line('��ǰ��ȣ  ��ǰ��  ����  ����');
	DBMS_Output.put_line('--------------------------');
    for s in s1 loop
        exit when s1%notfound; -- ���̻� �����Ͱ� ������ ����������.
        DBMS_Output.put_line(s.sang_no||'  '||s.sang_name||'  '||s.sang_color||'  '||s.sang_price);
    end loop;    
end;
/

-- ����14
-- ��ǰ��, ����, ������ �Է��ϸ� shop db�� �߰��ϱ�
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
DECLARE
    v_sang shop.sang_name%type := '&isang';
    v_color shop.sang_color%type := '&icolor';
    v_price shop.sang_price%type := '&iprice';
BEGIN
    insert into shop values (seq_shop.nextval, v_sang, v_price, v_color);
    commit;
	DBMS_Output.put_line('��ǰ ������ �߰��߽��ϴ�');
end;
/

-- ���� : food ���̺�
/*
fname, fprice, no �Է� �޾Ƽ�
no�� 1�̸� fname, fprice�� ������ �߰� 14��
no�� 2�̸� food ��ü ������ ��� 13��
*/
accept ino prompt 'no?';
accept iname prompt 'name?';
accept iprice prompt 'price?';
DECLARE
    v_no food.food_num%type := '&ino';
    v_name food.fname%type := '&iname';
    v_price food.fprice%type := '&iprice';
    Cursor food_list is select * from food;
BEGIN
    if v_no = 1 then
        insert into food values (seq_food.nextval, v_name, v_price);
        commit;
        DBMS_Output.put_line('���� �߰� �Ϸ�');
    elsif v_no = 2 then
        DBMS_Output.put_line('���Ĺ�ȣ  ���ĸ�    ����');
        DBMS_Output.put_line('--------------------------');
        for n in food_list loop
            exit when food_list%notfound;
            DBMS_Output.put_line('  '||n.food_num||'     '||n.fname||'    '||n.fprice);
        end loop;
    end if;
end;
/