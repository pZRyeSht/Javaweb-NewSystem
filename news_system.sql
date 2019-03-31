/*
Navicat MySQL Data Transfer

Source Server         : 恒
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : news_system

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-12-17 10:25:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) DEFAULT NULL,
  `admin_rname` varchar(50) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL,
  `admin_datetime` date DEFAULT NULL,
  `admin_type` varchar(50) DEFAULT NULL,
  `admin_right` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'heng', '恒', '123456', '2018-12-15', '超级管理员', '0');
INSERT INTO `admin` VALUES ('2', 'jie', '杰', '123456', '2018-12-05', '超级管理员', '0');
INSERT INTO `admin` VALUES ('3', 'bo', '博', '123456', '2018-12-05', '超级管理员', '0');
INSERT INTO `admin` VALUES ('4', 'xu', '栩', '123456', '2018-12-05', '超级管理员', '0');
INSERT INTO `admin` VALUES ('5', 'yue', '月', '123456', '2018-12-06', '普通管理员', '1');
INSERT INTO `admin` VALUES ('6', 'li', '离', '123456', '2018-12-06', '普通管理员', '1');
INSERT INTO `admin` VALUES ('9', 'jin', '金', '123456', '2018-12-14', '普通管理员', '1');
INSERT INTO `admin` VALUES ('11', 'fa', '发', '123456', '2018-12-15', '普通管理员', '1');
INSERT INTO `admin` VALUES ('12', 'hao', '豪', '123456', '2018-12-15', '普通管理员', '1');

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------
INSERT INTO `cat` VALUES ('1', '政治');
INSERT INTO `cat` VALUES ('2', '娱乐');
INSERT INTO `cat` VALUES ('3', '军事');
INSERT INTO `cat` VALUES ('4', '科学');
INSERT INTO `cat` VALUES ('5', '法制');
INSERT INTO `cat` VALUES ('6', '野生动物');
INSERT INTO `cat` VALUES ('7', '社会');

-- ----------------------------
-- Table structure for cmt
-- ----------------------------
DROP TABLE IF EXISTS `cmt`;
CREATE TABLE `cmt` (
  `cmt_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cmt_content` varchar(255) DEFAULT NULL,
  `cmt_datetime` date DEFAULT NULL,
  PRIMARY KEY (`cmt_id`),
  KEY `cmt_news_id` (`news_id`),
  KEY `cmt_user_id` (`user_id`),
  CONSTRAINT `cmt_news_id` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`),
  CONSTRAINT `cmt_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cmt
-- ----------------------------

-- ----------------------------
-- Table structure for dc
-- ----------------------------
DROP TABLE IF EXISTS `dc`;
CREATE TABLE `dc` (
  `dc_id` int(11) NOT NULL AUTO_INCREMENT,
  `dc_name` varchar(50) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dc_id`),
  KEY `dc_cat_id` (`cat_id`),
  CONSTRAINT `dc_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `cat` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dc
-- ----------------------------
INSERT INTO `dc` VALUES ('1', '外交', '1');
INSERT INTO `dc` VALUES ('2', '国内', '2');
INSERT INTO `dc` VALUES ('3', '刑法', '5');
INSERT INTO `dc` VALUES ('4', '手机', '4');
INSERT INTO `dc` VALUES ('5', '选举', '1');
INSERT INTO `dc` VALUES ('6', '汽车', '4');
INSERT INTO `dc` VALUES ('7', '军备', '3');
INSERT INTO `dc` VALUES ('8', '搞笑', '7');
INSERT INTO `dc` VALUES ('9', '日常', '7');
INSERT INTO `dc` VALUES ('10', '保护动物', '6');
INSERT INTO `dc` VALUES ('11', '奇妙动物', '6');
INSERT INTO `dc` VALUES ('12', '影视', '2');
INSERT INTO `dc` VALUES ('13', '音乐', '2');

-- ----------------------------
-- Table structure for human
-- ----------------------------
DROP TABLE IF EXISTS `human`;
CREATE TABLE `human` (
  `human_id` int(11) NOT NULL AUTO_INCREMENT,
  `human_name` varchar(50) DEFAULT NULL,
  `human_address` varchar(255) DEFAULT NULL,
  `human_age` int(11) DEFAULT NULL,
  `human_work` varchar(50) DEFAULT NULL,
  `human_intr` varchar(255) DEFAULT NULL,
  `human_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`human_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of human
-- ----------------------------
INSERT INTO `human` VALUES ('1', '习近平', '陕西富平', '65', '国家主席', '习近平，男，汉族，1953年6月生，陕西富平人，1969年1月参加工作，1974年1月加入中国共产党，清华大学人文社会学院马克思主义理论与思想政治教育专业毕业，在职研究生学历，法学博士学位。\r\n现任中国共产党中央委员会总书记，中共中央军事委员会主席，中华人民共和国主席，中华人民共和国中央军事委员会主席。', '543');
INSERT INTO `human` VALUES ('2', '詹姆斯', '美国克利夫兰', '34', 'NBA职业球员', 'NBA第一人！', '15');
INSERT INTO `human` VALUES ('5', '科比', '美国', '40', 'NBA职业球员', '科比·布莱恩特（Kobe Bryant），1978年8月23日出生于宾夕法尼亚州费城，前美国著名职业篮球运动员，司职得分后卫小前锋（锋卫摇摆人）。自1996年起，科比一直效力于NBA洛杉矶湖人队，直到2015-2016年赛季结束正式退役。在长达20年的NBA生涯中，科比5次获得NBA总冠军，两次获得总决赛MVP（2009年和2010年），1次常规赛MVP（2008年），18次入选全明星阵容，其中4次获得全明星MVP。', '2');

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(50) DEFAULT NULL,
  `link_address` varchar(255) DEFAULT NULL,
  `link_datetime` date DEFAULT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES ('1', '新浪', 'https://news.sina.com.cn/', '2018-12-05');
INSERT INTO `link` VALUES ('2', '搜狐', 'http://news.sohu.com/', '2018-12-05');
INSERT INTO `link` VALUES ('3', '网易', 'https://news.163.com/', '2018-12-05');
INSERT INTO `link` VALUES ('4', '雅虎', 'https://www.yahoo.com/', '2018-12-05');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) DEFAULT NULL,
  `news_content` text,
  `news_datetime` date DEFAULT NULL,
  `news_firstshow` int(11) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `dc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  KEY `news_cat_id` (`cat_id`),
  KEY `news_dc_id` (`dc_id`),
  CONSTRAINT `news_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `cat` (`cat_id`),
  CONSTRAINT `news_dc_id` FOREIGN KEY (`dc_id`) REFERENCES `dc` (`dc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '美报告发现中国基建“点亮”非洲 外交部回应', '[环球时报-环球网报道记者 郭芳]近日，美国国家公共广播电台在一篇报道中援引了美国威廉与玛丽学院\"援助数据\"项目最新的研究报告。该报告对2000年至2014年之间中国在全球138个国家4000多个发展项目进行跟踪研究后发现，中国融资的基建项目比西方参与的项目更有效地减少了区域发展不平衡现象。中国在发展中国家特别是非洲的基础设施建设项目有力促进了当地经济增长。在回答《环球时报》记者有关此事的提问时，耿爽说：\"我们一般不对媒体、智库、专家学者的报告和言论作具体和直接的评论。作为原则，我们当然欢迎并支持媒体和研究机构对中非合作以及中国同发展中国家的合作作出客观公允的报道和评价。\"\r\n\r\n他告诉《环球时报》记者，越来越多的数据和事例证明，中方同非洲等广大发展中国家开展的互利合作为当地经济社会发展提供了巨大助力，作出了重要贡献。中非合作成果得到了非洲国家政府的一致肯定和非洲人民的普遍好评。\r\n\r\n耿爽表示，中方将同非洲国家一道，共同推进落实习近平主席在中非合作论坛北京峰会上宣布的中非合作八大行动。中方也愿同其他国际合作伙伴一道，共同为促进非洲的和平发展事业作出新的努力。', '2018-12-05', '1', '1', '1');
INSERT INTO `news` VALUES ('2', '广东英德发生枪击案致1人死亡 警方悬赏10万元追凶', '12月4日晚，广东省英德市公安局发布了一则通报称，12月4日16时许，该市东华镇发生一起枪击致1人死亡案件。案发后，该局立即启动命案侦破机制，迅速开展侦查工作。目前，该市副市长、公安局长黄构恩带领刑侦、巡特警、交警、各派出所等相关警种正全力组织搜捕工作。\r\n\r\n据“悬赏通告”内容显示，犯罪嫌疑人杨日初，男，英德市东华镇人，身份证号码：441822197412176130。\r\n\r\n警方呼吁，广大市民在注意自身安全的前提下，如发现线索，请及时与广东省英德市公安局联系。对反映情况的群众，该局给予保密，并对提供准确信息抓获犯罪嫌疑人的给予人民币100000元的奖励。同时，该局敦促犯罪嫌疑人杨日初迅速到公安机关投案自首。', '2018-12-05', '1', '5', '3');
INSERT INTO `news` VALUES ('5', '大兴区召开区镇人大换届选举工作会', '开发区首次作为大兴选举委员会分会开展选举\r\n林克庆李长友张伯旭张书领高树旺等出席。\r\n    8月30日，大兴区召开区镇人大换届选举工作会。会议宣读了《北京市大兴区人大常委会党组关于做好区镇两级人民代表大会换届选举工作的意见》。大兴区委书记、开发区工委书记林克庆，大兴区委副书记、区长、开发区工委副书记李长友，大兴区委副书记、副区长、开发区工委副书记、管委会主任张伯旭，大兴区人大常委会主任张书领，大兴区政协主席高树旺，大兴区委副书记王新等领导出席会议。', '2018-12-16', '1', '1', '5');
INSERT INTO `news` VALUES ('6', '《港珠澳大桥》亮相广州国际纪录片节，展映人气爆棚一票难求', '12月11日，2018中国（广州）国际纪录片节正式拉开帷幕，来自122个国家和地区的4542部/集作品参评参展，还有奥斯卡评委会成员、柏林电影节获奖导演以及美国国家地理频道、BBC英国广播公司、香港国际电影节等行业精英齐聚一堂，展望纪录片产业发展趋势。\r\n本届“金红棉影展”上最受追捧的当属纪录电影《港珠澳大桥》，该片于11日下午在广州图书馆展映，导演闫东等主创亮相与观众互动，更首度揭秘影片幕后创作故事，现场座无虚席，人气爆棚。', '2018-12-16', '1', '2', '2');
INSERT INTO `news` VALUES ('7', '1700位天之骄子共赴国难 豆瓣高分纪录片《冲天》上映倒计时', '12月13日，是南京大屠杀死难者国家公祭日，纪录片《冲天》当日发布概念海报，并透露将于2019年全国院线公映。该片在豆瓣评分高达9.3分，在纪录片得分中位居前列，获观众一致好评。这部电影以真实的镜头和生动的细节再现了抗战期间这些来自顶尖学府、名门望族或是归国华侨的中国飞行员们与日寇舍生忘死的空中搏斗，告诉生活在和平年代中的每个人，我们今天的幸福和平是他们用青春美好的生命换来的，他们值得被记录，不应被遗忘。', '2018-12-16', '1', '2', '12');
INSERT INTO `news` VALUES ('8', '刘德华睽违八年红馆连唱20场 六岁女儿坐台下应援', '网易娱乐12月16日报道 据台湾媒体报道，刘德华（华仔）伤愈后，于红馆举办“My Love Andy Lau刘德华World Tour-Hong Kong 2018”跨年演唱会，15日正式揭开序幕，向来注重隐私的华仔，更首度让6岁女儿刘向蕙跟老婆朱丽倩和他的父母现身台下欣赏演出，似乎已不介意女儿公开露脸。\r\n华仔以一身白色唐装大袍气派出场，并献唱《预谋》，57岁的他随后又脱去大袍展现精壮手臂肌打鼓，帅气逼人；接着他换上粉色唐装唱《笨小孩》，并感性说：“八年前生的（小孩）都已经8岁啦，我好想感受下七至八年前有过的掌声。”索性躺在地上感受大家掌声，提到去年坠马事件，他则说 ：“我已经忘记了，你们还记得吗？我都老啦。”', '2018-12-16', '1', '2', '13');
INSERT INTO `news` VALUES ('9', '俄国防部副部长：俄军2018年共接装56款新武器', '【环球网军事12月16日报道】俄罗斯卫星通讯社12月15日报道，俄罗斯国防部副部长布尔加科夫表示，俄武装力量2018年接装完成国家试验的新型武器达56种。\r\n\r\n布尔加科夫在接受“俄罗斯24”电视频道采访时说：“新式武器有很多。今年就接装了35种新型武器和装备。昨天和前天收到下级的汇报，又有21种武器完成了国家试验。就是说再增加了21种武器”。他还指出，军队共接装了5000个单位的新型军事装备。此外，收到800万套军装、70万吨食品和250万吨燃料。', '2018-12-16', '0', '3', '7');
INSERT INTO `news` VALUES ('10', '预售8.99万起 北汽绅宝智道将12月21日上市', '网易汽车12月14日报道 日前，我们从北汽绅宝官方获悉，绅宝智道将于12月21日正式上市销售。新车为北汽绅宝旗下全新中型车，此前公布的预售价格区间为8.99万-12.99万。', '2018-12-17', '0', '4', '6');
INSERT INTO `news` VALUES ('11', ' 交友 官方暗示荣耀V20神秘定制款：玛莎拉蒂or漫威？', '荣耀V20将于12月26日在北京召开发布会，荣耀V20共搭载了三项“黑科技”，包括4800万AI超清摄影技术、Link Turbo、魅眼全视屏。\r\n据悉，荣耀V20还搭载麒麟980芯片，支持22.5W快速充电，运行基于Android9 Pie的EMUI 9。此外，V20将是首个搭载索尼的高端摄像头IMX586的手机，它支持4800万超高像素，1/2.0英寸超大传感器尺寸、像素四合一滤色器，以及4倍硬件HDR等。', '2018-12-17', '0', '4', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_rname` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_tel` varchar(255) DEFAULT NULL,
  `user_datetime` date DEFAULT NULL,
  `user_right` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huang', '日光_jiezai', '123456', 'qwe@qq.com', '12345678910', '2018-12-15', '2');
INSERT INTO `user` VALUES ('2', 'wang', '日王', '123456', 'asd@qq.com', '74196325810', '2018-12-08', '2');
INSERT INTO `user` VALUES ('3', 'gou', '句多', '123456', 'zxc@qq.com', '96321478510', '2018-12-08', '2');
INSERT INTO `user` VALUES ('4', 'xiao', '小小', '123456', 'qaz@qq.com', '123456789', '2018-12-16', '2');
