-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 31, 2020 at 10:48 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newroster`
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

--
-- Dumping data for table `calendardata`
--

INSERT INTO `calendardata` (`id`, `employeename`, `endTime`, `isNight`, `shiftDate`, `shiftDescription`, `shiftType`, `startTIme`) VALUES
(137, 'Employee 7', '14:30:00', b'0', '2020-02-03', 'Early', 'E', '06:30:00'),
(138, 'Employee 11', '14:30:00', b'0', '2020-02-03', 'Early', 'E', '06:30:00'),
(139, 'Employee 12', '14:30:00', b'0', '2020-02-03', 'Early', 'E', '06:30:00'),
(140, 'Employee 8', '14:30:00', b'0', '2020-02-03', 'Early', 'E', '06:30:00'),
(141, 'Employee 3', '23:45:00', b'0', '2020-02-03', 'Late', 'L', '14:30:00'),
(142, 'Employee 6', '23:45:00', b'0', '2020-02-03', 'Late', 'L', '14:30:00'),
(143, 'Employee 9', '06:30:00', b'1', '2020-02-03', 'Night', 'N', '23:45:00'),
(144, 'Employee 4', '06:30:00', b'1', '2020-02-03', 'Night', 'N', '23:45:00'),
(145, 'Employee 7', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(146, 'Employee 11', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(147, 'Employee 1', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(148, 'Employee 12', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(149, 'Employee 5', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(150, 'Employee 8', '14:30:00', b'0', '2020-02-04', 'Early', 'E', '06:30:00'),
(151, 'Employee 10', '23:45:00', b'0', '2020-02-04', 'Late', 'L', '14:30:00'),
(152, 'Employee 6', '23:45:00', b'0', '2020-02-04', 'Late', 'L', '14:30:00'),
(153, 'Employee 9', '06:30:00', b'1', '2020-02-04', 'Night', 'N', '23:45:00'),
(154, 'Employee 4', '06:30:00', b'1', '2020-02-04', 'Night', 'N', '23:45:00'),
(155, 'Employee 11', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(156, 'Employee 2', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(157, 'Employee 1', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(158, 'Employee 12', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(159, 'Employee 5', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(160, 'Employee 8', '14:30:00', b'0', '2020-02-05', 'Early', 'E', '06:30:00'),
(161, 'Employee 10', '23:45:00', b'0', '2020-02-05', 'Late', 'L', '14:30:00'),
(162, 'Employee 6', '23:45:00', b'0', '2020-02-05', 'Late', 'L', '14:30:00'),
(163, 'Employee 3', '06:30:00', b'1', '2020-02-05', 'Night', 'N', '23:45:00'),
(164, 'Employee 4', '06:30:00', b'1', '2020-02-05', 'Night', 'N', '23:45:00'),
(165, 'Employee 11', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(166, 'Employee 2', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(167, 'Employee 8', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(168, 'Employee 9', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(169, 'Employee 1', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(170, 'Employee 12', '14:30:00', b'0', '2020-02-06', 'Early', 'E', '06:30:00'),
(171, 'Employee 5', '23:45:00', b'0', '2020-02-06', 'Late', 'L', '14:30:00'),
(172, 'Employee 7', '23:45:00', b'0', '2020-02-06', 'Late', 'L', '14:30:00'),
(173, 'Employee 10', '06:30:00', b'1', '2020-02-06', 'Night', 'N', '23:45:00'),
(174, 'Employee 6', '06:30:00', b'1', '2020-02-06', 'Night', 'N', '23:45:00'),
(175, 'Employee 11', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(176, 'Employee 2', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(177, 'Employee 9', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(178, 'Employee 4', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(179, 'Employee 3', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(180, 'Employee 12', '14:30:00', b'0', '2020-02-07', 'Early', 'E', '06:30:00'),
(181, 'Employee 1', '23:45:00', b'0', '2020-02-07', 'Late', 'L', '14:30:00'),
(182, 'Employee 8', '23:45:00', b'0', '2020-02-07', 'Late', 'L', '14:30:00'),
(183, 'Employee 10', '06:30:00', b'1', '2020-02-07', 'Night', 'N', '23:45:00'),
(184, 'Employee 6', '06:30:00', b'1', '2020-02-07', 'Night', 'N', '23:45:00'),
(185, 'Employee 3', '14:30:00', b'0', '2020-02-08', 'Early', 'E', '06:30:00'),
(186, 'Employee 2', '14:30:00', b'0', '2020-02-08', 'Early', 'E', '06:30:00'),
(187, 'Employee 7', '23:45:00', b'0', '2020-02-08', 'Late', 'L', '14:30:00'),
(188, 'Employee 5', '23:45:00', b'0', '2020-02-08', 'Late', 'L', '14:30:00'),
(189, 'Employee 9', '06:30:00', b'1', '2020-02-08', 'Night', 'N', '23:45:00'),
(190, 'Employee 4', '06:30:00', b'1', '2020-02-08', 'Night', 'N', '23:45:00'),
(191, 'Employee 10', '14:30:00', b'0', '2020-02-09', 'Early', 'E', '06:30:00'),
(192, 'Employee 2', '14:30:00', b'0', '2020-02-09', 'Early', 'E', '06:30:00'),
(193, 'Employee 1', '23:45:00', b'0', '2020-02-09', 'Late', 'L', '14:30:00'),
(194, 'Employee 8', '23:45:00', b'0', '2020-02-09', 'Late', 'L', '14:30:00'),
(195, 'Employee 7', '06:30:00', b'1', '2020-02-09', 'Night', 'N', '23:45:00'),
(196, 'Employee 5', '06:30:00', b'1', '2020-02-09', 'Night', 'N', '23:45:00'),
(197, 'Employee 3', '14:30:00', b'0', '2020-02-10', 'Early', 'E', '06:30:00'),
(198, 'Employee 4', '14:30:00', b'0', '2020-02-10', 'Early', 'E', '06:30:00'),
(199, 'Employee 11', '14:30:00', b'0', '2020-02-10', 'Early', 'E', '06:30:00'),
(200, 'Employee 12', '14:30:00', b'0', '2020-02-10', 'Early', 'E', '06:30:00'),
(201, 'Employee 1', '23:45:00', b'0', '2020-02-10', 'Late', 'L', '14:30:00'),
(202, 'Employee 6', '23:45:00', b'0', '2020-02-10', 'Late', 'L', '14:30:00'),
(203, 'Employee 10', '06:30:00', b'1', '2020-02-10', 'Night', 'N', '23:45:00'),
(204, 'Employee 5', '06:30:00', b'1', '2020-02-10', 'Night', 'N', '23:45:00'),
(205, 'Employee 11', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(206, 'Employee 9', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(207, 'Employee 7', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(208, 'Employee 2', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(209, 'Employee 12', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(210, 'Employee 8', '14:30:00', b'0', '2020-02-11', 'Early', 'E', '06:30:00'),
(211, 'Employee 3', '23:45:00', b'0', '2020-02-11', 'Late', 'L', '14:30:00'),
(212, 'Employee 4', '23:45:00', b'0', '2020-02-11', 'Late', 'L', '14:30:00'),
(213, 'Employee 1', '06:30:00', b'1', '2020-02-11', 'Night', 'N', '23:45:00'),
(214, 'Employee 6', '06:30:00', b'1', '2020-02-11', 'Night', 'N', '23:45:00'),
(215, 'Employee 11', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(216, 'Employee 12', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(217, 'Employee 10', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(218, 'Employee 5', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(219, 'Employee 7', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(220, 'Employee 2', '14:30:00', b'0', '2020-02-12', 'Early', 'E', '06:30:00'),
(221, 'Employee 9', '23:45:00', b'0', '2020-02-12', 'Late', 'L', '14:30:00'),
(222, 'Employee 8', '23:45:00', b'0', '2020-02-12', 'Late', 'L', '14:30:00'),
(223, 'Employee 3', '06:30:00', b'1', '2020-02-12', 'Night', 'N', '23:45:00'),
(224, 'Employee 4', '06:30:00', b'1', '2020-02-12', 'Night', 'N', '23:45:00'),
(225, 'Employee 11', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(226, 'Employee 12', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(227, 'Employee 1', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(228, 'Employee 6', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(229, 'Employee 7', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(230, 'Employee 2', '14:30:00', b'0', '2020-02-13', 'Early', 'E', '06:30:00'),
(231, 'Employee 9', '23:45:00', b'0', '2020-02-13', 'Late', 'L', '14:30:00'),
(232, 'Employee 5', '23:45:00', b'0', '2020-02-13', 'Late', 'L', '14:30:00'),
(233, 'Employee 3', '06:30:00', b'1', '2020-02-13', 'Night', 'N', '23:45:00'),
(234, 'Employee 4', '06:30:00', b'1', '2020-02-13', 'Night', 'N', '23:45:00'),
(235, 'Employee 11', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(236, 'Employee 12', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(237, 'Employee 7', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(238, 'Employee 2', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(239, 'Employee 1', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(240, 'Employee 8', '14:30:00', b'0', '2020-02-14', 'Early', 'E', '06:30:00'),
(241, 'Employee 9', '23:45:00', b'0', '2020-02-14', 'Late', 'L', '14:30:00'),
(242, 'Employee 10', '23:45:00', b'0', '2020-02-14', 'Late', 'L', '14:30:00'),
(243, 'Employee 3', '06:30:00', b'1', '2020-02-14', 'Night', 'N', '23:45:00'),
(244, 'Employee 6', '06:30:00', b'1', '2020-02-14', 'Night', 'N', '23:45:00'),
(245, 'Employee 1', '14:30:00', b'0', '2020-02-15', 'Early', 'E', '06:30:00'),
(246, 'Employee 8', '14:30:00', b'0', '2020-02-15', 'Early', 'E', '06:30:00'),
(247, 'Employee 10', '23:45:00', b'0', '2020-02-15', 'Late', 'L', '14:30:00'),
(248, 'Employee 5', '23:45:00', b'0', '2020-02-15', 'Late', 'L', '14:30:00'),
(249, 'Employee 7', '06:30:00', b'1', '2020-02-15', 'Night', 'N', '23:45:00'),
(250, 'Employee 2', '06:30:00', b'1', '2020-02-15', 'Night', 'N', '23:45:00'),
(251, 'Employee 6', '14:30:00', b'0', '2020-02-16', 'Early', 'E', '06:30:00'),
(252, 'Employee 4', '14:30:00', b'0', '2020-02-16', 'Early', 'E', '06:30:00'),
(253, 'Employee 5', '23:45:00', b'0', '2020-02-16', 'Late', 'L', '14:30:00'),
(254, 'Employee 10', '23:45:00', b'0', '2020-02-16', 'Late', 'L', '14:30:00'),
(255, 'Employee 9', '06:30:00', b'1', '2020-02-16', 'Night', 'N', '23:45:00'),
(256, 'Employee 3', '06:30:00', b'1', '2020-02-16', 'Night', 'N', '23:45:00');

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
(1, '10 Shifts', '10 Shifts', 'SATURDAY_SUNDAY'),
(2, '8 Shifts', '8 Shifts', 'SATURDAY_SUNDAY'),
(3, 'Casual', 'Casual', 'SATURDAY_SUNDAY'),
(4, 'Days', 'Days Only', 'SATURDAY_SUNDAY');

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
('MinMaxContractLine', 14, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 1, b'1', 10, 1, 1),
('MinMaxContractLine', 15, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 16, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 17, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 18, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 19, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 5, 1, b'0', 2, 1, 1),
('MinMaxContractLine', 20, 'CONSECUTIVE_LATE_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 1),
('MinMaxContractLine', 21, 'CONSECUTIVE_EARLY_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 1),
('MinMaxContractLine', 22, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 8, 1, b'1', 8, 1, 2),
('MinMaxContractLine', 23, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'1', 1, 1, 2),
('MinMaxContractLine', 24, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 6, 1, b'1', 2, 1, 2),
('MinMaxContractLine', 25, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 2),
('MinMaxContractLine', 26, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 2),
('MinMaxContractLine', 27, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'1', 5, 1, b'1', 2, 1, 2),
('MinMaxContractLine', 28, 'CONSECUTIVE_LATE_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 2),
('MinMaxContractLine', 29, 'CONSECUTIVE_EARLY_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 2),
('MinMaxContractLine', 30, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 31, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 32, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 33, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 34, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 35, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 36, 'CONSECUTIVE_LATE_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 37, 'CONSECUTIVE_EARLY_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 3),
('MinMaxContractLine', 38, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 1, b'1', 10, 1, 4),
('MinMaxContractLine', 39, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'1', 5, 1, 4),
('MinMaxContractLine', 40, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 2, 1, b'1', 2, 1, 4),
('MinMaxContractLine', 41, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 0, 2, b'1', 0, 2, 4),
('MinMaxContractLine', 42, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 0, 2, b'1', 0, 2, 4),
('MinMaxContractLine', 43, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 4),
('MinMaxContractLine', 44, 'CONSECUTIVE_LATE_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 4),
('MinMaxContractLine', 45, 'CONSECUTIVE_EARLY_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 4),
('BooleanContractLine', 46, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 47, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 48, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 49, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 50, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 51, 'ALTERNATIVE_DEPARTMENT', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 52, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 53, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 54, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 55, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 56, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 57, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 58, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 59, 'ALTERNATIVE_DEPARTMENT', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 60, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 61, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 62, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 63, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 64, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 65, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 66, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 67, 'ALTERNATIVE_DEPARTMENT', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 68, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 69, 'IS_CASUAL', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 3),
('BooleanContractLine', 70, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 71, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 72, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 73, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 74, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 75, 'ALTERNATIVE_DEPARTMENT', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 76, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4),
('BooleanContractLine', 77, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 4);

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
(113, 0, 4, 11),
(114, 1, 6, 11),
(115, 2, 6, 11),
(117, 3, 6, 11),
(118, 4, 6, 11),
(119, 5, 2, 11),
(120, 6, 2, 11),
(121, 0, 2, 12),
(122, 1, 2, 12),
(123, 2, 2, 12),
(124, 3, 2, 12),
(125, 4, 2, 12),
(126, 5, 2, 12),
(127, 6, 2, 12),
(128, 0, 2, 13),
(129, 1, 2, 13),
(130, 2, 2, 13),
(131, 3, 2, 13),
(132, 4, 2, 13),
(133, 5, 2, 13),
(134, 6, 2, 13);

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
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `code`) VALUES
(9, 'Logan'),
(10, 'Cleveland'),
(90, 'Medical');

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
  `contract_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `code`, `contactdetails`, `employeeId`, `name`, `postcode`, `streetnum`, `suburb`, `contract_id`, `department_id`, `skill_id`) VALUES
(96, '', '1', '', '1', 'Employee 1', '', '', '', 1, 9, 5),
(97, '', '2', '', '2', 'Employee 2', '', '', '', 1, 9, 5),
(98, '', '3', '', '3', 'Employee 3', '', '', '', 1, 9, 5),
(99, '', '4', '', '4', 'Employee 4', '', '', '', 1, 9, 5),
(100, '', '5', '', '5', 'Employee 5', '', '', '', 1, 9, 5),
(101, '', '6', '', '6', 'Employee 6', '', '', '', 1, 9, 5),
(102, '', '7', '', '7', 'Employee 7', '', '', '', 1, 9, 5),
(103, '', '8', '', '8', 'Employee 8', '', '', '', 1, 9, 5),
(104, '', '9', '', '9', 'Employee 9', '', '', '', 1, 9, 5),
(105, '', '10', '', '10', 'Employee 10', '', '', '', 1, 9, 5),
(106, '', '11', '', '11', 'Employee 11', '', '', '', 4, 90, 8),
(107, '', '12', '', '12', 'Employee 12', '', '', '', 4, 90, 8);

-- --------------------------------------------------------

--
-- Table structure for table `employeedepartment`
--

CREATE TABLE `employeedepartment` (
  `id` bigint(20) NOT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257),
(257);

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
  `workShiftType_id` bigint(20) DEFAULT NULL,
  `dayIndex0ShiftType_id` bigint(20) DEFAULT NULL,
  `dayIndex1ShiftType_id` bigint(20) DEFAULT NULL,
  `dayIndex2ShiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pattern`
--

INSERT INTO `pattern` (`type`, `id`, `code`, `weight`, `freeDayOfWeek`, `freeDayLength`, `workDayOfWeek`, `workShiftType_id`, `dayIndex0ShiftType_id`, `dayIndex1ShiftType_id`, `dayIndex2ShiftType_id`) VALUES
('WorkBefore', 78, 'WB', 1, NULL, 2, NULL, 13, NULL, NULL, NULL),
('Shift2Days', 79, 'NE', 1, NULL, NULL, NULL, NULL, 13, 11, NULL),
('Shift2Days', 80, 'NL', 1, NULL, NULL, NULL, NULL, 13, 12, NULL),
('Shift2Days', 81, 'LE', 1, NULL, NULL, NULL, NULL, 12, 11, NULL);

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
(83, 1, 79),
(84, 1, 80),
(85, 1, 81),
(86, 2, 78),
(87, 2, 79),
(88, 2, 80),
(89, 2, 81);

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
(0, 'Test', '2020-02-16', '2020-02-03');

-- --------------------------------------------------------

--
-- Table structure for table `shift`
--

CREATE TABLE `shift` (
  `id` bigint(20) NOT NULL,
  `shift_index` int(11) DEFAULT NULL,
  `requiredEmployeeSize` int(11) NOT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `rosterdayoff` tinyblob,
  `rosterdayoff_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `shift_index` int(11) DEFAULT NULL,
  `night` bit(1) NOT NULL,
  `startTimeString` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shifttype`
--

INSERT INTO `shifttype` (`id`, `code`, `description`, `endTimeString`, `shift_index`, `night`, `startTimeString`) VALUES
(11, 'E', 'Early', '14:30:00', 0, b'0', '06:30:00'),
(12, 'L', 'Late', '23:45:00', 0, b'0', '14:30:00'),
(13, 'N', 'Night', '06:30:00', 0, b'1', '23:45:00');

-- --------------------------------------------------------

--
-- Table structure for table `shifttypedepartmentrequirement`
--

CREATE TABLE `shifttypedepartmentrequirement` (
  `id` bigint(20) NOT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shifttypedepartmentrequirement`
--

INSERT INTO `shifttypedepartmentrequirement` (`id`, `department_id`, `shiftType_id`) VALUES
(91, 90, 11),
(92, 9, 11),
(136, 9, 12),
(94, 9, 13),
(95, 10, 11);

-- --------------------------------------------------------

--
-- Table structure for table `shifttypeskillrequirement`
--

CREATE TABLE `shifttypeskillrequirement` (
  `id` bigint(20) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shifttypeskillrequirement`
--

INSERT INTO `shifttypeskillrequirement` (`id`, `shiftType_id`, `skill_id`) VALUES
(108, 11, 8),
(109, 11, 7),
(110, 12, 5),
(135, 11, 5),
(112, 13, 5);

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
(5, 'HP3'),
(6, 'Casual'),
(7, 'Cleaner'),
(8, 'Doctor');

-- --------------------------------------------------------

--
-- Table structure for table `skillproficiency`
--

CREATE TABLE `skillproficiency` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3c85oj07itam8uodrx0ar2qrv` (`contract_id`),
  ADD KEY `FK14tijxqry9ml17nk86sqfp561` (`department_id`),
  ADD KEY `FKe3ybtt1urh4pw5l72onheck5u` (`skill_id`);

--
-- Indexes for table `employeedepartment`
--
ALTER TABLE `employeedepartment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmryxjpevfdsees12v5wt4pfcg` (`department_id`),
  ADD KEY `FKphfeogj09f9pgcss8hi50argr` (`employee_id`);

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
-- Indexes for table `pattern`
--
ALTER TABLE `pattern`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKieddnrui1m77eui84r2s1wgjg` (`workShiftType_id`),
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
  ADD KEY `FKgnuvsq6831tvjalqo77fmssdy` (`rosterdayoff_id`),
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
-- Indexes for table `shifttypedepartmentrequirement`
--
ALTER TABLE `shifttypedepartmentrequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj1c80s9cjh06q7d3mpnh5ara7` (`department_id`),
  ADD KEY `FK3tnmritsvtdenb03botg3u81p` (`shiftType_id`);

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
