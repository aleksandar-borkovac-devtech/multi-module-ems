INSERT INTO ems.authority values ('ROLE_ADMIN');
INSERT INTO ems.authority values ('ROLE_USER');
INSERT INTO ems.authority values ('ROLE_SUPERUSER');

INSERT INTO ems.customer VALUES ('1', 'borkke@gmail.com', 'Aleksandar', 'Borkovac', 'password', 'borkke');

INSERT INTO ems.customer_authority VALUES ('1', 'ROLE_ADMIN');
INSERT INTO ems.customer_authority VALUES ('1', 'ROLE_USER');