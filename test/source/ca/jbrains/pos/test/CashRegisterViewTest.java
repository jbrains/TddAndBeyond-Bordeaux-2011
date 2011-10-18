package ca.jbrains.pos.test;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.Canvas;
import ca.jbrains.pos.view.CashRegisterView;
import ca.jbrains.pos.view.TextFormat;

@RunWith(JMock.class)
public class CashRegisterViewTest {
	private Mockery mockery = new Mockery();

	@Test
	public void displayPrice() throws Exception {
		final TextFormat textFormat = mockery.mock(TextFormat.class);
		final Canvas canvas = mockery.mock(Canvas.class);

		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(Price.euro(12));
				will(returnValue("doesn't matter"));

				oneOf(canvas).printMessage("doesn't matter");
			}
		});

		new CashRegisterView(textFormat, canvas).displayPrice(Price.euro(12));
	}
}
