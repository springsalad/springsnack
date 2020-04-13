CREATE SCHEMA `demo` ;

CREATE TABLE `demo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'User id',
  `name` VARCHAR(45) NULL COMMENT 'user name',
  PRIMARY KEY (`id`))
  COMMENT = 'User';