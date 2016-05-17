-- MySQL dump 10.13  Distrib 5.7.12, for osx10.11 (x86_64)
--
-- Host: localhost    Database: compass
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) DEFAULT NULL,
  `search_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eix9du6u2r4wxwu415wq8yb99` (`question_id`),
  KEY `FK_4y07gmxvmpplqtrul9e0onv6o` (`search_id`),
  CONSTRAINT `FK_4y07gmxvmpplqtrul9e0onv6o` FOREIGN KEY (`search_id`) REFERENCES `search` (`id`),
  CONSTRAINT `FK_eix9du6u2r4wxwu415wq8yb99` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,1),(2,2,1),(3,3,1);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer_question_options`
--

DROP TABLE IF EXISTS `answer_question_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer_question_options` (
  `answer_id` bigint(20) NOT NULL,
  `question_options_id` bigint(20) NOT NULL,
  KEY `FK_b4u505bwo8t0r6o68prbg7f00` (`question_options_id`),
  KEY `FK_7cfh55j9sgwyumgi8muxfem2i` (`answer_id`),
  CONSTRAINT `FK_7cfh55j9sgwyumgi8muxfem2i` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`id`),
  CONSTRAINT `FK_b4u505bwo8t0r6o68prbg7f00` FOREIGN KEY (`question_options_id`) REFERENCES `question_option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_question_options`
--

LOCK TABLES `answer_question_options` WRITE;
/*!40000 ALTER TABLE `answer_question_options` DISABLE KEYS */;
INSERT INTO `answer_question_options` VALUES (1,4),(2,7),(3,10),(3,11),(3,12);
/*!40000 ALTER TABLE `answer_question_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'You will learn how to create software.','Software Engineering'),(2,'This course will teach you all the theory behind programming - algorithms and data structures.','Computer Science'),(3,'You will be taught how to create programs, helping biologists all around the world with the use of <em>Big Data</em> and <em>Python</em>','Bioinformatics');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_course_questions`
--

DROP TABLE IF EXISTS `course_course_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_course_questions` (
  `course_id` bigint(20) NOT NULL,
  `course_questions_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_5ktqqbbuoy2t27chwxcd63qg2` (`course_questions_id`),
  KEY `FK_9gnurh1liiqshtwui43u1pp7i` (`course_id`),
  CONSTRAINT `FK_5ktqqbbuoy2t27chwxcd63qg2` FOREIGN KEY (`course_questions_id`) REFERENCES `course_question` (`id`),
  CONSTRAINT `FK_9gnurh1liiqshtwui43u1pp7i` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_course_questions`
--

LOCK TABLES `course_course_questions` WRITE;
/*!40000 ALTER TABLE `course_course_questions` DISABLE KEYS */;
INSERT INTO `course_course_questions` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9);
/*!40000 ALTER TABLE `course_course_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_question`
--

DROP TABLE IF EXISTS `course_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b7kt3ld1tjrmktxmro620rxmp` (`course_id`),
  KEY `FK_t3b0e2c6a0s2l8ujk8qrgcw7l` (`question_id`),
  CONSTRAINT `FK_b7kt3ld1tjrmktxmro620rxmp` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FK_t3b0e2c6a0s2l8ujk8qrgcw7l` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_question`
--

LOCK TABLES `course_question` WRITE;
/*!40000 ALTER TABLE `course_question` DISABLE KEYS */;
INSERT INTO `course_question` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,2,2),(6,2,3),(7,3,1),(8,3,2),(9,3,3);
/*!40000 ALTER TABLE `course_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_question_course_question_options`
--

DROP TABLE IF EXISTS `course_question_course_question_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_question_course_question_options` (
  `course_question_id` bigint(20) NOT NULL,
  `course_question_options_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_avrdw1h1qsxe278abjn2ahmcv` (`course_question_options_id`),
  KEY `FK_ktennth1lf07pxonyox1dudw7` (`course_question_id`),
  CONSTRAINT `FK_avrdw1h1qsxe278abjn2ahmcv` FOREIGN KEY (`course_question_options_id`) REFERENCES `course_question_option` (`id`),
  CONSTRAINT `FK_ktennth1lf07pxonyox1dudw7` FOREIGN KEY (`course_question_id`) REFERENCES `course_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_question_course_question_options`
--

LOCK TABLES `course_question_course_question_options` WRITE;
/*!40000 ALTER TABLE `course_question_course_question_options` DISABLE KEYS */;
INSERT INTO `course_question_course_question_options` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,7),(2,8),(3,9),(3,10),(3,11),(3,12),(3,13),(4,14),(4,15),(4,16),(4,17),(4,18),(5,19),(5,20),(5,21),(6,22),(6,23),(6,24),(6,25),(6,26),(7,27),(7,28),(7,29),(7,30),(7,31),(8,32),(8,33),(8,34),(9,35),(9,36),(9,37),(9,38),(9,39);
/*!40000 ALTER TABLE `course_question_course_question_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_question_option`
--

DROP TABLE IF EXISTS `course_question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_question_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weight` int(11) NOT NULL,
  `course_question_id` bigint(20) DEFAULT NULL,
  `question_option_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3y6wycji7od26avd0cddqm2pa` (`course_question_id`),
  KEY `FK_go8gi0x8nydifw6rhu4msdtaq` (`question_option_id`),
  CONSTRAINT `FK_3y6wycji7od26avd0cddqm2pa` FOREIGN KEY (`course_question_id`) REFERENCES `course_question` (`id`),
  CONSTRAINT `FK_go8gi0x8nydifw6rhu4msdtaq` FOREIGN KEY (`question_option_id`) REFERENCES `question_option` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_question_option`
--

LOCK TABLES `course_question_option` WRITE;
/*!40000 ALTER TABLE `course_question_option` DISABLE KEYS */;
INSERT INTO `course_question_option` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4),(5,1,1,5),(6,3,2,6),(7,4,2,7),(8,5,2,8),(9,5,3,9),(10,3,3,10),(11,5,3,11),(12,4,3,12),(13,5,3,13),(14,1,4,1),(15,1,4,2),(16,1,4,3),(17,1,4,4),(18,1,4,5),(19,5,5,6),(20,4,5,7),(21,3,5,8),(22,5,6,9),(23,5,6,10),(24,3,6,11),(25,5,6,12),(26,3,6,13),(27,1,7,1),(28,2,7,2),(29,3,7,3),(30,4,7,4),(31,5,7,5),(32,5,8,6),(33,3,8,7),(34,5,8,8),(35,3,9,9),(36,5,9,10),(37,5,9,11),(38,5,9,12),(39,3,9,13);
/*!40000 ALTER TABLE `course_question_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org`
--

DROP TABLE IF EXISTS `org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org`
--

LOCK TABLES `org` WRITE;
/*!40000 ALTER TABLE `org` DISABLE KEYS */;
INSERT INTO `org` VALUES (1,'Uniwersytet Jagielloński','Located in a heart of Cracov, Jagiellonian university offers broad list of courses and high quality of theorethical knowledge.'),(2,'Akademia Górniczo-Hutnicza','Located in a beautiful city of Cracov, AGH provides its students with out-of-competition practical skills.'),(3,'Politechnika Wrocławska','Wroclaw, the cultural center of Poland, offers great possibilities for students, willing to learn IT subjects.'),(4,'Wyższa Szkoła Informatyczna','Well, you will pass. Just if you apply. But the quality of studies is still above the average.');
/*!40000 ALTER TABLE `org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_courses`
--

DROP TABLE IF EXISTS `org_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_courses` (
  `org_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL,
  KEY `FK_madi17s87ljjhomb1aqowdi0m` (`course_id`),
  KEY `FK_cj62nfms3kybky0c29ni49g0s` (`org_id`),
  CONSTRAINT `FK_cj62nfms3kybky0c29ni49g0s` FOREIGN KEY (`org_id`) REFERENCES `org` (`id`),
  CONSTRAINT `FK_madi17s87ljjhomb1aqowdi0m` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_courses`
--

LOCK TABLES `org_courses` WRITE;
/*!40000 ALTER TABLE `org_courses` DISABLE KEYS */;
INSERT INTO `org_courses` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,2),(4,1);
/*!40000 ALTER TABLE `org_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `image_url` varchar(255) DEFAULT NULL,
  `style` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,NULL,NULL,2,'How curious are you about what are living beings inside?'),(2,NULL,NULL,3,'Are you about to discover something inexistent or create something in a totally awesome way?'),(3,NULL,NULL,1,'What activities would you like to do the most (on a daily basis)?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_option`
--

DROP TABLE IF EXISTS `question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_81c44qermc4v4ou5mxfjxe1es` (`question_id`),
  CONSTRAINT `FK_81c44qermc4v4ou5mxfjxe1es` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_option`
--

LOCK TABLES `question_option` WRITE;
/*!40000 ALTER TABLE `question_option` DISABLE KEYS */;
INSERT INTO `question_option` VALUES (1,'1',1),(2,'2',1),(3,'3',1),(4,'4',1),(5,'5',1),(6,'Only discovery!',2),(7,'Discovery is nice, but I want to create too...',2),(8,'Creating stuff is my passion!',2),(9,'Making theory to play nice in practice',3),(10,'Develop new ways of doing something',3),(11,'Create new tools and things',3),(12,'Working in a team of experienced seniors',3),(13,'Working in an enthusiastic team of same-agers',3);
/*!40000 ALTER TABLE `question_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_question_options`
--

DROP TABLE IF EXISTS `question_question_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_question_options` (
  `question_id` bigint(20) NOT NULL,
  `question_options_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_mmi1k04ke4siucuiih8j33otj` (`question_options_id`),
  KEY `FK_qtjjq3r96as8qiup4e6hdus35` (`question_id`),
  CONSTRAINT `FK_mmi1k04ke4siucuiih8j33otj` FOREIGN KEY (`question_options_id`) REFERENCES `question_option` (`id`),
  CONSTRAINT `FK_qtjjq3r96as8qiup4e6hdus35` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_question_options`
--

LOCK TABLES `question_question_options` WRITE;
/*!40000 ALTER TABLE `question_question_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_question_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search`
--

DROP TABLE IF EXISTS `search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hj0kk1r8qk27ep49hl6w0jsmi` (`user_id`),
  CONSTRAINT `FK_hj0kk1r8qk27ep49hl6w0jsmi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search`
--

LOCK TABLES `search` WRITE;
/*!40000 ALTER TABLE `search` DISABLE KEYS */;
INSERT INTO `search` VALUES (1,1,'2016-05-17 00:00:00');
/*!40000 ALTER TABLE `search` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_answers`
--

DROP TABLE IF EXISTS `search_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_answers` (
  `search_id` bigint(20) NOT NULL,
  `answers_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_idud0oj55tby09jjw2gm985o4` (`answers_id`),
  KEY `FK_8bmi5jnsj2gl3yf97o5oydf74` (`search_id`),
  CONSTRAINT `FK_8bmi5jnsj2gl3yf97o5oydf74` FOREIGN KEY (`search_id`) REFERENCES `search` (`id`),
  CONSTRAINT `FK_idud0oj55tby09jjw2gm985o4` FOREIGN KEY (`answers_id`) REFERENCES `answer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_answers`
--

LOCK TABLES `search_answers` WRITE;
/*!40000 ALTER TABLE `search_answers` DISABLE KEYS */;
INSERT INTO `search_answers` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `search_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'u1@email.com','user #1'),(2,'u2@email.com','user #2'),(3,'u3@email.com','user #3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_searches`
--

DROP TABLE IF EXISTS `user_searches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_searches` (
  `user_id` bigint(20) NOT NULL,
  `searches_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_4a5f1uik38g104jyalxbnf5qg` (`searches_id`),
  KEY `FK_87wm26e7dml8igimiktvhfd37` (`user_id`),
  CONSTRAINT `FK_4a5f1uik38g104jyalxbnf5qg` FOREIGN KEY (`searches_id`) REFERENCES `search` (`id`),
  CONSTRAINT `FK_87wm26e7dml8igimiktvhfd37` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_searches`
--

LOCK TABLES `user_searches` WRITE;
/*!40000 ALTER TABLE `user_searches` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_searches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-17 11:17:52
