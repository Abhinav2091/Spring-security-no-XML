DROP DATABASE  IF EXISTS `spring_security_demo`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo`;
USE `spring_security_demo`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- {noop} is for pplain text
-- {bcrypt} is for encripted password her i put for root using bcryptcalculater
INSERT INTO `users` 
VALUES 
('Abhinav','{noop}root',1),
('Aju','{bcrypt}$2a$10$CAJIIsZrOtxIjWkFKgSaPuBuTrUFiS.lMVeOYHBxkp44UmA2BRnxq',1),
('Himanshu','{noop}root',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('Abhinav','ROLE_EMPLOYEE'),
('Aju','ROLE_EMPLOYEE'),
('Aju','ROLE_MANAGER'),
('Himanshu','ROLE_EMPLOYEE'),
('Himanshu','ROLE_ADMIN');


