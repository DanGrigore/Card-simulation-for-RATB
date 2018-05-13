CREATE TABLE `CARD` (
	`card_id` INT NOT NULL AUTO_INCREMENT,
	`card_money` INT,
	`expire_on` DATE,
	PRIMARY KEY (`card_id`)
);

CREATE TABLE `CARD_TYPE` (
	`Id` INT NOT NULL AUTO_INCREMENT,
	`pass_type` varchar(20) NOT NULL DEFAULT 'Cartela',
	`price` INT NOT NULL,
	`card_id` INT NOT NULL UNIQUE,
	PRIMARY KEY (`Id`)
);

CREATE TABLE `CLIENT` (
	`client_id` INT NOT NULL AUTO_INCREMENT,
	`card_id` INT,
	`first_name` varchar(20) NOT NULL,
	`last_name` varchar(20) NOT NULL,
	PRIMARY KEY (`client_id`)
);

CREATE TABLE `TRANSPORT` (
	`transport_id` INT NOT NULL AUTO_INCREMENT,
	`line` INT NOT NULL,
	`type` INT NOT NULL,
	`charge_per_trip` FLOAT NOT NULL DEFAULT '1.3',
	PRIMARY KEY (`transport_id`)
);

CREATE TABLE `VALIDATION` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`card_id` INT NOT NULL,
	`transport_id` INT NOT NULL,
	`date` DATE NOT NULL,
	`time` TIME NOT NULL,
	`transport_line` TIME NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `CARD_TYPE` ADD CONSTRAINT `CARD_TYPE_fk0` FOREIGN KEY (`card_id`) REFERENCES `CARD`(`card_id`);

ALTER TABLE `CLIENT` ADD CONSTRAINT `CLIENT_fk0` FOREIGN KEY (`card_id`) REFERENCES `CARD`(`card_id`);

ALTER TABLE `VALIDATION` ADD CONSTRAINT `VALIDATION_fk0` FOREIGN KEY (`card_id`) REFERENCES `CARD`(`card_id`);

ALTER TABLE `VALIDATION` ADD CONSTRAINT `VALIDATION_fk1` FOREIGN KEY (`transport_id`) REFERENCES `TRANSPORT`(`transport_id`);

