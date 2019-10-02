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
INSERT INTO `message_type` VALUES (2, '入队申请');
insert into `message_type` values (3, '入队申请结果');


-- ----------------------------
-- Records of user_detail_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', 'root', 'ALone Wolf', NULL, '男', '武汉', '湖北大学', '教育学院', '教育技术学', '我的世界，你的爱情', 'java，宅男',0);
INSERT INTO `user_info` VALUES (2, '111', '111', '111', NULL, '男', '武汉', '湖北大学', '教育学院', '教育技术学', '1111', 'vue',0);
INSERT INTO `user_info` VALUES (3, '222', '222', '222', NULL, '女', '武汉', '湖北大学', '生命科学学院', '生物信息学', '222', '无',0);
INSERT INTO `user_info` VALUES (4, 'abc', 'abc', 'abc', NULL, '女', '武汉', '武汉大学', '计算机与信息学院', '软件工程', 'abc', '无',0);

-- ----------------------------
-- Records of user_friends
-- ----------------------------
insert into `user_friends` values (1,'root','111');
insert into `user_friends` values (2,'root','222');
insert into `user_friends` values (3,'222','111');