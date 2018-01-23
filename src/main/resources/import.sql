
/*ROLE DEFINE */
INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (ID, NAME) VALUES (3, 'ROLE_STUFF');


/*Auth DEFINE*/
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (1, 'stuff1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (2, 'user1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (3, 'stuff2', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (4, 'user2', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (5, 'stuff3', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (6, 'user3', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (7, 'stuff4', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (8, 'admin1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));

/* ASSIGN ROLE */
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (4, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (5, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (6, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (7, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (8, 2);
/*BRANCH DEFINE*/
INSERT INTO branch (address , phone ,city,code ) VALUES ('shiraz',44286981,'shiraz',5863);
INSERT INTO branch (address , phone ,city,code ) VALUES ('tehran',44286981,'tehran',5864);
INSERT INTO branch (address , phone ,city,code ) VALUES ('mashhad',44286981,'mashhad',5865);

/*USER DEFINE*/
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user , personal_number , type , branch) VALUES ('razavi', '0018601375'  , '09392262950' ,'razavi_rohani@yahoo.com','shiraz',3 , 1 , 2437 , 'NORMAL' , 1);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('rohani', '0018601376'  , '09392262951' ,'razavi_rohanii@yahoo.com','shiraz',1 , 2 );
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user , personal_number , type , branch) VALUES ('ebrahimi', '0018601378'  , '09392262952' ,'razavi_rohanii@yahoo.com','tehran',3 , 3 , 2439 , 'NORMAL' , 3);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('kiani', '0018601379'  , '09392262958' ,'razavi_rohaniii@yahoo.com','mashhad',1 , 4 );
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user , personal_number , type , branch) VALUES ('mohamadi', '0018601380' , '09392262959' ,'razavi_rohaniii@yahoo.com','tabriz',3 , 5 , 2580 , 'HEAD' , 3);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('motahari', '0018601325' , '09392262978' ,'razavi_rohaniiii@yahoo.com','tabriz',1 , 6);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user , personal_number , type , branch) VALUES ('taheri', '00186012580' , '09992262959' ,'razavi_rohaniiiii@yahoo.com','tabriz',3 , 7 , 8976 ,'NORMAL' , 2);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('ahmadi', '0017901380' , '09392266559' ,'razavi_rohaniiiii@yahoo.com','tabriz',2 , 8);


/*ACCOUNT STATUS DEFINE*/
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('BLOCKED' , PARSEDATETIME('01-09-2016', 'dd-MM-yyyy') , PARSEDATETIME('01-02-2017', 'dd-MM-yyyy') , 'درخواست مشتری');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('BLOCKED' , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'بدهی');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'بدهی');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2013', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('BLOCKED' , PARSEDATETIME('01-01-2012', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'بدهی');

/*ACCOUNT DEFINE*/
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275855' , 250000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2  , 'INDIVISUAL' , 'REAL' , 0 , 'GHARZ' , 1 , 2 , 1 , null);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275852' , 952000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2  , 'INDIVISUAL' , 'LAWY' , 1 , 'SEPORDE_KOTAH' , 2 , 3 , 3 , 90);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275853' , 759000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2  , 'GROUP' , 'REAL' , 1 , 'SEPORDE_BOLAND' , 3 , 3 , 1 , 24);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275854' , 45000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 4  , 'INDIVISUAL' , 'REAL' , 1 , 'JARI' , 4 , 2 , 5 , null);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275890' , 852000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 4  , 'INDIVISUAL' , 'LAWY' , 0 , 'SEPORDE_KOTAH' , 5 , 2 , 5 , 90);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275856' , 458700.0 , null , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 4  , 'GROUP' , 'REAL' , 0 , 'GHARZ' , 6 , 1 , 5 , null);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275857' , 77000.0 , null , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 6  , 'INDIVISUAL' , 'REAL' , 0 , 'JARI' , 7 , 2 , 3 , null);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275858' , 965000.0 , null , PARSEDATETIME('01-11-2017', 'dd-MM-yyyy') , 6  , 'INDIVISUAL' , 'REAL' , 1 , 'SEPORDE_KOTAH' , 8 , 1 , 1 , 120);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275859' , 4782000.0 , null , PARSEDATETIME('21-05-2017', 'dd-MM-yyyy') , 6  , 'INDIVISUAL' , 'REAL' , 0 , 'JARI' , 9 , 1 , 7 , null);

/*ACCESS CARD DEFINE*/
INSERT INTO access_card (is_active , access_card_number , second_password , expire_date , cvv2 ,branch , start , end , account) VALUES (1 , '610433784658588' , '987654321' , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 022 ,1, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , null , 1 );
INSERT INTO access_card (is_active , access_card_number , second_password , expire_date , cvv2 ,branch , start , end , account) VALUES (1 , '610783784658589' , '98871654321' , PARSEDATETIME('01-01-2020', 'dd-MM-yyyy') , 032 , 2 ,PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , null , 4 );
INSERT INTO access_card (is_active , access_card_number , second_password , expire_date , cvv2 ,branch , start , end , account) VALUES (1 , '610783784658590' , '9887165821' , PARSEDATETIME('01-01-2021', 'dd-MM-yyyy') , 079 , 3 ,PARSEDATETIME('01-01-2013', 'dd-MM-yyyy') , null , 7 );

/*ACCOUNT FLOW DEFINE*/
INSERT INTO account_flow ( account  , type , date , amount) VALUES ( 1 , 'KHARID_POZ',PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 28800.7);
INSERT INTO account_flow ( account , type , date , amount) VALUES ( 2 , 'KHARID_INTERNET' ,PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 28548400.7);
INSERT INTO account_flow ( account  , type , date ,amount ) VALUES ( 3  ,'VARIZ_NAGHD' ,PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 28452000.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 2  , 'KHARID_POZ' ,PARSEDATETIME('05-01-2016', 'dd-MM-yyyy') , 2880000.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 3  , 'KHARID_INTERNET' ,PARSEDATETIME('04-08-2016', 'dd-MM-yyyy') , 28800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 4  , 'KHARID_INTERNET' ,PARSEDATETIME('04-08-2017', 'dd-MM-yyyy') , 28800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 4  , 'VARIZ_NAGHD' ,PARSEDATETIME('04-08-2015', 'dd-MM-yyyy') , 288000.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 3  , 'KHARID_INTERNET' ,PARSEDATETIME('04-18-2015', 'dd-MM-yyyy') , 27800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 7  , 'KHARID_INTERNET' ,PARSEDATETIME('04-28-2016', 'dd-MM-yyyy') , 56800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 8  , 'PAYBILL' ,PARSEDATETIME('14-08-2014', 'dd-MM-yyyy') , 288500.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 6  , 'VARIZ_NAGHD' ,PARSEDATETIME('24-08-2016', 'dd-MM-yyyy') , 758800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 6  , 'PAYBILL' ,PARSEDATETIME('28-08-2013', 'dd-MM-yyyy') , 96800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 5  , 'KHARID_POZ' ,PARSEDATETIME('04-08-2016', 'dd-MM-yyyy') , 78800.7);
INSERT INTO account_flow ( account  , type , date ,amount) VALUES ( 9  , 'PAYBILL' ,PARSEDATETIME('12-08-2016', 'dd-MM-yyyy') , 938800.7);

/*CHECKBOOK DEFINE*/
INSERT INTO checkbook (number , count , expire , account) VALUES (991023 , 10 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 2);
INSERT INTO checkbook (number , count , expire , account) VALUES (991024 , 10 , PARSEDATETIME('01-01-2013', 'dd-MM-yyyy') , 3);
INSERT INTO checkbook (number , count , expire , account) VALUES (991025 ,  10 , PARSEDATETIME('01-01-2022', 'dd-MM-yyyy') , 4)
INSERT INTO checkbook (number , count , expire , account) VALUES (991026 , 10 , PARSEDATETIME('01-01-2021', 'dd-MM-yyyy') , 8)
INSERT INTO checkbook (number , count , expire , account) VALUES (991027 , 10 , PARSEDATETIME('01-01-2023', 'dd-MM-yyyy') , 3)

/*CHECK DEFINE TODO EMBEDDED ID */
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104850 , 991023 , 1 , 24000.0, PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104851 , 991023 , 1 , 580000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104852 , 991023 , 1 , 74000.0, PARSEDATETIME('01-02-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104853 , 991023 , 1 , 0 , PARSEDATETIME('03-01-2019', 'dd-MM-yyyy') , 'NOT_USE' , 'رضوی ');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104854 , 991023 , 1 , 74000.0, PARSEDATETIME('05-01-2019', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104855 , 991023 , 1 , 4000.0, PARSEDATETIME('11-01-2019', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104856 , 991023 , 1 , 774000.0, PARSEDATETIME('01-09-2019', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104857 , 991023 , 1 , 0 , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104858 , 991023 , 1 , 23000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104859 , 991023 , 1 , 49000.0, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');

INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 111760 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104851 , 991024 , 2 ,  0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104852 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104853 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104854 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104855 , 991024 , 2 ,  0 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104856 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 'PASS' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104857 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'REJECTED' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104858 , 991024 , 2 , 0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104859 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');

INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 111770 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104871 , 991025 , 3 ,  0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104872 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104873 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104874 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104875 , 991025 , 3 , 0 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104876 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 'PASS' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104877 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'REJECTED' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104878 , 991025 , 3 ,  0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104879 , 991025 , 3 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');

INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 181760 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184851 , 991026 , 4 , 0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184852 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184853 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184854 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184855 , 991026 , 4 , 0 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184856 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 'PASS' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184857 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'REJECTED' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184858 , 991026 , 4 , 0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 184859 , 991026 , 4 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');

INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 141760 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144851 , 991027 , 5 , 0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144852 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144853 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144854 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144855 , 991027 , 5 , 0 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144856 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 'PASS' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144857 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'REJECTED' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144858 , 991027 , 5 ,  0 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 144859 , 991027 , 5 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');

/*DRAFT DEFINE*/

INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (2 , 3 , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 52150000.0 , 'خرید لامپ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 4 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 216200.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (4 , 1 , PARSEDATETIME('01-04-2015', 'dd-MM-yyyy') , 247100.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 2 , PARSEDATETIME('09-07-2015', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (4 , 4 , PARSEDATETIME('07-11-2016', 'dd-MM-yyyy') , 254500.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 4 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 7860000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (2 , 4 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2005540.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (7 , 9 , PARSEDATETIME('01-11-2014', 'dd-MM-yyyy') , 27000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (8 , 7 , PARSEDATETIME('01-01-2013', 'dd-MM-yyyy') , 2440000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (2 , 7 , PARSEDATETIME('01-01-2012', 'dd-MM-yyyy') , 9560000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (6 , 1 , PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 6360000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 6 , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 1460000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (9 , 4 , PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 9360000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (4 , 6 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 660000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (1 , 7 , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 360000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (8 , 1 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 660000.0 , 'پرداخت شارژ' , 'INTERNET');


/*REQUEST RESPONSE DEFINE */
INSERT INTO request_response (is_accept , answer_time , for_why , day_required_for_ready)  VALUES (1 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , null , 14 );
INSERT INTO request_response (is_accept , answer_time , for_why , day_required_for_ready)  VALUES (0 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'بدهی' , 0 );
INSERT INTO request_response (is_accept , answer_time , for_why , day_required_for_ready)  VALUES (1 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , null , 20 );
INSERT INTO request_response (is_accept , answer_time , for_why , day_required_for_ready)  VALUES (0 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'بدهی' , 0 );
INSERT INTO request_response (is_accept , answer_time , for_why , day_required_for_ready)  VALUES (1 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , null , 7 )


/*ACCESS CARD REQUEST DEFINE 1 4 7 */
INSERT INTO card_req (stuff ,account  , status ,FIRST) VALUES (1 ,6  ,'NOT_OPEN',1);
INSERT INTO card_req (stuff ,account  , status ,FIRST) VALUES (3 ,3  ,'NOT_OPEN',1);
INSERT INTO card_req (stuff ,account  , status ,FIRST) VALUES (5 ,5  ,'NOT_OPEN',1);
INSERT INTO card_req (stuff ,account , status ,FIRST , response) VALUES (5 , 7 ,'ACCEPT',1 , 1);



/*FACILITY REQUEST DEFINE  2 4 9 */
INSERT INTO facility_req (stuff , account , status , title , cash , waranty) VALUES (1 , 3 , 'NOT_OPEN' , 'MASKANE_HEYATE_ELMI' , 'RIAL' , 'CASH');
INSERT INTO facility_req (stuff , account , status , title , cash , waranty) VALUES (3 , 5 , 'NOT_OPEN' , 'MASKANE_NOKHBEGAN' , 'RIAL' , 'SANAD');
INSERT INTO facility_req (stuff , account , status , title , cash , waranty , response) VALUES (5 , 6 , 'REJECTED' , 'SARMAYE_DAR_GOSTARESH' , 'DOLLAR' , 'CASH' , 2);
INSERT INTO facility_req (stuff , account , status , title , cash , waranty) VALUES (7 , 7 , 'NOT_OPEN' , 'MASKANE_HEYATE_ELMI' , 'RIAL' , 'SANAD');
INSERT INTO facility_req (stuff , account , status , title , cash , waranty , response) VALUES (3 , 8 , 'ACCEPT' , 'BONGAH_KOCHIK_MOTEVASET' , 'DOLLAR' , 'WITHOUT_WARANTY' , 3);
INSERT INTO facility_req (stuff , account , status , title , cash , waranty) VALUES (1 , 3 , 'NOT_OPEN' , 'MASKANE_HEYATE_ELMI' , 'RIAL' , 'WITHOUT_WARANTY');


/*CHECKBOOK REQUEST DEFINE 2 4 9 */
INSERT INTO check_book_request (stuff , account , status , number_of_check) VALUES (3 , 6 , 'NOT_OPEN' , 10);
INSERT INTO check_book_request (stuff , account , status , number_of_check , response) VALUES (7 , 7 , 'REJECTED' , 15 , 4);
INSERT INTO check_book_request (stuff , account , status , number_of_check) VALUES (7 , 1 , 'NOT_OPEN' , 50);
INSERT INTO check_book_request (stuff , account , status , number_of_check , response) VALUES (5 , 3 , 'ACCEPT' , 25 , 5);

