-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: utilitybill
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu` (
  `sid` varchar(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `ss_class` varchar(20) DEFAULT NULL,
  `Electric` double(110,2) DEFAULT NULL,
  `water` double(110,2) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `name` (`name`),
  CONSTRAINT `check_Electric` CHECK ((`Electric` > 0)),
  CONSTRAINT `check_water` CHECK ((`water` > 0)),
  CONSTRAINT `Electric` CHECK ((`Electric` > 0)),
  CONSTRAINT `stu_chk_1` CHECK (((`sex` = _utf8mb4'男') or (`sex` = _utf8mb4'女')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES ('123123123234','吴秉恒','女','计算机-123',123.23,234543.20),('123456789124','吴学颖','男','计算机学院-104班',123.56,1234.67);
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `tid` varchar(6) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `Electric` double(100,2) DEFAULT NULL,
  `water` double(100,2) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `name` (`name`),
  CONSTRAINT `ck_Electric` CHECK ((`Electric` > 0)),
  CONSTRAINT `ck_water` CHECK ((`water` > 0)),
  CONSTRAINT `teacher_chk_1` CHECK (((`sex` = _utf8mb4'男') or (`sex` = _utf8mb4'女')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('123458','吴佳佳','女','计算机学院',123.50,123.67),('123459','吴无恶意','男','计算机学院',123.70,1234.67);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 11:35:02
