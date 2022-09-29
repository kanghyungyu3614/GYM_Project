drop database if exists GYM_Project;
create database GYM_Project;
use GYM_Project;
drop table if exists gym_admin;
create table gym_admin(
	admin_no int auto_increment primary key,
	admin_id varchar(20),
    admin_pw varchar(20)
);
select * from gym_admin;