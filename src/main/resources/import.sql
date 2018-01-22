

INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (ID, NAME) VALUES (3, 'ROLE_STUFF');



INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));


INSERT INTO user_model (frist_name   , national_code , phone_number , email , address , user_type, user ,personal_number) VALUES ('rooz', 222 , 2222 ,'a@ss.c','sss',3 , 1,2222);
INSERT INTO user_model (frist_name   , national_code , phone_number , email , address , user_type, user) VALUES ('rooz', 222 , 2222 ,'a@ss.c','sss',1 , 2);

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);

INSERT INTO branch (address , phone ,city,code ) VALUES ('ss',555,'sss',858);

INSERT INTO card_req (stuff ,customer , branch , status ,FIRST) VALUES (1 ,2 ,1 ,'NOT_OPEN',1);