-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2026 at 02:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_shoppingcart`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_alamat`
--

CREATE TABLE `tbl_alamat` (
  `id_alamat` bigint(20) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_alamat`
--

INSERT INTO `tbl_alamat` (`id_alamat`, `alamat`, `user_id`) VALUES
(3, 'Dormitory Atma Jaya', 8),
(7, 'Vila Nusa Indah 3', 8),
(14, 'Atma Jaya', 8),
(15, 'rumah gw', 8),
(16, 'White House', 8),
(17, 'Atma Jaya Semanggi', 22),
(18, 'kalimantan barat', 24),
(19, 'dormitory atma jaya bsd', 24),
(20, 'Bekasi', 24),
(21, 'planet', 8),
(22, 'rumah iell', 8),
(23, 'dormitory', 27),
(24, 'atma jaya', 27);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cart`
--

CREATE TABLE `tbl_cart` (
  `cart_id` bigint(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `totalHargaItem` double NOT NULL,
  `user_id` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_cart`
--

INSERT INTO `tbl_cart` (`cart_id`, `nama`, `jumlah`, `harga`, `totalHargaItem`, `user_id`) VALUES
(209, 'Ortuseight Hyperblast', 3, 584565, 1753695, 8),
(210, 'Vintage Cherry Red Fall Flats', 1, 487000, 487000, 8),
(211, 'Sappun Erino Enamel Ribbon', 1, 770000, 770000, 8);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_history`
--

CREATE TABLE `tbl_history` (
  `id_history` bigint(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `totalHargaItem` double NOT NULL,
  `totalHargaCart` double NOT NULL,
  `tanggal_transaksi` datetime NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `promo` varchar(30) NOT NULL,
  `kurir` varchar(30) NOT NULL,
  `metodePembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_history`
--

INSERT INTO `tbl_history` (`id_history`, `nama`, `jumlah`, `harga`, `totalHargaItem`, `totalHargaCart`, `tanggal_transaksi`, `alamat`, `user_id`, `promo`, `kurir`, `metodePembayaran`) VALUES
(44, 'Ortuseight Hyperblast', 1, 584565, 584565, 315282.5, '2026-01-02 23:01:48', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'Gopay'),
(45, 'Fonte White', 2, 183600, 367200, 2868300, '2026-01-03 10:19:20', 'Vila Nusa Indah 3', 8, 'Diskon 10%', 'JPX', 'QRIS'),
(46, 'Sepatu Kulit Harry Lambert', 1, 1999900, 1999900, 2868300, '2026-01-03 10:19:20', 'Vila Nusa Indah 3', 8, 'Diskon 10%', 'JPX', 'QRIS'),
(47, 'Mokasin Formal', 1, 799900, 799900, 2868300, '2026-01-03 10:19:20', 'Vila Nusa Indah 3', 8, 'Diskon 10%', 'JPX', 'QRIS'),
(48, 'Mokasin Formal', 1, 799900, 799900, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(49, 'Ortuseight Hyperblast', 1, 584565, 584565, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(50, 'Kenzo Run', 1, 518420, 518420, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(51, 'Brooks Ghost 16', 1, 1399000, 1399000, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(52, 'XPREME', 1, 170499, 170499, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(53, 'Sepatu Kulit Harry Lambert', 2, 1999900, 3999800, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(54, 'Sepatu Kulit Dua Gesper', 1, 1999000, 1999000, 9471184, '2026-01-03 14:41:55', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'Si Cepat', 'COD'),
(55, 'Sappun Erino Enamel Ribbon', 1, 770000, 770000, 3695500, '2026-01-03 16:36:55', 'Dormitory Atma Jaya', 8, 'Diskon 50%', 'J&T', 'QRIS'),
(56, 'Heels Casadei Pepl Tau', 1, 6575000, 6575000, 3695500, '2026-01-03 16:36:55', 'Dormitory Atma Jaya', 8, 'Diskon 50%', 'J&T', 'QRIS'),
(57, 'Sepatu Kulit Harry Lambert', 1, 1999900, 1999900, 3013950, '2026-01-03 16:37:59', 'Atma Jaya Semanggi', 22, 'Diskon 50%', 'JNE', 'Gopay'),
(58, 'Sepatu Kulit Dua Gesper', 2, 1999000, 3998000, 3013950, '2026-01-03 16:37:59', 'Atma Jaya Semanggi', 22, 'Diskon 50%', 'JNE', 'Gopay'),
(59, 'Sepatu Kulit Harry Lambert', 20, 1999900, 39998000, 134904080, '2026-01-03 17:07:21', 'rumah gw', 8, 'Diskon 10%', 'Si Cepat', 'COD'),
(60, 'Channel Ballet Quilted Calfskin', 2, 14000000, 28000000, 134904080, '2026-01-03 17:07:21', 'rumah gw', 8, 'Diskon 10%', 'Si Cepat', 'COD'),
(61, 'New Jimmy Choo Douchas 100', 2, 20700000, 41400000, 134904080, '2026-01-03 17:07:21', 'rumah gw', 8, 'Diskon 10%', 'Si Cepat', 'COD'),
(62, 'SOPHITINA Stylish Genuine', 4, 10118300, 40473200, 134904080, '2026-01-03 17:07:21', 'rumah gw', 8, 'Diskon 10%', 'Si Cepat', 'COD'),
(63, 'Channel Ballet Quilted Calfskin', 6, 14000000, 84000000, 114473000, '2026-01-03 17:16:39', 'White House', 8, 'Diskon 50%', 'J&T', 'Gopay'),
(64, 'New Jimmy Choo Douchas 100', 7, 20700000, 144900000, 114473000, '2026-01-03 17:16:39', 'White House', 8, 'Diskon 50%', 'J&T', 'Gopay'),
(65, 'Ortuseight Hyperblast', 3, 584565, 1753695, 899847.5, '2026-01-03 18:27:32', 'Atma Jaya Semanggi', 22, 'Diskon 50%', 'J&T', 'Gopay'),
(66, 'NORA Bigtree Heels', 2, 2299000, 4598000, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(67, 'Chester Blue Dodger', 3, 251600, 754800, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(68, 'Arka Khaki', 1, 183600, 183600, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(69, 'Alter Black Gum', 4, 195600, 782400, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(70, 'Vintage Cherry Red Fall Flats', 2, 487000, 974000, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(71, 'Patris Slavina PTS 208', 3, 425250, 1275750, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(72, 'Sepatu Kulit Formal', 4, 1299000, 5196000, 13764550, '2026-01-03 18:39:23', 'Dormitory Atma Jaya', 8, 'Gratis Ongkir', 'JPX', 'QRIS'),
(73, 'Vintage Cherry Red Fall Flats', 2, 487000, 974000, 15277000, '2026-01-08 21:02:43', 'dormitory atma jaya bsd', 24, 'Diskon 50%', 'Si Cepat', 'COD'),
(74, 'Channel Ballet Quilted Calfskin', 2, 14000000, 28000000, 15277000, '2026-01-08 21:02:43', 'dormitory atma jaya bsd', 24, 'Diskon 50%', 'Si Cepat', 'COD'),
(75, 'Sappun Erino Enamel Ribbon', 2, 770000, 1540000, 15277000, '2026-01-08 21:02:43', 'dormitory atma jaya bsd', 24, 'Diskon 50%', 'Si Cepat', 'COD'),
(76, 'New Jimmy Choo Douchas 100', 8, 20700000, 165600000, 104736450, '2026-01-08 21:09:15', 'kalimantan barat', 24, 'Diskon 50%', 'J&T', 'Gopay'),
(77, 'SOPHITINA Stylish Genuine', 3, 10118300, 30354900, 104736450, '2026-01-08 21:09:15', 'kalimantan barat', 24, 'Diskon 50%', 'J&T', 'Gopay'),
(78, 'NORA Bigtree Heels', 3, 2299000, 6897000, 104736450, '2026-01-08 21:09:15', 'kalimantan barat', 24, 'Diskon 50%', 'J&T', 'Gopay'),
(79, 'Heels Casadei Pepl Tau', 1, 6575000, 6575000, 104736450, '2026-01-08 21:09:15', 'kalimantan barat', 24, 'Diskon 50%', 'J&T', 'Gopay'),
(80, 'Kenzo Run', 2, 518420, 1036840, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(81, 'Ortuseight Hyperblast', 2, 584565, 1169130, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(82, 'Brooks Ghost 16', 3, 1399000, 4197000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(83, 'Sepatu Kulit Harry Lambert', 1, 1999900, 1999900, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(84, 'Sepatu Kulit Formal', 2, 1299000, 2598000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(85, 'Mokasin Formal', 3, 799900, 2399700, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(86, 'Sepatu Kulit Dua Gesper', 5, 1999000, 9995000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(87, 'Arka Khaki', 1, 183600, 183600, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(88, 'Alter Black Gum', 2, 195600, 391200, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(89, 'Chester Blue Dodger', 3, 251600, 754800, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(90, 'Fonte White', 1, 183600, 183600, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(91, 'Sappun Erino Enamel Ribbon', 1, 770000, 770000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(92, 'Vintage Cherry Red Fall Flats', 1, 487000, 487000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(93, 'New Jimmy Choo Douchas 100', 3, 20700000, 62100000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(94, 'Heels Casadei Pepl Tau', 1, 6575000, 6575000, 94840770, '2026-01-08 21:16:29', 'Bekasi', 24, 'Gratis Ongkir', 'JPX', 'OVO'),
(95, 'Fonte White', 1, 183600, 183600, 235600, '2026-01-08 21:19:48', 'kalimantan barat', 24, 'Diskon 50%', 'JPX', 'Gopay'),
(96, 'Chester Blue Dodger', 1, 251600, 251600, 235600, '2026-01-08 21:19:48', 'kalimantan barat', 24, 'Diskon 50%', 'JPX', 'Gopay'),
(97, 'Ortuseight Hyperblast', 1, 584565, 584565, 310282.5, '2026-01-08 21:20:50', 'kalimantan barat', 24, 'Diskon 50%', 'JPX', 'COD'),
(98, 'Ortuseight Hyperblast', 2, 584565, 1169130, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(99, 'Mokasin Formal', 2, 799900, 1599800, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(100, 'Arka Khaki', 1, 183600, 183600, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(101, 'Alter Black Gum', 1, 195600, 195600, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(102, 'Vintage Cherry Red Fall Flats', 1, 487000, 487000, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(103, 'New Jimmy Choo Douchas 100', 1, 20700000, 20700000, 12182565, '2026-01-08 21:34:01', 'planet', 8, 'Diskon 50%', 'JNE', 'COD'),
(104, 'Channel Ballet Quilted Calfskin', 1, 14000000, 14000000, 14000000, '2026-01-08 21:38:05', 'rumah iell', 8, 'Gratis Ongkir', 'J&T', 'COD'),
(105, 'Vintage Cherry Red Fall Flats', 1, 487000, 487000, 261500, '2026-01-09 13:30:26', 'rumah gw', 8, 'Diskon 50%', 'JPX', 'Gopay'),
(106, 'XPREME', 1, 170499, 170499, 108249.5, '2026-01-09 13:33:12', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'OVO'),
(107, 'XPREME', 1, 170499, 170499, 170499, '2026-01-09 14:36:21', 'White House', 8, 'Gratis Ongkir', 'JPX', 'Gopay'),
(108, 'Ortuseight Hyperblast', 2, 584565, 1169130, 1063690, '2026-01-10 15:19:17', 'dormitory', 27, 'Diskon 50%', 'J&T', 'Gopay'),
(109, 'Vintage Cherry Red Fall Flats', 1, 487000, 487000, 1063690, '2026-01-10 15:19:17', 'dormitory', 27, 'Diskon 50%', 'J&T', 'Gopay'),
(110, 'Patris Slavina PTS 208', 1, 425250, 425250, 1063690, '2026-01-10 15:19:17', 'dormitory', 27, 'Diskon 50%', 'J&T', 'Gopay'),
(111, 'Ortuseight Hyperblast', 3, 584565, 1753695, 2041097.5, '2026-01-10 15:36:10', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'COD'),
(112, 'Mokasin Formal', 1, 799900, 799900, 2041097.5, '2026-01-10 15:36:10', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'COD'),
(113, 'Sepatu Kulit Formal', 1, 1299000, 1299000, 2041097.5, '2026-01-10 15:36:10', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'COD'),
(114, 'Fonte White', 1, 183600, 183600, 2041097.5, '2026-01-10 15:36:10', 'Atma Jaya', 8, 'Diskon 50%', 'J&T', 'COD');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` bigint(11) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `username`, `password`) VALUES
(8, 'user1', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),
(21, 'beatricealicia', '9f0107112d8a667ef4358e7553c9bfd0733b99f572b0202d032aace504a37ed3'),
(22, 'user2', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),
(23, 'user3', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),
(24, 'edolopiell', '9cf6d237775b45213bcd87268793ebb7eaed93270ccb125e535f8a9af8687101'),
(26, 'user7', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
(27, 'user5', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_alamat`
--
ALTER TABLE `tbl_alamat`
  ADD PRIMARY KEY (`id_alamat`);

--
-- Indexes for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_history`
--
ALTER TABLE `tbl_history`
  ADD PRIMARY KEY (`id_history`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_alamat`
--
ALTER TABLE `tbl_alamat`
  MODIFY `id_alamat` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  MODIFY `cart_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=212;

--
-- AUTO_INCREMENT for table `tbl_history`
--
ALTER TABLE `tbl_history`
  MODIFY `id_history` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  ADD CONSTRAINT `tbl_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
