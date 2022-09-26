drop database if exists gym_project;
create database gym_project;
use gym_project;


CREATE TABLE `gym_admin` (
  `admin_no` int PRIMARY KEY AUTO_INCREMENT,
  `admin_id` varchar(20),
  `admin_pw` varchar(20)
);

CREATE TABLE `pt_member` (
  `pt_no` int PRIMARY KEY AUTO_INCREMENT,
  `pt_name` varchar(10),
  `pt_phone` varchar(15),
  `pt_date` date
);


CREATE TABLE `membership` (
  `mem_no` int PRIMARY KEY AUTO_INCREMENT,
  `mem_name` varchar(10),
  `mem_start` date,
  `mem_end` date,
  `mem_comment` varchar(15)
);

CREATE TABLE `body` (
  `body_no` int PRIMARY KEY AUTO_INCREMENT,
  `body_name` varchar(10),
  `body_place` varchar(10),
  `body_comment` varchar(15)
);

CREATE TABLE `check` (
  `ck_no` int PRIMARY KEY AUTO_INCREMENT,
  `ck_name` varchar(10),
  `ck_date` datetime
);