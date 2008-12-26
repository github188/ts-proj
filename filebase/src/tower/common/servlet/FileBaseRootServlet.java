package tower.common.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tower.common.util.TransactionHolder;
import tower.tmvc.ErrorException;
import tower.tmvc.RootServlet;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.util.ContentFactory;

/**
 * Servlet implementation class for Servlet: FileBaseRootServlet
 * 
 * @web.servlet name="FileBaseRootServlet" display-name="FileBaseRootServlet"
 * 
 * @web.servlet-mapping url-pattern="/FileBaseRootServlet"
 * 
 */
public class FileBaseRootServlet extends RootServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest req = null;

	String errorPage;

	String operClassLogoPath;

	Logger logger;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.req = req;
		super.service(req, res);
	}

	protected XMLWrap wrapApplication(ServletContext context)
			throws ErrorException {
		XMLWrap res = super.wrapApplication(context);
		if (res.getInputRowCount("UPLOAD_CATALOG") <= 0) {
			res.addInputRow("UPLOAD_CATALOG");
			res.setInputValue("UPLOAD_CATALOG", 1, context.getRealPath("/"));
		}

		return res;
	}

	protected void onRootServletError(HttpServletResponse res, ErrorException ex)
			throws ServletException, IOException {

		this.myDispatch(errorPage, req, res);
	}

	private void myDispatch(String local, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dipatcher = req.getRequestDispatcher(local);
		dipatcher.forward(req, res);
	}

	protected XMLWrap wrapRequest(HttpServletRequest request)
			throws ErrorException {
		request.setAttribute("_TMVC_MODULE", this.configHolder.getModule());
		XMLWrap res = new XMLWrap();
		Map params = new HashMap();
		params.put("encoding", "utf8");
		params.put("maxLength", new Integer((int) this.configHolder
				.getCommonConfig().getUploadMaxSize()));
		params.put("uploadTmpPath", this.configHolder.getCommonConfig()
				.getUploadTmpPath());
		params.put("autoRemoveUploadTmpFile", new Boolean(this.configHolder
				.getCommonConfig().isUploadAutoRemove()));
		params.put("uploadFileFactory", this.configHolder.getCommonConfig()
				.getUploadFactory());
		ContentFactory cf = ContentFactory.getContentFactory(request, params);

		Enumeration enumAttrName = cf.getParameterNames();
		String attrName;
		Object[] attrValues;
		int i;
		int row;
		while (enumAttrName.hasMoreElements()) {
			attrName = (String) enumAttrName.nextElement();
			attrValues = cf.getParameterValues(attrName);
			if (attrValues != null) {
				for (i = 0; i < attrValues.length; i++) {
					row = res.addInputRow(attrName);
					res.setInputValue(attrName, row, treatDanYinHao((String)attrValues[i]));
				}
			}
		}

		enumAttrName = cf.getFileParameterNames();
		while (enumAttrName.hasMoreElements()) {
			attrName = (String) enumAttrName.nextElement();
			attrValues = cf.getFileParameterValues(attrName);
			if (attrValues != null) {
				for (i = 0; i < attrValues.length; i++) {
					row = res.addInputRow(attrName);
					res.setInputValue(attrName, row, attrValues[i]);
				}
			}
		}
		request.setAttribute("XML", res);
		return res;
	}
	private String treatDanYinHao(String src) {
		if (src == null || src.indexOf('\'') < 0) {
			return src;
		}
		StringBuffer res = new StringBuffer();
		char[] chArray = src.toCharArray();
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == '\'') {
				res.append('\'');
			}
			res.append(chArray[i]);
		}
		return res.toString();
	}

}