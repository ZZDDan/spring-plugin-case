/*
Navicat MySQL Data Transfer

Source Server         : mysql5.6
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : dubbo-demo

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-05-24 15:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `user_type` tinyint(1) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '张丹', '1', '20', '1');
