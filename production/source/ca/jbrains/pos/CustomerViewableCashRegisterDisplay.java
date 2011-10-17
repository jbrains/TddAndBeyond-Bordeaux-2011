package ca.jbrains.pos;


public interface CustomerViewableCashRegisterDisplay {
	void displayPrice(Price price);

	void displayProductNotFoundMessage(String barcode);

	void displayEmptyBarcodeMessage();
}