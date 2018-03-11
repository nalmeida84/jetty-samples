CREATE SEQUENCE IF NOT EXISTS SEQ_GEN START WITH 1 INCREMENT BY 1;

insert into TM_ROLES (ID,NAME) values (NEXTVAL('SEQ_GEN'),'default_role');
insert into TM_ROLES (ID,NAME) values (NEXTVAL('SEQ_GEN'),'role_1');
insert into TM_ROLES (ID,NAME) values (NEXTVAL('SEQ_GEN'),'role_2');
insert into TM_ROLES (ID,NAME) values (NEXTVAL('SEQ_GEN'),'role_3');

insert into TM_USERS (ID,NAME) values (NEXTVAL('SEQ_GEN'),'user_1');
insert into TM_USERS (ID,NAME) values (NEXTVAL('SEQ_GEN'),'user_2');
insert into TM_USERS (ID,NAME) values (NEXTVAL('SEQ_GEN'),'user_3');

insert into TM_USERS_TM_ROLES (USER_ID,ROLE_ID) values (SELECT ID FROM TM_USERS WHERE NAME = 'user_1', SELECT ID FROM TM_ROLES WHERE NAME = 'role_1');
insert into TM_USERS_TM_ROLES (USER_ID,ROLE_ID) values (SELECT ID FROM TM_USERS WHERE NAME = 'user_1', SELECT ID FROM TM_ROLES WHERE NAME = 'role_2');