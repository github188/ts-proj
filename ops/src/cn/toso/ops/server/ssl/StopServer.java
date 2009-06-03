package cn.toso.ops.server.ssl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StopServer {
	public static void main(String[] args) {
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream("stop.txt");
			fos.write('F');
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
