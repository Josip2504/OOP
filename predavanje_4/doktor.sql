DROP database IF EXISTS doktor;

CREATE database doktor;

USE doktor;

CREATE table pacjenti (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table sestre (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table ljecenje (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	pacjent_id int(50) UNSIGNED NOT NULL,
	datum_ljecenja dateTime,
	PRIMARY KEY (ID),
	FOREIGN KEY (pacjent_id) REFERENCES pacjenti (ID)
);

CREATE table sestre_ljecenje (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	sestre_id int(50) UNSIGNED NOT NULL,
	ljecenje_id int(50) UNSIGNED NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (sestre_id) REFERENCES sestre (ID),
	FOREIGN KEY (ljecenje_id) REFERENCES ljecenje (ID)
);

INSERT INTO sestre(name) values ("Ana");
INSERT INTO sestre(name) values ("Iva");
INSERT INTO pacjenti(name) values ("Marko");
INSERT INTO ljecenje(pacjent_id, datum_ljecenja) values (1, "2023-03-16 12:42:43");
INSERT INTO sestre_ljecenje(sestre_id, ljecenje_id) values (1, 1);
INSERT INTO sestre_ljecenje(sestre_id, ljecenje_id) values (2, 1);