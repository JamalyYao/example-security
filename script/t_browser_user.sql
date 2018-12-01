/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : example-security

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-11-30 18:09:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_browser_user
-- ----------------------------
DROP TABLE IF EXISTS `t_browser_user`;
CREATE TABLE `t_browser_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `user_nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `account` varchar(20) DEFAULT NULL COMMENT '登陆账号',
  `password` varchar(128) NOT NULL COMMENT '登陆密码',
  `mobile_no` varchar(16) DEFAULT NULL COMMENT '电话',
  `sex` char(1) DEFAULT NULL COMMENT '性别 0-男 1-女',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `is_freeze` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否冻结 0--未冻结 1--冻结',
  `last_login_ip` varchar(32) DEFAULT NULL COMMENT '最后登录IP',
  `last_login_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后登录时间',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `update_by` varchar(32) NOT NULL COMMENT '修改人',
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='浏览器用户信息表';

-- ----------------------------
-- Records of t_browser_user
-- ----------------------------
INSERT INTO `t_browser_user` VALUES ('1', '阿凡达', '盖世英雄', 'wangww@163.com', '123456', '15251005148', '0', 'http://www.photo.com', 'wangww@163.com', '0', '127.0.0.1', '2018-11-27 10:07:11.460', '2018-11-27 10:07:11.460', 'wangww', '2018-11-27 10:07:11.460', 'wangww', '0');
