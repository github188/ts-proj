INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0001', '注册EAP用户', 'eapCreateUser', 1);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0002', '注册用户信息修改', 'eapModifyUser', 2);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0003', '注册设备', 'eapAssociateCard', 3);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0004', '注销用户', 'eapBlockUser', 4);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0005', '添加渠道', 'eapBlockUser', 5);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0006', '注销渠道', 'eapBlockChannel', 6);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0007', '注销设备', 'eapBlockCard', 7);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0008', '更改用户状态', 'eapModifyUserStatus', 8);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0011', '挂失设备', 'eapLockCard', 11);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0012', '解挂失设备', 'eapUnlockCard', 12);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0013', '验证动态密码', 'eapVerifyCode', 13);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0014', '同步', 'eapSynchronize', 14);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0015', '解锁动态密码', 'eapUnlockOTP', 15);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0016', '激活设备', 'eapActivateCard', 16);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0017', '更换设备', 'eapReplaceCard', 17);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0018', '获取刮刮卡序号', 'eapGetSequenceNumber', 18);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0019', '获取服务器验证码', 'eapGetCodePrefix', 19);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0020', '验证电子签名', 'eapVerifySignature', 20);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0021', '验证电子签名', 'eapVerifySignatureLarge', 21);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0022', '验证矩阵卡密码', 'eapVerifyMatrixCode', 22);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0023', '获取矩阵卡坐标', 'eapGetCoordinates', 23);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0024', '获取短信动态密码', 'eapRetrieveOTP', 24);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0025', '获取设备信息', 'eapGetCardInfo', 25);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0026', '获取设备信息列表', 'eapGetCardList', 26);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0027', '获取用户信息', 'eapGetUser', 27);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0028', '获取用户渠道', 'eapGetUserChannel', 28);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0030', '解锁矩阵卡密码', 'eapUnlockMatrixCode', 30);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0031', '解锁签名', 'eapUnlockSignature', 31);
INSERT INTO "EAP_ADM"."EAP_API" (API_ID, API_NAME, API_DESC, SORT_NO) VALUES ('0032', '重新生成激活码', 'eapReGenerateActivateCode', 32);
COMMIT;

INSERT INTO "EAP_ADM"."EAP_AUTH" ( AUTH_ID, AUTH_NAME, AUTH_DESC, SORT_NO ) VALUES ( '0001', '注册EAP用户', 'eapCreateUser', 1);
COMMIT;

INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '100', '10', 'SIM卡', 'N', '100');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '101', '11', 'SIM卡', 'S', '100');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '102', '12', 'SIM卡', 'S', '100');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '320', '00', '令牌', 'N', '320');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '323', '01', '双向认证令牌', 'N', '323');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '330', '05', '短信', 'N', '330');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '332', '06', '短信', 'S', '330');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '300', 'AA', '刮刮卡', 'N', '300');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '303', 'AB', '双向认证刮刮卡', 'N', '303');
INSERT INTO "EAP_ADM"."EAP_CARD_TYPE" ( CARD_TYPE, GID_VERSION, CARD_TYPE_DESC, CARD_TYPE_STATUS, EAP_CARD_TYPE ) VALUES ( '310', '04', '矩阵卡', 'N', '310');
COMMIT;

INSERT INTO "EAP_ADM"."EAP_ID_CREATOR" ( CREATOR_ID, CREATOR_VALUE, CREATOR_REMARK) VALUES ('PRE_ECODE_USER', '0', 'Next ID of PRE_ECODE_USER');
COMMIT;

INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M001', '首页 ', 'W', 0, '0000', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M004', '客户动态口令管理', 'W', 0, '0000', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M005', '解锁管理', 'W', 0, '0000', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M002', '平台管理', 'W', 0, '0000', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M003', '报表＆日志', 'W', 0, '0000', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT0', '测试功能', 'W', 0, '0000', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPC0', '应用系统管理', 'W', 1, 'M002', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU1', '机构管理', 'W', 1, 'M002', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPR0', '角色管理', 'W', 1, 'M002', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPT0', '操作员管理', 'W', 1, 'M002', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD0', '设备管理', 'W', 1, 'M002', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRS0', '应用系统统计报表', 'W', 1, 'M003', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRP0', '平台运行报表', 'W', 1, 'M003', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IRA0', '认证设备报表', 'W', 1, 'M003', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRL0', '平台日志', 'W', 1, 'M003', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M101', '客户动态口令管理', 'W', 1, 'M004', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('M102', '电话注册申请', 'W', 1, 'M004', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC0', '电话注册审核', 'W', 1, 'M004', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCB0', '批量绑定', 'W', 1, 'M004', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUA1', '简单动态口令解锁', 'W', 1, 'M005', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUB1', '电子签名解锁', 'W', 1, 'M005', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUC1', '刮刮卡解锁', 'W', 1, 'M005', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUD1', '矩阵卡解锁', 'W', 1, 'M005', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUE1', '双向认证刮刮卡解锁', 'W', 1, 'M005', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUF1', '双向认证令牌解锁', 'W', 1, 'M005', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCB1', '批量绑定', 'F', 2, 'BCB0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC1', '电话注册审核:客户查询', 'F', 2, 'BCC0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC2', '电话注册审核:客户详细信息', 'F', 2, 'BCC0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC3', '电话注册审核:审核预检查', 'F', 2, 'BCC0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC4', '电话注册审核:审核通过', 'F', 2, 'BCC0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC6', '电话注册审核:审核拒绝', 'F', 2, 'BCC0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCC7', '电话注册审核:客户注销', 'F', 2, 'BCC0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BLF2', 'FutureCard文件上传提交', 'F', 2, 'BLF1', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD1', '查询设备', 'F', 2, 'BPD0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD2', '查看设备详细信息', 'F', 2, 'BPD0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD3', '修改渠道:输入', 'F', 2, 'BPD0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD4', '修改渠道:提交', 'F', 2, 'BPD0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD5', '添加渠道:输入', 'F', 2, 'BPD0', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD6', '添加渠道:提交', 'F', 2, 'BPD0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPD7', '删除设备', 'F', 2, 'BPD0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPD5', '设备增加', 'F', 2, 'BPD0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPDB', '定义设备权限', 'F', 2, 'BPD0', 9);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPDH', '定义设备权限,提交', 'F', 2, 'BPD0', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPDC', '查看设备权限', 'F', 2, 'BPD0', 11);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU2', '查看机构详细信息', 'F', 2, 'BPU1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU3', '修改机构:输入', 'F', 2, 'BPU1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU4', '修改机构:提交', 'F', 2, 'BPU1', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU5', '添加机构:输入', 'F', 2, 'BPU1', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU6', '添加机构:提交', 'F', 2, 'BPU1', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPU7', '删除机构', 'F', 2, 'BPU1', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPUA', '选择机构', 'F', 2, 'BPU1', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRL1', '日志查询', 'F', 2, 'BRL0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRL2', '日志详细信息', 'F', 2, 'BRL0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRL3', '日志打印', 'F', 2, 'BRL0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRL4', '日志输出Excel', 'F', 2, 'BRL0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRP1', '报表查询', 'F', 2, 'BRP0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRP2', '报表查询打印', 'F', 2, 'BRP0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRP3', '报表查询输出Excel', 'F', 2, 'BRP0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRS1', 'SP统计查询', 'F', 2, 'BRS0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRS2', 'SP统计查询打印', 'F', 2, 'BRS0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRS3', 'SP统计查询输出Excel', 'F', 2, 'BRS0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUA2', '动态口令解锁', 'F', 2, 'BUA1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUA3', '动态口令解锁', 'F', 2, 'BUA1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUB2', '电子签名解锁', 'F', 2, 'BUB1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUB3', '电子签名解锁', 'F', 2, 'BUB1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUC2', '刮刮卡解锁', 'F', 2, 'BUC1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUC3', '刮刮卡解锁', 'F', 2, 'BUC1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUD2', '矩阵卡解锁', 'F', 2, 'BUD1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUD3', '矩阵卡解锁', 'F', 2, 'BUD1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUE2', '双向认证刮刮卡解锁', 'F', 2, 'BUE1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUE3', '双向认证刮刮卡解锁', 'F', 2, 'BUE1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUF2', '双向认证令牌解锁', 'F', 2, 'BUF1', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BUF3', '双向认证令牌解锁', 'F', 2, 'BUF1', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT1', '测试功能:获取服务器验证码', 'F', 2, 'IAT0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT1', '测试功能:获取服务器验证码', 'F', 2, 'IAT0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT2', '测试功能:获取矩阵卡坐标页面', 'F', 2, 'IAT0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT2', '测试功能:获取矩阵卡坐标', 'F', 2, 'IAT0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT3', '测试功能:获取刮刮卡序号页面', 'F', 2, 'IAT0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT3', '测试功能:获取刮刮卡序号', 'F', 2, 'IAT0', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT4', '测试功能:获取短信动态密码页面', 'F', 2, 'IAT0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT4', '测试功能:获取短信动态密码', 'F', 2, 'IAT0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT5', '测试功能:同步页面', 'F', 2, 'IAT0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT5', '测试功能:同步', 'F', 2, 'IAT0', 9);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT6', '测试功能:验证动态密码页面', 'F', 2, 'IAT0', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT6', '测试功能:验证动态密码', 'F', 2, 'IAT0', 11);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT7', '测试功能:验证矩阵卡密码页面', 'F', 2, 'IAT0', 12);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT7', '测试功能:验证矩阵卡密码', 'F', 2, 'IAT0', 13);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT8', '测试功能:验证电子签名页面', 'F', 2, 'IAT0', 14);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATZ', '测试功能:验证电子签名', 'F', 2, 'IAT0', 15);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IAT9', '测试功能:验证电子签名页面', 'F', 2, 'IAT0', 16);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BAT9', '测试功能:验证电子签名', 'F', 2, 'IAT0', 17);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IATA', '测试功能:解锁动态密码页面', 'F', 2, 'IAT0', 18);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATA', '测试功能:解锁动态密码', 'F', 2, 'IAT0', 19);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IATB', '测试功能:解锁矩阵卡密码页面', 'F', 2, 'IAT0', 20);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATB', '测试功能:解锁矩阵卡密码', 'F', 2, 'IAT0', 21);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATC', '测试功能:解锁电子签名页面', 'F', 2, 'IAT0', 22);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATY', '测试功能:解锁电子签名', 'F', 2, 'IAT0', 23);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IATD', '测试功能:刮刮卡自助续卡，页面', 'F', 2, 'IAT0', 24);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BATD', '测试功能:刮刮卡自助续卡，提交', 'F', 2, 'IAT0', 25);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC1', '查询应用系统', 'F', 2, 'IPC0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC2', '查看应用系统详细信息', 'F', 2, 'IPC0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC3', '修改应用系统:输入', 'F', 2, 'IPC0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC4', '修改应用系统:提交', 'F', 2, 'IPC0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC5', '添加应用系统:输入', 'F', 2, 'IPC0', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC6', '添加应用系统:提交', 'F', 2, 'IPC0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPC7', '删除应用系统', 'F', 2, 'IPC0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPC5', '应用系统增加页面', 'F', 2, 'IPC0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR0', '角色管理', 'F', 2, 'IPR0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR1', '查询角色', 'F', 2, 'IPR0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR2', '查看角色详细信息', 'F', 2, 'IPR0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR3', '修改角色:输入', 'F', 2, 'IPR0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR4', '修改角色:提交', 'F', 2, 'IPR0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('IPR5', '添加角色:输入', 'F', 2, 'IPR0', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR6', '添加角色:提交', 'F', 2, 'IPR0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPR7', '删除角色', 'F', 2, 'IPR0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPRA', '选择角色', 'F', 2, 'IPR0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPRB', '定义角色权限:输入', 'F', 2, 'IPR0', 9);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPRC', '查看角色权限', 'F', 2, 'IPR0', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPRH', '定义角色权限:提交', 'F', 2, 'IPR0', 11);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT1', '查询操作员', 'F', 2, 'IPT0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT2', '查看操作员详细信息', 'F', 2, 'IPT0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT3', '修改操作员:输入', 'F', 2, 'IPT0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT4', '修改操作员:提交', 'F', 2, 'IPT0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT5', '添加操作员:输入', 'F', 2, 'IPT0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT6', '添加操作员:提交', 'F', 2, 'IPT0', 5);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPT7', '删除操作员', 'F', 2, 'IPT0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTA', '选择操作员', 'F', 2, 'IPT0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTB', '定义操作员权限', 'F', 2, 'IPT0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTC', '查看操作员权限', 'F', 2, 'IPT0', 9);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTD', '选择菜单', 'F', 2, 'IPT0', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTG', '选择API', 'F', 2, 'IPT0', 11);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTH', '提交操作员信息', 'F', 2, 'IPT0', 12);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BPTI', '选择授权', 'F', 2, 'IPT0', 13);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRA1', '验证设备报表查询', 'F', 2, 'IRA0', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRA2', '验证设备报表打印', 'F', 2, 'IRA0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BRA3', '验证设备报表输出Excel', 'F', 2, 'IRA0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR0', '动态口令客户查询', 'W', 2, 'M101', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR5', '动态口令客户添加', 'W', 2, 'M101', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT0', '电话注册查询', 'W', 2, 'M102', 0);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT5', '电话注册添加', 'W', 2, 'M102', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR1', '客户查询', 'F', 3, 'BCR0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR2', '客户详细信息', 'F', 3, 'BCR0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR3', '客户修改初始化', 'F', 3, 'BCR0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR4', '客户信息修改提交', 'F', 3, 'BCR0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRU', '创建用户信息检查', 'F', 3, 'BCR0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRV', '客户信息授权', 'F', 3, 'BCR0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCR6', '客户信息增加提交', 'F', 3, 'BCR0', 8);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRA', '用户解锁，用户锁定', 'F', 3, 'BCR0', 9);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRB', '用户注销', 'F', 3, 'BCR0', 10);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRM', '增加设备初始化', 'F', 3, 'BCR0', 20);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0003', '增加设备', 'F', 3, 'BCR0', 21);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRN', '更换设备初始化', 'F', 3, 'BCR0', 22);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0017', '更换设备', 'F', 3, 'BCR0', 23);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0011', '挂失', 'F', 3, 'BCR0', 24);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0012', '解挂失', 'F', 3, 'BCR0', 25);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0007', '注销设备', 'F', 3, 'BCR0', 26);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('ICRS', '用户渠道增加', 'F', 3, 'BCR0', 30);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRT', '注销用户渠道', 'F', 3, 'BCR0', 31);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRS', '增加用户渠道保存', 'F', 3, 'BCR0', 32);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRW', '用户详细信息打印', 'F', 3, 'BCR0', 40);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCRO', '激活设备页面', 'F', 3, 'BCR0', 41);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('0016', '激活设备', 'F', 3, 'BCR0', 42);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT1', '电话注册:客户查询', 'F', 3, 'BCT0', 1);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT2', '电话注册:客户详细信息', 'F', 3, 'BCT0', 2);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT3', '电话注册:客户修改初始化', 'F', 3, 'BCT0', 3);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT4', '电话注册:客户信息修改提交', 'F', 3, 'BCT0', 4);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT6', '电话注册:客户信息增加提交', 'F', 3, 'BCT0', 6);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT7', '电话注册:客户注销', 'F', 3, 'BCT0', 7);
INSERT INTO "EAP_ADM"."EAP_MENU" (MENU_ID, MENU_NAME, MENU_TYPE, MENU_LVL, PARENT_ID, SORT_NO) VALUES ('BCT8', '电话注册:客户详细信息打印', 'F', 3, 'BCT0', 8);
COMMIT;

INSERT INTO "EAP_ADM"."EAP_ROLE" ( ROLE_ID, ROLE_NAME, ROLE_DESC, ROLE_TYPE, SORT_NO, CREATE_OPERATOR, CREATE_DATETIME, MODIFY_OPERATOR, MODIFY_DATETIME ) VALUES ( '0000', '系统管理员', '具有所有权限', 'W', 0, '000000', '20070801      ', '000000', '20070929091348');
COMMIT;

INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCR0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCR5', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M102', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCT0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCT5', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCC0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BCB0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M005', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUA1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUB1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUC1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUD1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUE1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BUF1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M002', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'IPC0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BPU1', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'IPR0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'IPT0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BPD0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M003', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BRS0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BRP0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'IRA0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'BRL0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'IAT0', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M004', 'M', '000000', '20071123115024');
INSERT INTO "EAP_ADM"."EAP_ROLE_MENU_API_MAP" (ROLE_ID, MENU_API_ID, MENU_API_TYPE, CREATE_OPERATOR, CREATE_DATETIME) VALUES ('0000', 'M101', 'M', '000000', '20071123115024');
COMMIT;

INSERT INTO "EAP_ADM"."EAP_UNIT" ( UNIT_ID, UNIT_NAME, UNIT_DESC, UNIT_STATUS, UPPER_UNIT_NO, CREATE_OPERATOR, CREATE_DATETIME, MODIFY_OPERATOR, MODIFY_DATETIME, DELETE_OPERATOR, DELETE_DATETIME ) VALUES ( '0000', '总部', NULL, 'N', 'ROOT', NULL, NULL, '000000', '20070929093210', NULL, NULL);
COMMIT;

INSERT INTO "EAP_ADM"."EAP_TELLER" ( TELLER_ID, TELLER_NAME, TELLER_DESC, TELLER_PSW, PSW_FAULTY_LOGIN, UNIT_ID, TELLER_TYPE, TELLER_STATUS, CREATE_OPERATOR, CREATE_DATETIME, MODIFY_OPERATOR, MODIFY_DATETIME, DELETE_OPERATOR, DELETE_DATETIME ) VALUES ( '000000', '系统管理员', NULL, '670b14728ad9902aecba32e22fa4f6bd', NULL, '0000', '0', 'N', '000000', '20070920000000', '000000', '20070929093018', NULL, NULL);
COMMIT;

INSERT INTO "EAP_ADM"."EAP_TELL_RMA_MAP" (TELLER_ID,ROLE_MENU_API_ID,ROLE_MENU_API_TYPE,CREATE_OPERATOR,CREATE_DATETIME,MODIFY_OPERATOR,MODIFY_DATETIME) VALUES ('000000','0000','R','000000','20070929093210', NULL, NULL);
COMMIT;