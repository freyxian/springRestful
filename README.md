# springRestful
Spring Restful services with Hibernate and basic spring security
Here I am using HSQLDB run as server, as I am using DBPC connection pool.
Front side use ajax call.
Need use test case to insert user info into database, as password is encrypted.
GET for search, POST for insert, PUT for update, DEL for delete.

CREATE TABLE user_tbl (
   id BIGINT NOT NULL,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(256) NOT NULL,
   role binary(20) NOT NULL,
   status VARCHAR(20) NOT NULL,
  
   PRIMARY KEY (id)
);
ALTER TABLE user_tbl ADD UNIQUE (username);
ALTER TABLE user_tbl ADD CHECK (status = 'Activated' or status='Deactivated');

Spring framework 4, Hibernate 5
