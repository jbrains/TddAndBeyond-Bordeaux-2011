package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Product;
import ca.jbrains.pos.Sale;

public class SellOneItemTest {
	@Test
	public void productFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withProducts(Collections
				.<String, Product> singletonMap("12345",
						new Product(7.5d, true))));

		sale.onBarcode("12345");

		assertEquals("EUR 7,50", display.getText());
	}

	@Test
	public void anotherProductFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, new Catalog(
				Collections.<String, Product> singletonMap("23456",
						new Product(12.75d, true))));

		sale.onBarcode("23456");

		assertEquals("EUR 12,75", display.getText());
	}

	@Test
	public void productNotFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Catalog.withProducts(Collections
				.<String, Product> emptyMap()));

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
