-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 13-09-2020 a las 22:57:46
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbgreenhouse`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `mantenimiento_creado_por`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mantenimiento_creado_por` ()  NO SQL
SELECT mat.creado_por as creadoPor, mt.description_maintenace_green_house as mantenimiento, COUNT(mat.pk_used_material) as stdmantenimientos FROM useds_materials as mat 
INNER JOIN maintenances_green_house as mt ON mat.fk_maintenance_green_house = mt.pk_maintenance_green_house
GROUP BY mt.description_maintenace_green_house, mat.creado_por$$

DROP PROCEDURE IF EXISTS `reporte_invernadero_cantidad_usada`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_invernadero_cantidad_usada` ()  NO SQL
SELECT inver.name_green_house as nombre,cm.type_material as tipomaterial, um.quantity_used as cantidad 
FROM useds_materials as um
INNER JOIN maintenances_green_house as mg ON um.fk_maintenance_green_house = mg.pk_maintenance_green_house
INNER JOIN chemical_and_materials as cm ON um.fk_chemical_material = cm.pk_chemical_material
INNER JOIN green_houses as inver ON mg.fk_green_house = inver.pk_green_house
GROUP BY mg.fk_green_house, tipomaterial$$

DROP PROCEDURE IF EXISTS `reporte_material_usado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_material_usado` ()  NO SQL
SELECT cm.name_material AS nombre, ((100*um.quantity_used)/cm.quantity_material) AS cantidad FROM useds_materials as um INNER JOIN chemical_and_materials AS cm ON um.fk_chemical_material = cm.pk_chemical_material GROUP By 1$$

DROP PROCEDURE IF EXISTS `reporte_plants_sowing`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_plants_sowing` ()  NO SQL
SELECT pa.name_plant, COUNT(sow.pk_sowing) AS sow FROM sowings as sow INNER JOIN plants AS pa ON sow.fk_plant = pa.pk_plant GROUP By 1$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chemicals_useds`
--

DROP TABLE IF EXISTS `chemicals_useds`;
CREATE TABLE IF NOT EXISTS `chemicals_useds` (
  `pk_chemical_used` int(11) NOT NULL AUTO_INCREMENT,
  `quantity_supply` double DEFAULT NULL,
  `fk_chemical_material` int(11) DEFAULT NULL,
  `fk_treatment_swoing` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_chemical_used`),
  KEY `FK9fvasbmf34r9mp02g38vu8dav` (`fk_chemical_material`),
  KEY `FK8yjkavo6gp3rnsiscwovnuadt` (`fk_treatment_swoing`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chemical_and_materials`
--

DROP TABLE IF EXISTS `chemical_and_materials`;
CREATE TABLE IF NOT EXISTS `chemical_and_materials` (
  `pk_chemical_material` int(11) NOT NULL AUTO_INCREMENT,
  `commentary` varchar(255) DEFAULT NULL,
  `condition_stock` int(11) DEFAULT NULL,
  `date_buy` date DEFAULT NULL,
  `description_material` varchar(255) DEFAULT NULL,
  `image_chemicalmaterial` varchar(255) DEFAULT NULL,
  `name_material` varchar(255) DEFAULT NULL,
  `price_buy` double DEFAULT NULL,
  `quantity_material` varchar(255) DEFAULT NULL,
  `type_material` varchar(255) DEFAULT NULL,
  `unit_measure` varchar(255) DEFAULT NULL,
  `creado_en` datetime DEFAULT NULL,
  `creado_por` varchar(255) DEFAULT NULL,
  `modificado_en` datetime DEFAULT NULL,
  `modificado_por` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_chemical_material`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `chemical_and_materials`
--

INSERT INTO `chemical_and_materials` (`pk_chemical_material`, `commentary`, `condition_stock`, `date_buy`, `description_material`, `image_chemicalmaterial`, `name_material`, `price_buy`, `quantity_material`, `type_material`, `unit_measure`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(2, 'NA', 2, '2020-08-05', 'Lista', 'plantadelimon.jpg', 'Fertilizante', 20, '20', 'Quimico', 'Kilogramos', NULL, NULL, NULL, NULL),
(5, 'NA', 3, '2020-09-12', 'Plastico', 'plasticoTuberia.jpg', 'Plastico', 20, '30', 'Tuberia', 'Kilogramos', NULL, NULL, NULL, NULL),
(6, 'NA', 4, '2020-09-12', 'BASE', 'madera.jpg', 'Madera', 200, '400', 'Madera', 'Kilogramos', NULL, NULL, NULL, NULL),
(7, 'NA', 5, '2020-09-13', 'BASE', 'aluminio.jpg', 'Aluminio', 45, '500', 'Aluminio', 'Kilogramos', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `green_houses`
--

DROP TABLE IF EXISTS `green_houses`;
CREATE TABLE IF NOT EXISTS `green_houses` (
  `pk_green_house` int(11) NOT NULL AUTO_INCREMENT,
  `caliber_canal` int(11) DEFAULT NULL,
  `caliber_ceiling_lateral` int(11) DEFAULT NULL,
  `commentary_green_house` varchar(255) DEFAULT NULL,
  `condition_green_house` varchar(255) DEFAULT NULL,
  `dimension_green_house` double DEFAULT NULL,
  `name_green_house` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_green_house`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `green_houses`
--

INSERT INTO `green_houses` (`pk_green_house`, `caliber_canal`, `caliber_ceiling_lateral`, `commentary_green_house`, `condition_green_house`, `dimension_green_house`, `name_green_house`) VALUES
(1, 2, 2, 'NA', '2', 12, 'San Luis'),
(2, 12, 12, 'NA', '2', 12, 'Restourt'),
(3, 23, 22, 'NA', '5', 23, 'Esperanza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `harvests`
--

DROP TABLE IF EXISTS `harvests`;
CREATE TABLE IF NOT EXISTS `harvests` (
  `pk_harvest` int(11) NOT NULL AUTO_INCREMENT,
  `commentary_harvest` varchar(255) DEFAULT NULL,
  `condition_harvest` int(11) DEFAULT NULL,
  `date_harvest` datetime DEFAULT NULL,
  `lot_box_classifield` int(11) DEFAULT NULL,
  `lot_box_unclassifield` int(11) DEFAULT NULL,
  `lot_firts_class` int(11) DEFAULT NULL,
  `lot_second_class` int(11) DEFAULT NULL,
  `lot_thrid_class` int(11) DEFAULT NULL,
  `fk_sowing` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_harvest`),
  KEY `FKek6i3w7ckivs4hblqd4er06h9` (`fk_sowing`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maintenances_green_house`
--

DROP TABLE IF EXISTS `maintenances_green_house`;
CREATE TABLE IF NOT EXISTS `maintenances_green_house` (
  `pk_maintenance_green_house` int(11) NOT NULL AUTO_INCREMENT,
  `commentary_maintenace_green_house` varchar(255) DEFAULT NULL,
  `condition_maintenace_green_house` int(11) DEFAULT NULL,
  `date_maintenance_green_house` datetime DEFAULT NULL,
  `description_maintenace_green_house` varchar(255) DEFAULT NULL,
  `fk_green_house` int(11) DEFAULT NULL,
  `creado_en` datetime DEFAULT NULL,
  `creado_por` varchar(255) DEFAULT NULL,
  `modificado_en` datetime DEFAULT NULL,
  `modificado_por` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_maintenance_green_house`),
  KEY `FK2k5odwl2fntqd46q4aw1iws03` (`fk_green_house`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `maintenances_green_house`
--

INSERT INTO `maintenances_green_house` (`pk_maintenance_green_house`, `commentary_maintenace_green_house`, `condition_maintenace_green_house`, `date_maintenance_green_house`, `description_maintenace_green_house`, `fk_green_house`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(8, 'NA', 4, '2020-09-06 00:00:00', 'Se rego fertilizante', 2, '2020-09-13 18:32:55', 'ceciliaramos', NULL, NULL),
(7, 'NA', 3, '2020-09-11 00:00:00', 'Se mejoro las paredes', 2, '2020-09-13 18:31:36', ' 	micaelaruiz', NULL, NULL),
(6, 'Listo', 4, '2020-09-13 00:00:00', 'Se areglaron las tuberias', 1, '2020-09-13 18:28:47', ' 	micaelaruiz', NULL, NULL),
(9, 'NA', 5, '2020-09-13 00:00:00', 'Canaletas ', 3, '2020-09-13 18:34:48', ' 	micaelaruiz', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plants`
--

DROP TABLE IF EXISTS `plants`;
CREATE TABLE IF NOT EXISTS `plants` (
  `pk_plant` int(11) NOT NULL AUTO_INCREMENT,
  `commentary` varchar(255) DEFAULT NULL,
  `condition_plant` int(11) DEFAULT NULL,
  `description_plant` varchar(255) DEFAULT NULL,
  `image_plant` varchar(255) DEFAULT NULL,
  `name_plant` varchar(255) DEFAULT NULL,
  `type_plant` varchar(255) DEFAULT NULL,
  `variety_plant` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_plant`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `plants`
--

INSERT INTO `plants` (`pk_plant`, `commentary`, `condition_plant`, `description_plant`, `image_plant`, `name_plant`, `type_plant`, `variety_plant`) VALUES
(18, 'NA', 3, 'NA', 'plantadeaguacate.jpg', 'Planta de Manzana', 'Árboles', 'Anuales'),
(17, 'NA', 4, 'NA', 'plantademango.jpg', 'Planta de Tomate de Riñon', 'Árboles', 'Anuales'),
(16, 'NA', 3, 'NA', 'plantadeaguacate.jpg', 'Planta de Aguacate', 'Árboles', 'Anuales'),
(15, '12', 3, '12', 'plantademango.jpg', 'Planta de Mango', 'Árboles', 'Anuales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `pk_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `fk_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_rol`),
  UNIQUE KEY `UKnk2slx994dv48ll8clgiyoygb` (`fk_usuario`,`nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`pk_rol`, `nombre`, `fk_usuario`) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_ADMIN', 2),
(4, 'ROLE_USER', 4),
(5, 'ROLE_USER', 5),
(6, 'ROLE_USER', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sowings`
--

DROP TABLE IF EXISTS `sowings`;
CREATE TABLE IF NOT EXISTS `sowings` (
  `pk_sowing` int(11) NOT NULL AUTO_INCREMENT,
  `commentary_sowing` varchar(255) DEFAULT NULL,
  `condition_sowing` int(11) DEFAULT NULL,
  `date_sowing` datetime DEFAULT NULL,
  `distance_plants` int(11) DEFAULT NULL,
  `quantity_plants` int(11) DEFAULT NULL,
  `fk_green_house` int(11) DEFAULT NULL,
  `fk_plant` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_sowing`),
  KEY `FK4x50x3s1cdew1d4aqwfh973qq` (`fk_green_house`),
  KEY `FK4j09kuqkcj20c9jnf0m0k7oyg` (`fk_plant`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sowings`
--

INSERT INTO `sowings` (`pk_sowing`, `commentary_sowing`, `condition_sowing`, `date_sowing`, `distance_plants`, `quantity_plants`, `fk_green_house`, `fk_plant`) VALUES
(81, 'NAA', 1, '2020-09-18 00:00:00', 21, 21, NULL, 18),
(67, 'NA', 3, '2020-09-12 00:00:00', 12, 12, NULL, 18),
(66, 'P', 3, '2020-09-18 00:00:00', 21, 21, NULL, 17),
(65, 'NA', 3, '2020-09-18 00:00:00', 60, 60, NULL, 15),
(64, 'NA', 3, '2020-09-18 00:00:00', 54, 54, NULL, 15),
(63, 'F', 3, '2020-09-13 00:00:00', 40, 40, NULL, 15),
(62, 'm', 4, '2020-09-18 00:00:00', 4, 4, NULL, 16),
(61, 'N', 3, '2020-09-13 00:00:00', 45, 45, NULL, 16),
(69, 'Na', 3, '2020-09-12 00:00:00', 30, 30, NULL, 18),
(70, 'L', 2, '2020-09-18 00:00:00', 30, 30, NULL, 18),
(71, 'M', 3, '2020-09-12 00:00:00', 10, 10, NULL, 18),
(72, 'N', 1, '2020-09-13 00:00:00', 10, 10, NULL, 18),
(73, 'Q', 3, '2020-09-13 00:00:00', 20, 20, NULL, 18),
(74, 'R', 5, '2020-09-13 00:00:00', 21, 21, NULL, 18),
(75, 'T', 1, '2020-09-14 00:00:00', 13, 13, NULL, 18),
(76, 'U', 4, '2020-09-14 00:00:00', 15, 16, NULL, 18),
(77, 'W', 4, '2020-09-16 00:00:00', 21, 21, NULL, 18),
(78, 'X', 1, '2020-09-17 00:00:00', 31, 31, NULL, 18),
(79, 'A', 5, '2020-09-17 00:00:00', 45, 45, NULL, 18),
(80, 'B', 2, '2020-09-18 00:00:00', 41, 31, NULL, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `treatments_sowing`
--

DROP TABLE IF EXISTS `treatments_sowing`;
CREATE TABLE IF NOT EXISTS `treatments_sowing` (
  `pk_treatment_swoing` int(11) NOT NULL AUTO_INCREMENT,
  `commentary_treatment_sowing` varchar(255) DEFAULT NULL,
  `condtion_treatment_sowing` int(11) DEFAULT NULL,
  `date_treatment_sowing` datetime DEFAULT NULL,
  `description_treatment_sowing` varchar(255) DEFAULT NULL,
  `fk_sowing` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk_treatment_swoing`),
  KEY `FKmyvstdqgevk7e819igu77o2hj` (`fk_sowing`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `treatments_sowing`
--

INSERT INTO `treatments_sowing` (`pk_treatment_swoing`, `commentary_treatment_sowing`, `condtion_treatment_sowing`, `date_treatment_sowing`, `description_treatment_sowing`, `fk_sowing`) VALUES
(1, 'NA', 2, '2020-09-02 00:00:00', 'LISTO', 69),
(2, 'NA', 2, '2020-09-02 00:00:00', 'LISTO', 69);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `useds_materials`
--

DROP TABLE IF EXISTS `useds_materials`;
CREATE TABLE IF NOT EXISTS `useds_materials` (
  `pk_used_material` int(11) NOT NULL AUTO_INCREMENT,
  `quantity_used` int(11) DEFAULT NULL,
  `fk_maintenance_green_house` int(11) DEFAULT NULL,
  `fk_chemical_material` int(11) DEFAULT NULL,
  `creado_en` datetime DEFAULT NULL,
  `creado_por` varchar(255) DEFAULT NULL,
  `modificado_en` datetime DEFAULT NULL,
  `modificado_por` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_used_material`),
  KEY `FKeigv0lmspe0en4dc3a5vig7k5` (`fk_maintenance_green_house`),
  KEY `FK58oy61j7x5iq96e5wt2w1ualn` (`fk_chemical_material`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `useds_materials`
--

INSERT INTO `useds_materials` (`pk_used_material`, `quantity_used`, `fk_maintenance_green_house`, `fk_chemical_material`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(1, 10, 3, 2, '2020-09-09 15:04:21', 'admin', NULL, NULL),
(2, 12, 3, 5, '2020-09-09 15:04:21', 'admin', NULL, NULL),
(4, 30, 5, 2, '2020-09-13 17:33:41', 'admin', NULL, NULL),
(5, 150, 6, 7, '2020-09-13 18:28:47', 'admin', NULL, NULL),
(6, 15, 6, 5, '2020-09-13 18:28:48', 'admin', NULL, NULL),
(7, 40, 7, 6, '2020-09-13 18:31:36', 'admin', NULL, NULL),
(8, 10, 7, 7, '2020-09-13 18:31:36', 'admin', NULL, NULL),
(9, 20, 8, 2, '2020-09-13 18:32:55', 'admin', NULL, NULL),
(10, 20, 9, 7, '2020-09-13 18:34:48', 'admin', NULL, NULL),
(11, 5, 9, 5, '2020-09-13 18:34:48', 'admin', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `pk_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `habilitado` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_usuario`),
  UNIQUE KEY `UK_io49vjba68pmbgpy9vtw8vm81` (`nombre`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`pk_usuario`, `habilitado`, `nombre`, `password`) VALUES
(1, b'1', 'ceciliaramos', '$2a$10$Q8dI/JhyufGPDiWp5Q4ZQ.TBWcVZrZ0go7VlTEfFk7tvbUIsr3CKC'),
(2, b'1', 'micaelaruiz', '$2a$10$tLBcBq0q5G29ESqHKcg6EuGwluWoXmXZlNk2KvSHbeWPz6G1sumFW'),
(4, b'1', 'jeffpanchi', '$2a$10$vrBaSE6Hcil2F4ltWlOZ9uNCPRfQlLxyVyXcs1NwPrjiwUEp2sSAG'),
(5, b'1', 'javierllango', '$2a$10$abi6XJ8hTJouDxjjx0VMnO6pHQPSmp.oQfpOSSTfrPv7atWizB.vW'),
(6, b'1', 'yadiramendoza2', '$2a$10$ZF3UXk2PFjxdMZL6/7byE.T7ExGnaN8ph.tfXhMJx2LqhmjbvHkCO');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
