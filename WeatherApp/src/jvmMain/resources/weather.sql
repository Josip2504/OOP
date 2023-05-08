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