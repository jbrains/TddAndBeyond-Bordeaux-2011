package ca.jbrains.pos;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCanvas implements Canvas {

	@Override
	public void printMessage(String message) {
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			socket = new Socket("localhost", 5357);
			outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.println(message);
			printWriter.flush();
			outputStream.flush();
		} catch (Exception wrapped) {
			throw new RuntimeException(wrapped);
		} finally {
			if (outputStream != null)
				try {
					outputStream.close();
				} catch (IOException wrapped) {
					throw new RuntimeException(wrapped);
				}
			if (socket != null)
				try {
					socket.close();
				} catch (IOException wrapped) {
					throw new RuntimeException(wrapped);
				}
		}

	}

}
