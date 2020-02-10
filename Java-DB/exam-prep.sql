CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(30) NOT NULL
);

CREATE TABLE `articles`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	`content` TEXT NOT NULL,
	`category_id` INT,

CONSTRAINT fk_articles_categories 
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`)
);

CREATE TABLE `users` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) UNIQUE NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `email` VARCHAR(50) NOT NULL
);


CREATE TABLE `users_articles`(
`user_id` INT,
`article_id` INT,

CONSTRAINT fk_users_articles_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),

CONSTRAINT fk_users_articles_articles
FOREIGN KEY (`article_id`)
REFERENCES `articles`(`id`)
);


CREATE TABLE `comments`(
   `id` INT PRIMARY KEY AUTO_INCREMENT,
   `comment` VARCHAR(255) NOT NULL,
   `article_id` INT NOT NULL,
   `user_id` INT NOT NULL,
   
   CONSTRAINT fk_comments_articles
   FOREIGN KEY (`article_id`)
   REFERENCES `articles`(`id`),
   
   CONSTRAINT fk_comments_users
   FOREIGN KEY (`user_id`)
   REFERENCES `users`(`id`)
);

CREATE TABLE `likes` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `article_id` INT,
    `comment_id` INT,
    `user_id` INT NOT NULL,
    
    CONSTRAINT fk_likes_articles
    FOREIGN KEY (`article_id`)
    REFERENCES `articles`(`id`),
    
	CONSTRAINT fk_likes_comments
    FOREIGN KEY (`comment_id`)
    REFERENCES `comments`(`id`),
    
	CONSTRAINT fk_likes_users
    FOREIGN KEY (`user_id`)
    REFERENCES `users`(`id`)
);






INSERT INTO `likes`(`article_id`, `comment_id`, `user_id`)
SELECT
IF(u.`id` % 2 = 0, CHAR_LENGTH(u.`username`), null),
IF(u.`id` % 2 = 1, CHAR_LENGTH(u.`email`), null),
u.`id`
FROM `users` AS u
WHERE u.`id` BETWEEN 16 AND 20;






UPDATE `comments` AS c
SET `comment` = (
CASE
WHEN c.`id` % 2 = 0 THEN 'Very good article.'
WHEN c.`id` % 3 = 0 THEN 'This is interesting.'
WHEN c.`id` % 5 = 0 THEN 'I definitely will read the article again.'
WHEN c.`id` % 7 = 0 THEN 'The universe is such an amazing thing.'
ELSE c.`comment`
END
)
WHERE c.`id` BETWEEN 1 AND 15;





DELETE FROM `articles`
WHERE `category_id` IS NULL;




SELECT nt.`title`, nt.`summary` 
FROM
(SELECT a.`id`, a.`title`, CONCAT(LEFT(a.`content`, 20), '...') AS 'summary'
FROM `articles` AS a
ORDER BY CHAR_LENGTH(a.`content`) DESC
LIMIT 3) AS nt
ORDER BY nt.`id`;





SELECT a.`id`, a.`title`
FROM `articles` AS a
JOIN `users_articles` AS ua
ON ua.`article_id` = a.`id`
WHERE ua.`user_id` = ua.`article_id`
ORDER BY a.`id`;




SELECT c.`category`, COUNT(DISTINCT a.`id`) AS 'article_count' , COUNT(l.`id`) AS 'likes_count'
FROM `categories` AS c
LEFT JOIN `articles` AS a
ON c.`id` = a.`category_id`
LEFT JOIN `likes` AS l
ON a.`id` = l.`article_id`
GROUP BY c.`category`
ORDER BY `likes_count` DESC, `article_count` DESC, c.`id`;





SELECT a.`title`, COUNT(comm.`id`) AS 'c_count'
FROM `articles` AS a
JOIN `categories` AS c
ON c.`id` = a.`category_id`
JOIN `comments` AS comm
ON comm.`article_id` = a.`id`
WHERE c.`category` = 'Social'
GROUP BY a.`id`
ORDER BY `c_count` DESC
LIMIT 1;




SELECT CONCAT(LEFT(c.`comment`, 20), '...') AS 'summary'
FROM `comments` AS c
LEFT JOIN `likes` AS l
ON c.`id` = l.`comment_id`
WHERE l.`comment_id` IS NULL
ORDER BY c.`id` DESC;




DELIMITER $$
CREATE FUNCTION udf_users_articles_count(p_username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE result INT;

SET result := (

SELECT COUNT(ua.`article_id`)
FROM `users_articles` AS ua
RIGHT JOIN `users` AS u
ON u.`id` = ua.`user_id`
WHERE u.`username` = p_username
);

RETURN result;
END $$




DELIMITER $$
CREATE PROCEDURE udp_like_article(p_username VARCHAR(30), p_title VARCHAR(30))
BEGIN

IF((SELECT COUNT(*) FROM `users` AS u WHERE u.`username` = p_username) = 0)
THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent user.';
ROLLBACK;

ELSEIF((SELECT COUNT(*) FROM `articles` AS a WHERE a.`title` = p_title) = 0)
THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Non-existent article.';
ROLLBACK;

ELSE

INSERT INTO `likes`(article_id, comment_id, user_id)
SELECT 
	(SELECT id FROM articles WHERE title = p_title),
	NULL,
	(SELECT id FROM users WHERE username = p_username);

END IF;
END $$
