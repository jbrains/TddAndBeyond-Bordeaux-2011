package ca.jbrains.pos;

import java.io.PrintWriter;

public final class PrintWriterCanvas implements Canvas {
	private final PrintWriter printWriter;

	public PrintWriterCanvas(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	public void printMessage(String message) {
		printWriter.println(message);
	}
}