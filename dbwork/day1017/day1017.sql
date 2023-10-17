create table simpleboard(
	num smallint auto_increment primary key,
    writer varchar(20),
    subject varchar(1000),
    content varchar(1000),
    photo varchar(30),
    readcount smallint default 0,
    writeday datetime
)