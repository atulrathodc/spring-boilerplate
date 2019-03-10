use testdb;
drop table employee;
CREATE TABLE employee
( id int NOT NULL AUTO_INCREMENT,
  name varchar(225) NOT NULL,
  age varchar(225) ,
  salary varchar(225),
  PRIMARY KEY (id)
);
SELECT * FROM testdb.employee;