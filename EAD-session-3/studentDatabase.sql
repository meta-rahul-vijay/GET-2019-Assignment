CREATE DATABASE `student` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE student ;

CREATE TABLE `student_record` (
  `First_name` varchar(20) NOT NULL,
  `Last_name` varchar(45) NOT NULL,
  `Father_name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Class` int(11) NOT NULL,
  `Age` int(11) NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
