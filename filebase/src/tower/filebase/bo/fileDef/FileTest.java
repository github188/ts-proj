package tower.filebase.bo.fileDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileTest test = new FileTest();
		//test.retrue();
		//test.deleteFile("");
		//test.newFile("");
		System.out.println("copyFile");
		//test.newFolder("D:\\FileTest\\test\\1\\2\\test.txt");
		System.out.println("FileTest");
		
		/*String s = "test.txt";
		if ((s != null) && (s.length() > 0)) {
			int i = s.lastIndexOf('.');

			if ((i > 0) && (i < (s.length() - 1))) {
				System.out.println( s.substring(i + 1));
			}
		}*/
		/*String flag = "ss";
		int n = 0 ;
		System.out.println("boolean"+flag != null && flag.length() > 0 );
		while (flag != null && flag.length()> 0){
			n ++ ;
			if(n==3){
				flag="";
			}
			System.out.println("n"+ n + "flag" + flag);
		}*/
	}
	public void newFolder(String folderPath) {
	    try {
	      String filePath = folderPath;
	      filePath = filePath.toString();
	      java.io.File myFilePath = new java.io.File(filePath);
	      if (!myFilePath.exists()) {
	        myFilePath.mkdirs();
	        System.out.println("mkdir");
	      }else{
	    	  java.io.File myFilePaths = new java.io.File("D:\\FileTest\\test1\\te\\t\\s.txt");
	    	  myFilePath.renameTo(myFilePaths);
	    	  //myFilePath.delete();
	    	  System.out.println("已经存在");
	      }
	    }
	    catch (Exception e) {
	      System.out.println("新建目录操作出错");
	      e.printStackTrace();
	    }
	  }
	
	public void deleteFile(String file){
		java.io.File fileDelete = new java.io.File("D:\\FileTest\\test1\\t.txt");
		if(fileDelete.exists()){
			fileDelete.delete();
		}
	}

	/*public void retrue(){
		//java.io.File fileOld = new java.io.File("D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps\filebase\book/music/aa/e/d/deddd/dxddx");
		//java.io.FileFile = new java.io.File("D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps\filebase\book/music/aa/e/d/deddd/dx");
		if(fileOld.exists()){
			fileOld.renameTo(file);
		}
	}*/
	public void newFile(String filePath){
		java.io.File file = new java.io.File("D:\\FileTest\\test1\\test.txt");
		 if (!file.exists()) {
			 file.mkdirs();
		        System.out.println("mkdir");
		 }
	}
	public void newFileC(String filePath){
		java.io.File file = new java.io.File("D:\\FileTest\\test1\\test.txt");
		java.io.File fileCopy = new java.io.File("D:\\FileTest\\a\\b\\test.txt");
		java.io.File fileCopyC = new java.io.File("D:\\FileTest\\a\\b");
		try {
			InputStream stream = new FileInputStream(file);
			if(!fileCopyC.exists()){
				System.out.println("创建文件");
				fileCopyC.mkdirs();
			}
			fileCopy.createNewFile();
			OutputStream outStream = new FileOutputStream(fileCopy);
			if (stream != null && stream != null) {
				System.out.println("将文件内容复制到相应文件");
				IOUtils.copy(stream, outStream);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
