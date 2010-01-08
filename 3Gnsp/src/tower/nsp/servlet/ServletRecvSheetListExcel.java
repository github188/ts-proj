package tower.nsp.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import tower.common.util.DateFunc;
import tower.tmvc.XMLWrap;

/**
 * Servlet implementation class for Servlet: ServletKeyItemStatisticExcel
 * 
 */
public class ServletRecvSheetListExcel extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	// 工作薄
	WritableWorkbook wb;

	// 工作表
	WritableSheet sheet;

	XMLWrap xml;

	// 工单信息
	String[] sheetIds;

	String[] prepareDates;

	String[] listIds;

	String[] listStatus;

	String[] outOrgNames;

	String[] outStationNames;

	String[] inOrgNames;

	String[] inStationNames;

	String[] resourceClassNames;

	String[] resourceTypeNames;

	String[] amountPrepare;

	String[] newStationFlags;

	String[] statuDesc = { "下发", "已接收" };

	String[] statuVal = { "1", "2" };
	
	String[] newStationDesc = {"否","是"};
	
	String[] newStationValue = {"0","1"};

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {

		xml = (XMLWrap) req.getAttribute("XML");
		sheetIds = xml.getItemValues("SHEET_PREPARE_LIST", "SHEET_ID");
		prepareDates = xml.getItemValues("SHEET_PREPARE_LIST", "PREPARE_DATE");
		listIds = xml.getItemValues("SHEET_PREPARE_LIST", "LIST_ID");
		listStatus = xml.getItemValues("SHEET_PREPARE_LIST", "LIST_STATUS");
		outOrgNames = xml.getItemValues("SHEET_PREPARE_LIST", "OUT_ORG_NAME");
		outStationNames = xml.getItemValues("SHEET_PREPARE_LIST", "OUT_STATION_NAME");
		inOrgNames = xml.getItemValues("SHEET_PREPARE_LIST", "IN_ORG_NAME");
		inStationNames = xml.getItemValues("SHEET_PREPARE_LIST", "IN_STATION_NAME");
		resourceClassNames = xml.getItemValues("SHEET_PREPARE_LIST", "RESOURCE_CLASS_NAME");
		resourceTypeNames = xml.getItemValues("SHEET_PREPARE_LIST", "RESOURCE_TYPE_NAME");
		amountPrepare = xml.getItemValues("SHEET_PREPARE_LIST", "AMOUNT_PREPARE");
		newStationFlags = xml.getItemValues("SHEET_PREPARE_LIST","NEW_STATION_FLAG");

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

		String fileName = new String("接收工单列表.xls".getBytes(), "ISO8859-1");
		res.addHeader("Content-Disposition", "filename=\"" + fileName + "\"");

		OutputStream os = res.getOutputStream();
		os.write(data);

	}

	byte[] buildResult() throws IOException, RowsExceededException, WriteException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
		WorkbookSettings wbs = new WorkbookSettings();
		wbs.setEncoding("UTF-8");
		wb = Workbook.createWorkbook(baos, wbs);
		sheet = wb.createSheet("接收工单列表", 0);
		createHead(0, 0, "工单编号");
		createHead(0, 1, "调度日期");
		createHead(0, 2, "调出单位");
		createHead(0, 3, "调出基站");
		createHead(0, 4, "设备类别");
		createHead(0, 5, "设备型号");
		createHead(0, 6, "调度数量");
		createHead(0, 7, "调入单位");
		createHead(0, 8, "调入基站");
		createHead(0, 9, "新建基站");
		createHead(0, 10, "状态");
		for (int i = 0; i < listIds.length; i++) {
			createCell(i + 1, 0, sheetIds[i]);
			createCell(i + 1, 1, DateFunc.FormatDateTime(prepareDates[i]));
			createCell(i + 1, 2, outOrgNames[i]);
			createCell(i + 1, 3, outStationNames[i]);
			createCell(i + 1, 4, resourceClassNames[i]);
			createCell(i + 1, 5, resourceTypeNames[i]);
			createCell(i + 1, 6, amountPrepare[i]);
			createCell(i + 1, 7, inOrgNames[i]);
			createCell(i + 1, 8, inStationNames[i]);
			for (int j = 0; j < newStationValue.length; j++) {
				if(newStationFlags[i].equals(newStationValue[j])){
					createCell(i + 1,9, newStationDesc[j]);
				}
			}
			for (int j = 0; j < statuDesc.length; j++) {
				if (listStatus[i].equals(statuVal[j])) {
					createCell(i + 1, 10, statuDesc[j]);
				}
			}
		}

		// 输出
		wb.write();
		wb.close();

		return baos.toByteArray();
	}

	/**
	 * 列头单元格：边框为实线、居中对齐
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell createHead(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell res = new Label(col, row, value);
		WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
		WritableCellFormat titleFormat = new WritableCellFormat(font);
		// titleFormat.setBackground(Colour.TURQOISE2);
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setAlignment(Alignment.CENTRE);
		res.setCellFormat(titleFormat);
		sheet.setColumnView(col, 12);
		// sheet.setRowView(row, 400);
		sheet.addCell(res);
		return res;
	}

	/**
	 * 数据类型是字符串的单元格
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell createCell(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell cell = new Label(col, row, value);
		WritableCellFormat titleFormat = new WritableCellFormat();
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		titleFormat.setAlignment(Alignment.CENTRE);
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 12);
		// sheet.setRowView(row, 400);
		sheet.addCell(cell);
		return cell;
	}

	/**
	 * 虚边框单元格
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell Cell(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell cell = new Label(col, row, value);
		WritableCellFormat titleFormat = new WritableCellFormat();
		// titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		titleFormat.setAlignment(Alignment.LEFT);
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 15);
		sheet.setRowView(row, 400);
		sheet.addCell(cell);
		return cell;
	}

	/**
	 * 列头单元格：边框为虚线、居中对齐
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell cellHead(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell res = new Label(col, row, value);
		WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
		WritableCellFormat titleFormat = new WritableCellFormat(font);
		// titleFormat.setBackground(Colour.TURQOISE2);
		// titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setAlignment(Alignment.RIGHT);
		res.setCellFormat(titleFormat);
		sheet.setColumnView(col, 15);
		sheet.setRowView(row, 400);
		sheet.addCell(res);
		return res;
	}

	/**
	 * 加长的单元格
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell longHeadCell(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell res = new Label(col, row, value);
		WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
		WritableCellFormat titleFormat = new WritableCellFormat(font);
		// titleFormat.setBackground(Colour.TURQOISE2);
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setAlignment(Alignment.CENTRE);
		res.setCellFormat(titleFormat);
		sheet.setColumnView(col, 25);
		sheet.setRowView(row, 400);
		sheet.addCell(res);
		return res;
	}

	/**
	 * 加长的单元格
	 * 
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	WritableCell longCell(int row, int col, String value) throws RowsExceededException, WriteException {
		WritableCell cell = new Label(col, row, value);
		WritableCellFormat titleFormat = new WritableCellFormat();
		titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		titleFormat.setWrap(true);
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 25);
		sheet.setRowView(row, 400);
		sheet.addCell(cell);
		return cell;
	}
}