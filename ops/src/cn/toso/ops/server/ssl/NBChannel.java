package cn.toso.ops.server.ssl;

/* nbChannel.java - Source code to accompany the article
 * "The Easy Way to Non-blocked Sockets".
 *
 * Article copyright (C) 2003 by Kenneth Ballard.
 * First published by IBM developerWorks, 2003.
 *
 * Source code copyright (C) 2003 by Kenneth Ballard.
 * Use freely as you wish, acknowledgements not required.
 * Source code provided "as-is" without warranty of any kind.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class NBChannel implements ByteChannel {
	Socket s;

	InputStream is;

	OutputStream os;

	ReadableByteChannel rbc;

	WritableByteChannel wbc;

	public NBChannel(Socket socket) throws IOException {
		s = socket;
		is = s.getInputStream();
		os = s.getOutputStream();
		rbc = Channels.newChannel(is);
		wbc = Channels.newChannel(os);
	}

	public int read(ByteBuffer dst) throws IOException {
		/* If there's no space available or if no data is available, return */

		int y = checkConnection();
		if (y < 0)
			return y+1;
		dst.put((byte) y);
		// dst.putChar((char) y);
		return rbc.read(dst) + 1;
	}

	/* Checks for a connection by attempting to read only one byte */

	protected int checkConnection() throws IOException {
		/* Store the current timeout */

		int y = s.getSoTimeout();
		int p = -1;

		/* Set a new timeout to a very short amount of time */

		s.setSoTimeout(25);

		/*
		 * Attempt to read, catching the exception if it fails. If the
		 * connection times out, though, the connection is still open, it just
		 * doesn't have anything to read.
		 */

		try {
			p = is.read();
		} catch (SocketTimeoutException e) {
			p = -1;
		} catch (IOException e) {
			// e.printStackTrace();
			p = -2;
		}

		/* Reset the timeout */

		if (p != -2)
			s.setSoTimeout(y);
		return p;
	}

	public int write(ByteBuffer src) throws IOException {
		int x, y = s.getSendBufferSize(), z = 0;
		int expectedWrite;
		byte[] p = src.array();
		ByteBuffer buf;

		if (src.remaining() == 0)
			return 0;

		/* Allocate a temporary buffer for writing the data to the channel */

		buf = ByteBuffer.allocateDirect(y);
		os.flush();

		for (x = 0; x < p.length; x += y) {
			if (p.length - x < y) {
				buf.put(p, x, p.length - x);
				expectedWrite = p.length - x;
			} else {
				buf.put(p, x, y);
				expectedWrite = y;
			}

			buf.flip();
			z = wbc.write(buf);
			os.flush();
			if (z < expectedWrite)
				break;
			buf.clear();
		}

		if (x > p.length)
			return p.length;
		else
			return x + z;
	}

	public void close() {
		try {
			s.close();
		} catch (Exception e) {
		}
	}

	/*
	 * Thrown in to avoid the "should be declared abstract" messages. Will
	 * always return false, though.
	 */

	public boolean isOpen() {
		return s.isConnected();
	}
}
