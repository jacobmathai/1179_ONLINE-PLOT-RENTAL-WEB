# MySQL-Front 3.2  (Build 8.0)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

# Host: localhost    Database: opr_db
# ------------------------------------------------------
# Server version 5.0.15-nt

DROP DATABASE IF EXISTS `opr_db`;
CREATE DATABASE `opr_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `opr_db`;

#
# Table structure for table amenities_info
#

CREATE TABLE `amenities_info` (
  `id` int(11) NOT NULL auto_increment,
  `prop_id` varchar(11) NOT NULL,
  `ac` varchar(11) NOT NULL,
  `coffee` varchar(11) NOT NULL default '0',
  `heating` varchar(11) NOT NULL,
  `parking` varchar(11) NOT NULL,
  `balcony` varchar(11) NOT NULL,
  `internet` varchar(11) NOT NULL,
  `pool` varchar(11) NOT NULL,
  `bedding` varchar(11) NOT NULL,
  `fridge` varchar(11) NOT NULL,
  `microwave` varchar(11) NOT NULL default '0',
  `cable` varchar(11) NOT NULL,
  `oven` varchar(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `prop_id` (`prop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table amenities_info
#



#
# Table structure for table booking_info
#

CREATE TABLE `booking_info` (
  `id` int(11) NOT NULL default '0',
  `prop_id` varchar(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `booking_date` varchar(11) NOT NULL,
  `status` varchar(11) default NULL,
  PRIMARY KEY  (`prop_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table booking_info
#



#
# Table structure for table login_info
#

CREATE TABLE `login_info` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_type` varchar(30) NOT NULL,
  `gcm_key` varchar(350) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table login_info
#

INSERT INTO `login_info` VALUES ('admin','admin','admin',NULL);


#
# Table structure for table material_info
#

CREATE TABLE `material_info` (
  `prop_id` int(11) NOT NULL auto_increment,
  `wood_used` varchar(11) NOT NULL,
  `brick_used` varchar(11) NOT NULL,
  `panel_used` varchar(11) NOT NULL,
  `stone_used` varchar(11) NOT NULL,
  PRIMARY KEY  (`prop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table material_info
#



#
# Table structure for table property_info
#

CREATE TABLE `property_info` (
  `prop_id` varchar(11) NOT NULL default '0',
  `prop_title` varchar(100) NOT NULL,
  `prop_type` varchar(30) NOT NULL,
  `owner_name` varchar(30) NOT NULL,
  `city` varchar(50) NOT NULL,
  `location` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `pub_location` varchar(50) NOT NULL,
  `dist_pub_location` varchar(11) NOT NULL,
  `bedrooms` varchar(11) default NULL,
  `bathrooms` varchar(11) default NULL,
  `area` varchar(11) NOT NULL,
  `price` varchar(11) NOT NULL,
  `contract_type` varchar(50) NOT NULL,
  `quality_type` varchar(20) default NULL,
  `post_date` varchar(11) default NULL,
  `proof_type` varchar(20) NOT NULL,
  `proof_id` varchar(20) NOT NULL,
  `description` varchar(500) default NULL,
  `status` varchar(11) NOT NULL,
  `type` varchar(11) NOT NULL,
  PRIMARY KEY  (`prop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table property_info
#



#
# Table structure for table user_info
#

CREATE TABLE `user_info` (
  `name` varchar(30) NOT NULL,
  `username` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `city` varchar(50) NOT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table user_info
#



#
#  Foreign keys for table amenities_info
#

ALTER TABLE `amenities_info`
  ADD FOREIGN KEY (`prop_id`) REFERENCES `property_info` (`prop_id`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table booking_info
#

ALTER TABLE `booking_info`
  ADD FOREIGN KEY (`prop_id`) REFERENCES `property_info` (`prop_id`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table user_info
#

ALTER TABLE `user_info`
  ADD FOREIGN KEY (`username`) REFERENCES `login_info` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
