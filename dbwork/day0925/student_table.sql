create table student(
num smallint auto_increment,
name varchar(20), 
blood char(2),
phone varchar(20),
writeday datetime,
constraint stu_pk_num primary key(num),
constraint stu_ck_blood check (blood in('A', 'B', 'O', 'AB'))
);