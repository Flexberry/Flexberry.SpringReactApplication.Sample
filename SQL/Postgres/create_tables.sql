CREATE TABLE testentity (

 primaryKey INTEGER NOT NULL,

 name VARCHAR(255) NULL,
 
 points INTEGER NULL,

 enabled BOOLEAN DEFAULT FALSE NOT NULL,

 PRIMARY KEY (primaryKey));

