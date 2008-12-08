package tower.nsp.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			/*sheet.mergeCells(0, 2, 2, 1);
			sheet.mergeCells(0, 3, 3, 1);
			sheet.mergeCells(0, 4, 4, 1);
			*/
			createTitleCell(0,0,"类别");
			createTitleCell(1,0,"型号");
			//createTitleCell(2,1,"类别");
			//createTitleCell(3,2,"型号");
			if(org != null){
				if(org.size() >1){
					//合并类型单元格
					sheet.mergeCells(0, 0, 0, 1);
					sheet.mergeCells(1, 0, 1, 1);
					
					createTitleCell(2,0,"在线数量");
					createTitleCell(3,0,"库存数量");
					createTitleCell(4,0,"施工占用");
					createTitleCell(5,0,"坏件数量");
					sheet.mergeCells(2, 0, 2, 1);
					sheet.mergeCells(3, 0, 3, 1);
					sheet.mergeCells(4, 0, 4, 1);
					sheet.mergeCells(5, 0, 5, 1);
					for(int i = 0 ; i < org.size() ; i++){
						sheet.mergeCells(2+(i+1)*4, 0, 2+(i+1)*4+3, 0);
						createTitleCell(2+(i+1)*4,0,org.get(i).toString());
						createTitleCell(2+(i+1)*4,1,"在线");
						createTitleCell(2+(i+1)*4+1,1,"库存");
						createTitleCell(2+(i+1)*4+2,1,"施工");
						createTitleCell(2+(i+1)*4+3,1,"坏件");
					}
				}else{
					createTitleCell(2,0,"在线数量");
					createTitleCell(3,0,"库存数量");
					createTitleCell(4,0,"施工占用");
					createTitleCell(5,0,"坏件数量");
				}
			}
			/*if(org != null && org.size() == 1){
				//String orgName = (String) org.get(0);
				//createTitleCell(1,3,orgName);
				
			}else{
				createCell(0,2,"在线");
				createCell(0,3,"库存");
				createCell(0,4,"施工");
				for(int i = 0 ; i < org.size() ; i++){
					String orgName = (String) org.get(0);
					createTitleCell(1,5+i*3,orgName);
					sheet.mergeCells(5+i*3, 0, 8+i*3, 0);
					createCell(2,5+i*3,"在线");
					createCell(2,5+i*3,"库存");
					createCell(2,5+i*3,"施工");
				}
			}*/
			int n;
			if(org != null){
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
			}
			}
			/*int n = 3;
			for(Iterator i = classMap.values().iterator(); i.hasNext();){
				classList = (List) i.next();
				sheet.mergeCells(n, 0, classList.size()-1, 0);
				for(int j = 0 ; j < classList.size() ; j ++){
					createCell(n,j+1,classList.get(j).toString());
				}
				n++;
			}
			*/
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
