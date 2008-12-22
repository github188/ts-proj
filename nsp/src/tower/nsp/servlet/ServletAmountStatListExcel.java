package tower.nsp.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tower.common.util.DateFunc;
import tower.tmvc.XMLWrap;

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

/**
 * 
 * 功能概述：库存统计导出Excel
 * 
 * @author fanlj 2008-10-19 上午09:46:34
 */
public class ServletAmountStatListExcel extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7982396433338743263L;

	// 工作薄
	WritableWorkbook wb;

	// 工作表
	WritableSheet sheet;
	
	XMLWrap xml ;
	
	HashMap classMap = new HashMap();
	List org;
	List classList;
	List typeList;
	List classFor;

	protected void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

		xml = (XMLWrap) req.getAttribute("XML");
		classMap = (HashMap) xml.getItemObject("AMOUNT_STAT_LIST", 1, "AMOUNT_STAT");
		org = (List) xml.getItemObject("AMOUNT_STAT_LIST", 1, "AMOUNT_STAT_ORG");
		classFor = (List)xml.getItemObject("AMOUNT_STAT_LIST", 1, "CLASS_FOR");
		
		byte[] data;
		try {
			data = buildResult(classMap,org,classFor);
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

		String fileName = new String("资源库存统计.xls".getBytes(), "ISO8859-1");
		res.addHeader("Content-Disposition", "filename=\"" + fileName + "\"");

		OutputStream os = res.getOutputStream();
		os.write(data);
	}
	
	public byte[] buildResult(HashMap classMap, List org,List classFor)throws IOException, RowsExceededException,
		WriteException {
		
			ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
			WorkbookSettings wbs = new WorkbookSettings();
			wbs.setEncoding("UTF-8");
			wb = Workbook.createWorkbook(baos, wbs);
			sheet = wb.createSheet("资源库存统计", 0);
			
			String date = DateFunc.GenDate(new Date());
			String month = date.substring(4,6);
			month = month.replace("0", "");
			createTitleCell(0,0,month+"月无线资源审阅表");
			sheet.mergeCells(0, 0, 5+org.size(), 0);
			
			createTitleCell(0,1,"类别");
			createTitleCell(1,1,"型号");
			if(org != null && org.size() >0){
				//合并类型单元格
				sheet.mergeCells(0, 1, 0, 2);
				sheet.mergeCells(1, 1, 1, 2);
					
				createTitleCell(2,1,"上月在网数量");
				createTitleCell(3,1,"本月在网数量");
				createTitleCell(4,1,"本月新到数量");
				createTitleCell(5,1,"库存数量");
				sheet.mergeCells(2, 1, 2, 2);
				sheet.mergeCells(3, 1, 3, 2);
				sheet.mergeCells(4, 1, 4, 2);
				sheet.mergeCells(5, 1, 5, 2);
					
				createTitleCell(6,1,"存放地点");
				sheet.mergeCells(6, 1, 5+org.size(), 1);
				for(int i = 0 ; i < org.size() ; i++){
					createTitleCell(6+i,2,org.get(i).toString());
				}
			}else{
				createTitleCell(2,1,"上月在网数量");
				createTitleCell(3,1,"本月在网数量");
				createTitleCell(4,1,"本月新到数量");
				createTitleCell(5,1,"库存数量");
			}
			/*int n;
				if(org.size() > 1){
					n = 2;
				}else{
					n = 1;
				}
				for(int i = 0 ; i < classFor.size() ; i++ ){
					classList = (List) classMap.get(classFor.get(i));
					if(classList != null && classList.size() > 0){
					sheet.mergeCells(0, n, 0, n+classList.size()-1);
					for(int j = 0 ; j < classList.size() ; j ++){
						typeList = (List) classList.get(j);
						if( j == 0 ){
							createCell(0,n,typeList.get(0).toString());
						}
						for(int k = 1 ; k < typeList.size() ; k ++){
							if(k == 1){
								createCell(k,n,typeList.get(k).toString());
							}else{
								createCell(k,n,typeList.get(k).toString().split(",")[3]);
							}
						}
						n ++ ;
					}
				}
			}*/
			int n = 0 ;
			if(org != null && org.size() > 0){
				n = 3;
			}else{
				n = 2;
			}
			for(int i = 0 ; i  < classFor.size() ; i++){
				classList = (List) classMap.get(classFor.get(i));
				if(classList != null && classList.size() > 0){
					sheet.mergeCells(0, n, 0, n+classList.size()-1);
					for(int j = 0 ; j < classList.size() ; j ++){
						typeList = (List) classList.get(j);
						if( j == 0 ){
							createCell(0,n,typeList.get(0).toString());
						}
						for(int k = 1 ; k < typeList.size() ; k ++){
							if(k <= 4){
								createCell(k,n,typeList.get(k).toString());
							}else{
								createCell(k,n,typeList.get(k).toString().split(",")[2]);
							}
						}
						n ++ ;
					}
				}
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
