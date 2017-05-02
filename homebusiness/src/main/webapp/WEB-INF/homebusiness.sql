-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table homebusiness.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.animal: ~0 rows (approximately)
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

-- Dumping structure for table homebusiness.bus
CREATE TABLE IF NOT EXISTS `bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `busType` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `numberplate` varchar(30) DEFAULT NULL,
  `originalCost` decimal(20,2) DEFAULT NULL,
  `dateOfPurchase` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.bus: ~2 rows (approximately)
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT IGNORE INTO `bus` (`id`, `name`, `busType`, `manufacturer`, `model`, `numberplate`, `originalCost`, `dateOfPurchase`) VALUES
	(4, 'Hino', 'Small Bus', 'Toyota', '2003', 'AOB 3252', 210000.00, '2015-01-01 00:00:00'),
	(5, 'Rosa', 'Small Bus', 'Mitsubishi', '1998', 'AOB 3198', 176000.00, '2015-01-01 00:00:00');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;

-- Dumping structure for table homebusiness.busexpenses
CREATE TABLE IF NOT EXISTS `busexpenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfExpense` datetime DEFAULT NULL,
  `amount` double(30,0) DEFAULT NULL,
  `expenseType` varchar(255) DEFAULT NULL,
  `busId` int(11) DEFAULT NULL,
  `addedByUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `busexpenses_ibfk_1` (`busId`),
  CONSTRAINT `busexpenses_ibfk_1` FOREIGN KEY (`busId`) REFERENCES `bus` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.busexpenses: ~4 rows (approximately)
/*!40000 ALTER TABLE `busexpenses` DISABLE KEYS */;
INSERT IGNORE INTO `busexpenses` (`id`, `dateOfExpense`, `amount`, `expenseType`, `busId`, `addedByUserId`) VALUES
	(4, '2016-08-06 00:00:00', 50, 'no', 4, NULL),
	(5, '2010-06-09 00:00:00', 500, 'Ordinary', 5, NULL),
	(6, '2016-06-13 00:00:00', 100, 'Ordinary', 4, NULL),
	(7, '2016-11-01 00:00:00', 750, 'Necessity', 4, NULL);
/*!40000 ALTER TABLE `busexpenses` ENABLE KEYS */;

-- Dumping structure for table homebusiness.bussales
CREATE TABLE IF NOT EXISTS `bussales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfSale` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `busId` int(11) DEFAULT NULL,
  `addedByUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bussales_ibfk_1` (`busId`),
  CONSTRAINT `bussales_ibfk_1` FOREIGN KEY (`busId`) REFERENCES `bus` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.bussales: ~2 rows (approximately)
/*!40000 ALTER TABLE `bussales` DISABLE KEYS */;
INSERT IGNORE INTO `bussales` (`id`, `dateOfSale`, `description`, `amount`, `busId`, `addedByUserId`) VALUES
	(6, '2016-06-09 00:00:00', 'Luanshya', '1900.0', 5, NULL),
	(7, '2016-06-13 00:00:00', 'Solwezi', '1200.0', 4, NULL),
	(8, '2016-08-18 00:00:00', 'Good Sales', '5600.0', 4, NULL);
/*!40000 ALTER TABLE `bussales` ENABLE KEYS */;

-- Dumping structure for table homebusiness.bustype
CREATE TABLE IF NOT EXISTS `bustype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.bustype: ~2 rows (approximately)
/*!40000 ALTER TABLE `bustype` DISABLE KEYS */;
INSERT IGNORE INTO `bustype` (`id`, `name`) VALUES
	(1, 'Small Bus'),
	(2, 'Big Bus');
/*!40000 ALTER TABLE `bustype` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farm
CREATE TABLE IF NOT EXISTS `farm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `town` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `globalX` float DEFAULT NULL,
  `globalY` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farm: ~2 rows (approximately)
/*!40000 ALTER TABLE `farm` DISABLE KEYS */;
INSERT IGNORE INTO `farm` (`id`, `name`, `town`, `location`, `globalX`, `globalY`, `price`) VALUES
	(1, 'Kafubu Block Farm', 'Luanshya', 'Kafubu BLock', 0, 0, 2000),
	(5, 'Kafue Farm', 'Kafue', 'Kfue', 0, 0, 20000);
/*!40000 ALTER TABLE `farm` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farmarea
CREATE TABLE IF NOT EXISTS `farmarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmId` int(11) DEFAULT NULL,
  `lengthInMeters` float DEFAULT NULL,
  `breadthInMeters` float DEFAULT NULL,
  `primaryItem` varchar(50) DEFAULT NULL,
  `globalX` float DEFAULT NULL,
  `globalY` float DEFAULT NULL,
  `isActive` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_farmarea_farm` (`farmId`),
  CONSTRAINT `FK_farmarea_farm` FOREIGN KEY (`farmId`) REFERENCES `farm` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farmarea: ~4 rows (approximately)
/*!40000 ALTER TABLE `farmarea` DISABLE KEYS */;
INSERT IGNORE INTO `farmarea` (`id`, `farmId`, `lengthInMeters`, `breadthInMeters`, `primaryItem`, `globalX`, `globalY`, `isActive`) VALUES
	(1, 1, 20, 20, 'Maize/Corn', 0, 0, 1),
	(2, 1, 20, 20, 'Cassava', -18.55, 23.55, 1),
	(3, 1, 50, 50, 'Cows', NULL, NULL, 1),
	(5, 5, 50, 50, 'Maize/Corn', NULL, NULL, 1);
/*!40000 ALTER TABLE `farmarea` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farmareaanimal
CREATE TABLE IF NOT EXISTS `farmareaanimal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmAreaId` int(11) DEFAULT NULL,
  `animalId` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_farmareaanimal_farmarea` (`farmAreaId`),
  CONSTRAINT `FK_farmareaanimal_farmarea` FOREIGN KEY (`farmAreaId`) REFERENCES `farmarea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farmareaanimal: ~0 rows (approximately)
/*!40000 ALTER TABLE `farmareaanimal` DISABLE KEYS */;
/*!40000 ALTER TABLE `farmareaanimal` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farmareacrop
CREATE TABLE IF NOT EXISTS `farmareacrop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmAreaId` int(11) DEFAULT NULL,
  `plantId` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_farmareacrop_farmarea` (`farmAreaId`),
  CONSTRAINT `FK_farmareacrop_farmarea` FOREIGN KEY (`farmAreaId`) REFERENCES `farmarea` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farmareacrop: ~0 rows (approximately)
/*!40000 ALTER TABLE `farmareacrop` DISABLE KEYS */;
/*!40000 ALTER TABLE `farmareacrop` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farmexpense
CREATE TABLE IF NOT EXISTS `farmexpense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmId` int(11) DEFAULT NULL,
  `expenseName` varchar(50) DEFAULT NULL,
  `expenseType` varchar(50) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_farmexpense_farm` (`farmId`),
  CONSTRAINT `FK_farmexpense_farm` FOREIGN KEY (`farmId`) REFERENCES `farm` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farmexpense: ~2 rows (approximately)
/*!40000 ALTER TABLE `farmexpense` DISABLE KEYS */;
INSERT IGNORE INTO `farmexpense` (`id`, `farmId`, `expenseName`, `expenseType`, `amount`) VALUES
	(1, 1, 'Some (Important) Expense', 'General', 500),
	(2, 1, 'Fertilizer', 'Necessity', 2000);
/*!40000 ALTER TABLE `farmexpense` ENABLE KEYS */;

-- Dumping structure for table homebusiness.farmsales
CREATE TABLE IF NOT EXISTS `farmsales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `farmId` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `dateOfSales` datetime DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `FK_farmsales_farm` (`farmId`),
  CONSTRAINT `FK_farmsales_farm` FOREIGN KEY (`farmId`) REFERENCES `farm` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.farmsales: ~0 rows (approximately)
/*!40000 ALTER TABLE `farmsales` DISABLE KEYS */;
INSERT IGNORE INTO `farmsales` (`id`, `farmId`, `amount`, `dateOfSales`, `description`) VALUES
	(1, 1, 8000, '2016-12-24 22:16:13', 'Good');
/*!40000 ALTER TABLE `farmsales` ENABLE KEYS */;

-- Dumping structure for table homebusiness.plant
CREATE TABLE IF NOT EXISTS `plant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table homebusiness.plant: ~0 rows (approximately)
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
