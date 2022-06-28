create database casestudy;
use casestudy;
DROP Table if exists `product`;
create table `product` (
	id int primary key auto_increment,
    `name` varchar(50) not null,
    price double not null,
    quantity int not null,
    color varchar(50) not null,
    `description` varchar(255),
    category varchar(100) not null
);
insert into `product`(`name`, price, quantity,color,category) values('IPhone 11',799,12,'Purple,Yellow,Green','Phone');
insert into `product`(`name`, price, quantity,color,category) values('Iphone 11 Pro',1100,12,'Green,Black,White','Phone');
insert into `product`(name, price, quantity,color,category) values('Iphone X',749,13,'Coral,Black,Blue','Phone');
insert into `product`(name, price, quantity,color,category) values(' Smart TV',1000000,5,'Black','Television');
insert into `product`(name, price, quantity,color,category) values(' Samsung Galaxy S10',420,10,'Prism White,Prism Blue,Ceramic Black','Phone');

