/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : example-security

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-11-30 18:08:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_browser_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_browser_permission`;
CREATE TABLE `t_browser_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `perm_name` varchar(64) NOT NULL COMMENT '资源名',
  `remark` varchar(256) DEFAULT NULL COMMENT '描述',
  `url` varchar(1024) DEFAULT NULL COMMENT '菜单链接',
  `icon` varchar(64) DEFAULT NULL COMMENT '图标',
  `permission` varchar(256) DEFAULT NULL COMMENT '关联资源（后台接口/权限字符串等）',
  `p_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属上级',
  `is_display` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示 0--显示 1--显示',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `type` tinyint(4) NOT NULL COMMENT '类型 1--页面 2--动作',
  `method` varchar(32) NOT NULL DEFAULT 'ALL' COMMENT '动作方法 ALL POST GET PUT',
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
  `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
  `update_by` varchar(32) NOT NULL COMMENT '修改人',
  `create_by` varchar(32) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_perm_name` (`perm_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='浏览器权限信息表';

-- ----------------------------
-- Records of t_browser_permission
-- ----------------------------
INSERT INTO `t_browser_permission` VALUES ('1', '系统管理', '系统管理', null, null, null, '0', '1', '1', '1', 'ALL', '2018-11-28 16:42:40.024', '2018-11-28 16:42:40.024', '0', 'admin', 'admin');
INSERT INTO `t_browser_permission` VALUES ('2', '用户管理', '用户管理', '/user/me', 'iconfont icon-user', 'sys:user:list', '0', '1', '1', '1', 'ALL', '2018-11-28 16:44:42.727', '2018-11-28 16:48:49.608', '0', 'wangww', 'wangww');
