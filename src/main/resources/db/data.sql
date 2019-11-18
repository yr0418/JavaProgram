-- ----------------------------
-- Records of action_type
-- ----------------------------
INSERT INTO `action_type` VALUES (1, '线下学习');
INSERT INTO `action_type` VALUES (2, '线上学习');
INSERT INTO `action_type` VALUES (3, '吃喝玩乐');

-- ----------------------------
-- Records of message_type
-- ----------------------------
INSERT INTO `message_type` VALUES (1, '好友申请');
insert into `message_type` values (2, '入队申请失败');
insert into `message_type` values (3, '入队申请成功');

-- ----------------------------
-- Records of key_value
-- ----------------------------
insert into `field_value` values (1, 'user_message', 'read', '1', '消息已读');
insert into `field_value` values (2, 'user_message', 'read', '0', '消息未读');
insert into `field_value` values (3, 'user_info', 'online', '0', '不在线');
insert into `field_value` values (4, 'user_info', 'online', '1', '在线');
insert into `field_value` values (5, 'study_info', 'valid', '1', '组队信息有效');
insert into `field_value` values (6, 'study_info', 'valid', '0', '组队消息失效');
insert into `field_value` values (7, 'enjoy_info', 'sex_specific', '1', '性别限制，只限异性');
insert into `field_value` values (8, 'enjoy_info', 'sex_specific', '2', '性别限制，只限同性');
insert into `field_value` values (9, 'enjoy_info', 'sex_specific', '3', '无性别限制');
insert into `field_value` values (10, 'audit_info', 'audit_state', '0', '未审核');
insert into `field_value` values (11, 'audit_info', 'audit_state', '1', '已审核');
insert into `field_value` values (12, 'audit_info', 'audit_result', '0', '申请失败');
insert into `field_value` values (13, 'audit_info', 'audit_result', '1',' 申请成功');


-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', 'root', 'ALone Wolf', NULL, '男', '武汉', '湖北大学', '教育学院', '教育技术学', '我的世界，你的爱情', 'java，宅男',0);
INSERT INTO `user_info` VALUES (2, '111', '111', '111', 'img/virtual/111.jpg', '男', '武汉', '湖北大学', '教育学院', '教育技术学', '1111', 'vue',0);
INSERT INTO `user_info` VALUES (3, '222', '222', '222', NULL, '女', '长沙', '湖南大学', '生命科学学院', '生物信息学', '222', '无',0);
INSERT INTO `user_info` VALUES (4, 'abc', 'abc', 'abc', NULL, '女', '南京', '南京大学', '计算机与信息学院', '软件工程', 'abc', '无',0);
insert into `user_info` values (5,'19333','123456','Alone-Wolf',null,'女','武汉','武汉大学','计算机学院','软件工程','sassas','swswswwsw',0);

-- ----------------------------
-- Records of user_friends
-- ----------------------------
insert into `user_friends` values (1,'root','111');
insert into `user_friends` values (2,'root','222');
insert into `user_friends` values (3,'222','111');

commit;