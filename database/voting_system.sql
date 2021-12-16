-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 16, 2021 at 03:20 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `block`
--

CREATE TABLE `block` (
  `BlockID` bigint(20) NOT NULL,
  `prevBlockID` bigint(20) DEFAULT NULL,
  `voterID` bigint(20) NOT NULL,
  `candidate` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `messageHash` varchar(255) NOT NULL,
  `messagePrevHash` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `block`
--

INSERT INTO `block` (`BlockID`, `prevBlockID`, `voterID`, `candidate`, `created_at`, `messageHash`, `messagePrevHash`) VALUES
(45, NULL, 2, 0, '2021-12-16 09:49:18', '5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9', NULL),
(52, 45, 10, 2, '2021-12-16 11:18:49', '5122a1d1bc9d87662dcf5fb870adf8c55faf2ce12fad1bacac2fe7df88172466', '5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9'),
(53, 52, 3, 2, '2021-12-16 11:19:10', '3c857ab8e3936f0f125a97a86262fd3d1cd906f4b7acf1df385f1756f7f692b2', '5122a1d1bc9d87662dcf5fb870adf8c55faf2ce12fad1bacac2fe7df88172466'),
(54, 53, 4, 0, '2021-12-16 11:19:29', '3806743a62ad600a453105090db2884c747600ad27576f4e6ba18f2f56cc445b', '3c857ab8e3936f0f125a97a86262fd3d1cd906f4b7acf1df385f1756f7f692b2');

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE `candidate` (
  `id` int(11) NOT NULL,
  `student_id` varchar(8) NOT NULL,
  `name` varchar(255) NOT NULL,
  `policy` varchar(255) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`id`, `student_id`, `name`, `policy`, `create_at`) VALUES
(1, '64070001', 'สุชัชวีร์ สุวรรณสวัสดิ์', 'ผมจบ MIT', '2021-12-16 09:27:57'),
(2, '64070002', 'ชัชชาติ สิทธิพันธุ์', 'ชายที่แข็งแกร่งที่สุดในแผ่นดิน', '2021-12-16 09:28:42'),
(3, '64070003', 'ประยุทธ์ จันทร์โอชา', 'สนับสนุนเลี้ยงไก่ 2 ตัวต่อบ้าน', '2021-12-16 09:29:13'),
(4, '64070004', 'จัสติน บีเบอร์', 'สนับสนุนการปั่นจักรยาน', '2021-12-16 09:29:51'),
(5, '64070005', 'มงคล มีชัย', 'ขายฝัน', '2021-12-16 10:39:04'),
(6, '64070006', 'นายมีชัย มั่งมี', 'ทำดี', '2021-12-16 11:16:47');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE `setting` (
  `id` int(11) NOT NULL,
  `voting_time` time NOT NULL,
  `update_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`id`, `voting_time`, `update_at`) VALUES
(1, '01:00:00', '2021-12-16 08:17:08');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `isAdmin` tinyint(1) DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `student_id`, `password`, `fullName`, `isAdmin`, `created_at`) VALUES
(2, 1, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Admin', 1, '2021-12-16 09:25:19'),
(3, 63070121, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Pisitchai Rueangwatanaphong', 0, '2021-12-16 09:26:06'),
(4, 63070156, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Wannasa Chonchoochart', 0, '2021-12-16 09:26:22'),
(5, 63070138, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Puriwat Udompittayasit', 0, '2021-12-16 09:26:43'),
(10, 63070169, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Suphachai Chuensooksri', 0, '2021-12-16 11:17:47'),
(11, 63070183, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'Apichet Komwatcharapong', 0, '2021-12-16 13:49:14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `block`
--
ALTER TABLE `block`
  ADD PRIMARY KEY (`BlockID`),
  ADD KEY `voterID` (`voterID`),
  ADD KEY `prevBlockID` (`prevBlockID`);

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `setting`
--
ALTER TABLE `setting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_id` (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `block`
--
ALTER TABLE `block`
  MODIFY `BlockID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `setting`
--
ALTER TABLE `setting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `block`
--
ALTER TABLE `block`
  ADD CONSTRAINT `prevBlockID` FOREIGN KEY (`prevBlockID`) REFERENCES `block` (`BlockID`) ON DELETE CASCADE,
  ADD CONSTRAINT `voterID` FOREIGN KEY (`voterID`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
