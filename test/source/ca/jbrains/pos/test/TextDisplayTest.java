package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.TextDisplay;


public class TextDisplayTest extends DisplayContract {
	@Test
	public void displayNonNullPrice() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayPrice(Price.euro(12));
		assertEquals("EUR 12,00\n", canvas.toString());
	}

	private TextDisplay createDisplayWritingTo(StringWriter canvas) {
		return new TextDisplay(new PrintWriter(canvas, true));
	}

	@Override
	public void displayProductNotFoundMessageWithNonNullBarcode()
			throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayProductNotFoundMessage("99999");
		assertEquals("No product found for 99999\n", canvas.toString());
	}

	@Override
	public void displayEmptyBarcodeMessage() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayEmptyBarcodeMessage();
		assertEquals("Scanning error: empty barcode\n", canvas.toString());
	}
}
