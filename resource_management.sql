-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2021 at 04:28 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resource_management`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `multi_query` ()  BEGIN
   INSERT INTO employee (name,gender,birth_date,email,jabatan) VALUES ('Willi','Laki-laki','1997-03-01','willi@gmail.com','Developer');
SET @emp_id = LAST_INSERT_ID();

INSERT INTO skill(skill_id, label) SELECT skill_id, 'Java' FROM skill WHERE label = 'Java';
SET @skill_id = LAST_INSERT_ID();

INSERT INTO emp_skill (emp_id,skill_id) VALUES(@emp_id, @skill_id);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_id` int(10) NOT NULL,
  `client_name` varchar(50) NOT NULL,
  `instansi` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `industry_type` varchar(50) NOT NULL,
  `location` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_id`, `client_name`, `instansi`, `email`, `industry_type`, `location`) VALUES
(1, 'Andi', 'BNI', 'bnicall@bni.co.id', 'Financial', 'Jakarta'),
(2, 'Budi', 'BCA', 'halobca@bca.co.id', 'Financial', 'Jakarta'),
(3, 'Charlie', 'PERTAMINA', 'pcc135@pertamina.com', 'Oil & Gas', 'Jawa Barat'),
(4, 'Dodi', 'COCA-COLA', 'ncc@sea.ccamatil.com', 'Beverage', 'Bekasi'),
(5, 'Even', 'SILOAM', 'corporate.secretary@siloamhospital.com.', 'Hospital', 'Jakarta'),
(6, 'Fafa', 'INDOSAT', 'cs@indosatooredoo.com', 'Telecommunications', 'Jakarta'),
(7, 'Ghigha', 'KIMIA FARMA', 'corsec@kimiafarma.co.id', 'Health Care', 'Jakarta'),
(8, 'Harry', 'PINDAD', 'info@pindad.com', 'Industrial', 'Bandung'),
(9, 'Ikhsan', 'SUSI AIR', 'info@susiair.com', 'Consumer Service', 'Tangerang'),
(10, 'Jerry', 'UNILEVER', 'unvr.indonesia@unilever.com', 'Consumer Good', 'Tangerang'),
(11, 'Kelvin', 'MANDIRI', 'mandiricare@bankmandiri.co.id', 'Bank', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `gender` enum('Laki-laki','Perempuan') NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `jabatan` enum('Developer','RM') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `name`, `gender`, `birth_date`, `email`, `jabatan`) VALUES
(1, 'Arnum Sari', 'Perempuan', '1997-12-28', 'arnumsari17@gmail.com', 'Developer'),
(2, 'William Yangjaya', 'Laki-laki', '1997-03-01', 'william.yangjaya@ms.mii.co.id', 'Developer'),
(3, 'Fadel Muhammad Nasution', 'Laki-laki', '1992-02-29', 'fadelmn21@gmail.com', 'Developer'),
(4, 'Rafi Mufadhal Difany', 'Laki-laki', '1998-05-08', 'rafimdifany@gmail.com', 'Developer'),
(5, 'Christina Regita Kumala Sari', 'Perempuan', '1997-04-24', 'christinaregita24@gmail.com', 'Developer'),
(6, 'Yosie Fridolin', 'Perempuan', '1998-06-01', 'yosiefridolin01@gmail.com', 'RM'),
(7, 'Jaka Brajadenta', 'Laki-laki', '1998-04-04', 'jakabrajadenta@gmail.com', 'Developer'),
(8, 'Florentina Vela Nindyasari', 'Perempuan', '1998-07-20', 'florentinavela.n@gmail.com', 'Developer'),
(9, 'Jarister Edwins Silalahi', 'Laki-laki', '1998-03-25', 'jarister.silalahi@ms.mii.co.id', 'Developer'),
(10, 'Zahra Zakiyah Salsabila Kurnia', 'Perempuan', '1997-09-27', 'zahrazakiyahsk@gmail.com', 'Developer'),
(11, 'Welly', 'Laki-laki', '2021-04-27', 'welly@gmail.com', 'Developer');

-- --------------------------------------------------------

--
-- Table structure for table `emp_skill`
--

CREATE TABLE `emp_skill` (
  `empskill_id` int(10) NOT NULL,
  `emp_id` int(10) NOT NULL,
  `skill_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_skill`
--

INSERT INTO `emp_skill` (`empskill_id`, `emp_id`, `skill_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(4, 2, 3),
(3, 2, 4),
(5, 3, 5),
(6, 3, 6),
(7, 4, 7),
(8, 4, 8),
(9, 5, 9),
(10, 5, 10),
(11, 7, 1),
(12, 7, 5),
(13, 8, 7),
(14, 8, 8),
(15, 9, 1),
(16, 9, 9),
(17, 10, 3),
(18, 10, 4),
(19, 11, 1),
(20, 11, 2);

--
-- Triggers `emp_skill`
--
DELIMITER $$
CREATE TRIGGER `emp_skill_new` AFTER INSERT ON `emp_skill` FOR EACH ROW update skill s set s.count = s.count + 1
where s.skill_id IN (select es.skill_id from emp_skill es where es.emp_id = NEW.emp_id)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `interview`
--

CREATE TABLE `interview` (
  `interview_id` int(10) NOT NULL,
  `emp_id` int(10) NOT NULL,
  `client_id` int(10) NOT NULL,
  `interview_date` datetime NOT NULL,
  `result_date` date DEFAULT NULL,
  `result` enum('ACCEPT','REJECT','IN REVIEW') NOT NULL DEFAULT 'IN REVIEW',
  `status` enum('PROCESS','CANCEL') NOT NULL DEFAULT 'PROCESS',
  `interview_via` enum('ONLINE','OFFLINE') NOT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `interview`
--

INSERT INTO `interview` (`interview_id`, `emp_id`, `client_id`, `interview_date`, `result_date`, `result`, `status`, `interview_via`, `note`) VALUES
(1, 1, 1, '2021-05-05 07:00:00', '2021-05-27', 'REJECT', 'PROCESS', 'ONLINE', ''),
(2, 2, 2, '2021-05-05 07:00:00', '2021-05-27', 'REJECT', 'PROCESS', 'ONLINE', ''),
(3, 3, 3, '2021-05-02 07:00:00', '2021-05-27', 'REJECT', 'PROCESS', 'ONLINE', ''),
(4, 4, 4, '2021-05-02 07:00:00', NULL, 'IN REVIEW', 'PROCESS', 'ONLINE', ''),
(5, 5, 5, '2021-05-02 07:00:00', NULL, 'IN REVIEW', 'PROCESS', 'ONLINE', ''),
(7, 7, 7, '2021-05-02 07:00:00', NULL, 'IN REVIEW', 'PROCESS', 'OFFLINE', ''),
(8, 8, 8, '2021-05-02 07:00:00', '2021-05-27', 'ACCEPT', 'PROCESS', 'OFFLINE', ''),
(9, 9, 9, '2021-05-02 07:00:00', '2021-05-27', 'ACCEPT', 'PROCESS', 'OFFLINE', ''),
(10, 10, 10, '2021-05-02 07:00:00', '2021-05-20', 'ACCEPT', 'PROCESS', 'OFFLINE', ''),
(11, 11, 11, '2021-05-06 07:00:00', '2021-05-20', 'ACCEPT', 'PROCESS', 'OFFLINE', '');

-- --------------------------------------------------------

--
-- Table structure for table `privilege`
--

CREATE TABLE `privilege` (
  `privilege_id` int(10) NOT NULL,
  `privilege_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `privilege`
--

INSERT INTO `privilege` (`privilege_id`, `privilege_name`) VALUES
(1, 'CREATE'),
(2, 'READ'),
(3, 'UPDATE'),
(4, 'DELETE');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(10) NOT NULL,
  `role_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'DEVELOPER'),
(2, 'RM');

-- --------------------------------------------------------

--
-- Table structure for table `role_privilege`
--

CREATE TABLE `role_privilege` (
  `role_id` int(10) NOT NULL,
  `privilege_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_privilege`
--

INSERT INTO `role_privilege` (`role_id`, `privilege_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `skill_id` int(10) NOT NULL,
  `label` varchar(50) NOT NULL,
  `count` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`skill_id`, `label`, `count`) VALUES
(1, 'Java', 11),
(2, 'NET', 4),
(3, 'JavaScript', 3),
(4, 'Python', 6),
(5, 'Go', 3),
(6, 'C++', 1),
(7, 'R', 3),
(8, 'PHP', 2),
(9, 'HTML', 3),
(10, 'Ruby', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`) VALUES
(1, 'arnum', '$2y$10$oDJEuX5SiGf.RzYAIGzGvupWGbB1PxFSdiYw28pEejd/IkJ.4W9My'),
(2, 'william', '$2y$10$ZKmTdq/qw8iVvsLfW.mow.MA.N8mqWSKRm.6EHEUS/JG4rTsAwuUW'),
(3, 'fadel', '$2y$10$X/zHXYM6aOYVxnExp1fXJuGPkCqEetaSsTpCXex9lGFti4aHnQYs2'),
(4, 'rafi', '$2y$10$GYWQ6NZu0igUbG6VTLtX2e1HhJi1P3c3Cfhv2AX9l.RnlJsnkr6bm'),
(5, 'regita', '$2y$10$fh3NwgnwFkuyA5ePKq3bEOhaMgPwsboQQbLibMqCh9DKL4xaHdaNa'),
(6, 'yosie', '$2y$10$6IERj5K4evQ/Sju744pGz.xLeeHcgtlAYqJ7zdTtv9kjj92Ap/Z4u'),
(7, 'jaka', '$2y$10$1a0UYa3tYzHtn/2qOgEhKudbUuhzVkQ2ou/R9cL8NCZgrUe.oB.UG'),
(8, 'vela', '$2y$10$aPLHx0GKpcZGTuRgrRsgA.0dHeHVATxoJuEYvvpEDYZqWDO2wqDfW'),
(9, 'edwin', '$2y$10$xcj3pdoQzaOtCunibABcW.7XY9OVgG/KRtKFp7pBIp5/YPUlIjlTi'),
(10, 'zakiyah', '$2y$10$2HLg9rWoaQJr5bckoMykhuntztM7PfGKqqesLwvkQERsDEb0cUQSu');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 1),
(8, 1),
(9, 1),
(10, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `emp_skill`
--
ALTER TABLE `emp_skill`
  ADD PRIMARY KEY (`empskill_id`),
  ADD UNIQUE KEY `uq_emp_skill` (`emp_id`,`skill_id`),
  ADD KEY `FK_skill_id_skill` (`skill_id`),
  ADD KEY `FK_emp_id_emp` (`emp_id`) USING BTREE;

--
-- Indexes for table `interview`
--
ALTER TABLE `interview`
  ADD PRIMARY KEY (`interview_id`),
  ADD KEY `FK_emp_id_employee` (`emp_id`),
  ADD KEY `FK_client_id_client` (`client_id`);

--
-- Indexes for table `privilege`
--
ALTER TABLE `privilege`
  ADD PRIMARY KEY (`privilege_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD KEY `role_id` (`role_id`),
  ADD KEY `privilege_id` (`privilege_id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`skill_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `emp_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `emp_skill`
--
ALTER TABLE `emp_skill`
  MODIFY `empskill_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `interview`
--
ALTER TABLE `interview`
  MODIFY `interview_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emp_skill`
--
ALTER TABLE `emp_skill`
  ADD CONSTRAINT `FK_skill_id_skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`),
  ADD CONSTRAINT `emp_skill_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `interview`
--
ALTER TABLE `interview`
  ADD CONSTRAINT `FK_client_id_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  ADD CONSTRAINT `FK_emp_id_employee` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD CONSTRAINT `FK_privilege_privilege_id` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`privilege_id`),
  ADD CONSTRAINT `FK_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_uid_fk` FOREIGN KEY (`user_id`) REFERENCES `employee` (`emp_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_role_id_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `FK_user_id_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `result_change` ON SCHEDULE EVERY 1 MONTH STARTS '2021-04-30 09:14:21' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE resource_management.interview SET result = 'REJECT'
   WHERE result_date IS NULL$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
