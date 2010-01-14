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
import tower.tmvc.XMLWrap;

/**
 * Servlet implementation class for Servlet: ServletKeyItemStatisticExcel
 * 
 */
public class ServletConfStatDetailExcel extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	// 工作薄
	WritableWorkbook wb;

	// 工作表
	WritableSheet sheet;

	XMLWrap xml;

	// 机构信息
	String orgName;

	String orgCode;

	String parentOrgName;

	String linkMan;

	String linkTel;

	String linkEmail;

	String orgRemark;

	String stationFlag;

	String buyInFlag;

	// 库存信息
	String[] classNames;

	String[] typeNames;

	String[] stockAmounts;

	String[] preOutAmount;

	String[] preInAmount;

	String[] onlineAmount;

	String[] inConsAmount;

	String[] badAmounts;

	String[] value = { "Y", "N" };

	String[] Desc = { "是", "否" };

	String[] onlineAmountConf;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException {
		xml = (XMLWrap) req.getAttribute("XML");

		orgCode = xml.getItemValue("SYS_ORG", 1, "ORG_CODE");
		orgName = xml.getItemValue("SYS_ORG", 1, "ORG_NAME");
		orgCode = xml.getItemValue("SYS_ORG", 1, "ORG_CODE");
		parentOrgName = xml.getItemValue("SYS_ORG", 1, "PARENT_ORG_NAME");
		linkMan = xml.getItemValue("SYS_ORG", 1, "LINK_MAN");
		linkTel = xml.getItemValue("SYS_ORG", 1, "LINK_TEL");
		linkEmail = xml.getItemValue("SYS_ORG", 1, "LINK_EMAIL");
		orgRemark = xml.getItemValue("SYS_ORG", 1, "ORG_DESC");
		stationFlag = xml.getItemValue("SYS_ORG", 1, "STATION_FLAG");
		buyInFlag = xml.getItemValue("SYS_ORG", 1, "BUY_IN_FLAG");

		classNames = xml.getItemValues("RESOURCE_ORG_AMOUNT", "CLASS_NAME");
		typeNames = xml.getItemValues("RESOURCE_ORG_AMOUNT", "TYPE_NAME");
		stockAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT", "STOCK_AMOUNT");
		preOutAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT", "PRE_OUT_AMOUNT");
		preInAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT", "PRE_IN_AMOUNT");
		onlineAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT", "ONLINE_AMOUNT");
		onlineAmountConf = xml.getItemValues("RESOURCE_ORG_AMOUNT", "ONLINE_AMOUNT_CONF_AMOUNT");
		inConsAmount = xml.getItemValues("RESOURCE_ORG_AMOUNT", "INCONS_AMOUNT");
		badAmounts = xml.getItemValues("RESOURCE_ORG_AMOUNT", "BAD_AMOUNT");

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

		String fileName = new String("小区配置统计.xls".getBytes(), "ISO8859-1");
		res.addHeader("Content-Disposition", "filename=\"" + fileName + "\"");

		OutputStream os = res.getOutputStream();
		os.write(data);

	}

	byte[] buildResult() throws IOException, RowsExceededException, WriteException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
		WorkbookSettings wbs = new WorkbookSettings();
		wbs.setEncoding("UTF-8");
		wb = Workbook.createWorkbook(baos, wbs);
		sheet = wb.createSheet("小区配置统计", 0);
		createHead(0, 0, "机构编号");
		createCell(0, 1, orgCode);
		createHead(0, 2, "机构名称");
		createCell(0, 3, orgName);
		createHead(0, 4, "所属机构");
		createCell(0, 5, parentOrgName);

		createHead(1, 0, "联系人");
		createCell(1, 1, linkMan);
		createHead(1, 2, "联系电话");
		createCell(1, 3, linkTel);
		createHead(1, 4, "E-Mail");
		createCell(1, 5, linkEmail);

		createHead(2, 0, "是否为小区");
		for (int j = 0; j < value.length; j++) {
			if (value[j].equals(stationFlag)) {
				createCell(2, 1, Desc[j]);
			}
		}

		createCell(2, 2, "");
		createHead(2, 3, "允许外购入库");
		for (int j = 0; j < value.length; j++) {
			if (value[j].equals(buyInFlag)) {
				createCell(2, 4, Desc[j]);
			}
		}

		createCell(2, 5, "");
		sheet.mergeCells(1, 2, 2, 2);
		sheet.mergeCells(4, 2, 5, 2);

		createHead(3, 0, "备注及说明");
		createCell(3, 1, orgRemark);
		createCell(3, 2, "");
		createCell(3, 3, "");
		createCell(3, 4, "");
		createCell(3, 5, "");
		sheet.mergeCells(1, 3, 5, 3);

		createHead(5, 0, "类别");
		createHead(5, 1, "型号");
		createHead(5, 2, "库存数量");
		createHead(5, 3, "预出库");
		createHead(5, 4, "预入库");
		createHead(5, 5, "施工占用");
		createHead(5, 6, "在线数量");
		createHead(5, 7, "在线配置");
		createHead(5, 8, "坏件数量");

		for (int i = 0; i < typeNames.length; i++) {
			createCell(6 + i, 0, classNames[i]);
			createCell(6 + i, 1, typeNames[i]);
			createCell(6 + i, 2, stockAmounts[i]);
			createCell(6 + i, 3, preOutAmount[i]);
			createCell(6 + i, 4, preInAmount[i]);
			createCell(6 + i, 5, inConsAmount[i]);
			createCell(6 + i, 6, onlineAmount[i]);
			createCell(6 + i, 7, onlineAmountConf[i]);
			createCell(6 + i, 8, badAmounts[i]);
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
		sheet.setColumnView(col, 15);
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
		cell.setCellFormat(titleFormat);
		sheet.setColumnView(col, 15);
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