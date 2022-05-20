create database student_manager;

use student_manager;

create table student(
	id int primary key not null,
    `name` varchar(45),
    age int,
    country varchar(45) 
);