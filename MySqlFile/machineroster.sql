-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 08, 2020 at 03:23 PM
-- Server version: 5.7.29-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.3

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
-- Table structure for table `CalendarData`
--

CREATE TABLE `CalendarData` (
  `id` bigint(20) NOT NULL,
  `employeename` varchar(255) DEFAULT NULL,
  `endTime` varchar(255) DEFAULT NULL,
  `isNight` bit(1) NOT NULL,
  `shiftDate` date DEFAULT NULL,
  `shiftDescription` varchar(255) DEFAULT NULL,
  `shiftType` varchar(255) DEFAULT NULL,
  `startTIme` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CalendarData`
--

INSERT INTO `CalendarData` (`id`, `employeename`, `endTime`, `isNight`, `shiftDate`, `shiftDescription`, `shiftType`, `startTIme`) VALUES
(1101, '11', '23:00:00', b'0', '2020-02-25', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1100, '15', '06:30:00', b'1', '2020-02-24', 'Machine 2 Night', 'M2N', '23:00:00'),
(1099, '13', '06:30:00', b'1', '2020-02-24', 'Machine 2 Night', 'M2N', '23:00:00'),
(1098, '14', '23:30:00', b'0', '2020-02-24', 'Machine 2 Late', 'M2L', '16:30:00'),
(1097, '6', '23:30:00', b'0', '2020-02-24', 'Machine 2 Late', 'M2L', '16:30:00'),
(1096, '8', '14:30:00', b'0', '2020-02-24', 'Machine 2 Early', 'M2E', '06:30:00'),
(1095, '4', '14:30:00', b'0', '2020-02-24', 'Machine 2 Early', 'M2E', '06:30:00'),
(1094, '10', '06:30:00', b'1', '2020-02-24', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1093, '5', '06:30:00', b'1', '2020-02-24', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1092, '1', '16:30:00', b'0', '2020-02-24', 'Machine 1 Early', 'M1E', '06:30:00'),
(1091, '7', '16:30:00', b'0', '2020-02-24', 'Machine 1 Early', 'M1E', '06:30:00'),
(1090, '9', '23:00:00', b'0', '2020-02-24', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1089, '11', '23:00:00', b'0', '2020-02-24', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1088, '11', '06:30:00', b'1', '2020-02-23', 'Machine 2 Night', 'M2N', '23:00:00'),
(1087, '13', '06:30:00', b'1', '2020-02-23', 'Machine 2 Night', 'M2N', '23:00:00'),
(1086, '14', '23:30:00', b'0', '2020-02-23', 'Machine 2 Late', 'M2L', '16:30:00'),
(1085, '15', '23:30:00', b'0', '2020-02-23', 'Machine 2 Late', 'M2L', '16:30:00'),
(1084, '8', '14:30:00', b'0', '2020-02-23', 'Machine 2 Early', 'M2E', '06:30:00'),
(1083, '4', '14:30:00', b'0', '2020-02-23', 'Machine 2 Early', 'M2E', '06:30:00'),
(1082, '6', '06:30:00', b'1', '2020-02-23', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1081, '10', '06:30:00', b'1', '2020-02-23', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1080, '5', '16:30:00', b'0', '2020-02-23', 'Machine 1 Early', 'M1E', '06:30:00'),
(1079, '1', '16:30:00', b'0', '2020-02-23', 'Machine 1 Early', 'M1E', '06:30:00'),
(1078, '7', '23:00:00', b'0', '2020-02-23', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1077, '9', '23:00:00', b'0', '2020-02-23', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1102, '9', '23:00:00', b'0', '2020-02-25', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1103, '7', '16:30:00', b'0', '2020-02-25', 'Machine 1 Early', 'M1E', '06:30:00'),
(1104, '1', '16:30:00', b'0', '2020-02-25', 'Machine 1 Early', 'M1E', '06:30:00'),
(1105, '5', '06:30:00', b'1', '2020-02-25', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1106, '10', '06:30:00', b'1', '2020-02-25', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1107, '4', '14:30:00', b'0', '2020-02-25', 'Machine 2 Early', 'M2E', '06:30:00'),
(1108, '8', '14:30:00', b'0', '2020-02-25', 'Machine 2 Early', 'M2E', '06:30:00'),
(1109, '6', '23:30:00', b'0', '2020-02-25', 'Machine 2 Late', 'M2L', '16:30:00'),
(1110, '14', '23:30:00', b'0', '2020-02-25', 'Machine 2 Late', 'M2L', '16:30:00'),
(1111, '13', '06:30:00', b'1', '2020-02-25', 'Machine 2 Night', 'M2N', '23:00:00'),
(1112, '15', '06:30:00', b'1', '2020-02-25', 'Machine 2 Night', 'M2N', '23:00:00'),
(1113, '13', '23:00:00', b'0', '2020-02-26', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1114, '9', '23:00:00', b'0', '2020-02-26', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1115, '8', '16:30:00', b'0', '2020-02-26', 'Machine 1 Early', 'M1E', '06:30:00'),
(1116, '1', '16:30:00', b'0', '2020-02-26', 'Machine 1 Early', 'M1E', '06:30:00'),
(1117, '5', '06:30:00', b'1', '2020-02-26', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1118, '10', '06:30:00', b'1', '2020-02-26', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1119, '4', '14:30:00', b'0', '2020-02-26', 'Machine 2 Early', 'M2E', '06:30:00'),
(1120, '7', '14:30:00', b'0', '2020-02-26', 'Machine 2 Early', 'M2E', '06:30:00'),
(1121, '15', '23:30:00', b'0', '2020-02-26', 'Machine 2 Late', 'M2L', '16:30:00'),
(1122, '14', '23:30:00', b'0', '2020-02-26', 'Machine 2 Late', 'M2L', '16:30:00'),
(1123, '11', '06:30:00', b'1', '2020-02-26', 'Machine 2 Night', 'M2N', '23:00:00'),
(1124, '6', '06:30:00', b'1', '2020-02-26', 'Machine 2 Night', 'M2N', '23:00:00'),
(1125, '11', '23:00:00', b'0', '2020-02-27', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1126, '13', '23:00:00', b'0', '2020-02-27', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1127, '7', '16:30:00', b'0', '2020-02-27', 'Machine 1 Early', 'M1E', '06:30:00'),
(1128, '1', '16:30:00', b'0', '2020-02-27', 'Machine 1 Early', 'M1E', '06:30:00'),
(1129, '5', '06:30:00', b'1', '2020-02-27', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1130, '10', '06:30:00', b'1', '2020-02-27', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1131, '4', '14:30:00', b'0', '2020-02-27', 'Machine 2 Early', 'M2E', '06:30:00'),
(1132, '6', '14:30:00', b'0', '2020-02-27', 'Machine 2 Early', 'M2E', '06:30:00'),
(1133, '15', '23:30:00', b'0', '2020-02-27', 'Machine 2 Late', 'M2L', '16:30:00'),
(1134, '14', '23:30:00', b'0', '2020-02-27', 'Machine 2 Late', 'M2L', '16:30:00'),
(1135, '9', '06:30:00', b'1', '2020-02-27', 'Machine 2 Night', 'M2N', '23:00:00'),
(1136, '8', '06:30:00', b'1', '2020-02-27', 'Machine 2 Night', 'M2N', '23:00:00'),
(1137, '10', '23:00:00', b'0', '2020-03-01', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1138, '13', '23:00:00', b'0', '2020-03-01', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1139, '1', '16:30:00', b'0', '2020-03-01', 'Machine 1 Early', 'M1E', '06:30:00'),
(1140, '5', '16:30:00', b'0', '2020-03-01', 'Machine 1 Early', 'M1E', '06:30:00'),
(1141, '14', '06:30:00', b'1', '2020-03-01', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1142, '11', '06:30:00', b'1', '2020-03-01', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1143, '4', '14:30:00', b'0', '2020-03-01', 'Machine 2 Early', 'M2E', '06:30:00'),
(1144, '7', '14:30:00', b'0', '2020-03-01', 'Machine 2 Early', 'M2E', '06:30:00'),
(1145, '8', '23:30:00', b'0', '2020-03-01', 'Machine 2 Late', 'M2L', '16:30:00'),
(1146, '9', '23:30:00', b'0', '2020-03-01', 'Machine 2 Late', 'M2L', '16:30:00'),
(1147, '15', '06:30:00', b'1', '2020-03-01', 'Machine 2 Night', 'M2N', '23:00:00'),
(1148, '6', '06:30:00', b'1', '2020-03-01', 'Machine 2 Night', 'M2N', '23:00:00'),
(1149, '10', '23:00:00', b'0', '2020-03-02', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1150, '11', '23:00:00', b'0', '2020-03-02', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1151, '7', '16:30:00', b'0', '2020-03-02', 'Machine 1 Early', 'M1E', '06:30:00'),
(1152, '1', '16:30:00', b'0', '2020-03-02', 'Machine 1 Early', 'M1E', '06:30:00'),
(1153, '8', '06:30:00', b'1', '2020-03-02', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1154, '13', '06:30:00', b'1', '2020-03-02', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1155, '4', '14:30:00', b'0', '2020-03-02', 'Machine 2 Early', 'M2E', '06:30:00'),
(1156, '6', '14:30:00', b'0', '2020-03-02', 'Machine 2 Early', 'M2E', '06:30:00'),
(1157, '15', '23:30:00', b'0', '2020-03-02', 'Machine 2 Late', 'M2L', '16:30:00'),
(1158, '14', '23:30:00', b'0', '2020-03-02', 'Machine 2 Late', 'M2L', '16:30:00'),
(1159, '5', '06:30:00', b'1', '2020-03-02', 'Machine 2 Night', 'M2N', '23:00:00'),
(1160, '9', '06:30:00', b'1', '2020-03-02', 'Machine 2 Night', 'M2N', '23:00:00'),
(1161, '9', '23:00:00', b'0', '2020-03-03', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1162, '10', '23:00:00', b'0', '2020-03-03', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1163, '7', '16:30:00', b'0', '2020-03-03', 'Machine 1 Early', 'M1E', '06:30:00'),
(1164, '1', '16:30:00', b'0', '2020-03-03', 'Machine 1 Early', 'M1E', '06:30:00'),
(1165, '8', '06:30:00', b'1', '2020-03-03', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1166, '13', '06:30:00', b'1', '2020-03-03', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1167, '5', '14:30:00', b'0', '2020-03-03', 'Machine 2 Early', 'M2E', '06:30:00'),
(1168, '6', '14:30:00', b'0', '2020-03-03', 'Machine 2 Early', 'M2E', '06:30:00'),
(1169, '11', '23:30:00', b'0', '2020-03-03', 'Machine 2 Late', 'M2L', '16:30:00'),
(1170, '15', '23:30:00', b'0', '2020-03-03', 'Machine 2 Late', 'M2L', '16:30:00'),
(1171, '4', '06:30:00', b'1', '2020-03-03', 'Machine 2 Night', 'M2N', '23:00:00'),
(1172, '14', '06:30:00', b'1', '2020-03-03', 'Machine 2 Night', 'M2N', '23:00:00'),
(1173, '5', '23:00:00', b'0', '2020-03-04', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1174, '10', '23:00:00', b'0', '2020-03-04', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1175, '7', '16:30:00', b'0', '2020-03-04', 'Machine 1 Early', 'M1E', '06:30:00'),
(1176, '1', '16:30:00', b'0', '2020-03-04', 'Machine 1 Early', 'M1E', '06:30:00'),
(1177, '8', '06:30:00', b'1', '2020-03-04', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1178, '11', '06:30:00', b'1', '2020-03-04', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1179, '4', '14:30:00', b'0', '2020-03-04', 'Machine 2 Early', 'M2E', '06:30:00'),
(1180, '6', '14:30:00', b'0', '2020-03-04', 'Machine 2 Early', 'M2E', '06:30:00'),
(1181, '13', '23:30:00', b'0', '2020-03-04', 'Machine 2 Late', 'M2L', '16:30:00'),
(1182, '15', '23:30:00', b'0', '2020-03-04', 'Machine 2 Late', 'M2L', '16:30:00'),
(1183, '9', '06:30:00', b'1', '2020-03-04', 'Machine 2 Night', 'M2N', '23:00:00'),
(1184, '14', '06:30:00', b'1', '2020-03-04', 'Machine 2 Night', 'M2N', '23:00:00'),
(1185, '10', '23:00:00', b'0', '2020-03-05', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1186, '1', '23:00:00', b'0', '2020-03-05', 'Machine 1 Late Shift', 'M1L', '14:30:00'),
(1187, '6', '16:30:00', b'0', '2020-03-05', 'Machine 1 Early', 'M1E', '06:30:00'),
(1188, '7', '16:30:00', b'0', '2020-03-05', 'Machine 1 Early', 'M1E', '06:30:00'),
(1189, '5', '06:30:00', b'1', '2020-03-05', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1190, '15', '06:30:00', b'1', '2020-03-05', 'Machine 1 Night Shift', 'M1N', '23:00:00'),
(1191, '4', '14:30:00', b'0', '2020-03-05', 'Machine 2 Early', 'M2E', '06:30:00'),
(1192, '8', '14:30:00', b'0', '2020-03-05', 'Machine 2 Early', 'M2E', '06:30:00'),
(1193, '9', '23:30:00', b'0', '2020-03-05', 'Machine 2 Late', 'M2L', '16:30:00'),
(1194, '13', '23:30:00', b'0', '2020-03-05', 'Machine 2 Late', 'M2L', '16:30:00'),
(1195, '14', '06:30:00', b'1', '2020-03-05', 'Machine 2 Night', 'M2N', '23:00:00'),
(1196, '11', '06:30:00', b'1', '2020-03-05', 'Machine 2 Night', 'M2N', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `Contract`
--

CREATE TABLE `Contract` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `weekendDefinition` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Contract`
--

INSERT INTO `Contract` (`id`, `code`, `description`, `weekendDefinition`) VALUES
(834, 'FT', 'Full Time', 'SATURDAY_SUNDAY'),
(835, 'NN', 'No Night Shift', 'SATURDAY_SUNDAY'),
(916, 'Casual', 'Casual', 'SATURDAY_SUNDAY');

-- --------------------------------------------------------

--
-- Table structure for table `ContractLine`
--

CREATE TABLE `ContractLine` (
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ContractLine`
--

INSERT INTO `ContractLine` (`type`, `id`, `contractLineType`, `enabled`, `weight`, `maximumEnabled`, `maximumValue`, `maximumWeight`, `minimumEnabled`, `minimumValue`, `minimumWeight`, `contract_id`) VALUES
('MinMaxContractLine', 845, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 835),
('MinMaxContractLine', 844, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 835),
('MinMaxContractLine', 843, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'1', 5, 1, 835),
('MinMaxContractLine', 842, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 1, b'1', 10, 1, 835),
('MinMaxContractLine', 841, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 834),
('MinMaxContractLine', 840, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 834),
('MinMaxContractLine', 839, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 834),
('MinMaxContractLine', 838, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 834),
('MinMaxContractLine', 837, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'0', 0, 0, 834),
('MinMaxContractLine', 836, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 1, b'1', 10, 1, 834),
('MinMaxContractLine', 846, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 835),
('MinMaxContractLine', 847, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 835),
('BooleanContractLine', 848, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 849, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 850, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 851, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 852, 'ALTERNATIVE_SKILL_CATEGORY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 853, 'ALTERNATIVE_MACHINE', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 854, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 855, 'NO_NIGHT_SHIFTS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 856, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 834),
('BooleanContractLine', 857, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 858, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 859, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 860, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 861, 'ALTERNATIVE_SKILL_CATEGORY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 862, 'ALTERNATIVE_MACHINE', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 863, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 864, 'NO_NIGHT_SHIFTS', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('BooleanContractLine', 865, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 835),
('MinMaxContractLine', 917, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('MinMaxContractLine', 918, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('MinMaxContractLine', 919, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('MinMaxContractLine', 920, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('MinMaxContractLine', 921, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('MinMaxContractLine', 922, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 916),
('BooleanContractLine', 923, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 924, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 925, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 926, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 927, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 928, 'ALTERNATIVE_MACHINE', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 929, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 930, 'NO_NIGHT_SHIFTS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916),
('BooleanContractLine', 931, 'IS_CASUAL', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 916);

-- --------------------------------------------------------

--
-- Table structure for table `CoverRequirements`
--

CREATE TABLE `CoverRequirements` (
  `id` bigint(20) NOT NULL,
  `dayOfWeek` int(11) DEFAULT NULL,
  `requiredEmployeesize` int(11) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CoverRequirements`
--

INSERT INTO `CoverRequirements` (`id`, `dayOfWeek`, `requiredEmployeesize`, `shiftType_id`) VALUES
(881, 0, 2, 829),
(880, 4, 2, 831),
(879, 3, 2, 831),
(878, 2, 2, 831),
(877, 0, 2, 831),
(876, 4, 2, 828),
(875, 3, 2, 828),
(874, 2, 2, 828),
(873, 1, 2, 828),
(872, 0, 2, 828),
(882, 1, 2, 829),
(883, 2, 2, 829),
(884, 3, 2, 829),
(885, 4, 2, 829),
(886, 0, 2, 832),
(887, 1, 2, 832),
(888, 2, 2, 832),
(889, 3, 2, 832),
(890, 4, 2, 832),
(891, 0, 2, 833),
(892, 1, 2, 833),
(893, 2, 2, 833),
(894, 3, 2, 833),
(895, 4, 2, 833),
(896, 0, 2, 830),
(897, 1, 2, 830),
(898, 2, 2, 830),
(899, 3, 2, 830),
(900, 4, 2, 830),
(1029, 1, 2, 831),
(1221, 5, 2, 828),
(1222, 5, 2, 829),
(1223, 5, 2, 830);

-- --------------------------------------------------------

--
-- Table structure for table `DayOffDate`
--

CREATE TABLE `DayOffDate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DayOffDate`
--

INSERT INTO `DayOffDate` (`id`, `date`, `weight`, `employee_id`) VALUES
(1028, '2020-02-24', 4, 936);

-- --------------------------------------------------------

--
-- Table structure for table `DayOffRequest`
--

CREATE TABLE `DayOffRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DayOnDate`
--

CREATE TABLE `DayOnDate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `DayOnRequest`
--

CREATE TABLE `DayOnRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`id`, `address`, `code`, `contactdetails`, `employeeId`, `name`, `postcode`, `streetnum`, `suburb`, `contract_id`) VALUES
(936, '', '1', '', '1', '1', '', '', '', 834),
(941, '', '2', '', '2', '2', '', '', '', 834),
(946, '', '3', '', '3', '3', '', '', '', 834),
(951, '', '4', '', '4', '4', '', '', '', 834),
(957, '', '5', '', '5', '5', '', '', '', 834),
(965, '', '6', '', '6', '6', '', '', '', 834),
(971, '', '7', '', '7', '7', '', '', '', 834),
(976, '', '8', '', '8', '8', '', '', '', 834),
(999, '', '9', '', '9', '9', '', '', '', 834),
(1010, '', '10', '', '10', '10', '', '', '', 834),
(1016, '', '11', '', '11', '11', '', '', '', 835),
(1024, '', '12', '', '12', '12', '', '', '', 916),
(1030, '', '13', '', '13', '13', '', '', '', 835),
(1224, '', '14', '', '14', '14', '', '', '', 834);

-- --------------------------------------------------------

--
-- Table structure for table `EmployeeMachine`
--

CREATE TABLE `EmployeeMachine` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `machine_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EmployeeMachine`
--

INSERT INTO `EmployeeMachine` (`id`, `employee_id`, `machine_id`) VALUES
(1220, 936, 826),
(1219, 936, 827),
(944, 941, 827),
(945, 941, 826),
(1244, 946, 826),
(1243, 946, 827),
(955, 951, 827),
(956, 951, 826),
(963, 957, 827),
(964, 957, 826),
(1070, 976, 826),
(1069, 976, 827),
(1063, 971, 826),
(1062, 971, 827),
(997, 965, 827),
(998, 965, 826),
(1008, 999, 827),
(1009, 999, 826),
(1014, 1010, 827),
(1015, 1010, 826),
(1021, 1016, 827),
(1022, 1016, 826),
(1026, 1024, 827),
(1027, 1024, 826),
(1207, 1030, 826),
(1206, 1030, 827),
(1231, 1224, 826),
(1230, 1224, 827);

-- --------------------------------------------------------

--
-- Table structure for table `Employee_DayOffRequest`
--

CREATE TABLE `Employee_DayOffRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_DayOnRequest`
--

CREATE TABLE `Employee_DayOnRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_EmployeeMachine`
--

CREATE TABLE `Employee_EmployeeMachine` (
  `Employee_id` bigint(20) NOT NULL,
  `employeeMachine_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_HolidayRequest`
--

CREATE TABLE `Employee_HolidayRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `holidayRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_LeaveRequest`
--

CREATE TABLE `Employee_LeaveRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `leaveMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_RosterDay`
--

CREATE TABLE `Employee_RosterDay` (
  `Employee_id` bigint(20) NOT NULL,
  `rosterdayMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_ShiftOffRequest`
--

CREATE TABLE `Employee_ShiftOffRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_ShiftOnRequest`
--

CREATE TABLE `Employee_ShiftOnRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee_TrainingRequest`
--

CREATE TABLE `Employee_TrainingRequest` (
  `Employee_id` bigint(20) NOT NULL,
  `trainingRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245),
(1245);

-- --------------------------------------------------------

--
-- Table structure for table `HolidayRequest`
--

CREATE TABLE `HolidayRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `endshiftDate_id` bigint(20) DEFAULT NULL,
  `startshiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `HolidaysData`
--

CREATE TABLE `HolidaysData` (
  `id` bigint(20) NOT NULL,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `LeaveData`
--

CREATE TABLE `LeaveData` (
  `id` bigint(20) NOT NULL,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `LeaveRequest`
--

CREATE TABLE `LeaveRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `endshiftDate_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `startshiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Machine`
--

CREATE TABLE `Machine` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Machine`
--

INSERT INTO `Machine` (`id`, `code`) VALUES
(827, 'M2'),
(826, 'M1');

-- --------------------------------------------------------

--
-- Table structure for table `MachineTypeSkillsRequirement`
--

CREATE TABLE `MachineTypeSkillsRequirement` (
  `id` bigint(20) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MachineTypeSkillsRequirement`
--

INSERT INTO `MachineTypeSkillsRequirement` (`id`, `machine_id`, `skill_id`, `shiftType_id`) VALUES
(901, 826, 821, 828),
(902, 826, 822, 828),
(903, 826, 822, 829),
(904, 826, 823, 829),
(905, 826, 824, 830),
(906, 826, 822, 830),
(907, 827, 825, 831),
(908, 827, 821, 831),
(909, 827, 825, 832),
(910, 827, 824, 832),
(911, 827, 825, 833),
(912, 827, 824, 833);

-- --------------------------------------------------------

--
-- Table structure for table `Pattern`
--

CREATE TABLE `Pattern` (
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Pattern`
--

INSERT INTO `Pattern` (`type`, `id`, `code`, `weight`, `freeDayOfWeek`, `freeDayLength`, `workDayOfWeek`, `shiftLength`, `workShiftType_id`, `employee_id`, `dayIndex0ShiftType_id`, `dayIndex1ShiftType_id`, `dayIndex2ShiftType_id`) VALUES
('Shift2Days', 913, 'NE', 1, NULL, NULL, NULL, NULL, NULL, NULL, 830, 828, NULL),
('Shift2Days', 914, 'M2NE', 1, NULL, NULL, NULL, NULL, NULL, NULL, 833, 831, NULL),
('WorkBefore', 932, 'WB', 1, NULL, 2, NULL, NULL, 830, NULL, NULL, NULL, NULL),
('WorkBefore', 933, 'WB2', 1, NULL, 2, NULL, NULL, 833, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `PatternContractLine`
--

CREATE TABLE `PatternContractLine` (
  `id` bigint(20) NOT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `pattern_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PatternContractLine`
--

INSERT INTO `PatternContractLine` (`id`, `contract_id`, `pattern_id`) VALUES
(915, 834, 913),
(934, 834, 932),
(935, 834, 933);

-- --------------------------------------------------------

--
-- Table structure for table `RosterDay`
--

CREATE TABLE `RosterDay` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `RosterDayOff`
--

CREATE TABLE `RosterDayOff` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `RosterParametrizationData`
--

CREATE TABLE `RosterParametrizationData` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `RosterParametrizationData`
--

INSERT INTO `RosterParametrizationData` (`id`, `code`, `endDate`, `startDate`) VALUES
(0, 'Test', '2020-03-07', '2020-02-23');

-- --------------------------------------------------------

--
-- Table structure for table `Shift`
--

CREATE TABLE `Shift` (
  `id` bigint(20) NOT NULL,
  `shift_index` int(11) DEFAULT NULL,
  `requiredEmployeeSize` int(11) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `machineType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftDate`
--

CREATE TABLE `ShiftDate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `dayIndex` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftOffDate`
--

CREATE TABLE `ShiftOffDate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftOffRequest`
--

CREATE TABLE `ShiftOffRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftOnDate`
--

CREATE TABLE `ShiftOnDate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftOnRequest`
--

CREATE TABLE `ShiftOnRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ShiftType`
--

CREATE TABLE `ShiftType` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endTimeString` varchar(255) DEFAULT NULL,
  `Shift_index` int(11) DEFAULT NULL,
  `night` bit(1) NOT NULL,
  `startTimeString` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ShiftType`
--

INSERT INTO `ShiftType` (`id`, `code`, `description`, `endTimeString`, `Shift_index`, `night`, `startTimeString`) VALUES
(829, 'M1L', 'Machine 1 Late Shift', '23:00:00', 0, b'0', '14:30:00'),
(828, 'M1E', 'Machine 1 Early', '16:30:00', 0, b'0', '06:30:00'),
(830, 'M1N', 'Machine 1 Night Shift', '06:30:00', 0, b'1', '23:00:00'),
(831, 'M2E', 'Machine 2 Early', '14:30:00', 0, b'0', '06:30:00'),
(832, 'M2L', 'Machine 2 Late', '23:30:00', 0, b'0', '16:30:00'),
(833, 'M2N', 'Machine 2 Night', '06:30:00', 0, b'1', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `ShiftTypeMachineRequirement`
--

CREATE TABLE `ShiftTypeMachineRequirement` (
  `id` bigint(20) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ShiftTypeMachineRequirement`
--

INSERT INTO `ShiftTypeMachineRequirement` (`id`, `machine_id`, `shiftType_id`) VALUES
(867, 826, 829),
(866, 826, 828),
(868, 826, 830),
(869, 827, 831),
(870, 827, 832),
(871, 827, 833);

-- --------------------------------------------------------

--
-- Table structure for table `ShiftTypeSkillRequirement`
--

CREATE TABLE `ShiftTypeSkillRequirement` (
  `id` bigint(20) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Skill`
--

CREATE TABLE `Skill` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Skill`
--

INSERT INTO `Skill` (`id`, `code`) VALUES
(823, 'S2'),
(822, 'S1'),
(821, 'Quality'),
(824, 'S3'),
(825, 'S4'),
(1023, 'Casual');

-- --------------------------------------------------------

--
-- Table structure for table `SkillProficiency`
--

CREATE TABLE `SkillProficiency` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SkillProficiency`
--

INSERT INTO `SkillProficiency` (`id`, `employee_id`, `skill_id`) VALUES
(1217, 936, 824),
(1216, 936, 821),
(942, 941, 821),
(943, 941, 824),
(1240, 946, 822),
(1239, 946, 823),
(952, 951, 821),
(953, 951, 824),
(954, 951, 825),
(958, 957, 823),
(959, 957, 822),
(960, 957, 821),
(961, 957, 824),
(962, 957, 825),
(996, 965, 825),
(995, 965, 824),
(994, 965, 821),
(993, 965, 822),
(992, 965, 823),
(1061, 971, 825),
(1060, 971, 824),
(1059, 971, 821),
(1058, 971, 822),
(1067, 976, 824),
(1066, 976, 821),
(1065, 976, 822),
(1064, 976, 823),
(1007, 999, 825),
(1006, 999, 824),
(1005, 999, 822),
(1004, 999, 823),
(1011, 1010, 823),
(1012, 1010, 822),
(1013, 1010, 824),
(1017, 1016, 823),
(1018, 1016, 822),
(1019, 1016, 824),
(1020, 1016, 825),
(1025, 1024, 1023),
(1205, 1030, 825),
(1204, 1030, 824),
(1203, 1030, 822),
(1227, 1224, 821),
(1226, 1224, 822),
(1225, 1224, 823),
(1218, 936, 825),
(1242, 946, 825),
(1241, 946, 821),
(1229, 1224, 825),
(1228, 1224, 824),
(1057, 971, 823),
(1068, 976, 825),
(1215, 936, 822),
(1214, 936, 823),
(1202, 1030, 823);

-- --------------------------------------------------------

--
-- Table structure for table `TrainingData`
--

CREATE TABLE `TrainingData` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `shiftType` varchar(255) DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TrainingRequest`
--

CREATE TABLE `TrainingRequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CalendarData`
--
ALTER TABLE `CalendarData`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Contract`
--
ALTER TABLE `Contract`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ContractLine`
--
ALTER TABLE `ContractLine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKks3iwiv1kvajype73v2svgiyd` (`contract_id`);

--
-- Indexes for table `CoverRequirements`
--
ALTER TABLE `CoverRequirements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb4hwhwkauwgm5rcw2dwsouv46` (`shiftType_id`);

--
-- Indexes for table `DayOffDate`
--
ALTER TABLE `DayOffDate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgkvvcng0n9yquha8lsx09yggb` (`employee_id`);

--
-- Indexes for table `DayOffRequest`
--
ALTER TABLE `DayOffRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpyo1oqn1e3qxh7y77xnpr8or0` (`employee_id`),
  ADD KEY `FKcnjmka6kk5ftuk18ah5tldamy` (`shiftDate_id`);

--
-- Indexes for table `DayOnDate`
--
ALTER TABLE `DayOnDate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3i08ea64l262vh0753gbyd9p4` (`employee_id`);

--
-- Indexes for table `DayOnRequest`
--
ALTER TABLE `DayOnRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmfetwkpiyl15ooi8qya4o9ew3` (`employee_id`),
  ADD KEY `FK7op31a7rwvt1fn1lsl1jxfrln` (`shiftDate_id`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3c85oj07itam8uodrx0ar2qrv` (`contract_id`);

--
-- Indexes for table `EmployeeMachine`
--
ALTER TABLE `EmployeeMachine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqj9ck7l9sonvyti4ad4o78ojo` (`employee_id`),
  ADD KEY `FKfdk9o85wblx03u9w392vdykpc` (`machine_id`);

--
-- Indexes for table `Employee_DayOffRequest`
--
ALTER TABLE `Employee_DayOffRequest`
  ADD PRIMARY KEY (`Employee_id`,`dayOffRequestMap_id`),
  ADD UNIQUE KEY `UK_6ukd3e4c3ahspcrbw8tqv78qr` (`dayOffRequestMap_id`);

--
-- Indexes for table `Employee_DayOnRequest`
--
ALTER TABLE `Employee_DayOnRequest`
  ADD PRIMARY KEY (`Employee_id`,`dayOnRequestMap_id`),
  ADD UNIQUE KEY `UK_21jnl15lh2owdju21t77wm8in` (`dayOnRequestMap_id`);

--
-- Indexes for table `Employee_EmployeeMachine`
--
ALTER TABLE `Employee_EmployeeMachine`
  ADD UNIQUE KEY `UK_gtmulgqpcr95k8m23x9ul53e2` (`employeeMachine_id`),
  ADD KEY `FK8pb1g8mjoi0lt3jqxa7of81eg` (`Employee_id`);

--
-- Indexes for table `Employee_HolidayRequest`
--
ALTER TABLE `Employee_HolidayRequest`
  ADD PRIMARY KEY (`Employee_id`,`holidayRequestMap_id`),
  ADD UNIQUE KEY `UK_uu40im9usrsjvioxxkhh4ne7` (`holidayRequestMap_id`);

--
-- Indexes for table `Employee_LeaveRequest`
--
ALTER TABLE `Employee_LeaveRequest`
  ADD PRIMARY KEY (`Employee_id`,`leaveMap_id`),
  ADD UNIQUE KEY `UK_o24oxowpx2tx60vb9bo67txfs` (`leaveMap_id`);

--
-- Indexes for table `Employee_RosterDay`
--
ALTER TABLE `Employee_RosterDay`
  ADD PRIMARY KEY (`Employee_id`,`rosterdayMap_id`),
  ADD UNIQUE KEY `UK_mx4j9hncegm9l3txubgvb7kru` (`rosterdayMap_id`);

--
-- Indexes for table `Employee_ShiftOffRequest`
--
ALTER TABLE `Employee_ShiftOffRequest`
  ADD PRIMARY KEY (`Employee_id`,`shiftOffRequestMap_id`),
  ADD UNIQUE KEY `UK_r5qkw989qxsx7w9ts88fk9q8d` (`shiftOffRequestMap_id`);

--
-- Indexes for table `Employee_ShiftOnRequest`
--
ALTER TABLE `Employee_ShiftOnRequest`
  ADD PRIMARY KEY (`Employee_id`,`shiftOnRequestMap_id`),
  ADD UNIQUE KEY `UK_onc99tm9v58n6gnhsurxpue2` (`shiftOnRequestMap_id`);

--
-- Indexes for table `Employee_TrainingRequest`
--
ALTER TABLE `Employee_TrainingRequest`
  ADD PRIMARY KEY (`Employee_id`,`trainingRequestMap_id`),
  ADD UNIQUE KEY `UK_i8orxffa06q4fu5mnr7m6lp9g` (`trainingRequestMap_id`);

--
-- Indexes for table `HolidayRequest`
--
ALTER TABLE `HolidayRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjsgs4t7akc2qq9sirmuc9nj73` (`employee_id`),
  ADD KEY `FKk4tccf66bymjklpt4kkab7p3a` (`endshiftDate_id`),
  ADD KEY `FKoh43ab4q5rhk2tn1crh3cpqoq` (`startshiftDate_id`);

--
-- Indexes for table `HolidaysData`
--
ALTER TABLE `HolidaysData`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKljv4949j16faxr1n4rbuhxgym` (`employee_id`);

--
-- Indexes for table `LeaveData`
--
ALTER TABLE `LeaveData`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3dn9dh6cxxowsxkiee9wviyn9` (`employee_id`),
  ADD KEY `FK7f9m8b40ow62il41pi01ii4fx` (`shiftType_id`);

--
-- Indexes for table `LeaveRequest`
--
ALTER TABLE `LeaveRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg3i4xdy258ug6id6o26u0v8fp` (`employee_id`),
  ADD KEY `FKkdyx0t93vv1bxgn60d3ukue8` (`endshiftDate_id`),
  ADD KEY `FK5mi25icdc1jq7x8m2g6jiy42n` (`shift_id`),
  ADD KEY `FKkl0not2wkh7e05vy1fqys06nd` (`shiftType_id`),
  ADD KEY `FKd52p49gafq6dts4hoh8use2nl` (`startshiftDate_id`);

--
-- Indexes for table `Machine`
--
ALTER TABLE `Machine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `MachineTypeSkillsRequirement`
--
ALTER TABLE `MachineTypeSkillsRequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9en411q8trlgst30gncscebm5` (`machine_id`),
  ADD KEY `FKgb7glhgsf15k0qpx78lesexrd` (`shiftType_id`),
  ADD KEY `FKcmgyi17rlwg6fgk7kffibkq9g` (`skill_id`);

--
-- Indexes for table `Pattern`
--
ALTER TABLE `Pattern`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKieddnrui1m77eui84r2s1wgjg` (`workShiftType_id`),
  ADD KEY `FKyjoriwu3ccd7cfejqah46ttm` (`employee_id`),
  ADD KEY `FKcgeu0vfp7jfnaamat7eepp7l6` (`dayIndex0ShiftType_id`),
  ADD KEY `FK82htfcv0vdjipn65758v8gke3` (`dayIndex1ShiftType_id`),
  ADD KEY `FKdelr3729occ5v17cq587ixd1a` (`dayIndex2ShiftType_id`);

--
-- Indexes for table `PatternContractLine`
--
ALTER TABLE `PatternContractLine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKxhq4kfp59w8v6h7gwmhgbsug` (`contract_id`),
  ADD KEY `FKb5pyfowja1psc0nbbav4nm67u` (`pattern_id`);

--
-- Indexes for table `RosterDay`
--
ALTER TABLE `RosterDay`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfcpcbhwcu7twxxae7xg7k0ax` (`employee_id`),
  ADD KEY `FKqd8nh797lt8sjsefuc34fw37r` (`shift_id`),
  ADD KEY `FKij8l44390o3evv0nyd5f3o6ld` (`shiftDate_id`),
  ADD KEY `FK46kw5125oc9lyg101oln358e1` (`shiftType_id`);

--
-- Indexes for table `RosterDayOff`
--
ALTER TABLE `RosterDayOff`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrd0vy1miwfshpa5xte90arag` (`employee_id`),
  ADD KEY `FKt20rut4tx4wwe3afn5s2ytahc` (`shift_id`),
  ADD KEY `FKpbusrlk8boxg0rhbny9v0g3xf` (`shiftType_id`);

--
-- Indexes for table `RosterParametrizationData`
--
ALTER TABLE `RosterParametrizationData`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Shift`
--
ALTER TABLE `Shift`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKplw8xjmjryi0mxpggqcyn7huj` (`machine_id`),
  ADD KEY `FK9gxamrwlgdl106jsagit7s4n` (`machineType_id`),
  ADD KEY `FKpe9wvrqm9ikwlah0i9oo018x0` (`shiftDate_id`),
  ADD KEY `FKn1ko8kai4ortj14amvyaaupka` (`shiftType_id`);

--
-- Indexes for table `ShiftDate`
--
ALTER TABLE `ShiftDate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ShiftOffDate`
--
ALTER TABLE `ShiftOffDate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnux1dq56lnusrp97qnejd3u5a` (`employee_id`),
  ADD KEY `FK1pam1akme2t5qsj1nqivaafuv` (`shiftType_id`);

--
-- Indexes for table `ShiftOffRequest`
--
ALTER TABLE `ShiftOffRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh604hhlq2ka1wu6j6npmvish5` (`employee_id`),
  ADD KEY `FKg2v5hp8mpa2va8cbbkytwxdq1` (`shift_id`);

--
-- Indexes for table `ShiftOnDate`
--
ALTER TABLE `ShiftOnDate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5eefa2viicvaln5t7uj21m76n` (`employee_id`),
  ADD KEY `FK9tvrmhv9cbwd6c0qmxtxxxnn8` (`shiftType_id`);

--
-- Indexes for table `ShiftOnRequest`
--
ALTER TABLE `ShiftOnRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3py6d6mm9tggsu8gomnl3c8bj` (`employee_id`),
  ADD KEY `FKsmgfbibkupw7whnn78xuetulx` (`shift_id`);

--
-- Indexes for table `ShiftType`
--
ALTER TABLE `ShiftType`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ShiftTypeMachineRequirement`
--
ALTER TABLE `ShiftTypeMachineRequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlgrm82xg8vx2qgmc7xjlhmcui` (`machine_id`),
  ADD KEY `FKcvrjoe6y6hdhqwlcj9s2rsda6` (`shiftType_id`);

--
-- Indexes for table `ShiftTypeSkillRequirement`
--
ALTER TABLE `ShiftTypeSkillRequirement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7elqms0w3sd9ms79kj94scybp` (`shiftType_id`),
  ADD KEY `FKcq1rgunxaa69sfpmtqiffnehk` (`skill_id`);

--
-- Indexes for table `Skill`
--
ALTER TABLE `Skill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `SkillProficiency`
--
ALTER TABLE `SkillProficiency`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhu3d5yo0x2cx2vv1f9k2kso2f` (`employee_id`),
  ADD KEY `FK2u1hqp6jh7ns03bf9butjhym0` (`skill_id`);

--
-- Indexes for table `TrainingData`
--
ALTER TABLE `TrainingData`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdlgrccheqd596yj14l2phn0mt` (`employee_id`),
  ADD KEY `FKe7xxgvx4jphlic2ti4f53h3i` (`shift_id`);

--
-- Indexes for table `TrainingRequest`
--
ALTER TABLE `TrainingRequest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg3ppac1qvy5nys19u2g2kdvf4` (`employee_id`),
  ADD KEY `FK3omuc6j0po1ni7g0lasxqylab` (`shift_id`),
  ADD KEY `FKbkwhs72iibhtqoa8stt8ip27r` (`shiftDate_id`),
  ADD KEY `FK8a9dmsdgrk57pkbpglm54fvee` (`shiftType_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
