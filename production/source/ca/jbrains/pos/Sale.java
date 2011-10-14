package ca.jbrains.pos;

import java.util.Locale;

public class Sale {
	private final Display display;
	private final Catalog catalog;

	public Sale(Display display, Catalog catalog) {
		this.display = display;
		this.catalog = catalog;
	}

	public void onBarcode(String barcode) {
		if ("".equals(barcode)) {
			display.displayEmptyBarcodeMessage();
			return;
		}

		if (catalog.hasBarcode(barcode)) {
			display.displayPrice(catalog.findPrice(barcode));
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	public void onTotal() {
		display.displayTotal(formatAmount(costOfProduct()));
	}

	private double costOfProduct() {
		return 11.3d;
	}

	public static String formatAmount(double amount) {
		return String.format(Locale.FRANCE, "EUR %.2f", amount);
	}
}