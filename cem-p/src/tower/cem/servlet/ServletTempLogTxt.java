package tower.cem.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tower.tmvc.XMLWrap;

public class ServletTempLogTxt extends HttpServlet implements Servlet{

	private static final long serialVersionUID = 7982396433338743263L;
	XMLWrap xml ;
	String  deviceName;
	String  deviceIp;
	String  userId;
	String userName;
	String  maintainBegin;
	String maintainEnd;
	String  status;
	String logCont;
	String fileName;
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		xml = (XMLWrap) req.getAttribute("XML");
		
		deviceName = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"TYPE_NAME");
		deviceIp = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"DEVICE_IP");
		userId = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"USER_ID");
		userName = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"USER_NAME");
		maintainBegin = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"MAINTAIN_BEGIN");
		maintainEnd = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"MAINTAIN_END");
		status = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"STATUS");
		logCont = xml.getItemValue("DEVICE_MAINTAIN_LOG",1,"LOG_CONT");
		fileName = "maintain_"+deviceIp+"_"+maintainEnd+".txt";;
		
		res.setContentType("text/plain");// 一下两行关键的设置   
		res.addHeader("Content-Disposition",   
                "attachment;filename="+fileName);// filename指定默认的名字   
        BufferedOutputStream buff = null;   
        StringBuffer write = new StringBuffer();   
        String tab = "  ";   
        String enter = "\r\n";   
        ServletOutputStream outSTr = null;   
        
        try {   
            outSTr = res.getOutputStream();// 建立   
            buff = new BufferedOutputStream(outSTr);   
                write.append( logCont+ enter);
            buff.write(write.toString().getBytes("UTF-8"));   
            buff.flush();   
            buff.close();   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
                buff.close();   
                outSTr.close();   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
    }   

		
}
	

