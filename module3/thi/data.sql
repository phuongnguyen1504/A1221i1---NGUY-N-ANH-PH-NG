create database benh_an;
use benh_an;
DROP Table if exists `benh_nhan`;
create table `benh_nhan`(
	id varchar(25) primary key,
    name varchar(100) not null
);
DROP Table if exists `benh_an`;

create table `benh_an`(
	id varchar(25) primary key,
    date_in date not null,
    date_out date not null,
    reason varchar(255) not null,
    id_benh_nhan varchar(25) not null,
    foreign key(id_benh_nhan) references `benh_nhan`(id)
);
ALTER TABLE `benh_an`.`benh_an` 
DROP FOREIGN KEY `benh_an_ibfk_1`;
ALTER TABLE `benh_an`.`benh_an` 
ADD CONSTRAINT `benh_an_ibfk_1`
  FOREIGN KEY (`id_benh_nhan`)
  REFERENCES `benh_an`.`benh_nhan` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
 
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-435', 'Nguyen Van A');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-123', 'Nguyen Van B');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-984', 'Nguyen Van C');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-153', 'Nguyen Van D');

  
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-001', '2019/05/01', '2020/05/01', 'Ung thu giai doan cuoi', 'BN-435');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-112', '2018-05-05', '2019-05-05', 'Suy than man', 'BN-123');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-223', '2020-01-01', '2021-01-01', 'Covid 19', 'BN-984');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-444', '2021-06-30', '2022-06-30', 'Ung thu phoi giai doan cuoi', 'BN-153');
