CREATE USER 'svc_z_blog'@'%' IDENTIFIED BY 'vuew4NdJgM3yZb5b';
CREATE DATABASE IF NOT EXISTS svc_z_blog;
GRANT ALL PRIVILEGES ON `svc_z_blog` .  * TO 'svc_z_blog'@'%';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'svc_z_blog'@'%';
COMMIT;
