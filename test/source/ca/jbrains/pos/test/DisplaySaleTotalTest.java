package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Sale;

public class DisplaySaleTotalTest {
	@Test
	public void happyPath() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withUnformattedPrices(Collections
				.<String, Number> singletonMap("12345", 10.0d)));

		sale.onBarcode("12345");
		sale.onTotal();

		assertEquals("EUR 11,30", display.getText());
	}
}
