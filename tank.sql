/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : petrolstation

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-03-13 16:40:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tank
-- ----------------------------
DROP TABLE IF EXISTS `tank`;
CREATE TABLE `tank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameoftank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '油罐名称',
  `product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '油品名称',
  `categories` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '油品种类',
  `Inventorytonnage` float(255,0) DEFAULT NULL COMMENT '库存吨数',
  `Conversionratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '转换比例',
  `Inventoryfloor` float(11,0) DEFAULT NULL COMMENT '库存下限',
  `Stockupseveral` float(11,0) DEFAULT NULL COMMENT '库存升数',
  `retailprice` float(11,0) DEFAULT NULL COMMENT '零售价格',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `Dateregistration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登记日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tank
-- ----------------------------
