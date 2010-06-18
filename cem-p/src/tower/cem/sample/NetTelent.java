package tower.cem.sample;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketTimeoutException;

import org.apache.commons.net.telnet.TelnetClient;

public class NetTelent {

    // Telnet对象
    // 终端类型包括，vt100、vt52、ansi 或 vtnt；选择了错误的终端类型，可能会使得返回信息乱码
    private TelnetClient telnet = new TelnetClient("vtnt");

    private InputStream in;

    private PrintStream out;

    // 提示符。具体请telnet到路由器查看
    private String prompt = "";

    public String FuncLogin(String ip, String port, String user, String password, String prom) {

	StringBuffer returnResult = new StringBuffer();	
	String result;

	try {
	    // 路由器IP 注：我这里模拟telnet登录linux服务器
	    telnet.setDefaultTimeout(5000);
	    telnet.connect(ip, Integer.parseInt(port));

	    in = telnet.getInputStream();
	    out = new PrintStream(telnet.getOutputStream());

	    result = readUntil("login:");
	    returnResult.append(result);

	    write(user);

	    result = readUntil("Password:");
	    returnResult.append(result);

	    write(password);

	    // 替换命令行提示符
	    this.prompt = prom;
	    result = readUntil(prompt);
	    returnResult.append(result);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return returnResult.toString();
    }

    public String FuncRelogin(String ip, String port, String user, String password, String prom) {

	String result;
	StringBuffer returnResult = new StringBuffer();

	try {	    
	    write("telnet " + ip + " " + port);

	    result = readUntil("login:");
	    returnResult.append(result);

	    write(user);

	    result = readUntil(user + "'s Password:");
	    returnResult.append(result);

	    write(password);

	    // 替换命令行提示符
	    this.prompt = prom;
	    result=readUntil(prompt);
	    returnResult.append(result);
	    return returnResult.toString();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return returnResult.toString();
    }

    public String readUntil(String pattern) {

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
	} catch(SocketTimeoutException eTimeout){	    
	    System.out.println("server no response, time out!");
	}
	catch (Exception e) {	    
	    e.printStackTrace();
	}
	return sb.toString();
    }

    /**
         * 写
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
         * 向目标发送命令字符串
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
         * 关闭连接
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
	    result = telent.FuncLogin("60.209.94.194", "23", "ecode315", "password", "$");
	    System.out.print(result);
	    
	    // 命令是 ll 列出当前目录下的目录及文件
	    result = telent.sendCommand("ll");
	    System.out.print(result);

	    // 命令是 pwd 查看当前所在目录
	    result = telent.sendCommand("pwd");
	    System.out.print(result);

	    // 命令是 relogin 再次登录到其他机器（模拟通过堡垒机登录的情况）
	    result = telent.FuncRelogin("192.168.1.254", "23", "oracle", "password", "$");
	    System.out.print(result);

	    // 命令是 ll 列出当前目录下的目录及文件
	    result = telent.sendCommand("ll");
	    System.out.print(result);

	    result = telent.sendCommand("exit");
	    System.out.print(result);

	    // 最后一定要关闭
	    telent.disconnect();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
