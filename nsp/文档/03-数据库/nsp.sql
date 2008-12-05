--
--ER/Studio 6.0 SQL Code Generation
-- Company :      TOWERSOFT
-- Project :      nsp.dm1
-- Author :       CHANGHU
--
-- Date Created : Thursday, October 09, 2008 12:07:10
-- Target DBMS : MySQL 4.x
--


-- 
-- TABLE: RESOURCE_BUYIN_LIST 
--

CREATE TABLE RESOURCE_BUYIN_LIST(
    LIST_ID             CHAR(6)          NOT NULL,
    ORG_ID              CHAR(6),
    RESOURCE_TYPE_ID    CHAR(6),
    IN_AMOUNT           DECIMAL(8, 0),
    IN_OPER_USERID      CHAR(6),
    IN_OPER_DATETIME    CHAR(14),
    IN_REMARK           VARCHAR(300),
    PRIMARY KEY (LIST_ID)
)
;



-- 
-- TABLE: RESOURCE_CLASS 
--

CREATE TABLE RESOURCE_CLASS(
    CLASS_ID      CHAR(6)        NOT NULL,
    CLASS_CODE    VARCHAR(20)    NOT NULL,
    CLASS_NAME    VARCHAR(50)    NOT NULL,
    PRIMARY KEY (CLASS_ID)
)
;



-- 
-- TABLE: RESOURCE_ORG_AMOUNT 
--

CREATE TABLE RESOURCE_ORG_AMOUNT(
    ORG_ID              CHAR(6)          NOT NULL,
    RESOURCE_TYPE_ID    CHAR(6)          NOT NULL,
    STOCK_AMOUNT        DECIMAL(8, 0)    NOT NULL,
    PRE_OUT_AMOUNT      DECIMAL(8, 0)    NOT NULL,
    PRE_IN_AMOUNT       DECIMAL(8, 0)    NOT NULL,
    ONLINE_AMOUNT       DECIMAL(8, 0)    NOT NULL,
    INCONS_AMOUNT       DECIMAL(8, 0)    NOT NULL,
    PRIMARY KEY (ORG_ID, RESOURCE_TYPE_ID)
)
;



-- 
-- TABLE: RESOURCE_PREPARE_LIST 
--

CREATE TABLE RESOURCE_PREPARE_LIST(
    LIST_ID                   CHAR(10)         NOT NULL,
    LIST_STATUS               CHAR(1)          NOT NULL,
    SHEET_ID                  CHAR(6),
    OUT_ORG_ID                CHAR(6),
    OUT_STATION_ID            CHAR(6),
    RESOURCE_CLASS_ID         CHAR(6),
    RESOURCE_TYPE_ID          CHAR(6),
    AMOUNT_PREPARE            DECIMAL(8, 0),
    IN_ORG_ID                 CHAR(6),
    IN_STATION_ID             CHAR(6),
    TAKE_USER_NAME            VARCHAR(30),
    TAKE_DATE                 CHAR(8),
    OUT_OPER_USERID           CHAR(6),
    OUT_OPER_DATETIME         CHAR(14),
    IN_OPER_USERID            CHAR(6),
    IN_OPER_DATETIME          CHAR(14),
    AMOUNT_BEFORE_CONS        DECIMAL(8, 0),
    AMOUNT_FEED_BACK          DECIMAL(8, 0),
    AMOUNT_AFTER_CONS         DECIMAL(8, 0),
    CONF_AMOUNT_AFTER_CONS    DECIMAL(8, 0),
    AMOUNT_DIFF               DECIMAL(8, 0),
    DIFF_IN_ORG_ID            CHAR(6),
    DIFF_IN_STATION_ID        CHAR(6),
    CONS_USER_NAME            VARCHAR(30),
    CONS_FIN_DATE             CHAR(8),
    CONS_FIN_OPER_USERID      CHAR(6),
    CONS_FIN_OPER_DATETIME    CHAR(14),
    CONS_ACK_USERID           CHAR(6),
    CONS_ACK_DATETIME         CHAR(14),
    PRIMARY KEY (LIST_ID)
)
;



-- 
-- TABLE: RESOURCE_PREPARE_SHEET 
--

CREATE TABLE RESOURCE_PREPARE_SHEET(
    SHEET_ID           CHAR(6)    NOT NULL,
    PREPARE_DATE       CHAR(8)    NOT NULL,
    PREPARE_USER_ID    CHAR(6)    NOT NULL,
    PRIMARY KEY (SHEET_ID)
)
;



-- 
-- TABLE: RESOURCE_TYPE 
--

CREATE TABLE RESOURCE_TYPE(
    TYPE_ID              CHAR(6)          NOT NULL,
    TYPE_CODE            VARCHAR(20)      NOT NULL,
    TYPE_NAME            VARCHAR(50)      NOT NULL,
    RESOURCE_CLASS_ID    CHAR(6)          NOT NULL,
    TYPE_CONF_AMOUNT     DECIMAL(6, 0)    NOT NULL,
    PRIMARY KEY (TYPE_ID)
)
;



-- 
-- TABLE: SYS_ID_CREATOR 
--

CREATE TABLE SYS_ID_CREATOR(
    CREATOR_ID        VARCHAR(40)     NOT NULL,
    CREATOR_VALUE     VARCHAR(40)     NOT NULL,
    CREATOR_REMARK    VARCHAR(200),
    PRIMARY KEY (CREATOR_ID)
)
;



-- 
-- TABLE: SYS_MENU 
--

CREATE TABLE SYS_MENU(
    MENU_ID      VARCHAR(50)     NOT NULL,
    MENU_NAME    VARCHAR(50)     NOT NULL,
    MENU_TYPE    CHAR(1)         NOT NULL,
    MENU_LVL     INT             NOT NULL,
    PARENT_ID    VARCHAR(50)     NOT NULL,
    SORT_NO      INT             NOT NULL,
    MENU_URL     VARCHAR(200),
    MENU_DESC    VARCHAR(200),
    PRIMARY KEY (MENU_ID)
)
;



-- 
-- TABLE: SYS_ORG 
--

CREATE TABLE SYS_ORG(
    ORG_ID          CHAR(6)         NOT NULL,
    ORG_NAME        VARCHAR(50)     NOT NULL,
    ORG_CODE        VARCHAR(20),
    PARENT_ID       CHAR(6),
    ORG_DESC        VARCHAR(200),
    LINK_MAN        VARCHAR(50),
    LINK_TELE       VARCHAR(50),
    LINK_EMAIL      VARCHAR(50),
    STATION_FLAG    CHAR(1),
    BUY_IN_FLAG     CHAR(1),
    PRIMARY KEY (ORG_ID)
)
;



-- 
-- TABLE: SYS_PERM 
--

CREATE TABLE SYS_PERM(
    USER_ID    CHAR(6)        NOT NULL,
    MENU_ID    VARCHAR(50)    NOT NULL,
    PRIMARY KEY (USER_ID, MENU_ID)
)
;



-- 
-- TABLE: SYS_STAT 
--

CREATE TABLE SYS_STAT(
    STAT_ID      CHAR(6)         NOT NULL,
    STAT_NAME    VARCHAR(50)     NOT NULL,
    STAT_DESC    VARCHAR(200),
    PRIMARY KEY (STAT_ID)
)
;



-- 
-- TABLE: SYS_USER 
--

CREATE TABLE SYS_USER(
    USER_ID         CHAR(6)         NOT NULL,
    USER_NAME       VARCHAR(50)     NOT NULL,
    LOGIN_NAME      VARCHAR(50)     NOT NULL,
    PASSWORD        VARCHAR(32)     NOT NULL,
    STATUS          CHAR(1)         NOT NULL,
    USER_ORG_ID     CHAR(6),
    USER_STAT_ID    CHAR(6),
    USER_DESC       VARCHAR(200),
    LINK_TELE       VARCHAR(50),
    LINK_EMAIL      VARCHAR(50),
    USER_SEX        CHAR(1),
    USER_BIRTH      VARCHAR(8),
    MAN_FLAG        CHAR(1),
    PRIMARY KEY (USER_ID)
)
;




