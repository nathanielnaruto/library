use library;

create table book (
		bno char(8) primary key,
		category char(10),
		title varchar(40),
		press varchar(30),
		year int,
		author varchar(20),
		price decimal(7,2),
		total int,
		stock int);


create table card (
		cno char(7) primary key,
		name varchar(10),
		department varchar(40),
		type char(1));

create table handler (
		hno char(7),
		password varchar(20),
		name varchar(10),
		contact varchar(20),
		primary key (hno));

create table borrow (
		cno char(7),
		bno char(8),
		borrow_date date,
		return_date date,
		hno char(7),
		foreign key (cno) references card(cno)
			on delete cascade
			on update cascade,
		foreign key (bno) references book(bno)
			on delete set null
			on update cascade,
		foreign key (hno) references handler(hno)
			on delete set null
			on update cascade);


