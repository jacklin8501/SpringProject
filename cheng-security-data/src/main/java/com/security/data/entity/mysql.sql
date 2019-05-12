CREATE TABLE `iden_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `password` varchar(150) COLLATE ucs2_unicode_ci NOT NULL COMMENT '密码',
  `username` varchar(36) COLLATE ucs2_unicode_ci NOT NULL COMMENT '用户名',
  `account_non_expired` bit(1) NOT NULL DEFAULT b'1' COMMENT '账户没过期?',
  `account_non_locked` bit(1) NOT NULL DEFAULT b'1' COMMENT '账户没锁定?',
  `credentials_non_expired` bit(1) NOT NULL DEFAULT b'1' COMMENT '证书没过期?',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '可用?',
  `version` bigint(20) NOT NULL DEFAULT '0',
  `create_by` varchar(100) COLLATE ucs2_unicode_ci NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `last_modified_by` varchar(100) COLLATE ucs2_unicode_ci NOT NULL COMMENT '最后修改者',
  `last_modified_date` bigint(20) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=ucs2 COLLATE=ucs2_unicode_ci COMMENT='用户';
