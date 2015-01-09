drop table if exists `version`;
CREATE  TABLE `version`
(
  `id` INT NOT NULL AUTO_INCREMENT ,
  `version_num` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(250) NOT NULL ,
  `update_time` TIMESTAMP NOT NULL ,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='version信息表';