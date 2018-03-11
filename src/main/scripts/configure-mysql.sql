CREATE DATABASE smd_dev;
CREATE DATABASE smd_prod;

CREATE USER 'smd_dev_user'@'localhost' IDENTIFIED BY 'smvcd';
CREATE USER 'smd_prod_user'@'localhost' IDENTIFIED BY 'smvcd';
CREATE USER 'smg_dev_user'@'%' IDENTIFIED BY 'smvcd';
CREATE USER 'smg_prod_user'@'%' IDENTIFIED BY 'smvcd';

GRANT SELECT ON smd_dev.* to 'smd_dev_user'@'localhost';
GRANT INSERT ON smd_dev.* to 'smd_dev_user'@'localhost';
GRANT DELETE ON smd_dev.* to 'smd_dev_user'@'localhost';
GRANT UPDATE ON smd_dev.* to 'smd_dev_user'@'localhost';
GRANT SELECT ON smd_prod.* to 'smd_prod_user'@'localhost';
GRANT INSERT ON smd_prod.* to 'smd_prod_user'@'localhost';
GRANT DELETE ON smd_prod.* to 'smd_prod_user'@'localhost';
GRANT UPDATE ON smd_prod.* to 'smd_prod_user'@'localhost';
GRANT SELECT ON smd_dev.* to 'smg_dev_user'@'%';
GRANT INSERT ON smd_dev.* to 'smg_dev_user'@'%';
GRANT DELETE ON smd_dev.* to 'smg_dev_user'@'%';
GRANT UPDATE ON smd_dev.* to 'smg_dev_user'@'%';
GRANT SELECT ON smd_prod.* to 'smg_prod_user'@'%';
GRANT INSERT ON smd_prod.* to 'smg_prod_user'@'%';
GRANT DELETE ON smd_prod.* to 'smg_prod_user'@'%';
GRANT UPDATE ON smd_prod.* to 'smg_prod_user'@'%';