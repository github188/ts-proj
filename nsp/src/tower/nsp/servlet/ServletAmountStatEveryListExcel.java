package tower.nsp.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import tower.tmvc.XMLWrap;

public class ServletAmountStatEveryListExcel extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7982396433338743263L;

	// 工作薄
	WritableWorkbook wb;

	// 工作表
	WritableSheet sheet;
	
	XMLWrap xml ;
	
	String typeName;
	String className;
	
	String[] orgNames;
	String[] parentOrgs;	
	String[] amounts;
	String[] inconsAmounts;
	String[] badAmounts;
	String[] allAmounts;
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		xml = (XMLWrap) req.getAttribute("XML");
		
		typeName = xml.getItemValue("STAT_LIST_EVERY",1,"TYPE_NAME");
		className = xml.getItemValue("STAT_LIST_EVERY",1,"CLASS_NAME");
		
		orgNames = xml.getItemValues("STAT_LIST_EVERY","SYS_ORG_NAME");
		parentOrgs = xml.getItemValues("STAT_LIST_EVERY","SYS_PARENTORG_NAME");
		amounts = xml.getItemValues("STAT_LIST_EVERY","STOCK_AMOUNT");
	    inconsAmounts = xml.getItemValues("STAT_LIST_EVERY","INCONS_AMOUNT");
	    badAmounts = xml.getItemValues("STAT_LIST_EVERY","BAD_AMOUNT");
	    allAmounts = xml.getItemValues("STAT_LIST_EVERY","ALL_AMOUNT");
		
		byte[] data;
		try {
			data = buildResult();
		} catch (RowsExceededException e) {
			e.printStackTrace();
			return;
		} catch (WriteException e) {
			e.printStackTrace();
			return;
		}
		res.setContentType("bin");
		res.setContentLength(data.length);

		res.setHeader("Pragma", "No-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);

		String fileName = new String("资源库存统计详细.xls".getBytes(), "ISO8859-1");
		res.addHeader("Content-Disposition", "filename=\"" + fileName + "\"");

		OutputStream os = res.getOutputStream();
		os.write(data);
	}
	
	public byte[] buildResult()throws IOException, RowsExceededException,
		WriteException {
		
			ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
			WorkbookSettings wbs = new WorkbookSettings();
			wbs.setEncoding("UTF-8");
			wb = Workbook.createWorkbook(baos, wbs);
			sheet = wb.createSheet("资源库存统计详细", 0);
			
			createTitleCell(0,0,"机构名称");
			createTitleCell(1,0,"所属机构");
			createTitleCell(2,0,"类别");
			createTitleCell(3,0,"型号");
			createTitleCell(4,0,"库存数量");
			createTitleCell(5,0,"施工占用");
			createTitleCell(6,0,"坏件数量");
			createTitleCell(7,0,"合计");
	
			for(int i = 0 ; i < orgNames.length ; i ++){
				createCell(0,i+1,orgNames[i]);
				createCell(1,i+1,parentOrgs[i]);
				createCell(2,i+1,className);
				createCell(3,i+1,typeName);
				createCell(4,i+1,amounts[i]);
				createCell(5,i+1,inconsAmounts[i]);
				createCell(6,i+1,badAmounts[i]);
				createCell(7,i+1,allAmounts[i]);
			}
			wb.write();
			wb.close();
			
			return baos.toByteArray();
	}
	/**
	 * 数据类型是字符串的单元格 边框为实线 数据自动换行 水平居中对齐 行高：15 列宽：400 字体正常
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell createCell( int col,int row, String value)
			throws RowsExceededException, WriteException {
		WritableCell cell = new Label(col, row, value);
		WritableCellFormat titleFormat = new WritableCellFormat();
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		titleFormat.setAlignment(Alignment.CENTRE);
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 18);
		sheet.setRowView(row, 300);
		sheet.addCell(cell);
		return cell;
	}

	/**
	 * 数据类型是数字的单元格 边框为实线 数据自动换行 水平居中对齐 行高：15 列宽：400 字体正常
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell createCell(int row, int col, long value)
			throws RowsExceededException, WriteException {
		WritableCell res = new Number(col, row, value);
		WritableCellFormat titleFormat = new WritableCellFormat();
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		titleFormat.setAlignment(Alignment.CENTRE);
		res.setCellFormat(titleFormat);
		sheet.setColumnView(col, 18);
		sheet.setRowView(row, 300);
		sheet.addCell(res);
		return res;
	}

	/**
	 * 数据类型是字符串的单元格 边框为实线 数据自动换行 水平居中对齐 行高：15 列宽：400 字体加粗
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell createTitleCell( int col, int row, String value)
			throws RowsExceededException, WriteException {
		WritableCell cell = new Label(col, row, value);
		WritableFont font = new WritableFont(WritableFont.TIMES, 10,
				WritableFont.BOLD);
		WritableCellFormat titleFormat = new WritableCellFormat(font);
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		titleFormat.setAlignment(Alignment.CENTRE);
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 15);
		sheet.setRowView(row, 300);
		sheet.addCell(cell);
		return cell;
	}

}
