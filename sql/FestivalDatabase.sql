
CREATE DATABASE `festivaldatabase`;

USE `festivaldatabase`;

DROP TABLE IF EXISTS `festivaldatabase`.`event`;
CREATE TABLE  `festivaldatabase`.`event` (
  `eventid` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `description` varchar(40) NOT NULL,
  `places` varchar(40) NOT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `eventtype` varchar(40) DEFAULT NULL,
  `seatsavailable` int(11) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
);

DROP TABLE IF EXISTS `festivaldatabase`.`visitor`;
CREATE TABLE  `festivaldatabase`.`visitor` (
  `visitorid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`visitorid`)
);

DROP TABLE IF EXISTS `festivaldatabase`.`eventsignup`;
CREATE TABLE  `festivaldatabase`.`eventsignup` (
  `signupid` int(11) NOT NULL AUTO_INCREMENT,
  `eventid` int(11) DEFAULT NULL,
  `visitorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`signupid`),
  KEY `eventid` (`eventid`),
  KEY `visitorid` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_2`  FOREIGN KEY (`visitorid`) REFERENCES `visitor` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_3`  FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`)
);


CREATE DATABASE `testFestivaldatabase`;

USE `testFestivaldatabase`;

DROP TABLE IF EXISTS `testFestivaldatabase`.`event`;
CREATE TABLE  `testFestivaldatabase`.`event` (
  `eventid` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `description` varchar(40) NOT NULL,
  `places` varchar(40) NOT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `eventtype` varchar(40) DEFAULT NULL,
  `seatsavailable` int(11) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
);

DROP TABLE IF EXISTS `testFestivaldatabase`.`visitor`;
CREATE TABLE  `testFestivaldatabase`.`visitor` (
  `visitorid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`visitorid`)
);

DROP TABLE IF EXISTS `testFestivaldatabase`.`eventsignup`;
CREATE TABLE  `testFestivaldatabase`.`eventsignup` (
  `signupid` int(11) NOT NULL AUTO_INCREMENT,
  `eventid` int(11) DEFAULT NULL,
  `visitorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`signupid`),
  KEY `eventid` (`eventid`),
  KEY `visitorid` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_2`  FOREIGN KEY (`visitorid`) REFERENCES `visitor` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_3`  FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`)
);
