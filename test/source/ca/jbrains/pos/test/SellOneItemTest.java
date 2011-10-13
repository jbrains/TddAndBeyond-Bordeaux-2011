package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SellOneItemTest {
	public static class Display {
		private String text;

		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}
	}

	public static class Sale {
		private Display display;
		private final Map<String, String> pricesByBarcode;

		public Sale(Display display, Map<String,String> pricesByBarcode) {
			this.display = display;
			this.pricesByBarcode = pricesByBarcode;
		}

		public void onBarcode(String barcode) {
			if (pricesByBarcode.containsKey(barcode))
				display.setText(pricesByBarcode.get(barcode));
			else
				display.setText("No product found for " + barcode);
		}
	}

	@Test
	public void productFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, new HashMap<String, String>() {
			{
				put("12345", "EUR 7,50");
			}
		});

		sale.onBarcode("12345");

		assertEquals("EUR 7,50", display.getText());
	}

	@Test
	public void anotherProductFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, new HashMap<String, String>() {
			{
				put("23456", "EUR 12,75");
			}
		});

		sale.onBarcode("23456");

		assertEquals("EUR 12,75", display.getText());
	}

	@Test
	public void yetAnotherProductFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, new HashMap<String, String>() {
			{
				put("34567", "EUR 29,01");
			}
		});

		sale.onBarcode("34567");

		assertEquals("EUR 29,01", display.getText());
	}

	@Test
	public void productNotFound() throws Exception {
		Display display = new Display();
		Sale sale = new Sale(display, Collections.<String, String> emptyMap());

		sale.onBarcode("99999");

		assertEquals("No product found for 99999", display.getText());
	}
}
