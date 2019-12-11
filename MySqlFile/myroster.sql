-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 11, 2019 at 04:49 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myroster`
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calendardata`
--

INSERT INTO `calendardata` (`id`, `employeename`, `endTime`, `isNight`, `shiftDate`, `shiftDescription`, `shiftType`, `startTIme`) VALUES
(2579, 'Employee  8', '23:00:00', b'0', '2019-10-20', 'Late', 'L', '14:30:00'),
(2577, 'Employee  7', '21:00:00', b'0', '2019-10-20', 'LC', 'LC', '12:30:00'),
(2578, 'Employee  3', '21:00:00', b'0', '2019-10-20', 'LC', 'LC', '12:30:00'),
(2576, 'Employee  6', '15:30:00', b'0', '2019-10-20', 'Early', 'E', '07:00:00'),
(2575, 'Employee  4', '15:30:00', b'0', '2019-10-20', 'Early', 'E', '07:00:00'),
(2574, 'Casual 4', '07:15:00', b'1', '2019-10-19', 'Night', 'N', '22:45:00'),
(2573, 'Employee 9', '07:15:00', b'1', '2019-10-19', 'Night', 'N', '22:45:00'),
(2571, 'Employee  3', '23:00:00', b'0', '2019-10-19', 'Late', 'L', '14:30:00'),
(2572, 'Employee  12', '23:00:00', b'0', '2019-10-19', 'Late', 'L', '14:30:00'),
(2570, 'Employee  7', '21:00:00', b'0', '2019-10-19', 'LC', 'LC', '12:30:00'),
(2569, 'Employee 1', '21:00:00', b'0', '2019-10-19', 'LC', 'LC', '12:30:00'),
(2567, 'Employee  2', '15:30:00', b'0', '2019-10-19', 'Early', 'E', '07:00:00'),
(2568, 'Employee  4', '15:30:00', b'0', '2019-10-19', 'Early', 'E', '07:00:00'),
(2566, 'Employee  11', '07:15:00', b'1', '2019-10-18', 'Night', 'N', '22:45:00'),
(2565, 'Employee  10', '07:15:00', b'1', '2019-10-18', 'Night', 'N', '22:45:00'),
(2564, 'Casual 4', '23:00:00', b'0', '2019-10-18', 'Late', 'L', '14:30:00'),
(2562, 'Casual', '21:00:00', b'0', '2019-10-18', 'LC', 'LC', '12:30:00'),
(2563, 'Employee  3', '23:00:00', b'0', '2019-10-18', 'Late', 'L', '14:30:00'),
(2559, 'Employee  2', '15:30:00', b'0', '2019-10-18', 'Early', 'E', '07:00:00'),
(2560, 'Employee  5', '15:30:00', b'0', '2019-10-18', 'Early', 'E', '07:00:00'),
(2561, 'Employee  7', '21:00:00', b'0', '2019-10-18', 'LC', 'LC', '12:30:00'),
(2558, 'Employee  12', '15:30:00', b'0', '2019-10-18', 'Early', 'E', '07:00:00'),
(2557, 'Employee  8', '07:15:00', b'1', '2019-10-17', 'Night', 'N', '22:45:00'),
(2556, 'Employee  6', '07:15:00', b'1', '2019-10-17', 'Night', 'N', '22:45:00'),
(2555, 'Casual 3', '23:00:00', b'0', '2019-10-17', 'Late', 'L', '14:30:00'),
(2554, 'Employee  11', '23:00:00', b'0', '2019-10-17', 'Late', 'L', '14:30:00'),
(2553, 'Employee  2', '21:00:00', b'0', '2019-10-17', 'LC', 'LC', '12:30:00'),
(2552, 'Employee  10', '21:00:00', b'0', '2019-10-17', 'LC', 'LC', '12:30:00'),
(2551, 'Employee  12', '15:30:00', b'0', '2019-10-17', 'Early', 'E', '07:00:00'),
(2550, 'Employee  3', '15:30:00', b'0', '2019-10-17', 'Early', 'E', '07:00:00'),
(2548, 'Employee  4', '07:15:00', b'1', '2019-10-16', 'Night', 'N', '22:45:00'),
(2549, 'Employee 9', '07:15:00', b'1', '2019-10-16', 'Night', 'N', '22:45:00'),
(2547, 'Employee  6', '23:00:00', b'0', '2019-10-16', 'Late', 'L', '14:30:00'),
(2546, 'Employee  10', '23:00:00', b'0', '2019-10-16', 'Late', 'L', '14:30:00'),
(2543, 'Employee  2', '15:30:00', b'0', '2019-10-16', 'Early', 'E', '07:00:00'),
(2544, 'Employee  11', '21:00:00', b'0', '2019-10-16', 'LC', 'LC', '12:30:00'),
(2545, 'Employee  12', '21:00:00', b'0', '2019-10-16', 'LC', 'LC', '12:30:00'),
(2542, 'Casual', '15:30:00', b'0', '2019-10-16', 'Early', 'E', '07:00:00'),
(2541, 'Employee  5', '07:15:00', b'1', '2019-10-15', 'Night', 'N', '22:45:00'),
(2540, 'Employee  7', '07:15:00', b'1', '2019-10-15', 'Night', 'N', '22:45:00'),
(2539, 'Employee 9', '23:00:00', b'0', '2019-10-15', 'Late', 'L', '14:30:00'),
(2538, 'Employee  6', '23:00:00', b'0', '2019-10-15', 'Late', 'L', '14:30:00'),
(2537, 'Employee  12', '21:00:00', b'0', '2019-10-15', 'LC', 'LC', '12:30:00'),
(2536, 'Employee  4', '21:00:00', b'0', '2019-10-15', 'LC', 'LC', '12:30:00'),
(2535, 'Casual', '15:30:00', b'0', '2019-10-15', 'Early', 'E', '07:00:00'),
(2534, 'Employee  10', '15:30:00', b'0', '2019-10-15', 'Early', 'E', '07:00:00'),
(2533, 'Employee  3', '07:15:00', b'1', '2019-10-14', 'Night', 'N', '22:45:00'),
(2532, 'Employee  8', '07:15:00', b'1', '2019-10-14', 'Night', 'N', '22:45:00'),
(2531, 'Employee 9', '23:00:00', b'0', '2019-10-14', 'Late', 'L', '14:30:00'),
(2528, 'Casual 3', '21:00:00', b'0', '2019-10-14', 'LC', 'LC', '12:30:00'),
(2529, 'Employee  10', '21:00:00', b'0', '2019-10-14', 'LC', 'LC', '12:30:00'),
(2530, 'Casual', '23:00:00', b'0', '2019-10-14', 'Late', 'L', '14:30:00'),
(2527, 'Employee  4', '15:30:00', b'0', '2019-10-14', 'Early', 'E', '07:00:00'),
(2524, 'Employee  11', '07:15:00', b'1', '2019-10-13', 'Night', 'N', '22:45:00'),
(2525, 'Employee  12', '15:30:00', b'0', '2019-10-14', 'Early', 'E', '07:00:00'),
(2526, 'Employee  7', '15:30:00', b'0', '2019-10-14', 'Early', 'E', '07:00:00'),
(2523, 'Employee  2', '07:15:00', b'1', '2019-10-13', 'Night', 'N', '22:45:00'),
(2522, 'Employee 9', '23:00:00', b'0', '2019-10-13', 'Late', 'L', '14:30:00'),
(2521, 'Casual', '23:00:00', b'0', '2019-10-13', 'Late', 'L', '14:30:00'),
(2520, 'Employee  3', '21:00:00', b'0', '2019-10-13', 'LC', 'LC', '12:30:00'),
(2518, 'Employee  10', '15:30:00', b'0', '2019-10-13', 'Early', 'E', '07:00:00'),
(2519, 'Employee 1', '21:00:00', b'0', '2019-10-13', 'LC', 'LC', '12:30:00'),
(2517, 'Employee  8', '15:30:00', b'0', '2019-10-13', 'Early', 'E', '07:00:00'),
(2516, 'Employee  6', '07:15:00', b'1', '2019-10-12', 'Night', 'N', '22:45:00'),
(2515, 'Employee  5', '07:15:00', b'1', '2019-10-12', 'Night', 'N', '22:45:00'),
(2514, 'Employee 1', '23:00:00', b'0', '2019-10-12', 'Late', 'L', '14:30:00'),
(2513, 'Employee  3', '23:00:00', b'0', '2019-10-12', 'Late', 'L', '14:30:00'),
(2512, 'Employee 9', '21:00:00', b'0', '2019-10-12', 'LC', 'LC', '12:30:00'),
(2511, 'Employee  8', '21:00:00', b'0', '2019-10-12', 'LC', 'LC', '12:30:00'),
(2510, 'Employee  12', '15:30:00', b'0', '2019-10-12', 'Early', 'E', '07:00:00'),
(2509, 'Employee  2', '15:30:00', b'0', '2019-10-12', 'Early', 'E', '07:00:00'),
(2508, 'Employee  4', '07:15:00', b'1', '2019-10-11', 'Night', 'N', '22:45:00'),
(2506, 'Employee 1', '23:00:00', b'0', '2019-10-11', 'Late', 'L', '14:30:00'),
(2507, 'Employee  7', '07:15:00', b'1', '2019-10-11', 'Night', 'N', '22:45:00'),
(2504, 'Casual 3', '21:00:00', b'0', '2019-10-11', 'LC', 'LC', '12:30:00'),
(2505, 'Employee  5', '23:00:00', b'0', '2019-10-11', 'Late', 'L', '14:30:00'),
(2503, 'Employee  2', '21:00:00', b'0', '2019-10-11', 'LC', 'LC', '12:30:00'),
(2502, 'Employee  6', '24:00:00', b'0', '2019-10-11', 'Leave', 'Leave', '08:00:00'),
(2501, 'Employee  12', '15:30:00', b'0', '2019-10-11', 'Early', 'E', '07:00:00'),
(2500, 'Employee  8', '15:30:00', b'0', '2019-10-11', 'Early', 'E', '07:00:00'),
(2499, 'Employee  3', '15:30:00', b'0', '2019-10-11', 'Early', 'E', '07:00:00'),
(2498, 'Employee  10', '07:15:00', b'1', '2019-10-10', 'Night', 'N', '22:45:00'),
(2495, 'Employee  2', '23:00:00', b'0', '2019-10-10', 'Late', 'L', '14:30:00'),
(2496, 'Employee  4', '23:00:00', b'0', '2019-10-10', 'Late', 'L', '14:30:00'),
(2497, 'Employee  11', '07:15:00', b'1', '2019-10-10', 'Night', 'N', '22:45:00'),
(2494, 'Employee  5', '21:00:00', b'0', '2019-10-10', 'LC', 'LC', '12:30:00'),
(2491, 'Employee  7', '15:30:00', b'0', '2019-10-10', 'Early', 'E', '07:00:00'),
(2492, 'Employee  6', '24:00:00', b'0', '2019-10-10', 'Leave', 'Leave', '08:00:00'),
(2493, 'Employee  8', '21:00:00', b'0', '2019-10-10', 'LC', 'LC', '12:30:00'),
(2490, 'Employee  3', '15:30:00', b'0', '2019-10-10', 'Early', 'E', '07:00:00'),
(2489, 'Employee 9', '07:15:00', b'1', '2019-10-09', 'Night', 'N', '22:45:00'),
(2488, 'Employee  11', '07:15:00', b'1', '2019-10-09', 'Night', 'N', '22:45:00'),
(2487, 'Employee  2', '23:00:00', b'0', '2019-10-09', 'Late', 'L', '14:30:00'),
(2484, 'Employee  4', '21:00:00', b'0', '2019-10-09', 'LC', 'LC', '12:30:00'),
(2485, 'Employee  10', '21:00:00', b'0', '2019-10-09', 'LC', 'LC', '12:30:00'),
(2486, 'Employee  5', '23:00:00', b'0', '2019-10-09', 'Late', 'L', '14:30:00'),
(2483, 'Employee  6', '24:00:00', b'0', '2019-10-09', 'Leave', 'Leave', '08:00:00'),
(2482, 'Employee  3', '15:30:00', b'0', '2019-10-09', 'Early', 'E', '07:00:00'),
(2481, 'Employee  7', '15:30:00', b'0', '2019-10-09', 'Early', 'E', '07:00:00'),
(2480, 'Employee 1', '07:15:00', b'1', '2019-10-08', 'Night', 'N', '22:45:00'),
(2479, 'Employee  12', '07:15:00', b'1', '2019-10-08', 'Night', 'N', '22:45:00'),
(2478, 'Employee 9', '23:00:00', b'0', '2019-10-08', 'Late', 'L', '14:30:00'),
(2477, 'Employee  4', '23:00:00', b'0', '2019-10-08', 'Late', 'L', '14:30:00'),
(2476, 'Employee  7', '21:00:00', b'0', '2019-10-08', 'LC', 'LC', '12:30:00'),
(2475, 'Employee  6', '21:00:00', b'0', '2019-10-08', 'LC', 'LC', '12:30:00'),
(2474, 'Employee  5', '15:30:00', b'0', '2019-10-08', 'Early', 'E', '07:00:00'),
(2473, 'Employee  10', '15:30:00', b'0', '2019-10-08', 'Early', 'E', '07:00:00'),
(2472, 'Employee  8', '07:15:00', b'1', '2019-10-07', 'Night', 'N', '22:45:00'),
(2471, 'Employee 1', '07:15:00', b'1', '2019-10-07', 'Night', 'N', '22:45:00'),
(2470, 'Employee  12', '23:00:00', b'0', '2019-10-07', 'Late', 'L', '14:30:00'),
(2469, 'Employee 9', '23:00:00', b'0', '2019-10-07', 'Late', 'L', '14:30:00'),
(2468, 'Employee  5', '21:00:00', b'0', '2019-10-07', 'LC', 'LC', '12:30:00'),
(2467, 'Employee  7', '21:00:00', b'0', '2019-10-07', 'LC', 'LC', '12:30:00'),
(2466, 'Employee  4', '15:30:00', b'0', '2019-10-07', 'Early', 'E', '07:00:00'),
(2465, 'Employee  6', '15:30:00', b'0', '2019-10-07', 'Early', 'E', '07:00:00'),
(2464, 'Employee  10', '15:30:00', b'0', '2019-10-07', 'Early', 'E', '07:00:00'),
(2580, 'Employee 1', '23:00:00', b'0', '2019-10-20', 'Late', 'L', '14:30:00'),
(2581, 'Employee 9', '07:15:00', b'1', '2019-10-20', 'Night', 'N', '22:45:00'),
(2582, 'Employee  2', '07:15:00', b'1', '2019-10-20', 'Night', 'N', '22:45:00'),
(2583, 'Employee  7', '15:30:00', b'0', '2019-10-21', 'Early', 'E', '07:00:00'),
(2584, 'Employee  5', '15:30:00', b'0', '2019-10-21', 'Early', 'E', '07:00:00'),
(2585, 'Employee  11', '15:30:00', b'0', '2019-10-21', 'Early', 'E', '07:00:00'),
(2586, 'Employee  10', '21:00:00', b'0', '2019-10-21', 'LC', 'LC', '12:30:00'),
(2587, 'Employee  6', '21:00:00', b'0', '2019-10-21', 'LC', 'LC', '12:30:00'),
(2588, 'Employee  12', '23:00:00', b'0', '2019-10-21', 'Late', 'L', '14:30:00'),
(2589, 'Employee  8', '23:00:00', b'0', '2019-10-21', 'Late', 'L', '14:30:00'),
(2590, 'Employee  4', '07:15:00', b'1', '2019-10-21', 'Night', 'N', '22:45:00'),
(2591, 'Employee  3', '07:15:00', b'1', '2019-10-21', 'Night', 'N', '22:45:00'),
(2592, 'Employee  6', '15:30:00', b'0', '2019-10-22', 'Early', 'E', '07:00:00'),
(2593, 'Employee  2', '15:30:00', b'0', '2019-10-22', 'Early', 'E', '07:00:00'),
(2594, 'Employee  5', '21:00:00', b'0', '2019-10-22', 'LC', 'LC', '12:30:00'),
(2595, 'Casual 3', '21:00:00', b'0', '2019-10-22', 'LC', 'LC', '12:30:00'),
(2596, 'Employee  10', '23:00:00', b'0', '2019-10-22', 'Late', 'L', '14:30:00'),
(2597, 'Employee  11', '23:00:00', b'0', '2019-10-22', 'Late', 'L', '14:30:00'),
(2598, 'Employee  12', '07:15:00', b'1', '2019-10-22', 'Night', 'N', '22:45:00'),
(2599, 'Employee  7', '07:15:00', b'1', '2019-10-22', 'Night', 'N', '22:45:00'),
(2600, 'Employee  6', '15:30:00', b'0', '2019-10-23', 'Early', 'E', '07:00:00'),
(2601, 'Employee 9', '15:30:00', b'0', '2019-10-23', 'Early', 'E', '07:00:00'),
(2602, 'Employee  2', '21:00:00', b'0', '2019-10-23', 'LC', 'LC', '12:30:00'),
(2603, 'Employee  10', '21:00:00', b'0', '2019-10-23', 'LC', 'LC', '12:30:00'),
(2604, 'Casual 4', '23:00:00', b'0', '2019-10-23', 'Late', 'L', '14:30:00'),
(2605, 'Casual 3', '23:00:00', b'0', '2019-10-23', 'Late', 'L', '14:30:00'),
(2606, 'Employee  11', '07:15:00', b'1', '2019-10-23', 'Night', 'N', '22:45:00'),
(2607, 'Employee  5', '07:15:00', b'1', '2019-10-23', 'Night', 'N', '22:45:00'),
(2608, 'Employee 9', '15:30:00', b'0', '2019-10-24', 'Early', 'E', '07:00:00'),
(2609, 'Employee  6', '15:30:00', b'0', '2019-10-24', 'Early', 'E', '07:00:00'),
(2610, 'Employee  4', '21:00:00', b'0', '2019-10-24', 'LC', 'LC', '12:30:00'),
(2611, 'Employee  10', '21:00:00', b'0', '2019-10-24', 'LC', 'LC', '12:30:00'),
(2612, 'Employee  3', '23:00:00', b'0', '2019-10-24', 'Late', 'L', '14:30:00'),
(2613, 'Employee  2', '23:00:00', b'0', '2019-10-24', 'Late', 'L', '14:30:00'),
(2614, 'Casual 2', '07:15:00', b'1', '2019-10-24', 'Night', 'N', '22:45:00'),
(2615, 'Employee  8', '07:15:00', b'1', '2019-10-24', 'Night', 'N', '22:45:00'),
(2616, 'Employee  4', '15:30:00', b'0', '2019-10-25', 'Early', 'E', '07:00:00'),
(2617, 'Employee  12', '15:30:00', b'0', '2019-10-25', 'Early', 'E', '07:00:00'),
(2618, 'Employee  6', '15:30:00', b'0', '2019-10-25', 'Early', 'E', '07:00:00'),
(2619, 'Employee  2', '21:00:00', b'0', '2019-10-25', 'LC', 'LC', '12:30:00'),
(2620, 'Employee  3', '21:00:00', b'0', '2019-10-25', 'LC', 'LC', '12:30:00'),
(2621, 'Employee  7', '23:00:00', b'0', '2019-10-25', 'Late', 'L', '14:30:00'),
(2622, 'Employee 9', '23:00:00', b'0', '2019-10-25', 'Late', 'L', '14:30:00'),
(2623, 'Employee  10', '07:15:00', b'1', '2019-10-25', 'Night', 'N', '22:45:00'),
(2624, 'Employee 1', '07:15:00', b'1', '2019-10-25', 'Night', 'N', '22:45:00'),
(2625, 'Employee  2', '15:30:00', b'0', '2019-10-26', 'Early', 'E', '07:00:00'),
(2626, 'Employee  5', '15:30:00', b'0', '2019-10-26', 'Early', 'E', '07:00:00'),
(2627, 'Employee  7', '21:00:00', b'0', '2019-10-26', 'LC', 'LC', '12:30:00'),
(2628, 'Employee  12', '21:00:00', b'0', '2019-10-26', 'LC', 'LC', '12:30:00'),
(2629, 'Employee  3', '23:00:00', b'0', '2019-10-26', 'Late', 'L', '14:30:00'),
(2630, 'Employee  4', '23:00:00', b'0', '2019-10-26', 'Late', 'L', '14:30:00'),
(2631, 'Employee  11', '07:15:00', b'1', '2019-10-26', 'Night', 'N', '22:45:00'),
(2632, 'Employee 9', '07:15:00', b'1', '2019-10-26', 'Night', 'N', '22:45:00'),
(2633, 'Employee  6', '15:30:00', b'0', '2019-10-27', 'Early', 'E', '07:00:00'),
(2634, 'Employee  12', '15:30:00', b'0', '2019-10-27', 'Early', 'E', '07:00:00'),
(2635, 'Employee  3', '21:00:00', b'0', '2019-10-27', 'LC', 'LC', '12:30:00'),
(2636, 'Employee  2', '21:00:00', b'0', '2019-10-27', 'LC', 'LC', '12:30:00'),
(2637, 'Employee  7', '23:00:00', b'0', '2019-10-27', 'Late', 'L', '14:30:00'),
(2638, 'Employee  5', '23:00:00', b'0', '2019-10-27', 'Late', 'L', '14:30:00'),
(2639, 'Employee  8', '07:15:00', b'1', '2019-10-27', 'Night', 'N', '22:45:00'),
(2640, 'Employee  4', '07:15:00', b'1', '2019-10-27', 'Night', 'N', '22:45:00'),
(2641, 'Employee  3', '15:30:00', b'0', '2019-10-28', 'Early', 'E', '07:00:00'),
(2642, 'Casual 4', '15:30:00', b'0', '2019-10-28', 'Early', 'E', '07:00:00'),
(2643, 'Casual', '15:30:00', b'0', '2019-10-28', 'Early', 'E', '07:00:00'),
(2644, 'Employee  12', '21:00:00', b'0', '2019-10-28', 'LC', 'LC', '12:30:00'),
(2645, 'Employee  10', '21:00:00', b'0', '2019-10-28', 'LC', 'LC', '12:30:00'),
(2646, 'Employee  7', '23:00:00', b'0', '2019-10-28', 'Late', 'L', '14:30:00'),
(2647, 'Employee  6', '23:00:00', b'0', '2019-10-28', 'Late', 'L', '14:30:00'),
(2648, 'Employee  5', '07:15:00', b'1', '2019-10-28', 'Night', 'N', '22:45:00'),
(2649, 'Employee 1', '07:15:00', b'1', '2019-10-28', 'Night', 'N', '22:45:00'),
(2650, 'Employee  2', '15:30:00', b'0', '2019-10-29', 'Early', 'E', '07:00:00'),
(2651, 'Employee  10', '15:30:00', b'0', '2019-10-29', 'Early', 'E', '07:00:00'),
(2652, 'Employee  11', '21:00:00', b'0', '2019-10-29', 'LC', 'LC', '12:30:00'),
(2653, 'Employee 9', '21:00:00', b'0', '2019-10-29', 'LC', 'LC', '12:30:00'),
(2654, 'Employee  7', '23:00:00', b'0', '2019-10-29', 'Late', 'L', '14:30:00'),
(2655, 'Employee  12', '23:00:00', b'0', '2019-10-29', 'Late', 'L', '14:30:00'),
(2656, 'Employee  3', '07:15:00', b'1', '2019-10-29', 'Night', 'N', '22:45:00'),
(2657, 'Employee  6', '07:15:00', b'1', '2019-10-29', 'Night', 'N', '22:45:00'),
(2658, 'Employee  4', '15:30:00', b'0', '2019-10-30', 'Early', 'E', '07:00:00'),
(2659, 'Casual 2', '15:30:00', b'0', '2019-10-30', 'Early', 'E', '07:00:00'),
(2660, 'Employee  2', '21:00:00', b'0', '2019-10-30', 'LC', 'LC', '12:30:00'),
(2661, 'Employee 9', '21:00:00', b'0', '2019-10-30', 'LC', 'LC', '12:30:00'),
(2662, 'Employee  12', '23:00:00', b'0', '2019-10-30', 'Late', 'L', '14:30:00'),
(2663, 'Employee  8', '23:00:00', b'0', '2019-10-30', 'Late', 'L', '14:30:00'),
(2664, 'Employee  7', '07:15:00', b'1', '2019-10-30', 'Night', 'N', '22:45:00'),
(2665, 'Employee  10', '07:15:00', b'1', '2019-10-30', 'Night', 'N', '22:45:00'),
(2666, 'Employee 9', '15:30:00', b'0', '2019-10-31', 'Early', 'E', '07:00:00'),
(2667, 'Employee  2', '15:30:00', b'0', '2019-10-31', 'Early', 'E', '07:00:00'),
(2668, 'Employee  8', '21:00:00', b'0', '2019-10-31', 'LC', 'LC', '12:30:00'),
(2669, 'Employee 1', '21:00:00', b'0', '2019-10-31', 'LC', 'LC', '12:30:00'),
(2670, 'Casual 2', '23:00:00', b'0', '2019-10-31', 'Late', 'L', '14:30:00'),
(2671, 'Employee  4', '23:00:00', b'0', '2019-10-31', 'Late', 'L', '14:30:00'),
(2672, 'Employee  5', '07:15:00', b'1', '2019-10-31', 'Night', 'N', '22:45:00'),
(2673, 'Casual 3', '07:15:00', b'1', '2019-10-31', 'Night', 'N', '22:45:00'),
(2674, 'Employee  3', '15:30:00', b'0', '2019-11-01', 'Early', 'E', '07:00:00'),
(2675, 'Employee  6', '15:30:00', b'0', '2019-11-01', 'Early', 'E', '07:00:00'),
(2676, 'Employee 9', '15:30:00', b'0', '2019-11-01', 'Early', 'E', '07:00:00'),
(2677, 'Casual 2', '21:00:00', b'0', '2019-11-01', 'LC', 'LC', '12:30:00'),
(2678, 'Employee  4', '21:00:00', b'0', '2019-11-01', 'LC', 'LC', '12:30:00'),
(2679, 'Casual 3', '23:00:00', b'0', '2019-11-01', 'Late', 'L', '14:30:00'),
(2680, 'Employee  8', '23:00:00', b'0', '2019-11-01', 'Late', 'L', '14:30:00'),
(2681, 'Employee  11', '07:15:00', b'1', '2019-11-01', 'Night', 'N', '22:45:00'),
(2682, 'Employee  2', '07:15:00', b'1', '2019-11-01', 'Night', 'N', '22:45:00'),
(2683, 'Employee  12', '15:30:00', b'0', '2019-11-02', 'Early', 'E', '07:00:00'),
(2684, 'Employee  4', '15:30:00', b'0', '2019-11-02', 'Early', 'E', '07:00:00'),
(2685, 'Employee  3', '21:00:00', b'0', '2019-11-02', 'LC', 'LC', '12:30:00'),
(2686, 'Employee  10', '21:00:00', b'0', '2019-11-02', 'LC', 'LC', '12:30:00'),
(2687, 'Employee 9', '23:00:00', b'0', '2019-11-02', 'Late', 'L', '14:30:00'),
(2688, 'Employee  8', '23:00:00', b'0', '2019-11-02', 'Late', 'L', '14:30:00'),
(2689, 'Employee  7', '07:15:00', b'1', '2019-11-02', 'Night', 'N', '22:45:00'),
(2690, 'Employee  6', '07:15:00', b'1', '2019-11-02', 'Night', 'N', '22:45:00'),
(2691, 'Employee  5', '15:30:00', b'0', '2019-11-03', 'Early', 'E', '07:00:00'),
(2692, 'Employee  10', '15:30:00', b'0', '2019-11-03', 'Early', 'E', '07:00:00'),
(2693, 'Employee  8', '21:00:00', b'0', '2019-11-03', 'LC', 'LC', '12:30:00'),
(2694, 'Employee  3', '21:00:00', b'0', '2019-11-03', 'LC', 'LC', '12:30:00'),
(2695, 'Employee 9', '23:00:00', b'0', '2019-11-03', 'Late', 'L', '14:30:00'),
(2696, 'Employee  4', '23:00:00', b'0', '2019-11-03', 'Late', 'L', '14:30:00'),
(2697, 'Employee  7', '07:15:00', b'1', '2019-11-03', 'Night', 'N', '22:45:00'),
(2698, 'Employee  12', '07:15:00', b'1', '2019-11-03', 'Night', 'N', '22:45:00');

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `weekendDefinition` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`id`, `code`, `description`, `weekendDefinition`) VALUES
(9, '10 Day', '10 Days per Fornight', 0),
(10, '8 Days', '8 Days per Fornight', 0),
(11, '7 Days', '7 Dayds per Fortnight', 0),
(12, '6 Days', '6 DAys per Fortnight', 0),
(14, '4 Days', '4 Days per Fotnight', 0),
(308, 'Casual', 'Casual', 0),
(625, '9 Days', '9 Days per Fortnight', 0),
(649, '5 Days', '5 Days per Fortnight', 0);

-- --------------------------------------------------------

--
-- Table structure for table `contractline`
--

CREATE TABLE `contractline` (
  `DTYPE` varchar(50) NOT NULL,
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
-- Dumping data for table `contractline`
--

INSERT INTO `contractline` (`DTYPE`, `id`, `contractLineType`, `enabled`, `weight`, `maximumEnabled`, `maximumValue`, `maximumWeight`, `minimumEnabled`, `minimumValue`, `minimumWeight`, `contract_id`) VALUES
('MinMaxContractLine', 27, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 10, 10, b'0', 10, 1, 9),
('MinMaxContractLine', 28, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 6, 1, b'1', 2, 1, 9),
('MinMaxContractLine', 29, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 4, 1, b'1', 2, 1, 9),
('MinMaxContractLine', 30, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 9),
('MinMaxContractLine', 31, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 9),
('MinMaxContractLine', 32, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 8, 10, b'0', 8, 1, 10),
('MinMaxContractLine', 33, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 6, 1, b'1', 1, 1, 10),
('MinMaxContractLine', 34, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 6, 1, b'1', 2, 1, 10),
('MinMaxContractLine', 36, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 10),
('MinMaxContractLine', 37, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 10),
('MinMaxContractLine', 38, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 7, 10, b'0', 7, 1, 11),
('MinMaxContractLine', 39, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 6, 1, b'1', 1, 1, 11),
('MinMaxContractLine', 40, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 7, 1, b'1', 2, 1, 11),
('MinMaxContractLine', 41, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 3, 1, b'0', 1, 1, 11),
('MinMaxContractLine', 42, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 3, 1, b'1', 1, 1, 11),
('MinMaxContractLine', 43, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 6, 10, b'0', 6, 1, 12),
('MinMaxContractLine', 44, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 6, 1, b'0', 1, 1, 12),
('MinMaxContractLine', 45, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 8, 1, b'1', 2, 1, 12),
('MinMaxContractLine', 46, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 3, 1, b'0', 1, 1, 12),
('MinMaxContractLine', 47, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 12),
('MinMaxContractLine', 53, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 4, 10, b'0', 1, 1, 14),
('MinMaxContractLine', 54, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 14),
('MinMaxContractLine', 55, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 10, 1, b'1', 2, 1, 14),
('MinMaxContractLine', 56, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'0', 0, 0, 14),
('MinMaxContractLine', 57, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'0', 0, 0, 14),
('BooleanContractLine', 58, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 59, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 60, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 61, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 62, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 63, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 64, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 65, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 66, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 67, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 68, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 69, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 70, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 71, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 72, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 73, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 74, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 75, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 76, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 77, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 78, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 84, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 85, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 86, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 87, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 88, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 250, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 251, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 252, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 255, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('MinMaxContractLine', 309, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'0', 1, 1, b'0', 1, 1, 308),
('MinMaxContractLine', 310, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'0', 5, 1, b'0', 1, 1, 308),
('MinMaxContractLine', 311, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'0', 14, 1, b'0', 1, 1, 308),
('MinMaxContractLine', 312, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'0', 4, 1, b'0', 1, 1, 308),
('MinMaxContractLine', 313, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'0', 4, 1, b'0', 0, 0, 308),
('BooleanContractLine', 314, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('BooleanContractLine', 315, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('BooleanContractLine', 316, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('BooleanContractLine', 318, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('BooleanContractLine', 319, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('BooleanContractLine', 618, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 9),
('BooleanContractLine', 619, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 10),
('BooleanContractLine', 620, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 11),
('BooleanContractLine', 621, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 12),
('BooleanContractLine', 623, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 14),
('BooleanContractLine', 624, 'IS_CASUAL', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 308),
('MinMaxContractLine', 626, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 9, 10, b'0', 0, 0, 625),
('MinMaxContractLine', 627, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 9, 1, b'1', 2, 1, 625),
('MinMaxContractLine', 628, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 5, 1, b'1', 2, 1, 625),
('MinMaxContractLine', 629, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 625),
('MinMaxContractLine', 630, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 625),
('BooleanContractLine', 631, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 632, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 633, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 635, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 636, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 637, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('BooleanContractLine', 638, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 625),
('MinMaxContractLine', 650, 'TOTAL_ASSIGNMENTS', NULL, NULL, b'1', 5, 10, b'0', 1, 1, 649),
('MinMaxContractLine', 651, 'CONSECUTIVE_WORKING_DAYS', NULL, NULL, b'1', 5, 1, b'1', 1, 1, 649),
('MinMaxContractLine', 652, 'CONSECUTIVE_FREE_DAYS', NULL, NULL, b'1', 9, 1, b'1', 2, 1, 649),
('MinMaxContractLine', 653, 'CONSECUTIVE_WORKING_WEEKENDS', NULL, NULL, b'1', 4, 1, b'1', 1, 1, 649),
('MinMaxContractLine', 654, 'TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS', NULL, NULL, b'1', 3, 1, b'1', 1, 1, 649),
('BooleanContractLine', 655, 'SINGLE_ASSIGNMENT_PER_DAY', b'1', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 656, 'COMPLETE_WEEKENDS', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 657, 'IDENTICAL_SHIFT_TYPES_DURING_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 658, 'NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 659, 'ALTERNATIVE_SKILL_CATEGORY', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 660, 'IS_LOADBALANCED', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649),
('BooleanContractLine', 661, 'IS_CASUAL', b'0', 1, NULL, NULL, NULL, NULL, NULL, NULL, 649);

-- --------------------------------------------------------

--
-- Table structure for table `coverrequirements`
--

CREATE TABLE `coverrequirements` (
  `id` bigint(20) NOT NULL,
  `dayOfWeek` int(11) DEFAULT NULL,
  `requiredEmployeesize` int(11) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coverrequirements`
--

INSERT INTO `coverrequirements` (`id`, `dayOfWeek`, `requiredEmployeesize`, `shiftType_id`) VALUES
(146, 0, 3, 2),
(151, 0, 2, 7),
(152, 0, 2, 8),
(153, 1, 2, 2),
(154, 1, 2, 7),
(155, 1, 2, 8),
(156, 2, 2, 2),
(157, 2, 2, 7),
(158, 2, 2, 8),
(159, 3, 2, 2),
(160, 3, 2, 7),
(161, 3, 2, 8),
(163, 4, 2, 7),
(164, 4, 2, 8),
(165, 5, 2, 2),
(166, 5, 2, 7),
(167, 5, 2, 8),
(168, 6, 2, 2),
(169, 6, 2, 7),
(170, 6, 2, 8),
(227, 4, 3, 2),
(304, 2, 2, 6),
(305, 3, 2, 6),
(306, 4, 2, 6),
(323, 0, 2, 6),
(325, 1, 2, 6),
(329, 6, 2, 6),
(330, 5, 2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `dayoffdate`
--

CREATE TABLE `dayoffdate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dayoffrequest`
--

CREATE TABLE `dayoffrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dayondate`
--

CREATE TABLE `dayondate` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dayondate`
--

INSERT INTO `dayondate` (`id`, `date`, `weight`, `employee_id`) VALUES
(2820, '2019-10-23', 1, 122);

-- --------------------------------------------------------

--
-- Table structure for table `dayonrequest`
--

CREATE TABLE `dayonrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `code`, `contactdetails`, `employeeId`, `name`, `postcode`, `streetnum`, `suburb`, `contract_id`) VALUES
(122, '', '102815', '', '102815', 'Employee 1', '', '', '', 9),
(124, '', '169910', '', '169910', 'Employee  2', '', '', '', 9),
(126, '', '170759', '', '170759', 'Employee  3', '', '', '', 9),
(128, '', '067501', '', '067501', 'Employee  4', '', '', '', 9),
(130, '', '273540', '', '273540', 'Employee  5', '', '', '', 10),
(132, '', '391700', '', '391700', 'Employee  6', '', '', '', 9),
(134, '', '171804', '', '171804', 'Employee  7', '', '', '', 9),
(136, '', '263467', '', '263467', 'Employee  8', '', '', '', 10),
(138, '', '330696', '', '330696', 'Employee 9', '', '', '', 9),
(140, '', '312480', '', '312480', 'Employee  10', '', '', '', 9),
(142, '', '273577', '', '273577', 'Employee  11', '', '', '', 12),
(144, '', '289920', '', '289920', 'Employee  12', '', '', '', 9),
(1297, '', 'Casual', '', 'Casual', 'Casual', '', '', '', 308),
(1299, '', 'Casual 2', '', 'Casual 2', 'Casual 2', '', '', '', 308),
(1300, '', 'Casual 3', '', 'Casual 3', 'Casual 3', '', '', '', 308),
(1301, '', 'Casual 4', '', 'Casual 4', 'Casual 4', '', '', '', 308),
(2701, '', 'Casual 5', '', 'Casual 5', 'Casual 5', '', '', '', 308);

-- --------------------------------------------------------

--
-- Table structure for table `employee_dayoffrequest`
--

CREATE TABLE `employee_dayoffrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_dayonrequest`
--

CREATE TABLE `employee_dayonrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `dayOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_holidayrequest`
--

CREATE TABLE `employee_holidayrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `holidayRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_leaverequest`
--

CREATE TABLE `employee_leaverequest` (
  `Employee_id` bigint(20) NOT NULL,
  `leaveMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_rosterday`
--

CREATE TABLE `employee_rosterday` (
  `Employee_id` bigint(20) NOT NULL,
  `rosterdayMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_shiftoffrequest`
--

CREATE TABLE `employee_shiftoffrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOffRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_shiftonrequest`
--

CREATE TABLE `employee_shiftonrequest` (
  `Employee_id` bigint(20) NOT NULL,
  `shiftOnRequestMap_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_trainingrequest`
--

CREATE TABLE `employee_trainingrequest` (
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
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821),
(2821);

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leavedata`
--

INSERT INTO `leavedata` (`id`, `enddate`, `startdate`, `weight`, `employee_id`, `shift_id`, `shiftType_id`) VALUES
(2344, '2019-10-11', '2019-10-09', 0, 132, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `leaverequest`
--

CREATE TABLE `leaverequest` (
  `id` bigint(20) NOT NULL,
  `endshiftDate` tinyblob,
  `startshiftDate` tinyblob,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `endshiftDate_id` bigint(20) DEFAULT NULL,
  `startshiftDate_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pattern`
--

CREATE TABLE `pattern` (
  `DTYPE` varchar(50) NOT NULL,
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pattern`
--

INSERT INTO `pattern` (`DTYPE`, `id`, `code`, `weight`, `freeDayOfWeek`, `freeDayLength`, `workDayOfWeek`, `workShiftType_id`, `dayIndex0ShiftType_id`, `dayIndex1ShiftType_id`, `dayIndex2ShiftType_id`) VALUES
('ShiftType2DaysPattern', 2744, 'NEH', 1, NULL, NULL, NULL, NULL, 8, 517, NULL),
('ShiftType3DaysPattern', 2783, 'NEN', 1, NULL, NULL, NULL, NULL, 8, 2, 8),
('ShiftType2DaysPattern', 2739, 'NL', 1, NULL, NULL, NULL, NULL, 8, 7, NULL),
('ShiftType2DaysPattern', 2740, 'NEG', 1, NULL, NULL, NULL, NULL, 8, 516, NULL),
('ShiftType2DaysPattern', 2737, 'NWLC', 1, NULL, NULL, NULL, NULL, 8, 5, NULL),
('ShiftType2DaysPattern', 2738, 'NLC', 1, NULL, NULL, NULL, NULL, 8, 6, NULL),
('ShiftType2DaysPattern', 2728, 'NE', 1, NULL, NULL, NULL, NULL, 8, 2, NULL),
('ShiftType2DaysPattern', 2729, 'NADO', 1, NULL, NULL, NULL, NULL, 8, 3, NULL),
('ShiftType2DaysPattern', 2730, 'NLEAVE', 1, NULL, NULL, NULL, NULL, 8, 4, NULL),
('WorkBeforeFreeSequencePattern', 2784, 'wb', 1, NULL, 2, NULL, 8, NULL, NULL, NULL),
('FreeBefore2DaysWithAWorkDayPattern', 2785, 'fb', 1, 4, NULL, NULL, NULL, NULL, NULL, NULL),
('ShiftType2DaysPattern', 2791, 'LE', 1, NULL, NULL, NULL, NULL, 7, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patterncontractline`
--

CREATE TABLE `patterncontractline` (
  `id` bigint(20) NOT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `pattern_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patterncontractline`
--

INSERT INTO `patterncontractline` (`id`, `contract_id`, `pattern_id`) VALUES
(2803, 14, 2728),
(2776, 12, 2740),
(2732, 9, 2729),
(2775, 12, 2739),
(2731, 9, 2728),
(2774, 12, 2744),
(2733, 9, 2730),
(2773, 11, 2730),
(2745, 9, 2744),
(2772, 11, 2729),
(2802, 14, 2738),
(2801, 14, 2737),
(2795, 12, 2791),
(2797, 14, 2744),
(2800, 14, 2740),
(2767, 11, 2739),
(2756, 625, 2729),
(2746, 9, 2739),
(2786, 9, 2785),
(2794, 11, 2791),
(2765, 10, 2730),
(2757, 625, 2730),
(2749, 9, 2738),
(2777, 12, 2737),
(2788, 11, 2785),
(2763, 10, 2728),
(2758, 10, 2744),
(2750, 625, 2744),
(2778, 12, 2738),
(2789, 12, 2785),
(2764, 10, 2729),
(2759, 10, 2739),
(2751, 625, 2739),
(2779, 12, 2728),
(2790, 625, 2785),
(2766, 11, 2744),
(2760, 10, 2740),
(2752, 625, 2740),
(2780, 12, 2729),
(2792, 9, 2791),
(2796, 625, 2791),
(2748, 9, 2737),
(2771, 11, 2728),
(2769, 11, 2737),
(2799, 14, 2739),
(2762, 10, 2738),
(2761, 10, 2737),
(2753, 625, 2737),
(2781, 12, 2729),
(2793, 10, 2791),
(2747, 9, 2740),
(2770, 11, 2738),
(2798, 14, 2783),
(2768, 11, 2740),
(2755, 625, 2728),
(2754, 625, 2738),
(2782, 12, 2730),
(2787, 10, 2785),
(2804, 14, 2729),
(2805, 14, 2730),
(2806, 14, 2785),
(2807, 14, 2791),
(2808, 649, 2744),
(2809, 649, 2783),
(2810, 649, 2739),
(2811, 649, 2740),
(2812, 649, 2737),
(2813, 649, 2738),
(2814, 649, 2728),
(2815, 649, 2729),
(2816, 649, 2730),
(2817, 649, 2785),
(2818, 649, 2791),
(2819, 308, 2728);

-- --------------------------------------------------------

--
-- Table structure for table `rosterday`
--

CREATE TABLE `rosterday` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shiftDate_id` bigint(20) DEFAULT NULL,
  `workShiftType_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rosterparametrization`
--

CREATE TABLE `rosterparametrization` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rosterparametrization`
--

INSERT INTO `rosterparametrization` (`id`, `code`, `endDate`, `startDate`) VALUES
(0, 'Becs', '2019-10-20', '2019-10-07');

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shiftoffrequest`
--

CREATE TABLE `shiftoffrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shiftonrequest`
--

CREATE TABLE `shiftonrequest` (
  `id` bigint(20) NOT NULL,
  `weight` int(11) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shifttype`
--

INSERT INTO `shifttype` (`id`, `code`, `description`, `endTimeString`, `Shift_index`, `night`, `startTimeString`) VALUES
(2, 'E', 'Early', '15:30:00', 0, b'0', '07:00:00'),
(3, 'ADO', 'ADO', '24:00:00', 0, b'0', '08:30:00'),
(4, 'Leave', 'Leave', '24:00:00', 0, b'0', '08:00:00'),
(5, 'WLC', 'WLC', '19:30:00', 0, b'0', '11:00:00'),
(6, 'LC', 'LC', '21:00:00', 0, b'0', '12:30:00'),
(7, 'L', 'Late', '23:00:00', 0, b'0', '14:30:00'),
(516, 'EG', 'EG', '17:00:00', 0, b'0', '08:30:00'),
(517, 'EH', 'EH', '18:30:00', 0, b'0', '10:00:00'),
(8, 'N', 'Night', '07:15:00', 0, b'1', '23:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `shifttypeskillrequirement`
--

CREATE TABLE `shifttypeskillrequirement` (
  `id` bigint(20) NOT NULL,
  `shiftType_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shifttypeskillrequirement`
--

INSERT INTO `shifttypeskillrequirement` (`id`, `shiftType_id`, `skill_id`) VALUES
(20, 2, 1),
(21, 3, 1),
(22, 4, 1),
(23, 5, 1),
(24, 6, 1),
(25, 7, 1),
(26, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`id`, `code`) VALUES
(1, 'HP3'),
(307, 'Casual');

-- --------------------------------------------------------

--
-- Table structure for table `skillproficiency`
--

CREATE TABLE `skillproficiency` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `skill_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skillproficiency`
--

INSERT INTO `skillproficiency` (`id`, `employee_id`, `skill_id`) VALUES
(123, 122, 1),
(125, 124, 1),
(127, 126, 1),
(129, 128, 1),
(131, 130, 1),
(133, 132, 1),
(135, 134, 1),
(137, 136, 1),
(139, 138, 1),
(141, 140, 1),
(143, 142, 1),
(145, 144, 1),
(1298, 1297, 307),
(1302, 1299, 307),
(1303, 1300, 307),
(1304, 1301, 307),
(2702, 2701, 307);

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  ADD KEY `FKqhsqwxxq1td3l6ds8hwx22b1n` (`shift_id`),
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
  ADD KEY `FKcrima64sn9ja1lchdnk9ibn1x` (`workShiftType_id`),
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
-- Indexes for table `rosterparametrization`
--
ALTER TABLE `rosterparametrization`
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
