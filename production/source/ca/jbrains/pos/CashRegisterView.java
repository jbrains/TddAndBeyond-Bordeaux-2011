package ca.jbrains.pos;


public class CashRegisterView implements Display {
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

}