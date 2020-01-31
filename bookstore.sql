/*
Navicat MySQL Data Transfer

Source Server         : sa
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-12-29 19:21:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(200) NOT NULL,
  `booktype` varchar(200) NOT NULL,
  `author` varchar(20) NOT NULL,
  `translate` varchar(20) NOT NULL,
  `price` varchar(200) NOT NULL,
  `page` varchar(20) NOT NULL,
  `publish` varchar(50) NOT NULL,
  `barcode` varchar(20) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('10', '钢铁是怎样炼成的', '励志', '保尔柯察金', '李一凡', '99', '193', '湖南图书出版社', '785462248');
INSERT INTO `bookinfo` VALUES ('11', '黑暗宝典', '魔法', '瓦龙', '李希', '999', '500', '黑影兵团出版社', '369782477');
INSERT INTO `bookinfo` VALUES ('12', '维山帝之书', '魔法', '永恒', '古一', '789', '1050', '生命法庭出版社', '995836451');
INSERT INTO `bookinfo` VALUES ('13', '符文之书', '魔法', '索尔', '瑞兹', '636', '780', '巨神峰出版社', '567824968');
INSERT INTO `bookinfo` VALUES ('14', '大话数据结构', '计算机', '程杰', '李四', '25', '198', '湖南图书出版社', '773625794');
INSERT INTO `bookinfo` VALUES ('15', '屠龙宝典', '武侠', '亚历山大', '王五', '15', '897', '圣城出版社', '458925783');
INSERT INTO `bookinfo` VALUES ('16', '长生界', '武侠', '耳根', '李四', '98', '864', '唐山出版社', '691797357');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `bwid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `borrowtime` date NOT NULL,
  `repaytime` date NOT NULL,
  `ifbook` int(11) NOT NULL,
  PRIMARY KEY (`bwid`),
  KEY `reader_borrow` (`rid`),
  KEY `bookinfo_borrow` (`bid`),
  CONSTRAINT `bookinfo_borrow` FOREIGN KEY (`bid`) REFERENCES `bookinfo` (`bid`),
  CONSTRAINT `reader_borrow` FOREIGN KEY (`rid`) REFERENCES `reader` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('22', '3', '12', '2019-09-19', '2019-11-08', '2');
INSERT INTO `borrow` VALUES ('26', '3', '14', '2019-09-19', '2019-11-13', '2');
INSERT INTO `borrow` VALUES ('27', '3', '14', '2019-12-29', '2020-01-01', '2');
INSERT INTO `borrow` VALUES ('28', '3', '15', '2019-12-29', '2020-01-16', '1');
INSERT INTO `borrow` VALUES ('29', '3', '10', '2019-12-29', '2020-01-01', '1');

-- ----------------------------
-- Table structure for borrowtime
-- ----------------------------
DROP TABLE IF EXISTS `borrowtime`;
CREATE TABLE `borrowtime` (
  `btid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`btid`),
  KEY `book` (`bid`),
  CONSTRAINT `book` FOREIGN KEY (`bid`) REFERENCES `bookinfo` (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowtime
-- ----------------------------
INSERT INTO `borrowtime` VALUES ('1', '10', '4');
INSERT INTO `borrowtime` VALUES ('2', '11', '1');
INSERT INTO `borrowtime` VALUES ('3', '12', '16');
INSERT INTO `borrowtime` VALUES ('4', '13', '2');
INSERT INTO `borrowtime` VALUES ('5', '14', '24');
INSERT INTO `borrowtime` VALUES ('6', '15', '5');

-- ----------------------------
-- Table structure for givebook
-- ----------------------------
DROP TABLE IF EXISTS `givebook`;
CREATE TABLE `givebook` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `backtime` date NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `give_reader` (`rid`),
  KEY `give_bookinfo` (`bid`),
  CONSTRAINT `give_bookinfo` FOREIGN KEY (`bid`) REFERENCES `bookinfo` (`bid`),
  CONSTRAINT `give_reader` FOREIGN KEY (`rid`) REFERENCES `reader` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of givebook
-- ----------------------------

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(11) NOT NULL,
  `barcode` varchar(30) NOT NULL,
  `birthday` date NOT NULL,
  `papertype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paperno` varchar(20) NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `readtype_reader` (`typeid`),
  CONSTRAINT `readtype_reader` FOREIGN KEY (`typeid`) REFERENCES `readtype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('3', '1', '张三', '1', '78632312', '1998-03-19', '身份证', '430521199');

-- ----------------------------
-- Table structure for readtype
-- ----------------------------
DROP TABLE IF EXISTS `readtype`;
CREATE TABLE `readtype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readtype
-- ----------------------------
INSERT INTO `readtype` VALUES ('1', '学生', '2');
INSERT INTO `readtype` VALUES ('2', '程序员', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'lisi@qq.com', '123456');
INSERT INTO `user` VALUES ('7', 'lisiwu', 'admin');
INSERT INTO `user` VALUES ('8', 'admin', 'admin');
INSERT INTO `user` VALUES ('9', 'zhangsan', '043d8b6cb8c674e9985ce07aab0ad512');
