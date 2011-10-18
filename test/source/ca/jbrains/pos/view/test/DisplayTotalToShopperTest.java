package ca.jbrains.pos.view.test;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import org.junit.Test;

import ca.jbrains.pos.controller.test.HandleTotalKeyTest.Sale;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.Canvas;
import ca.jbrains.pos.view.CashRegisterView;
import ca.jbrains.pos.view.FrenchTextFormat;

public class DisplayTotalToShopperTest {
	public static class StringWriterCanvas implements Canvas {
		private final StringWriter output;

		public StringWriterCanvas(StringWriter output) {
			this.output = output;
		}

		@Override
		public void printMessage(String message) {
			output.append(message);
		}

	}

	@Test
	public void completedSale() throws Exception {
		StringWriter output = new StringWriter();
		new CashRegisterView(new FrenchTextFormat(), new StringWriterCanvas(
				output)).displayTotal(new Sale() {
			public Price getTotal() {
				return Price.euro(100);
			}
		});

		assertEquals("EUR 100,00", output.toString());
	}
}
