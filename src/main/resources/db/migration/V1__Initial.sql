CREATE SEQUENCE if not exists SEQ_PLAYBILL;

CREATE TABLE if not exists PLAYBILL
(
    ID           INT NOT NULL,
    NAME         VARCHAR (255) NOT NULL,
    DESCRIPTION  VARCHAR (2000),
    AGE_CATEGORY VARCHAR (30),
    SEATS        INT NOT NULL,
    SEATS_SOLD   INT DEFAULT 0 NOT NULL,
    CONSTRAINT PLAYBILL_PK PRIMARY KEY (ID),
    CONSTRAINT PLAYBILL_UQ UNIQUE (NAME)
);

CREATE TABLE if not exists USERS
(
    USERNAME VARCHAR (30) NOT NULL,
    PASSWORD VARCHAR (255),
    ROLENAME VARCHAR (30),
    CONSTRAINT USERS_PK PRIMARY KEY (USERNAME)
);