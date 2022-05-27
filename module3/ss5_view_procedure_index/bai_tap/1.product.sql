-- 1.Tạo cơ sở dữ liệu 
create database ss5;
use ss5;
-- 2.Tạo bảng Product với các trường dữ liệu sau
create table `product`(
id int primary key auto_increment,
`code` varchar(45),
`name` varchar(45),
`price` double,
`amount` int,
`description` varchar(100),
`status` int 
);
insert into `product` (`code`,`name`,`price`,`amount`,`description`,`status`) values 
('A1','name1',10000,1,'des1',0),
('A2','name2',20000,2,'des2',0),
('A3','name3',30000,3,'des3',0),
('A4','name4',40000,4,'des4',0),
('A5','name5',50000,5,'des5',0),
('A6','name6',60000,6,'des6',0);

-- 3
explain select * from product p where p.code='A5';
create unique index code_index on `product`(`code`);
alter table `product` drop index code_index;
explain select * from product p where p.name='name3' and p.price=30000;
create index name_price_index on `product`(`name`,`price`);
alter table product drop index name_price_index;

-- 4
create or replace view product_view as
select `code`,`name`,`price`,`status` from `product`;
explain select * from product_view;
select * from product;
-- update view
update product_view
set price="333333"
where code="A3";
-- xoa view
drop view product_view;
-- 5
-- Display product
DELIMITER //
create procedure get_infor()
begin
	select * from product;
end //
DELIMITER 
call get_infor;

-- ADD Product
DELIMITER //
CREATE PROCEDURE add_product(pcode varchar(45),pname varchar(45),pprice int,pamount int)
BEGIN
	INSERT INTO product(`code`,`name`,`price`,`amount`) values (pcode,pname,pprice,pamount); 
END //
DELIMITER 
call add_product("A7","name7",700000,7);
call get_infor();
-- UPDATE BY ID
DELIMITER //
CREATE PROCEDURE update_byID(pid int,pcode varchar(45),pname varchar(45),pprice int,pamount double,pdes varchar(100),pstatus int)
BEGIN
	update product
    set code=pcode,name=pname,price=pprice,amount=pamount,description=pdes,status=pstatus
    where id=pid;
END //
DELIMITER 
call update_byID(3,"A3","name3",30000,3,"des333",1);
call get_infor();
-- delete product by id
DELIMITER //
CREATE PROCEDURE delete_byID(pid int)
BEGIN
	DELETE FROM product
    where id=pid;
END //
DELIMITER 
call delete_byID(7);
call get_infor();


