package ca.jbrains.pos.view;

import ca.jbrains.pos.model.Price;

public class FrenchFormatAndCanvasDisplay implements CustomerViewableCashRegisterDisplay {
	private Canvas canvas;

	public FrenchFormatAndCanvasDisplay(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void displayPrice(Price price) {
		canvas.printMessage(price.format());
	}

	@Override
	public void displayProductNotFoundMessage(String barcode) {
		canvas.printMessage("No product found for " + barcode);
	}

	@Override
	public void displayEmptyBarcodeMessage() {
		canvas.printMessage("Scanning error: empty barcode");
	}

}