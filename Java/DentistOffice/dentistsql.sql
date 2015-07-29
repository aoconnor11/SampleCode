-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 27, 2012 at 01:02 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dentist`
--
CREATE DATABASE `dentist` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dentist`;

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `history` (
  `historyID` int(11) NOT NULL AUTO_INCREMENT,
  `conditionName` varchar(40) DEFAULT NULL,
  `dateOccurred` date DEFAULT NULL,
  `medication` varchar(60) DEFAULT NULL,
  `patientID` int(11) NOT NULL,
  PRIMARY KEY (`historyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `inv`
--

CREATE TABLE IF NOT EXISTS `inv` (
  `invoiceID` int(11) NOT NULL AUTO_INCREMENT,
  `invoiceAmt` double DEFAULT NULL,
  `invoiceDate` date DEFAULT NULL,
  `invoiceIsPaid` bit(1) NOT NULL DEFAULT b'0',
  `patientID` int(11) NOT NULL,
  PRIMARY KEY (`invoiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoiceID` int(11) NOT NULL AUTO_INCREMENT,
  `invoiceAmt` double DEFAULT NULL,
  `invoiceDate` date DEFAULT NULL,
  `invoiceIsPaid` bit(1) NOT NULL DEFAULT b'0',
  `patientID` int(11) NOT NULL,
  PRIMARY KEY (`invoiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `invoiceprocs`
--

CREATE TABLE IF NOT EXISTS `invoiceprocs` (
  `invoiceID` int(11) NOT NULL,
  `procedureID` int(11) NOT NULL,
  PRIMARY KEY (`invoiceID`,`procedureID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patientID` int(11) NOT NULL AUTO_INCREMENT,
  `patientName` varchar(50) DEFAULT NULL,
  `patientAddress` varchar(200) DEFAULT NULL,
  `patientPhone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`patientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `proc`
--

CREATE TABLE IF NOT EXISTS `proc` (
  `procedureID` int(11) NOT NULL AUTO_INCREMENT,
  `procName` varchar(50) DEFAULT NULL,
  `procCost` double DEFAULT NULL,
  PRIMARY KEY (`procedureID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `proc`
--

INSERT INTO `proc` (`procedureID`, `procName`, `procCost`) VALUES
(1, 'Filling', 70),
(2, 'Scale and Polish', 40),
(3, 'Examination & Diagnosis', 40),
(4, 'Prescription', 30),
(5, 'Gum Treatment', 190),
(6, 'X-Rays', 20),
(7, 'Routine Extraction', 70),
(8, 'Surgical Extraction', 100),
(9, 'Acrylic Dentures', 500),
(10, 'Metal Dentures', 800),
(11, 'Crown', 750),
(12, 'Core/Post Preparation', 100),
(13, 'Fissure Sealants', 25);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
