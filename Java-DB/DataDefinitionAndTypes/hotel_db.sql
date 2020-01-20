CREATE SCHEMA `Hotel`;
CREATE TABLE `employees` (
    `id` INT NOT NULL PRIMARY KEY,
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
(1, 'petar', 'petrov', 'sir', 'sometextt'),
(2, 'petar', 'petrov', 'sir', 'sometextt'),
(3, 'petar', 'petrov', 'sir', 'sometextt');

CREATE TABLE `customers` (
    `account_number` INT NOT NULL PRIMARY KEY,
    `first_name` VARCHAR(45),
    `last_name` VARCHAR(45),
    `phone_number` INT(25),
    `emergency_name` VARCHAR(45),
    `emergency_number` INT(25),
    `notes` TEXT
);

INSERT INTO `customers`
(`account_number`,
`first_name`,
`last_name`,
`phone_number`,
`emergency_name`,
`emergency_number`,
`notes`)
VALUES
(515, 'petar', 'ivanov', 645645, 'galka', 2566, 'sometext'),
(525, 'petar', 'ivanov', 645645, 'galka', 2566, 'sometext'),
(535, 'petar', 'ivanov', 645645, 'galka', 2566, 'sometext');

CREATE TABLE `room_status`(
`room_status` VARCHAR(45) PRIMARY KEY,
`notes` TEXT
);

INSERT INTO `room_status`
(`room_status`,
`notes`)
VALUES
('free', 'some rooms'),
('not free', 'some rooms'),
('occupied', 'some rooms');


CREATE TABLE `room_types`(
`room_types` VARCHAR(45) PRIMARY KEY,
`notes` TEXT
);

INSERT INTO `room_types`
(`room_types`,
`notes`)
VALUES
('small', 'text'),
('big', 'text'),
('medium', 'text');

CREATE TABLE `bed_types`(
`bed_types` VARCHAR(45) PRIMARY KEY,
`notes` TEXT
);

INSERT INTO `bed_types`
(`bed_types`,
`notes`)
VALUES
('s', 'text'),
('m', 'text'),
('l', 'text');


CREATE TABLE `rooms` (
    `room_number` INT(25) PRIMARY KEY,
    `room_type` VARCHAR(45),
    `bed_type` VARCHAR(45),
    `rate` INT(25),
    `room_status` VARCHAR(45),
    `notes` TEXT,
    CONSTRAINT fk_rooms_room_types FOREIGN KEY (`room_type`)
        REFERENCES `room_types` (`room_types`),
    CONSTRAINT fk_rooms_bed_types FOREIGN KEY (`bed_type`)
        REFERENCES `bed_types` (`bed_types`),
    CONSTRAINT fk_rooms_room_status FOREIGN KEY (`room_status`)
        REFERENCES `room_status` (`room_status`)
);

INSERT INTO `rooms`
(`room_number`,
`room_type`,
`bed_type`,
`rate`,
`room_status`,
`notes`)
VALUES
(1, 'small', 's', 5, 'free', 'text'),
(2, 'small', 's', 5, 'free', 'text'),
(3, 'small', 's', 5, 'free', 'text');


CREATE TABLE `payments`(
`id` INT NOT NULL PRIMARY KEY,
`employee_id` INT NOT NULL,
`payment_date` DATE,
`account_number` INT NOT NULL,
`first_date_occupied` DATE,
`last_date_occupied` DATE,
`total_days` INT,
`amount_charged` DOUBLE,
`tax_rate` INT,
`tax_amount` INT,
`payment_total`INT,
`notes` TEXT,

CONSTRAINT fk_payments_employees FOREIGN KEY `payments`(`employee_id`)
REFERENCES `employees`(`id`),
CONSTRAINT fk_payments_customers FOREIGN KEY `payments`(`account_number`)
REFERENCES `customers`(`account_number`)
);

INSERT INTO `payments`
(`id`,
`employee_id`,
`payment_date`,
`account_number`,
`first_date_occupied`,
`last_date_occupied`,
`total_days`,
`amount_charged`,
`tax_rate`,
`tax_amount`,
`payment_total`,
`notes`)
VALUES
(1, 1, '2019-01-01', 515, '2019-01-02', '2019-01-03', 10, 256, 20, 200, 300, 'text'),
(2, 1, '2019-01-01', 515, '2019-01-02', '2019-01-03', 10, 256, 20, 200, 300, 'text'),
(3, 1, '2019-01-01', 515, '2019-01-02', '2019-01-03', 10, 256, 20, 200, 300, 'text');


CREATE TABLE `occupancies` (
    `id` INT NOT NULL PRIMARY KEY,
    `employee_id` INT NOT NULL,
    `date_occupied` DATE,
    `account_number` INT NOT NULL,
    `room_number` INT(25),
    `rate_applied` INT,
    `phone_charge` INT,
    `notes` TEXT,
    CONSTRAINT fk_occupancies_employees FOREIGN KEY (`employee_id`)
        REFERENCES `employees` (`id`),
    CONSTRAINT fk_occupancies_customers FOREIGN KEY (`account_number`)
        REFERENCES `customers` (`account_number`),
    CONSTRAINT fk_occupancies_rooms FOREIGN KEY (`room_number`)
        REFERENCES `rooms` (`room_number`)
);

INSERT INTO `occupancies`
(`id`,
`employee_id`,
`date_occupied`,
`account_number`,
`room_number`,
`rate_applied`,
`phone_charge`,
`notes`)
VALUES
(1, 2, '2019-01-05', 515, 3, 25, 14, 'text'),
(2, 2, '2019-01-05', 515, 3, 25, 14, 'text'),
(3, 2, '2019-01-05', 515, 3, 25, 14, 'text');

select tax_rate*0.97 from payments;

TRUNCATE occupancies;

