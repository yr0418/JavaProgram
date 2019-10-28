SET NAMES utf8;

DROP TABLE IF EXISTS `action_type`;
CREATE TABLE `action_type`
(
    `id`          int(11) NOT NULL,
    `action_type` varchar(255),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `audit_info`;
CREATE TABLE `audit_info`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `sender`       varchar(255) DEFAULT NULL,
    `receiver`     varchar(255) default null,
    `action_type`  int(10)      DEFAULT NULL,
    `action_id`    int(10)      DEFAULT NULL,
    `audit_status` int(10)      DEFAULT NULL,
    `audit_result` int(10)      DEFAULT NULL,
    `date`         varchar(255) default null,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `enjoy_info`;
CREATE TABLE `enjoy_info`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `username`     varchar(255) DEFAULT NULL,
    `user_city`    varchar(255) DEFAULT NULL,
    `user_sex`     varchar (255) default null ,
    `action_name`  varchar(255) default null,
    `label`        varchar(255) DEFAULT NULL,
    `sex_specific` int(10)      DEFAULT NULL,
    `time`         datetime     DEFAULT NULL,
    `site`         varchar(255) DEFAULT NULL,
    `max_member`   int(10)      DEFAULT NULL,
    `left_size`  int(10)      DEFAULT NULL,
    `date`         date         default null,
    `ps`           varchar(255) DEFAULT NULL,
    `valid`        int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `study_info`;
CREATE TABLE `study_info`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `username`     varchar(255) DEFAULT NULL,
    `user_school`  varchar(255) DEFAULT NULL,
    `action_name`  varchar(255) default null,
    `type`         int(10)      default null ,
    `label`        varchar(255) DEFAULT NULL,
    `time`         varchar(255) DEFAULT NULL,
    `site`         varchar(255) DEFAULT NULL,
    `max_member`   int(10)      DEFAULT NULL,
    `left_size`  int(10)      DEFAULT NULL,
    `date`         date         default null,
    `ps`           varchar(255) DEFAULT NULL,
    `valid`        int(10)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `team_info`;
CREATE TABLE `team_info`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `username`     varchar(255) DEFAULT NULL,
    `action_type`  int(10)      DEFAULT NULL,
    `action_id`    int(10)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`                     bigint(20) NOT NULL AUTO_INCREMENT,
    `username`               varchar(255) DEFAULT NULL,
    `password`               varchar(255) DEFAULT NULL,
    `nickname`               varchar(255) DEFAULT NULL,
    `user_img_url`           varchar(255) DEFAULT NULL,
    `sex`                    varchar(255) DEFAULT NULL,
    `city`                   varchar(255) DEFAULT NULL,
    `school`                 varchar(255) DEFAULT NULL,
    `academy`                varchar(255) DEFAULT NULL,
    `major`                  varchar(255) DEFAULT NULL,
    `personalized_signature` varchar(255) DEFAULT NULL,
    `personalized_labels`    varchar(255) DEFAULT NULL,
    `online`                 int(10)      default null,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message`
(
    `id`       bigint(10) NOT NULL AUTO_INCREMENT,
    `sender`   varchar(255) DEFAULT NULL,
    `receiver` varchar(255) DEFAULT NULL,
    `type`     int(10)      DEFAULT NULL,
    `context`  varchar(255) DEFAULT NULL,
    `date`     varchar(255) default null,
    `read`     int(10)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type`
(
    `id`   bigint(10) NOT NULL,
    `type` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `user_friends`;
CREATE TABLE `user_friends`
(
    `id`       bigint(20) not null AUTO_INCREMENT,
    `username` varchar(255) default null,
    `friend`   varchar(255) default null,
    primary key (`id`)
);

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`
(
    `id`   integer(20) not null,
    `type` integer (20),
    primary key (`id`)
);

DROP TABLE IF EXISTS `key_value`;
CREATE TABLE `key_value`
(
    `id`   integer(20) not null AUTO_INCREMENT,
    `table` varchar (50),
    `key` varchar (50),
    `value` integer (50),
    `comment` varchar (50),
    primary key (`id`)
);
