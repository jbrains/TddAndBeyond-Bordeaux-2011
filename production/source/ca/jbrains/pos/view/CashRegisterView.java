package ca.jbrains.pos.view;

import ca.jbrains.pos.model.NoSaleInProgressMessage;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.model.Sale;

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
		Price total = sale.getTotal();
		if (total == null)
			canvas.printMessage(textFormat
					.format(new NoSaleInProgressMessage()));
		else
			canvas.printMessage(textFormat.format(total));
	}
}