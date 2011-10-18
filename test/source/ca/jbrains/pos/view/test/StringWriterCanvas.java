package ca.jbrains.pos.view.test;

import java.io.StringWriter;

import ca.jbrains.pos.view.Canvas;

public class StringWriterCanvas implements Canvas {
	private final StringWriter output;

	public StringWriterCanvas(StringWriter output) {
		this.output = output;
	}

	@Override
	public void printMessage(String message) {
		output.append(message);
	}

}