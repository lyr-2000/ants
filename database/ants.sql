/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100132
 Source Host           : localhost:3306
 Source Schema         : chat

 Target Server Type    : MySQL
 Target Server Version : 100132
 File Encoding         : 65001

 Date: 21/08/2019 03:59:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` double(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2225 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (15, 'test', 16);
INSERT INTO `account` VALUES (20, 'test', 16);
INSERT INTO `account` VALUES (200, 'test', 16);
INSERT INTO `account` VALUES (222, 'test', 16);
INSERT INTO `account` VALUES (300, 'test', 16);
INSERT INTO `account` VALUES (310, 'test', 16);
INSERT INTO `account` VALUES (312, 'test', 16);
INSERT INTO `account` VALUES (2222, 'test', 16);
INSERT INTO `account` VALUES (2223, 'yes', 56);
INSERT INTO `account` VALUES (2224, 'account', 57);
INSERT INTO `account` VALUES (171543113, '陈彬', 3);
INSERT INTO `account` VALUES (171543114, '陈杰灿', 16);
INSERT INTO `account` VALUES (171543117, '邓学洋', 16);

-- ----------------------------
-- Table structure for ants_chat_offline
-- ----------------------------
DROP TABLE IF EXISTS `ants_chat_offline`;
CREATE TABLE `ants_chat_offline`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(50) NULL DEFAULT NULL COMMENT '谁发送过来的',
  `towho` int(50) NULL DEFAULT NULL COMMENT '发送给谁的',
  `offlinemessage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '离线的消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_chat_offline
-- ----------------------------
INSERT INTO `ants_chat_offline` VALUES (1, 171543113, 171543114, '12312');

-- ----------------------------
-- Table structure for ants_chat_user
-- ----------------------------
DROP TABLE IF EXISTS `ants_chat_user`;
CREATE TABLE `ants_chat_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL COMMENT '学号',
  `contactor` int(255) NULL DEFAULT NULL COMMENT '联系人id',
  `contactorName` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `information` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '历史消息',
  `latestTime` datetime(0) NULL DEFAULT NULL COMMENT '聊天最晚消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_chat_user
-- ----------------------------
INSERT INTO `ants_chat_user` VALUES (1, 171543113, 171543114, '陈杰灿', '你好呀', NULL);
INSERT INTO `ants_chat_user` VALUES (5, 171543113, 171543115, '不认识', NULL, NULL);
INSERT INTO `ants_chat_user` VALUES (6, 171543113, 171543119, '邓学洋', '恩恩额', NULL);
INSERT INTO `ants_chat_user` VALUES (7, 171543114, 171543115, '不认识', NULL, NULL);

-- ----------------------------
-- Table structure for ants_class_parent
-- ----------------------------
DROP TABLE IF EXISTS `ants_class_parent`;
CREATE TABLE `ants_class_parent`  (
  `parentId` int(11) NOT NULL AUTO_INCREMENT,
  `parentName` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '大类别的',
  `parentPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`parentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_class_parent
-- ----------------------------
INSERT INTO `ants_class_parent` VALUES (1, '书籍', 'book.png');
INSERT INTO `ants_class_parent` VALUES (2, '文具', 'stationery.png');
INSERT INTO `ants_class_parent` VALUES (3, '日用', 'daily.png');
INSERT INTO `ants_class_parent` VALUES (4, '美妆', 'cosmetics.png');
INSERT INTO `ants_class_parent` VALUES (5, '食品', 'food.png');
INSERT INTO `ants_class_parent` VALUES (6, '电器', 'electrical.png');
INSERT INTO `ants_class_parent` VALUES (7, '其他', 'others.png');

-- ----------------------------
-- Table structure for ants_class_sub
-- ----------------------------
DROP TABLE IF EXISTS `ants_class_sub`;
CREATE TABLE `ants_class_sub`  (
  `subClassId` int(11) NOT NULL AUTO_INCREMENT COMMENT '子类别的id',
  `subClassName` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子类别的名字',
  `parentClass` int(255) NULL DEFAULT NULL COMMENT '父类别的id',
  PRIMARY KEY (`subClassId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_class_sub
-- ----------------------------
INSERT INTO `ants_class_sub` VALUES (1, '英语四六级', 1);
INSERT INTO `ants_class_sub` VALUES (2, '证从', 1);
INSERT INTO `ants_class_sub` VALUES (3, '银从', 1);
INSERT INTO `ants_class_sub` VALUES (4, '会计', 1);
INSERT INTO `ants_class_sub` VALUES (5, '教师资格证', 1);
INSERT INTO `ants_class_sub` VALUES (6, '计算机二级', 1);
INSERT INTO `ants_class_sub` VALUES (7, '其他', 1);
INSERT INTO `ants_class_sub` VALUES (8, '本子', 2);
INSERT INTO `ants_class_sub` VALUES (9, '笔', 2);
INSERT INTO `ants_class_sub` VALUES (10, '便签', 2);
INSERT INTO `ants_class_sub` VALUES (11, '文件夹', 2);
INSERT INTO `ants_class_sub` VALUES (12, '计算器', 2);
INSERT INTO `ants_class_sub` VALUES (13, '办公用品', 2);
INSERT INTO `ants_class_sub` VALUES (14, '包装用品', 2);
INSERT INTO `ants_class_sub` VALUES (15, '其他', 2);
INSERT INTO `ants_class_sub` VALUES (16, '收纳', 3);
INSERT INTO `ants_class_sub` VALUES (17, '服饰', 3);
INSERT INTO `ants_class_sub` VALUES (18, '鞋表', 3);
INSERT INTO `ants_class_sub` VALUES (19, '箱包', 3);
INSERT INTO `ants_class_sub` VALUES (20, '洗护用品', 3);
INSERT INTO `ants_class_sub` VALUES (21, '非处方用品', 3);
INSERT INTO `ants_class_sub` VALUES (22, '餐桌用品', 3);
INSERT INTO `ants_class_sub` VALUES (23, '其他', 3);
INSERT INTO `ants_class_sub` VALUES (24, '化妆水乳', 4);
INSERT INTO `ants_class_sub` VALUES (25, '防晒隔离', 4);
INSERT INTO `ants_class_sub` VALUES (26, '粉底定妆', 4);
INSERT INTO `ants_class_sub` VALUES (27, '眼妆眉笔', 4);
INSERT INTO `ants_class_sub` VALUES (28, '唇膏口红', 4);
INSERT INTO `ants_class_sub` VALUES (29, '化妆工具', 4);
INSERT INTO `ants_class_sub` VALUES (30, '美甲用具', 4);
INSERT INTO `ants_class_sub` VALUES (31, '其他', 4);
INSERT INTO `ants_class_sub` VALUES (32, '速食品', 5);
INSERT INTO `ants_class_sub` VALUES (33, '饮料', 5);
INSERT INTO `ants_class_sub` VALUES (34, '调味料', 5);
INSERT INTO `ants_class_sub` VALUES (35, '五谷', 5);
INSERT INTO `ants_class_sub` VALUES (36, '甜品', 5);
INSERT INTO `ants_class_sub` VALUES (37, '膨化食品', 5);
INSERT INTO `ants_class_sub` VALUES (38, '冲泡花茶', 5);
INSERT INTO `ants_class_sub` VALUES (39, '其他', 5);
INSERT INTO `ants_class_sub` VALUES (40, 'U盘', 6);
INSERT INTO `ants_class_sub` VALUES (41, '台灯', 6);
INSERT INTO `ants_class_sub` VALUES (42, '数据线', 6);
INSERT INTO `ants_class_sub` VALUES (43, '充电宝', 6);
INSERT INTO `ants_class_sub` VALUES (44, '鼠标键盘', 6);
INSERT INTO `ants_class_sub` VALUES (45, '洗衣机', 6);
INSERT INTO `ants_class_sub` VALUES (46, '烘干机', 6);
INSERT INTO `ants_class_sub` VALUES (47, '其他', 6);

-- ----------------------------
-- Table structure for ants_goods_base
-- ----------------------------
DROP TABLE IF EXISTS `ants_goods_base`;
CREATE TABLE `ants_goods_base`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `goodsVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品视频的路径',
  `goodsClass` int(11) NULL DEFAULT NULL COMMENT '一个子类的id',
  `goodsPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品的价格',
  `goodsState` int(11) NULL DEFAULT 0 COMMENT '0：未交易  1：正在交易中',
  `goodsBargin` int(11) NULL DEFAULT 0 COMMENT '0:可议价  1：不可议价',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '所属买家主键',
  `goodsWay` int(11) NULL DEFAULT 0 COMMENT '0:卖家送货上门  1:买家上门自取 2：可待商量',
  `uploadTime` datetime(0) NULL DEFAULT NULL COMMENT '商品上传时间',
  `repertory` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_goods_base
-- ----------------------------
INSERT INTO `ants_goods_base` VALUES (1, '2', '2', '4', '4', 7, 521.00, 1, 1, 1, 1, '2019-05-23 14:49:14', 1);
INSERT INTO `ants_goods_base` VALUES (2, '3', '4', '5', '5', 15, 45.00, 1, 1, 1, 1, '2019-06-20 14:49:19', 1);
INSERT INTO `ants_goods_base` VALUES (3, '4', '8', '7', '6', 2, 68.00, 1, 1, 1, 1, '2019-06-23 14:49:22', 1);
INSERT INTO `ants_goods_base` VALUES (4, '5', '3', '2', '3', 2, 77.00, 1, 1, 1, 1, '2019-06-18 14:49:27', 1);
INSERT INTO `ants_goods_base` VALUES (6, '44', '41', '22', '3', 2, 52.00, 1, 1, 1, 1, '2019-06-29 14:49:30', 1);
INSERT INTO `ants_goods_base` VALUES (7, '89', '465', '32', '14', 2, 23.00, 1, 1, 1, 1, '2019-06-30 14:49:34', 1);
INSERT INTO `ants_goods_base` VALUES (8, '2', '2', '4', '4', 7, 521.00, 1, 1, 1, 1, '2019-07-18 14:49:46', 1);
INSERT INTO `ants_goods_base` VALUES (9, '3', '4', '5', '5', 15, 45.00, 1, 1, 1, 1, '2019-06-29 14:49:50', 1);
INSERT INTO `ants_goods_base` VALUES (10, '4', '8', '7', '6', 2, 68.00, 1, 1, 1, 1, '2019-07-18 14:49:56', 1);
INSERT INTO `ants_goods_base` VALUES (11, '5', '3', '2', '3', 2, 77.00, 1, 1, 1, 1, '2019-06-14 14:50:00', 1);
INSERT INTO `ants_goods_base` VALUES (12, '44', '41', '22', '3', 2, 52.00, 1, 1, 1, 1, '2019-06-29 14:50:03', 1);
INSERT INTO `ants_goods_base` VALUES (13, '89', '465', '32', '14', 2, 23.00, 1, 1, 1, 1, '2019-07-13 14:50:08', 1);
INSERT INTO `ants_goods_base` VALUES (555, 'czd', 'sadasdadsa', '233.jpg', '555.mp4', 4, 45.60, 0, 0, 1, 1, '2019-08-12 00:00:00', 10);
INSERT INTO `ants_goods_base` VALUES (5556, 'czd', 'sadasdadsa', '233.jpg', '555.mp4', 4, 45.60, 0, 0, 1, 1, '2019-08-12 00:00:00', 10);
INSERT INTO `ants_goods_base` VALUES (1580745663, NULL, NULL, NULL, NULL, 0, 0.00, 0, 0, 1, 0, '2019-08-13 00:00:00', 0);

-- ----------------------------
-- Table structure for ants_goods_give
-- ----------------------------
DROP TABLE IF EXISTS `ants_goods_give`;
CREATE TABLE `ants_goods_give`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `goodsVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品商品的路径',
  `goodsClass` int(11) NULL DEFAULT NULL COMMENT '一个子类的id',
  `goodsPrice` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品的价格',
  `goodsState` int(11) NULL DEFAULT NULL COMMENT '0：未赠送  1：已赠送',
  `goodsBargin` int(11) NULL DEFAULT NULL COMMENT '0:可议价  1：不可议价',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '所属买家主键',
  `goodsWay` int(11) NULL DEFAULT NULL COMMENT '0:卖家送货上门  1:买家上门自取 2：可待商量',
  `uploadTime` datetime(0) NULL DEFAULT NULL COMMENT '发布赠送时间',
  `repertory` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_goods_give
-- ----------------------------
INSERT INTO `ants_goods_give` VALUES (1070420010, '9999', 'hello ', '1.jpg', '3.mp4', 4, 50.50, 0, 1, 1, 0, '2019-08-13 00:00:00', 10);

-- ----------------------------
-- Table structure for ants_goods_lease
-- ----------------------------
DROP TABLE IF EXISTS `ants_goods_lease`;
CREATE TABLE `ants_goods_lease`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `goodsVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品视频的路径',
  `goodsClass` int(11) NULL DEFAULT NULL COMMENT '一个子类的id',
  `goodsPrice` decimal(50, 0) NULL DEFAULT NULL COMMENT '商品的价格',
  `goodsState` int(11) NULL DEFAULT NULL COMMENT '0：未租赁  1：租赁中',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '所属买家主键',
  `uploadTime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `repertory` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_goods_lease
-- ----------------------------
INSERT INTO `ants_goods_lease` VALUES (1, 'czd', 'sss', '1.jpg', NULL, NULL, NULL, 1, 2, NULL, NULL);

-- ----------------------------
-- Table structure for ants_goods_seek
-- ----------------------------
DROP TABLE IF EXISTS `ants_goods_seek`;
CREATE TABLE `ants_goods_seek`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `goodsWay` int(11) NULL DEFAULT NULL,
  `goodsClass` int(11) NULL DEFAULT NULL COMMENT '一个子类的id',
  `goodsPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品的价格',
  `goosState` int(11) NULL DEFAULT NULL COMMENT '0：未租赁  1：租赁中',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '所属买家主键',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ants_management_announcement
-- ----------------------------
DROP TABLE IF EXISTS `ants_management_announcement`;
CREATE TABLE `ants_management_announcement`  (
  `annId` int(20) NOT NULL COMMENT '公告表编号',
  `annTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告的标题 ',
  `annContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告的内容',
  `annTime` datetime(0) NULL DEFAULT NULL COMMENT '公告发布的时间',
  PRIMARY KEY (`annId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_management_announcement
-- ----------------------------
INSERT INTO `ants_management_announcement` VALUES (20170525, '测试1', '测试内容：Hello World', '2019-05-02 16:14:54');
INSERT INTO `ants_management_announcement` VALUES (20180525, '测试2', '测试内容：Hello World', '2019-05-24 16:23:00');

-- ----------------------------
-- Table structure for ants_management_feedback
-- ----------------------------
DROP TABLE IF EXISTS `ants_management_feedback`;
CREATE TABLE `ants_management_feedback`  (
  `fbId` int(20) NOT NULL COMMENT '反馈编号',
  `userId` int(20) NULL DEFAULT NULL COMMENT '用户编号 ',
  `
fbContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈内容',
  `fbTime` datetime(0) NULL DEFAULT NULL COMMENT '反馈时间',
  `fbSatisfaction` int(20) NULL DEFAULT NULL COMMENT '满意度',
  `userMobile` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈人电话',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈人姓名',
  PRIMARY KEY (`fbId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ants_management_user
-- ----------------------------
DROP TABLE IF EXISTS `ants_management_user`;
CREATE TABLE `ants_management_user`  (
  `managerId` int(20) NOT NULL,
  `managerAccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `managerPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `managerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  PRIMARY KEY (`managerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ants_order_base
-- ----------------------------
DROP TABLE IF EXISTS `ants_order_base`;
CREATE TABLE `ants_order_base`  (
  `orderId` int(11) NOT NULL,
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '订单对应商品编号',
  `buyerId` int(11) NULL DEFAULT NULL COMMENT '买家的主键',
  `sellerId` int(11) NOT NULL COMMENT '卖家对应的主键',
  `buyerName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(买家)收货人姓名',
  `buyerAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '（买家）收货地址',
  `buyerPhone` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人的电话',
  `reciveTime` datetime(0) NULL DEFAULT NULL COMMENT '收货时间',
  `orderTime` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
  `orderPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `orderState` int(11) NULL DEFAULT NULL COMMENT '订单状态',
  `deliverWay` int(11) NULL DEFAULT NULL COMMENT '配送方式',
  PRIMARY KEY (`orderId`, `sellerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ants_other_sell
-- ----------------------------
DROP TABLE IF EXISTS `ants_other_sell`;
CREATE TABLE `ants_other_sell`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的名字',
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的描述',
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片的路径',
  `goodsClass` int(11) NULL DEFAULT NULL COMMENT '所属类别 子类',
  `goodsPrice` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品的价格',
  `goodsState` int(11) NULL DEFAULT NULL COMMENT '0:已出售  1：已赠送  2:已租赁',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '所属买家的主键',
  `sellTime` datetime(0) NULL DEFAULT NULL COMMENT '成功交易的时间 ',
  `numbers` int(11) NULL DEFAULT NULL COMMENT '交易数量',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_other_sell
-- ----------------------------
INSERT INTO `ants_other_sell` VALUES (1, 'hhh', 'hhhhhh', '1.jpg', 2, 5.06, 1, 1, '2019-08-27 19:58:00', 50);
INSERT INTO `ants_other_sell` VALUES (2, '44', '3', '.jpg', 4, 33.60, 3, 1, '2019-08-19 20:05:54', 60);

-- ----------------------------
-- Table structure for ants_other_trade
-- ----------------------------
DROP TABLE IF EXISTS `ants_other_trade`;
CREATE TABLE `ants_other_trade`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品视频的路径',
  `goodsClass` int(11) NULL DEFAULT NULL,
  `goodsPrice` decimal(50, 2) NULL DEFAULT NULL,
  `goodsState` int(11) NULL DEFAULT NULL COMMENT '0：普通商品  1：赠送商品 2：租赁商品',
  `goodsBargin` int(11) NULL DEFAULT NULL COMMENT '0:可议价  1：不可议价',
  `tradeState` int(11) NULL DEFAULT NULL COMMENT '交易类型 0代表买，1代表卖',
  `goodsBelong` int(11) NULL DEFAULT NULL COMMENT '卖家的主键',
  `goodsWay` int(11) NULL DEFAULT NULL COMMENT '0:卖家送货上门  1:买家上门自取 2：可待商量',
  `repertory` int(11) NULL DEFAULT NULL COMMENT '库存',
  `newChatTime` datetime(0) NULL DEFAULT NULL COMMENT '买卖双方最新聊天时间',
  `uploadTime` datetime(0) NULL DEFAULT NULL COMMENT '商品上传时间',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_other_trade
-- ----------------------------
INSERT INTO `ants_other_trade` VALUES (2, 'ad', 'sd', '1.jpg', NULL, 2, 52.50, 1, NULL, 2, 2, NULL, 50, '2019-08-06 06:59:57', NULL);

-- ----------------------------
-- Table structure for ants_shop_base
-- ----------------------------
DROP TABLE IF EXISTS `ants_shop_base`;
CREATE TABLE `ants_shop_base`  (
  `shopId` int(11) NOT NULL COMMENT '购物车id号',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户的id号',
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '商品的id号',
  `shopNum` int(11) NULL DEFAULT NULL COMMENT '加入购物车的数量',
  `goodsPrice` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品的价格',
  `joinTime` datetime(0) NULL DEFAULT NULL COMMENT '加入购物车时间',
  PRIMARY KEY (`shopId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ants_user_base
-- ----------------------------
DROP TABLE IF EXISTS `ants_user_base`;
CREATE TABLE `ants_user_base`  (
  `studentId` int(11) NOT NULL,
  `userName` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userSex` int(10) NULL DEFAULT NULL COMMENT '0:男  1：女',
  `passWord` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unpw` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'userNamePassWord',
  `mobilePhone` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易地址',
  `portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片',
  `userWechat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userQQ` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `registTime` datetime(0) NULL DEFAULT NULL,
  `qqHidden` int(11) NULL DEFAULT NULL COMMENT '0:不隐藏 1:隐藏',
  `wechatHidden` int(11) NULL DEFAULT NULL COMMENT '0:不隐藏 1:隐藏',
  PRIMARY KEY (`studentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ants_user_base
-- ----------------------------
INSERT INTO `ants_user_base` VALUES (1, 'user', 0, '123456', '123', '13106617928', '13栋905宿舍', '1.jpg', 'weiXing', '1783209601', '2019-06-06 00:00:00', 0, 1);
INSERT INTO `ants_user_base` VALUES (171543113, '陈彬', 1, '123155', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ants_user_base` VALUES (171543114, '陈杰灿', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ants_user_base` VALUES (171543115, '不认识', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ants_user_base` VALUES (171543119, '邓学洋', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ants_user_base` VALUES (171543144, '杨楷煜', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable`  (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
