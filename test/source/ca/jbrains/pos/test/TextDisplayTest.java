package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.FrenchFormatAndCanvasDisplay;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.PrintWriterCanvas;
import ca.jbrains.util.Lines;

import com.google.common.collect.Lists;

@RunWith(JMock.class)
public class TextDisplayTest extends DisplayContract {
	private Mockery mockery = new Mockery();

	@Test
	public void displayNonNullPrice() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayPrice(Price.euro(12));
		assertEquals(Lists.newArrayList("EUR 12,00"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}

	@Override
	public void displayProductNotFoundMessageWithNonNullBarcode()
			throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayProductNotFoundMessage("99999");
		assertEquals(Lists.newArrayList("No product found for 99999"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}

	@Override
	public void displayEmptyBarcodeMessage() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayEmptyBarcodeMessage();
		assertEquals(Lists.newArrayList("Scanning error: empty barcode"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}

	private FrenchFormatAndCanvasDisplay createDisplayWritingTo(StringWriter canvas) {
		return new FrenchFormatAndCanvasDisplay(new PrintWriterCanvas(new PrintWriter(canvas,
				true)));
	}
}
