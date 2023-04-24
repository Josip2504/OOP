DROP database IF EXISTS animal_owners;

CREATE database animal_owners;

USE animal_owners;

CREATE table owners (
	id INT(255) UNSIGNED AUTO_INCREMENT NOT NULL,
	name VARCHAR(255) NOT NULL, 
	PRIMARY KEY (id)
);

CREATE table animals (
	id INT(255) UNSIGNED AUTO_INCREMENT NOT NULL,
	name VARCHAR(255) NOT NULL, 
	owner_id INT(255) UNSIGNED NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (owner_id) references owners(id)
);

INSERT INTO owners(name) VALUES ("Matej");
INSERT INTO owners(name) VALUES ("Pero");
INSERT INTO owners(name) VALUES ("Ivo");

INSERT INTO animals(name, owner_id) VALUES ("Zuco", 1);
INSERT INTO animals(name, owner_id) VALUES ("Fluffy", 2);
INSERT INTO animals(name, owner_id) VALUES ("Garo", 3);