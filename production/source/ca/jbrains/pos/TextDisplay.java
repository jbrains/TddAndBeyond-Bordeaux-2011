package ca.jbrains.pos;

import java.io.PrintWriter;

public class TextDisplay implements Display {
	private final PrintWriter canvas;

	public TextDisplay(PrintWriter canvas) {
		this.canvas = canvas;
	}

	@Override
	public void displayPrice(Price price) {
		canvas.println(price.format());
	}

	@Override
	public void displayProductNotFoundMessage(String barcode) {
		canvas.println("No product found for " + barcode);
	}

	@Override
	public void displayEmptyBarcodeMessage() {
		canvas.println("Scanning error: empty barcode");
	}

}