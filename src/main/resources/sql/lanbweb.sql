/*
Navicat MySQL Data Transfer

Source Server         : 本地ROOT
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : lanbweb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-10-18 11:55:47
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
INSERT INTO `code_info` VALUES ('122a3157be9c4bf1aa615bf3e0073d8c', '5bc7e2b50f1344c6b46e3f9e430acab8', '异常', '1', '0');
INSERT INTO `code_info` VALUES ('76d297c2b8b84f85b0e8954175185e7e', '64178638698a4524bac6546608821f8e', '否', '0', '1');
INSERT INTO `code_info` VALUES ('831d632e5e134da9ba923b496407f04b', '5bc7e2b50f1344c6b46e3f9e430acab8', '正常', '0', '0');
INSERT INTO `code_info` VALUES ('90e3138704fd47778669ba91484ac17f', '64178638698a4524bac6546608821f8e', '是', '1', '0');

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
INSERT INTO `code_type` VALUES ('5bc7e2b50f1344c6b46e3f9e430acab8', 'status');
INSERT INTO `code_type` VALUES ('64178638698a4524bac6546608821f8e', 'yesOrNo');

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
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `demo_id` varchar(255) NOT NULL DEFAULT '' COMMENT '例子ID',
  `demo_name` varchar(255) DEFAULT '' COMMENT '例子名',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`demo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', '1', '2018-08-12 23:54:03');

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
INSERT INTO `menu` VALUES ('10', '菜单设置', '2', 'menu/menuSetting', '2', '1');
INSERT INTO `menu` VALUES ('160f069b7b634bfb9cc180da3dfd5cc6', '机构管理', '2', '', '1', null);
INSERT INTO `menu` VALUES ('2', '系统设置', '', 'sys', '5', null);
INSERT INTO `menu` VALUES ('29827f4b8ee84dccac60852400a697f6', '会员管理', '1', 'user/userManager', '1', null);
INSERT INTO `menu` VALUES ('2a68d7f2e810416dace5cbff5fa26479', '代码信息', 'eb4bba91d1794771a2ddb89c7f4fb87a', 'codeInfo/codeInfoSetting', '4', null);
INSERT INTO `menu` VALUES ('30686dfdb7be4677b349342a66b75369', '机构管理', '160f069b7b634bfb9cc180da3dfd5cc6', 'org/orgManager', '0', null);
INSERT INTO `menu` VALUES ('3488cf3be05446cf84224dbf98026d1c', '消息管理', '2', 'msg/msgManager', '0', null);
INSERT INTO `menu` VALUES ('349cb244e3e64a0a92a6721879f624d4', '代码生成', '', '', '0', null);
INSERT INTO `menu` VALUES ('5ec948da02e3460d8aef006dcf837427', '用户角色管理', 'c96f059ac3374c519ee69943109b555b', 'roleUser/roleUserManager', '0', null);
INSERT INTO `menu` VALUES ('bc509ab9234d4793b0e86efd89a15e2d', '测试设置', '349cb244e3e64a0a92a6721879f624d4', 'test/testManager', '0', null);
INSERT INTO `menu` VALUES ('c96f059ac3374c519ee69943109b555b', '角色管理', '1', '', '0', null);
INSERT INTO `menu` VALUES ('ea337b1ab99a4f8abf45e67829eb5cbb', '代码生成器', '349cb244e3e64a0a92a6721879f624d4', 'creater', '1', null);
INSERT INTO `menu` VALUES ('eb4bba91d1794771a2ddb89c7f4fb87a', '代码设置', '2', '', '4', null);
INSERT INTO `menu` VALUES ('efe548ea98e24854b9a60e5acd36a3f4', '角色设置', 'c96f059ac3374c519ee69943109b555b', 'role/roleManager', '0', null);
INSERT INTO `menu` VALUES ('fbc8d54cdb814d9781f3d27236beea53', '系统设置', '2', 'config/configManager', '0', null);

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
INSERT INTO `role` VALUES ('5e0320d9c2904ee298e9e9b1b2191684', 'user', '', '', '0', '2018-08-29 23:22:12');
INSERT INTO `role` VALUES ('5e0320d9c2904ee298e9e9b1b2191685', 'admin', '', '', '0', '2018-08-29 23:22:12');

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
INSERT INTO `role_user` VALUES ('512308ca81094211964e9354cafc842c', '5e0320d9c2904ee298e9e9b1b2191684', '1', '2018-08-30 14:45:55');
INSERT INTO `role_user` VALUES ('cb23c830d5434f84aaec5bef0fc63465', '5e0320d9c2904ee298e9e9b1b2191684', '1', '2018-08-30 11:17:38');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` varchar(255) NOT NULL COMMENT '测试ID',
  `test_name` varchar(255) DEFAULT '' COMMENT '测试名',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('01a0e54ec2b5425b83f978b249484b14', '测试143426734', '2018-08-22 00:00:03');
INSERT INTO `test` VALUES ('4b9c7ee627714288831175be110d030e', '测试数据2', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('665c29626ce1400b9983cbbf6540d427', '测试-1345641338', '2018-08-13 00:00:00');
INSERT INTO `test` VALUES ('82c0b5e767b64511ae090898b0df69a6', '测试数据1', '2018-07-09 00:00:00');
INSERT INTO `test` VALUES ('83ae005933d249cb87ab5e6df52434df', '测试', '2018-08-30 10:43:30');
INSERT INTO `test` VALUES ('ae48f4d4b9de4bd588d601f9ecc3657f', '测试1635560001', '2018-08-13 00:00:00');
INSERT INTO `test` VALUES ('ba4db6145a8b466f9be0e72228dcbddd', '测试776799309', '2018-08-12 00:00:00');
INSERT INTO `test` VALUES ('babb8903f31740108fdb303d328852c7', '测试-1788136031', '2018-08-13 00:00:00');
INSERT INTO `test` VALUES ('ca147d48e27743998626bf8a3dd866c9', '测试-1444069085', '2018-08-12 00:00:00');
INSERT INTO `test` VALUES ('cffe7e85244f4811b9763f6ce5885d63', '测试-2064463233', '2018-08-13 00:00:00');
INSERT INTO `test` VALUES ('e0d229e6aa984161a738af1d94fb92fe', '1', '2018-08-11 00:00:00');
INSERT INTO `test` VALUES ('e1350c8c991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1476f8e991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e153256b991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e162e2be991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1706c6f991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e178b20b991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1817e7d991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e18b66c4991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e193cb64991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1a078a0991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1a9ca8f991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1b265f8991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1bae5df991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1c4e49f991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1cd64ae991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1d5dd35991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1de2a86991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1e6a3e8991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1ef2a22991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e1f94ded991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e201defb991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e20a2a96991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e2127fda991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e21b003e991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e222cb92991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e22a3b2d991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e232c334991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e23b3a2e991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e2439b8f991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e24bede5991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e2560956991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');
INSERT INTO `test` VALUES ('e25e9b86991b11e88384f8a9639f5919', '测试数据', '2018-07-06 00:00:00');

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
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2018-07-31 23:34:18', '2018-07-31 23:34:16', '1', '1');
INSERT INTO `user` VALUES ('45fdc5a5fcc7405aba3bf790eeaae5e0', 'test', '098f6bcd4621d373cade4e832627b4f6', '2018-08-30 10:38:47', '2018-08-30 10:38:47', '0', '1');

-- ----------------------------
-- Function structure for getChildLst
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildLst`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
			DECLARE sTemp VARCHAR(1000);
			DECLARE sTempChd VARCHAR(1000);

			SET sTemp = '$';
			SET sTempChd =cast(rootId as CHAR);

			WHILE sTempChd is not null DO
				SET sTemp = concat(sTemp,',',sTempChd);
				SELECT group_concat(menu_id) INTO sTempChd FROM menu where FIND_IN_SET(parent_menu_id,sTempChd)>0;
			END WHILE;
			RETURN sTemp;
		END
;;
DELIMITER ;
