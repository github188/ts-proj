package tower.cem.util;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class TelnetApplet extends Applet {

    private static final long serialVersionUID = 421948810855312124L;

    NetTelnet nt;

    Label lCommand = new Label("指令:", Label.RIGHT);

    TextField tCommand = new TextField("", 70);

    Button bSend = new Button("发送指令");

    Button bReConnButton = new Button("重新连接");

    TextArea tResult = new TextArea(27, 120);

    Label lStatus = new Label("没有连接");

    StringBuffer sbCommands = new StringBuffer();

    File file;

    PrintWriter out;

    public void init() {
	// TODO 自动生成方法存根
	super.init();

	this.setFont(new Font("Tahoma", 0, 11));

	add(lCommand);
	add(tCommand);
	add(bSend);
	add(bReConnButton);
	add(lStatus);
	add(tResult);

	tCommand.addKeyListener(new MyKeyListener());

    }

    public class MyKeyListener extends KeyAdapter {
	public void keyPressed(KeyEvent evt) {
	    String sComm;

	    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
		bSend.setEnabled(false);
		sComm = tCommand.getText().trim();
		if (sComm.toLowerCase().indexOf("telnet") >= 0) {
		    sComm = "";
		}
		if (sComm != null && sComm.length() != 0) {
		    sbCommands.append(sComm + "\n");
		    String result = nt.sendCommand(sComm);
		    tResult.append(result);

		    try {
			out.write(result);
			out.flush();
		    } catch (Exception e) {
			// TODO: handle exception
		    }

		    if (nt.getBflag()) {
			lStatus.setText("执行成功");
		    } else {
			lStatus.setText("执行失败");
		    }
		}

		bSend.setEnabled(true);
		tCommand.setText("");
		tCommand.requestFocus();

	    }
	}
    }

    public void start() {
	// TODO 自动生成方法存根
	super.start();

	this.sbCommands = new StringBuffer();

	final String deviceIp = getParameter("DeviceIP");
	final String devicePort = getParameter("DevicePort");
	final String deviceUser = getParameter("DeviceUser");
	final String devicePassword = getParameter("DevicePassword");
	final String devicePrompt = getParameter("DevicePrompt");
	final String userPrompt = getParameter("UserPrompt");
	final String passwordPrompt = getParameter("PasswordPrompt");

	final String frontHostIp = getParameter("FrontHostIP");
	final String frontHostPort = getParameter("FrontHostPort");
	final String frontHostUser = getParameter("FrontHostUser");
	final String frontHostPassword = getParameter("FrontHostPassword");
	final String frontHostPrompt = getParameter("FrontHostPrompt");
	final String hostUserPrompt = getParameter("HostUserPrompt");
	final String hostPasswordPrompt = getParameter("HostPasswordPrompt");

	String result;

	try {
	    file = new File("c:/cem-logs");
	    if (!file.exists()) {
		file.mkdir();
	    }

	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	    String sTime = formatter.format(new java.util.Date());
	    FileWriter fw = new FileWriter("c:/cem-logs/" + sTime + "-" + deviceIp + ".log");
	    out = new PrintWriter(fw);

	} catch (Exception e) {
	    // TODO: handle exception
	}

	nt = new NetTelnet();
	nt.setTimeOut(0);
	if (frontHostIp == null || frontHostIp.trim().length() == 0) {
	    if (!(deviceIp == null || deviceIp.trim().length() == 0)) {
		result = nt.FunLogin(deviceIp, devicePort, userPrompt, deviceUser, passwordPrompt,
			devicePassword, devicePrompt);
		tResult.append(result);

		try {
		    out.write(result);
		    out.flush();
		} catch (Exception e) {
		    // TODO: handle exception
		}

		if (nt.getBflag()) {
		    lStatus.setText("连接成功");		    			
		} else {
		    lStatus.setText("连接失败");
		}
	    } else {
		lStatus.setText("连接失败");
	    }

	} else {
	    result = nt.FunLogin(frontHostIp, frontHostPort, hostUserPrompt, frontHostUser,
		    hostPasswordPrompt, frontHostPassword, frontHostPrompt);
	    tResult.append(result);

	    try {
		out.write(result);
		out.flush();
	    } catch (Exception e) {
		// TODO: handle exception
	    }

	    if (nt.getBflag()) {
		result = nt.FunRelogin(deviceIp, devicePort, userPrompt, deviceUser, passwordPrompt,
			devicePassword, devicePrompt);
		tResult.append(result);

		try {
		    out.write(result);
		    out.flush();
		} catch (Exception e) {
		    // TODO: handle exception
		}

		if (nt.getBflag()) {
		    lStatus.setText("连接成功");
		} else {
		    lStatus.setText("连接失败");
		}
	    } else {
		lStatus.setText("登陆堡垒主机失败");
	    }
	}	
    }

    public void paint(Graphics g) {
	// TODO 自动生成方法存根
	super.paint(g);

    }

    public void stop() {
	// TODO 自动生成方法存根
	super.stop();

	try {
	    out.flush();
	    out.close();
	} catch (Exception e) {
	    // TODO: handle exception
	}

	nt.disconnect();
    }

    public void destroy() {
	// TODO 自动生成方法存根
	super.destroy();
    }

    public boolean action(Event evt, Object arg) {
	String sComm;

	if (evt.target.equals(bSend)) {
	    bSend.setEnabled(false);
	    sComm = tCommand.getText().trim();
	    if (sComm.toLowerCase().indexOf("telnet") >= 0) {
		sComm = "";
	    }
	    if (sComm != null && sComm.length() != 0) {
		sbCommands.append(sComm + "\n");
		String result = nt.sendCommand(sComm);
		tResult.append(result);

		try {
		    out.write(result);
		    out.flush();
		} catch (Exception e) {
		    // TODO: handle exception
		}

		if (nt.getBflag()) {
		    lStatus.setText("执行成功");
		} else {
		    lStatus.setText("执行失败");
		}
	    }

	    bSend.setEnabled(true);
	    tCommand.setText("");
	    tCommand.requestFocus();

	} else if (evt.target.equals(bReConnButton)) {

	    tResult.setText("");
	    this.start();
	}

	else
	    return super.action(evt, arg);

	return true; // We've handled it here
    }

    public StringBuffer getCommands() {
	return this.sbCommands;
    }

}
