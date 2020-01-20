CREATE SCHEMA `Movies`;
CREATE TABLE `directors` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `director_name` VARCHAR(45),
    `notes` TEXT
);

CREATE TABLE `genres` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `genre_name` VARCHAR(45),
    `notes` TEXT
);

CREATE TABLE `categories` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category_name` VARCHAR(45),
    `notes` TEXT
);

CREATE TABLE `movies` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(45),
    `director_id` INT NOT NULL,
    `copyright_year` INT(4),
    `length` DECIMAL(5 , 2 ),
    `genre_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `rating` INT(1),
    `notes` TEXT,
    CONSTRAINT `fk_movies_directors` FOREIGN KEY (`director_id`)
        REFERENCES `directors` (`id`),
    CONSTRAINT `fk_movies_genres` FOREIGN KEY (`genre_id`)
        REFERENCES `genres` (`id`),
    CONSTRAINT `fk_movies_categories` FOREIGN KEY (`category_id`)
        REFERENCES `categories` (`id`)
);

INSERT INTO `directors`
(`id`,
`director_name`,
`notes`)
VALUES
(1, 'peter petrov', 'sometextt'),
(2, 'peter ivanov', 'sometextt'),
(3, 'ann petrov', 'sometextt'),
(4, 'seb petrov', 'sometextt'),
(5, 'peter angelov', 'sometextt');

INSERT INTO `genres`
(`id`,
`genre_name`,
`notes`)
VALUES
(1, 'comedy', 'sometexttt'),
(2, 'drama', 'sometexttt'),
(3, 'horror', 'sometexttt'),
(4, 'action', 'sometexttt'),
(5, 'comedy', 'sometexttt');

INSERT INTO `categories`
(`id`,
`category_name`,
`notes`)
VALUES
(1, 'block-buster', 'sometextt'),
(2, 'box-office', 'sometextt'),
(3, 'for kids', 'sometextt'),
(4, 'oscar-winning', 'sometextt'),
(5, 'block-buster', 'sometextt');

INSERT INTO `movies`.`movies`
(`id`,
`title`,
`director_id`,
`copyright_year`,
`length`,
`genre_id`,
`category_id`,
`rating`,
`notes`)
VALUES
(1, 'A good story', 2, 1998, 200.51, 2, 4, 6, 'sometext'),
(2, 'A bad story', 1, 2008, 185.51, 1, 4, 0, 'sometext'),
(3, 'A good story', 2, 1998, 200.00, 2, 4, 6, 'sometext'),
(4, 'A good story', 2, 1998, 200.76, 2, 4, 6, 'sometext'),
(5, 'A good story', 2, 1998, 200.21, 2, 4, 6, 'sometext');



