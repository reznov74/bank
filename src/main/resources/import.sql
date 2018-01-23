
/*ROLE DEFINE */
INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (ID, NAME) VALUES (3, 'ROLE_STUFF');


/*Auth DEFINE*/
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (1, 'stuff1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (2, 'user1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (3, 'stuff2', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (4, 'user2', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD,  ENABLED, LASTPASSWORDRESETDATE ) VALUES (5, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));

/* ASSIGN ROLE */
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 3);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (4, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (5, 2);

/*USER DEFINE TODO STUFF BRANCH AND HISTORY */
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user ,personal_number) VALUES ('razavi', '0018601375'  , '09392262950' ,'razavi_rohani@yahoo.com','shiraz',3 , 1,2437);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('rohani', '0018601376'  , '09392262951' ,'razavi_rohanii@yahoo.com','shiraz',1 , 2 );
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user ,personal_number) VALUES ('ebrahimi', '0018601378'  , '09392262952' ,'razavi_rohanii@yahoo.com','tehran',3 , 3 , 2439);
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('kiani', '0018601379'  , '09392262958' ,'razavi_rohaniii@yahoo.com','mashhad',1 , 4 );
INSERT INTO user_model (frist_name  , national_code , phone_number , email , address , user_type, user) VALUES ('mohamadi', '0018601380' , '09392262959' ,'razavi_rohaniii@yahoo.com','tabriz',2 , 5);


/*BRANCH DEFINE*/
INSERT INTO branch (address , phone ,city,code ) VALUES ('shiraz',44286981,'shiraz',5863);
INSERT INTO branch (address , phone ,city,code ) VALUES ('tehran',44286981,'tehran',5864);
INSERT INTO branch (address , phone ,city,code ) VALUES ('mashhad',44286981,'mashhad',5865);
INSERT INTO branch (address , phone ,city,code ) VALUES ('tabriz',44286981,'tabriz',5866);

/*ACCESS CARD REQUEST DEFINE */
INSERT INTO card_req (stuff ,customer , branch , status ,FIRST) VALUES (1 ,2 ,1 ,'NOT_OPEN',1);
INSERT INTO card_req (stuff ,customer , branch , status ,FIRST) VALUES (3 ,2 ,1 ,'NOT_OPEN',0);
INSERT INTO card_req (stuff ,customer , branch , status ,FIRST) VALUES (1 ,4 ,1 ,'NOT_OPEN',0);
INSERT INTO card_req (stuff ,customer , branch , status ,FIRST) VALUES (3 ,4 ,1 ,'NOT_OPEN',1);

/*ACCOUNT STATUS DEFINE*/
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('BLOCKED' , PARSEDATETIME('01-09-2017', 'dd-MM-yyyy') , PARSEDATETIME('01-02-2017', 'dd-MM-yyyy') , 'درخواست مشتری');
INSERT INTO account_status(type , start , end , reason) VALUES ('OPEN' , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , '');
INSERT INTO account_status(type , start , end , reason) VALUES ('BLOCKED' , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'بدهی');

/*ACCOUNT DEFINE*/
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275855' , 250000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2  , 'INDIVISUAL' , 'REAL' , 0 , 'GHARZ' , 1 , 4 , 1 , null);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275852' , 952000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 4  , 'INDIVISUAL' , 'LAWY' , 1 , 'SEPORDE_KOTAH' , 2 , 3 , 3 , 90);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275853' , 759000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 4  , 'GROUP' , 'REAL' , 1 , 'SEPORDE_BOLAND' , 3 , 2 , 1 , 24);
INSERT INTO account (number , cash , expire , start , customer , account_type_indivisual ,account_type_real ,with_check , account_type , account_status , branch , stuff ,long_period) VALUES ('6104337846275854' , 45000.0 , null , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 2  , 'INDIVISUAL' , 'REAL' , 0 , 'JARI' , 4 , 1 , 3 , null);

/*ACCESS CARD DEFINE*/
INSERT INTO access_card (is_active , access_card_number , second_password , expire_date , cvv2 ,branch , start , end , account) VALUES (1 , '610433784658588' , '987654321' , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 022 ,1, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , null , 1 );
INSERT INTO access_card (is_active , access_card_number , second_password , expire_date , cvv2 ,branch , start , end , account) VALUES (1 , '610783784658589' , '98871654321' , PARSEDATETIME('01-01-2020', 'dd-MM-yyyy') , 032 , 3 ,PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , null , 2 );

/*ACCOUNT FLOW DEFINE*/
INSERT INTO account_flow (id , account  , type , date , amount) VALUES (1 , 1 , 'KHARID_POZ',PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 28800.7);
INSERT INTO account_flow (id , account , type , date , amount) VALUES (2 , 2 , 'KHARID_INTERNET' ,PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 28548400.7);
INSERT INTO account_flow (id , account  , type , date ,amount ) VALUES (3 , 3  ,'VARIZ_NAGHD' ,PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 28452000.7);
INSERT INTO account_flow (id , account  , type , date ,amount) VALUES (4 , 2  , 'KHARID_POZ' ,PARSEDATETIME('05-01-2016', 'dd-MM-yyyy') , 2880000.7);
INSERT INTO account_flow (id , account  , type , date ,amount) VALUES (5 , 1  , 'KHARID_INTERNET' ,PARSEDATETIME('04-08-2016', 'dd-MM-yyyy') , 28800.7);

/*CHECKBOOK DEFINE*/
INSERT INTO checkbook (number , count , expire , account) VALUES (991023 , 15 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 2);
INSERT INTO checkbook (number , count , expire , account) VALUES (991024 , 50 , PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 3);

/*CHECK DEFINE TODO EMBEDDED ID */
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104850 , 991023 , 1 , 24000.0, PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104851 , 991023 , 1 , 580000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104852 , 991023 , 1 , 74000.0, PARSEDATETIME('01-02-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104853 , 991023 , 1 , 664000.0, PARSEDATETIME('03-01-2019', 'dd-MM-yyyy') , 'NOT_USE' , 'رضوی ');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104854 , 991023 , 1 , 74000.0, PARSEDATETIME('05-01-2019', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104855 , 991023 , 1 , 4000.0, PARSEDATETIME('11-01-2019', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104856 , 991023 , 1 , 774000.0, PARSEDATETIME('01-09-2019', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104857 , 991023 , 1 , 26000.0, PARSEDATETIME('01-01-2018', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104858 , 991023 , 1 , 23000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104859 , 991023 , 1 , 49000.0, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');

INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 111760 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'PASS' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104851 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'روحانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104852 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104853 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2011', 'dd-MM-yyyy') , 'REJECTED' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104854 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'PASS' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104855 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104856 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 'PASS' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104857 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2014', 'dd-MM-yyyy') , 'REJECTED' , 'کیانی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104858 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 'NOT_USE' , 'ابراهیمی');
INSERT INTO check_ (check_number , checkbook_number ,checkbook,cash,date,status,to_name) VALUES ( 104859 , 991024 , 2 , 24000.0, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy') , 'PASS' , 'کیانی');

/*DRAFT DEFINE TODO SYNC WITH ACCOUNT FLOW*/

INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (2 , 3 , PARSEDATETIME('01-01-2015', 'dd-MM-yyyy') , 260000.0 , 'خرید لامپ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 4 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (4 , 1 , PARSEDATETIME('01-04-2015', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 2 , PARSEDATETIME('09-07-2015', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (4 , 4 , PARSEDATETIME('07-11-2016', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'ATM');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (3 , 4 , PARSEDATETIME('01-01-2016', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'INTERNET');
INSERT INTO draft (source , dist , date , amount  , for_  , type) VALUES (2 , 4 , PARSEDATETIME('01-01-2017', 'dd-MM-yyyy') , 260000.0 , 'پرداخت شارژ' , 'ATM');

/*FACILITY REQUEST DEFINE */




/*CHECKBOOK REQUEST DEFINE */




/*REQUEST RESPONSE DEFINE */



