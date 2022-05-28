use classicmodels;
-- in paramater
DELIMITER //
DROP PROCEDURE IF EXISTS getCusById;
CREATE PROCEDURE getCusById(IN cusNum int(11))
BEGIN
	SELECT * FROM customers where customerNumber=cusNum;
END //
DELIMITER 
call getCusById(171);
-- out paramater
DELIMITER //
DROP PROCEDURE IF EXISTS `classicmodels`.`GetCustomersCountByCity`;
CREATE PROCEDURE GetCustomersCountByCity(IN in_city varchar(50),OUT total INT)
BEGIN
	SELECT COUNT(customerName) into total from customers where city=in_city;
END //
DELIMITER 

call GetCustomersCountByCity('Singapore',@tong);
select @tong;
--inout paramater
DELIMITER //
DROP PROCEDURE IF EXISTS SetCounter;
CREATE PROCEDURE SetCounter(INOUT counter int, in inc int)
BEGIN
	SET counter =counter +inc;
END //
DELIMITER 
set @counter=2;
call SetCounter(@counter,2);
call SetCounter(@counter,4);
select @counter;
