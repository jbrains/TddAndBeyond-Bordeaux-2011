package ca.jbrains.pos.controller;

import ca.jbrains.pos.controller.test.HandleTotalKeyTest.Model;
import ca.jbrains.pos.model.Catalog;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.CustomerViewableCashRegisterDisplay;


public class SaleController implements ScanBarcodeListener {
	private final CustomerViewableCashRegisterDisplay display;
	private final Catalog catalog;
	private final Model model;

	public SaleController(Catalog catalog, Model model, CustomerViewableCashRegisterDisplay display) {
		this.catalog = catalog;
		this.model = model;
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

	public void onTotal() {
		display.displayTotal(model.getSale());
	}
}