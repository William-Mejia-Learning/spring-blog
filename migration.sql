CREATE DATABASE IF NOT EXISTS spring_blog_db;

USE spring_blog_db;

CREATE USER IF NOT EXISTS 'spring_blog_user'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON spring_blog_db.* TO 'codeup_test_user1'@'localhost';

SELECT User FROM mysql.user;



