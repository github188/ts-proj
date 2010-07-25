package tower.cem.util;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class TelnetApplet extends Applet {

    private static final long serialVersionUID = 421948810855312124L;

    NetTelnet nt;

    Label lCommand = new Label("指令:", Label.RIGHT);

    TextField tCommand = new TextField("", 70);

    Button bSend = new Button("发送指令");

    Button bReConnButton = new Button("重新连接");

    TextArea tResult = new TextArea(27, 120);

    Label lStatus = new Label("没有连接");

    @Override
    public void init() {
	// TODO 自动生成方法存根
	super.init();

	this.setFont(new Font("abc ", 0, 11));

	add(lCommand);
	add(tCommand);
	add(bSend);
	add(bReConnButton);
	add(lStatus);
	add(tResult);

    }

    @Override
    public void start() {
	// TODO 自动生成方法存根
	super.start();

	final String deviceIp = getParameter("DeviceIP");
	final String devicePort = getParameter("DevicePort");
	final String deviceUser = getParameter("DeviceUser");
	final String devicePassword = getParameter("DevicePassword");
	final String devicePrompt = getParameter("DevicePrompt");

	final String frontHostIp = getParameter("FrontHostIP");
	final String frontHostPort = getParameter("FrontHostPort");
	final String frontHostUser = getParameter("FrontHostUser");
	final String frontHostPassword = getParameter("FrontHostPassword");
	final String frontHostPrompt = getParameter("FrontHostPrompt");

	String result;

	nt = new NetTelnet();
	nt.setTimeOut(0);
	if (frontHostIp == null || frontHostIp.trim().length() == 0) {
	    if (!(deviceIp == null || deviceIp.trim().length() == 0)) {
		result = nt.FunLogin(deviceIp, devicePort, deviceUser, devicePassword, devicePrompt);
		tResult.append(result);
		if (nt.getBflag()) {
		    lStatus.setText("连接成功");
		} else {
		    lStatus.setText("连接失败");
		}
	    } else {
		lStatus.setText("连接失败");
		// // 测试程序段
		// result = nt.FunLogin("60.209.94.194", "23", "ecode315",
		// "password", "$");
		// tResult.append(result);
		// if (nt.getBflag()) {
		// lStatus.setText("连接成功");
		// } else {
		// lStatus.setText("连接失败");
		// }
	    }

	} else {
	    result = nt.FunLogin(frontHostIp, frontHostPort, frontHostUser, frontHostPassword,
		    frontHostPrompt);
	    tResult.append(result);
	    if (nt.getBflag()) {
		result = nt.FunRelogin(deviceIp, devicePort, deviceUser, devicePassword, devicePrompt);
		tResult.append(result);
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

    @Override
    public void paint(Graphics g) {
	// TODO 自动生成方法存根
	super.paint(g);

    }

    @Override
    public void stop() {
	// TODO 自动生成方法存根
	super.stop();

	nt.disconnect();
    }

    @Override
    public void destroy() {
	// TODO 自动生成方法存根
	super.destroy();
    }

    public boolean action(Event evt, Object arg) {
	String sComm;

	if (evt.target.equals(bSend)) {
	    bSend.setEnabled(false);
	    sComm = tCommand.getText().trim();
	    if (sComm != null && sComm.length() != 0) {
		String result = nt.sendCommand(sComm);
		tResult.append(result);
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
	// Let the base class handle it:
	else
	    return super.action(evt, arg);

	return true; // We've handled it here
    }

}
