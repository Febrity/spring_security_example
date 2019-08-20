CREATE TABLE IF NOT EXISTS USERS(user_name varchar(256) primary key, password varchar(256),  passwordEncode varchar(256), role varchar(256));

INSERT INTO USERS VALUES ('user', 'user', '$2a$10$QrQloemXCsbS3ISGkTKIQ.EVs7.L3hpS3mg8GYRqJ10b/W/vc3OUm', 'user');
INSERT INTO USERS VALUES ('admin', 'admin', '$2a$10$9ZwlxRThXMW1WwTDBykvY.D3QyV/U/i0djip3mdkL4z3SYKSq9Do6', 'admin');
INSERT INTO USERS VALUES ('business_admin', 'business_admin', '$2a$10$QHsHI8XhOfJvtXtLw0Gw7Os216vTk2vt1v32y.K38KFc4pluEzGgS', 'business_admin');