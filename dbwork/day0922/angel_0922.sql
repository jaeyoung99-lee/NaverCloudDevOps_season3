-- 2023.09.22.금 프로시저

/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
형식
 
create : 새로 생성, 기존 프로시저가 있을 경우 오류 발생
create or replace : 새로 생성, 기존 프로시저 있으면 덮어씀

create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명;
            	exec 프로시져명(값..)

*/

-- 예제1
-- 초간단 프로시저 생성해보기
create or replace procedure mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('첫 프로시저 생성!');
end;
/

-- mytest 프로시저 호출
exec mytest;


--------------------------------------------------------------------------------


-- 예제2 : 숫자를 인자로 보내면 구구단 출력
create or replace procedure gugu(dan number)
is
begin
    if dan < 2 or dan > 9 then
        DBMS_OUTPUT.PUT_LINE('2 ~ 9 사이로 값을 넣으세요!');
    else
        DBMS_OUTPUT.PUT_LINE('** '||dan|| '단 **');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||' x '||a||' = '||(dan * a));
        end loop;
    end if;
end;
/

-- 실행
exec gugu(9);


--------------------------------------------------------------------------------


-- shop에 데이터 추가하기 - 연습용
insert into shop values (seq_shop.nextval, '레이스블라우스', 34000, 'white');

-- shop의 sang_color의 타입 길이 변경
alter table shop modify sang_color varchar2(30);
insert into shop values(seq_shop.nextval, '체크조끼', 34890, 'rainbow');
insert into shop values(seq_shop.nextval, '레이스조끼', 24250, 'purple');
insert into shop values(seq_shop.nextval, '7부청바지', 55730, 'magenta');
commit;


--------------------------------------------------------------------------------


-- 예제3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기
create or replace procedure sangpum(sang varchar2)
is
    Cursor s1 is select * from shop where sang_name like '%'||sang||'%';
    
    -- 검색된 상품 개수를 구할 변수
    v_cnt number(2);

begin
    select count(*) into v_cnt from shop where sang_name like '%'||sang||'%';
    if v_cnt = 0 then
        DBMS_OUTPUT.PUT_LINE(sang||' 상품은 목록에 없습니다.');
    else
        DBMS_OUTPUT.PUT_LINE(sang||' 상품 조회하기');
        DBMS_OUTPUT.PUT_LINE('총 '||v_cnt||'개 조회');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명  가격  색상');
        DBMS_OUTPUT.PUT_LINE('-----------------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;
        end loop;
    end if;
end;
/

-- sangpum 프로시저 호출
exec sangpum('조끼');
exec sangpum('청바지');
exec sangpum('한복');


--------------------------------------------------------------------------------


-- 예제4
/*
exec addUpdate('레이스조끼', '45000', 'black'); - 해당 상품이 없으면 추가, 있으면 가격, 색상 수정
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
        DBMS_OUTPUT.PUT_LINE(sang_name||' 상품이 추가되었습니다.');
    else
        update shop set sang_price = v_price where sang_name = v_name;
        update shop set sang_color = v_color where sang_name = v_name;
        DBMS_OUTPUT.PUT_LINE(sang_name||' 상품의 가격과 색상이 변경되었습니다.');
    end if;
end;
/

exec addUpdate('레이스조끼', '45000', 'black');
exec addUpdate('반바지', '42190', 'lightgreen');