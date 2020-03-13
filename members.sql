/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : petrolstation

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-03-13 16:39:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnumber` int(11) DEFAULT NULL COMMENT '会员卡号',
  `Membername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员姓名',
  `gender` int(11) DEFAULT NULL COMMENT '会员性别 0女，1男',
  `originalamount` float DEFAULT NULL COMMENT '原始金额',
  `Lplatenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车牌号码',
  `Vehicletype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车辆类型',
  `Vehicletypel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车辆型号',
  `phonenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `entity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单位名称',
  `carddate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '办卡日期',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系地址',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `Kaneamount` float(255,0) DEFAULT NULL COMMENT '卡内金额',
  `Topupamount` float DEFAULT NULL COMMENT '充值金额',
  `Topupdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '充值日期',
  `product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '油品名称',
  `numberof` float DEFAULT NULL COMMENT '数量',
  `unitprice` float DEFAULT NULL COMMENT '单价',
  `receivableamount` float DEFAULT NULL COMMENT '应收金额',
  `Paidin` float DEFAULT NULL COMMENT '实收金额',
  `Termsofpayment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '付款方式',
  `Comeontime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '加油时间',
  `currentbalance` float DEFAULT NULL COMMENT '当前余额',
  `initialamount` float DEFAULT NULL COMMENT '初始金额',
  `cumulative` float DEFAULT NULL COMMENT '累积消费',
  `accumulatedtopup` float DEFAULT NULL COMMENT '累积充值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of members
-- ----------------------------
