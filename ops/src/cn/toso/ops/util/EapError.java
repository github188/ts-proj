package cn.toso.ops.util;

public class EapError {

	public static final String UndefinedException = "AP0000";

	public static final String BUS_USER_NOT_EXISTED = "AP0001";

	public static final String BUS_USER_LOCKED = "AP0002";

	public static final String ECODE_UNKNOWN_CARD = "AP0003";

	public static final String BUS_CARD_BLOCKED = "AP0004";

	public static final String BUS_CARD_ACTIVATED = "AP0005";

	public static final String ECODE_CARD_USER_NOT_MATCHED = "AP0006";

	public static final String ECODE_CARD_ACTIVATE_CODE = "AP0007";

	public static final String ECODE_CARD_ACTIVATE_ERR = "AP0008";

	public static final String BadResponseException = "AP0009";

	public static final String FilterException = "AP0010";

	public static final String MessageBuilderException = "AP0011";

	public static final String SocketErrorException = "AP0012";

	public static final String BUS_USER_EXISTED = "AP0013";

	public static final String BUS_ECODE_USER_EXISTED = "AP0014";

	public static final String ECODE_CARD_CREATE_ERR = "AP0015";

	public static final String ECODE_USER_CREATE_ERR = "AP0016";

	public static final String BUS_USER_MULTIUSER = "AP0017";

	public static final String ECODE_CARD_BLOCK_ERR = "AP0018";

	public static final String ECODE_USER_BLOCK_ERR = "AP0019";

	public static final String BUS_CHANNEL_EXISTED = "AP0020";

	public static final String BUS_CHANNEL_NOT_EXISTED = "AP0021";

	public static final String BUS_USER_ONLYUSER = "AP0022";

	public static final String ECODE_CARD_LOCK_ERR = "AP0023";

	public static final String ECODE_CARD_UNLOCK_ERR = "AP0024";

	public static final String BUS_CARD_LOCKED = "AP0025";

	public static final String BUS_CARD_GENERATOR_LOCKED = "AP0026";

	public static final String ECODE_VERIFYCODE_ERR = "AP0027";

	public static final String BUS_NO_SUIT_DEVICE = "AP0028";

	public static final String ECODE_GETSEQ_ERR = "AP0029";

	public static final String ECODE_SUPERVERIFYCODE_ERR = "AP0030";

	public static final String ECODE_UNLOCKOTP_ERR = "AP0031";

	public static final String BUS_CARD_REGISTERED = "AP0032";

	public static final String ECODE_CARD_REPLEASE1_ERR = "AP0033";

	public static final String ECODE_CARD_REPLEASE2_ERR = "AP0034";

	public static final String ECODE_GETPREFIX_ERR = "AP0036";

	public static final String BUS_USER_CREATE1_ERR = "AP0037";

	public static final String BUS_USER_CREATE2_ERR = "AP0038";

	public static final String BUS_USER_UPDATE_ERR = "AP0039";

	public static final String BUS_CHANNEL_CREATE_ERR = "AP0040";

	public static final String BUS_CHANNEL_BLOCK_ERR = "AP0041";

	public static final String BUS_USER_LOCK_ERR = "AP0042";

	public static final String BUS_USER_UNLOCK_ERR = "AP0043";

	public static final String BUS_USER_BLOCK1_ERR = "AP0044";

	public static final String BUS_CARD_FUTURE = "AP0045";

	public static final String NOT_DEFINE_PRINTED_CARD = "AP0046";

	public static final String CALL_ECODE_ERROR = "AP0047";

	public static final String NOT_DEFINE_MATRIX_CARD = "AP0048";

	public static final String BUS_CARD_NOT_REGISTERED = "AP0049";
	
	public static final String NOT_DEFINE_DA_CARD = "AP0050";
	
	public static final String NOT_DEFINE_SMS_CARD = "AP0051";
	
	public static final String BUS_NO_SUIT_USER_CHANNEL = "AP0052";
	
	public static final String BUS_UNKNOWN_CARD = "AP0053";
	
	public static final String NOT_SUPPORT_CARD_TYPE = "AP0054";

	/**
	 * 将调用ECODE方法的返回值转换为EAP的错误返回码
	 * 
	 * @param eapErrorCode
	 * @return
	 */
	public synchronized static String errorEcode2Eap(int res) {
		String eapCode = "";
		switch (res) {
		case 0:
			eapCode = "000000";// CALL_ECODE_RET_SUCCESS
			break;
		case 1:
			eapCode = "000000";// CALL_ECODE_RET_SUCCESS
			break;
		case 10:
			eapCode = "EC0010";// CALL_ECODE_RET_WRONGOTP
			break;
		case 11:
			eapCode = "EC0011";// CALL_ECODE_RET_DBERROR
			break;
		case 12:
			eapCode = "EC0012";// CALL_ECODE_RET_SMERROR
			break;
		case 13:
			eapCode = "EC0013";// CALL_ECODE_RET_DBANDSMERROR
			break;
		case 14:
			eapCode = "EC0014";// CALL_ECODE_RET_UNKNOWNCARD
			break;
		case 15:
			eapCode = "EC0015";// CALL_ECODE_RET_LOCKED
			break;
		case 16:
			eapCode = "EC0016";// CALL_ECODE_RET_EXPIRED
			break;
		case 17:
			eapCode = "EC0017";// CALL_ECODE_RET_OUTOFSYNC
			break;
		case 18:
			eapCode = "EC0018";// CALL_ECODE_RET_UNKNOWNUSER
			break;
		case 31:
			eapCode = "EC0031";// CALL_ECODE_RET_APPINVALID
			break;
		case 42:
			eapCode = "EC0042";// CALL_ECODE_RET_LOSTKEY
			break;
		case 62:
			eapCode = "EC0062";// CALL_ECODE_RET_DATAEXISTED
			break;
		case 70:
			eapCode = "EC0070";// CALL_ECODE_RET_PARAFMTERR
			break;
		case 80:
			eapCode = "EC0080";// CALL_ECODE_RET_REQFMTERR
			break;
		default:
			eapCode = "EC0099";// CALL_ECODE_RET_OTHER
			break;
		}
		return eapCode;
	}

}
