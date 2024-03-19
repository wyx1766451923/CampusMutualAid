/*
 Navicat Premium Data Transfer

 Source Server         : ncmas
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : ncmas

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 19/03/2024 21:14:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for campusinfo
-- ----------------------------
DROP TABLE IF EXISTS `campusinfo`;
CREATE TABLE `campusinfo`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标题',
  `content` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '内容',
  `imageurl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
  `releaseTime` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of campusinfo
-- ----------------------------
INSERT INTO `campusinfo` VALUES (1, '大家帮校园平台正式开始使用', '大家帮\"校园互助平台，一个专为校园师生打造的多功能服务社区，致力于资源共享、失物招领和闲置物品转让，让校园生活更加和谐便捷。\r\n      资源共享板块：在这里，你可以找到各种虚拟资源或实物资源。\r\n      失物招领板块：如果你不慎遗失物品，或是捡到他人遗失的物品，都可以在这里发布信息。我们提供快速有效的失物招领服务，帮助你找回失物，或是让遗失的物品尽快回到主人手中。\r\n      闲置转让板块：毕业季、搬家季，总有一些物品需要处理。在这里，你可以发布闲置物品转让信息，无论是书籍、电子产品还是生活用品，都能找到新的主人，避免浪费。\r\n      如何使用：\r\n      只需进入大家帮网站，注册并登录你的校园账号，即可浏览各个板块，发布信息或联系他人。平台操作简单，信息真实可靠，让校园内的互助变得更加简单高效。\r\n      \"大家帮\"校园互助平台，是你校园生活的得力助手。在这里，每个人都可以成为他人的帮助者，也可以成为得到帮助的人。加入我们，让校园互助成为我们共同的美好记忆！', '/img/campusinfo/info1.png', '2024-3-14');
INSERT INTO `campusinfo` VALUES (2, '学校召开2024年春季学期第一次本科教学工作例会', '3月4日上午，学校2024年春季学期第一次本科教学工作例会在花溪校区明德楼129会议室召开。校党委常委、副校长何建国出席会议并讲话。教务处处长丁军主持会议。\r\n\r\n何建国在讲话中指出，本科人才培养工作要紧紧围绕教育强国、教育强市建设总体部署和高等教育发展新形势新要求，紧紧围绕学校2024年工作要点，打好攻坚战，抓好重点任务，把握好“学科交叉”、“产教融合”、“教育数字化”三个关键词，持续提升本科教育教学水平。要以本科教育教学审核评估为重点，聚焦构建落实立德树人根本任务新生态新格局，做到以评促建、以评促改、以评促教、以评促管、以评促强。要以学科专业优化调整为契机，深化“招生——培养——就业”联动，全面提升人才自主培养质量。要以工作作风建设为牵引，推行工作清单化，抓实抓细本科教育教学各项工作。\r\n\r\n会上，丁军总结了2023年我校在本科教育教学方面取得的成绩，并结合高等教育发展新形势和2024学年学校工作要点，就本科教育教学审核评估、工程教育专业认证、专业优化调整、教学成果奖培育等四项重点工作进行了分析和强调。教务处副处长张小容、邹政、张勇分别就本科教育教学审核评估、教师教学竞赛、专业集群建设、一流专业和课程建设、课程思政建设、教学楼环境建设、教学数字化等工作要点进行了说明。\r\n\r\n教学质量监控与评估中心主任郭永强从教学资料、访谈资料准备等方面介绍了本科教育教学审核评估工作安排和相关要求。\r\n\r\n各教学单位分管本科教学工作负责人、教学秘书，教务处、教学质量监控与评估中心、教学督导团本科教学督导分团有关人员参加会议。', '/img/campusinfo/info2.png', '2024-3-4');
INSERT INTO `campusinfo` VALUES (3, '[喜讯]学校在2023年度重庆共青团工作考核中获评“特等”', '近日，团市委召开了六届三次全会，通报了2023年度重庆共青团工作目标考核结果，我校共青团工作再获“特等”等次，且考核分数位列公办本科高校第一。团委书记龙婷作为团组织主要负责人年度履职情况获评为“好”。\r\n\r\n2023年，学校团委深入学习贯彻习近平新时代中国特色社会主义思想和党的二十大精神，着力实施“四大工程”，聚力提升团组织的“三力一度”，在学校党委和团市委的坚强领导下，各项工作扎实有效、特色鲜明、成果显著。荣获全国“三下乡”社会实践优秀单位、全国优秀西部计划项目办等国家级荣誉30余项，获评重庆市“五四红旗团委”荣誉称号。成功选树青年师生获评“中国大学生自强之星”，青少年科技创新市长奖，青年科创先锋等数十项市级以上荣誉。学校共青团工作多次获人民网、学习强国、《中国青年报》《重庆日报》等主流媒体关注报道。\r\n\r\n学校团委将以此次考核为契机，紧扣主题主线，坚持“身心同健、文理兼修、德才并进、知行合一”的人才培养理念，以青马工程为龙头强化思想引领“牵引力”，以“红岩先锋”变革型团组织打造为依托注入团学改革“原动力”，以“第二课堂成绩单”评价体系建设为抓手提升工作质效“服务力”，以社会实践为载体激发实践育人“鲜活力”， “四力”赋能，切实提升青年获得感，团结引领广大青年“学起来”“动起来”“干起来”，为学校事业开创新局面、取得新成就贡献青春力量。', '/img/campusinfo/info3.png', '2024-3-15');
INSERT INTO `campusinfo` VALUES (4, '计算机科学与工程学院举行“返家乡”社会实践交流会暨第三十期青马班开班仪式', '3月12日，计算机科学与工程学院于花溪校区第一实验楼C210会议室举行“返家乡”社会实践交流会暨第三十期青马班开班仪式。学院团委书记王南甫，学院组织部、全体团校成员、青马班成员参加。会议由学生代表张芳绮主持。\r\n\r\n会议伊始，全体成员奏唱团歌。“返家乡”社会实践先进个人李子奇、刘晓兵、王宇亮、李欣薄、肖文秀、龙雨萌等依次发言。他们表示“返家乡”实践活动不仅带给自己一种全新的生活体验，也提升了自身的能力和素质，未来将继续坚持志愿活动，回馈家乡与社会。王南甫对此给予高度评价，并为他们颁发了“返家乡”社会实践先进个人荣誉奖项。\r\n\r\n团校优秀学员代表董文硕在发言中表示，作为当代大学生应该坚定共产主义信念，坚决拥护中国共产党的领导，勤奋学习，刻苦钻研，进一步提高思想政治素质，做一名合格的社会主义接班人。在学习和工作中，要结合马克思主义理论，注意观察与研究新事物，积极探索，勇于突破传统观念的束缚，力求学习水平不断进步、工作能力精益求精，争取最后以优异的成绩结业。\r\n\r\n王南甫在总结中对学院本次大学生“返家乡”实践活动成果表示认可，也提出了意见建议。他鼓励同学们应该积极参加此类活动。随后，他就学生干部的“情商”和“情怀”与同学们进行了交流，他表示学生干部在工作时候应该学会换位思考，采取正确的沟通方式与态度，放宽心境、保持大度、着眼大局。\r\n\r\n此次会议的举行，展现了新时代青年积极向上、担当实干的风采，学院将继续推进各项社会实践活动，激励广大青年人才们投身于家乡建设的积极性、主动性，为家乡城市发展注入青春力量，让青春在拼搏和奉献中绽放光芒。', '/img/campusinfo/info4.png', '2024-3-14');
INSERT INTO `campusinfo` VALUES (5, '学校举行“奋进新征程，建功新时代”教职工趣味运动会', '3月11日下午，为提升教职工幸福感、获得感，展现学校教职工良好的精神风貌，学校以“奋进新征程，建功新时代”为主题在花溪校区足球场举行教职工趣味运动会。校党委副书记张晓洪出席活动并致辞，开幕式由校工会兼职副主席、教代会副主任李川主持。\r\n\r\n本次运动会由广播体操开场展演及人桥接力、薪火相传、超级玛丽、珠行万里四个趣味运动项目组成，来自全校26个基层工会的近600名教职工参加运动会。比赛现场精彩纷呈、扣人心弦，教职工们团结一心、顽强拼搏，将个人技巧和团队协作精神融入比赛过程。\r\n\r\n经过紧张激烈的角逐，体育教学部工会、药学与生物工程学院工会、两江校区工会获本次比赛一等奖；机关第一工会、两江人工智能学院工会、基建后勤工会、应用技术学院商贸信息学院工会、机械工程学院工会、理学院工会获二等奖；管理学院工会、机关第二工会、直属单位工会、车辆工程学院工会、重庆知识产权学院工会、马克思主义学院工会、化学化工学院工会、电气与电子工程学院工会获三等奖。\r\n\r\n本次趣味运动会的举办，进一步丰富了教职工的业余文化生活，提高了大家的职业幸福感，引导了广大教职工继续保持昂扬向上的精神风貌，在各自的岗位上再展风采、再创佳绩，为构建和分享和谐校园作出贡献。', '/img/campusinfo/info5.png', '2024-3-14');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `userid` int NOT NULL COMMENT '评论用户id',
  `postid` int NOT NULL COMMENT '贴子id',
  `commentContent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `publishTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, 1, 1, '这个好像是我室友的我去问问', '2024-03-18');
INSERT INTO `comments` VALUES (2, 1, 1, '确实是我室友的，我让他联系你', '2024-03-18');
INSERT INTO `comments` VALUES (3, 1, 1, '搞错了，不是他的，对不起', '2024-03-18');

-- ----------------------------
-- Table structure for lostandfound
-- ----------------------------
DROP TABLE IF EXISTS `lostandfound`;
CREATE TABLE `lostandfound`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物品名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '丢失或拾取地址',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '丢失或拾取时间',
  `imageUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `ContactInformation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系方式',
  `userid` int NOT NULL COMMENT '用户id',
  `type` int NOT NULL COMMENT '拾取或者丢失0为丢失，1为拾取',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lostandfound
-- ----------------------------
INSERT INTO `lostandfound` VALUES (1, 'vivo手机', '一操场', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ：1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (2, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (3, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (4, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (5, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (6, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (7, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (8, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (9, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (10, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (11, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (12, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (13, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (14, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 0);
INSERT INTO `lostandfound` VALUES (15, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (16, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (17, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (18, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (19, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (20, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (21, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (22, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (23, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (24, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (25, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);
INSERT INTO `lostandfound` VALUES (26, 'vivo手机z50s哈哈版', '一操场外跑道健步处杠杠', '2024-03-17', '/img/lostandfound/lost1.png', '在操场跑道外部丢失，拾取到请联系我', '王大锤', 'QQ:1766451923', 1, 1);

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `imageurl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper` VALUES (1, '/img/swiper/swiper1.png');
INSERT INTO `swiper` VALUES (2, '/img/swiper/swiper2.png');
INSERT INTO `swiper` VALUES (3, '/img/swiper/swiper3.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户头像',
  `Permissions` int NOT NULL COMMENT '用户权限，0为普通，1为管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '红树', '123456', '/img/avatar/avatar1.png', 1);

SET FOREIGN_KEY_CHECKS = 1;
