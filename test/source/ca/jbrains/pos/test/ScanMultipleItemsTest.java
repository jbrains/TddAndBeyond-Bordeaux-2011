package ca.jbrains.pos.test;

import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.SaleController;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@RunWith(JMock.class)
public class ScanMultipleItemsTest {
	private Mockery mockery = new Mockery();

	@Test
	public void allFound() throws Exception {
		final List<Price> pricesInOrder = Arrays.asList(Price.euro(10),
				Price.euro(25), Price.euro(40));

		final Catalog catalog = mockery.mock(Catalog.class);
		final Display display = mockery.mock(Display.class);

		mockery.checking(new Expectations() {
			{
				allowing(catalog).findPrice(with(any(String.class)));
				will(onConsecutiveCalls(Lists.transform(pricesInOrder,
						new Function<Price, Action>() {
							@Override
							public Action apply(Price each) {
								return returnValue(each);
							}
						}).toArray(new Action[0])));
			}
		});

		mockery.checking(new Expectations() {
			{
				for (Price price : pricesInOrder) {
					oneOf(display).displayPrice(price);
				}
			}
		});

		SaleController saleController = new SaleController(catalog, display);
		saleController.onBarcode("12345");
		saleController.onBarcode("23456");
		saleController.onBarcode("34567");
	}
}
