/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : example-security

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-11-30 18:08:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_browser_remember_me
-- ----------------------------
DROP TABLE IF EXISTS `t_browser_remember_me`;
CREATE TABLE `t_browser_remember_me` (
  `series` varchar(64) NOT NULL COMMENT '序号',
  `username` varchar(64) NOT NULL COMMENT '用户名称',
  `token` varchar(64) NOT NULL COMMENT 'token值',
  `last_user_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '最后用户登录时间',
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浏览器账号记录表';

-- ----------------------------
-- Records of t_browser_remember_me
-- ----------------------------
