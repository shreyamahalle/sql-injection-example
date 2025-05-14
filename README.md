# sql-injection-example

## Initial setup for application to run
Pls set below properties in application.properties as per your mysql database setup.
```properties
application.mysql.username=root
application.mysql.password=admin
application.mysql.database-name=demodb
```

## Create table in your database
```sql
create table credentials(
username varchar(128) not null,
password varchar(128) not null
);
```

## Insert data into table
```sql
insert into credentials(username, password) values ('superuser', 'superuser'), ('admin', 'admin');
```

## How to build
```shell
mvn clean install
```

## How to run
```shell
mvn spring-boot:run
```

## How to test?

### Pls test insecure login

Please open http://localhost:8080/index.html in browser and provide the values as below:

<b>Username: `dummy`<br/>
Password: `' or '1'='1`<b>

### Pls test SECURE login
Please open http://localhost:8080/securelogin.html in browser and provide the values as below:

<b>Username: `dummy`<br/>
Password: `' or '1'='1`<b>