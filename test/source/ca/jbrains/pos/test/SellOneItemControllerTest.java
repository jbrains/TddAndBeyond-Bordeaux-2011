package ca.jbrains.pos.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class SellOneItemControllerTest {
	public static class SaleController {
		private final Display display;
		private final Catalog catalog;

		public SaleController(Catalog catalog, Display display) {
			this.catalog = catalog;
			this.display = display;
		}

		public void onBarcode(String barcode) {
			if ("".equals(barcode)) {
				display.displayEmptyBarcodeMessage();
				return;
			}

			Price price = catalog.findPrice(barcode);
			if (price == null)
				display.displayProductNotFoundMessage(barcode);
			else
				display.displayPrice(price);
		}
	}

	public interface Display {
		void displayPrice(Price price);

		void displayProductNotFoundMessage(String barcode);

		void displayEmptyBarcodeMessage();
	}

	public static class Price {
		private final int valueInEuro;

		public Price(int valueInEuro) {
			this.valueInEuro = valueInEuro;
		}

		public static Price euro(int valueInEuro) {
			return new Price(valueInEuro);
		}

		@Override
		public boolean equals(Object other) {
			if (other instanceof Price) {
				Price that = (Price) other;
				return this.valueInEuro == that.valueInEuro;
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return valueInEuro;
		}

		@Override
		public String toString() {
			return "a Price";
		}
	}

	public interface Catalog {
		Price findPrice(String barcode);
	}

	private Mockery mockery = new Mockery();

	@Test
	public void productFound() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final Display display = mockery.mock(Display.class);

		mockery.checking(new Expectations() {
			{
				allowing(catalog).findPrice("12345");
				will(returnValue(Price.euro(12)));
			}
		});

		mockery.checking(new Expectations() {
			{
				oneOf(display).displayPrice(Price.euro(12));
			}
		});

		new SaleController(catalog, display).onBarcode("12345");
	}

	@Test
	public void productNotFound() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final Display display = mockery.mock(Display.class);

		mockery.checking(new Expectations() {
			{
				allowing(catalog).findPrice("12345");
				will(returnValue(null));
			}
		});

		mockery.checking(new Expectations() {
			{
				oneOf(display).displayProductNotFoundMessage("12345");
			}
		});

		new SaleController(catalog, display).onBarcode("12345");
	}

	@Test
	public void emptyBarcode() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final Display display = mockery.mock(Display.class);

		mockery.checking(new Expectations() {
			{
				ignoring(catalog);
				oneOf(display).displayEmptyBarcodeMessage();
			}
		});

		new SaleController(catalog, display).onBarcode("");
	}
}
