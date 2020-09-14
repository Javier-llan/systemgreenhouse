DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `mantenimiento_creado_por` ()  NO SQL
SELECT mat.creado_por as creadoPor, mt.description_maintenace_green_house as mantenimiento, COUNT(mat.pk_used_material) as stdmantenimientos FROM useds_materials as mat 
INNER JOIN maintenances_green_house as mt ON mat.fk_maintenance_green_house = mt.pk_maintenance_green_house
GROUP BY mt.description_maintenace_green_house, mat.creado_por$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_invernadero_cantidad_usada` ()  NO SQL
SELECT inver.name_green_house as nombre,cm.type_material as tipomaterial, um.quantity_used as cantidad 
FROM useds_materials as um
INNER JOIN maintenances_green_house as mg ON um.fk_maintenance_green_house = mg.pk_maintenance_green_house
INNER JOIN chemical_and_materials as cm ON um.fk_chemical_material = cm.pk_chemical_material
INNER JOIN green_houses as inver ON mg.fk_green_house = inver.pk_green_house
GROUP BY mg.fk_green_house, tipomaterial$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_material_usado` ()  NO SQL
SELECT cm.name_material AS nombre, ((100*um.quantity_used)/cm.quantity_material) AS cantidad FROM useds_materials as um INNER JOIN chemical_and_materials AS cm ON um.fk_chemical_material = cm.pk_chemical_material GROUP By 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_plants_sowing` ()  NO SQL
SELECT pa.name_plant, sow.quantity_plants FROM sowings as sow INNER JOIN plants AS pa ON sow.fk_plant = pa.pk_plant GROUP By 1$$

DELIMITER ;



INSERT INTO `chemical_and_materials` (`pk_chemical_material`, `commentary`, `condition_stock`, `date_buy`, `description_material`, `image_chemicalmaterial`, `name_material`, `price_buy`, `quantity_material`, `type_material`, `unit_measure`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(1, 'N/A', 4, '2020-03-03', 'N/A', NULL, 'Tuberia', 4, '8', 'Madera', 'Kilogramos', NULL, NULL, NULL, NULL),
(2, 'N/A', NULL, '2020-03-03', 'N/A', NULL, 'Canaleta', 6, '20', 'Plastico', 'Kilogramos', NULL, NULL, NULL, NULL);



INSERT INTO `green_houses` (`pk_green_house`, `caliber_canal`, `caliber_ceiling_lateral`, `commentary_green_house`, `condition_green_house`, `dimension_green_house`, `name_green_house`) VALUES
(1, 5, 6, 'N/A', '4', 24, 'H100'),
(2, 2, 1, 'N/A', '5', 26, 'H200'),
(3, 6, 5, 'N/A', '4', 25, 'H300');



INSERT INTO `maintenances_green_house` (`pk_maintenance_green_house`, `commentary_maintenace_green_house`, `condition_maintenace_green_house`, `date_maintenance_green_house`, `description_maintenace_green_house`, `fk_green_house`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(3, 'N/A', 2, '2020-03-03', 'Cambio tuberias', 1, '2020-09-09 07:13:35', 'admin', NULL, NULL),
(4, 'N/A', 5, '2020-05-05', 'Cambio canaletas', 2, '2020-09-09 13:19:20', 'admin', NULL, NULL),
(5, 'N/A', 4, '2020-09-09', 'Cmabio de canaletas del invernadero', 3, '2020-09-09 15:37:37', 'admin', NULL, NULL),
(6, 'N/A', 5, '2020-09-09', 'Reparación de paredes', 2, '2020-09-09 15:39:22', 'admin', NULL, NULL);



INSERT INTO `plants` (`pk_plant`, `commentary`, `condition_plant`, `description_plant`, `image_plant`, `name_plant`, `type_plant`, `variety_plant`) VALUES
(1, 'N/A', 4, 'N/A', NULL, 'Tomate', 'Árboles', 'Bienales'),
(2, '', 4, 'N/A', NULL, 'Naranja', 'Árboles', 'Bienales'),
(3, 'N/A', 5, 'N/A', NULL, 'Manzana', 'Árboles', 'Perennes'),
(4, 'N/A', 4, 'N/A', NULL, 'Piña', 'Árboles', 'Anuales');



INSERT INTO `roles` (`pk_rol`, `nombre`, `fk_usuario`) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_USER', 2);



INSERT INTO `sowings` (`pk_sowing`, `commentary_sowing`, `condition_sowing`, `date_sowing`, `distance_plants`, `quantity_plants`, `fk_green_house`, `fk_plant`) VALUES
(11, 'N/A', 4, '2020-02-20', 5, 9, NULL, 1),
(12, 'N/A', 4, '2020-02-20', 5, 6, NULL, 2);


INSERT INTO `useds_materials` (`pk_used_material`, `quantity_used`, `fk_maintenance_green_house`, `fk_chemical_material`, `creado_en`, `creado_por`, `modificado_en`, `modificado_por`) VALUES
(2, 3, 3, 1, '2020-09-09 07:13:35', 'admin', NULL, NULL),
(3, 2, 4, 2, '2020-09-09 13:19:20', 'admin', NULL, NULL),
(4, 2, 4, 1, '2020-09-09 13:19:20', 'admin', NULL, NULL),
(5, 5, 5, 2, '2020-09-09 15:37:37', 'admin', NULL, NULL),
(6, 7, 5, 1, '2020-09-09 15:37:37', 'admin', NULL, NULL),
(7, 6, 6, 1, '2020-09-09 15:39:22', 'admin', NULL, NULL),
(8, 7, 6, 2, '2020-09-09 15:39:22', 'admin', NULL, NULL),
(9, 6, 6, 1, '2020-09-09 15:39:22', 'admin', NULL, NULL);


INSERT INTO `usuarios` (`pk_usuario`, `habilitado`, `nombre`, `password`) VALUES
(1, b'1', 'admin', '$2a$10$mVMoTlKGmsOqm7g8lXgjx.vvPHx4jUg3P7c0EpX5R9vef5WkzWOwG'),
(2, b'1', 'django', '$2a$10$OZRdvN.DiVe7HfX0rkUdTeWk7wFM0zXn3YKr6Y2KH.YMSyER6VBPS');

