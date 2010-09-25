package tower.cem.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tower.tmvc.XMLWrap;

/**
 * Servlet implementation class for Servlet: ServletCollectLogTxt
 *
 */
 public class ServletCollectLogTxt extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	XMLWrap xml ;
	String  deviceName;
	String  deviceIp;
	String collectEnd;
	String logCont;
	String fileName;
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		xml = (XMLWrap) req.getAttribute("XML");
		
		deviceName = xml.getItemValue("DEVICE_COLLECT_LOG",1,"TYPE_NAME");
		deviceIp = xml.getItemValue("DEVICE_COLLECT_LOG",1,"DEVICE_IP");
		collectEnd = xml.getItemValue("DEVICE_COLLECT_LOG",1,"COLLECT_END");
		logCont = xml.getItemValue("DEVICE_COLLECT_LOG",1,"LOG_CONT");
		fileName = "collect_"+deviceIp+"_"+collectEnd+".txt";
		
		res.setContentType("text/plain");// 两行关键的设置   
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