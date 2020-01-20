CREATE schema `car_rental`;
CREATE TABLE `categories` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `category` VARCHAR(45) NOT NULL,
    `daily_rate` INT,
    `weekly_rate` INT,
    `monthly_rate` INT,
    `weekend_rate` INT
);

INSERT INTO `categories`
(`id`,
`category`,
`daily_rate`,
`weekly_rate`,
`monthly_rate`,
`weekend_rate`)
VALUES
(1, 'big cars', 1,2,3,4),
(2, 'big cars', 1,2,3,4),
(3, 'big cars', 1,2,3,4);

CREATE TABLE `cars` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `plate_number` INT,
    `make` VARCHAR(45),
    `model` VARCHAR(45),
    `car_year` INT,
    `category_id` INT,
    `doors` INT,
    `picture` BLOB,
    `car_condition` VARCHAR(10),
    `available` VARCHAR(45),
    
    CONSTRAINT `fk_cars_categories` FOREIGN KEY `cars`(`category_id`)
    REFERENCES `categories`(`id`)
);

INSERT INTO `cars`
(`id`,
`plate_number`,
`make`,
`model`,
`car_year`,
`category_id`,
`doors`,
`picture`,
`car_condition`,
`available`)
VALUES
(1, 4556, 'ferrari', 'g59', 2018, 2, 5, 'somepics', 'brand new', 'yes'),
(2, 4556, 'ferrari', 'g59', 2018, 2, 5, 'somepics', 'brand new', 'yes'),
(3, 4556, 'ferrari', 'g59', 2018, 2, 5, 'somepics', 'brand new', 'yes');

CREATE TABLE `employees`(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(45),
`last_name` VARCHAR(45),
`title` VARCHAR(45),
`notes` TEXT
);

INSERT INTO `employees`
(`id`,
`first_name`,
`last_name`,
`title`,
`notes`)
VALUES
(1, 'pesho', 'petrov', 'sir', 'sometext'),
(2, 'pesho', 'petrov', 'sir', 'sometext'),
(3, 'pesho', 'petrov', 'sir', 'sometext');

CREATE TABLE `customers`(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`driver_licence_number` INT,
`full_name` VARCHAR(45),
`address` VARCHAR(45),
`city` VARCHAR(45),
`zip_code` INT,
`notes` TEXT
);

INSERT INTO `customers`
(`id`,
`driver_licence_number`,
`full_name`,
`address`,
`city`,
`zip_code`,
`notes`)
VALUES
(1, 6569464, 'petar petrov', 'gorska iglika', 'sofa', 1100, 'sometext'),
(2, 6569464, 'petar petrov', 'gorska iglika', 'sofa', 1100, 'sometext'),
(3, 6569464, 'petar petrov', 'gorska iglika', 'sofa', 1100, 'sometext');

CREATE TABLE `rental_orders` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `employee_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `car_id` INT NOT NULL,
    `car_condition` VARCHAR(45),
    `tank_level` INT,
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` INT,
    `rate_applied` INT,
    `tax_rate` INT,
    `order_status` VARCHAR(45),
    `notes` TEXT,
    CONSTRAINT `fk_rental_orders_employees` FOREIGN KEY (`employee_id`)
        REFERENCES `employees` (`id`),
    CONSTRAINT `fk_rental_orders_customers` FOREIGN KEY (`customer_id`)
        REFERENCES `customers` (`id`),
    CONSTRAINT `fk_rental_orders_cars` FOREIGN KEY (`car_id`)
        REFERENCES `cars` (`id`)
);


INSERT INTO `rental_orders`
(`id`,
`employee_id`,
`customer_id`,
`car_id`,
`car_condition`,
`tank_level`,
`kilometrage_start`,
`kilometrage_end`,
`total_kilometrage`,
`start_date`,
`end_date`,
`total_days`,
`rate_applied`,
`tax_rate`,
`order_status`,
`notes`)
VALUES
(1, 2, 3, 4, 'good', 500, 0, 2000, 3000, '2019-01-02', '2019-02-01', 50, 7, 20, 'active', 'sometext'),
(2, 2, 3, 4, 'good', 500, 0, 2000, 3000, '2019-01-02', '2019-02-01', 50, 7, 20, 'active', 'sometext'),
(3, 2, 3, 4, 'good', 500, 0, 2000, 3000, '2019-01-02', '2019-02-01', 50, 7, 20, 'active', 'sometext');







