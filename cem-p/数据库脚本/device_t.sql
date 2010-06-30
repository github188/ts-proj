
-- 
-- TABLE: DEVICE_INFO 
--

CREATE TABLE DEVICE_INFO(
    DEVICE_ID             CHAR(6)         NOT NULL,
    DEVICE_NAME_EN        VARCHAR(60)     NOT NULL,
    DEVICE_ABB_NAME_EN    VARCHAR(60),
    DEVICE_NAME_CN        VARCHAR(60)     NOT NULL,
    TYPE_ID               CHAR(6),
    LOCATION_ID           CHAR(6),
    DEVICE_STATUS         CHAR(1)         NOT NULL,
    FRONT_HOST_ID         CHAR(6),
    DEVICE_IP             VARCHAR(50)     NOT NULL,
    DEVICE_PORT           VARCHAR(50)     NOT NULL,
    DEVICE_USER           VARCHAR(50)     NOT NULL,
    DEVICE_PASSWORD       VARCHAR(50)     NOT NULL,
    DEVICE_PROMPT         VARCHAR(10)     NOT NULL,
    REMARK                VARCHAR(200),
    PRIMARY KEY (DEVICE_ID)
)
;



-- 
-- TABLE: DEVICE_MAINTAIN_LOG 
--

CREATE TABLE DEVICE_MAINTAIN_LOG(
    SEND_ID           CHAR(10)       NOT NULL,
    DEVICE_ID         CHAR(6)        NOT NULL,
    DEVICE_NAME       VARCHAR(60),
    DEVICE_IP         VARCHAR(50),
    USER_ID           CHAR(6)        NOT NULL,
    MAINTAIN_BEGIN    CHAR(14),
    MAINTAIN_END      CHAR(14),
    STATUS            CHAR(1),
    LOG_CONT          TEXT
)
;


--
-- TABLE: FRONT_HOST_INFO
--

CREATE TABLE FRONT_HOST_INFO(
    HOST_ID             CHAR(6)         NOT NULL,
    HOST_NAME_EN        VARCHAR(60)     NOT NULL,
    HOST_ABB_NAME_EN    VARCHAR(60),
    HOST_NAME_CN        VARCHAR(60)     NOT NULL,
    LOCATION_ID         CHAR(6),
    HOST_STATUS         CHAR(1)         NOT NULL,
    HOST_IP             VARCHAR(50)     NOT NULL,
    HOST_PORT           VARCHAR(50)     NOT NULL,
    HOST_USER           VARCHAR(50)     NOT NULL,
    HOST_PASSWORD       VARCHAR(50)     NOT NULL,
    HOST_PROMPT         VARCHAR(200)    NOT NULL,
    REMARK              VARCHAR(200),
    PRIMARY KEY (HOST_ID)
)
;



-- 
-- TABLE: MAINTAIN_COMMANDS_TEMPLATE 
--

CREATE TABLE MAINTAIN_COMMANDS_TEMPLATE(
    TEMP_ID      CHAR(6)         NOT NULL,
    TEMP_NAME    VARCHAR(60)     NOT NULL,
    TEMP_DESC    VARCHAR(200),
    TEMP_CONT    TEXT,
    PRIMARY KEY (TEMP_ID)
)
;