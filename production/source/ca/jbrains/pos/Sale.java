package ca.jbrains.pos;

public class Sale {
	private final Display display;
	private final Catalog catalog;
	private double priceOfLastScannedProduct;
	private boolean pstAppliesToLastScannedProduct;

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
			display.displayAmount(priceOfLastScannedProduct);
		} else {
			display.displayProductNotFoundMessage(barcode);
		}
	}

	public void onTotal() {
		display.displayAmount(costOfProduct(new Product(priceOfLastScannedProduct, pstAppliesToLastScannedProduct)));
	}

	public double costOfProduct(Product product) {
		return product.price + (product.price * 0.05d) + (product.pstApplies ? (product.price * 0.08d) : 0.0d);
	}
}