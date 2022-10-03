drop database if exists GYM_Project;
create database GYM_Project;
use GYM_Project;
drop table if exists gym_admin;
drop table if exists gym_regist;

CREATE TABLE gym_regist (
  regist_no int PRIMARY KEY AUTO_INCREMENT,
  regist_id varchar(20) UNIQUE,
  regist_pw varchar(20)
);

insert into gym_regist values(1, 'admin', 'admin');

CREATE TABLE membership (
  mem_no int AUTO_INCREMENT,
  mem_name varchar(10),
  mem_start date,
  mem_end date,
  mem_comment varchar(15),
  
  PRIMARY KEY (mem_no, mem_start, mem_end)
);

CREATE TABLE pt_member (
  pt_no int AUTO_INCREMENT,
  pt_name varchar(10),
  pt_phone varchar(15),
  pt_date date,
  
  PRIMARY KEY (pt_no, pt_date)
);

CREATE TABLE body (
  body_no int AUTO_INCREMENT,
  body_name varchar(10),
  body_date date,
  body_place varchar(10),
  body_comment varchar(15),
  
  PRIMARY KEY (body_no, body_date)
);

CREATE TABLE member_check (
  ck_no int PRIMARY KEY AUTO_INCREMENT,
  ck_name varchar(10),
  ck_date datetime
);

CREATE TABLE such (
  such_no int PRIMARY KEY AUTO_INCREMENT,
  mem_no int,
  mem_start date,
  mem_end date,
  pt_no int,
  pt_date date,
  body_no int,
  body_date date,
  
  foreign key (mem_no, mem_start, mem_end) references membership (mem_no, mem_start, mem_end),
  foreign key (pt_no, pt_date) references pt_member (pt_no, pt_date),
  foreign key (body_no, body_date) references body (body_no, body_date)
);
select * from such;

select * from gym_regist;
