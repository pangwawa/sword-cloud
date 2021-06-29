/*
 Navicat Premium Data Transfer

 Source Server         : 121.4.71.199
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 121.4.71.199:3306
 Source Schema         : sword_blog

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 29/06/2021 14:02:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_content
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章内容',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_content
-- ----------------------------
INSERT INTO `article_content` VALUES (1, 2001, '什么是Webservice\r\nWebService是一个SOA（面向服务的编程）的架构，它是不依赖于语言，不依赖于平台，可以实现不同的语言间的相互调用，通过Internet进行基于Http协议的网络应用间的交互。 其实WebService并不是什么神秘的东西，它就是一个可以远程调用的类，或者说是组件，把你本地的功能开放出去共别人调用。\r\n\r\nHttpClient和WebService的区别\r\n二者都是调用对方服务接口，区别在于：\r\n\r\nHttpClient用来调用服务，它是模拟一个浏览器，发送Http的请求，服务器会返回请求的一个响应结果，Httpclient然后把响应的结果取出来。HttpClinet相当于一个客户端，使用Http协议调用系统中的方法或者接口。\r\nwebService是使用soap协议而不是Http协议。\r\n什么是soap协议\r\nSOAP 是基于 XML 的简易协议，可使应用程序在 HTTP 之上进行信息交换。或者更简单地说：SOAP 是用于访问网络服务的协议。', '2021-03-23 11:13:32', '2021-03-23 11:13:34');

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  `abstract_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章封面图片',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `article_abstract` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章简介',
  `pv` bigint(20) NULL DEFAULT NULL COMMENT '浏览量',
  `article_status` tinyint(4) UNSIGNED NULL DEFAULT 1 COMMENT '状态，0：删除，1,未发布（草稿）2，私有，3，已发布，4，被禁止传播',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '作者ID',
  `author_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者名称',
  `type` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '文章类型',
  `like_num` bigint(20) NULL DEFAULT NULL COMMENT '点赞数',
  `comments_num` bigint(20) NULL DEFAULT NULL COMMENT '评论数',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES (1, 2001, 'https://double.aquestian.cn/2021-03-06-20-22-18-ffmpeg.png', '测试标题', '测试简介内容', 10, 1, 1101, '测试者一', 1, 1, 1, '2021-03-23 11:10:50', '2021-03-23 11:10:54');

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  `tag_id` int(11) NULL DEFAULT NULL COMMENT '标签ID',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 2001, 301, '2021-03-23 11:17:44', '2021-03-23 11:17:48');

-- ----------------------------
-- Table structure for article_type_info
-- ----------------------------
DROP TABLE IF EXISTS `article_type_info`;
CREATE TABLE `article_type_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型代号',
  `value` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_type_info
-- ----------------------------
INSERT INTO `article_type_info` VALUES (1, 1, '技术', '2021-03-23 11:18:45', '2021-03-23 11:18:48');

-- ----------------------------
-- Table structure for comments_info
-- ----------------------------
DROP TABLE IF EXISTS `comments_info`;
CREATE TABLE `comments_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '评论者的ID',
  `comment_status` tinyint(4) NULL DEFAULT 1 COMMENT '评论状态，1：正常，0删除',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments_info
-- ----------------------------
INSERT INTO `comments_info` VALUES (1, 2001, '真不错', 1101, 1, '2021-03-23 11:19:41', '2021-03-23 11:19:44');

-- ----------------------------
-- Table structure for like_info
-- ----------------------------
DROP TABLE IF EXISTS `like_info`;
CREATE TABLE `like_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '点赞者的ID',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like_info
-- ----------------------------
INSERT INTO `like_info` VALUES (1, 2001, 1101, '2021-03-23 11:20:05', '2021-03-23 11:20:08');

-- ----------------------------
-- Table structure for tag_info
-- ----------------------------
DROP TABLE IF EXISTS `tag_info`;
CREATE TABLE `tag_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '表主键',
  `tag_id` int(11) NULL DEFAULT NULL COMMENT '标签ID',
  `tag_value` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签值',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '归属的用户ID',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag_info
-- ----------------------------
INSERT INTO `tag_info` VALUES (1, 301, '网络协议', 1101, '2021-03-23 11:17:30', '2021-03-23 11:17:35');

SET FOREIGN_KEY_CHECKS = 1;
