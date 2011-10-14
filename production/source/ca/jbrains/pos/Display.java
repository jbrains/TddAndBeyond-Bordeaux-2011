package ca.jbrains.pos;

public class Display {
	private String text;

	public String getText() {
		return text;
	}

	public void displayPrice(String price) {
		this.text = price;
	}

	public void displayProductNotFoundMessage(String barcode) {
		this.text = "No product found for " + barcode;
	}
}