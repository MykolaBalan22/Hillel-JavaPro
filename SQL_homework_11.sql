CREATE TABLE user
(
user_id int not null auto_increment,
name varchar(20) not null default 'noname',
surname varchar(30) not null default 'nosurname',
date_of_registration date not null ,
primary key(user_id)
);

CREATE TABLE wallet
(
wallet_id int not null auto_increment,
currency varchar(20) not null,
amount bigint not null,
user_id int not null ,
created date not null ,
primary key(wallet_id),
foreign key(user_id) references user(user_id) on update cascade on delete cascade
);

insert into user
(name ,surname ,date_of_registration)
values
('Petro','Ivanov','2019-12-02'),
('Ivan','Semenov','2022-02-17'),
('Maria','Chesnokova' ,'20-12-02'),
('Mykola','Salo','2021-07-09'),
('Olga','Krasnova','2020-05-30');

insert into wallet
(currency ,amount ,user_id,created)
values
('Hryvnia',32434,2,'2015-09-23'),
('Peso',21836,3,'2017-02-26'),
('Dollar',239879,3,'2016-06-14'),
('Tenge',218379,5,'2020-03-20'),
('Yen',2445,4,'2022-06-03'),
('Hryvnia',2532,1,'2021-02-08'),
('Dollar',356,4,'2012-09-30'),
('Hryvnia',83456,1,'2018-10-22'),
('Euro',1903,2,'2019-01-14'),
('Euro',5986,5,'2013-04-16'),
('Euro',2166,3,'2014-12-28');

select name , currency ,amount from wallet inner join user on wallet.user_id=user.user_id ;