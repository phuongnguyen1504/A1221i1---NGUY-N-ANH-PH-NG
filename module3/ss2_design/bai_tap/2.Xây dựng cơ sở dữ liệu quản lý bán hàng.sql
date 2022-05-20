CREATE DATABASE QuanLyBanHang;
USE QuanLyBanHang;
CREATE TABLE `Customer`(
c_ID int primary key,
c_Name varchar(50),
c_Age int
);
CREATE TABLE `Order`(
o_ID int primary key,
c_ID int,
FOREIGN KEY(c_ID) REFERENCES `Customer`(c_ID),
o_Date int,
o_TotalPrice double
);
CREATE TABLE `Product`(
p_ID int PRIMARY KEY,
p_Name varchar(50),
p_Price int
);
CREATE TABLE `OrderDetail`(
o_ID int,
p_ID int,
od_Qty int,
PRIMARY KEY(o_ID,p_ID),
FOREIGN KEY(o_ID) REFERENCES `Order`(o_ID),
FOREIGN KEY(p_ID) REFERENCES `Product`(p_ID) 
);
SELECT * FROM ORDERDETAIL;
SELECT * FROM Product;
SELECT * FROM `Order`;
SELECT * FROM Customer;
