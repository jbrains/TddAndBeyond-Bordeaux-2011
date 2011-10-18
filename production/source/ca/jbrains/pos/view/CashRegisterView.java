package ca.jbrains.pos.view;

import ca.jbrains.pos.controller.test.HandleTotalKeyTest.Sale;
import ca.jbrains.pos.model.Price;

public class CashRegisterView implements CustomerViewableCashRegisterDisplay {
	private final TextFormat textFormat;
	private final Canvas canvas;

	public CashRegisterView(TextFormat textFormat, Canvas canvas) {
		this.textFormat = textFormat;
		this.canvas = canvas;
	}

	public void displayPrice(Price price) {
		canvas.printMessage(textFormat.format(price));
	}

	@Override
	public void displayProductNotFoundMessage(String barcode) {
		canvas.printMessage(textFormat.format(new ProductNotFoundMessage(
				barcode)));
	}

	@Override
	public void displayEmptyBarcodeMessage() {
		canvas.printMessage(textFormat.format(new EmptyBarcodeMessage()));
	}

	public void displayTotal(Sale sale) {
		canvas.printMessage(textFormat.format(sale.getTotal()));
	}

}