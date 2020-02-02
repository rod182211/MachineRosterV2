-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 02, 2020 at 11:30 PM
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
(593, 'Kim Farr', '24:00:00', b'0', '2020-02-09', 'Leave', 'Leave', '06:00:00'),
(592, 'Graham Thomson', '21:00:00', b'0', '2020-02-09', 'LC', 'LC', '12:30:00'),
(591, 'Genoveva Phillips', '07:15:00', b'1', '2020-02-09', 'Night', 'N', '23:45:00'),
(590, 'Modupe Alofokhai', '07:15:00', b'1', '2020-02-09', 'Night', 'N', '23:45:00'),
(588, 'Sharon Bamforth', '23:00:00', b'0', '2020-02-09', 'Late', 'L', '14:30:00'),
(589, 'Louise Davidson', '23:00:00', b'0', '2020-02-09', 'Late', 'L', '14:30:00'),
(587, 'Candida Blackwell', '15:30:00', b'0', '2020-02-09', 'Early', 'E', '07:00:00'),
(585, 'Kim Farr', '24:00:00', b'0', '2020-02-08', 'Leave', 'Leave', '06:00:00'),
(586, 'Richard Foreman', '15:30:00', b'0', '2020-02-09', 'Early', 'E', '07:00:00'),
(584, 'Graham Thomson', '21:00:00', b'0', '2020-02-08', 'LC', 'LC', '12:30:00'),
(583, 'Genoveva Phillips', '07:15:00', b'1', '2020-02-08', 'Night', 'N', '23:45:00'),
(581, 'Sharon Bamforth', '23:00:00', b'0', '2020-02-08', 'Late', 'L', '14:30:00'),
(582, 'Modupe Alofokhai', '07:15:00', b'1', '2020-02-08', 'Night', 'N', '23:45:00'),
(580, 'Louise Davidson', '23:00:00', b'0', '2020-02-08', 'Late', 'L', '14:30:00'),
(578, 'Richard Foreman', '15:30:00', b'0', '2020-02-08', 'Early', 'E', '07:00:00'),
(579, 'Candida Blackwell', '15:30:00', b'0', '2020-02-08', 'Early', 'E', '07:00:00'),
(577, 'Kim Farr', '24:00:00', b'0', '2020-02-07', 'Leave', 'Leave', '06:00:00'),
(576, 'Rosmary Moloney', '21:00:00', b'0', '2020-02-07', 'LC', 'LC', '12:30:00'),
(574, 'Joanne Muir', '07:15:00', b'1', '2020-02-07', 'Night', 'N', '23:45:00'),
(575, 'Richard Foreman', '23:00:00', b'0', '2020-02-07', 'ADO', 'ADO', '06:30:00'),
(573, 'Amanda Rees', '07:15:00', b'1', '2020-02-07', 'Night', 'N', '23:45:00'),
(572, 'Modupe Alofokhai', '23:00:00', b'0', '2020-02-07', 'Late', 'L', '14:30:00'),
(570, 'Genoveva Phillips', '15:30:00', b'0', '2020-02-07', 'Early', 'E', '07:00:00'),
(571, 'Sharon Bamforth', '23:00:00', b'0', '2020-02-07', 'Late', 'L', '14:30:00'),
(569, 'Candida Blackwell', '15:30:00', b'0', '2020-02-07', 'Early', 'E', '07:00:00'),
(568, 'Graham Thomson', '15:30:00', b'0', '2020-02-07', 'Early', 'E', '07:00:00'),
(567, 'Kim Farr', '24:00:00', b'0', '2020-02-06', 'Leave', 'Leave', '06:00:00'),
(566, 'Genoveva Phillips', '21:00:00', b'0', '2020-02-06', 'LC', 'LC', '12:30:00'),
(565, 'Joanne Muir', '07:15:00', b'1', '2020-02-06', 'Night', 'N', '23:45:00'),
(563, 'Janette Pascoe', '23:00:00', b'0', '2020-02-06', 'Late', 'L', '14:30:00'),
(564, 'Amanda Rees', '07:15:00', b'1', '2020-02-06', 'Night', 'N', '23:45:00'),
(561, 'Sharon Bamforth', '15:30:00', b'0', '2020-02-06', 'Early', 'E', '07:00:00'),
(562, 'Modupe Alofokhai', '23:00:00', b'0', '2020-02-06', 'Late', 'L', '14:30:00'),
(560, 'Rosmary Moloney', '15:30:00', b'0', '2020-02-06', 'Early', 'E', '07:00:00'),
(558, 'Kim Farr', '24:00:00', b'0', '2020-02-05', 'Leave', 'Leave', '06:00:00'),
(559, 'Graham Thomson', '15:30:00', b'0', '2020-02-06', 'Early', 'E', '07:00:00'),
(557, 'Janette Pascoe', '21:00:00', b'0', '2020-02-05', 'LC', 'LC', '12:30:00'),
(556, 'Louise Davidson', '07:15:00', b'1', '2020-02-05', 'Night', 'N', '23:45:00'),
(554, 'Casual', '23:00:00', b'0', '2020-02-05', 'Late', 'L', '14:30:00'),
(555, 'Joanne Muir', '07:15:00', b'1', '2020-02-05', 'Night', 'N', '23:45:00'),
(553, 'Amanda Rees', '23:00:00', b'0', '2020-02-05', 'Late', 'L', '14:30:00'),
(551, 'Rosmary Moloney', '15:30:00', b'0', '2020-02-05', 'Early', 'E', '07:00:00'),
(552, 'Genoveva Phillips', '15:30:00', b'0', '2020-02-05', 'Early', 'E', '07:00:00'),
(550, 'Sharon Bamforth', '15:30:00', b'0', '2020-02-05', 'Early', 'E', '07:00:00'),
(548, 'Janette Pascoe', '21:00:00', b'0', '2020-02-04', 'LC', 'LC', '12:30:00'),
(549, 'Kim Farr', '24:00:00', b'0', '2020-02-04', 'Leave', 'Leave', '06:00:00'),
(546, 'Joanne Muir', '07:15:00', b'1', '2020-02-04', 'Night', 'N', '23:45:00'),
(547, 'Richard Foreman', '07:15:00', b'1', '2020-02-04', 'Night', 'N', '23:45:00'),
(545, 'Amanda Rees', '23:00:00', b'0', '2020-02-04', 'Late', 'L', '14:30:00'),
(543, 'Louise Davidson', '15:30:00', b'0', '2020-02-04', 'Early', 'E', '07:00:00'),
(544, 'Casual', '23:00:00', b'0', '2020-02-04', 'Late', 'L', '14:30:00'),
(542, 'Rosmary Moloney', '15:30:00', b'0', '2020-02-04', 'Early', 'E', '07:00:00'),
(541, 'Candida Blackwell', '15:30:00', b'0', '2020-02-04', 'Early', 'E', '07:00:00'),
(539, 'Rosmary Moloney', '23:00:00', b'0', '2020-02-03', 'ADO', 'ADO', '06:30:00'),
(540, 'Candida Blackwell', '21:00:00', b'0', '2020-02-03', 'LC', 'LC', '12:30:00'),
(538, 'Graham Thomson', '07:15:00', b'1', '2020-02-03', 'Night', 'N', '23:45:00'),
(537, 'Richard Foreman', '07:15:00', b'1', '2020-02-03', 'Night', 'N', '23:45:00'),
(535, 'Janette Pascoe', '23:00:00', b'0', '2020-02-03', 'Late', 'L', '14:30:00'),
(536, 'Modupe Alofokhai', '23:00:00', b'0', '2020-02-03', 'Late', 'L', '14:30:00'),
(534, 'Casual', '15:30:00', b'0', '2020-02-03', 'Early', 'E', '07:00:00'),
(533, 'Joanne Muir', '15:30:00', b'0', '2020-02-03', 'Early', 'E', '07:00:00'),
(531, 'Amanda Rees', '15:30:00', b'0', '2020-02-03', 'Early', 'E', '07:00:00'),
(532, 'Louise Davidson', '15:30:00', b'0', '2020-02-03', 'Early', 'E', '07:00:00'),
(530, 'Louise Davidson', '21:00:00', b'0', '2020-02-02', 'LC', 'LC', '12:30:00'),
(528, 'Sharon Bamforth', '07:15:00', b'1', '2020-02-02', 'Night', 'N', '23:45:00'),
(529, 'Graham Thomson', '07:15:00', b'1', '2020-02-02', 'Night', 'N', '23:45:00'),
(527, 'Richard Foreman', '23:00:00', b'0', '2020-02-02', 'Late', 'L', '14:30:00'),
(526, 'Modupe Alofokhai', '23:00:00', b'0', '2020-02-02', 'Late', 'L', '14:30:00'),
(524, 'Candida Blackwell', '15:30:00', b'0', '2020-02-02', 'Early', 'E', '07:00:00'),
(525, 'Genoveva Phillips', '15:30:00', b'0', '2020-02-02', 'Early', 'E', '07:00:00'),
(523, 'Graham Thomson', '21:00:00', b'0', '2020-02-01', 'LC', 'LC', '12:30:00'),
(521, 'Janette Pascoe', '07:15:00', b'1', '2020-02-01', 'Night', 'N', '23:45:00'),
(522, 'Sharon Bamforth', '07:15:00', b'1', '2020-02-01', 'Night', 'N', '23:45:00'),
(520, 'Richard Foreman', '23:00:00', b'0', '2020-02-01', 'Late', 'L', '14:30:00'),
(519, 'Louise Davidson', '23:00:00', b'0', '2020-02-01', 'Late', 'L', '14:30:00'),
(518, 'Genoveva Phillips', '15:30:00', b'0', '2020-02-01', 'Early', 'E', '07:00:00'),
(517, 'Candida Blackwell', '15:30:00', b'0', '2020-02-01', 'Early', 'E', '07:00:00'),
(515, 'Richard Foreman', '21:00:00', b'0', '2020-01-31', 'LC', 'LC', '12:30:00'),
(516, 'Joanne Muir', '24:00:00', b'0', '2020-01-31', 'Leave', 'Leave', '06:00:00'),
(514, 'Rosmary Moloney', '07:15:00', b'1', '2020-01-31', 'Night', 'N', '23:45:00'),
(513, 'Janette Pascoe', '07:15:00', b'1', '2020-01-31', 'Night', 'N', '23:45:00'),
(511, 'Amanda Rees', '23:00:00', b'0', '2020-01-31', 'Late', 'L', '14:30:00'),
(512, 'Casual', '23:00:00', b'0', '2020-01-31', 'Late', 'L', '14:30:00'),
(510, 'Sharon Bamforth', '15:30:00', b'0', '2020-01-31', 'Early', 'E', '07:00:00'),
(509, 'Genoveva Phillips', '15:30:00', b'0', '2020-01-31', 'Early', 'E', '07:00:00'),
(508, 'Candida Blackwell', '15:30:00', b'0', '2020-01-31', 'Early', 'E', '07:00:00'),
(507, 'Joanne Muir', '24:00:00', b'0', '2020-01-30', 'Leave', 'Leave', '06:00:00'),
(506, 'Sharon Bamforth', '21:00:00', b'0', '2020-01-30', 'LC', 'LC', '12:30:00'),
(505, 'Kim Farr', '07:15:00', b'1', '2020-01-30', 'Night', 'N', '23:45:00'),
(504, 'Rosmary Moloney', '07:15:00', b'1', '2020-01-30', 'Night', 'N', '23:45:00'),
(503, 'Graham Thomson', '23:00:00', b'0', '2020-01-30', 'Late', 'L', '14:30:00'),
(502, 'Amanda Rees', '23:00:00', b'0', '2020-01-30', 'Late', 'L', '14:30:00'),
(501, 'Modupe Alofokhai', '15:30:00', b'0', '2020-01-30', 'Early', 'E', '07:00:00'),
(500, 'Genoveva Phillips', '15:30:00', b'0', '2020-01-30', 'Early', 'E', '07:00:00'),
(499, 'Casual', '15:30:00', b'0', '2020-01-30', 'Early', 'E', '07:00:00'),
(498, 'Joanne Muir', '24:00:00', b'0', '2020-01-29', 'Leave', 'Leave', '06:00:00'),
(497, 'Sharon Bamforth', '21:00:00', b'0', '2020-01-29', 'LC', 'LC', '12:30:00'),
(496, 'Louise Davidson', '07:15:00', b'1', '2020-01-29', 'Night', 'N', '23:45:00'),
(495, 'Kim Farr', '07:15:00', b'1', '2020-01-29', 'Night', 'N', '23:45:00'),
(494, 'Rosmary Moloney', '23:00:00', b'0', '2020-01-29', 'Late', 'L', '14:30:00'),
(493, 'Amanda Rees', '23:00:00', b'0', '2020-01-29', 'Late', 'L', '14:30:00'),
(492, 'Modupe Alofokhai', '15:30:00', b'0', '2020-01-29', 'Early', 'E', '07:00:00'),
(491, 'Graham Thomson', '15:30:00', b'0', '2020-01-29', 'Early', 'E', '07:00:00'),
(490, 'Genoveva Phillips', '15:30:00', b'0', '2020-01-29', 'Early', 'E', '07:00:00'),
(489, 'Joanne Muir', '24:00:00', b'0', '2020-01-28', 'Leave', 'Leave', '06:00:00'),
(488, 'Janette Pascoe', '21:00:00', b'0', '2020-01-28', 'LC', 'LC', '12:30:00'),
(487, 'Graham Thomson', '23:00:00', b'0', '2020-01-28', 'ADO', 'ADO', '06:30:00'),
(486, 'Modupe Alofokhai', '23:00:00', b'0', '2020-01-28', 'ADO', 'ADO', '06:30:00'),
(485, 'Louise Davidson', '07:15:00', b'1', '2020-01-28', 'Night', 'N', '23:45:00'),
(484, 'Candida Blackwell', '07:15:00', b'1', '2020-01-28', 'Night', 'N', '23:45:00'),
(483, 'Richard Foreman', '23:00:00', b'0', '2020-01-28', 'Late', 'L', '14:30:00'),
(482, 'Rosmary Moloney', '23:00:00', b'0', '2020-01-28', 'Late', 'L', '14:30:00'),
(481, 'Kim Farr', '15:30:00', b'0', '2020-01-28', 'Early', 'E', '07:00:00'),
(480, 'Amanda Rees', '15:30:00', b'0', '2020-01-28', 'Early', 'E', '07:00:00'),
(479, 'Casual', '15:30:00', b'0', '2020-01-28', 'Early', 'E', '07:00:00'),
(478, 'Joanne Muir', '24:00:00', b'0', '2020-01-27', 'Leave', 'Leave', '06:00:00'),
(477, 'Rosmary Moloney', '21:00:00', b'0', '2020-01-27', 'LC', 'LC', '12:30:00'),
(476, 'Casual', '07:15:00', b'1', '2020-01-27', 'Night', 'N', '23:45:00'),
(475, 'Candida Blackwell', '07:15:00', b'1', '2020-01-27', 'Night', 'N', '23:45:00'),
(474, 'Louise Davidson', '23:00:00', b'0', '2020-01-27', 'Late', 'L', '14:30:00'),
(473, 'Richard Foreman', '23:00:00', b'0', '2020-01-27', 'Late', 'L', '14:30:00'),
(472, 'Kim Farr', '15:30:00', b'0', '2020-01-27', 'Early', 'E', '07:00:00'),
(471, 'Modupe Alofokhai', '15:30:00', b'0', '2020-01-27', 'Early', 'E', '07:00:00'),
(470, 'Amanda Rees', '15:30:00', b'0', '2020-01-27', 'Early', 'E', '07:00:00'),
(469, 'Janette Pascoe', '15:30:00', b'0', '2020-01-27', 'Early', 'E', '07:00:00');

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
('MinMaxContractLine', 15, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 3, b'1', 1, 1, 1),
('MinMaxContractLine', 16, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 4, 1, b'1', 2, 3, 1),
('MinMaxContractLine', 17, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 18, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 1),
('MinMaxContractLine', 19, 'TOTAL_NIGHT_ASSIGNMENTS', NULL, NULL, b'1', 5, 1, b'1', 2, 1, 1),
('MinMaxContractLine', 20, 'CONSECUTIVE_LATE_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 1),
('MinMaxContractLine', 21, 'CONSECUTIVE_EARLY_ASSIGNMENTS', NULL, NULL, b'0', 0, 0, b'0', 0, 0, 1),
('MinMaxContractLine', 22, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 8, 1, b'1', 8, 1, 2),
('MinMaxContractLine', 23, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 3, b'1', 1, 1, 2),
('MinMaxContractLine', 24, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 6, 1, b'1', 2, 3, 2),
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
('BooleanContractLine', 50, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 51, 'ALTERNATIVE_DEPARTMENT', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 52, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 53, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 1),
('BooleanContractLine', 54, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 55, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 56, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 57, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
('BooleanContractLine', 58, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 2),
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
('BooleanContractLine', 75, 'ALTERNATIVE_DEPARTMENT', b'0', 0, NULL, NULL, NULL, NULL, NULL, NULL, 4),
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
(114, 1, 3, 11),
(115, 2, 3, 11),
(117, 3, 3, 11),
(118, 4, 3, 11),
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
(134, 6, 2, 13),
(297, 0, 1, 264),
(298, 1, 1, 264),
(299, 2, 1, 264),
(300, 3, 1, 264),
(301, 4, 1, 264),
(302, 5, 1, 264),
(303, 6, 1, 264);

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

--
-- Dumping data for table `dayoffdate`
--

INSERT INTO `dayoffdate` (`id`, `date`, `weight`, `employee_id`) VALUES
(270, '2020-02-06', 2, 99),
(273, '2020-02-07', 2, 101),
(314, '2020-01-31', 2, 96);

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
(261, 'CCU');

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
(96, '', '1', '', '1', 'Employee 1', '', '', '', 1, 261, 5),
(97, '', '2', '', '2', 'Employee 2', '', '', '', 1, 261, 5),
(98, '', '3', '', '3', 'Employee 3', '', '', '', 1, 261, 5),
(99, '', '4', '', '4', 'Employee 4', '', '', '', 1, 261, 5),
(101, '', '6', '', '6', 'Employee 6', '', '', '', 2, 261, 7),
(102, '', '7', '', '7', 'Employee 7', '', '', '', 1, 261, 7),
(103, '', '8', '', '8', 'Employee 8', '', '', '', 1, 261, 7),
(104, '', '9', '', '9', 'Employee 9', '', '', '', 1, 261, 7),
(105, '', '10', '', '10', 'Employee 10', '', '', '', 1, 261, 7),
(106, '', '11', '', '11', 'Employee 11', '', '', '', 1, 261, 7),
(304, '', 'Casual', '', 'Casual', 'Casual', '', '', '', 3, 261, 6),
(262, '', '12', '', '12', 'Employee 12', '', '', '', 1, 261, 8),
(263, '', '13', '', '13', 'Employee 13', '', '', '', 1, 261, 8),
(619, '', 'Casual 2', '', 'Casual 2', 'Casual 2', '', '', '', 3, 261, 6);

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
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622),
(622);

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

--
-- Dumping data for table `holidaysdata`
--

INSERT INTO `holidaysdata` (`id`, `enddate`, `startdate`, `weight`, `employee_id`) VALUES
(317, '2020-01-28', '2020-01-27', 1, 106),
(318, '2020-01-28', '2020-01-27', 1, 262),
(319, '2020-01-27', '2020-01-27', 1, 96);

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

--
-- Dumping data for table `leavedata`
--

INSERT INTO `leavedata` (`id`, `enddate`, `startdate`, `weight`, `employee_id`, `shiftType_id`) VALUES
(281, '2020-02-09', '2020-02-04', 0, 263, NULL),
(315, '2020-01-31', '2020-01-27', 0, 104, NULL);

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
('Shift2Days', 445, 'NE', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 11, NULL),
('Shift2Days', 446, 'NL', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 12, NULL),
('Shift2Days', 447, 'NLC', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 264, NULL),
('Shift2Days', 448, 'NADO', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 258, NULL),
('Shift2Days', 449, 'NLeave', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 265, NULL),
('Shift2Days', 450, 'NTraining', 4, NULL, NULL, NULL, NULL, NULL, NULL, 13, 260, NULL),
('Shift2Days', 465, 'LE', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12, 11, NULL),
('FreeBefore', 468, 'FB', 1, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('WorkBefore', 596, 'WB', 5, NULL, 2, NULL, NULL, 13, NULL, NULL, NULL, NULL),
('Shift3Days', 599, 'LCLE', 3, NULL, NULL, NULL, NULL, NULL, NULL, 264, 12, 11),
('Shift2Days', 602, 'EN', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11, 13, NULL),
('Shift3Days', 604, 'ELN', 3, NULL, NULL, NULL, NULL, NULL, NULL, 11, 12, 13),
('Shift3Days', 607, 'LLCE', 3, NULL, NULL, NULL, NULL, NULL, NULL, 12, 264, 11),
('Shift2Days', 610, 'EL', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11, 12, NULL),
('Shift2Days', 613, 'LCN', 1, NULL, NULL, NULL, NULL, NULL, NULL, 264, 13, NULL);

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
(452, 1, 445),
(453, 1, 446),
(454, 1, 447),
(455, 1, 448),
(456, 1, 449),
(457, 1, 450),
(459, 2, 445),
(460, 2, 446),
(461, 2, 447),
(462, 2, 448),
(463, 2, 449),
(464, 2, 450),
(466, 1, 465),
(467, 2, 465),
(617, 2, 468),
(616, 1, 468),
(600, 1, 599),
(601, 2, 599),
(603, 1, 602),
(605, 1, 604),
(606, 2, 604),
(608, 1, 607),
(609, 2, 607),
(611, 1, 610),
(612, 2, 610),
(614, 1, 613),
(615, 2, 613);

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

--
-- Dumping data for table `rosterdayoff`
--

INSERT INTO `rosterdayoff` (`id`, `date`, `weight`, `employee_id`, `shift_id`, `shiftType_id`) VALUES
(257, '2020-01-28', 0, 96, NULL, NULL),
(269, '2020-02-07', 0, 99, NULL, NULL),
(274, '2020-02-03', 0, 103, NULL, NULL),
(307, '2020-01-28', 0, 105, NULL, NULL);

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
(0, 'Test', '2020-02-09', '2020-01-27');

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

--
-- Dumping data for table `shiftondate`
--

INSERT INTO `shiftondate` (`id`, `date`, `weight`, `employee_id`, `shiftType_id`) VALUES
(266, '2020-01-27', 2, 97, 12),
(267, '2020-01-28', 2, 97, 13),
(268, '2020-01-29', 2, 97, 13),
(271, '2020-01-31', 2, 101, 13),
(272, '2020-02-01', 2, 101, 13),
(275, '2020-01-27', 2, 105, 11),
(276, '2020-02-08', 2, 105, 13),
(277, '2020-01-27', 2, 98, 13),
(278, '2020-01-28', 2, 98, 13);

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
(11, 'E', 'Early', '15:30:00', 0, b'0', '07:00:00'),
(12, 'L', 'Late', '23:00:00', 0, b'0', '14:30:00'),
(13, 'N', 'Night', '07:15:00', 0, b'0', '23:45:00'),
(258, 'ADO', 'ADO', '23:00:00', 0, b'0', '06:30:00'),
(260, 'Training', 'Training', '16:30:00', 0, b'0', '06:30:00'),
(264, 'LC', 'LC', '21:00:00', 0, b'0', '12:30:00'),
(265, 'Leave', 'Leave', '24:00:00', 0, b'0', '06:00:00');

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
(294, 261, 260),
(293, 261, 258),
(292, 261, 13),
(291, 261, 12),
(290, 261, 11),
(295, 261, 264),
(296, 261, 265);

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
(112, 13, 5),
(282, 11, 5),
(283, 12, 7),
(284, 12, 8),
(285, 13, 7),
(286, 13, 8),
(288, 264, 7),
(289, 264, 8),
(620, 264, 5);

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
(5, 'G6'),
(6, 'Casual'),
(7, 'G5'),
(8, 'G3');

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
