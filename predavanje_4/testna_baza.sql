DROP database IF EXISTS vlasnici_zivotinja;

CREATE database vlasnici_zivotinja;

USE vlasnici_zivotinja;

CREATE table Persons (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table Animals (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name VARCHAR(50) NOT NULL,
	dateOfBirth DATE,
	prerson_id int(50) UNSIGNED,
	PRIMARY KEY (ID),
	FOREIGN KEY (prerson_id) REFERENCES Persons(ID)
);

INSERT INTO Persons(name) valuse ("Matej");
INSERT INTO Persons(name) valuse ("Ivo");
INSERT INTO Persons(name) valuse ("Pero");

INSERT INTO Animals(name, dateOfBirth, prerson_id) valuse ("zuco", NULL, 1);
INSERT INTO Animals(name, dateOfBirth, prerson_id) valuse ("garo", NULL, 2);