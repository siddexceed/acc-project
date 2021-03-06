CREATE TABLE TB_TRANSACTION_MASTER
( 
  TRANSACTION_ID VARCHAR(100)  NOT NULL 
, ACCOUNT_NUM VARCHAR(100) NOT NULL 
, TRANSACTION_DESC VARCHAR(100)
, TRANSACTION_AMT double(20,4)
, TRANSACTION_TYPE VARCHAR(100) NOT NULL
, TRANSACTION_CODE VARCHAR(100) NOT NULL
, TRANSACTION_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
, TRANSACTION_CURRENCY VARCHAR(50) NOT NULL 
, CONSTRAINT PRIMARY KEY ( TRANSACTION_ID ) );

CREATE TABLE TB_ACCOUNT_MASTER
( 
  ACCOUNT_NUM VARCHAR(100) NOT NULL 
, ACCOUNT_NAME VARCHAR(100) NOT NULL 
, ACCOUNT_TYPE VARCHAR(100) NOT NULL
, ACCOUNT_CURRENCY VARCHAR(50) NOT NULL
, CURRENT_BAL double(20,4) NULL 
, LINE_AMT double(20,4) NULL 
, CLEARING_AMT double(20,4) NULL 
, WITHDRAWBLE_BAL double(20,4) NULL 
, CREATION_DATE DATE NOT NULL 
, LAST_TRANSACTION_DATE TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' 
, ACCOUNT_ADDRESS VARCHAR(250) NULL 
, CUSTOMER_ID VARCHAR(50) NULL
, CONSTRAINT PRIMARY KEY ( ACCOUNT_NUM ) );