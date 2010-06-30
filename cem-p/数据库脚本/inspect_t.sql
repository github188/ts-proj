

-- 
-- TABLE: DEVICE_INSPECT_LOG 
--


CREATE TABLE DEVICE_INSPECT_LOG(
    SEND_ID          CHAR(10)       NOT NULL,
    DEVICE_ID        CHAR(6)        NOT NULL,
    DEVICE_NAME      VARCHAR(60),
    DEVICE_IP        VARCHAR(50),
    USER_ID          CHAR(6)        NOT NULL,
    INSPECT_BEGIN    CHAR(14),
    INSPECT_END      CHAR(14),
    STATUS           CHAR(1),
    LOG_CONT         TEXT
)
;



-- 
-- TABLE: DEVICE_TYPE 
--

CREATE TABLE DEVICE_TYPE(
    TYPE_ID                 CHAR(6)         NOT NULL,
    TYPE_NAME_EN            VARCHAR(60)     NOT NULL,
    TYPE_NAME_CN            VARCHAR(60)     NOT NULL,
    INSPECT_COMMANDS        TEXT,
    INSPECT_COMMANDS_EXP    VARCHAR(200),
    COLLECT_COMMANDS        TEXT,
    APP_PICTURE             LONGBLOB,
    REMARK                  VARCHAR(200),
    PRIMARY KEY (TYPE_ID)
)
;



