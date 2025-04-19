--liquibase formatted sql
--changeset svc_z_blog:tbl-post-sample-001
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) C FROM TBL_POST;
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (1, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (2, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (3, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (4, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (5, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (6, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
INSERT INTO TBL_POST (ID, TITLE, SUMMARY, THUMBNAIL_URL, CONTENT) VALUES (7, 'Sample post 1', 'Đây là câu chuyện mẫu đầu tiên', 'https://images.mansionglobal.com/im-58378810?width=1299&size=1.5005861664712778&pixel_ratio=1.5', 'Nội dung mẫu');
