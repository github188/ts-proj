package tower.cem.sample;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import org.apache.commons.net.telnet.TelnetClient;

public class NetTelent {

    // 设置终端类型包括，vt100、vt52、ansi 或 vtnt；选择了错误的终端类型，可能会使得返回信息乱码
    private TelnetClient telnet = new TelnetClient("vtnt");

    private InputStream in;

    private PrintStream out;

    // 命令行提示符
    private String prompt = "";

    // 登录用户名提示符
    private String loginPrompt = "login:";

    // 登录密码提示符
    private String passwordPrompt = "Password:";

    // 服务器响应超时
    private int timeOut = 5000;

    // 执行命令成功与否的标志，如服务器连接超时或没有读到指定提示符时返回false。
    public boolean bFlag = true;

    /**
         * 建立通讯连接，通常用于登录堡垒机或可以直接登录的服务器、网络设备。
         * 
         * @param ip
         *                服务器地址
         * @param port
         *                服务器端口号
         * @param user
         *                登录用户名
         * @param password
         *                登录密码
         * @param prom
         *                命令行提示符
         * @return 登录过程的提示信息；登录失败时返回null，通常是由于地址、端口、用户名或者密码错误，以及可能的命令行提示符设置错误导致。
         */
    public String FunLogin(String ip, String port, String user, String password, String prom) {

	StringBuffer returnResult = new StringBuffer();
	String result;

	try {

	    telnet.setDefaultTimeout(timeOut);
	    telnet.connect(ip, Integer.parseInt(port));

	    in = telnet.getInputStream();
	    out = new PrintStream(telnet.getOutputStream());

	    result = readUntil(loginPrompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	    write(user);

	    result = readUntil(passwordPrompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	    write(password);

	    // 替换命令行提示符
	    this.prompt = prom;
	    result = readUntil(prompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	} catch (ConnectException ec) {
	    bFlag = false;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return returnResult.toString();
    }

    /**
         * 在登录堡垒主机后，再次登录其他服务器或网络设备。
         * 
         * @param ip
         *                服务器地址
         * @param port
         *                服务器端口
         * @param user
         *                登录用户名
         * @param password
         *                登录密码
         * @param prom
         *                命令行提示符
         * @return 登录过程的提示信息；登录失败时返回null，通常是由于地址、端口、用户名或者密码错误，以及可能的命令行提示符设置错误导致。
         */
    public String FunRelogin(String ip, String port, String user, String password, String prom) {

	String result;
	StringBuffer returnResult = new StringBuffer();

	try {
	    write("telnet " + ip + " " + port);

	    result = readUntil(loginPrompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	    write(user);

	    result = readUntil(passwordPrompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	    write(password);

	    this.prompt = prom;
	    result = readUntil(prompt);
	    returnResult.append(result);
	    if (bFlag == false) {
		return returnResult.toString();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return returnResult.toString();
    }

    /**
         * 读取至以匹配符结束
         * 
         * @param pattern
         * @return
         */
    public String readUntil(String pattern) {

	bFlag = true;

	StringBuffer sb = new StringBuffer();

	try {
	    char lastChar = pattern.charAt(pattern.length() - 1);
	    char ch = (char) in.read();

	    while (true) {
		sb.append(ch);
		if (ch == lastChar) {
		    if (sb.toString().endsWith(pattern)) {
			return sb.toString();
		    }
		}
		ch = (char) in.read();
	    }
	} catch (SocketTimeoutException eTimeout) {
	    bFlag = false;
	} catch (Exception e) {
	    bFlag = false;
	    e.printStackTrace();
	}
	return sb.toString();
    }

    /**
         * 写入命令或字符
         * 
         * @param value
         */
    public void write(String value) {
	try {
	    out.println(value);
	    out.flush();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
         * 写入命令或字符，并读取至以匹配符结束
         * 
         * @param command
         * @return
         */
    public String sendCommand(String command) {
	try {
	    write(command);
	    return readUntil(prompt);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    /**
         * 断开与服务器的连接
         * 
         */
    public void disconnect() {
	try {
	    telnet.disconnect();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	try {

	    String result;
	    NetTelent telent = new NetTelent();

	    // 登录第一个服务器
	    result = telent.FunLogin("60.209.94.194", "23", "ecode315", "password", "$");
	    System.out.print(result);

	    // 判断是否登录成功
	    if (telent.bFlag == false) {
		System.out.println("Failed to login server!");
	    } else {
		// 命令是 ll 列出当前目录下的目录及文件
		result = telent.sendCommand("ll");
		System.out.print(result);

		// 命令是 pwd 查看当前所在目录
		result = telent.sendCommand("pwd");
		System.out.print(result);

		// 通过第一台服务器登录第二台服务器（模拟通过堡垒机登录的情况）
		result = telent.FunRelogin("192.168.1.254", "23", "oracle", "password", "$");
		System.out.print(result);

		// 判断是否登录成功
		if (telent.bFlag == false) {
		    System.out.println("Failed to re-login server!");
		} else {
		    // 命令是 ll 列出当前目录下的目录及文件
		    result = telent.sendCommand("ll");
		    System.out.print(result);

		    // 从第二台服务器退出
		    telent.write("exit");
		}

		// 关闭登录连接
		telent.disconnect();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
