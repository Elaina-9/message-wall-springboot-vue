/*
 Navicat Premium Dump SQL

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 03/12/2024 21:43:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for avatar
-- ----------------------------
DROP TABLE IF EXISTS `avatar`;
CREATE TABLE `avatar`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `timestamp` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of avatar
-- ----------------------------
INSERT INTO `avatar` VALUES ('1', '1d613bbd-424a-4639-b533-76ab2bd56745.png', '2024-11-28 15:40:28');
INSERT INTO `avatar` VALUES ('2', 'f614f022-855e-4766-8759-91a248a88cd5.jpg', '2024-11-29 09:46:12');
INSERT INTO `avatar` VALUES ('3', 'fabc7ec4-f42b-4ace-8776-5f1a8fcd91dc.png', '2024-11-29 09:47:59');
INSERT INTO `avatar` VALUES ('4', '51f5a032-2139-4366-a9ae-e0f03427375d.png', '2024-11-29 10:34:48');

-- ----------------------------
-- Table structure for liked
-- ----------------------------
DROP TABLE IF EXISTS `liked`;
CREATE TABLE `liked`  (
  `id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liked
-- ----------------------------
INSERT INTO `liked` VALUES ('1', '2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8');
INSERT INTO `liked` VALUES ('2', '2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8');
INSERT INTO `liked` VALUES ('3', '2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8');
INSERT INTO `liked` VALUES ('3', 'd222f7f5-57aa-4301-98c3-6b544d1a94b5');
INSERT INTO `liked` VALUES ('4', 'd222f7f5-57aa-4301-98c3-6b544d1a94b5');
INSERT INTO `liked` VALUES ('4', 'a2a87951-23cd-4e3a-b79f-fad1dc37a42d');
INSERT INTO `liked` VALUES ('3', 'a2a87951-23cd-4e3a-b79f-fad1dc37a42d');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `tag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('江hancer', '这是来自江hancer的留言\n                       --布洛尼亚', '2024-11-28T15:41:16.919Z', '1', '2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8');
INSERT INTO `message` VALUES ('铭青', '关于我在校园墙留言那档事', '2024-11-29T09:46:56.785Z', '2', 'd222f7f5-57aa-4301-98c3-6b544d1a94b5');
INSERT INTO `message` VALUES ('归去来兮', '校园墙真是个有趣的地方', '2024-11-29T09:48:36.501Z', '3', 'f125dc28-9981-44c4-a981-ffe724285f39');
INSERT INTO `message` VALUES ('知更鸟', '青春是多么美丽啊！\n却留不住这逝水年华。\n得欢乐时且欢乐吧，\n谁知明天有没有这闲暇。', '2024-11-29T10:44:32.344Z', '4', 'a2a87951-23cd-4e3a-b79f-fad1dc37a42d');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `tag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8', '你说得对', '1', '江hancer');
INSERT INTO `review` VALUES ('2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8', '我也喜欢布洛尼亚，你也是吗？', '2', '铭青');
INSERT INTO `review` VALUES ('2b75625f-1a15-47ca-a22f-e6ceb0f4f0c8', '我也是', '3', '归去来兮');
INSERT INTO `review` VALUES ('f125dc28-9981-44c4-a981-ffe724285f39', '哈哈，确实是这样', '4', '知更鸟');
INSERT INTO `review` VALUES ('a2a87951-23cd-4e3a-b79f-fad1dc37a42d', '斗胆献诗一首！', '4', '知更鸟');
INSERT INTO `review` VALUES ('a2a87951-23cd-4e3a-b79f-fad1dc37a42d', '不错呀，很有韵律美', '1', '江hancer');
INSERT INTO `review` VALUES ('a2a87951-23cd-4e3a-b79f-fad1dc37a42d', '哈哈，谢谢夸奖', '4', '知更鸟');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0', '$2a$10$GnuGPrZdObYmkwnn8U.UNO9nGPUZRe09Nlj6NcgJyeWu369xecP8u', 'admin', '无', 0, 1, 'admin', '星');
INSERT INTO `student` VALUES ('1', '$2a$10$mQK/U6F1QWCoKbPyRKIHhuso4CpJwc0yGdVuXCBjAYFsNKunK7qD6', '江', '男', 22, 1, 'user', '江hancer');
INSERT INTO `student` VALUES ('2', '$2a$10$UYjPrOjOJcs2HANYQcGD4.SiCGbpqvA1oFras1CD.0cWS72MNTGIS', '小明', '男', 19, 1, 'user', '铭青');
INSERT INTO `student` VALUES ('3', '$2a$10$ZoZ20NP1LfeDTSrpPz6wF.Q184HJbMKCz10S5cDxw9rdOCPEdmEN6', '喜多', '女', 20, 1, 'user', '归去来兮');
INSERT INTO `student` VALUES ('4', '$2a$10$lhDz3Xv9iAbQQS.E66kq0Ow9LNVOELqhefgBCM9ByeRBUgb5OeKP.', '小鸟', '女', 17, 1, 'user', '知更鸟');

SET FOREIGN_KEY_CHECKS = 1;
