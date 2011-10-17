package ca.jbrains.pos;

public class Sale {
	private final Display display;
	private final Catalog catalog;
	private Product lastScannedProduct;

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
			lastScannedProduct = catalog.findProduct(barcode);
			display.displayAmount(lastScannedProduct.getPrice());
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	public void onTotal() {
		display.displayAmount(lastScannedProduct.cost());
	}
}