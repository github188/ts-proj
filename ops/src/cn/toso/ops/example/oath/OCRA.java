package cn.toso.ops.example.oath;

import java.lang.reflect.UndeclaredThrowableException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

/**
 * This an example implementation of the OATH OCRA algorithm. Visit
 * www.openauthentication.org for more information.
 * 
 * @author Johan Rydell, PortWise
 */

public class OCRA {

    private OCRA() {
    }

    /**
         * This method uses the JCE to provide the crypto algorithm. HMAC
         * computes a Hashed Message Authentication Code with the crypto hash
         * algorithm as a parameter.
         * 
         * @param crypto
         *                the crypto algorithm (HmacSHA1, HmacSHA256,
         *                HmacSHA512)
         * @param keyBytes
         *                the bytes to use for the HMAC key
         * @param text
         *                the message or text to be authenticated.
         */
    public static byte[] hmac_sha1(String crypto, byte[] keyBytes, byte[] text) {
	try {
	    Mac hmac;
	    hmac = Mac.getInstance(crypto);
	    SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
	    hmac.init(macKey);
	    return hmac.doFinal(text);
	} catch (GeneralSecurityException gse) {
	    throw new UndeclaredThrowableException(gse);
	}
    }

    private static final int[] DIGITS_POWER
    // 0 1 2 3 4 5 6 7 8
    = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

    /**
         * This method generates an OCRA HOTP value for the given set of
         * parameters.
         * 
         * @param ocraSuite
         *                the OCRA Suite
         * @param key
         *                the shared secret, HEX encoded
         * @param counter
         *                the counter that changes on a per use basis, HEX
         *                encoded
         * @param question
         *                the challenge question
         * @param password
         *                a password that can be used
         * @param sessionInformation
         *                Static information that identifies the current session
         * @param timeStamp
         *                a value that reflects a time
         * 
         * @return A numeric String in base 10 that includes
         *         {@link truncationDigits} digits
         */
    static public String generateOCRA(String ocraSuite, String key, String counter, String question,
	    String password, String sessionInformation, String timeStamp) {

	int codeDigits = 0;
	String crypto = "";
	String result = null;
	int ocraSuiteLength = ocraSuite.length();
	int counterLength = 0;
	int questionLength = 0;
	int passwordLength = 0;
	int sessionInformationLength = 0;
	int timeStampLength = 0;

	if (ocraSuite.toLowerCase().indexOf("sha1") > 1)
	    crypto = "HmacSHA1";
	if (ocraSuite.toLowerCase().indexOf("sha256") > 1)
	    crypto = "HmacSHA256";
	if (ocraSuite.toLowerCase().indexOf("sha512") > 1)
	    crypto = "HmacSHA512";

	// How many digits should we return
	String oS = ocraSuite.substring(ocraSuite.indexOf(":"), ocraSuite.indexOf(":",
		ocraSuite.indexOf(":") + 1));

	codeDigits = Integer.decode(oS.substring(oS.lastIndexOf("-") + 1, oS.length())).intValue();

	// The size of the byte array message to be encrypted
	// Counter
	if (ocraSuite.toLowerCase().indexOf(":c") > 1) {
	    counterLength = 8;
	}
	// Question
	if ((ocraSuite.toLowerCase().indexOf(":q") > 1) || (ocraSuite.toLowerCase().indexOf("-q") > 1)) {
	    questionLength = 128;
	}

	// Password
	if ((ocraSuite.toLowerCase().indexOf(":p") > 1) || (ocraSuite.toLowerCase().indexOf("-p") > 1)) {
	    passwordLength = 20;
	}

	// sessionInformation
	if ((ocraSuite.toLowerCase().indexOf(":s") > 1)
		|| (ocraSuite.toLowerCase().indexOf("-s", ocraSuite.indexOf(":", ocraSuite.indexOf(":") + 1)) > 1)) {
	    sessionInformationLength = 64;
	}
	// TimeStamp
	if ((ocraSuite.toLowerCase().indexOf(":t") > 1) || (ocraSuite.toLowerCase().indexOf("-t") > 1)) {
	    timeStampLength = 8;
	}

	// Remember to add "1" for the "00" byte delimiter
	byte[] msg = new byte[ocraSuiteLength + counterLength + questionLength + passwordLength
		+ sessionInformationLength + timeStampLength + 1];

	// Put the bytes of "ocraSuite" parameters
	// into the message
	byte[] bArray = ocraSuite.getBytes();
	for (int i = 0; i < bArray.length; i++) {
	    msg[i] = bArray[i];
	}

	// Put the bytes of "Counter" to the message
	// Input is HEX encoded
	if (counter.length() > 0) {
	    bArray = new BigInteger(counter, 16).toByteArray();
	    if (bArray.length == 9) {
		// First byte is the "sign" byte
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length + ocraSuiteLength + 1] = bArray[i + 1];
		}
	    } else {
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length + ocraSuiteLength + 1] = bArray[i];
		}
	    }
	}

	// Put the bytes of "question" to the message
	// Input is text encoded
	if (question.length() > 0) {
	    bArray = question.getBytes();
	    for (int i = 0; i < 128 && i < bArray.length; i++) {
		msg[i + ocraSuiteLength + 1 + counterLength] = bArray[i];
	    }
	}

	// Put the bytes of "password" to the message
	// Input is HEX encoded
	if (password.length() > 0) {
	    bArray = new BigInteger(password, 16).toByteArray();
	    if (bArray.length == 21) {
		// First byte is the "sign" byte
		for (int i = 0; i < 20 && i < bArray.length; i++) {
		    msg[i + ocraSuiteLength + 1 + counterLength + questionLength] = bArray[i + 1];
		}
	    } else {
		for (int i = 0; i < 20 && i < bArray.length; i++) {
		    msg[i + ocraSuiteLength + 1 + counterLength + questionLength] = bArray[i];
		}
	    }
	}

	// Put the bytes of "sessionInformation" to the message
	// Input is text encoded

	if (sessionInformation.length() > 0) {
	    bArray = sessionInformation.getBytes();
	    for (int i = 0; i < 128 && i < bArray.length; i++) {
		msg[i + ocraSuiteLength + 1 + counterLength + questionLength + passwordLength] = bArray[i];
	    }
	}

	// Put the bytes of "time" to the message
	// Input is text value of minutes
	if (timeStamp.length() > 0) {
	    bArray = new BigInteger(timeStamp, 16).toByteArray();
	    if (bArray.length == 9) {
		// First byte is the "sign" byte
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length + ocraSuiteLength + 1 + counterLength + questionLength
			    + passwordLength + sessionInformationLength] = bArray[i + 1];
		}
	    } else {
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length + ocraSuiteLength + 1 + counterLength + questionLength
			    + passwordLength + sessionInformationLength] = bArray[i];
		}
	    }
	}

	byte[] hash;
	bArray = new BigInteger(key, 16).toByteArray();
	if (bArray[0] == 0) {
	    byte[] b = new byte[bArray.length - 1];
	    for (int i = 0; i < b.length; i++)
		b[i] = bArray[i + 1];
	    hash = hmac_sha1(crypto, b, msg);
	} else {
	    // compute hmac hash
	    hash = hmac_sha1(crypto, bArray, msg);
	}

	// put selected bytes into result int
	int offset = hash[hash.length - 1] & 0xf;

	int binary = ((hash[offset] & 0x7f) << 24) | ((hash[offset + 1] & 0xff) << 16)
		| ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff);

	int otp = binary % DIGITS_POWER[codeDigits];

	result = Integer.toString(otp);

	while (result.length() < codeDigits) {
	    result = "0" + result;
	}
	return result;
    }

    public static void main(String[] args) {

	String seed = "3132333435363738393031323334353637383930";
	// String seed ="00000000857C04259B10FEC2D9B657F8BC40C8AD";
	String time = "0";

	Date myDate = Calendar.getInstance().getTime();
	BigInteger b = new BigInteger("0");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	df.setTimeZone(TimeZone.getTimeZone("UTC"));

	try {
	    // static public String generateOCRA(String ocraSuite, String
                // key,
	    // String counter, String question, String password,
	    // String sessionInformation, String timeStamp)

	    System.out.println("OCRA Code:"
		    + generateOCRA("OCRA-1:HOTP-SHA512-8:C-QN08", seed, "0", "00000000", "", "", ""));
	} catch (Exception e) {
	    System.out.print("err:" + e.getMessage());
	}
    }
}
