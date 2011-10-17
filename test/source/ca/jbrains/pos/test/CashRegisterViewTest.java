package ca.jbrains.pos.test;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.Canvas;
import ca.jbrains.pos.CashRegisterView;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.TextFormat;

@RunWith(JMock.class)
public class CashRegisterViewTest {
	private Mockery mockery = new Mockery();

	@Test
	public void displayPrice() throws Exception {
		final TextFormat textFormat = mockery.mock(TextFormat.class);
		final Canvas canvas = mockery.mock(Canvas.class);

		mockery.checking(new Expectations() {
			{
				oneOf(textFormat).format(Price.euro(12));
				will(returnValue("12Û"));

				oneOf(canvas).printMessage("12Û");
			}
		});

		new CashRegisterView(textFormat, canvas).displayPrice(Price.euro(12));
	}
}
