package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Product;
import ca.jbrains.pos.Sale;

public class DisplaySaleTotalTest {
	@Test
	public void happyPath() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withProducts(Collections
				.<String, Product> singletonMap("12345", new Product(10.0d,
						true))));
		sale.onBarcode("12345");

		sale.onTotal();

		assertEquals("EUR 11,30", display.getText());
	}
}
