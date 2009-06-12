package cn.toso.ops.server.control;

import java.util.List;
import java.util.Vector;

import EDU.oswego.cs.dl.util.concurrent.Mutex;
import EDU.oswego.cs.dl.util.concurrent.Sync;

public class ControlPool {

	String functionsXmlPath;

	String transactionXmlPath;

	String errorMsgXmlPath;

	String authServerConnParaFilePath;

	Sync useLock;

	List ctrlListFree;

	List ctrlListUsed;

	public ControlPool(String functionsXmlPath, String transactionXmlPath,
			String errorMsgXmlPath, String authServerConnParaFilePath)
			throws ControlInitException {
		this.functionsXmlPath = functionsXmlPath;
		this.transactionXmlPath = transactionXmlPath;
		this.errorMsgXmlPath = errorMsgXmlPath;
		this.authServerConnParaFilePath = authServerConnParaFilePath;

		this.useLock = new Mutex();

		this.ctrlListFree = new Vector();
		this.ctrlListUsed = new Vector();
	}

	public EapApiControl get() throws ControlInitException {
		EapApiControl res = null;

		try {
			useLock.acquire();
			if (ctrlListFree.size() != 0) {
				res = (EapApiControl) ctrlListFree.remove(0);
			} else {
				res = new EapApiControl();
				res.init(functionsXmlPath, transactionXmlPath, errorMsgXmlPath,
						authServerConnParaFilePath);
			}
			ctrlListUsed.add(res);
		} catch (InterruptedException e) {
			// no op
		} finally {
			useLock.release();
		}
		return res;
	}

	public void put(EapApiControl ctrl) {
		try {
			useLock.acquire();
			if (ctrlListUsed.indexOf(ctrl) < 0) {
				// do nothing
				ctrlListFree.add(ctrl);
			} else {
				ctrlListUsed.remove(ctrl);
				ctrlListFree.add(ctrl);
			}
		} catch (InterruptedException e) {
			// no op
		} finally {
			useLock.release();
		}
	}
}
