# SpringBootFirstPractice
First project to learn Spring Boot with jQuery-AJAX-Bootstrap-JPA-MySQL and Unit Testing

# Database setup
1.  CREATE DATABASE first_practice_sb;

2.  CREATE TABLE `first_practice_sb`.`customer` (  
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20),
  `email` VARCHAR(20),
  `address` VARCHAR(255),
  `gender` VARCHAR(10),
  `phone` VARCHAR(13),
  `dob` VARCHAR(15),
  `bank_branch` VARCHAR(15),
  `bank_branch_type` VARCHAR(15),
  PRIMARY KEY (`id`)
);
