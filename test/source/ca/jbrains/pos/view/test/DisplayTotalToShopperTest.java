package ca.jbrains.pos.view.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.model.NoSaleInProgressMessage;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.model.Sale;
import ca.jbrains.pos.view.Canvas;
import ca.jbrains.pos.view.CashRegisterView;
import ca.jbrains.pos.view.TextFormat;

@RunWith(JMock.class)
public class DisplayTotalToShopperTest {
	private final Mockery mockery = new Mockery();
	private final Canvas canvas = mockery.mock(Canvas.class);
	private final TextFormat textFormat = mockery.mock(TextFormat.class);
	private final CashRegisterView cashRegisterView = new CashRegisterView(
			textFormat, canvas);

	@Test
	public void completedSale() throws Exception {
		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(with(any(Price.class)));
				will(returnValue("formatted total"));

				oneOf(canvas).printMessage("formatted total");
			}
		});

		cashRegisterView.displayTotal(new Sale() {
			public Price getTotal() {
				return Price.euro(100);
			}
		});
	}

	@Test
	public void saleWithNoItemsYet() throws Exception {
		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(
						with(any(NoSaleInProgressMessage.class)));
				will(returnValue("no sale in progress message"));

				oneOf(canvas).printMessage("no sale in progress message");
			}
		});

		cashRegisterView.displayTotal(new Sale() {
			public Price getTotal() {
				return null;
			}
		});
	}
}
