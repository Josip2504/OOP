DROP DATABASE IF EXISTS frizerski;

CREATE DATABASE frizerski;

USE frizerski;

CREATE table korisnik (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table djelatnica (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table usluga (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table posjet (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	vrijeme date,
	korisnik_id int(50) UNSIGNED,
	djelatnica_id int(50) UNSIGNED,
	usluga_id int(50) UNSIGNED,
	PRIMARY KEY (ID),
	FOREIGN KEY (korisnik_id) REFERENCES korisnik(ID),
	FOREIGN KEY (djelatnica_id) REFERENCES djelatnica(ID),
	FOREIGN KEY (usluga_id) REFERENCES usluga(ID)
);

INSERT INTO korisnik(name) values
	("Josip"),
	("Marko"),
	("Ivan");

INSERT INTO djelatnica(name) values
	("Ana"),
	("Iva"),
	("Lucija");

INSERT INTO usluga(name) values
	("Sisanje"),
	("Pranje"),
	("Bojanje");

INSERT INTO posjet(vrijeme, korisnik_id, djelatnica_id, usluga_id) values
	("2022-01-23", 2, 1, 1),
	("2022-04-13", 1, 3, 2),
	("2022-07-12", 2, 2, 2),
	("2022-02-22", 3, 1, 3),
	("2022-12-04", 3, 1, 1),
	("2022-04-09", 1, 3, 1),
	("2022-06-19", 2, 2, 2),
	("2022-11-11", 1, 3, 1);