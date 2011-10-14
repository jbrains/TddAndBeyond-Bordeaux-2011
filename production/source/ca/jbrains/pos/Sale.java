package ca.jbrains.pos;

public class Sale {
	private final Display display;
	private final Catalog catalog;
	private double priceOfLastScannedProduct;
	private boolean pstAppliesToLastScannedProduct;
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
			priceOfLastScannedProduct = catalog.findPrice(barcode);
			pstAppliesToLastScannedProduct = true;
			lastScannedProduct = new Product(priceOfLastScannedProduct, pstAppliesToLastScannedProduct);
			display.displayAmount(priceOfLastScannedProduct);
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	public void onTotal() {
		display.displayAmount(lastScannedProduct.cost());
	}
}