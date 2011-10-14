package ca.jbrains.pos;

import java.util.Locale;

public class Display {
	private String text;

	public String getText() {
		return text;
	}

	public void displayProductNotFoundMessage(String barcode) {
		this.text = "No product found for " + barcode;
	}

	public void displayEmptyBarcodeMessage() {
		this.text = "Scanning error: empty barcode";
	}

	public void displayTotal(String total) {
		this.text = total;
	}

	public void displayAmount(double amount) {
		this.text = formatAmount(amount);
	}

	public static String formatAmount(double amount) {
		return String.format(Locale.FRANCE, "EUR %.2f", amount);
	}
}