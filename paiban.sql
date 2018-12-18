/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : paiban

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 30/10/2018 18:46:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ISDELETE` bit(1) NULL DEFAULT b'0'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', 'admin', b'0');

-- ----------------------------
-- Table structure for paiban
-- ----------------------------
DROP TABLE IF EXISTS `paiban`;
CREATE TABLE `paiban`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PeopleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Month` int(4) NULL DEFAULT 1,
  `Day` int(2) NULL DEFAULT 1,
  `Year` int(4) NULL DEFAULT 1900,
  `Remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `Date` date NULL DEFAULT '1900-01-01',
  `ISDELETE` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 209 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `peoplename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IsDelete` bit(1) NULL DEFAULT b'0',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES (1, '左1', b'0');
INSERT INTO `people` VALUES (2, '李1', b'0');
INSERT INTO `people` VALUES (3, '吴1', b'0');
INSERT INTO `people` VALUES (4, '陈1', b'0');
INSERT INTO `people` VALUES (5, '刘1', b'0');

SET FOREIGN_KEY_CHECKS = 1;
