drop database if exists GYM_Project;
create database GYM_Project;
use GYM_Project;
drop table if exists gym_admin;
drop table if exists gym_regist;

CREATE TABLE gym_regist (
  regist_no int PRIMARY KEY AUTO_INCREMENT,
  regist_name varchar(20),
  regist_id varchar(20) UNIQUE,
  regist_pw varchar(20)
);

insert into gym_regist values(1, 'admin', 'admin', 'admin');

CREATE TABLE membership (
  mem_no int PRIMARY KEY AUTO_INCREMENT,
  mem_name varchar(10),
  mem_start date,
  mem_end date,
  mem_comment varchar(15)
);

CREATE TABLE pt_member (
  pt_no int PRIMARY KEY AUTO_INCREMENT,
  pt_name varchar(10),
  pt_phone varchar(15),
  pt_date date
); 

CREATE TABLE body (
  body_no int PRIMARY KEY AUTO_INCREMENT,
  body_name varchar(10),
  body_date date,
  body_place varchar(10),
  body_comment varchar(15)
);

CREATE TABLE member_check (
  ck_no int PRIMARY KEY AUTO_INCREMENT,
  ck_name varchar(10),
  ck_date datetime
);

CREATE TABLE record_exercise (
  rd_no int PRIMARY KEY AUTO_INCREMENT,
  rd_name varchar(10),
  rd_date datetime ,
  rd_routine varchar(30),
  rd_weight varchar(10)
);


select * from gym_regist;