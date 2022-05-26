-- MySQL Workbench Synchronization
-- Generated: 2022-05-26 20:45
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: ADMIN

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `furama_database` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `furama_database`.`vi_tri` (
  `ma_vi_tri` INT(11) NOT NULL,
  `ten_vi_tri` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ma_vi_tri`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`nhan_vien` (
  `ma_nhan_vien` INT(11) NOT NULL AUTO_INCREMENT,
  `ho_ten` VARCHAR(45) NOT NULL,
  `ngay_sinh` DATE NOT NULL,
  `so_cmnd` VARCHAR(45) NOT NULL,
  `luong` DOUBLE NOT NULL,
  `so_dien_thoai` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `dia_chi` VARCHAR(45) NULL DEFAULT NULL,
  `ma_trinh_do` INT(11) NOT NULL,
  `ma_vi_tri` INT(11) NOT NULL,
  `ma_bo_phan` INT(11) NOT NULL,
  PRIMARY KEY (`ma_nhan_vien`),
  INDEX `fk_nhan_vien_trinh_do1_idx` (`ma_trinh_do` ASC) VISIBLE,
  INDEX `fk_nhan_vien_vi_tri1_idx` (`ma_vi_tri` ASC) VISIBLE,
  INDEX `fk_nhan_vien_bo_phan1_idx` (`ma_bo_phan` ASC) VISIBLE,
  CONSTRAINT `fk_nhan_vien_trinh_do1`
    FOREIGN KEY (`ma_trinh_do`)
    REFERENCES `furama_database`.`trinh_do` (`ma_trinh_do`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nhan_vien_vi_tri1`
    FOREIGN KEY (`ma_vi_tri`)
    REFERENCES `furama_database`.`vi_tri` (`ma_vi_tri`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nhan_vien_bo_phan1`
    FOREIGN KEY (`ma_bo_phan`)
    REFERENCES `furama_database`.`bo_phan` (`ma_bo_phan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`trinh_do` (
  `ma_trinh_do` INT(11) NOT NULL,
  `ten_trinh_do` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_trinh_do`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`bo_phan` (
  `ma_bo_phan` INT(11) NOT NULL,
  `ten_bo_phan` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_bo_phan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`khach_hang` (
  `ma_khach_hang` INT(11) NOT NULL,
  `ma_loai_khach` INT(11) NOT NULL,
  `ho_ten` VARCHAR(45) NOT NULL,
  `ngay_sinh` DATE NOT NULL,
  `gioi_tinh` VARCHAR(45) NOT NULL,
  `so_cmnd` VARCHAR(45) NOT NULL,
  `so_dien_thoai` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dia_chi` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ma_khach_hang`),
  INDEX `fk_khach_hang_loai_khach1_idx` (`ma_loai_khach` ASC) VISIBLE,
  CONSTRAINT `fk_khach_hang_loai_khach1`
    FOREIGN KEY (`ma_loai_khach`)
    REFERENCES `furama_database`.`loai_khach` (`ma_loai_khach`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`loai_khach` (
  `ma_loai_khach` INT(11) NOT NULL,
  `ten_loai_khach` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_loai_khach`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`hop_dong` (
  `ma_hop_dong` INT(11) NOT NULL,
  `ngay_lam_hop_dong` DATETIME NOT NULL,
  `ngay_ket_thuc` DATETIME NOT NULL,
  `tien_dat_coc` DOUBLE NOT NULL,
  `ma_nhan_vien` INT(11) NOT NULL,
  `ma_khach_hang` INT(11) NOT NULL,
  `ma_dich_vu` INT(11) NOT NULL,
  PRIMARY KEY (`ma_hop_dong`),
  INDEX `fk_hop_dong_nhan_vien1_idx` (`ma_nhan_vien` ASC) VISIBLE,
  INDEX `fk_hop_dong_khach_hang1_idx` (`ma_khach_hang` ASC) VISIBLE,
  INDEX `fk_hop_dong_dich_vu1_idx` (`ma_dich_vu` ASC) VISIBLE,
  CONSTRAINT `fk_hop_dong_nhan_vien1`
    FOREIGN KEY (`ma_nhan_vien`)
    REFERENCES `furama_database`.`nhan_vien` (`ma_nhan_vien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hop_dong_khach_hang1`
    FOREIGN KEY (`ma_khach_hang`)
    REFERENCES `furama_database`.`khach_hang` (`ma_khach_hang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hop_dong_dich_vu1`
    FOREIGN KEY (`ma_dich_vu`)
    REFERENCES `furama_database`.`dich_vu` (`ma_dich_vu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`hop_dong_chi_tiet` (
  `ma_hop_dong_chi_tiet` INT(11) NOT NULL,
  `ma_hop_dong` INT(11) NOT NULL,
  `ma_dich_vu_di_kem` INT(11) NOT NULL,
  `so_luong` INT(11) NOT NULL,
  PRIMARY KEY (`ma_hop_dong_chi_tiet`),
  INDEX `fk_hop_dong_chi_tiet_hop_dong1_idx` (`ma_hop_dong` ASC) VISIBLE,
  INDEX `fk_hop_dong_chi_tiet_dich_vu_di_kem1_idx` (`ma_dich_vu_di_kem` ASC) VISIBLE,
  CONSTRAINT `fk_hop_dong_chi_tiet_hop_dong1`
    FOREIGN KEY (`ma_hop_dong`)
    REFERENCES `furama_database`.`hop_dong` (`ma_hop_dong`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hop_dong_chi_tiet_dich_vu_di_kem1`
    FOREIGN KEY (`ma_dich_vu_di_kem`)
    REFERENCES `furama_database`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`dich_vu_di_kem` (
  `ma_dich_vu_di_kem` INT(11) NOT NULL,
  `ten_dich_vu_di_kem` VARCHAR(45) NOT NULL,
  `gia` DOUBLE NOT NULL,
  `don_vi` VARCHAR(10) NOT NULL,
  `trang_thai` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_dich_vu_di_kem`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`dich_vu` (
  `ma_dich_vu` INT(11) NOT NULL,
  `ten_dich_vu` VARCHAR(45) NOT NULL,
  `dien_tich` INT(11) NULL DEFAULT NULL,
  `chi_phi_thue` DOUBLE NOT NULL,
  `so_nguoi_toi_da` INT(11) NULL DEFAULT NULL,
  `ma_kieu_thue` INT(11) NOT NULL,
  `ma_loai_dich_vu` INT(11) NOT NULL,
  `tieu_chuan_phong` VARCHAR(45) NULL DEFAULT NULL,
  `mo_ta_tien_nghi_khac` VARCHAR(45) NULL DEFAULT NULL,
  `dien_tich_ho_boi` DOUBLE NULL DEFAULT NULL,
  `so_tang` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_dich_vu`),
  INDEX `fk_dich_vu_kieu_thue1_idx` (`ma_kieu_thue` ASC) VISIBLE,
  INDEX `fk_dich_vu_loai_dich_vu1_idx` (`ma_loai_dich_vu` ASC) VISIBLE,
  CONSTRAINT `fk_dich_vu_kieu_thue1`
    FOREIGN KEY (`ma_kieu_thue`)
    REFERENCES `furama_database`.`kieu_thue` (`ma_kieu_thue`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dich_vu_loai_dich_vu1`
    FOREIGN KEY (`ma_loai_dich_vu`)
    REFERENCES `furama_database`.`loai_dich_vu` (`ma_loai_dich_vu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`kieu_thue` (
  `ma_kieu_thue` INT(11) NOT NULL,
  `ten_kieu_thue` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_kieu_thue`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `furama_database`.`loai_dich_vu` (
  `ma_loai_dich_vu` INT(11) NOT NULL,
  `ten_loai_dich_vu` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ma_loai_dich_vu`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
