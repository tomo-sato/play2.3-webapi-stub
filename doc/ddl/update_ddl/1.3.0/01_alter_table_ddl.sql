-- MySQL Script generated by MySQL Workbench
-- Tue Nov  7 22:18:40 2017
-- Model: webapi_stub    Version: 1.3.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Table `webapi_stub`.`responses`
-- -----------------------------------------------------
ALTER TABLE `webapi_stub`.`responses` 
ADD COLUMN `actions_id` BIGINT NULL COMMENT 'アクションID（※紐付け可能なアクションIDを指定。）' AFTER `note`;

