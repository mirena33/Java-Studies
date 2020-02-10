DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `salary` > 35000
ORDER BY `first_name`, `last_name`, `employee_id`;

END$$

CALL usp_get_employees_salary_above_35000();


DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(min_salary DECIMAL(19,4))
BEGIN

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `salary` >= min_salary
ORDER BY `first_name`, `last_name`, `employee_id`;

END$$

CALL usp_get_employees_salary_above(48100);




DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(starts_with VARCHAR(20))
BEGIN

SELECT `name` FROM `towns`
WHERE `name` LIKE CONCAT(starts_with, '%')
ORDER BY `name`;

END$$

CALL usp_get_towns_starting_with('b');


DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(20))
BEGIN

SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.address_id = a.address_id
JOIN `towns` AS t
ON a.town_id = t.town_id
WHERE t.`name` = town_name
ORDER BY  e.`first_name`, e.`last_name`, e.`employee_id`;

END$$

CALL usp_get_employees_from_town('Sofia');


DELIMITER$$
CREATE FUNCTION ufn_get_salary_level(salary_emp DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
DECLARE result VARCHAR(10);

IF salary_emp < 30000 THEN SET result := 'Low';
ELSEIF salary_emp BETWEEN 30000 AND 50000 THEN SET result := 'Average';
ELSE SET result := 'High';
END IF;

RETURN result;
END$$

SELECT ufn_get_salary_level(43300.00);



DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(`salary_level` VARCHAR(10))
BEGIN

SELECT `first_name`, `last_name` 
FROM `employees`
WHERE LOWER(ufn_get_salary_level(`salary`)) = `salary_level`
ORDER BY `first_name` DESC, `last_name` DESC;

END$$

CALL usp_get_employees_by_salary_level('high');



DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(`salary_level` DECIMAL(19,4))
BEGIN

SELECT ah.`first_name`, ah.`last_name`
FROM `account_holders` AS ah
JOIN `accounts` AS a
ON a.`account_holder_id` = ah.`id`
GROUP BY a.`account_holder_id`
HAVING SUM(`balance`)  > salary_level
ORDER BY a.`id`;

END$$

CALL usp_get_holders_with_balance_higher_than(7000);



DELIMITER$$
CREATE PROCEDURE usp_deposit_money(acc_id INT, money_amount DECIMAL(19,4))
BEGIN 
START TRANSACTION;
IF(money_amount <= 0) 
THEN ROLLBACK;

ELSE 
UPDATE `accounts`
SET `balance` = `balance` + money_amount
WHERE `id` = acc_id;
END IF;
COMMIT;

END$$

CALL usp_deposit_money(1, 100);



