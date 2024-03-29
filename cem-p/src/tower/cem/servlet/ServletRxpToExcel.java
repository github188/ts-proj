package tower.cem.servlet;

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
import jxl.format.Colour;
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
 * Servlet implementation class for Servlet: ServletRxpToExcel
 *
 */
 public class ServletRxpToExcel extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

		// 工作薄
		WritableWorkbook wb;

		// 工作表
		WritableSheet sheet;

		XMLWrap xml;

		// 设备采集数据
		String[] sendIds;
		String[] typeNames;
		String[] deviceNames;
		String[] portSns;
		String[] typeNameCns;
		String[] rxps;
		String[] rxMaxs;
		String[] rxMins;
		String[] netWordRxMins;
		String[] netWordRxMaxs;
		String[] collectEnds;
		String[] deviceIps;
		String[] status;
		String[] isNormals;
		
		String deviceTypeId;
		
		String[] deviceStatusDesc = {"在用","停用"};
		String[] deviceStatusValue = {"N","S"};
		
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,
				IOException {
			
			xml = (XMLWrap) req.getAttribute("XML");
			sendIds = xml.getItemValues("DEVICE_PORT_RXP","SEND_ID");
			typeNames = xml.getItemValues("DEVICE_PORT_RXP","PORT_TYPE_NAME");
			deviceNames = xml.getItemValues("DEVICE_PORT_RXP","DEVICE_NAME");
			deviceIps = xml.getItemValues("DEVICE_PORT_RXP","DEVICE_IP");
			portSns = xml.getItemValues("DEVICE_PORT_RXP","PORT_SN");
			typeNameCns = xml.getItemValues("DEVICE_PORT_RXP","DEVICE_TYPE_NAME");
			rxps = xml.getItemValues("DEVICE_PORT_RXP","RXP");
			rxMaxs = xml.getItemValues("DEVICE_PORT_RXP","STANDARD_RX_MAX");
			rxMins = xml.getItemValues("DEVICE_PORT_RXP","STANDARD_RX_MIN");
			netWordRxMins = xml.getItemValues("DEVICE_PORT_RXP","NETWORK_RX_MIN");
			netWordRxMaxs = xml.getItemValues("DEVICE_PORT_RXP","NETWORK_RX_MAX");
			collectEnds = xml.getItemValues("DEVICE_PORT_RXP","COLLECT_END");
			isNormals = xml.getItemValues("DEVICE_PORT_RXP","IS_NORMAL");
			status = xml.getItemValues("DEVICE_PORT_RXP","STATUS");
			
			deviceTypeId = xml.getInputValue("DEVICE_TYPE_ID");
			String fileName1="";
			if(deviceTypeId == null || deviceTypeId.length() == 0){
				 fileName1 = "rxp_all_"+collectEnds[0]+".xls";
			}else{
				 fileName1 = "rxp_"+deviceIps[0]+"_"+collectEnds[0]+".xls";
			}
			
			
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

			String fileName = new String(fileName1.getBytes(), "ISO8859-1");
			res.addHeader("Content-Disposition", "filename=\"" + fileName + "\"");

			OutputStream os = res.getOutputStream();
			os.write(data);

		}

		byte[] buildResult() throws IOException, RowsExceededException, WriteException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
			WorkbookSettings wbs = new WorkbookSettings();
			wbs.setEncoding("UTF-8");
			wb = Workbook.createWorkbook(baos, wbs);
			sheet = wb.createSheet("设备光功率数据", 0);
			createHead(0, 0, "设备型号");
			createHead(0, 1, "设备名称");
			createHead(0, 2, "网管IP");
			createHead(0, 3, "本端端口编号");
			createHead(0, 4, "使用状态");
			createHead(0, 5, "端口类型");
			createHead(0, 6, "端口收光功率");
			createHead(0, 7, "光功率是否正常");
			createHead(0, 8, "标准最大接收光功率（dBm）");
			createHead(0, 9, "标准最小接收光功率（dBm）");
			createHead(0, 10, "网络要求的最大接收光功率（dBm）");
			createHead(0, 11, "网络要求的最小接收光功率（dBm）");
			createHead(0, 12, "备注");

			for (int i = 0; i < sendIds.length; i++) {
				createCell(i + 1, 0, typeNameCns[i]);
				createCell(i + 1, 1, deviceNames[i]);
				/*
				if(i!=0 && deviceNames[i].equals(deviceNames[i-1])){
					sheet.mergeCells(0,1,0, i+1);
					sheet.mergeCells(1,1,1, i+1);
					sheet.mergeCells(2,1,2, i+1);
				}
				*/
				
				createCell(i + 1, 2, deviceIps[i]);
				createCell(i + 1, 3, portSns[i]);
				createCell(i + 1, 4, "在用");
				createCell(i + 1, 5, typeNames[i]);
				createCell(i + 1, 6, rxps[i]);
				createCell(i + 1, 7, isNormals[i]);
				createCell(i + 1, 8, rxMaxs[i]);
				createCell(i + 1, 9, rxMins[i]);
				createCell(i + 1, 10, netWordRxMaxs[i]);
				createCell(i + 1, 11, netWordRxMins[i]);
				createCell(i + 1, 12, "");
			}
			//合并单元格
			for (int i = 0,n=0; i < sendIds.length; i++,n++) {
				if(i!=0 && !(deviceNames[i].equals(deviceNames[i-1]))){
					sheet.mergeCells(0,i+1-n,0, i);
					sheet.mergeCells(1,i+1-n,1, i);
					sheet.mergeCells(2,i+1-n,2, i);
					n=0;
				}
				if(i == sendIds.length-1){
					sheet.mergeCells(0,i+1-n,0, i+1);
					sheet.mergeCells(1,i+1-n,1, i+1);
					sheet.mergeCells(2,i+1-n,2, i+1);
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
			WritableFont font = new WritableFont(WritableFont.TIMES, 10);
			font.setColour(Colour.WHITE);
			WritableCellFormat titleFormat = new WritableCellFormat(font);
			titleFormat.setBackground(Colour.BLUE);
			titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			titleFormat.setAlignment(Alignment.CENTRE);
			titleFormat.setLocked(true);
			res.setCellFormat(titleFormat);
			sheet.setColumnView(col, 200);
			sheet.setRowView(row, 400);
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
			sheet.setColumnView(col, 20);
			sheet.setRowView(row, 400);
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
			sheet.setColumnView(col, 20);
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
			sheet.setColumnView(col, 20);
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