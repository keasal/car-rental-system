CREATE DATABASE `rental` DEFAULT CHARACTER SET utf8;

USE `rental`;

DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(32) DEFAULT NULL COMMENT '车型号',
  `in_stock` int(11) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`car_id`),
  UNIQUE INDEX `model` (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆库存信息表';

INSERT INTO `car_info` VALUES ('1', 'Toyota Camry', 2);
INSERT INTO `car_info` VALUES ('2', 'BMW 650', 2);


DROP TABLE IF EXISTS `user_rental_record`;
CREATE TABLE `user_rental_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `model` varchar(32) DEFAULT NULL COMMENT '车型号',
  `start_date` date NOT NULL COMMENT '开始时间',
  `end_date` date NOT NULL COMMENT '结束时间',
  `status` varchar(2) NOT NULL COMMENT '是否归还，Y未归还，N已归还',
  `fcd` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `lcd` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`record_id`),
  INDEX `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租借记录表';

