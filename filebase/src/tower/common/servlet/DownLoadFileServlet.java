package tower.common.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import tower.common.util.DateFunc;
import tower.tmvc.XMLWrap;

/**
 * Servlet implementation class for Servlet: DownLoadFileServlet
 * 
 */
public class DownLoadFileServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	XMLWrap xml;
	
	String[] fileIds;
	String[] fileNames;

	String[] fileExtNames;

	String[] filePath;

	String[] fileVersions;

	String zipFileName = DateFunc.GenNowTime() + ".zip";

	String path;

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		xml = (XMLWrap) req.getAttribute("XML");
		fileIds = xml.getItemValues("T_FILE", "FILE_ID");
		fileNames = xml.getItemValues("T_FILE", "FILE_NAME");
		fileExtNames = xml.getItemValues("T_FILE", "FILE_EXT_NAME");
		filePath = xml.getItemValues("T_FILE", "FILE_PATH");
		fileVersions = xml.getItemValues("T_FILE", "NEW_VERSION_NO");
		path = xml.getInputValue("PATH");

		byte[] data;

		data = buildResult();
		//res.setContentType("bin");
		res.setContentType("application/octet-stream");
		res.setContentLength(data.length);

		res.setHeader("Pragma", "No-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);

		// 如果只下载一个文件则：文件名即使原文件名；如果下载多个文件则压缩后下载,压缩后的文件名为当前时间
		String fileName = "";
		if (fileNames.length == 1) {
			String fileFullName = fileNames[0];
			fileName = new String(fileFullName.getBytes(), "ISO8859-1");
		} else if (fileNames.length > 1) {
			String fileFullName = zipFileName;
			fileName = new String(fileFullName.getBytes(), "ISO8859-1");
		}
		res.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

		OutputStream os = res.getOutputStream();
		os.write(data);

	}

	/**
	 * 1、 根据文件路径+文件名+版本号读取文件 
	 * 2、如果是下载单个文件，直接下载，如果是下载多个文件压缩后下载。
	 * 
	 * @return
	 * @throws IOException
	 */
	private byte[] buildResult() throws IOException {
		byte[] array = new byte[0];
		FileInputStream fs;
		if (filePath.length == 1) {
			fs = new FileInputStream(filePath[0]);
			array = new byte[fs.available()];
			fs.read(array);
		} else if (filePath.length > 1) {
			zip(path,zipFileName);
			fs = new FileInputStream(zipFileName);
			array = new byte[fs.available()];
			fs.read(array);
		}
		return array;
	}
	/**
	 * 
	 * @param inputFilename 将要压缩的文件名或目录名
	 * @param zipFilename  压缩后的文件名
	 * @throws IOException
	 */
	public synchronized void zip(String inputFilename, String zipFilename)
			throws IOException {
		zip(new File(inputFilename), zipFilename);
	}
	
	/**
	 * 
	 * @param inputFile 将要压缩的文件或目录
	 * @param zipFilename 压缩后的文件名
	 * @throws IOException
	 */
	public synchronized void zip(File inputFile, String zipFilename)
			throws IOException {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFilename));
		try {
			zip(inputFile, out, "");
		} catch (IOException e) {
			throw e;
		} finally {
			out.close();
		}
	}
   /**
    * 
    * @param inputFile
    * @param out
    * @param base
    * @throws IOException
    */
	private synchronized void zip(File inputFile, ZipOutputStream out,
			String base) throws IOException {
		if (inputFile.isDirectory()) {
			File[] inputFiles = inputFile.listFiles();
			 out.putNextEntry(new ZipEntry(base + "/"));
			 base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < inputFiles.length; i++) {
				for(int j=0;j<fileIds.length;j++){
					String fileName = fileIds[j]+"_"+fileVersions[j]+"_"+fileNames[j];
					if(fileName.equals(inputFiles[i].getName())){
						zip(inputFiles[i], out, base + fileNames[j]);
					}
				}
				
			}
		} else {
			if (base.length() > 0) {
				out.putNextEntry(new ZipEntry(base));
			} else {
				out.putNextEntry(new ZipEntry(inputFile.getName()));
			}

			FileInputStream in = new FileInputStream(inputFile);
			try {
				int c;
				byte[] by = new byte[1024];
				while ((c = in.read(by)) != -1) {
					out.write(by, 0, c);
				}
			} catch (IOException e) {
				throw e;
			} finally {
				in.close();
			}
		}
	}

}