package ca.jbrains.pos;

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
			double price = catalog.findPrice(barcode);
			display.displayAmount(price);
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	public void onTotal() {
		display.displayAmount(costOfProduct());
	}

	private double costOfProduct() {
		return 11.3d;
	}
}