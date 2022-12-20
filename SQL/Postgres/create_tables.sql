CREATE TABLE testentity (

 primaryKey UUID NOT NULL,

 name VARCHAR(255) NULL,
 
 points INTEGER NULL,

 enabled BOOLEAN DEFAULT FALSE NOT NULL,

 PRIMARY KEY (primaryKey));
 
 
 CREATE TABLE customer (

 primarykey UUID NOT NULL,

 name VARCHAR(255) NULL,
 
 age INTEGER NULL,

 PRIMARY KEY (primarykey));
 
 
 CREATE TABLE comment (

 primarykey UUID NOT NULL,

 commentdate timestamp NULL,
 
 commenttext VARCHAR(255) NULL,
 
 customer_id UUID REFERENCES customer(primarykey),

 PRIMARY KEY (primarykey));

