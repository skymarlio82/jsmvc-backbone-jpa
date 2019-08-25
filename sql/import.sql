-- ==============================
-- db script and data initializer
-- ==============================
create table events (
	-- for H2
	-- ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL, 
	-- for Mysql
	ID INT NOT NULL AUTO_INCREMENT, 
	TITLE VARCHAR(40) NOT NULL, 
	DESCRIPTION VARCHAR(400) NOT NULL, 
	START VARCHAR(20) NOT NULL, 
	END VARCHAR(20) NOT NULL, 
	OWNER VARCHAR(20) NOT NULL, 
	STATUS VARCHAR(10) NOT NULL, 
	CONSTRAINT pk_EVENTS PRIMARY KEY (ID)
);

insert into events (TITLE, DESCRIPTION, START, END, OWNER, STATUS) values ('UI Issue', 'Checkbox not pop up', '01/01/2017', '01/02/2017', 'Tom', 'Opening');
insert into events (TITLE, DESCRIPTION, START, END, OWNER, STATUS) values ('SQL Statement Error', 'Select syntax wrong', '02/01/2017', '02/02/2017', 'Jim', 'Opening');
insert into events (TITLE, DESCRIPTION, START, END, OWNER, STATUS) values ('Spring AOP No Dependency', 'JAR lib missed', '04/01/2017', '04/02/2017', 'Bob', 'Opening');
insert into events (TITLE, DESCRIPTION, START, END, OWNER, STATUS) values ('Java Null Point Error', 'Java Object not found', '03/01/2017', '03/02/2017', 'Joe', 'Opening');
