-- MySQL Workbench Synchronization
-- Generated: 2022-11-23 21:05
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: 84354

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER SCHEMA `book_store`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `book_store`.`category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`book` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `author` VARCHAR(45) NULL DEFAULT NULL,
  `year_publish` DATE NULL DEFAULT NULL,
  `img_url` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `amount` INT(11) NULL DEFAULT NULL,
  `publisher` VARCHAR(255) NULL DEFAULT NULL,
  `language` VARCHAR(45) NULL DEFAULT NULL,
  `number_rating` INT(11) NULL DEFAULT NULL,
  `total_pages` INT(11) NULL DEFAULT NULL,
  `weight` DOUBLE NULL DEFAULT NULL,
  `category_id` INT(11) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_book_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_book_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `book_store`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`cart` (
  `id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cart_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_cart_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `book_store`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`customer` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` DATE NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `gender` BIT(1) NULL DEFAULT NULL,
  `img_url` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(10) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_user1_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_customer_user1`
    FOREIGN KEY (`username`)
    REFERENCES `book_store`.`account` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`account` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`role` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`order` (
  `id` INT(11) NOT NULL,
  `date_order` DATE NULL DEFAULT NULL,
  `date_delivery` DATE NULL DEFAULT NULL,
  `date_receipt` DATE NULL DEFAULT NULL,
  `customer_id` INT(11) NOT NULL,
  `total_price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `book_store`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`account_role` (
  `role_id` INT(11) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`, `username`),
  INDEX `fk_role_has_user_user1_idx` (`username` ASC) VISIBLE,
  INDEX `fk_role_has_user_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_has_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `book_store`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1`
    FOREIGN KEY (`username`)
    REFERENCES `book_store`.`account` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`cart_item` (
  `book_id` INT(11) NOT NULL,
  `cart_id` INT(11) NOT NULL,
  `amount` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`, `cart_id`),
  INDEX `fk_book_has_cart_cart1_idx` (`cart_id` ASC) VISIBLE,
  INDEX `fk_book_has_cart_book1_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk_book_has_cart_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `book_store`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_has_cart_cart1`
    FOREIGN KEY (`cart_id`)
    REFERENCES `book_store`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `book_store`.`order_detail` (
  `order_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `amount` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`, `book_id`),
  INDEX `fk_order_has_book_book1_idx` (`book_id` ASC) VISIBLE,
  INDEX `fk_order_has_book_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_book_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `book_store`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_book_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `book_store`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
