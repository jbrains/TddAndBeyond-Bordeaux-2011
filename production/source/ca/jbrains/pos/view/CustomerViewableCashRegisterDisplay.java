package ca.jbrains.pos.view;

import ca.jbrains.pos.controller.test.HandleTotalKeyTest.Sale;
import ca.jbrains.pos.model.Price;


public interface CustomerViewableCashRegisterDisplay {
	void displayPrice(Price price);

	void displayProductNotFoundMessage(String barcode);

	void displayEmptyBarcodeMessage();

	void displayTotal(Sale sale);
}