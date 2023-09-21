-- 상품 정보를 담을 shop 테이블
-- 장바구니에 담을 cart 테이블을 만드는데 상품 정보 저장을 위해서 shop의 num을 외부키로 설정
-- 상품을 삭제하면 장바구니의 해당 데이터가 자동으로 삭제되도록 on delete cascade 설정

-- 새로운 시퀀스 생성
create sequence seq_shop start with 10 increment by 10 nocache;

-- shop table 생성
create table shop(
    sang_no number(5) constraint shop_pk_no primary key,
    sang_name varchar(100),
    sang_price number(7),
    sang_color varchar2(20));
    
-- 외부키로 연결된 cart 테이블을 생성 -> show의 상품을 지우면 장바구니 목록은 자동으로 지워지도록 cascade 설정해서 생성
create table cart(
    cart_no number(5) constraint cart_fk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date);
    
alter table cart add constraint cart_fk_sangno foreign key(sang_no) references shop(sang_no) on delete cascade;

-- model(ERD) 확인 : cart 테이블의 model 클릭해서 확인

-- 5개의 상품 등록
insert into shop values(seq_shop.nextval, '블라우스', '23000', 'yellow');
insert into shop values(seq_shop.nextval, '청바지', '49000', 'skyblue');
insert into shop values(seq_shop.nextval, '슬랙스', '59800', 'black');
insert into shop values(seq_shop.nextval, '니트조끼', '35600', 'red');
insert into shop values(seq_shop.nextval, '블레이저', '49900', 'green');

commit;

-- cart에 블라우스, 청바지, 니트조끼 3개에 대해서 추가 - 날짜는 현재 날짜(sysdate)
insert into cart values(seq_shop.nextval, 300, 3, sysdate);
insert into cart values(seq_shop.nextval, 310, 2, sysdate);
insert into cart values(seq_shop.nextval, 330, 5, sysdate);

commit;

-- 조회(inner join)
-- 순서는 상품명, 가격, 색상, 개수, 구입일(to_char 이용해서 yyyy-mm-dd hh24:mi)
select sang_name, sang_price, sang_color, cnt, to_char(cartday,'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c 
where s.sang_no = c.sang_no;

-- 아무도 cart에 담지 않은 상품명 조회
-- 상품명, 가격, 색상 출력
select sang_name, sang_price, sang_color
from shop s, cart c
where s.sang_no = c.sang_no(+) and c.cnt is null;

--cascade 를 지정했으므로 cart 에 담긴 상품도 삭제가 된다(이때 cart 도 자동으로 지워짐)
delete from shop where sang_no = 10;

--부모 테이블 drop 시켜보자
drop table shop;  --에러난다

--테이블 삭제시 sub 테이블 먼저 제거후 부모 테이블 제거
drop table cart;
drop table shop;

--시퀀스도 지워보자
drop SEQUENCE seq_shop;


---------------------------------------------------------------------------------------------------------------------


-- 문제
-- 시퀀스 : seq_food 생성
-- 레스토랑의 메뉴 테이블(테이블명 : food)
-- food_num 숫자(5) 기본키, fname 문자열(20), : 메뉴명, fprice 숫자(7) : 가격
create sequence seq_food start with 1 increment by 1 nocache;

create table food(
    food_num number(5) constraint food_pk_num primary key,
    fname varchar2(20),
    fprice number(7));

-- sub 테이블 : 고객 테이블(person)
-- person_num 숫자(5) 기본키, food_num 외부키 설정(cascade 설정)
-- person_name 문자열(10) : 고객명
-- 예약일 : bookingday : date 타입
create table person(
    person_num number(5) constraint person_pk_num primary key,
    food_num number(5),
    person_name varchar2(10),
    bookingday date);

alter table person add constraint person_fk_foodnum foreign key(food_num) references food(food_num) on delete cascade;

commit;

-- food에 5개의 메뉴 등록(스파게티, 떡볶이 등)
insert into food values(seq_food.nextval, '스파게티', 12000);
insert into food values(seq_food.nextval, '떡볶이', 8000);
insert into food values(seq_food.nextval, '초밥', 24000);
insert into food values(seq_food.nextval, '치킨', 18000);
insert into food values(seq_food.nextval, '잡채', 10000);

commit;

-- 주문한 고객 정보 추가(같은 메뉴를 여러 명 주문하기도 함)
insert into person values(seq_food.nextval, 1, '강호동', '2023-09-21');
insert into person values(seq_food.nextval, 1, '유재석', '2023-10-21');
insert into person values(seq_food.nextval, 3, '이효리', '2023-09-25');
insert into person values(seq_food.nextval, 4, '강감찬', '2023-11-12');
insert into person values(seq_food.nextval, 2, '홍길동', '2023-12-29');
insert into person values(seq_food.nextval, 5, '유관순', '2024-01-30');
insert into person values(seq_food.nextval, 3, '이순신', '2023-10-23');

commit;

-- 메뉴 중 스파게티를 삭제 시 주문한 테이블에서도 지워지는지 확인
delete from food where fname = '스파게티';

-- 조회 : 시퀀스, 주문자명, 음식명, 가격, 예약일(제목도 한글로 주기)
select food.food_num "메뉴 번호", person_name "주문자명", fname "음식명", fprice "가격", bookingday "예약일" from food, person where food.food_num = person.food_num;
