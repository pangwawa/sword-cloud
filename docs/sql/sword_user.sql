/*
 Navicat Premium Data Transfer

 Source Server         : 121.4.71.199
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 121.4.71.199:3306
 Source Schema         : sword_user

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 29/06/2021 14:02:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author_info
-- ----------------------------
DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '作者ID',
  `author_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agipassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '临时密码',
  `avatar_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像图片',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  `vip_level` int(11) NULL DEFAULT NULL COMMENT '特权级别',
  `exp_value` int(11) NULL DEFAULT NULL COMMENT '经验值',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author_info
-- ----------------------------
INSERT INTO `author_info` VALUES (1, 1101, '测试者一', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, '', 10, 2, '2021-03-23 11:15:22', '2021-03-23 11:15:24');

SET FOREIGN_KEY_CHECKS = 1;
