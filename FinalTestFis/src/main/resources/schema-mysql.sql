CREATE DATABASE  IF NOT EXISTS test02;
USE test02;
drop table if exists orders ;
create table orders(
	id smallint primary key auto_increment,
	order_no varchar(20) unique ,
	user_id smallint,
	amount double,
	order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	status smallint,
	customer_name varchar (50)
);

drop table if exists order_line;
create table order_line (
    id smallint primary key auto_increment,
    order_id smallint ,
    product_name varchar(50),
    quantity int,
    amount double
);

drop table if exists users;
create table users (
    id smallint primary key auto_increment,
    user_name char (20) unique ,
    password char(20),
    full_name varchar (50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    last_login timestamp
);

drop table if exists roles;
create table roles (
    id smallint primary key auto_increment,
    role_name varchar (50),
    description varchar (200),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
    user_id smallint  NOT NULL,
    role_id smallint  NOT NULL,
    PRIMARY KEY (user_id,role_id)
);





