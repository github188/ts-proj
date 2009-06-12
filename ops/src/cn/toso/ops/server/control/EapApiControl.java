package cn.toso.ops.server.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import tmvc.common.ConnectionPool;
import tmvc.common.ErrorException;
import tmvc.common.FatalException;
import tmvc.common.QueryResult;
import tmvc.common.QueryResultRow;
import tmvc.common.RootBo;
import tmvc.common.Transaction;
import tmvc.common.XMLWrap;
import tmvc.common.config.ErrorMsgConfig;
import tmvc.common.config.Function;
import tmvc.common.config.FunctionConfig;
import tmvc.common.config.TransactionConfig;
import tower.tmvc.ErrorException;
import tower.tmvc.FatalException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.config.ConfigHolder;
import tower.tmvc.config.ErrorMessageConfig;
import tower.tmvc.config.FunctionConfig;
import tower.tmvc.config.TransactionConfig;
import cn.toso.ops.util.AuthServerConnPara;

public class EapApiControl {
    public String functionsXmlPath;

    public String transactionXmlPath;

    public String errorMsgXmlPath;

    public String authServerConnParaFilePath;

    public FunctionConfig funcConf;

    public TransactionConfig transConf;

    public ErrorMessageConfig errorConf;

    public AuthServerConnPara authServerConnPara;
    
    protected ConfigHolder configHolder;

    public static ConnectionPool POOL = new ConnectionPool();

    static {
	POOL.setConnFreeTime(10);
	POOL.setMaxSize(40);
	POOL.setMinSize(2);
    }

    /**
         * 日志记录工具：apache Log4j
         */
    protected Logger logger;

    public EapApiControl() {
    }

    public void init(String functionsXmlPath, String transactionXmlPath, String errorMsgXmlPath,
	    String authServerConnParaFilePath) throws ControlInitException {
	this.functionsXmlPath = functionsXmlPath;
	this.transactionXmlPath = transactionXmlPath;
	this.errorMsgXmlPath = errorMsgXmlPath;
	this.authServerConnParaFilePath = authServerConnParaFilePath;

	SAXBuilder builder = new SAXBuilder();
	try {
	    // 读取配置事务
	    this.transConf = (TransactionConfig) this.buildConfig(transactionXmlPath, builder, 0);
	    // 读取配置功能
	    this.funcConf = (FunctionConfig) this.buildConfig(functionsXmlPath, builder, 1);
	    // 读取配置错误信息
	    this.errorConf = (ErrorMsgConfig) this.buildConfig(errorMsgXmlPath, builder, 2);

	    // authServerConnPara =
                // AuthServerConnPara.createConfig(authServerConnParaFilePath);
	} catch (FatalException e) {
	    throw new ControlInitException(e);
	} catch (JDOMException e) {
	    throw new ControlInitException(e);
	} catch (IOException e) {
	    throw new ControlInitException(e);
	}
	logger = Logger.getLogger(this.getClass());
    }

    public void service(XMLWrap packetHeaderXml, XMLWrap packetXml) throws ErrorException {

	Transaction transaction = null;
	Logger boLogger = null;
	String funcId;
	Function func = null;
	RootBo bo;

	String logDbConnId = null;
	String tradeDate = packetHeaderXml.getInputValue("TRDATE");
	String tradeTime = packetHeaderXml.getInputValue("TRTIME");
	String seqNo = packetHeaderXml.getInputValue("SEQ_NO");

	// 创建事务
//	transaction = new Transaction(this.transConf, POOL);
	transaction = new Transaction(this.configHolder
		.getTransactionConfigSet());

	try {
	    // 获取功能号
	    funcId = packetXml.getInputValue("FUNC_ID");

	    // 开始事务
	    transaction.beginTransaction();

	    // 检查权限
	    // checkRights(transaction, packetHeaderXml);

	    /*--- 记录日志到数据库 ---*/
	    // logDbConnId = transaction.createConnection("loggerDB", true);
	    // this.insertLog(packetHeaderXml, packetXml, transaction,
                // logDbConnId, tradeDate, tradeTime, seqNo);
	    // 获取功能
	    func = this.getFunctionInfo(funcId);

	    if (func.getType() == Function.TYPE_BO) {
		try {
		    // System.out.println("TIME CREATE BO BGN\t"
		    // + System.currentTimeMillis());
		    bo = (RootBo) func.getBoClass().newInstance();
		    // System.out.println("TIME CREATE BO END\t"
		    // + System.currentTimeMillis());
		} catch (InstantiationException e) {
		    // TS0007=BO实例化错误
		    throw new ErrorException("TS0007", new Object[] { func.getBoClassName() });
		} catch (IllegalAccessException e) {
		    // TS0008=BO非法访问错误
		    throw new ErrorException("TS0008", new Object[] { func.getBoClassName() });
		}
		// 日志
		// boLogger = Logger.getLogger(bo.getClass());

		// 执行业务逻辑
		bo.doBusiness(transaction, packetXml, packetHeaderXml, null, boLogger);

	    }

	    // 更新日志:操作成功
	    // System.out.println("TIME UPDATE LOG BGN\t"
	    // + System.currentTimeMillis());
	    this.updateLog(packetHeaderXml, packetXml, transaction, logDbConnId, tradeDate, tradeTime, seqNo);
	    // System.out.println("TIME UPDATE LOG END\t"
	    // + System.currentTimeMillis());
	    logDbConnId = null; // 成功记录日志后,不进行finally部分中的记日志

	    // System.out.println("TIME END TRANS BGN\t"
	    // + System.currentTimeMillis());
	    transaction.endTransaction(true);
	    // System.out.println("TIME END TRANS END\t"
	    // + System.currentTimeMillis());
	} catch (ErrorException e) {
	    String retCode = e.getCode();
	    if (packetHeaderXml.getInputRowCount("RETCODE") == 0) {
		packetHeaderXml.addInputRow("RETCODE");
	    }
	    packetHeaderXml.setInputValue("RETCODE", 1, retCode);
	    throw e;
	} finally {
	    if (logDbConnId != null) {
		// 更新日志:操作失败
		this.updateLog(packetHeaderXml, packetXml, transaction, logDbConnId, tradeDate, tradeTime,
			seqNo);
	    }
	    if (transaction != null) {
		try {
		    transaction.endTransaction(false);
		} catch (ErrorException e) {
		    e.printStackTrace();
		    // do nothing
		}
	    }
	}
    }

    static final String LOG_SQL_JUDGE = "SELECT TRADE_DATE FROM EAP_TRADE_LOG WHERE ROWNUM=1";

    static final String LOG_SQL_COPY = "INSERT INTO EAP_TRADE_LOG_HIS SELECT * FROM EAP_TRADE_LOG";

    static final String LOG_SQL_TRUNCATE = "TRUNCATE TABLE EAP_TRADE_LOG";

    /**
         * 检查当前日志表中是否有与TRDATE不同的记录,若有,则将当前日志表所有记录移至历史表,并清空当前日志表
         * 
         * @param transaction
         *                事务
         * @param connId
         *                日志数据库ID
         * @param curTradeDate
         *                当前交易日期
         */
    void moveLog(Transaction transaction, String connId, String curTradeDate) {
	try {
	    QueryResult qr = transaction.doQuery(connId, LOG_SQL_JUDGE);
	    if (qr.size() > 0) {
		if (!curTradeDate.equals(qr.get(0).getString(1))) {
		    transaction.doUpdate(connId, LOG_SQL_COPY);

		    transaction.doUpdate(connId, LOG_SQL_TRUNCATE);
		}
	    }
	} catch (ErrorException e) {
	    logger.error("moveLog()", e);
	}
    }

    private void insertLog(XMLWrap packetHeaderXml, XMLWrap packetXml, Transaction transaction,
	    String connId, String tradeDate, String tradeTime, String seqNo) {
	/*
         * DbEapTradeLog dbLog = new DbEapTradeLog(transaction, connId);
         * EnEapTradeLog enLog = new EnEapTradeLog();
         * 
         * enLog.setTradeDate(tradeDate); enLog.setTradeTime(tradeTime);
         * enLog.setSeqNo(seqNo); // enLog.setTecclDate(tecclDate); //
         * enLog.setTecclTime(tecclTime); //
         * enLog.setTecclSessionId(tecclSessionId);
         * enLog.setAppCode(packetHeaderXml.getInputValue("APPCODE"));
         * enLog.setChannelCode(packetHeaderXml.getInputValue("CHANNELCODE"));
         * enLog.setUnitNo(packetHeaderXml.getInputValue("UNITNO"));
         * enLog.setDeviceNo(packetHeaderXml.getInputValue("DEVICENO"));
         * enLog.setTellerId(packetHeaderXml.getInputValue("TELLID"));
         * enLog.setTradeCode(packetHeaderXml.getInputValue("TRCODE"));
         * enLog.setOtpCardType(packetHeaderXml.getInputValue("OTP_CARD_TYPE"));
         * enLog.setTradeRequest(PubFunc.CutByByteLen(packetHeaderXml.toString() +
         * packetXml.toString(), 2000));
         * 
         * try { dbLog.insert(enLog); } catch (ErrorException e) {
         * logger.error("insertLog()", e); }
         */
    }

    private void updateLog(XMLWrap packetHeaderXml, XMLWrap packetXml, Transaction transaction,
	    String connId, String tradeDate, String tradeTime, String seqNo) {

    }

    private Object buildConfig(String filePath, SAXBuilder builder, int index) throws FatalException,
	    JDOMException, IOException {
	InputStream inputStream;
	Document document;

	inputStream = new FileInputStream(filePath);
	document = builder.build(inputStream);
	switch (index) {
	case 0:
	    return new TransactionConfig(document);
	case 1:
	    return new FunctionConfig(document);
	case 2:
	    return new ErrorMsgConfig(document);
	case 3:
	default:
	    return null;
	}
    }

    synchronized protected Function getFunctionInfo(String funcId) throws ErrorException {
	Function function = null;
	if (funcId == null || funcId.length() == 0) {
	    // TS0001=未提交功能号！
	    throw new ErrorException("TS0001", null);
	}
	function = this.funcConf.getFunction(funcId);
	if (function == null) {
	    String error = this.funcConf.getFunctionError(funcId);
	    Object[] errorInfos;
	    if (error == null) {
		if (logger.isInfoEnabled()) {
		    errorInfos = this.funcConf.getCommonError();
		    for (int i = 0; i < errorInfos.length; i++) {
			logger.warn(errorInfos[i]);
		    }
		}
		errorInfos = new String[] { funcId };
	    } else {
		errorInfos = new String[] { funcId + ":" + error };
	    }
	    // TS0001=未配置的功能号！
	    throw new ErrorException("TS0002", errorInfos);
	}
	return function;
    }

    synchronized protected void checkRights(Transaction transaction, XMLWrap packetHeaderXml)
	    throws ErrorException {
	String trCode;
	String tellId;
	String unitNo;
	String deviceNo;
	QueryResult qr;
	QueryResultRow qrRow;

	trCode = packetHeaderXml.getInputValue("TRCODE");
	// tellId = packetHeaderXml.getInputValue("TELLID");
	// unitNo = packetHeaderXml.getInputValue("UNITNO");
	deviceNo = packetHeaderXml.getInputValue("DEVICENO");

	// 创建连接
	// System.out.println("TIME CREATE CHK CONN BGN\t"
	// + System.currentTimeMillis());
	transaction.createDefaultConnection(null, true);
	// System.out.println("TIME CREATE CHK CONN END\t"
	// + System.currentTimeMillis());

	// 检查设备,设备状态,对应柜员
	// System.out
	// .println("TIME DEVICE CHK BGN\t" + System.currentTimeMillis());
	StringBuffer sqlDevice = new StringBuffer();
	sqlDevice.append("SELECT ");
	sqlDevice.append("    DEVICE_STATUS,DEVICE_TELLER_ID,UNIT_ID ");
	sqlDevice.append("FROM ");
	sqlDevice.append("    EAP_DEVICE A ");
	sqlDevice.append("WHERE ");
	sqlDevice.append("    A.DEVICE_ID= ");
	sqlDevice.append(Transaction.formatString(deviceNo));
	// sqlDevice.append(" AND A.DEVICE_STATUS='N' ");
	// sqlDevice.append(" AND A.DEVICE_TELLER_ID= ");
	// sqlDevice.append(Transaction.formatString(tellId));

	qr = transaction.doQuery(null, sqlDevice.toString());

	if (qr.size() == 0) {
	    // 设置错误码
	    // SCHK01=设备不存在或设备被锁定或对应自动柜员不匹配
	    throw new ErrorException("SCHK01", null);
	}
	qrRow = qr.get(0);
	if (!("N".equals(qrRow.getString(1)))) {
	    // 设置错误码
	    // SCHK01=设备不存在或设备被锁定或对应自动柜员不匹配
	    throw new ErrorException("SCHK01", null);
	}
	tellId = qrRow.getString(2);
	unitNo = qrRow.getString(3);
	if (packetHeaderXml.getInputRowCount("TELLID") == 0) {
	    packetHeaderXml.addInputRow("TELLID");
	}
	packetHeaderXml.setInputValue("TELLID", 1, tellId);
	if (packetHeaderXml.getInputRowCount("UNITNO") == 0) {
	    packetHeaderXml.addInputRow("UNITNO");
	}
	packetHeaderXml.setInputValue("UNITNO", 1, unitNo);

	// System.out
	// .println("TIME DEVICE CHK END\t" + System.currentTimeMillis());

	// 检查柜员,柜员状态,对应机构
	// System.out.println("TIME TELL CHK BGN\t" +
	// System.currentTimeMillis());
	// StringBuffer sql = new StringBuffer();
	// sql.append("SELECT ");
	// sql.append(" TELLER_TYPE,TELLER_STATUS,UNIT_ID ");
	// sql.append("FROM ");
	// sql.append(" EAP_TELLER A ");
	// sql.append("WHERE ");
	// sql.append(" A.TELLER_ID= ");
	// sql.append(Transaction.formatString(tellId));
	// sql.append(" AND A.TELLER_TYPE='1' ");
	// sql.append(" AND A.TELLER_STATUS='N' ");
	// sql.append(" AND A.UNIT_ID= ");
	// sql.append(Transaction.formatString(unitNo));

	// qr = transaction.doQuery(null, sql.toString());
	//
	// if (qr.size() == 0) {
	// // SCHK02=柜员不存在或柜员被注销或对应机构不匹配
	// throw new ErrorException("SCHK02", null);
	// }
	// qrRow = qr.get(0);
	// if (!("1".equals(qrRow.getString(1)) &&
	// "N".equals(qrRow.getString(2)) && unitNo
	// .equals(qrRow.getString(3)))) {
	// // SCHK02=柜员不存在或柜员被注销或对应机构不匹配
	// throw new ErrorException("SCHK02", null);
	// }
	// System.out.println("TIME TELL CHK END\t" +
	// System.currentTimeMillis());

	// 检查柜员权限
	// System.out
	// .println("TIME RIGHTS CHK BGN\t" + System.currentTimeMillis());
	StringBuffer sqlTrCode = new StringBuffer();
	sqlTrCode.append("SELECT ");
	sqlTrCode.append("    1 ");
	sqlTrCode.append("FROM ");
	sqlTrCode.append("    EAP_TELL_RMA_MAP A ");
	sqlTrCode.append("WHERE ");
	sqlTrCode.append("    A.TELLER_ID= ");
	sqlTrCode.append(Transaction.formatString(tellId));
	sqlTrCode.append("    AND A.ROLE_MENU_API_ID= ");
	sqlTrCode.append(Transaction.formatString(trCode));
	sqlTrCode.append("    AND A.ROLE_MENU_API_TYPE='A' ");
	sqlTrCode.append("UNION ALL ");
	sqlTrCode.append("SELECT ");
	sqlTrCode.append("    1 ");
	sqlTrCode.append("FROM ");
	sqlTrCode.append("    EAP_TELL_RMA_MAP A, ");
	sqlTrCode.append("    EAP_ROLE_MENU_API_MAP B ");
	sqlTrCode.append("WHERE ");
	sqlTrCode.append("    A.ROLE_MENU_API_ID=B.ROLE_ID ");
	sqlTrCode.append("    AND B.MENU_API_ID= ");
	sqlTrCode.append(Transaction.formatString(trCode));
	sqlTrCode.append("    AND B.MENU_API_TYPE='A' ");
	sqlTrCode.append("    AND A.TELLER_ID= ");
	sqlTrCode.append(Transaction.formatString(tellId));
	sqlTrCode.append("    AND A.ROLE_MENU_API_TYPE='R' ");

	if (transaction.doQuery(null, sqlTrCode.toString()).size() == 0) {
	    // SCHK03=柜员权限不足.
	    throw new ErrorException("SCHK03", null);
	}
	// System.out
	// .println("TIME RIGHTS CHK END\t" + System.currentTimeMillis());
    }
}
