package cn.toso.ops.example.oath;

import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * This an example implementation of the OATH TOTP algorithm. Visit
 * www.openauthentication.org for more information.
 * 
 * TOTP: Time-based One-time Password Algorithm
 * 
 * @author Johan Rydell, PortWise
 */
public class TimebasedOnetimePassword {

    private TimebasedOnetimePassword() {
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
    // 0 1 2 3 4 5 6 7 8 9 10
    = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

    /**
         * This method generates an TOTP value for the given set of parameters.
         * 
         * @param key
         *                the shared secret, HEX encoded
         * @param time
         *                a value that reflects a time
         * @param returnDigits
         *                number of return digits
         * 
         * @return A numeric String in base 10 that includes
         *         {@link truncationDigits} digits
         */
    static public String generateTOTP(String key, String time, String returnDigits) {
	Integer codeDigits = Integer.decode(returnDigits);
	String crypto = "HmacSHA1";
	String result = null;
	byte[] bArray;

	byte[] msg = new byte[8];
	// Put the bytes of "time" to the message
	// Input is the HEX value of "time"
	if (time.length() > 0) {
	    bArray = new BigInteger(time, 16).toByteArray();

	    if (bArray.length == 9) {
		// First byte is the "sign" byte
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length] = bArray[i + 1];
		}
	    } else {
		for (int i = 0; i < 8 && i < bArray.length; i++) {
		    msg[i + 8 - bArray.length] = bArray[i];
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

	int otp = binary % DIGITS_POWER[codeDigits.intValue()];

	result = Integer.toString(otp);
	while (result.length() < codeDigits.intValue()) {
	    result = "0" + result;
	}
	return result;
    }

    public static void main(String[] args) {

	//String seed = "3132333435363738393031323334353637383930";
	String seed ="4C45B409121F21463200EF094004FFFA9B5E1DAD";
	String time = "0";

	Date myDate = Calendar.getInstance().getTime();
	BigInteger b = new BigInteger("0");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	df.setTimeZone(TimeZone.getTimeZone("UTC"));
	try {
	    System.out.println("+------------+-----------------------+------------------+--------+");
	    System.out.println("| Unix Time  |       UTC Time        |    Value of T    |  OTP   |");
	    System.out.println("+------------+-----------------------+------------------+--------+");

	    // sample for gen OTP base time "1000000000000"
	    myDate.setTime(Long.parseLong("1000000000000"));
	    System.out.print("| " + myDate.getTime() + " |  " + df.format(myDate) + "  |");
	    b = new BigInteger("0" + myDate.getTime());
	    b = b.divide(new BigInteger("30000"));
	    time = b.toString(16).toUpperCase();
	    while (time.length() < 16)
		time = "0" + time;
	    System.out.print(" " + time + " | ");
	    System.out.println(generateTOTP(seed, time, "9") + " |");

	    System.out.println("+------------+-----------------------+------------------+--------+");

	    // sample for gen OTP base time now
	    myDate.setTime(new Date().getTime());
	    System.out.print("| " + myDate.getTime() + " |  " + df.format(myDate) + "  |");
	    b = new BigInteger("0" + myDate.getTime());
	    b = b.divide(new BigInteger("30000"));
	    System.out.print("["+b+"]");
	    time = b.toString(16).toUpperCase();
	    
	    while (time.length() < 16)
		time = "0" + time;
	    System.out.print(" " + time + " | ");
	    System.out.println(generateTOTP(seed, time, "9") + " |");
	    

	    System.out.println("+------------+-----------------------+------------------+--------+");

	    // sample for event based OTP gen, parameter is counter.	   
	    myDate.setTime(Long.parseLong("0"));
	    System.out.print("| " + myDate.getTime() + " |  " + df.format(myDate) + "  |");
	    b = new BigInteger("0" + myDate.getTime());
	    time = b.toString(16).toUpperCase();
	    while (time.length() < 16)
		time = "0" + time;
	    System.out.print(" " + time + " | ");
	    System.out.println(generateTOTP(seed, time, "9") + " |");

	    System.out.println("+------------+-----------------------+------------------+--------+");

	    // sample for based challenge & response gen	    
	    myDate.setTime(Long.parseLong("00001111"));
	    System.out.print("| " + myDate.getTime() + " |  " + df.format(myDate) + "  |");
	    b = new BigInteger("0" + myDate.getTime());
	    time = b.toString(16).toUpperCase();
	    while (time.length() < 16)
		time = "0" + time;
	    System.out.print(" " + time + " | ");
	    System.out.println(generateTOTP(seed, time, "9") + " |");
	    System.out.println("+------------+-----------------------+------------------+--------+");

	} catch (final Exception e) {
	    System.out.println("Error : " + e);
	}
    }
}