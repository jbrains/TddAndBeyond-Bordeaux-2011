package ca.jbrains.pos.view.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.Canvas;
import ca.jbrains.pos.view.CashRegisterView;
import ca.jbrains.pos.view.CustomerViewableCashRegisterDisplay;
import ca.jbrains.pos.view.EmptyBarcodeMessage;
import ca.jbrains.pos.view.ProductNotFoundMessage;
import ca.jbrains.pos.view.TextFormat;

import static org.hamcrest.Matchers.*;

@RunWith(JMock.class)
public class TextDisplayTest extends DisplayContract {
	private Mockery mockery = new Mockery();
	private TextFormat textFormat;
	private Canvas canvas;
	private CustomerViewableCashRegisterDisplay display;

	@Before
	public void setUp() {
		textFormat = mockery.mock(TextFormat.class);
		canvas = mockery.mock(Canvas.class);
		display = new CashRegisterView(textFormat, canvas);
	}

	@Test
	public void displayNonNullPrice() throws Exception {
		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(with(not(nullValue(Price.class))));
				will(returnValue("formatted price"));

				oneOf(canvas).printMessage(with("formatted price"));
			}
		});

		display.displayPrice(Price.euro(12));
	}

	@Override
	public void displayProductNotFoundMessageWithNonNullBarcode()
			throws Exception {

		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(
						with(any(ProductNotFoundMessage.class)));
				will(returnValue("product not found message"));

				oneOf(canvas).printMessage(with("product not found message"));
			}
		});

		display.displayProductNotFoundMessage("irrelevant barcode");
	}

	@Override
	public void displayEmptyBarcodeMessage() throws Exception {
		mockery.checking(new Expectations() {
			{
				allowing(textFormat).format(
						with(any(EmptyBarcodeMessage.class)));
				will(returnValue("empty barcode message"));

				oneOf(canvas).printMessage(with("empty barcode message"));
			}
		});

		display.displayEmptyBarcodeMessage();
	}
}
