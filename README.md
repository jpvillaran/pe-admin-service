# pe-admin-service
Patriot Energy Group Admin Service

## Database
MySQL

### Databases to be created:
#### Rates database
``` SQL
create database pedb_rates_dev;
create user 'pedb_rates_user'@'localhost' identified by 'pedb_rates_user';
grant all on pedb_rates_dev.* to 'pedb_rates_user'@'localhost';
```

#### Security database
``` SQL
create database pedb_auth_dev;
create user 'pedb_auth_user'@'localhost' identified by 'pedb_auth_user';
grant all on pedb_auth_dev.* to 'pedb_auth_user'@'localhost';
```
