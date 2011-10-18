package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import ca.jbrains.pos.view.PrintWriterCanvas;

public class PrintWriterCanvasTest {
	@Test
	public void printsMessage() throws Exception {
		StringWriter stringWriter = new StringWriter();
		PrintWriterCanvas printWriterCanvas = new PrintWriterCanvas(
				new PrintWriter(stringWriter));

		printWriterCanvas.printMessage("Hello, world!");

		assertEquals("Hello, world!\n", stringWriter.toString());
	}
}
