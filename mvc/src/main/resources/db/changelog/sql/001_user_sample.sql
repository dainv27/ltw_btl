--liquibase formatted sql
--changeset svc_z_blog:tbl-user-sample-001
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) C FROM TBL_USER;
INSERT INTO TBL_USER (ID, USERNAME, PASSWORD, FULL_NAME, EMAIL, ENABLED, CREATE_TIME) VALUES ('21e54880-f541-46d2-9e13-9bbf2c23dabc', 'dainv', '$2a$10$pycb/Uf6zG1KtcM7wlCP7Oixd7popkGN49sEz4t4GkRF1ebjIm102', 'Nguyễn Đại', 'nguyenvandaik57@gmail.com', 1, NOW());
INSERT INTO TBL_USER (ID, USERNAME, PASSWORD, FULL_NAME, EMAIL, ENABLED, CREATE_TIME) VALUES ('3a22eda3-459c-4af7-9a6e-4f0bf243ff69', 'test1', '$2a$10$pycb/Uf6zG1KtcM7wlCP7Oixd7popkGN49sEz4t4GkRF1ebjIm102', 'Test User 1', 'test1@gmail.com', 1, NOW());
INSERT INTO TBL_USER (ID, USERNAME, PASSWORD, FULL_NAME, EMAIL, ENABLED, CREATE_TIME) VALUES ('d802354f-d203-4406-b09c-898a786d13d6', 'test2', '$2a$10$pycb/Uf6zG1KtcM7wlCP7Oixd7popkGN49sEz4t4GkRF1ebjIm102', 'Test User 2', 'test2@gmail.com', 2, NOW());
