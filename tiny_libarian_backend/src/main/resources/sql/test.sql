CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(255) UNIQUE,password VARCHAR(255),email VARCHAR(255),create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,update_at TIMESTAMP DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,role INT);
CREATE TABLE roles(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255),create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
ALTER TABLE users ADD CONSTRAINT fk_roles FOREIGN KEY (role) REFERENCES roles(id);

ALTER DATABASE tiny_libarian
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
ALTER TABLE roles CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE users CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- ALTER TABLE books CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


-- 插入角色数据
INSERT INTO roles (name) VALUES
                             ('管理员'),
                             ('图书管理员'),
                             ('普通读者'),
                             ('VIP读者'),
                             ('访客');

-- 插入用户数据
INSERT INTO users (username, password, email, role) VALUES
-- 管理员 (role=1)
('admin', 'admin123', 'admin@library.com', 1),
('sysadmin', 'sys@2023', 'sysadmin@library.com', 1),

-- 图书管理员 (role=2)
('librarian1', 'lib123456', 'librarian1@library.com', 2),
('librarian2', 'lib654321', 'librarian2@library.com', 2),
('book_mgr', 'book@2023', 'bookmgr@library.com', 2),

-- 普通读者 (role=3)
('reader_zhang', 'zhang2023', 'zhangsan@email.com', 3),
('reader_li', 'li@123456', 'lisi@email.com', 3),
('reader_wang', 'wang#789', 'wangwu@email.com', 3),
('zhaoliu', 'zhao!2023', 'zhaoliu@email.com', 3),
('sunqi', 'sunqi888', 'sunqi@email.com', 3),

-- VIP读者 (role=4)
('vip_zhang', 'vipzhang123', 'vipzhang@email.com', 4),
('vip_li', 'vip!li456', 'vip.li@company.com', 4),
('vip_wang', 'WangVIP2023', 'wang.vip@company.com', 4),

-- 访客 (role=5)
('guest1', 'guest111', 'guest1@email.com', 5),
('guest2', 'guest222', 'guest2@email.com', 5),
('temp_user', 'temp1234', 'temp@email.com', 5);


CREATE TABLE books (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       title VARCHAR(255),
                       status BOOL,
                       owner INT,
                       borrower INT,
                       create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 插入图书数据
INSERT INTO books (title, status, owner, borrower, create_at) VALUES
-- 图书管理员拥有的图书 (可借阅状态)
('百年孤独', TRUE, 3, NULL, '2023-01-15 10:00:00'),
('活着', TRUE, 3, NULL, '2023-01-16 11:30:00'),
('三体', TRUE, 4, NULL, '2023-01-17 14:20:00'),
('红楼梦', TRUE, 4, NULL, '2023-02-01 09:15:00'),
('小王子', TRUE, 5, NULL, '2023-02-10 16:45:00'),
('1984', TRUE, 3, NULL, '2023-02-15 13:10:00'),
('围城', TRUE, 4, NULL, '2023-02-20 10:30:00'),
('人类简史', TRUE, 5, NULL, '2023-03-05 11:00:00'),

-- 已被借阅的图书 (status=FALSE)
('哈利波特与魔法石', FALSE, 3, 6, '2023-03-10 10:00:00'),
('Effective Java', FALSE, 4, 7, '2023-03-12 14:30:00'),
('设计模式', FALSE, 5, 8, '2023-03-15 16:20:00'),
('Python编程从入门到实践', FALSE, 3, 9, '2023-03-18 09:45:00'),
('算法导论', FALSE, 4, 10, '2023-03-20 13:15:00'),

-- 管理员拥有的图书
('图书馆管理实务', TRUE, 1, NULL, '2023-04-01 08:30:00'),
('信息系统安全', TRUE, 2, NULL, '2023-04-05 10:20:00'),

-- 被VIP读者借阅的图书
('了不起的盖茨比', FALSE, 4, 11, '2023-04-10 15:00:00'),
('追风筝的人', FALSE, 5, 12, '2023-04-12 11:30:00'),
('白夜行', FALSE, 3, 13, '2023-04-15 14:45:00'),

-- 更多可借阅图书
('挪威的森林', TRUE, 4, NULL, '2023-04-20 10:00:00'),
('解忧杂货店', TRUE, 5, NULL, '2023-04-22 13:20:00'),
('明朝那些事儿', TRUE, 3, NULL, '2023-04-25 09:30:00'),
('时间简史', TRUE, 4, NULL, '2023-04-28 15:10:00'),
('乌合之众', TRUE, 5, NULL, '2023-05-01 11:40:00'),

-- 最近被借阅的图书
('C++ Primer', FALSE, 3, 6, '2023-05-05 10:30:00'),
('深入理解计算机系统', FALSE, 4, 7, '2023-05-08 14:00:00'),
('经济学原理', FALSE, 5, 8, '2023-05-10 16:45:00');

-- 更新一些图书的更新时间为借阅时间
UPDATE books SET update_at = '2023-05-12 09:20:00' WHERE id IN (9, 10, 11);
UPDATE books SET update_at = '2023-05-15 14:30:00' WHERE id IN (16, 17, 18);
UPDATE books SET update_at = '2023-05-18 11:10:00' WHERE id IN (23, 24, 25);

ALTER TABLE books ADD CONSTRAINT fk_books_owner FOREIGN KEY (owner) REFERENCES users(id);
ALTER TABLE books ADD CONSTRAINT fk_books_borrower FOREIGN KEY (borrower) REFERENCES users(id);