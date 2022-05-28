SELECT * FROM furama_database.loai_dich_vu;
INSERT INTO `furama_database`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) VALUES ('1', 'Villa');
INSERT INTO `furama_database`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) VALUES ('2', 'House');
INSERT INTO `furama_database`.`loai_dich_vu` (`ma_loai_dich_vu`) VALUES ('3');
UPDATE `furama_database`.`loai_dich_vu` SET `ten_loai_dich_vu` = 'Room' WHERE (`ma_loai_dich_vu` = '3');
