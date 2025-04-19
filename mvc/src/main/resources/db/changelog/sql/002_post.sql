--liquibase formatted sql
--changeset svc_z_blog:tbl-post-001
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) C FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME='TBL_POST';
CREATE TABLE TBL_POST(
    `ID` INT NOT NULL,
    `TITLE` NVARCHAR(500) NOT NULL,
    `SUMMARY` NVARCHAR(2000) NOT NULL,
    `THUMBNAIL_URL` VARCHAR(1000) DEFAULT NULL,
    `CONTENT` LONGTEXT DEFAULT NULL,
    `CREATE_TIME` DATETIME DEFAULT NULL,
    `LAST_UPDATE` DATETIME DEFAULT NULL,

    PRIMARY KEY (`ID`)
);
