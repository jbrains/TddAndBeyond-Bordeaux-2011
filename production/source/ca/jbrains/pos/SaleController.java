package ca.jbrains.pos;


public class SaleController implements ScanBarcodeListener {
	private final CustomerViewableCashRegisterDisplay display;
	private final Catalog catalog;

	public SaleController(Catalog catalog, CustomerViewableCashRegisterDisplay display) {
		this.catalog = catalog;
		this.display = display;
	}

	public void onBarcode(String barcode) {
		if ("".equals(barcode)) {
			display.displayEmptyBarcodeMessage();
			return;
		}

		Price price = catalog.findPrice(barcode);
		if (price == null)
			display.displayProductNotFoundMessage(barcode);
		else
			display.displayPrice(price);
	}
}