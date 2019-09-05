SET NAMES utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL comment '用户名',
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL comment '用户昵称',
  `avatar_url` varchar(200) DEFAULT '' comment '头像',
  PRIMARY KEY (`id`)
);