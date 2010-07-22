package tower.cem.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tower.tmvc.XMLWrap;

/**
 * Servlet implementation class for Servlet: ServletPickLogTxt
 *
 */
 public class ServletPickLogTxt extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	 private static final long serialVersionUID = 7982396433338743263L;
		XMLWrap xml ;
		String pickTime;
		String logCont;
		String fileName;
		
		protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			xml = (XMLWrap) req.getAttribute("XML");
			pickTime = xml.getItemValue("DEVICE_INSPECT_PICK_LOG",1,"PICK_TIME");
			logCont = xml.getItemValue("DEVICE_INSPECT_PICK_LOG",1,"LOG_CONT");
			fileName = pickTime;
			
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
	                write.append("分拣日志内容：" + tab);   
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