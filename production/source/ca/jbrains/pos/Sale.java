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
			lastScannedProduct = findProductByBarcode(barcode);
			display.displayAmount(lastScannedProduct.price);
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	private Product findProductByBarcode(String barcode) {
		double priceOfLastScannedProduct = catalog.findPrice(barcode);
		boolean pstAppliesToLastScannedProduct = true;
		return new Product(priceOfLastScannedProduct, pstAppliesToLastScannedProduct);
	}

	public void onTotal() {
		display.displayAmount(lastScannedProduct.cost());
	}
}