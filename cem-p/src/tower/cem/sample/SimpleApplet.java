package tower.cem.sample;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseListener;

import tower.cem.util.NetTelnet;

public class SimpleApplet extends Applet {

    NetTelnet nt ;

    Label lCommand = new Label("指令:");

    TextField tCommand = new TextField("", 30);

    Button bSend = new Button("发送指令");

    Button bDisConnButton = new Button("断开连接");

    TextArea tResult = new TextArea("");

    Label lStatus = new Label("");
    

    @Override
    public void init() {
	// TODO 自动生成方法存根
	super.init();

	add(lCommand);
	add(tCommand);
	add(bSend);
	add(bDisConnButton);
	add(tResult);
	add(lStatus);

    }

    @Override
    public void start() {
	// TODO 自动生成方法存根
	super.start();
	
	nt = new NetTelnet();
	nt.setTimeOut(0);
	String result = nt.FunLogin("192.168.1.251", "23", "ecode315", "password", "$");	
	tResult.append(result);
	
	if(nt.getBflag()){
	    lStatus.setText("连接成功");
	}else{
	    lStatus.setText("连接失败");
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
		if(nt.getBflag()){
		    lStatus.setText("执行成功");    
		}else{
		    lStatus.setText("执行失败");
		}
		
	    }
	      
	    bSend.setEnabled(true);
	    tCommand.setText("");

	} else if (evt.target.equals(bDisConnButton)) {

	    nt.disconnect();
	}
	// Let the base class handle it:
	else
	    return super.action(evt, arg);

	return true; // We've handled it here
    }

}
