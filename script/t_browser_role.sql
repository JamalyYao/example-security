/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : example-security

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-11-30 18:08:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_browser_role
-- ----------------------------
DROP TABLE IF EXISTS `t_browser_role`;
CREATE TABLE `t_browser_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `status` char(1) DEFAULT NULL COMMENT '状态  Y-启用 N-禁用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
  `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='浏览器角色信息表';

-- ----------------------------
-- Records of t_browser_role
-- ----------------------------
INSERT INTO `t_browser_role` VALUES ('1', '管理员', 'M001', '0', '所有权限', '2018-11-28 16:37:08.894', '2018-11-28 16:37:08.894', '0');
