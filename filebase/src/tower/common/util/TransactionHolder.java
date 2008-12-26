package tower.common.util;

import tower.tmvc.ConfigSet;
import tower.tmvc.Transaction;


public class TransactionHolder {

	private static Transaction transaction;

	private static ConfigSet configSet;

	public static Transaction getTransaction() {
		// if (transaction==null) {
		transaction = new Transaction(configSet);
		// }
		return transaction;
	}

	public static void setTransactionConfig(ConfigSet configSet) {
		TransactionHolder.configSet = configSet;
	}
}
