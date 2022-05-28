SELECT * FROM furama_database.kieu_thue;
INSERT INTO `furama_database`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES ('1', 'năm');
INSERT INTO `furama_database`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES ('2', 'tháng');
INSERT INTO `furama_database`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) VALUES ('3', 'ngày');
INSERT INTO `furama_database`.`kieu_thue` (`ma_kieu_thue`) VALUES ('4');
UPDATE `furama_database`.`kieu_thue` SET `ten_kieu_thue` = 'giờ' WHERE (`ma_kieu_thue` = '4');
