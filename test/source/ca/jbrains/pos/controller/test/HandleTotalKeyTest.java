package ca.jbrains.pos.controller.test;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.controller.SaleController;
import ca.jbrains.pos.model.Model;
import ca.jbrains.pos.model.Sale;
import ca.jbrains.pos.view.CustomerViewableCashRegisterDisplay;

@RunWith(JMock.class)
public class HandleTotalKeyTest {
	private final Mockery mockery = new Mockery();

	@Test
	public void displaysSaleTotal() throws Exception {
		final Model model = mockery.mock(Model.class);
		final CustomerViewableCashRegisterDisplay customerViewableCashRegisterDisplay = mockery
				.mock(CustomerViewableCashRegisterDisplay.class);

		final Sale sale = new Sale();

		mockery.checking(new Expectations() {
			{
				allowing(model).getSale();
				will(returnValue(sale));

				oneOf(customerViewableCashRegisterDisplay).displayTotal(sale);
			}
		});

		new SaleController(null, model, customerViewableCashRegisterDisplay)
				.onTotal();
	}
}
