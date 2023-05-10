drop database if exists weather;

create database weather;

use weather;

create table users(
	id int unsigned auto_increment not null,
	username varchar(255) not null,
	password varchar(255) not null,
	location varchar(255) not null,
	primary key (id)
);

create table historys(
	id int unsigned auto_increment not null,
	user_id int unsigned not null,
	location varchar(255) not null,
	primary key (id),
	foreign key (user_id) references users(id)
);