CREATE TABLE `im_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_user_id` bigint(20) DEFAULT NULL,
  `from_username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `to_user_id` bigint(20) DEFAULT NULL,
  `to_username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;