CREATE USER 'scott'@'localhost' IDENTIFIED BY 'tiger';
CREATE USER 'scott'@'%' IDENTIFIED BY 'tiger';
GRANT ALL PRIVILEGES ON *.* TO 'scott'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'scott'@'%';
FLUSH PRIVILEGES;

create database lecture;
use lecture;

create table if not exists board (
num int primary key auto_increment,
userId varchar(30) not null,
title varchar(70) not null,
wrdate datetime default current_timestamp,
content longtext not null,
viewCnt int default 0 
);

insert into board(userId, title, content) values('tester1','dummy data1','tesing...');
insert into board(userId, title, content) values('tester2','dummy data2','tesing...');
insert into board(userId, title, content) values('tester3','dummy data3','tesing...');
insert into board(userId, title, content) values('tester4','dummy data4','tesing...');
insert into board(userId, title, content) values('tester5','dummy data5','tesing...');