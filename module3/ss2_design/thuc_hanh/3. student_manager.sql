create database QuanLySinhVien;
use QuanLySinhVien;
create table class(
c_id int primary key auto_increment,
`name` varchar(60) not null,
`start_date` datetime not null,
`status` bit
);
create table student(
s_id int primary key auto_increment,
`name` varchar(30) not null,
`adress` varchar(50),
`phone` varchar(20),
`status` bit,
c_id int not null,
foreign key(c_id) references class(c_id)
);
create table subject(
su_id int primary key auto_increment,
`name` varchar(30) not null,
`credit` tinyint not null default 1,
check(`credit`>=1),
`status` bit default 1
);
create table mark(
m_id int primary key auto_increment,
s_id int not null,
su_id int not null,
unique(s_id,su_id),
`mark` float default 0,
check(mark between 0 and 100),
exam_times tinyint default 1,
foreign key (s_id) references student(s_id),
foreign key(su_id) references subject(su_id)

);