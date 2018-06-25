-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 24, 2018 at 08:04 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3
CREATE database stockexchange;
USE stockexchange;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stockexchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `id` int(11) NOT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `balance` bigint(20) DEFAULT NULL,
  `profit` int(11) NOT NULL,
  `turns` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `account_name`, `balance`, `profit`, `turns`) VALUES
(4, 'John', 1033, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `broker`
--

CREATE TABLE `broker` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `broker`
--

INSERT INTO `broker` (`id`, `username`) VALUES
(1, 'LittleFinger'),
(2, 'LordVarys'),
(3, 'Bronn');

-- --------------------------------------------------------

--
-- Table structure for table `broker_customer`
--

CREATE TABLE `broker_customer` (
  `id` int(11) NOT NULL,
  `broker_name` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `price_bought` int(11) NOT NULL,
  `price_sell` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `stocks` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `broker_stocks`
--

CREATE TABLE `broker_stocks` (
  `id` int(11) NOT NULL,
  `broker_name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `stock` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `broker_stocks`
--

INSERT INTO `broker_stocks` (`id`, `broker_name`, `price`, `quantity`, `stock`) VALUES
(1, 'LittleFinger', 100, 10000, 'google'),
(2, 'LordVarys', 100, 10000, 'amazon'),
(3, 'Bronn', 100, 10000, 'hooli'),
(4, 'LittleFinger', 100, 10000, 'apple'),
(5, 'LordVarys', 100, 10000, 'stark'),
(6, 'Bronn', 100, 10000, 'wayne'),
(7, 'LittleFinger', 100, 10000, 'wb'),
(8, 'LordVarys', 100, 10000, 'delos'),
(9, 'Bronn', 100, 10000, 'fox'),
(10, 'LittleFinger', 100, 10000, 'nasa'),
(11, 'LordVarys', 100, 10000, 'fedex'),
(12, 'Bronn', 100, 10000, 'dhl'),
(13, 'LittleFinger', 100, 10000, 'sony'),
(14, 'LordVarys', 100, 10000, 'jvc'),
(15, 'Bronn', 100, 10000, 'oracle'),
(16, 'LittleFinger', 100, 10000, 'rk'),
(17, 'LordVarys', 100, 10000, 'dk'),
(18, 'Bronn', 100, 10000, 'yahoo'),
(19, 'LittleFinger', 100, 10000, 'ifs'),
(20, 'LordVarys', 100, 10000, 'ebay');

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
(7),
(7),
(7),
(7),
(7),
(7);

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

CREATE TABLE `stocks` (
  `id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stock_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`id`, `price`, `qty`, `sector`, `stock_name`) VALUES
(1, 100, 10000, 'GOV0', 'google'),
(2, 100, 10000, 'GOV-1', 'amazon'),
(3, 100, 10000, 'GOV-2', 'hooli'),
(4, 100, 10000, 'GOV-3', 'apple'),
(5, 100, 10000, 'GOV-4', 'stark'),
(6, 100, 10000, 'GOV-5', 'wayne'),
(7, 100, 10000, 'GOV-6', 'wb'),
(8, 100, 10000, 'GOV-7', 'delos'),
(9, 100, 10000, 'GOV-8', 'fox'),
(10, 100, 10000, 'GOV-9', 'nasa'),
(11, 100, 10000, 'GOV-10', 'fedex'),
(12, 100, 10000, 'GOV-11', 'dhl'),
(13, 100, 10000, 'GOV-12', 'sony'),
(14, 100, 10000, 'GOV-13', 'jvc'),
(15, 100, 10000, 'GOV-14', 'oracle'),
(16, 100, 10000, 'GOV-15', 'rk'),
(17, 100, 10000, 'GOV-16', 'dk'),
(18, 100, 10000, 'GOV-17', 'yahoo'),
(19, 100, 10000, 'GOV-18', 'ifs'),
(20, 100, 10000, 'GOV-19', 'ebay');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `username`) VALUES
(1, 'Newuser@tet.com', 'abc', 'Iroshan'),
(3, 'ai1@st.com', 'AI1', 'John');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6mf3l1yqbskqubb1qv1i5fmhq` (`account_name`);

--
-- Indexes for table `broker`
--
ALTER TABLE `broker`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ir7m48sd33uogfacuhlut9rc8` (`username`);

--
-- Indexes for table `broker_customer`
--
ALTER TABLE `broker_customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `broker_stocks`
--
ALTER TABLE `broker_stocks`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ktnyvtdcuwrhfs2jxukwdsm89` (`stock`);

--
-- Indexes for table `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_pq0ii5jhrwhuxsqlio7dbc66s` (`stock_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
