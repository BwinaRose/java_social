CREATE DATABASE `java_social`;

use `java_social`;

CREATE TABLE IF NOT EXISTS `users` (
    `id` varchar(50) primary key,
    `email` varchar(50)
);

CREATE TABLE IF NOT EXISTS `profile`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    `email` VARCHAR(50),
    `user_name` VARCHAR(20),
    `password` VARCHAR(16),
    `sender_id` INTEGER,
    `receiver_id` INTEGER,
    `detail_id` INTEGER,
    `group_id` INTEGER,
    `admin_id` INTEGER
);


CREATE TABLE IF NOT EXISTS `user_details`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE IF NOT EXISTS `skills`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `skill` VARCHAR(50),
    `detail_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `experience`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `employment_type` ENUM('FULL_TIME', 'PART_TIME', 'INTERNSHIP', 'APPRENTICESHIP', 'FREELANCE'),
    `jobTitle` varchar(50),
    `company` varchar(50),
    `location` varchar(50),
    `startDate` varchar(50),
    `endDate` varchar(50),
    `detail_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `education`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `schoolName` varchar(50),
    `location` varchar(50),
    `startDate` varchar(50),
    `endDate` varchar(50),
    `fieldOfStudy` varchar(50),
    `isGraduated` Boolean,
    `gradePointAvg` Double,
    `detail_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `accomplishments`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `accomplishment` VARCHAR(50),
    `detail_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `groups`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `groupName` varchar(20)
);

CREATE TABLE IF NOT EXISTS `posts`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `post_content` varchar(256),
    `likes` INTEGER
);

CREATE TABLE IF NOT EXISTS `messages`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `message_content` VARCHAR(256),
    `date_sent` TIMESTAMP,
    `post_id` INTEGER
);

CREATE TABLE IF NOT EXISTS `comments` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `content` VARCHAR(500),
    `date_posted` TIMESTAMP,
    `post_id` INTEGER
);