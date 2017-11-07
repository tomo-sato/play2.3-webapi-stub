-- MySQL Script generated by MySQL Workbench
-- Tue Nov  7 22:18:40 2017
-- Model: webapi_stub    Version: 1.3.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema webapi_stub
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webapi_stub
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webapi_stub` DEFAULT CHARACTER SET utf8mb4 ;
USE `webapi_stub` ;

-- -----------------------------------------------------
-- Table `webapi_stub`.`actions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webapi_stub`.`actions` ;

CREATE TABLE IF NOT EXISTS `webapi_stub`.`actions` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `detail` VARCHAR(128) NULL COMMENT '機能詳細',
  `api_name` VARCHAR(128) NULL COMMENT 'API名',
  `api_endpoint` VARCHAR(128) NULL COMMENT 'API Endpoint',
  `created` DATETIME NOT NULL COMMENT '作成日時',
  `modified` DATETIME NOT NULL COMMENT '更新日時',
  `delete_flg` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '削除フラグ（1：削除、0：未削除）',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'アクション';

CREATE INDEX `i_actions1` ON `webapi_stub`.`actions` (`api_endpoint` ASC, `delete_flg` ASC);


-- -----------------------------------------------------
-- Table `webapi_stub`.`responses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webapi_stub`.`responses` ;

CREATE TABLE IF NOT EXISTS `webapi_stub`.`responses` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `response_json` TEXT NULL COMMENT 'レスポンス json',
  `http_status_code` INT NULL COMMENT 'HTTPステータスコード',
  `sleep_time_seconds` INT NOT NULL DEFAULT 0 COMMENT 'スリープ時間（デフォルト：0秒）',
  `note` VARCHAR(128) NULL COMMENT '備考',
  `created` DATETIME NOT NULL COMMENT '作成日時',
  `modified` DATETIME NOT NULL COMMENT '更新日時',
  `delete_flg` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '削除フラグ（1：削除、0：未削除）',
  `actions_id` BIGINT NOT NULL COMMENT 'アクションID（※紐付け可能なアクションIDを指定。）',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'レスポンス';

CREATE INDEX `fk_responses_actions1_idx` ON `webapi_stub`.`responses` (`actions_id` ASC);


-- -----------------------------------------------------
-- Table `webapi_stub`.`action_response_joins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `webapi_stub`.`action_response_joins` ;

CREATE TABLE IF NOT EXISTS `webapi_stub`.`action_response_joins` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `actions_id` BIGINT NOT NULL COMMENT 'アクションID',
  `responses_id` BIGINT NOT NULL COMMENT 'レスポンスID',
  `created` DATETIME NOT NULL COMMENT '作成日時',
  `modified` DATETIME NOT NULL COMMENT '更新日時',
  `delete_flg` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '削除フラグ（1：削除、0：未削除）',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'アクション レスポンス紐付け';

CREATE INDEX `fk_action_response_join_actions_idx` ON `webapi_stub`.`action_response_joins` (`actions_id` ASC);

CREATE INDEX `fk_action_response_join_responses_idx` ON `webapi_stub`.`action_response_joins` (`responses_id` ASC);

CREATE INDEX `i_action_response_join1_idx` ON `webapi_stub`.`action_response_joins` (`actions_id` ASC, `responses_id` ASC, `delete_flg` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
