
SELECT * FROM furama_database.khach_hang;
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (1, 1, 'Le Thi A', '1999-12-12', 'Nam', '983', '09548124', 'aa@gmail.com', '12 NVC');
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (2, 2, 'Le Thi B', '2000-04-10', 'Nữ', '091', '01923431', 'bb@gmail.com', '312 LTV');
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (3, 3, 'Le Thi C', '1985-03-03', 'Nữ', '178', '03982414', 'cc@gmail.com', '122 CCC');
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (4, 4, 'Le Thi D', '1978-03-12', 'Nữ', '555', '01212341', 'đ@gmail.com', '222 ASD');
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (5, 5, 'Le Thi E', '2001-12-09', 'Nữ', '878', '04442142', 'ê@gmail.com', '121 LLL');
INSERT INTO `furama_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES (6, 5, 'Le Thi F', '1990-07-12', 'Nữ', '319', '01111111', 'ff@gmail.com', '455 UJC');

ALTER TABLE `furama_database`.`khach_hang` 
CHANGE COLUMN `gioi_tinh` `gioi_tinh` VARCHAR(10) NOT NULL ;