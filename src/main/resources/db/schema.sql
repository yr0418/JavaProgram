
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `action_type`;
CREATE TABLE `action_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_type` varchar(255),
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `audit_info`;
CREATE TABLE `audit_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255),
  `action_type` int(10),
  `action_id` int(10),
  `audit_status` int(10),
  `audit_result` int(10),
  PRIMARY KEY (`id`)
)


DROP TABLE IF EXISTS `enjoy`;
CREATE TABLE `enjoy`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) ,
  `user_city` varchar(255),
  `lable` varchar(255),
  `sex_specific` int(10),
  `time` datetime,
  `site` varchar(255),
  `max_member` int(10),
  `left_member` int(10),
  `ps` varchar(255),
  `valid` int(11),
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `offline_study`;
CREATE TABLE `offline_study`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `user_school` varchar(255)  DEFAULT NULL,
  `lable` varchar(255) DEFAULT NULL,
  `time` varchar(255)DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `max_member` int(10) DEFAULT NULL,
  `left_member` int(10) DEFAULT NULL,
  `ps` varchar(255) DEFAULT NULL,
  `valid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `online_study`;
CREATE TABLE `online_study`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `lable` varchar(255)DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `max_member` int(255) DEFAULT NULL,
  `left_member` int(255) DEFAULT NULL,
  `ps` varchar(255)  DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


DROP TABLE IF EXISTS `team_info`;
CREATE TABLE `team_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `action_type` int(10) DEFAULT NULL,
  `action_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255)  DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `user_img_url` varchar(255) DEFAULT NULL,
  `sex` varchar(255)  DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `school` varchar(255)DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `major` varchar(255)  DEFAULT NULL,
  `personalized_signature` varchar(255)  DEFAULT NULL,
  `personalized_lables` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `sender` varchar(255)  DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `type` int(10) DEFAULT NULL ,
  `context` varchar(255)  DEFAULT NULL,
  `read` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type`  (
  `id` bigint(10) NOT NULL ,
  `type` varchar(50) DEFAULT NULL ,
  PRIMARY KEY (`id`)
)

