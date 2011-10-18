package ca.jbrains.pos.view;

import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.model.Sale;

public interface CustomerViewableCashRegisterDisplay {
	void displayPrice(Price price);

	void displayProductNotFoundMessage(String barcode);

	void displayEmptyBarcodeMessage();

	void displayTotal(Sale sale);
}