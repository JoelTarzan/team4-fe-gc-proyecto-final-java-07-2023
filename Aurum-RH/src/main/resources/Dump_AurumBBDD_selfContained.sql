-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: containers-us-west-68.railway.app    Database: railway
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `id_candidature` int DEFAULT NULL,
  `phase` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_candidature` (`id_candidature`),
  KEY `phase` (`phase`),
  CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`id_candidature`) REFERENCES `candidatures` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `applications_ibfk_3` FOREIGN KEY (`phase`) REFERENCES `open_processes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` VALUES (1,1,1,NULL),(2,1,2,1),(3,4,3,2),(4,1,3,NULL),(5,6,6,5),(6,4,4,6);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidatures`
--

DROP TABLE IF EXISTS `candidatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidatures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `closing_date` date DEFAULT NULL,
  `type_working_date` varchar(100) DEFAULT NULL,
  `applicants_num` int DEFAULT NULL,
  `description` text,
  `requirements` text,
  `responsabilities` text,
  `state` tinyint(1) DEFAULT NULL,
  `creator` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creator` (`creator`),
  CONSTRAINT `candidatures_ibfk_1` FOREIGN KEY (`creator`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidatures`
--

LOCK TABLES `candidatures` WRITE;
/*!40000 ALTER TABLE `candidatures` DISABLE KEYS */;
INSERT INTO `candidatures` VALUES (1,'Candidatura X','Reus','2023-12-04','Jornada completa',22,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',1,5),(2,'Candidatura Y','Tarragona','2023-12-20','Media jornada',15,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',0,5),(3,'Candidatura Z','Barcelona','2023-12-31','Jornada completa',36,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',1,3),(4,'Candidatura A','Girona','2023-12-15','Jornada completa',25,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',0,3),(5,'Candidatura B','Lleida','2023-11-25','Media jornada',18,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',1,5),(6,'Candidatura C','Tarragona','2023-11-10','Jornada completa',30,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet',1,3);
/*!40000 ALTER TABLE `candidatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `open_processes`
--

DROP TABLE IF EXISTS `open_processes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `open_processes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `is_open` tinyint(1) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `id_candidature` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_candidature` (`id_candidature`),
  CONSTRAINT `open_processes_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `open_processes_ibfk_2` FOREIGN KEY (`id_candidature`) REFERENCES `candidatures` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `open_processes`
--

LOCK TABLES `open_processes` WRITE;
/*!40000 ALTER TABLE `open_processes` DISABLE KEYS */;
INSERT INTO `open_processes` VALUES (1,'Entregar CV','2023-11-10',1,1,2),(2,'Entrevista','2023-11-23',0,4,3),(3,'Entrevista Técnica','2023-11-28',1,6,4),(4,'Prueba de habilidades','2023-12-05',0,1,1),(5,'Segunda entrevista','2023-12-15',1,6,6),(6,'Evaluación de aptitud','2023-12-20',1,4,4);
/*!40000 ALTER TABLE `open_processes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'rrhh'),(3,'candidate');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (3,'Angular'),(2,'CSS'),(1,'Java'),(5,'JavaScript'),(6,'Spring Boot'),(4,'TypeScript');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills_candidatures`
--

DROP TABLE IF EXISTS `skills_candidatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills_candidatures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_skill` int DEFAULT NULL,
  `id_candidature` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_skill` (`id_skill`),
  KEY `id_candidature` (`id_candidature`),
  CONSTRAINT `skills_candidatures_ibfk_1` FOREIGN KEY (`id_skill`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `skills_candidatures_ibfk_2` FOREIGN KEY (`id_candidature`) REFERENCES `candidatures` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills_candidatures`
--

LOCK TABLES `skills_candidatures` WRITE;
/*!40000 ALTER TABLE `skills_candidatures` DISABLE KEYS */;
INSERT INTO `skills_candidatures` VALUES (1,3,1),(2,4,2),(3,5,4),(4,1,3),(5,2,6),(6,5,5);
/*!40000 ALTER TABLE `skills_candidatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills_users`
--

DROP TABLE IF EXISTS `skills_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_skill` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `validated` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_skill` (`id_skill`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `skills_users_ibfk_1` FOREIGN KEY (`id_skill`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `skills_users_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills_users`
--

LOCK TABLES `skills_users` WRITE;
/*!40000 ALTER TABLE `skills_users` DISABLE KEYS */;
INSERT INTO `skills_users` VALUES (1,1,4,1),(2,3,6,1),(3,5,1,0),(4,1,6,1),(5,3,1,1),(6,5,4,0);
/*!40000 ALTER TABLE `skills_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_open_process` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_open_process` (`id_open_process`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`id_open_process`) REFERENCES `open_processes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subscriptions_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,1,3),(2,2,5),(3,3,5),(4,4,3),(5,6,3),(6,5,5);
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `description` text,
  `rating` enum('0','1','2','3','4','5') NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `web` varchar(150) DEFAULT NULL,
  `linkedin` varchar(150) DEFAULT NULL,
  `git` varchar(150) DEFAULT NULL,
  `avatar` blob,
  `id_role` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Joel','Tarzán','joel@gmail.com','Joel123','Lorem ipsum dolor sit amet, consectetur adipiscing','2','Programador Junior','644288331','joeltarzan.es','joeltarzan','JoelTarzan',NULL,3),(2,'Gerard','Fernández','gerard@gmail.com','Gerard123','Lorem ipsum dolor sit amet, consectetur adipiscing','3','Administrador','644399182','gerardfernandez.es','gerardfernandez','GerardFernandez',NULL,1),(3,'Marco','Santoro','marco@gmail.com','Marco123','Lorem ipsum dolor sit amet, consectetur adipiscing','4','Manager RRHH','644271622','marcosantoro.es','marcosantoro','MarcoSantoro',NULL,2),(4,'Laura','Pérez','laura@gmail.com','Laura123','Lorem ipsum dolor sit amet, consectetur adipiscing','3','Desarrollador Web Senior','644123456','lauraperez.es','lauraperez','LauraPerez',NULL,3),(5,'Elena','García','elena@gmail.com','Elena123','Lorem ipsum dolor sit amet, consectetur adipiscing','4','Coordinador RRHH','644987654','elenagarcia.es','elenagarcia','ElenaGarcia',NULL,2),(6,'Carlos','López','carlos@gmail.com','Carlos123','Lorem ipsum dolor sit amet, consectetur adipiscing','3','Administrador de Sistemas','644567890','carloslopez.es','carloslopez','CarlosLopez',NULL,3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-05 19:42:52
