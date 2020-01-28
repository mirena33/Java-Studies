CREATE TABLE `people` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB NULL,
    `height` DOUBLE(5 , 2 ) NULL,
    `weight` DOUBLE(5 , 2 ) NULL,
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT NULL
);

INSERT INTO `people`
(`id`,
`name`,
`picture`,
`height`,
`weight`,
`gender`,
`birthdate`,
`biography`)
VALUES
(1, 'Ivan', 'somepics', 165.53, 55.0, 'm', '2020-02-21', 'He has a dog and a cat.'),
(2, 'Petar', 'somepics', 165.53, 55.0, 'm', '2020-02-20', 'He has a dog and a cat.'),
(3, 'Sonia', 'somepics', 165.53, 55.0, 'f', '2020-03-21', 'He has a dog and a cat.'),
(4, 'Maria', 'somepics', 165.53, 55.0, 'f', '2020-02-21', 'He has a dog and a cat.'),
(5, 'Svetlana', 'somepics', 165.53, 55.0, 'f', '2020-04-21', 'He has a dog and a cat.');

CREATE TABLE `users` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(30),
    `password` VARCHAR(26),
    `profile_picture` BLOB,
    `last_login_time` TIMESTAMP,
    `is_deleted` CHAR(5)
);

INSERT INTO `users`
(`id`,
`username`,
`password`,
`profile_picture`,
`last_login_time`,
`is_deleted`)
VALUES
(1, 'badboy', 'hoho123', 'somepicss', '2020-01-19 03:14:07.999999', 'false'),
(2, 'badboy2', 'hoho', 'somepicss', '2020-01-19 03:14:07.999999', 'true'),
(3, 'badboy3', 'hoho311', 'somepicss', '2020-01-19 03:14:07.999999', 'false'),
(4, 'badboy4', 'hoho321', 'somepicss', '2020-01-19 03:14:07.999999', 'false'),
(5, 'badboy5', 'hoho13', 'somepicss', '2020-01-19 03:14:07.999999', 'true');

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (`id`, `username`);

ALTER TABLE `users`
MODIFY COLUMN `last_login_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE users MODIFY id BIGINT NOT NULL;
ALTER TABLE users DROP PRIMARY KEY;
ALTER TABLE users ADD CONSTRAINT pk_users PRIMARY KEY(id);
ALTER TABLE users ADD CONSTRAINT uq_username UNIQUE (username);


