package tower.cem.sample;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

public class NetTelent {

    // Telnet对象
    // 终端类型包括，vt100、vt52、ansi 或 vtnt；选择了错误的终端类型，可能会使得返回信息乱码
    private TelnetClient telnet = new TelnetClient("vtnt");

    private InputStream in;

    private PrintStream out;

    // 提示符。具体请telnet到路由器查看
    private String prompt = "";

    public void FuncLogin(String ip, String port, String user, String password, String prom) {

	String result;

	try {
	    // 路由器IP 注：我这里模拟telnet登录linux服务器
	    System.out.println("telnet " + ip + " " + port);
	    telnet.connect(ip, Integer.parseInt(port));
	    in = telnet.getInputStream();
	    out = new PrintStream(telnet.getOutputStream());

	    result = readUntil("login:");
	    System.out.println(result);

	    write(user);

	    result = readUntil("Password:");
	    System.out.println(result);

	    write(password);

	    // 替换命令行提示符
	    this.prompt = prom;
	    readUntil(prompt);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public String FuncRelogin(String ip, String port, String user, String password, String prom) {

	String result;

	try {
	    System.out.println("telnet " + ip + " " + port);
	    write("telnet " + ip + " " + port);

	    result = readUntil("login:");
	    System.out.print(result);

	    write(user);

	    result = readUntil(user + "'s Password:");
	    System.out.println(result);

	    write(password);

	    // 替换命令行提示符
	    this.prompt = prom;
	    return readUntil(prompt);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public String readUntil(String pattern) {
	try {
	    char lastChar = pattern.charAt(pattern.length() - 1);
	    StringBuffer sb = new StringBuffer();

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
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
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
	    System.out.println("The connection was closed by the remote host!");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	try {

	    String result;
	    NetTelent telent = new NetTelent();
	    telent.FuncLogin("60.209.94.194", "23", "ecode315", "password", "-bash-3.00$");

	    // 命令是 ll 列出当前目录下的目录及文件
	    result = telent.sendCommand("ll");
	    System.out.println(result);

	    // 命令是 pwd 查看当前所在目录
	    result = telent.sendCommand("pwd");
	    System.out.println(result);

	    // 命令是 relogin 再次登录到其他机器（模拟通过堡垒机登录的情况）
	    result = telent.FuncRelogin("192.168.1.254", "23", "oracle", "password", "$");
	    System.out.print(result);

	    // 命令是 ll 列出当前目录下的目录及文件
	    result = telent.sendCommand("ll");
	    System.out.println(result);

	    result = telent.sendCommand("exit");
	    System.out.println(result);

	    // 最后一定要关闭
	    telent.disconnect();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}