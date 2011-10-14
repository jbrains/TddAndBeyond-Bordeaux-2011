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
			displayEmptyBarcodeMessage();
			return;
		}
		
		if (catalog.hasBarcode(barcode)) {
			display.displayPrice(catalog.findPrice(barcode));
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	private void displayEmptyBarcodeMessage() {
		display.text = "Scanning error: empty barcode";
	}
}