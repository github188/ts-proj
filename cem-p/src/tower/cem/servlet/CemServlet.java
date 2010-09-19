package tower.cem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import tower.cem.db.DbSystemOperationLog;
import tower.cem.en.EnSystemOperationLog;
import tower.cem.util.TransactionHolder;
import tower.tmvc.ErrorException;
import tower.tmvc.RootServlet;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;
import tower.tmvc.config.ErrorMessageConfig;


public class CemServlet extends RootServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest req = null;

	String errorPage;

	String operClassLogoPath;
	
	private Logger logger;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.req = req;
		super.service(req, res);
	}

	protected void onError(HttpServletResponse res, ErrorException ex)
			throws ServletException, IOException {
		ErrorMessageConfig emConfig;
		String code, info, hint;
		String errorPage;

		// 输出日志
		if (logger.isInfoEnabled()) {
			logger.info("系统异常", ex);
		}

		// 取得错误码
		code = ex.getCode();

		// 取得错误信息与提示
		if (!this.initSuccess
				&& this.configHolder.getErrorMessageConfigSet().getErrors() != null) {
			info = "系统初始化出错，并且未正确载入错误配置文件。";
			hint = "保存此页面并与系统管理员联系。系统管理员请查看日志获取更多信息。";
		} else {
			// 取得错误配置
			emConfig = (ErrorMessageConfig) this.configHolder
					.getErrorMessageConfigSet().get(code);

			// 判断是否配置错误信息
			if (emConfig == null) {
				info = "系统未配置此代码的错误信息。";
				hint = "保存此页面并与系统管理员联系。";
				logger.warn("未配置错误信息，代号：‘" + code + "’。");
			} else {
				ex.setMessage(emConfig.getMessage());
				info = ex.getMessage();
				hint = emConfig.getHint();
				ex.setMessage(info);
			}
		}

		// 转到错误页面
		errorPage = this.configHolder.getCommonConfig().getErrorPage();
		String appendInfo;

		if (!this.initSuccess && errorPage == null) {
			appendInfo = "系统初始化出错，并且错误页面未配置正确！";
			logger.warn(appendInfo);
		} else {
			Exception errorPageException;
			try {
				req.setAttribute("ERROR_CODE", code);
				req.setAttribute("ERROR_INFO", info);
				req.setAttribute("ERROR_HINT", hint);
				req.setAttribute("ERROR_EXCEPTION", ex);
				RequestDispatcher dipatcher = req
						.getRequestDispatcher(buildJspPath(errorPage));
				dipatcher.forward(req, res);
				errorPageException = null;
			} catch (ServletException e) {
				errorPageException = e;
			} catch (IOException e) {
				errorPageException = e;
			} catch (Exception e) {
				errorPageException = e;
			}

			// 若导向错误页面出错,本Servlet输出
			if (errorPageException == null) {
				appendInfo = null;
			} else {
				appendInfo = "导向错误页面时出错，异常信息："
						+ errorPageException.getMessage();
				logger.warn(appendInfo, errorPageException);
			}
		}

		// 硬输出错误信息
		if (appendInfo != null) {
			PrintWriter writer = res.getWriter();
			writer.write("<html>");
			writer.write("<head>");
			writer
					.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			writer.write("<title>系统发生错误</title>");
			writer.write("</head>");
			writer.write("<body>");
			writer.write("<h1>系统发生错误</h1>");
			writer.write("<hr/>");
			writer.write("<strong>错误代码：</strong>");
			writer.write(code);
			writer.write("<br/>");
			writer.write("<strong>错误信息：</strong>");
			writer.write(info);
			writer.write("<br/>");
			writer.write("<strong>错误提示：</strong>");
			writer.write(hint);
			writer.write("<br/>");
			writer.write("<hr/>");
			writer.write("<strong>附加信息：</strong>");
			writer.write("<strike>");
			writer.write(appendInfo);
			writer.write("</strike>");
			writer.write("</body>");
			writer.write("</html>");
			writer.flush();
			writer.close();
		}
		
		// 更新日志
		// 从Session中获取日志标志和日志ID
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("NSP-XML") != null) {
			String logId;
			XMLWrap sessionXml;
			sessionXml = (XMLWrap) session.getAttribute("NSP-XML");
			logId = sessionXml.getItemValue("LOG_INFO", 1, "LOG_ID");
			if (logId.length() > 0) {
				Transaction transaction = TransactionHolder.getTransaction();
				try {
					if (transaction != null) {
						transaction.createDefaultConnection(null, true);
							DbSystemOperationLog dbSystemOperationLog = new DbSystemOperationLog(transaction, null);
							EnSystemOperationLog enSystemOperationLog = new EnSystemOperationLog();
							enSystemOperationLog.setReturnCode(code);
							enSystemOperationLog.setRemark(info);
							dbSystemOperationLog.updateByKey(logId, enSystemOperationLog);
					}
			     } catch (ErrorException e) {
					e.printStackTrace();
					// do nothing
				} 
			}
			}
		}
	}


