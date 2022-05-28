use classicmodels;
DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers` // 
CREATE PROCEDURE findAllCustomers()
BEGIN
	SELECT * FROM CUSTOMERS WHERE customerNumber=175;
END //
DELIMITER 
CALL findAllCustomers();