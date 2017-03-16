-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: CuentasDB
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `Conceptos_Pago`
--

DROP TABLE IF EXISTS `Conceptos_Pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Conceptos_Pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(200) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Conceptos_Pago`
--

LOCK TABLES `Conceptos_Pago` WRITE;
/*!40000 ALTER TABLE `Conceptos_Pago` DISABLE KEYS */;
INSERT INTO `Conceptos_Pago` VALUES (1,'ARTICULOS DEL HOGAR ','ACTIVO'),(2,'CARNE PRIMERA CALIDAD','ACTIVO'),(3,'UTENSILIOS DE COCINA','ACTIVO'),(4,'PAGO COLEGIATURA','ACTIVO'),(6,'hola','activo');
/*!40000 ALTER TABLE `Conceptos_Pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Entrada_Docs`
--

DROP TABLE IF EXISTS `Entrada_Docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Entrada_Docs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_doc` date NOT NULL,
  `Monto` float NOT NULL,
  `Fecha_registro` date NOT NULL,
  `Proveedor` varchar(25) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Entrada_Docs`
--

LOCK TABLES `Entrada_Docs` WRITE;
/*!40000 ALTER TABLE `Entrada_Docs` DISABLE KEYS */;
INSERT INTO `Entrada_Docs` VALUES (1,'2017-01-17',13000,'2016-11-06','HOME DEPOT','ACTIVO'),(2,'2016-11-23',7400,'2015-04-12','IKEA,SA','ACTIVO'),(3,'2017-01-09',1000,'2016-01-11','CASTLE STUDIO ','activo'),(5,'2016-05-22',2500,'2015-09-24','ALMACENES UNIDOS, SA','ACTIVO');
/*!40000 ALTER TABLE `Entrada_Docs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedores`
--

DROP TABLE IF EXISTS `Proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Tipo_Persona` varchar(10) NOT NULL,
  `Cedula_Rnc` varchar(11) NOT NULL,
  `Balance` float NOT NULL,
  `Estado` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  UNIQUE KEY `Cedula_Rnc_UNIQUE` (`Cedula_Rnc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedores`
--

LOCK TABLES `Proveedores` WRITE;
/*!40000 ALTER TABLE `Proveedores` DISABLE KEYS */;
INSERT INTO `Proveedores` VALUES (3,'CARREFOUR','Fisica','113-40932-1',6000,'ACTIVO'),(4,'Patrick, SA','Fisica','40224747762',15000,'ACTIVO'),(5,'HIRO MOTORS, SRL','FISICA','003123451',34000,'ACTIVO');
/*!40000 ALTER TABLE `Proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Nombre_Usuario_UNIQUE` (`user`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'admin','1234');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'CuentasDB'
--

--
-- Dumping routines for database 'CuentasDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-16 12:32:45
