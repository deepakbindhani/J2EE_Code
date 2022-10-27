/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - policy-provider-portal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`policy-provider-portal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `policy-provider-portal`;

/*Table structure for table `buy_policy` */

DROP TABLE IF EXISTS `buy_policy`;

CREATE TABLE `buy_policy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `buy_date` date DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `duration` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `poilicy_id` bigint DEFAULT NULL,
  `poilicy_name` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `renewal_date` date DEFAULT NULL,
  `roi` varchar(225) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `buy_policy` */

insert  into `buy_policy`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`buy_date`,`contact_no`,`dob`,`duration`,`email`,`first_name`,`last_name`,`poilicy_id`,`poilicy_name`,`price`,`renewal_date`,`roi`,`user_id`) values 
(1,NULL,NULL,NULL,NULL,'2021-05-29','9654565858','1997-06-10',NULL,'Hari@gmail.com','Hariom','Mukati',1,'Jescie Gillespie','518','2021-05-29','2.6',2);

/*Table structure for table `feed_back` */

DROP TABLE IF EXISTS `feed_back`;

CREATE TABLE `feed_back` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `message` varchar(225) DEFAULT NULL,
  `subject` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `feed_back` */

insert  into `feed_back`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`message`,`subject`) values 
(1,NULL,NULL,NULL,NULL,'Qui voluptate archit','Eaque qui ut libero ');

/*Table structure for table `policy` */

DROP TABLE IF EXISTS `policy`;

CREATE TABLE `policy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `duration` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `rating` varchar(225) DEFAULT NULL,
  `roi` varchar(225) DEFAULT NULL,
  `category` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `policy` */

insert  into `policy`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`date`,`description`,`duration`,`name`,`price`,`rating`,`roi`,`category`) values 
(1,NULL,NULL,NULL,NULL,'2021-05-26','3 Year','3 Year','Jescie Gillespie','518','4.6','2.6','Vehicle'),
(2,NULL,NULL,NULL,NULL,'2021-05-26','5 Year','5 Year','Nora Richard','215','3.5','6.5','Health');

/*Table structure for table `term_condition` */

DROP TABLE IF EXISTS `term_condition`;

CREATE TABLE `term_condition` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `headiing` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `term_condition` */

insert  into `term_condition`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`description`,`headiing`) values 
(1,NULL,NULL,NULL,NULL,'Culpa consequatur vdfvsfdvsdvsdvwefduwevfuewfu,\r\nadcbwudvciwdcuyvwedd','Aut eu incididunt do');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `comment` varchar(225) DEFAULT NULL,
  `issue` varchar(225) DEFAULT NULL,
  `message` varchar(225) DEFAULT NULL,
  `status` varchar(225) DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  `user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkh64g43tjdln3narjpjnxcxcf` (`user`),
  CONSTRAINT `FKkh64g43tjdln3narjpjnxcxcf` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ticket` */

insert  into `ticket`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`comment`,`issue`,`message`,`status`,`ticket_id`,`user`) values 
(1,NULL,NULL,NULL,NULL,'zxvsd vds','Ullam commodi ducimu','Nisi reprehenderit dhc',NULL,1,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `city` varchar(225) DEFAULT NULL,
  `confirm_password` varchar(255) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email_id` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `middle_name` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`address`,`city`,`confirm_password`,`contact_no`,`dob`,`email_id`,`first_name`,`gender`,`last_name`,`middle_name`,`password`,`role_id`,`user_name`) values 
(1,NULL,NULL,NULL,NULL,'Adipisci anim ration','dvbisdbvibgdsvi',NULL,'9685456585','1997-06-10','cebot@mailinator.com','Daryl','Male','Hammond','Ria Johnson','Pa$$w0rd!',1,'Admin123'),
(2,NULL,NULL,NULL,NULL,'Dolores illo elit a','Eligendi iste itaquev',NULL,'9685452212','1997-06-10','hibyje@mailinator.com','Ingrid','Female','Reeves','Herrod Cantu','User@123',2,'kuziwaky123'),
(3,NULL,NULL,NULL,NULL,'Amet et sapiente ma','Cumque voluptas ex a',NULL,'9685456585','2021-06-10','jejyp@mailinator.com','Winter','Female','Pugh','Aurora','Pa$$w0rd!',2,'zeqylujag123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
