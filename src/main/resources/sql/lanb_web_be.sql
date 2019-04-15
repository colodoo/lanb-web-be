/*
Navicat MySQL Data Transfer

Source Server         : 本地ROOT
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : lanb_web_be

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-04-15 10:47:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for code_info
-- ----------------------------
DROP TABLE IF EXISTS `code_info`;
CREATE TABLE `code_info` (
  `code_info_id` varchar(255) NOT NULL COMMENT '代码信息ID',
  `code_type_id` varchar(255) DEFAULT NULL COMMENT '代码类型ID',
  `name` varchar(255) DEFAULT NULL COMMENT '代码名',
  `value` varchar(255) DEFAULT NULL COMMENT '代码值',
  `sort` int(255) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`code_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_info
-- ----------------------------
INSERT INTO `code_info` VALUES ('122a3157be9c4bf1aa615bf3e0073d8c', 'status', '异常', '1', '0');
INSERT INTO `code_info` VALUES ('76d297c2b8b84f85b0e8954175185e7e', 'yesOrNo', '否', '0', '1');
INSERT INTO `code_info` VALUES ('831d632e5e134da9ba923b496407f04b', 'status', '正常', '0', '0');
INSERT INTO `code_info` VALUES ('90e3138704fd47778669ba91484ac17f', 'yesOrNo', '是', '1', '0');
INSERT INTO `code_info` VALUES ('a257ba2f09c54a9da9fc250522076a13', 'orderStatus', '已废弃', '4', '4');
INSERT INTO `code_info` VALUES ('b10703ab5753466bacae990569c3bc58', 'orderStatus', '待处理', '2', '2');
INSERT INTO `code_info` VALUES ('c0d29570c34d4af297d2d85a5cd63ab0', 'orderStatus', '待受理', '1', '1');
INSERT INTO `code_info` VALUES ('e5145294f4e542f5a917b0d1eed7cb37', 'orderStatus', '已完成', '3', '3');

-- ----------------------------
-- Table structure for code_type
-- ----------------------------
DROP TABLE IF EXISTS `code_type`;
CREATE TABLE `code_type` (
  `code_type_id` varchar(255) NOT NULL DEFAULT '' COMMENT '代码类型ID',
  `code_type_name` varchar(255) DEFAULT NULL COMMENT '代码类型名',
  PRIMARY KEY (`code_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_type
-- ----------------------------
INSERT INTO `code_type` VALUES ('orderStatus', 'orderStatus');
INSERT INTO `code_type` VALUES ('status', 'status');
INSERT INTO `code_type` VALUES ('yesOrNo', 'yesOrNo');

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `config_id` varchar(255) NOT NULL COMMENT '配置ID',
  `config_name` varchar(255) DEFAULT NULL COMMENT '配置名',
  `config_value` varchar(255) DEFAULT NULL COMMENT '配置值',
  `sort_no` int(11) DEFAULT '0' COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', 'systemName', 'LanbWeb', '0', '2018-08-28 17:18:58', '系统名称');
INSERT INTO `config` VALUES ('2', 'uploadPath', '/upload', '0', '2018-10-18 11:48:49', '上传文件路径');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_id` varchar(255) NOT NULL COMMENT '日志ID',
  `log_type` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `log_source` varchar(255) DEFAULT NULL COMMENT '日志来源',
  `log_content` varchar(255) DEFAULT NULL COMMENT '日志内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('b9445a44811d4b56b3791b366f4203c8', 'LOGIN_FAILD', '0:0:0:0:0:0:0:1', '登录失败', '2019-02-13 17:08:17');
INSERT INTO `log` VALUES ('bfae625dfb7a4f2d958daf1d15b78afe', 'LOGIN_FAILD', '0:0:0:0:0:0:0:1', '登录失败', '2019-02-13 17:08:13');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` varchar(255) NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单名称',
  `parent_menu_id` varchar(255) DEFAULT '' COMMENT '父菜单ID',
  `menu_url` varchar(255) DEFAULT '' COMMENT '菜单地址',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `visible` int(11) DEFAULT '0' COMMENT '是否可见',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('0dfa166cc12048c1b52d41f9bc088ac0', '日志管理', '2', 'log/logManager', '0', null);
INSERT INTO `menu` VALUES ('1', '会员中心', '', 'user', '1', null);
INSERT INTO `menu` VALUES ('10', '菜单设置', '2', 'pages/sys/menu/menuList.html', '2', '1');
INSERT INTO `menu` VALUES ('160f069b7b634bfb9cc180da3dfd5cc6', '机构管理', '2', '', '1', null);
INSERT INTO `menu` VALUES ('2', '系统设置', '', 'sys', '5', null);
INSERT INTO `menu` VALUES ('29827f4b8ee84dccac60852400a697f6', '会员管理', '1', 'user/userManager', '1', null);
INSERT INTO `menu` VALUES ('2a68d7f2e810416dace5cbff5fa26479', '代码信息', 'eb4bba91d1794771a2ddb89c7f4fb87a', 'codeInfo/codeInfoSetting', '4', null);
INSERT INTO `menu` VALUES ('30686dfdb7be4677b349342a66b75369', '机构管理', '160f069b7b634bfb9cc180da3dfd5cc6', 'org/orgManager', '0', null);
INSERT INTO `menu` VALUES ('3488cf3be05446cf84224dbf98026d1c', '消息管理', '2', 'msg/msgManager', '0', null);
INSERT INTO `menu` VALUES ('349cb244e3e64a0a92a6721879f624d4', '代码生成', '', '', '0', null);
INSERT INTO `menu` VALUES ('5ec948da02e3460d8aef006dcf837427', '用户角色管理', 'c96f059ac3374c519ee69943109b555b', 'roleUser/roleUserManager', '0', null);
INSERT INTO `menu` VALUES ('bc509ab9234d4793b0e86efd89a15e2d', '测试设置', '349cb244e3e64a0a92a6721879f624d4', 'pages/tables/data.html', '0', null);
INSERT INTO `menu` VALUES ('c96f059ac3374c519ee69943109b555b', '角色管理', '1', '', '0', null);
INSERT INTO `menu` VALUES ('cbf460c36a3b458bad8be774c4904564', '工单信息管理', '349cb244e3e64a0a92a6721879f624d4', 'ordersInfo/ordersInfoManager', '0', null);
INSERT INTO `menu` VALUES ('ea337b1ab99a4f8abf45e67829eb5cbb', '代码生成器', '349cb244e3e64a0a92a6721879f624d4', 'creater', '1', null);
INSERT INTO `menu` VALUES ('eb4bba91d1794771a2ddb89c7f4fb87a', '代码设置', '2', '', '4', null);
INSERT INTO `menu` VALUES ('efe548ea98e24854b9a60e5acd36a3f4', '角色设置', 'c96f059ac3374c519ee69943109b555b', 'role/roleManager', '0', null);
INSERT INTO `menu` VALUES ('f8ffee28176c482fb02252aa312169fb', '工单管理', '349cb244e3e64a0a92a6721879f624d4', 'orders/ordersManager', '0', null);
INSERT INTO `menu` VALUES ('fbc8d54cdb814d9781f3d27236beea53', '系统设置', '2', 'pages/sys/config/configList.html', '0', null);

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `msg_id` varchar(255) NOT NULL COMMENT '消息ID',
  `msg_title` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `msg_source` varchar(255) DEFAULT NULL COMMENT '消息来源',
  `msg_destination` varchar(255) DEFAULT NULL COMMENT '消息目标',
  `last_time` datetime DEFAULT NULL COMMENT '最后更新',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('1', '测试消息', 'admin', 'admin', '2018-08-31 17:11:00', '2018-08-31 17:11:00');
INSERT INTO `msg` VALUES ('2', '测试消息', 'admin', 'admin', '2018-08-31 17:11:00', '2018-08-31 17:11:00');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` varchar(32) NOT NULL COMMENT '工单ID',
  `orders_title` varchar(255) DEFAULT NULL COMMENT '工单标题',
  `orders_status` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `orders_info_id` varchar(32) DEFAULT NULL COMMENT '工单信息ID',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建工单人ID',
  `create_time` datetime DEFAULT NULL COMMENT '工单创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '工单更新时间',
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('19ebf4ff-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('19f7216c-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a080bc8-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a134856-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a1bccb7-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a267606-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a31aabb-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a411100-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a4bfe3d-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a54e800-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a628682-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a694459-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a721a3d-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a7d10ae-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a851d46-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a9418f7-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1a9b3b32-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1aa2be26-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1aad86de-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1ab581ae-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1ac07aca-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1ac82ed9-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1ad1d545-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1adafc6c-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1ae64603-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1aee4a84-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1af794cb-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b040454-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b0bec00-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b14e952-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b1fc9bb-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b29947e-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b309a92-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b3c23a1-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b444736-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b578a2b-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);
INSERT INTO `orders` VALUES ('1b605a02-4701-11e9-9f95-f8a9639f', '1', '1', '1', '1', null, null);

-- ----------------------------
-- Table structure for orders_info
-- ----------------------------
DROP TABLE IF EXISTS `orders_info`;
CREATE TABLE `orders_info` (
  `orders_info_id` varchar(32) NOT NULL COMMENT '工单信息ID',
  `title` varchar(255) DEFAULT NULL COMMENT '工单标题',
  `content` varchar(255) DEFAULT NULL COMMENT '工单内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`orders_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_info
-- ----------------------------
INSERT INTO `orders_info` VALUES ('1', '1', '1', '2019-03-15 16:12:31', '2019-03-15 16:12:29');

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `org_id` varchar(255) NOT NULL COMMENT '机构ID',
  `org_name` varchar(255) DEFAULT NULL COMMENT '机构名',
  `parent_org_id` varchar(255) DEFAULT NULL COMMENT '父机构ID',
  `sort_no` int(11) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('81a36528acea4791a5c044f19ad59d92', '居委会', '', '0', '2018-08-31 10:27:27');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(255) NOT NULL COMMENT '角色ID',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `options` varchar(255) DEFAULT NULL COMMENT '角色配置项',
  `parent_role_id` varchar(255) DEFAULT NULL COMMENT '父角色ID',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin', 'admin', '', '', '0', '2018-08-29 23:22:12');
INSERT INTO `role` VALUES ('user', 'user', '', '', '0', '2018-08-29 23:22:12');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `role_user_id` varchar(255) NOT NULL COMMENT '角色用户ID',
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色ID',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('512308ca81094211964e9354cafc842c', 'user', '21232f297a57a5a743894a0e4a801fc3', '2018-08-30 14:45:55');
INSERT INTO `role_user` VALUES ('cb23c830d5434f84aaec5bef0fc63465', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2018-08-30 11:17:38');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` varchar(255) NOT NULL COMMENT '测试ID',
  `test_name` varchar(255) DEFAULT '' COMMENT '测试名',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('01a0e54ec2b5425b83f978b249484b14', '测试143426734', '2018-08-22');
INSERT INTO `test` VALUES ('4b9c7ee627714288831175be110d030e', '测试数据2', '2018-07-06');
INSERT INTO `test` VALUES ('665c29626ce1400b9983cbbf6540d427', '测试-1345641338', '2018-08-13');
INSERT INTO `test` VALUES ('82c0b5e767b64511ae090898b0df69a6', '测试数据1', '2018-07-09');
INSERT INTO `test` VALUES ('83ae005933d249cb87ab5e6df52434df', '测试', '2018-08-30');
INSERT INTO `test` VALUES ('ae48f4d4b9de4bd588d601f9ecc3657f', '测试1635560001', '2018-08-13');
INSERT INTO `test` VALUES ('ba4db6145a8b466f9be0e72228dcbddd', '测试776799309', '2018-08-12');
INSERT INTO `test` VALUES ('babb8903f31740108fdb303d328852c7', '测试-1788136031', '2018-08-13');
INSERT INTO `test` VALUES ('ca147d48e27743998626bf8a3dd866c9', '测试-1444069085', '2018-08-12');
INSERT INTO `test` VALUES ('cffe7e85244f4811b9763f6ce5885d63', '测试-2064463233', '2018-08-13');
INSERT INTO `test` VALUES ('e0d229e6aa984161a738af1d94fb92fe', '1', '2018-08-11');
INSERT INTO `test` VALUES ('e1350c8c991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1476f8e991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e153256b991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e162e2be991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1706c6f991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e178b20b991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1817e7d991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e18b66c4991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e193cb64991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1a078a0991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1a9ca8f991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1b265f8991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1bae5df991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1c4e49f991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1cd64ae991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1d5dd35991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1de2a86991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1e6a3e8991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1ef2a22991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e1f94ded991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e201defb991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e20a2a96991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e2127fda991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e21b003e991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e222cb92991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e22a3b2d991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e232c334991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e23b3a2e991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e2439b8f991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e24bede5991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e2560956991b11e88384f8a9639f5919', '测试数据', '2018-07-06');
INSERT INTO `test` VALUES ('e25e9b86991b11e88384f8a9639f5919', '测试数据', '2018-07-06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL COMMENT '用户ID',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_date` datetime DEFAULT NULL COMMENT '最后修改',
  `try_count` int(11) DEFAULT '0' COMMENT '尝试登录次数',
  `enable` tinyint(4) DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`user_id`,`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0ffe4877d7bd41e0986778862fdda5ed', 'anymouse', '2db7dc272caf9844f1677ec0b5be76d9', '2018-08-12 23:08:52', '2018-08-12 23:08:52', '0', '1');
INSERT INTO `user` VALUES ('21232f297a57a5a743894a0e4a801fc3', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2018-07-31 23:34:18', '2018-07-31 23:34:16', '5', '1');
INSERT INTO `user` VALUES ('45fdc5a5fcc7405aba3bf790eeaae5e0', 'test', '098f6bcd4621d373cade4e832627b4f6', '2018-08-30 10:38:47', '2018-08-30 10:38:47', '2', '1');
