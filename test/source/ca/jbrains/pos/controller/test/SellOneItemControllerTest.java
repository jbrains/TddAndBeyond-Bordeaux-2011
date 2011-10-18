package ca.jbrains.pos.controller.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.controller.SaleController;
import ca.jbrains.pos.model.Catalog;
import ca.jbrains.pos.model.Model;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.CustomerViewableCashRegisterDisplay;

@RunWith(JMock.class)
public class SellOneItemControllerTest {
	private Mockery mockery = new Mockery();

	private Model model = mockery.mock(Model.class);
	
	@Test
	public void productFound() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final CustomerViewableCashRegisterDisplay display = mockery.mock(CustomerViewableCashRegisterDisplay.class);

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

		new SaleController(catalog, model, display).onBarcode("12345");
	}

	@Test
	public void productNotFound() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final CustomerViewableCashRegisterDisplay display = mockery.mock(CustomerViewableCashRegisterDisplay.class);

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

		new SaleController(catalog, model, display).onBarcode("12345");
	}

	@Test
	public void emptyBarcode() throws Exception {
		final Catalog catalog = mockery.mock(Catalog.class);
		final CustomerViewableCashRegisterDisplay display = mockery.mock(CustomerViewableCashRegisterDisplay.class);

		mockery.checking(new Expectations() {
			{
				ignoring(catalog);
				oneOf(display).displayEmptyBarcodeMessage();
			}
		});

		new SaleController(null, model, display).onBarcode("");
	}
}
