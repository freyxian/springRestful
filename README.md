# springRestful
Spring Restful services with Hibernate/HSQLDB and basic spring security. 

Here I am using HSQLDB run as server, as I am using DBPC connection pool.

java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/TestDB --dbname.0 UXPTestDB

CREATE TABLE user_tbl (
   id BIGINT NOT NULL,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(256) NOT NULL,
   role VARCHAR(20) NOT NULL,
   status VARCHAR(20) NOT NULL,
  
   PRIMARY KEY (id)
);

ALTER TABLE user_tbl ADD UNIQUE (username);

ALTER TABLE user_tbl ADD CHECK (status = 'Activated' or status='Deactivated');

Test only can run once to avoid primary key impact. If want to run test again, please clean table data first.

Front side use ajax call, entry URL is http://localhost:8080/assignment/info. user id "aac", password "123".

GET button for search user info by user id, POST button for insert new user, PUT button for update user info, DELETE button for delete user by user id.