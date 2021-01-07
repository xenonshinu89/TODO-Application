INSERT INTO users(username,password,enabled)
values('test','pwd123',true);

INSERT INTO users(username,password,enabled)
values('test2','pwd1234',true);

INSERT INTO users(username,password,enabled)
values('admin','admpwd123',true);

INSERT into authorities(username,authority)
values('test','ROLE_USER');

INSERT into authorities(username,authority)
values('test2','ROLE_USER');

INSERT into authorities(username,authority)
values('admin','ROLE_ADMIN');

