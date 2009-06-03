package cn.toso.ops.util;

public class SeqNoGennor {
	private int nextSeqNo;

	private StringBuffer res = new StringBuffer();

	private static SeqNoGennor _gennor = null;

	private SeqNoGennor() {

	}

	public static SeqNoGennor createGennor() {
		if (_gennor == null) {
			_gennor = new SeqNoGennor();
		}
		return _gennor;
	}

	public synchronized String next() {
		res.setLength(0);
		res.append(nextSeqNo);
		while (res.length() < 6) {
			res.insert(0, '0');
		}
		nextSeqNo++;
		if (nextSeqNo > 999999) {
			nextSeqNo = 0;
		}
		return res.toString();
	}
}
