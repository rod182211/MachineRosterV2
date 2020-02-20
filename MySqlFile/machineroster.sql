-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 20, 2020 at 03:08 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `machineroster`
--

-- --------------------------------------------------------

--
-- Table structure for table `calendardata`
--

CREATE TABLE `calendardata` (
  `id` bigint(20) NOT NULL,
  `employeename` varchar(255) DEFAULT NULL,
  `endTime` varchar(255) DEFAULT NULL,
  `isNight` bit(1) NOT NULL,
  `shiftDate` date DEFAULT NULL,
  `shiftDescription` varchar(255) DEFAULT NULL,
  `shiftType` varchar(255) DEFAULT NULL,
  `startTIme` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `weekendDefinition` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`id`, `code`, `description`, `weekendDefinition`) VALUES
(7, 'FT', 'FullTime', 'SATURDAY_SUNDAY');

-- --------------------------------------------------------

--
-- Table structure for table `contractline`
--

CREATE TABLE `contractline` (
  `type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `contractLineType` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `maximumEnabled` bit(1) DEFAULT NULL,
  `maximumValue` int(11) DEFAULT NULL,
  `maximumWeight` int(11) DEFAULT NULL,
  `minimumEnabled` bit(1) DEFAULT NULL,
  `minimumValue` int(11) DEFAULT NULL,
  `minimumWeight` int(11) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contractline`
--

INSERT INTO `contractline` (`type`, `id`, `contractLineType`, `enabled`, `weight`, `maximumEnabled`, `maximumValue`, `maximumWeight`, `minimumEnabled`, `minimumValue`, `minimumWeight`, `contract_id`) VALUES
('BooleanContractLine', 70, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 71, 'COMPLETE_WEEKENDS', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 72, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 73, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 74, 'ALTERNATIVE_SKILL_CATEGORY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 75, 'ALTERNATIVE_MACHINE', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 76, 'IS_LOADBALANCED', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('BooleanContractLine', 77, 'IS_CASUAL', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 7),
('MinMaxContractLine', 78, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 1, b'1', 10, 1, 7),
('MinMaxContractLine', 79, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'0', 0, 0, 7),
('MinMaxContractLine', 80, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 7),
('MinMaxContractLine', 81, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 7),
('MinMaxContractLine', 82, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 7),
('MinMaxContractLine', 83, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 7);

-- --------------------------------------------------------

--
-- Table structure for table `coverrequirements`
--

CREATE TABLE `coverrequirements` (
  `id` bigint(20) NOT NULL,
  `dayOfWeek` int(11) DEFAULT NULL,
  `requiredEmployeesize` int(11) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coverrequirements`
--

INSERT INTO `coverrequirements` (`id`, `dayOfWeek`, `requiredEmployeesize`, `shiftType_id`) VALUES
(40, 0, 2, 21),
(41, 1, 2, 21),
(42, 2, 2, 21),
(43, 3, 2, 21),
(44, 4, 2, 21),
(45, 0, 2, 23),
(46, 1, 2, 23),
(47, 2, 2, 23),
(48, 3, 2, 23),
(49, 4, 2, 23),
(50, 0, 2, 24),
(51, 1, 2, 24),
(52, 2, 2, 24),
(53, 3, 2, 24),
(54, 4, 2, 24),
(55, 0, 2, 25),
(56, 1, 2, 25),
(57, 2, 2, 25),
(58, 3, 2, 25),
(59, 4, 2, 25),
(60, 0, 2, 26),
(61, 1, 2, 26),
(62, 2, 2, 26),
(63, 3, 2, 26),
(64, 4, 2, 26),
(65, 0, 2, 27),
(66, 1, 2, 27),
(67, 2, 2, 27),
(68, 3, 2, 27),
(69, 4, 2, 27);

-- --------------------------------------------------------

--
-- Table structure for table `dayoffdate`
--

CREATE TABLE `dayoffdate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dayoffrequest`
--

CREATE TABLE `dayoffrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dayondate`
--

CREATE TABLE `dayondate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `dayonrequest`
--

CREATE TABLE `dayonrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `contactdetails` varchar(255) DEFAULT NULL,
  `employeeId` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `streetnum` varchar(255) DEFAULT NULL,
  `suburb` varchar(255) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `code`, `contactdetails`, `employeeId`, `name`, `postcode`, `streetnum`, `suburb`, `contract_id`) VALUES
(85, '', '1', '', '1', '1', '', '', '', 7),
(90, '', '2', '', '2', '2', '', '', '', 7),
(96, '', '3', '', '3', '3', '', '', '', 7),
(103, '', '4', '', '4', '4', '', '', '', 7),
(108, '', '5', '', '5', '5', '', '', '', 7),
(114, '', '6', '', '6', '6', '', '', '', 7),
(124, '', '7', '', '7', '7', '', '', '', 7),
(130, '', '8', '', '8', '8', '', '', '', 7),
(135, '', '9', '', '9', '9', '', '', '', 7),
(142, '', '10', '', '10', '10', '', '', '', 7),
(148, '', '11', '', '11', '11', '', '', '', 7),
(155, '', '12', '', '12', '12', '', '', '', 7);

-- --------------------------------------------------------

--
-- Table structure for table `employeemachine`
--

CREATE TABLE `employeemachine` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `machine_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employeemachine`
--

INSERT INTO `employeemachine` (`id`, `employee_id`, `machine_id`) VALUES
(309, 114, 10),
(308, 114, 9),
(307, 114, 8),
(305, 108, 10),
(304, 108, 9),
(303, 108, 8),
(301, 103, 10),
(300, 103, 9),
(299, 103, 8),
(297, 96, 10),
(296, 96, 9),
(295, 96, 8),
(314, 124, 10),
(313, 124, 9),
(312, 124, 8),
(319, 130, 10),
(318, 130, 9),
(317, 130, 8),
(323, 135, 10),
(322, 135, 9),
(321, 135, 8),
(337, 142, 10),
(336, 142, 9),
(335, 142, 8),
(327, 148, 10),
(326, 148, 9),
(325, 148, 8),
(332, 155, 10),
(331, 155, 9),
(330, 155, 8),
(293, 90, 10),
(292, 90, 9),
(291, 90, 8),
(339, 85, 8),
(340, 85, 9),
(341, 85, 10);

-- --------------------------------------------------------

--
-- Table structure for table `employee_dayoffrequest`
--

CREATE TABLE `employee_dayoffrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_dayonrequest`
--

CREATE TABLE `employee_dayonrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_holidayrequest`
--

CREATE TABLE `employee_holidayrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `holidayRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_leaverequest`
--

CREATE TABLE `employee_leaverequest` (
  `Employee_id` bigint(20) NOT NULL,
  `leaveMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_rosterday`
--

CREATE TABLE `employee_rosterday` (
  `Employee_id` bigint(20) NOT NULL,
  `rosterdayMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_shiftoffrequest`
--

CREATE TABLE `employee_shiftoffrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_shiftonrequest`
--

CREATE TABLE `employee_shiftonrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employee_trainingrequest`
--

CREATE TABLE `employee_trainingrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `trainingRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343),
(343);

-- --------------------------------------------------------

--
-- Table structure for table `holidayrequest`
--

CREATE TABLE `holidayrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `endshiftDate_id` bigint(20) DEFAULT NULL,
  `startshiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `holidaysdata`
--

CREATE TABLE `holidaysdata` (
  `id` bigint(20) NOT NULL,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `leavedata`
--

CREATE TABLE `leavedata` (
  `id` bigint(20) NOT NULL,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `leaverequest`
--

CREATE TABLE `leaverequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `endshiftDate_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `startshiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `machine`
--

CREATE TABLE `machine` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `machine`
--

INSERT INTO `machine` (`id`, `code`) VALUES
(8, 'M1'),
(9, 'M2'),
(10, 'M3');

-- --------------------------------------------------------

--
-- Table structure for table `machinetypeskillsrequirement`
--

CREATE TABLE `machinetypeskillsrequirement` (
  `id` bigint(20) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `machinetypeskillsrequirement`
--

INSERT INTO `machinetypeskillsrequirement` (`id`, `machine_id`, `skill_id`, `shiftType_id`) VALUES
(263, 10, 1, 30),
(262, 10, 4, 29),
(261, 10, 4, 28),
(260, 9, 2, 27),
(259, 9, 3, 26),
(258, 9, 6, 25),
(257, 8, 2, 24),
(256, 8, 2, 23),
(255, 8, 1, 21),
(342, 8, 2, 21);

-- --------------------------------------------------------

--
-- Table structure for table `pattern`
--

CREATE TABLE `pattern` (
  `type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `freeDayOfWeek` int(11) DEFAULT NULL,
  `freeDayLength` int(11) DEFAULT NULL,
  `workDayOfWeek` int(11) DEFAULT NULL,
  `shiftLength` int(11) DEFAULT NULL,
  `workShiftType_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `dayIndex0ShiftType_id` bigint(20) DEFAULT NULL,
  `dayIndex1ShiftType_id` bigint(20) DEFAULT NULL,
  `dayIndex2ShiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pattern`
--

INSERT INTO `pattern` (`type`, `id`, `code`, `weight`, `freeDayOfWeek`, `freeDayLength`, `workDayOfWeek`, `shiftLength`, `workShiftType_id`, `employee_id`, `dayIndex0ShiftType_id`, `dayIndex1ShiftType_id`, `dayIndex2ShiftType_id`) VALUES
('WorkBefore', 84, '2DaysOff', 1, NULL, 2, NULL, NULL, 24, NULL, NULL, NULL, NULL),
('Shift2Days', 165, 'NE', 1, NULL, NULL, NULL, NULL, NULL, NULL, 24, 21, NULL),
('Shift2Days', 166, 'NEM2', 1, NULL, NULL, NULL, NULL, NULL, NULL, 27, 25, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patterncontractline`
--

CREATE TABLE `patterncontractline` (
  `id` bigint(20) NOT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `pattern_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `patterncontractline`
--

INSERT INTO `patterncontractline` (`id`, `contract_id`, `pattern_id`) VALUES
(167, 7, 165),
(168, 7, 166);

-- --------------------------------------------------------

--
-- Table structure for table `rosterday`
--

CREATE TABLE `rosterday` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rosterdayoff`
--

CREATE TABLE `rosterdayoff` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rosterparametrizationdata`
--

CREATE TABLE `rosterparametrizationdata` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rosterparametrizationdata`
--

INSERT INTO `rosterparametrizationdata` (`id`, `code`, `endDate`, `startDate`) VALUES
(0, 'First', '2020-02-29', '2020-02-16');

-- --------------------------------------------------------

--
-- Table structure for table `shift`
--

CREATE TABLE `shift` (
  `id` bigint(20) NOT NULL,
  `shift_index` int(11) DEFAULT NULL,
  `requiredEmployeeSize` int(11) NOT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shiftdate`
--

CREATE TABLE `shiftdate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `dayIndex` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shiftoffdate`
--

CREATE TABLE `shiftoffdate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shiftoffrequest`
--

CREATE TABLE `shiftoffrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shiftondate`
--

CREATE TABLE `shiftondate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shiftonrequest`
--

CREATE TABLE `shiftonrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shifttype`
--

CREATE TABLE `shifttype` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endTimeString` varchar(255) DEFAULT NULL,
  `Shift_index` int(11) DEFAULT NULL,
  `night` bit(1) NOT NULL,
  `startTimeString` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shifttype`
--

INSERT INTO `shifttype` (`id`, `code`, `description`, `endTimeString`, `Shift_index`, `night`, `startTimeString`) VALUES
(21, 'EM1', 'Early Machine 1', '14:00:00', 0, b'0', '06:30:00'),
(23, 'LM1', 'Late Machine 1', '23:00:00', 0, b'0', '16:30:00'),
(24, 'NM1', 'Night Machine 1', '06:00:00', 0, b'1', '23:00:00'),
(25, 'EM2', 'Early Machine 2', '16:30:00', 0, b'0', '06:30:00'),
(26, 'LM2', 'Late Machine 2', '23:00:00', 0, b'0', '16:00:00'),
(27, 'NM2', 'Night Machine 2', '06:30:00', 0, b'1', '23:00:00'),
(28, 'EM3', 'Early Machine 3', '14:30:00', 0, b'0', '06:30:00'),
(29, 'LM3', 'Late Machine 3', '23:00:00', 0, b'0', '16:00:00'),
(30, 'NM3', 'Night Machine 3', '06:30:00', 0, b'1', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `shifttypemachinerequirement`
--

CREATE TABLE `shifttypemachinerequirement` (
  `id` bigint(20) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shifttypemachinerequirement`
--

INSERT INTO `shifttypemachinerequirement` (`id`, `machine_id`, `shiftType_id`) VALUES
(172, 8, 21),
(173, 8, 23),
(174, 8, 24),
(175, 9, 25),
(176, 9, 26),
(177, 9, 27),
(178, 10, 28),
(179, 10, 29),
(180, 10, 30);

-- --------------------------------------------------------

--
-- Table structure for table `shifttypeskillrequirement`
--

CREATE TABLE `shifttypeskillrequirement` (
  `id` bigint(20) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`id`, `code`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3'),
(4, 'E4'),
(5, 'E5'),
(6, 'E6');

-- --------------------------------------------------------

--
-- Table structure for table `skillproficiency`
--

CREATE TABLE `skillproficiency` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skillproficiency`
--

INSERT INTO `skillproficiency` (`id`, `employee_id`, `skill_id`) VALUES
(290, 90, 2),
(338, 85, 6),
(294, 96, 3),
(298, 103, 2),
(302, 108, 4),
(306, 114, 2),
(310, 124, 3),
(311, 124, 4),
(315, 130, 4),
(316, 130, 5),
(320, 135, 1),
(324, 148, 2),
(328, 155, 2),
(329, 155, 4),
(333, 142, 2),
(334, 142, 5);

-- --------------------------------------------------------

--
-- Table structure for table `trainingdata`
--

CREATE TABLE `trainingdata` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `shiftType` varchar(255) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `trainingrequest`
--

CREATE TABLE `trainingrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `calendardata`
--
ALTER TABLE `calendardata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contractline`
--
ALTER TABLE `contractline`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKks3iwiv1kvajype73v2svgiyd` (`contract_id`);

--
-- Indexes for table `coverrequirements`
--
ALTER TABLE `coverrequirements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb4hwhwkauwgm5rcw2dwsouv46` (`shiftType_id`);

--
-- Indexes for table `dayoffdate`
--
ALTER TABLE `dayoffdate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgkvvcng0n9yquha8lsx09yggb` (`employee_id`);

--
-- Indexes for table `dayoffrequest`
--
ALTER TABLE `dayoffrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpyo1oqn1e3qxh7y77xnpr8or0` (`employee_id`),
  ADD KEY `FKcnjmka6kk5ftuk18ah5tldamy` (`shiftDate_id`);

--
-- Indexes for table `dayondate`
--
ALTER TABLE `dayondate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3i08ea64l262vh0753gbyd9p4` (`employee_id`);

--
-- Indexes for table `dayonrequest`
--
ALTER TABLE `dayonrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmfetwkpiyl15ooi8qya4o9ew3` (`employee_id`),
  ADD KEY `FK7op31a7rwvt1fn1lsl1jxfrln` (`shiftDate_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3c85oj07itam8uodrx0ar2qrv` (`contract_id`);

--
-- Indexes for table `employeemachine`
--
ALTER TABLE `employeemachine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqj9ck7l9sonvyti4ad4o78ojo` (`employee_id`),
  ADD KEY `FKfdk9o85wblx03u9w392vdykpc` (`machine_id`);

--
-- Indexes for table `employee_dayoffrequest`
--
ALTER TABLE `employee_dayoffrequest`
  ADD PRIMARY KEY (`Employee_id`,`dayOffRequestMap_id`),
  ADD UNIQUE KEY `UK_6ukd3e4c3ahspcrbw8tqv78qr` (`dayOffRequestMap_id`);

--
-- Indexes for table `employee_dayonrequest`
--
ALTER TABLE `employee_dayonrequest`
  ADD PRIMARY KEY (`Employee_id`,`dayOnRequestMap_id`),
  ADD UNIQUE KEY `UK_21jnl15lh2owdju21t77wm8in` (`dayOnRequestMap_id`);

--
-- Indexes for table `employee_holidayrequest`
--
ALTER TABLE `employee_holidayrequest`
  ADD PRIMARY KEY (`Employee_id`,`holidayRequestMap_id`),
  ADD UNIQUE KEY `UK_uu40im9usrsjvioxxkhh4ne7` (`holidayRequestMap_id`);

--
-- Indexes for table `employee_leaverequest`
--
ALTER TABLE `employee_leaverequest`
  ADD PRIMARY KEY (`Employee_id`,`leaveMap_id`),
  ADD UNIQUE KEY `UK_o24oxowpx2tx60vb9bo67txfs` (`leaveMap_id`);

--
-- Indexes for table `employee_rosterday`
--
ALTER TABLE `employee_rosterday`
  ADD PRIMARY KEY (`Employee_id`,`rosterdayMap_id`),
  ADD UNIQUE KEY `UK_mx4j9hncegm9l3txubgvb7kru` (`rosterdayMap_id`);

--
-- Indexes for table `employee_shiftoffrequest`
--
ALTER TABLE `employee_shiftoffrequest`
  ADD PRIMARY KEY (`Employee_id`,`shiftOffRequestMap_id`),
  ADD UNIQUE KEY `UK_r5qkw989qxsx7w9ts88fk9q8d` (`shiftOffRequestMap_id`);

--
-- Indexes for table `employee_shiftonrequest`
--
ALTER TABLE `employee_shiftonrequest`
  ADD PRIMARY KEY (`Employee_id`,`shiftOnRequestMap_id`),
  ADD UNIQUE KEY `UK_onc99tm9v58n6gnhsurxpue2` (`shiftOnRequestMap_id`);

--
-- Indexes for table `employee_trainingrequest`
--
ALTER TABLE `employee_trainingrequest`
  ADD PRIMARY KEY (`Employee_id`,`trainingRequestMap_id`),
  ADD UNIQUE KEY `UK_i8orxffa06q4fu5mnr7m6lp9g` (`trainingRequestMap_id`);

--
-- Indexes for table `holidayrequest`
--
ALTER TABLE `holidayrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjsgs4t7akc2qq9sirmuc9nj73` (`employee_id`),
  ADD KEY `FKk4tccf66bymjklpt4kkab7p3a` (`endshiftDate_id`),
  ADD KEY `FKoh43ab4q5rhk2tn1crh3cpqoq` (`startshiftDate_id`);

--
-- Indexes for table `holidaysdata`
--
ALTER TABLE `holidaysdata`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKljv4949j16faxr1n4rbuhxgym` (`employee_id`);

--
-- Indexes for table `leavedata`
--
ALTER TABLE `leavedata`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3dn9dh6cxxowsxkiee9wviyn9` (`employee_id`),
  ADD KEY `FK7f9m8b40ow62il41pi01ii4fx` (`shiftType_id`);

--
-- Indexes for table `leaverequest`
--
ALTER TABLE `leaverequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg3i4xdy258ug6id6o26u0v8fp` (`employee_id`),
  ADD KEY `FKkdyx0t93vv1bxgn60d3ukue8` (`endshiftDate_id`),
  ADD KEY `FK5mi25icdc1jq7x8m2g6jiy42n` (`shift_id`),
  ADD KEY `FKkl0not2wkh7e05vy1fqys06nd` (`shiftType_id`),
  ADD KEY `FKd52p49gafq6dts4hoh8use2nl` (`startshiftDate_id`);

--
-- Indexes for table `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `machinetypeskillsrequirement`
--
ALTER TABLE `machinetypeskillsrequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9en411q8trlgst30gncscebm5` (`machine_id`),
  ADD KEY `FKgb7glhgsf15k0qpx78lesexrd` (`shiftType_id`),
  ADD KEY `FKcmgyi17rlwg6fgk7kffibkq9g` (`skill_id`);

--
-- Indexes for table `pattern`
--
ALTER TABLE `pattern`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKieddnrui1m77eui84r2s1wgjg` (`workShiftType_id`),
  ADD KEY `FKyjoriwu3ccd7cfejqah46ttm` (`employee_id`),
  ADD KEY `FKcgeu0vfp7jfnaamat7eepp7l6` (`dayIndex0ShiftType_id`),
  ADD KEY `FK82htfcv0vdjipn65758v8gke3` (`dayIndex1ShiftType_id`),
  ADD KEY `FKdelr3729occ5v17cq587ixd1a` (`dayIndex2ShiftType_id`);

--
-- Indexes for table `patterncontractline`
--
ALTER TABLE `patterncontractline`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKxhq4kfp59w8v6h7gwmhgbsug` (`contract_id`),
  ADD KEY `FKb5pyfowja1psc0nbbav4nm67u` (`pattern_id`);

--
-- Indexes for table `rosterday`
--
ALTER TABLE `rosterday`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfcpcbhwcu7twxxae7xg7k0ax` (`employee_id`),
  ADD KEY `FKqd8nh797lt8sjsefuc34fw37r` (`shift_id`),
  ADD KEY `FKij8l44390o3evv0nyd5f3o6ld` (`shiftDate_id`),
  ADD KEY `FK46kw5125oc9lyg101oln358e1` (`shiftType_id`);

--
-- Indexes for table `rosterdayoff`
--
ALTER TABLE `rosterdayoff`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrd0vy1miwfshpa5xte90arag` (`employee_id`),
  ADD KEY `FKt20rut4tx4wwe3afn5s2ytahc` (`shift_id`),
  ADD KEY `FKpbusrlk8boxg0rhbny9v0g3xf` (`shiftType_id`);

--
-- Indexes for table `rosterparametrizationdata`
--
ALTER TABLE `rosterparametrizationdata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpe9wvrqm9ikwlah0i9oo018x0` (`shiftDate_id`),
  ADD KEY `FKn1ko8kai4ortj14amvyaaupka` (`shiftType_id`);

--
-- Indexes for table `shiftdate`
--
ALTER TABLE `shiftdate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shiftoffdate`
--
ALTER TABLE `shiftoffdate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnux1dq56lnusrp97qnejd3u5a` (`employee_id`),
  ADD KEY `FK1pam1akme2t5qsj1nqivaafuv` (`shiftType_id`);

--
-- Indexes for table `shiftoffrequest`
--
ALTER TABLE `shiftoffrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh604hhlq2ka1wu6j6npmvish5` (`employee_id`),
  ADD KEY `FKg2v5hp8mpa2va8cbbkytwxdq1` (`shift_id`);

--
-- Indexes for table `shiftondate`
--
ALTER TABLE `shiftondate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5eefa2viicvaln5t7uj21m76n` (`employee_id`),
  ADD KEY `FK9tvrmhv9cbwd6c0qmxtxxxnn8` (`shiftType_id`);

--
-- Indexes for table `shiftonrequest`
--
ALTER TABLE `shiftonrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3py6d6mm9tggsu8gomnl3c8bj` (`employee_id`),
  ADD KEY `FKsmgfbibkupw7whnn78xuetulx` (`shift_id`);

--
-- Indexes for table `shifttype`
--
ALTER TABLE `shifttype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shifttypemachinerequirement`
--
ALTER TABLE `shifttypemachinerequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlgrm82xg8vx2qgmc7xjlhmcui` (`machine_id`),
  ADD KEY `FKcvrjoe6y6hdhqwlcj9s2rsda6` (`shiftType_id`);

--
-- Indexes for table `shifttypeskillrequirement`
--
ALTER TABLE `shifttypeskillrequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7elqms0w3sd9ms79kj94scybp` (`shiftType_id`),
  ADD KEY `FKcq1rgunxaa69sfpmtqiffnehk` (`skill_id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skillproficiency`
--
ALTER TABLE `skillproficiency`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhu3d5yo0x2cx2vv1f9k2kso2f` (`employee_id`),
  ADD KEY `FK2u1hqp6jh7ns03bf9butjhym0` (`skill_id`);

--
-- Indexes for table `trainingdata`
--
ALTER TABLE `trainingdata`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdlgrccheqd596yj14l2phn0mt` (`employee_id`),
  ADD KEY `FKe7xxgvx4jphlic2ti4f53h3i` (`shift_id`);

--
-- Indexes for table `trainingrequest`
--
ALTER TABLE `trainingrequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg3ppac1qvy5nys19u2g2kdvf4` (`employee_id`),
  ADD KEY `FK3omuc6j0po1ni7g0lasxqylab` (`shift_id`),
  ADD KEY `FKbkwhs72iibhtqoa8stt8ip27r` (`shiftDate_id`),
  ADD KEY `FK8a9dmsdgrk57pkbpglm54fvee` (`shiftType_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
