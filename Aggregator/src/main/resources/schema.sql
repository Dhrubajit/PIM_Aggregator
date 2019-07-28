DROP TABLE IF EXISTS product;

CREATE TABLE product ( 
	id INT(10) NOT NULL AUTO_INCREMENT, 
	version INT (50) NOT NULL, 
	uuid VARCHAR(200) NOT NULL UNIQUE, 
	name VARCHAR(50) NOT NULL, 
	description VARCHAR(200) NOT NULL, 
	provider VARCHAR(50) NOT NULL, 
	available VARCHAR(20) NOT NULL, 
	messuermentunit VARCHAR(50) NOT NULL, 
	createddate Date NOT NULL, 
	lastmodifieddate Date NOT NULL, 
	PRIMARY KEY (id) 
);
