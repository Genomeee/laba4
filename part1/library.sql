connect 'dbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true", "root","1234"';

CREATE TABLE `authors` (
	`id` BIGINT(19,0) NOT NULL AUTO_INCREMENT,
	`name` CHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `books` (
	`id` BIGINT(19,0) NOT NULL AUTO_INCREMENT,
	`name` CHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `book_author` (
	`fk_book` BIGINT(19,0) NOT NULL,
	`fk_author` BIGINT(19,0) NOT NULL,
	PRIMARY KEY (`fk_book`, `fk_author`) USING BTREE,
	INDEX `FK_author` (`fk_author`) USING BTREE,
	CONSTRAINT `FK_author_book` FOREIGN KEY (`fk_author`) REFERENCES `library`.`authors` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `FK_book_author` FOREIGN KEY (`fk_book`) REFERENCES `library`.`books` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);


disconnect;
exit;
