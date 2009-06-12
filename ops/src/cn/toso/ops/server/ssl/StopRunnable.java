package cn.toso.ops.server.ssl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class StopRunnable implements Runnable {
	Thread workThread;

	String stopFileName;

	Logger logger;
	
	public StopRunnable(Thread workThread, String stopFileName)
			throws IOException {
		this.workThread = workThread;
		this.stopFileName = stopFileName;
		this.initRun();
		logger = Logger.getLogger(this.getClass());
	}

	public void run() {
		try {
			while (true) {
				if (canStop()) {
					logger.info("Server stopped!");
					System.exit(0);
					break;
				}
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} finally {
			workThread.interrupt();
		}
	}

	public boolean canStop() throws IOException {
		boolean res = false;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(stopFileName);
			res = !('T' == fis.read());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return res;
	}

	public void initRun() throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(stopFileName);
			fos.write('T');
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	public static void main(String[] args) {

	}
}