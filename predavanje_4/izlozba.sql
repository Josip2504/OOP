DROP database IF EXISTS izlozba;

CREATE database izlozba;

USE izlozba;

CREATE table kustos (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table sponzor (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE table izlozba (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID) REFERENCES kustos(ID),
	FOREIGN KEY (ID) REFERENCES sponzor(ID)
);

CREATE table djelo (
	ID int(50) UNSIGNED AUTO_INCREMENT NOT NULL,
	name varchar(255) NOT NULL,
	PRIMARY KEY (ID),
	izlozba_id int(50) UNSIGNED NOT NULL,
	FOREIGN KEY (izlozba_id) REFERENCES izlozba(ID)
);	