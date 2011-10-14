package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Sale;

public class SellOneItemTest {
	@Test
	public void productFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withFormattedPrices(Collections.<String, String> singletonMap("12345", "EUR 7,50")));

		sale.onBarcode("12345");

		assertEquals("EUR 7,50", display.getText());
	}

	@Test
	public void anotherProductFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display,
				Catalog.withFormattedPrices(Collections.<String, String> singletonMap("23456",
						"EUR 12,75")));

		sale.onBarcode("23456");

		assertEquals("EUR 12,75", display.getText());
	}

	@Test
	public void productNotFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withFormattedPrices(Collections.<String, String> emptyMap()));

		sale.onBarcode("99999");

		assertEquals("No product found for 99999", display.getText());
	}

	@Test
	public void emptyBarcode() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, null);

		sale.onBarcode("");
		assertEquals("Scanning error: empty barcode", display.getText());
	}
}
