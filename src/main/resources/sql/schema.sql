
--
-- table : bb_event_tbl
--
CREATE TABLE bb_event_tbl (
	id INT NOT NULL AUTO_INCREMENT, 
	title VARCHAR(40) NOT NULL, 
	description VARCHAR(400) NOT NULL, 
	start VARCHAR(20) NOT NULL, 
	end VARCHAR(20) NOT NULL, 
	owner VARCHAR(20) NOT NULL, 
	status VARCHAR(10) NOT NULL, 
	CONSTRAINT pk_EVENTS PRIMARY KEY (id)
);
