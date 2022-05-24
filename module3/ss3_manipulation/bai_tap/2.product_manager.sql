create database product_manager;
use product_manager;
create table `customer`(
c_id int primary key auto_increment,
`name` varchar(25),
age tinyint
);
create table `order`(
o_id int primary key auto_increment,
c_id int,
o_date datetime,
o_totalPrice int,
foreign key (c_id) references customer (c_id)
);
create table `product`(
p_id int primary key auto_increment,
p_name varchar(25),
p_price int
);
create table `orderdetail`(
o_id int,
p_id int,
quantity smallint,
primary key(o_id,p_id)
);
-- insert data customer
INSERT INTO customer (`name`, age) VALUE('Minhh Quan', 10);
INSERT INTO customer (`name`, age) VALUE('Ngoc Oanh', 20);
INSERT INTO customer (`name`, age) VALUE('Hong Ha', 50);
-- insert data order
insert INTO `order` (c_id, `o_date`) VALUE(1, '2006-03-21');
insert INTO `order` (c_id, `o_date`) VALUE(2, '2006-03-23');
insert INTO `order` (c_id, `o_date`) VALUE(1, '2006-03-21');

-- insert data product
INSERT into product (`p_name`, p_price) VALUE('may giat', 3);
INSERT into product (`p_name`, p_price) VALUE('tu lanh', 5);
INSERT into product (`p_name`, p_price) VALUE('dieu hoa', 7);
INSERT into product (`p_name`, p_price) VALUE('quat', 1);
INSERT into product (`p_name`, p_price) VALUE('bep dien', 2);

-- insert data order detail
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(1,1,3);
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(1,3,7);
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(1,4,2);
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(3,1,8);
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(2,5,4);
INSERT INTO orderdetail (o_id, p_id, quantity) VALUE(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select * from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select name,p_name from orderdetail
join `product` on orderdetail.p_id=product.p_id
join `order` on orderdetail.o_id=`order`.o_id
join `customer` on `order`.c_id=customer.c_id
--  Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select * from customer
left join `order` on `order`.c_id=customer.c_id
where `order`.o_id is  null
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select od.o_id as `code`,o.o_date as `date`, sum(p.p_price*od.quantity) as `total` from orderdetail od
join `order` o on od.o_id=o.o_id
join `product` p on od.p_id=p.p_id
group by o.o_id






