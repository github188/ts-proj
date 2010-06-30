
-- 
-- TABLE: COMMANDS_SEND_HIS 
--

CREATE TABLE COMMANDS_SEND_HIS(
    SEND_ID             CHAR(6)     NOT NULL,
    USER_ID             CHAR(6),
    DEVICE_ID           CHAR(6),
    TASK_DEFINE_TIME    CHAR(14),
    TASK_PLAN_TIME      CHAR(14),
    COMMANDS_TYPE       CHAR(1)     NOT NULL,
    TEMPLATE_ID         CHAR(6),
    STATUS              CHAR(1)     NOT NULL,
    EXEC_BEGIN_TIME     CHAR(14),
    EXEC_END_TIME       CHAR(14)
)
;



-- 
-- TABLE: COMMANDS_SEND_LIST 
--

CREATE TABLE COMMANDS_SEND_LIST(
    SEND_ID             CHAR(6)     NOT NULL,
    USER_ID             CHAR(6),
    DEVICE_ID           CHAR(6),
    TASK_DEFINE_TIME    CHAR(14),
    TASK_PLAN_TIME      CHAR(14),
    COMMANDS_TYPE       CHAR(1)     NOT NULL,
    TEMPLATE_ID         CHAR(6),
    STATUS              CHAR(1)     NOT NULL,
    PRIMARY KEY (SEND_ID)
)
;




