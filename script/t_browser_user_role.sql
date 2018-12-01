/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : example-security

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-11-30 18:09:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_browser_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_browser_user_role`;
CREATE TABLE `t_browser_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='浏览器用户角色信息表';

-- ----------------------------
-- Records of t_browser_user_role
-- ----------------------------
INSERT INTO `t_browser_user_role` VALUES ('1', '1', '1', '2018-11-28 16:37:31.135');
