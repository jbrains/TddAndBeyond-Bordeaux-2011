package ca.jbrains.pos.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.SaleController;

@RunWith(JMock.class)
public class SellOneItemControllerTest {
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

		new SaleController(null, display).onBarcode("");
	}
}
