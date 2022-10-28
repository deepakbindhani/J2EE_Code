/*************************************************************************USER DATA*************************************************************************/

INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'admin','Administrator','Admin01','admin01',0000000000,'',00,'');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Maneesh Kumar','maani09k@gmail.com','Qwerty',7087548100,'Male',22,'DodoMan');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Sakshi Chourasia','sakshi29111@gmail.com','SakshiChou',9618641615,'Female',21,'Coco');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Princy Pandey','princypandey777@gmail.com','Princypandey',7508027308,'Female',23,'Panda');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Kiran Rajput','kraj97@gmail.com','KiranRajput',8855876618,'Male',22,'Karan');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Sudarshan Wagh','waghsudarshan4340@gmail.com','SundyWagh',9403443111,'Male',21,'Sundy');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Vaibhav Saxena','vaibhav77705@gmail.com','VibhaJi',9672977705,'Male',21,'Vibha');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Ananya Sanyal','ananyasanyal123@gmail.com','Anannu',9468086355,'Female',18,'Nannu');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Rohan Tyagi','rohantyagi1998@gmail.com','TyagiJi',819895559,'Male',22,'Roh');
INSERT INTO USERDATA(user_id,user_role,user_name,user_mail,user_password,user_contact,user_gender,user_age,secret_word) VALUES (0,'user','Vrinda Miglani','vrindamiglani13@gmail.com','VMiglani',8968100208,'Female',20,'Chotu');


/************************************************************************PRODUCT DATA*********************************************************************/

INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'CompanyPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'PersonalPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'PublicPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'DomesticPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'EconomicPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'HealthPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'HumanResourcesPolicy');
INSERT INTO PRODUCTDATA(product_id,product_name) VALUES (0,'PrivatePolicy');


/************************************************************************POLICY DATA*********************************************************************/

INSERT INTO POLICYDATA(policy_number,customer_name,customer_contact,customer_email,customer_dob,customer_addressline,customer_addresspincode,customer_addresscity,customer_addresscountry,product_id) VALUES (0,'Princy',7508027308,'princypandey20@gmail.com','1996-11-20','G 44 ADA',211013,'Allahabad','India',1);