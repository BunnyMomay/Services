DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS HISTORY;

CREATE TABLE ACCOUNT
(
  ID            serial,
  TYPEID        character(1) NOT NULL,
  ENABLEID      character(1) NOT NULL,
  USERNAME      character varying(64) NOT NULL,
  PASSWD        character varying(64) NOT NULL,
  EMAIL	        character varying(128) NOT NULL,
  FIRSTNAME     character varying(64),
  LASTNAME      character varying(64),
  TWITTER       character varying(32),
  BIO           character varying(128),
  AVATARPATH    character varying(256),

  CREATED       timestamp with time zone,
  UPDATED       timestamp with time zone,
  UPDATEBY      integer,

  CONSTRAINT ACCOUNT_PK PRIMARY KEY (ID),
  CONSTRAINT USERNAME_UNIQUE UNIQUE (USERNAME)
)
WITH (
  OIDS = FALSE
) TABLESPACE pg_default;
ALTER TABLE ACCOUNT     OWNER TO training;


CREATE TABLE HISTORY
(
  ID            serial,
  ACCOUNTID		integer,
  ACTIONLOG		character varying(256),

  CREATED       timestamp with time zone,
  UPDATED       timestamp with time zone,
  UPDATEBY      integer,

  CONSTRAINT HISTORY_PK PRIMARY KEY (ID)
)
WITH (
  OIDS = FALSE
) TABLESPACE pg_default;
ALTER TABLE history     OWNER TO training;

INSERT INTO account(
            id, typeid, enableid, username, passwd, email, firstname, lastname, bio, avatarpath)
    VALUES (1, 'A', 'Y', 'admin',  '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'nuboat@gmail.com', 'Admin', '@ SIGNATURE', 'Default Admin of System', 'avatar/000000000.jpg');
