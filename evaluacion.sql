CREATE DATABASE  IF NOT EXISTS `evaluacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `evaluacion`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: evaluacion
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `barrio`
--

DROP TABLE IF EXISTS `barrio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barrio` (
  `idBarrio` int NOT NULL AUTO_INCREMENT,
  `nombarrio` varchar(45) NOT NULL,
  `idCiudad` int NOT NULL,
  PRIMARY KEY (`idBarrio`),
  UNIQUE KEY `nombarrio_UNIQUE` (`nombarrio`),
  KEY `fk_Barrio_Ciudad_idx` (`idCiudad`),
  CONSTRAINT `fk_Barrio_Ciudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barrio`
--

LOCK TABLES `barrio` WRITE;
/*!40000 ALTER TABLE `barrio` DISABLE KEYS */;
INSERT INTO `barrio` VALUES (1,'barrio1',1),(2,'shancayan',3),(4,'nicrupampa',3),(5,'la soledad',3),(6,'baranquilla',1),(7,'puente piedra',1);
/*!40000 ALTER TABLE `barrio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `idCiudad` int NOT NULL AUTO_INCREMENT,
  `nomciud` varchar(45) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  UNIQUE KEY `nomciud_UNIQUE` (`nomciud`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (4,'cusco'),(3,'huaraz'),(1,'lima');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudadano` (
  `idCiudadano` int NOT NULL AUTO_INCREMENT,
  `idBarrio` int NOT NULL,
  `idPersona` int NOT NULL,
  PRIMARY KEY (`idCiudadano`),
  KEY `fk_Ciudadano_Barrio1_idx` (`idBarrio`),
  KEY `fk_Ciudadano_Persona1_idx` (`idPersona`),
  CONSTRAINT `fk_Ciudadano_Barrio1` FOREIGN KEY (`idBarrio`) REFERENCES `barrio` (`idBarrio`),
  CONSTRAINT `fk_Ciudadano_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudadano`
--

LOCK TABLES `ciudadano` WRITE;
/*!40000 ALTER TABLE `ciudadano` DISABLE KEYS */;
INSERT INTO `ciudadano` VALUES (5,2,13),(6,2,14),(7,1,16),(8,2,18),(9,7,19),(10,7,20),(11,5,22);
/*!40000 ALTER TABLE `ciudadano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criterio`
--

DROP TABLE IF EXISTS `criterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criterio` (
  `idCriterio` int NOT NULL AUTO_INCREMENT,
  `nomcrite` varchar(45) NOT NULL,
  `valormin` int NOT NULL,
  `valormax` int NOT NULL,
  PRIMARY KEY (`idCriterio`),
  UNIQUE KEY `nomcrite_UNIQUE` (`nomcrite`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criterio`
--

LOCK TABLES `criterio` WRITE;
/*!40000 ALTER TABLE `criterio` DISABLE KEYS */;
INSERT INTO `criterio` VALUES (1,'nivel de pobreza ',0,10),(2,'cantidad de hijos',0,10),(3,'ubicacion de distrito',0,10),(4,'nivel educativo',0,5),(5,'tipo de trabajo que realiza',5,20);
/*!40000 ALTER TABLE `criterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleevaluacion`
--

DROP TABLE IF EXISTS `detalleevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleevaluacion` (
  `idDetalleEvaluacion` int NOT NULL AUTO_INCREMENT,
  `valreva` int NOT NULL,
  `idCriterio` int NOT NULL,
  `idEvaluacion` int NOT NULL,
  PRIMARY KEY (`idDetalleEvaluacion`),
  KEY `fk_DetalleEvaluacion_Criterio1_idx` (`idCriterio`),
  KEY `fk_DetalleEvaluacion_Evaluacion1_idx` (`idEvaluacion`),
  CONSTRAINT `fk_DetalleEvaluacion_Criterio1` FOREIGN KEY (`idCriterio`) REFERENCES `criterio` (`idCriterio`),
  CONSTRAINT `fk_DetalleEvaluacion_Evaluacion1` FOREIGN KEY (`idEvaluacion`) REFERENCES `evaluacion` (`idEvaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleevaluacion`
--

LOCK TABLES `detalleevaluacion` WRITE;
/*!40000 ALTER TABLE `detalleevaluacion` DISABLE KEYS */;
INSERT INTO `detalleevaluacion` VALUES (9,5,2,8),(10,5,1,8),(11,5,4,8),(12,6,2,9),(13,10,1,9),(14,5,4,9),(15,0,3,9),(16,0,2,10),(17,2,4,10),(18,10,3,10),(19,10,2,11),(20,10,3,11),(21,10,1,11);
/*!40000 ALTER TABLE `detalleevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluacion` (
  `idEvaluacion` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hra` time DEFAULT NULL,
  `observacion` text,
  `idCiudadano` int NOT NULL,
  `idUsuario` int NOT NULL,
  `idValorVulnerabilidad` int NOT NULL,
  `estado` tinyint DEFAULT NULL,
  PRIMARY KEY (`idEvaluacion`),
  KEY `fk_Evaluacion_Ciudadano1_idx` (`idCiudadano`),
  KEY `fk_Evaluacion_Usuario1_idx` (`idUsuario`),
  KEY `fk_evaluacion_valorvulnerabilidad_idx` (`idValorVulnerabilidad`),
  CONSTRAINT `fk_Evaluacion_Ciudadano1` FOREIGN KEY (`idCiudadano`) REFERENCES `ciudadano` (`idCiudadano`),
  CONSTRAINT `fk_Evaluacion_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `fk_evaluacion_valorvulnerabilidad` FOREIGN KEY (`idValorVulnerabilidad`) REFERENCES `valorvulnerabilidad` (`idValorVulnerabilidad`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion`
--

LOCK TABLES `evaluacion` WRITE;
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
INSERT INTO `evaluacion` VALUES (8,'2020-10-23','15:59:11','jason no es pobre',5,1,14,1),(9,'2020-10-23','18:02:44','',7,1,15,1),(10,'2020-10-23','18:08:55','no es seleccionado',6,1,16,0),(11,'2020-10-23','18:28:25','este a lumno es my vulnerable',11,1,17,1);
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediocomunicacion`
--

DROP TABLE IF EXISTS `mediocomunicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mediocomunicacion` (
  `idMedioComunicacion` int NOT NULL AUTO_INCREMENT,
  `nommedio` varchar(45) DEFAULT NULL,
  `valormedio` varchar(45) DEFAULT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`idMedioComunicacion`),
  KEY `fk_MedioComunicacion_Usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_MedioComunicacion_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediocomunicacion`
--

LOCK TABLES `mediocomunicacion` WRITE;
/*!40000 ALTER TABLE `mediocomunicacion` DISABLE KEYS */;
INSERT INTO `mediocomunicacion` VALUES (2,'celular','78965234',1);
/*!40000 ALTER TABLE `mediocomunicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `dir` varchar(45) NOT NULL,
  `gen` varchar(15) NOT NULL,
  `apell` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (13,'12547896','jason','av raymondi','masculino','solano'),(14,'75248564','jose','av.luz','masculino','perez soto'),(16,'25874596','maria ','av.uni','femenino','sufuentes'),(17,'45865987','erik','av. universitaria','masculino','flores chakon'),(18,'68546323','elmer','av. raymondi','femenino','de la cruz'),(19,'85412321','elsa','av. los alamos','femenino','ugarte'),(20,'22123213','juana','av. los alamos','femenino','sufuentes'),(22,'55222222','jamil','av. portales','masculino','florentino macayo');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nomus` varchar(45) NOT NULL,
  `clavusr` varchar(45) NOT NULL,
  `idPersona` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nomus_UNIQUE` (`nomus`),
  KEY `fk_Usuario_Persona1_idx` (`idPersona`),
  CONSTRAINT `fk_Usuario_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',17);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_barrio`
--

DROP TABLE IF EXISTS `v_barrio`;
/*!50001 DROP VIEW IF EXISTS `v_barrio`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_barrio` AS SELECT 
 1 AS `idbarrio`,
 1 AS `barrio`,
 1 AS `ciudad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_ciudadano`
--

DROP TABLE IF EXISTS `v_ciudadano`;
/*!50001 DROP VIEW IF EXISTS `v_ciudadano`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_ciudadano` AS SELECT 
 1 AS `idciudadano`,
 1 AS `dni`,
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `genero`,
 1 AS `direccion`,
 1 AS `barrio`,
 1 AS `ciudad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_usuario`
--

DROP TABLE IF EXISTS `v_usuario`;
/*!50001 DROP VIEW IF EXISTS `v_usuario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_usuario` AS SELECT 
 1 AS `idUsuario`,
 1 AS `login`,
 1 AS `clave`,
 1 AS `dni`,
 1 AS `direccion`,
 1 AS `genero`,
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `medio`,
 1 AS `valormedio`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `valorvulnerabilidad`
--

DROP TABLE IF EXISTS `valorvulnerabilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valorvulnerabilidad` (
  `idValorVulnerabilidad` int NOT NULL AUTO_INCREMENT,
  `vlrminivul` int NOT NULL,
  PRIMARY KEY (`idValorVulnerabilidad`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valorvulnerabilidad`
--

LOCK TABLES `valorvulnerabilidad` WRITE;
/*!40000 ALTER TABLE `valorvulnerabilidad` DISABLE KEYS */;
INSERT INTO `valorvulnerabilidad` VALUES (14,15),(15,21),(16,12),(17,30);
/*!40000 ALTER TABLE `valorvulnerabilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'evaluacion'
--

--
-- Dumping routines for database 'evaluacion'
--
/*!50003 DROP PROCEDURE IF EXISTS `ingresar_ciudadano` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresar_ciudadano`( d varchar(255),nombre varchar(255),apellido varchar(255),direccion varchar(255),
genero varchar(255),bar varchar(255))
BEGIN



insert into persona values(null,d,nombre,direccion,genero,apellido);



 insert into ciudadano values(null,(select idbarrio  from v_barrio where barrio=bar),
(select idpersona from persona where dni=d));



select 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`( usuario varchar(255),clave varchar(255))
BEGIN
declare res int default -1;
select idusuario into res from usuario where nomus=usuario and clavusr=md5(clave);
select res;
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_barrio`
--

/*!50001 DROP VIEW IF EXISTS `v_barrio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_barrio` AS select `barrio`.`idBarrio` AS `idbarrio`,`barrio`.`nombarrio` AS `barrio`,`ciudad`.`nomciud` AS `ciudad` from (`ciudad` join `barrio` on((`ciudad`.`idCiudad` = `barrio`.`idCiudad`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_ciudadano`
--

/*!50001 DROP VIEW IF EXISTS `v_ciudadano`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_ciudadano` AS select `ciudadano`.`idCiudadano` AS `idciudadano`,`persona`.`dni` AS `dni`,`persona`.`nom` AS `nombre`,`persona`.`apell` AS `apellido`,`persona`.`gen` AS `genero`,`persona`.`dir` AS `direccion`,`v_barrio`.`barrio` AS `barrio`,`v_barrio`.`ciudad` AS `ciudad` from ((`persona` join `ciudadano` on((`persona`.`idPersona` = `ciudadano`.`idPersona`))) join `v_barrio` on((`v_barrio`.`idbarrio` = `ciudadano`.`idBarrio`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_usuario`
--

/*!50001 DROP VIEW IF EXISTS `v_usuario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_usuario` AS select `usuario`.`idUsuario` AS `idUsuario`,`usuario`.`nomus` AS `login`,`usuario`.`clavusr` AS `clave`,`persona`.`dni` AS `dni`,`persona`.`dir` AS `direccion`,`persona`.`gen` AS `genero`,`persona`.`nom` AS `nombre`,`persona`.`apell` AS `apellido`,`mediocomunicacion`.`nommedio` AS `medio`,`mediocomunicacion`.`valormedio` AS `valormedio` from ((`usuario` join `persona` on((`usuario`.`idPersona` = `persona`.`idPersona`))) join `mediocomunicacion` on((`mediocomunicacion`.`idUsuario` = `usuario`.`idUsuario`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-23 19:31:06
