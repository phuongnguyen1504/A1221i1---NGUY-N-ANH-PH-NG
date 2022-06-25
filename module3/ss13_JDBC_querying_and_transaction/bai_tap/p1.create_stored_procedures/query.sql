create database demoss12;
use demoss12;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$
DROP PROCEDURE IF EXISTS `FindAllUser`$$
CREATE PROCEDURE `FindAllUser`()
BEGIN
	SELECT * FROM users;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `update_user`(in id_new int,in name_new varchar(20),in email_new varchar(50), in country_new varchar(20))
BEGIN
UPDATE users set name=name_new,email=email_new,country=country_new where id=id_new; 
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `delete_user`(in id_new int)
BEGIN
DELETE FROM users where id=id_new;
END $$
DELIMITER ;