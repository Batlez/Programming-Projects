-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2023 at 09:24 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursebook_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `authors` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `authors`, `isbn`) VALUES
(1, 'Systems Analysis and Design', 'Alan Dennis, Barbara Haley Wixom, Roberta M. Roth', '978-1-11-949632-8'),
(2, 'Introduction to Java Programming, Brief Version', 'Y. Daniel Liang', '978-0-13-461103-7'),
(3, 'Murach\'s PHP and MySQL', 'Joel Murach, Ray Harris', ' 978-1-943873-00-5');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(50) NOT NULL,
  `bookid` int(50) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `bookid`, `comment`) VALUES
(1, 2, 'hello'),
(2, 2, 'hello'),
(3, 1, 'hi'),
(4, 1, 'hey'),
(5, 1, 'THIS BOOK SUCKS');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `code`, `name`, `description`) VALUES
(1, 'IN1044', 'Introduction to Programming', 'This course provides an introduction to programming using Java. The course will focus on core programming concepts that are universal to all modern programming languages. Students will learn to write programs using proper algorithm design, logic, data types, variables, control structures and functions (methods). The goal of the course is to provide a solid foundation of core programming skills that will allow students to further their learning in a variety of development environments.'),
(2, 'IN1104', 'IT Essentials I', 'This course covers the fundamentals of computer hardware, software and advanced concepts such as security, networking, and the responsibilities of an IT professional. Students learn how to assemble and configure a computer, install operating systems and software, and finally troubleshoot hardware and software problems. In addition, chapters on networks and communication skills are included. This course helps students prepare for CompTIA’s A+ certification.\r\n'),
(3, 'MA1100', 'Technical Mathematics I', 'This course covers basic algebra properties, graphing the straight line, basic geometry and trigonometry, and solving a system of equations graphically and algebraically. It also covers vector addition by components and by the cosine and sine laws.'),
(4, 'IN1004', 'Cisco Networking I', 'Cisco Networking I is the first course of the Cisco Networking Academy CCNAv7 curriculum titled Introduction to Networks (ITN). Introduction to Networks is one of three courses that are aligned to the CCNA Certification Exam. ITN contains 17 modules, each with a series of topics. In Introduction to Networks, the student will gain a basic understanding of the way networks operate. They will learn about network components and their functions, as well as how a network is structured, and the architectures used to create networks, including the internet. ITN is about more than learning networking concepts. By the end of this course, the student will be able to build local area networks (LANs), configure basic settings on routers and switches, and implement internet protocol (IP). In ITN, every concept that the student learns and skills that they develop will be used in the rest of the CCNA curriculum.');

-- --------------------------------------------------------

--
-- Table structure for table `courses_books`
--

CREATE TABLE `courses_books` (
  `courseid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `programs`
--

CREATE TABLE `programs` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `programs`
--

INSERT INTO `programs` (`id`, `name`, `code`) VALUES
(1, 'Computer Engineering Technician', 'T100'),
(2, 'Business Fundamentals', 'B287'),
(3, 'Computer Programming', 'T115'),
(4, 'Cybersecurity', 'T250');

-- --------------------------------------------------------

--
-- Table structure for table `programs_books`
--

CREATE TABLE `programs_books` (
  `bookid` int(11) NOT NULL,
  `programid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `programs_books`
--

INSERT INTO `programs_books` (`bookid`, `programid`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `programs_courses`
--

CREATE TABLE `programs_courses` (
  `programid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  `semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `programs_courses`
--

INSERT INTO `programs_courses` (`programid`, `courseid`, `semester`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(1, 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses_books`
--
ALTER TABLE `courses_books`
  ADD PRIMARY KEY (`courseid`,`bookid`);

--
-- Indexes for table `programs`
--
ALTER TABLE `programs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `programs_books`
--
ALTER TABLE `programs_books`
  ADD PRIMARY KEY (`bookid`,`programid`);

--
-- Indexes for table `programs_courses`
--
ALTER TABLE `programs_courses`
  ADD PRIMARY KEY (`programid`,`courseid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `programs`
--
ALTER TABLE `programs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
