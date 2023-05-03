drop database if exists zaposelnici;

create database zaposelnici;

use zaposelnici;

create table user(
	id int unsigned auto_increment not null,
	name varchar(255) not null,
	primary key (id)
);

create table odjel(
	id int unsigned auto_increment not null,
	name varchar(255) not null,
	user_id int unsigned not null,
	primary key (id),
	foreign key (user_id) references user(id)
);